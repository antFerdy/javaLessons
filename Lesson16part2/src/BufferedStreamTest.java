import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class BufferedStreamTest {

	static BufferedInputStream buff = null;
	static FileInputStream myFile = null;
	
	public static void main(String[] args) {
		
		
		try { 
			myFile = new FileInputStream("C:\\Users\\zhumagulov_r\\workspace\\Lesson17\\src\\res\\xyz.dat");
			buff = new BufferedInputStream(myFile,5000);
			
			while(true) {
				int byteValue = buff.read();
				System.out.println(byteValue + " ");
				if (byteValue == -1) {
					break;
					
				}
			
			}
			
		}
		
		
		catch (Exception e ) {
			e.printStackTrace();
			
			
		}
		
		
		finally {
			try {
				myFile.close();
				buff.close();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
			
			
			
		}

		
	}

}
