
public class TestTax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double yourTax = 0;
		double yourEuroTax = 0;
		@SuppressWarnings("unused")
		Tax t = new Tax(50000,"NY",2);

		yourTax = Tax.calcTax();
		yourEuroTax = Tax.convertToEuro();
		
		System.out.println("Your tax is " + yourTax);
		System.out.println("Your tax in euro is " + yourEuroTax);

	}

}
