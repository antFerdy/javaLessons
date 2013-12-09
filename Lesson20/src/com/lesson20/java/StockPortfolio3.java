package com.lesson20.java;

public class StockPortfolio3 extends Thread {
	private volatile Thread stopMe = Thread.currentThread();
	
	public void stopMe() {
		stopMe = null;
	}
	
	
	public void run() {
		while(stopMe == Thread.currentThread()) {
			for(int i = 0; i<10; i++) {
				try {
					Thread.sleep(700);
					System.out.println("You earned 300K in thise month. Do you want to recieve it ?");
					
				} catch (InterruptedException e) {
					System.out.println("Oops... Something happend");
					e.printStackTrace();
				}
					
			}
			
			
			
		}

	}

}
