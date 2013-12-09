import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class StockQuoteServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Cоздаем серверсокет и сокет
		ServerSocket serv = null;
		Socket client = null;
		
		
		
		//Создадим два потока
		BufferedReader in = null;
		OutputStream out = null;
		
		
		try {
			//Слушаем порт
			serv = new ServerSocket(3000);
			
			while(true) {
				//Ждем запроса
				System.out.println("Waiting for request");
				client = serv.accept();
				
				
				//Получаем поток от клиента
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
				//Исходящий поток 
				out = client.getOutputStream();
				
				//Считываем входящий поток в строку
				String request = in.readLine();
				
				
				//получаем инфу о тикере
				StockQuote yahooReq = new StockQuote();
				String [] quotes = yahooReq.getStockQuote(request);
				
				//Делим массив котировок на составляющие 
				   String ticker = quotes[0];
			       String price = quotes[1];
			       String tradeDate = quotes[2];
			       String tradeTime = quotes[3];
				
			    //Отправляем данные в исходящий поток
			       out.write((" The price of " + ticker + " is " + price + 
			    		   " last print was at " + tradeDate + " in " + tradeTime).getBytes());
			    
			    //Подтверждение
			       System.out.println("The datafeed has been sended succesfully! The " + 
			    request + " price is " + price + "\n");
			       
			    //Отправляем закрытие исходящих данных
			       out.write((" End\n").getBytes());
			       
				
			}
			
			
			
		}
		
		catch (Exception e) {
			System.out.println("Ooops. Server error " + e.toString());
		
		}
		
		
		finally {
			System.out.println("I closed all streams");
			
			try {
				in.close();
				out.close();
				
			} catch (IOException e) {
				
				System.out.println("Ooops. Server error" + e.toString());
			}
			
			
			
			
			
		}
		

	}

}
