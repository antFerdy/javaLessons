package com.java.lesson25.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.java.lesson25.StockServer;

public class Client {

	
	public static void main(String[] args) {
		//�������� �� ���������� ����������
		if(args.length == 0) {
			System.out.println("Please insert the symbol");
			System.exit(0);
		}
		
		//�������� ���� ������ ������� ����� 
		try {
			StockServer myStockServer = (StockServer) Naming.lookup("rmi://192.168.1.42:1099/QuoteService");
			
			//�������� ��������� 
			String price = myStockServer.getStockPrice(args[0]);
			//����������� ����������
			if(price != null) {
				System.out.println("The price of symbol: " + args[0] + " is: " + price);
			}
			//����������� ����������
			else {
				System.out.println("Invalid ticker" + ". Please insert one of thise: \n" + myStockServer.getTickers());
			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
