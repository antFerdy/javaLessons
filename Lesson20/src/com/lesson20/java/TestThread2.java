package com.lesson20.java;

public class TestThread2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MarketNews2 mn2 = new MarketNews2();
		mn2.start();
		
		StockPortfolio2 sp2 = new StockPortfolio2();
		sp2.start();
		
		Thread t = Thread.currentThread();
		 
		synchronized (t) {
			try{
				   
			     t.wait(10000);   
			   } catch (InterruptedException e){  
				   
			   }
		}

		 	System.out.println("The threads are over");	
		}
		
		
		
	}


