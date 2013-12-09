package com.practicaljava.lesson32.ejb;

import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.jms.*;


import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

//Создаем локальный бин без состояния
@Stateless
@LocalBean
public class StockServerBean {
	ArrayList<String> tickers = new ArrayList<String>();
	String price = null;
	ConnectionFactory factory;
	QueueConnection connection = null;
	TopicSession session = null;
	
	
	public StockServerBean() {
		tickers.add("AAPL");
		tickers.add("AMZN");
		tickers.add("PCLN");
		tickers.add("FFIV");
		tickers.add("VMW");
		tickers.add("FCX");
		
	}
	
	//Создаем расписание постоянных получений котировок
	@Schedule(second="*",minute="*",hour="9:30-16:00",dayOfWeek="Mon-Fri")
	public void shareQuotes(String symbol) {
		if(tickers.contains(symbol)) {
			price = (new Double (Math.random()*100)).toString();
			sendMessage(price);
		}
		
		else {
			price = "N/A";
			sendMessage(price);
		}

	}
	
	public void sendMessage(String quotes) {
		try {
			/*Создаю фактори из нашей библиотеки и устанавливаю параметры
			 * месседжброкера. В параметре можно указать множесто url для брокеров
			 */
			factory = new com.sun.messaging.ConnectionFactory();
			factory.setProperty(ConnectionConfiguration.imqAddressList,"mq://localhost:7676");
			
			/*
			 * Создаю соединение отправляя логин и пароль 
			 * запускаю соединение
			 */
			/*
			 * connection = factory.createQueueConnection("admin","admin");
			 * 
			 */
				TopicConnection connection = factory.createTopicConnection("admin", "admin");
				connection.start();
			
			/*
			 * Создаем сессию с автоуведомлениями
			 */
			session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			
			
			Topic myTopic = session.createTopic("MyTopic");
			TopicPublisher publisher = session.createPublisher(myTopic);
			
			/*
			 * Создаю текстовое сообщение из сессии
			 * отправляю его
			 * закрываю продюсера
			 */
			TextMessage out = session.createTextMessage(quotes);
			publisher.send(out);
			publisher.close();
			
			
			System.out.println("The message was succesfully sended");
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				session.close();
				
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
	
}
