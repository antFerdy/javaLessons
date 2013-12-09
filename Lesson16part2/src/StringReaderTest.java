import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class StringReaderTest {

	static BufferedReader buff = null;
	static FileReader file = null; 
	static FileWriter writer = null;
	static BufferedWriter buffw= null;
	
	public static void main(String[] args) {
		try {
			file = new FileReader("C:\\Users\\zhumagulov_r\\workspace\\Lesson17\\src\\res\\scores.txt");
			buff = new BufferedReader(file);
			writer = new FileWriter("C:\\Users\\zhumagulov_r\\workspace\\Lesson17\\src\\res\\results.txt");
			buffw = new BufferedWriter(writer);
			while(true) {
				String line = buff.readLine();
				buffw.write(line);
				
				if(line == null) {
					System.out.println("Файл закончился");
					break;
					
				}
				
				System.out.println(line);
				
			}
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
			
		}

		
		finally {
			try {
				writer.close();
				buffw.close();
				buff.close();
				file.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			
		}
	}

}
