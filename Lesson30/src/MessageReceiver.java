import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.QueueConnection;
import javax.jms.Session;
import javax.jms.TextMessage;
import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.Queue;


public class MessageReceiver implements MessageListener{
	Session session = null;
	ConnectionFactory factory = null;
	QueueConnection connection = null;
	MessageConsumer consumer = null; 
	
	public MessageReceiver() {
	// TODO Auto-generated constructor stub
		try {
			//Creating factory 
			factory = new com.sun.messaging.ConnectionFactory();
			factory.setProperty(ConnectionConfiguration.imqAddressList, "mq://localhost:7676");
			
			//Creating queue connection 
			connection = factory.createQueueConnection("admin","admin");
			connection.start();
			
			//Create the session
			session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//Create the queue
			Queue ioQueue = new Queue("Queue");
			
			consumer = session.createConsumer(ioQueue);
			consumer.setMessageListener(this);
			
			System.out.println("Listening the query");
			Thread.sleep(100000);	
			
		} catch(Exception e) {
			System.out.println("Error " + e.getMessage());
		}
		
		finally {
				try {
					session.close();
					consumer.close();
					connection.close();
				} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		new MessageReceiver();
	}

	@Override
	public void onMessage(Message arg0) {
		//Processing received messages
		String msgText;
		try {
			if(arg0 instanceof TextMessage) {
				msgText = ((TextMessage)arg0).getText();
				System.out.println("Got from queue: " + msgText);
			}
		} catch(JMSException e) {
			System.out.println("Error while consuming a message: " + e.getMessage());
		}
		
	}

}
