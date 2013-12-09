
public class TestTax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		if(args.length !=3) {
			System.out.println("Sample usage of the programm:" + " java TestTax 50000 NY 1" );
			System.exit(0);
		}
		
		/* Want to add here code about 
		 * with loop switch
		 * 
		 * 
		 * 
		 * 
		 */
		
		double grossIncome = Double.parseDouble(args[0]);
		String state = args[1];
		int dependents = Integer.parseInt(args[2]);
		
		if (grossIncome == 0 || state == "0" || dependents == 0) {
			System.out.println("You entered incorrect values! Sample usage of the program:  " + " java TestTax 50000 NY 1" );
			System.exit(0);
		}
		
		
		
		Tax t = new Tax(grossIncome, state, dependents);
		double yourTax = t.calcTax();
		
		System.out.println("Your tax is " + yourTax);
		System.out.println("Your state is " + state);
		
		
		
	}

}
