import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MyCustomizableGUI implements ActionListener {
	JFrame fr = new JFrame("Properties");
	JTextField tField = new JTextField("Type your name");
	JButton btn = new JButton("My properties");
	JPanel pnl = new JPanel(new FlowLayout());
	
	
	public MyCustomizableGUI () {
		pnl.add(tField);
		pnl.add(btn);
		fr.setContentPane(pnl);
		fr.setVisible(true);
		fr.setSize(500, 300);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		MyCustomizableGUI gui = new MyCustomizableGUI();
		

	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			DialogFrame dialogFrame = new DialogFrame(fr, "Save as", true);
			dialogFrame.setVisible(true);
			
			
		}
		
	}

}
