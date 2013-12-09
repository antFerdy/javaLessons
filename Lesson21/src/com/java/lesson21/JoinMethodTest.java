package com.java.lesson21;

public class JoinMethodTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MarketNews mn = new MarketNews();
		Portfolio portf = new Portfolio();
		
		mn.start();
		portf.start();
		
		try{
			portf.join();
			mn.join();
			
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("You earned 30k non-covered profit");

	}

}
