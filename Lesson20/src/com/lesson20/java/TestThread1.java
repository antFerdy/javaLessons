package com.lesson20.java;

public class TestThread1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*MarketNews1 mn1 = new MarketNews1();
		Thread mn = new Thread(mn1);
		mn.start();*/
		
		new Thread(new MarketNews1()).start();
		
		
		StockPortfolio1 sp1 = new StockPortfolio1();
		Thread sp = new Thread(sp1);
		sp.start();
		
		System.out.println("Your thread is over");
		
	}

}
