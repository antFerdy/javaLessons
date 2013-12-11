
import java.util.ArrayList;


public class StockServerBean {
 
	//Создадим массив тикеров и цены
	ArrayList<String> tickers= new ArrayList<String>();
	String price;

	//Конструктор
        StockServerBean() {
            tickers.add("AAPL");
            tickers.add("AMZN");
            tickers.add("FFIV");
            tickers.add("GMCR");
         
        }
	

	public String getStockPrice(String symbol) {
		// Генерируем цены на тикеры
		if(tickers.indexOf(symbol.toUpperCase()) != -1) {
			price = (new Double(Math.random()*100)).toString();
		}
		return price;
	}



	public ArrayList<String> getTickers() {
		// TODO Auto-generated method stub
		return tickers;
	}

	

}

    
    

