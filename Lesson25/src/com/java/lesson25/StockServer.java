package com.java.lesson25;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface StockServer extends Remote {
	
	public String getStockPrice(String symbol) throws RemoteException;
	
	public ArrayList<String> getTickers() throws RemoteException;
	
}
