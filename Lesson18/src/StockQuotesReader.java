import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;


public class StockQuotesReader {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		//Create the connection
		InputStreamReader inRead = null;
		InputStream in = null;
		BufferedReader buff = null;
		try {
			URL url = new URL("http://quote.yahoo.com/d/quotes.csv?s="
                   + args[0] + "&f=sl1d1t1c1ohgv&e=.csv");
			URLConnection conn = url.openConnection();
			in = conn.getInputStream();
			inRead = new InputStreamReader(in,"UTF8");
			buff = new BufferedReader(inRead);
			
			
			//read stream
			String csvLine;
			csvLine = buff.readLine();
			
			
			//untokenizing
			StringTokenizer tokenizer = new StringTokenizer(csvLine, ",");
			String ticker = tokenizer.nextToken();
            String price  = tokenizer.nextToken();
            String tradeDate = tokenizer.nextToken();  
            String tradeTime = tokenizer.nextToken();  
            
            
            

            System.out.println("Symbol: " + ticker + 
              " Price: " + price + " Date: "  + tradeDate 
              + " Time: " + tradeTime);
			
			
		} 
		
		
		catch (IOException e) {
			System.out.println("Can't find a csv file " + e.toString());
			
		}
		
		/*catch (MalformedURLException e1) {
			System.out.println("Can't open the URL." + url + "Please check it" + e1.toString());
			
			
		}*/
		
		
		finally {
			
			try {
				inRead.close();
				in.close();
				buff.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			
		}

	}

}
