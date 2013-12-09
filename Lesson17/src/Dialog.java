
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;


public class Dialog extends java.awt.Dialog   {
	
	Vector a = new Vector();
	Vector b = new Vector();
	Vector c = new Vector();
	
	JComboBox colorBox = new JComboBox(a);
	JComboBox fontBox = new JComboBox(b);
	JComboBox fontSizeBox = new JComboBox(c);
	
	JButton save = new JButton("Save ");
	JButton cancel = new JButton("Cancel");
	
	
	
	
	public Dialog(Frame fl, String title, boolean modal) {
		super(fl, title, modal);
		setLayout(new FlowLayout());
		setSize(300,200);
		
		add(colorBox);
		add(fontBox);
		add(fontSizeBox);
		add(save);
		add(cancel);
		
		UserPreferences pref = new UserPreferences(this);
		colorBox.addActionListener(pref);
		fontBox.addActionListener(pref);
		fontSizeBox.addActionListener(pref);
		save.addActionListener(pref);
		cancel.addActionListener(pref);
		
		a.add("Blue");
		a.add("Black");
		a.add("Red");
		
		b.add("Arial");
		b.add("Calibri");
		b.add("Times New Roman");
		
		
		for(int i = 1; i < 16; i++) {
			c.add(i);
		
		}


	}


	


}
