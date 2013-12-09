package def.src;


import java.util.ArrayList;


public class StockServer {
	static ArrayList<String>tickers = new ArrayList<String>();
	static String price;
	
	
	public String getStockPrice(String symbol)  {
		
		tickers.add("AAPL");
		tickers.add("AMZN");
		tickers.add("FFIV");
		
		
		if(symbol == null) {
			return price = null;
		}
		else{
			if(tickers.contains(symbol)){
				price = (new Double(Math.random()*100)).toString();	
				return price;
			}
			
			else {
				return price = null;
			}
			
		}
		
		
		
	}
}
