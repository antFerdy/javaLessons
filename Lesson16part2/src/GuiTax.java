import java.awt.GridLayout;
import java.io.FileReader;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class GuiTax  {
	
	
		
		JLabel grIncLabel = new JLabel("Gross Income");
		JTextField grInc = new JTextField("Type your income");
		JLabel numDepLabel = new JLabel("Number of Dependents");
		JTextField numDep = new JTextField("Type count of depends",2);
		JLabel selStateLabel = new JLabel("State");
		static Vector st = new Vector(50);
		JComboBox<String> jstate = new JComboBox(st);
		JLabel stTaxLabel = new JLabel("State Tax");
		JTextField stTax = new JTextField(10);
		JButton go = new JButton("Go");
		JButton reset = new JButton("Reset");
		
		GuiTax() {
			
			JPanel panel = new JPanel(new GridLayout(5, 2, 2, 1));
			panel.add(grIncLabel);
			panel.add(grInc);
			panel.add(numDepLabel);
			panel.add(numDep);
			panel.add(selStateLabel);
			panel.add(jstate);
			panel.add(stTaxLabel);
			panel.add(stTax);
			panel.add(go);
			panel.add(reset);
			
			JFrame fr = new JFrame("Tax counter");
			fr.setContentPane(panel);
			fr.setVisible(true);
			fr.pack();
			
			EngineTax engine = new EngineTax(this);
			go.addActionListener(engine);
			reset.addActionListener(engine);
			
			
		}
		
		public static void main(String[] args) {
			GuiTax gui = new GuiTax();
			StatesReader reader = new StatesReader(st);
			try {
				reader.uploadStates();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
		}
	
	
}
