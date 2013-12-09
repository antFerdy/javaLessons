package com.lesson20.java;

public class StockPortfolio extends Thread {
	StockPortfolio(String ThreadName) {
		super(ThreadName);
	}
	
	public void run() {
		System.out.println("You have 5000 APPL, 3000 AMZN, 9000 LNKD, 4000 NFLX");
		
	}
	
	
}
