package com.java.lesson21;

import java.util.concurrent.Callable;

public class MarketNews1 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		// Запускает поток
		for(int i = 0; i < 10; i ++) {
			Thread.sleep(700);
			System.out.println("Отчеты AAPL выше оценок аналитиков");
		}
		
		
		
		return 488;
	}

}
