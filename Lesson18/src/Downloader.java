import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class Downloader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Проверка на количество аргументов
		if(args.length != 2) {
			System.out.println("You should input 2 parameters!");
			System.exit(0);
		}
		
		//Создаем переменные потоков
		URL url = null;
		URLConnection conn = null; 
		InputStreamReader in = null;
		FileOutputStream out = null;
		
		
		
		//Инициализируем данные переменные
		try {
			//URL
			url = new URL(args[0]);
			conn = url.openConnection();
			
			//I/O
			in = new InputStreamReader(conn.getInputStream());
			out = new FileOutputStream(args[1]);
			
			
			//write data
			while(true) {
				int data;
				data = in.read();
				if(data != -1) {
					out.write(data);
				}

			}
			
			
			
		} catch (Exception e) {
			System.out.println("Oops... something was wrong");
		}
		//Close the streams
		 finally {
			 System.out.println("The file was successfully downloaded");
			try {
				out.flush();
				out.close();
				in.close();
				
				
			} catch (IOException e) {
				System.out.println("Can't close the stream! ");
				e.printStackTrace();
			}
			
			
			
		}
		

	}
}

