
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class ObjectStreamTest {

	
	public static void main(String[] args) {
		
		FileOutputStream file = null;
		ObjectOutputStream ser = null;
		
		Employee emp = new Employee();
		emp.lname = "Zhumagulov";
		emp.fname = "Rustem";
		emp.salary = 20.5;
		
		
		
		try {
			file = new FileOutputStream("C:\\Users\\zhumagulov_r\\workspace\\Lesson17\\src\\res\\employee.ser");
			ser = new ObjectOutputStream(file);
			ser.writeObject(emp);
			
			
		}
		
		catch (IOException e) {
			e.printStackTrace();
			
		}
		
		finally {
			
			try {
				file.close();
				ser.flush();
				ser.close();
				System.out.println("The employee object has been serialized into " + "C:\\Users\\zhumagulov_r\\workspace\\Lesson17\\src\\res\\employee.ser");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		

	}

}
