import java.util.ArrayList;


public class TestArrays {
	public static ArrayList <RetiredEmployee> remp = new ArrayList<RetiredEmployee>();
	public static ArrayList <Employee> emp = new ArrayList<Employee>();
	
	public static void main(String[] args) {
		RetiredEmployee mike = new RetiredEmployee("Mike", "Vazovskiy");
		RetiredEmployee josh = new RetiredEmployee("Josh", "Helbegert");
		
		go(mike,josh);
		emp.addAll(remp);
		doIt(emp);
	}
	
	
	public static void go(RetiredEmployee mike,RetiredEmployee josh) {
		remp.add(mike);
		emp.add(josh);
		
	}
	
	public static void doIt (ArrayList<Employee> emp1) {
		for (Employee c:emp1) {
			c.doSomething();
		}
	}

}
