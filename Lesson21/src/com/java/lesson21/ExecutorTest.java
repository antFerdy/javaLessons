package com.java.lesson21;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.text.html.HTMLDocument.Iterator;

public class ExecutorTest {

	
	public static void main(String[] args) {
		//Создаем объект класса екзекьютор сервайс c ограничением в два потока
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		//Создаем лист Future объектов 
		//Threads’ results can be stored in the collection of Futures
		List<Future<Integer>> threadResults = new ArrayList<Future<Integer>>();
		
		//Создаем лист для сохранения результатов
		List<Integer> results = new ArrayList<Integer>();
		
		//Добавляем в лист
		threadResults.add(es.submit(new Portfolio1()));
		threadResults.add(es.submit(new MarketNews1()));
		
		//Получаем результаты выполнения в лист
		for(Future<Integer> future: threadResults) {
			try {
				results.add(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				es.shutdown();
			}
		}
		//Получаем значения цены покупки и текущей цены.
		int price = results.get(0);
		int currentPrice = results.get(1);
		//Принтуем наш профит.
		System.out.println("Вы заработали " + (currentPrice - price) + " поинтов");
		
	}

}
