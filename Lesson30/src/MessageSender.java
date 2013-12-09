import javax.jms.*;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.ConnectionConfiguration;

public class MessageSender {
	
	public static void main(String[] args) {
		ConnectionFactory factory;
		QueueConnection connection = null;
		Session session = null;
		
		try {
			//Create factory of connection 
			factory = new com.sun.messaging.ConnectionFactory();
			factory.setProperty(ConnectionConfiguration.imqAddressList, "mq://localhost:7676");
			
			//Create connection
			connection = factory.createQueueConnection("admin","admin");
			connection.start();
			
			//Create session
			session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//Create Queue and message producer
			Queue ioQueue = session.createQueue("Queue");
			MessageProducer producer = session.createProducer(ioQueue);
			
			//Sending message
			TextMessage outMsg = session.createTextMessage("IBM 200 MKT");
			producer.send(outMsg);
			producer.close();
			
			System.out.println("Your order was accepted and executed");
		}
		
		catch(JMSException e) {
			System.out.println("Error " + e.getMessage());
		}
		
		finally {
			try{
				session.close();
				connection.close();
			}
			
			catch(Exception e) { 
				System.out.println("Error " + e.getMessage());
			}
			
			
		}
		
		
		
		
		
	}

}
