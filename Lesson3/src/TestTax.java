
public class TestTax {

	public static void main(String[] args) {
		Tax t = new Tax();
		
		t.grossIncome = 50000;
		t.state = "NJ";
		t.dependents = 3;
		
		double yourTax = t.calcTax();
		
		
		
		System.out.println("Your tax is " + yourTax);
		
		
		
		
	}

}
