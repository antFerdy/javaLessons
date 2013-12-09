import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {
	Calculator parent;
	char selectedAction;
	double currentResult = 0;
	double displayValue = 0;
	
	CalculatorEngine(Calculator parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton)e.getSource();
		String displayFieldText = parent.getTextInDisplayField();
		
		
		
		if(!"".equals(displayFieldText)) {
			try {
				displayValue = Double.parseDouble(displayFieldText);
			}
			
			catch(NumberFormatException e1) {
				javax.swing.JOptionPane.showConfirmDialog(null,"Please insert a number", "incorrecte insert",javax.swing.JOptionPane.WARNING_MESSAGE);
				return;
			}
			
		}
		
		
		if(clickedButton == parent.buttonDivide) {
			selectedAction = '/';
			currentResult = displayValue;
			parent.setTextInDisplayField("");
		}
		
		else if(clickedButton == parent.buttonMinus) {
			selectedAction = '-';
			currentResult = displayValue;
			parent.setTextInDisplayField("");
		}
		
		else if (clickedButton == parent.buttonMultiply) {
			selectedAction = '*';
			currentResult = displayValue;
			parent.setTextInDisplayField("");
		}
		
		else if (clickedButton == parent.buttonPlus) {
			selectedAction = '+';
			currentResult = displayValue;
			parent.setTextInDisplayField("");
		}
		
		else if(clickedButton == parent.buttonEqual) {
			if(selectedAction == '+'){
				currentResult += displayValue;
				parent.setTextInDisplayField(""+currentResult);
			}
			
			else if(selectedAction == '-'){
				currentResult -= displayValue;
				parent.setTextInDisplayField(""+currentResult);
			}
			
			else if(selectedAction == '*'){
				currentResult *= displayValue;
				parent.setTextInDisplayField(""+currentResult);
			}
			
			else if(selectedAction == '/'){ 
				if(displayValue == 0){
					javax.swing.JOptionPane.showConfirmDialog(null,"Divede to null or empty value is forbiddance", "incorrecte insert",javax.swing.JOptionPane.WARNING_MESSAGE);
				}
				else {
					currentResult /= displayValue;
					parent.setTextInDisplayField(""+currentResult);
				}
			}
		}
		else {
			String clickedButtonLabel = clickedButton.getText();
			parent.setTextInDisplayField(displayFieldText+clickedButtonLabel);
		}
		
	}
	

   
}

