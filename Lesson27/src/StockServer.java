
import java.util.ArrayList;


public class StockServer {
	ArrayList<String>tickers = new ArrayList<String>();
	String price;
	
	StockServer() {
		tickers.add("AAPL");
		tickers.add("AMZN");
		tickers.add("FFIV");
	}
	
	public String getStockPrice(String symbol)  {
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
