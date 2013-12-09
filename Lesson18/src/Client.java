import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;



public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Проверка на количество аргументов
		if(args.length == 0) {
			System.out.println("Please insert correct argument");
			System.exit(0);
		}
		
		//Создаем сокет
		Socket clientSocket = null;
		
		//Создаем исходящий и входящие потоки
		BufferedReader reader = null;
		OutputStream out = null;
		
		
		try {
			//Поключаемся к сокету который слушает хост локал и порт 3000
			clientSocket = new Socket("localhost",3000);
			
			//Получаем нужные потоки
			reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = clientSocket.getOutputStream();
			
			//Отправляем на сервак тикет акции посредством исходящего потока
			out.write((args[0] + "\n").getBytes());
			out.write(("End\n").getBytes());
			
			//Получаем и преобразуем нужные данные
			String quote; 
			while(true) {
				quote = reader.readLine();
				if(quote == "End") {
					break;
				}
				//Отображаем данные
				System.out.println("Полученные данные о тикере " + args[0] + ":" + quote);
				
			}
			
		}
			//Отлавливаем исключения
		catch (UnknownHostException e1) {
			
			System.out.println("Проверьте соединение");
			
		}
		
		catch(IOException e2) {
			
			System.out.println("Ошибка при чтении файла");
		}
		
		
		finally {
			
			try {
				reader.close();
				out.flush();
				out.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			
			
		}
	}

}
