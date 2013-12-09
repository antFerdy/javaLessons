
public class Tax {
	static int customerCounter;
	static double grossIncome;
	static int dependents;
	String state;
	
	//constructor
	Tax (double gi, String st, int depen) {
		grossIncome = gi;
		dependents = depen;
		state = st;
		customerCounter++;
		//System.out.println("Preparing the tax data for customer #" + customerCounter);
	}
	
	public static double calcTax() {
		return (grossIncome * 0.33 - dependents*100);
	}
	
	public static double convertToEuro() {
		return (calcTax()*1.25);
	}
	
	
}