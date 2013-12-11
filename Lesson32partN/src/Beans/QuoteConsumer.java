package Beans;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: QuoteConsumer
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"), @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "MyJMSTestQueue")
		}, 
		mappedName = "MyJMSTestQueue")
public class QuoteConsumer implements MessageListener {

    /**
     * Default constructor. 
     */
    public QuoteConsumer() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
    	   String textMsg = null;
           if (message instanceof TextMessage) {
                try {
                    textMsg = ((TextMessage) message).getText();
                    System.out.println("Your received message with text: " + textMsg);
                } catch (JMSException ex) {
                    Logger.getLogger(QuoteConsumer.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
    }

}
