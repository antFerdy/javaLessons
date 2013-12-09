import java.io.Serializable;



public class Employee implements Serializable {
	String fname;
	String lname;
	Double salary;
	
	public String printName() {
		return(fname + " " + lname);
		
	}
	
}
