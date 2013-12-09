package com.practicaljava.lesson32.ejb;

import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.jms.*;


import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

//������� ��������� ��� ��� ���������
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
	
	//������� ���������� ���������� ��������� ���������
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
			/*������ ������� �� ����� ���������� � ������������ ���������
			 * ��������������. � ��������� ����� ������� �������� url ��� ��������
			 */
			factory = new com.sun.messaging.ConnectionFactory();
			factory.setProperty(ConnectionConfiguration.imqAddressList,"mq://localhost:7676");
			
			/*
			 * ������ ���������� ��������� ����� � ������ 
			 * �������� ����������
			 */
			/*
			 * connection = factory.createQueueConnection("admin","admin");
			 * 
			 */
				TopicConnection connection = factory.createTopicConnection("admin", "admin");
				connection.start();
			
			/*
			 * ������� ������ � �����������������
			 */
			session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			
			
			Topic myTopic = session.createTopic("MyTopic");
			TopicPublisher publisher = session.createPublisher(myTopic);
			
			/*
			 * ������ ��������� ��������� �� ������
			 * ��������� ���
			 * �������� ���������
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
