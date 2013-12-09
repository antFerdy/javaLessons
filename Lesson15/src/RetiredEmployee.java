
public class RetiredEmployee extends Employee {
	String name;
	String sname;
	
	public RetiredEmployee(String name, String sname) {
		this.name = name;
		this.sname = sname;
		
	}
	
	
	
	public void doSomething() {
		System.out.println("Employee name is " + name + " " + sname);
		
	}

	
	
	
	
}
