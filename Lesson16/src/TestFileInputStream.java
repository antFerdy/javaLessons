import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


 class TestFileInputStream {
	 static FileInputStream myFile = null;
	 static FileOutputStream outFile = null;
	 public static void main(String [] arg0) {
		 try {
			write();
		} catch (FileNotFoundException e1) {
			System.out.println("Oops... Something happend when we tried to write file");
		}
		 try {
			 myFile = new FileInputStream("C:\\Users\\zhumagulov_r\\workspace\\Lesson16\\src\\abc.dat");
			 
			 boolean eof = false;
			 while(eof != true) {
			 int bytes = myFile.read();
			 System.out.println("The butes array is" + bytes);
			 //write(bytes);
			 
			 if(bytes == -1) {
				 eof = true;
			 	}
			 
			 }
		 }
		 
		 catch(IOException e) {
			 System.out.println("Oops... Something happend");
		 }
		 
		 finally{
			 try {
				myFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
		 }
	 }
	private static void write() throws FileNotFoundException {
		int [] somedata = {13,2,255,234,0};
	
			outFile = new FileOutputStream("C:\\Users\\zhumagulov_r\\workspace\\Lesson16\\src\\abc.dat");
			for (int i = 0; i < somedata.length; i++) {
				try {
					outFile.write(somedata[i]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	}
	 
	 
	 
	 
	 
	 
	 
 }