class Tax {
	double grossIncome; //Class variable 
	String state; 
	int dependents; 
	
	public double calcTax() {
		double stateTax = 0;
		if(50000 > grossIncome){
			stateTax = grossIncome * 0.05;
		}
		else {
			stateTax = grossIncome * 0.06;
		}
		return stateTax;
	}
}
	
	//Constructor 
	/*Tax (double gi, String st, int depend) {
		grossIncome = gi; //class variable initialization 
		state = st;
		dependents = depend; 
	}*/
