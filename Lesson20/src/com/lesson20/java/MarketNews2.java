package com.lesson20.java;

public class MarketNews2 extends Thread {
	public void run() {
		try{
			for(int i = 0; i < 10; i++) {
				Thread.sleep(1000);
				System.out.println("The APPLE earnings was better estimated");
			}
			
			
		} catch(InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + e.toString());
			
		} 
		
	}
}
