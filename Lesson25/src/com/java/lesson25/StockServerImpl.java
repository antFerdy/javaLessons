package com.java.lesson25;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;



public class StockServerImpl extends UnicastRemoteObject implements StockServer  {
	//Создадим массив тикеров и цены
	ArrayList<String> tickers= new ArrayList<String>();
	String price;
	
	public StockServerImpl() throws RemoteException {
		super();
		tickers.add("AAPL");
		tickers.add("AMZN");
		tickers.add("FFIV");
		tickers.add("GMCR");
		
	}
	
	
	@Override
	public String getStockPrice(String symbol) throws RemoteException {
		// Генерируем цены на тикеры
		if(tickers.indexOf(symbol.toUpperCase()) != -1) {
			price = (new Double(Math.random()*100)).toString();
		}
		return price;
	}


	@Override
	public ArrayList<String> getTickers() throws RemoteException {
		// TODO Auto-generated method stub
		return tickers;
	}

	

}
