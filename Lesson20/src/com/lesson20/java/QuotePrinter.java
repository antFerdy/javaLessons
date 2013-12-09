package com.lesson20.java;

import java.util.StringTokenizer;

//Данный класс принтует биржевые новости.
public class QuotePrinter implements Updatable{
	String stockQuotes = null; 
	String stockNews = null; 
	
	public static void main(String[] args) {
		// Вызываем конструктор класса который загружает инфу из инета
		QuotePrinter dc = new QuotePrinter();
		QuoteLoader ps = new QuoteLoader(dc);
		Updatable news = new NewsLoader(dc);
		
		
		Thread a = new Thread(ps,"Load thread");
		a.start();
		
		
		//Ожидаем пока пусси загрузит новости и передаст сюда.
		synchronized (dc) {
			try {
				dc.wait();
			} catch (InterruptedException e) {
				// Ошибка при ожидании
				e.printStackTrace();
			}
		}
		
		StringTokenizer tokenizer = new StringTokenizer(dc.stockQuotes,",");
		System.out.println("Tiker: " +tokenizer.nextToken());
		System.out.println("Price: " +tokenizer.nextToken());
		System.out.println(dc.stockNews);
	}
	

	public void SetData(String string) {
		this.stockQuotes = string;
		
	}


	public void SetNewsData(String string) {
		this.stockNews = string;
		
	}
	
	

}
