import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;


public class DialogFrame extends Dialog implements ActionListener {
	JButton save;
	JButton cancel;
	JComboBox colorBox;
	JComboBox fontsBox;
	JComboBox sizesBox;
	


	public DialogFrame(JFrame fr, String title, boolean modal) {
		super(fr, title, modal);
		Vector colors = new Vector();
		Vector fonts = new Vector();
		Vector sizes = new Vector();
		
		colors.add("White");
		colors.add("Blue");
		colors.add("Red");
		
		fonts.add("Arial");
		fonts.add("Times New Roman");
		fonts.add("Calibri");
		
		sizes.add("Small");
		sizes.add("Middle");
		sizes.add("Large");
		
		colorBox = new JComboBox<>(colors);
		fontsBox = new JComboBox<>(fonts);
		sizesBox = new JComboBox<>(sizes);
		
		save = new JButton("Save");
		cancel = new JButton("Cancel");
		
		add(colorBox);
		add(fontsBox);
		add(sizesBox);
		add(save);
		add(cancel);
		setLayout(new FlowLayout());
		setSize(300,200);
		
		save.addActionListener(this);
		cancel.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		
	}


	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == cancel) {
			dispose();
		}
		
		else if(e.getSource() == save) {
			try {
				UserLogs user1 = new UserLogs();
				user1.color = (String) colorBox.getSelectedItem();
				user1.font = (String) fontsBox.getSelectedItem();
				user1.size = (String) sizesBox.getSelectedItem();
				
				FileOutputStream fileOut = new FileOutputStream("C:\\Users\\zhumagulov_r\\workspace\\Lesson17part2\\src\\prefer.ser");
				ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
				objOut.writeObject(user1);
				
				JOptionPane.showMessageDialog(null, "Your properties was saved sucsessfull ");
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		}
		
		
		
		
	}

}
