import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MyCustomizableGui implements ActionListener {
	 
	JFrame fr = new JFrame();
	JPanel pnl = new JPanel(new FlowLayout());
	JButton btn = new JButton("Properties");
	JTextField fl = new JTextField("Type here ");
	FileOutputStream flOut = null;
	ObjectOutputStream objOut = null;
	UserPreferences 
	
	
	MyCustomizableGui() {
		pnl.add(fl);
		pnl.add(btn);
		fr.setContentPane(pnl);
		fr.pack();
		fr.setVisible(true);
		btn.addActionListener(this);
		
	}
	
	
	public static void main(String[] args) {
		MyCustomizableGui gui = new MyCustomizableGui();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn) {
			Dialog dialog = new Dialog(fr, "Preferences", true);
			dialog.setVisible(true);
		}
		
	}


	public void serialaize() {
		try {
			flOut = new FileOutputStream("C:\\Users\\zhumagulov_r\\workspace\\Lesson17\\src\\res\\properties.ser");
			objOut = new ObjectOutputStream(flOut);
			objOut.wr
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
