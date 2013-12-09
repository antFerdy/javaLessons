import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class StockQuoteServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//C������ ����������� � �����
		ServerSocket serv = null;
		Socket client = null;
		
		
		
		//�������� ��� ������
		BufferedReader in = null;
		OutputStream out = null;
		
		
		try {
			//������� ����
			serv = new ServerSocket(3000);
			
			while(true) {
				//���� �������
				System.out.println("Waiting for request");
				client = serv.accept();
				
				
				//�������� ����� �� �������
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
				//��������� ����� 
				out = client.getOutputStream();
				
				//��������� �������� ����� � ������
				String request = in.readLine();
				
				
				//�������� ���� � ������
				StockQuote yahooReq = new StockQuote();
				String [] quotes = yahooReq.getStockQuote(request);
				
				//����� ������ ��������� �� ������������ 
				   String ticker = quotes[0];
			       String price = quotes[1];
			       String tradeDate = quotes[2];
			       String tradeTime = quotes[3];
				
			    //���������� ������ � ��������� �����
			       out.write((" The price of " + ticker + " is " + price + 
			    		   " last print was at " + tradeDate + " in " + tradeTime).getBytes());
			    
			    //�������������
			       System.out.println("The datafeed has been sended succesfully! The " + 
			    request + " price is " + price + "\n");
			       
			    //���������� �������� ��������� ������
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
