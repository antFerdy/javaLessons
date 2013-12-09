package com.lesson20.java;

public class StockPortfolio2 extends Thread{
	public void run() {
		try {
			for(int i = 0; i < 10; i++) {
				sleep(700);	
				System.out.println("You earned 30K today. Good luck! ");
			}
			
			interrupt();
			for(int i = 0; i < 10; i++) {
				System.out.println("You earned 30K today. Good luck! ");
			}
			
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + e.toString());
		}
		
		
	}
}
