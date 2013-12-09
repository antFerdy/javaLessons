package com.lesson20.java;


public class MarketNews extends Thread {
	
	MarketNews(String name) {
		super(name);

	}
	
	public void run() {
		System.out.println("The stock market is improving!");
		
	}
}
