package com.java.lesson25;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class StartServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			LocateRegistry.createRegistry(1099);
			StockServerImpl ssi = new StockServerImpl();
			Naming.rebind("rmi://localhost:1099/QuoteService",ssi);
			System.out.println("The server is started");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}