import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class ZipTest {
	static FileInputStream myFile;
	static ZipInputStream zipFile;
	static ZipEntry ze;
	
	public static void main(String[] args) {
		
			try {
				myFile = new FileInputStream("C:\\Users\\zhumagulov_r\\workspace\\Lesson17\\src\\res\\Src.zip");
				zipFile = new ZipInputStream(myFile);
				
				try {
					ze = zipFile.getNextEntry();
					while(ze != null) {
					 System.out.println(ze.getName());	
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				zipFile.close();
				myFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}

	}
