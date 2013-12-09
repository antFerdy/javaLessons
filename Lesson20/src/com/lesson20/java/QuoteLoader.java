package com.lesson20.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class QuoteLoader implements Runnable {
	String marketNews = null;
	Updatable dc = null; 
	
	//Конструктор для новостного фильтра
	public QuoteLoader(Updatable upd) {
		dc = upd;
		
	}
	
	public void loadNews() {
		
		//Загружаем новости из инета
		try {
			URL url = new URL("http://quote.yahoo.com/d/quotes.csv?s=AAPL&f=sl1d1t1c1ohgv&e=.csv");
			URLConnection conn = url.openConnection();
			BufferedReader buff= new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			while(true) {
			String currentLine = buff.readLine();
			if(currentLine != null) {
				marketNews = currentLine;
			} 
				else {
					break;
				}
			
			}
			
			
		} catch (MalformedURLException e) {
			// Ссылка не найдена
			e.printStackTrace();
		} catch (IOException e) {
			// Ошибка при открытии соединения
			e.printStackTrace();
		}
		/*System.out.println(news+"\n");
		StringTokenizer token = new StringTokenizer(news,"<>");
		token.nextToken();
		System.out.println(token.nextToken());*/
	}
	
	@Override
	public void run() {
		this.loadNews();
		dc.SetData(marketNews);
		synchronized (dc) {
			dc.notify();
		}
		
		
	} 
	
	
	
	
}
