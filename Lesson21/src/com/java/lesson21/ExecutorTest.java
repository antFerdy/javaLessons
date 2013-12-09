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
		//������� ������ ������ ���������� ������� c ������������ � ��� ������
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		//������� ���� Future �������� 
		//Threads� results can be stored in the collection of Futures
		List<Future<Integer>> threadResults = new ArrayList<Future<Integer>>();
		
		//������� ���� ��� ���������� �����������
		List<Integer> results = new ArrayList<Integer>();
		
		//��������� � ����
		threadResults.add(es.submit(new Portfolio1()));
		threadResults.add(es.submit(new MarketNews1()));
		
		//�������� ���������� ���������� � ����
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
		//�������� �������� ���� ������� � ������� ����.
		int price = results.get(0);
		int currentPrice = results.get(1);
		//�������� ��� ������.
		System.out.println("�� ���������� " + (currentPrice - price) + " �������");
		
	}

}
