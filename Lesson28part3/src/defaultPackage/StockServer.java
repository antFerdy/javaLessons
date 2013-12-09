package defaultPackage;


import java.util.ArrayList;



public class StockServer {
	ArrayList<String>tickers = new ArrayList<String>();
	String price;
	String symbol;
	
	public StockServer() { 
		tickers.add("AAPL");
		tickers.add("AMZN");
		tickers.add("FFIV");
	}
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getPrice() {
		if(symbol == null) {
			return price = "N/A";
		}
		else{
			if(tickers.contains(symbol)){
				price = (new Double(Math.random()*100)).toString();	
				return price;
			}
			
			else {
				return price = "N/A";
			}
			
		}
		
		
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
