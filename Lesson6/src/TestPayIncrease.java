import com.practicalJava.lesson6.*;

public abstract class TestPayIncrease implements Payable {
	
	public static void main(String[] args) {
		
		Person workers [] = new Person [3];
		workers[0] = new Employee("John Malcovich");
		workers[1] = new Contractor("Steve Jobs");
		workers[2] = new Employee("Howard Volovitz");
		
		Employee currentEmployee;
		Contractor currentContractor;
		
		for(Person p: workers) {
			
			if(p instanceof Employee) {
				currentEmployee = (Employee)p;
				currentEmployee.increasePay(30);
			}
			
			else if (p instanceof Contractor) {
				currentContractor = (Contractor)p;
				currentContractor.increasePay(30);
				
			}
		}

	}

}
