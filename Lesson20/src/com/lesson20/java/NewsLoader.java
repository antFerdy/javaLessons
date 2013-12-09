package com.lesson20.java;

public class NewsLoader extends Thread implements Updatable {

	Updatable dc;
	

	
	public NewsLoader(QuotePrinter dc) {
		this.dc = dc;
		this.start();
	}

	public void run() {
		dc.SetNewsData("AAPL was reached 52 week high");
		//dc.notify();
	}

	public void SetData(String marketNews) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SetNewsData(String string) {
		// TODO Auto-generated method stub
		
	}

}
