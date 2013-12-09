import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class GoogleReader {


	public static void main(String[] args) {
		//Создаем потоки
		InputStreamReader fl = null;
		URL url = null;
		URLConnection conn = null;
		BufferedReader buff = null;
		String currLine;

		//Пытаемся читать поток
		try{
			
			url = new URL("https://www.google.kz/#q=%D0%A0%D1%83%D1%81%D1%82%D0%B5%D0%BC+%D0%96%D1%83%D0%BC%D0%B0%D0%B3%D1%83%D0%BB%D0%BE%D0%B2");
			conn = url.openConnection();
			buff = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF8"));
			
			while(true) {
				currLine = buff.readLine();
				//Выводим результаты	
				if(currLine != null) {
					System.out.println(currLine);
				
				}
				
				else {
					break;
				}
			}
			
		}
		
		catch(Exception e) {
			System.out.println("Oops... Something was failed!");

		}

		//Закрываем потоки
		finally{
			try {
				
				fl.close();
				buff.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
	}

}
