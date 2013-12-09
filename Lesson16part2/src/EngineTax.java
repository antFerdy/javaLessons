import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class EngineTax implements ActionListener {
	GuiTax a = null;
	
	EngineTax(GuiTax a) {
		this.a = a;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
	  if((JButton) e.getSource() == a.go) {
		  
		 try {
			  double grossInc = Double.parseDouble(a.grInc.getText());
			  int dependents = Integer.parseInt(a.numDep.getText());
			  String state = (String) a.jstate.getSelectedItem();
			  
			  Tax tax = new Tax(grossInc,state,dependents);
			  String stax = Double.toString(tax.calcTax());
			  a.stTax.setText("Your tax in " + state + " is " + stax);
		 }
		 
		 catch(NumberFormatException eo) {
			 a.stTax.setText(eo.getMessage());			
			 
		 }
		 
		 catch (Exception e1) {
			 a.stTax.setText(e1.getMessage());			 
		 }
		  
	  }
	  
	  else if((JButton) e.getSource() == a.reset) { 
		  a.grInc.setText("");
		  a.numDep.setText("");
		  a.jstate.setSelectedIndex(0);
		  a.stTax.setText("");

	  }
		
	}

}
