package com.java.lesson21;

import java.util.concurrent.Callable;

public class Portfolio1 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		for(int i = 0; i < 10; i++) {
			Thread.sleep(700);
			System.out.println("Вы купили акции по 456 баксов");
			
		}
		
		return 456;
	}

}
