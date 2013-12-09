import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class TestOutputFile {
	static int [] someData = {1,23,45,78,99};
	static FileOutputStream myFile = null;
	static BufferedOutputStream buff = null; 
	
	public static void main(String[] args) {
		try {
			
			myFile = new FileOutputStream("C:\\Users\\zhumagulov_r\\workspace\\Lesson17\\src\\res\\xyz.dat");
			buff = new BufferedOutputStream(myFile, 10000);
			
			for (int i = 0; i < someData.length; i++) {
				buff.write(someData[i]);
			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally{
			try {
				buff.flush();
				buff.close();
				myFile.close();
			} catch (IOException e) {
				System.out.println("Something wrong");
				e.printStackTrace();
			}
		}
		
		System.out.println("Запись файла завершена");

	}

}
