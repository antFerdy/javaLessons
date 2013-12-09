
public class Tax {
	double grossIncome;
	String state;
	int dependents;
	
	
	Tax(double grossIncome, String state, int dependents) {
	 this.grossIncome = grossIncome;
	 this.state = state;
	 this.dependents = dependents;
	}
	
	 double calcTax() {
		 double stateTax;
		 if(grossIncome > 30000) {
			 stateTax = grossIncome * 0.06;	 
		 }
		
		 else {
			 stateTax = grossIncome * 0.05;
		 }
		 stateTax /=dependents;
		 return stateTax;
	 }
	
	
}


	
