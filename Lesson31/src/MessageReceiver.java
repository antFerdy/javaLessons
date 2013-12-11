import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.Queue;



public class MessageReceiver implements MessageListener {
	ConnectionFactory factory = null;
	javax.jms.Connection conn = null;
	Session session;
	MessageConsumer consumer = null; 
	
	public MessageReceiver() {
		try {
			Context ctx = new InitialContext();
			
			factory = (ConnectionFactory) ctx.lookup("MyTestConnectionFactory");
			Queue ioQueue = (Queue) ctx.lookup("MyJMSTestQueue");
			conn = factory.createConnection();
			
			conn.start();
			
			session = conn.createSession();
			
			consumer = session.createConsumer(ioQueue);
			consumer.setMessageListener(this);
			
		} catch (NamingException | JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MessageReceiver();
	}

	@Override
	public void onMessage(Message arg0) {
		String msgText;
		try {
			if(arg0 instanceof TextMessage) {
				msgText = ((TextMessage) arg0).getText();
				System.out.println("The text of message is " + msgText);
			}
		} catch(JMSException e) {
			System.out.println("Error " + e.getMessage());
		}
	}
}
