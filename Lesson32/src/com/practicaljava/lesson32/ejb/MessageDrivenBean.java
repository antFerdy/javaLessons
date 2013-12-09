package com.practicaljava.lesson32.ejb;


import javax.ejb.*;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: MessageDrivenBean
 */
@MessageDriven(
		activationConfig = { 
				@ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
				@ActivationConfigProperty(
				propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
		})
public class MessageDrivenBean implements MessageListener {
	private String text = null;
	
    public MessageDrivenBean() {
    }
	
    
    public void onMessage(Message message) {
    	
    	try {
    		if(message instanceof TextMessage) {
        		text = ((TextMessage) message).getText();
        		System.out.println(text);
        	}
    	} catch (JMSException e) {
    		System.out.println("Error" + e.getMessage());
    	}
    }
    
    public String getText() {
    	return text;
    }

}
