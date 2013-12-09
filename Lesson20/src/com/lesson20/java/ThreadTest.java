package com.lesson20.java;

public class ThreadTest {

	
	public static void main(String[] args) {
		MarketNews mn = new MarketNews("news");
		mn.start();
		
		StockPortfolio sp = new StockPortfolio("My Watchlist");
		sp.start();
		
		System.out.println("The threads is finished");
	}

}
