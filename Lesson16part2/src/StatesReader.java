import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JOptionPane;


public class StatesReader {
	BufferedReader buffReader = null;
	FileReader fileReader = null;
	FileWriter writer = null;
	Vector st;
	
	public StatesReader(Vector st) {
		this.st = st;
	}


	public void uploadStates() throws Exception {
		try {
			fileReader = new FileReader("C:\\Users\\zhumagulov_r\\workspace\\Lesson17\\src\\res\\scores.txt");
			buffReader = new BufferedReader(fileReader);
		
			boolean eof = true;
			while(eof ) {
				String curLine = buffReader.readLine();
				if(curLine == null) {
					eof = false;
				}
				
				else {
					st.add(curLine);
				}
			}
			
			
		} catch (FileNotFoundException e) {
			JOptionPane.showConfirmDialog(null, null, "File is not found", 0);
		}
		
	}

}
