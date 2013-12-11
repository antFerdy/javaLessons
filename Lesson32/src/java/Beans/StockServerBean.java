/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.jms.*;
import javax.naming.*;

/**
 *
 * @author zhumagulov_r
 */
@Stateless
public class StockServerBean implements TimerSessionBeanLocal {
    //Creating Price String and ArrayList with tickers
    private String price = null;
    private ArrayList<String> tickers = null;
    //Connection Factory and Connection references
    ConnectionFactory factory = null;
    Connection conn = null;
    //Session 
    Session session = null;
    
    
    //Constructor of StockServerBean with new Quotes
    public StockServerBean () {
        tickers = new ArrayList<String>();
        
        //Add the tickers
        tickers.add("AAPL");
        tickers.add("AMZN");
        tickers.add("MNST");
        tickers.add("FFIV");
        tickers.add("GMCR");
        tickers.add("TSLA");
        tickers.add("DDD");        
    }
    
    
    //Generating the price quotes if the symbols meets in tickers container
    @Schedule(minute = "*", second = "0", dayOfMonth = "*", month = "*", year = "*", hour = "9:30-17", dayOfWeek = "Mon-Fri")
    @Override
    public void getQuotes(String symbol) {
        if(tickers.contains(symbol.toUpperCase())) {
            price = new Double(Math.random()*100).toString();
            sendMessage();
        }
    }

    //Create method that will send price quotes to Queue
    public void sendMessage () {
        try {
            //Finder via JNDI
            Context jndiContext = new InitialContext();
            
            //Look up factory and connection to queue
            factory = (ConnectionFactory) jndiContext.lookup("MyTestConnectionFactory");
            conn = factory.createConnection();
            
            //Create the Queue via jndi lookup
            Queue quotesQueue = (Queue) jndiContext.lookup("MyJMSTestQueue");
            
            //Create the Session from connection
            session = conn.createSession(false, Session.DUPS_OK_ACKNOWLEDGE);
            
            //Create message producer
            MessageProducer producer = session.createProducer(quotesQueue);
            
            //Create text message with price
            TextMessage msg = session.createTextMessage();
            msg.setText(price);
            
            //Send message to queue, close producer 
            producer.send(msg);
            producer.close();
            System.out.println("The message was sended");
        } catch (NamingException ex) {
            Logger.getLogger(StockServerBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JMSException e ) {
            Logger.getLogger(StockServerBean.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                //Close session and connection
                session.close();
                conn.close();
            } catch (JMSException ex) {
                Logger.getLogger(StockServerBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
        
    }
}
