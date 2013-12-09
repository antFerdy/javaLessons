import java.io.BufferedWriter;
import java.io.FileWriter;



public class TestBufferedWriter {

	
	public static void main(String[] args) {
		FileWriter wr = null;
		BufferedWriter bwr = null;
		
		String[] names = new String [3];
		names[1] = "Hovard";
		names[2] = "Andrew";
		names[3] = "Andy";
		
		try {
			wr = new FileWriter("C:\\Users\\zhumagulov_r\\workspace\\Lesson17\\src\\res\\results.txt");
			bwr = new BufferedWriter(wr);
			
			for(int i = 0; i < names.length; i++) {
				bwr.write(names[i]);
				
			}
			
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		finally {
			try {
				wr.close();
				bwr.close();
			} catch (Exception e) {
				System.out.println("");
			}
			
			
			
			
		}

	}

}
