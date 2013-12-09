
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;


public class UserPreferences implements Serializable,ActionListener{
	String color;
	String font;
	int fontSize;
	Dialog dial;
	MyCustomizableGui gui;
	
	public UserPreferences (Dialog dial) {
		this.dial = dial;
	}
	
	public void setColor(Object selectedItem) {
		this.color = (String) selectedItem;
		
	}
	
	private void setFontSize(Object selectedItem) {
		this.font = (String) selectedItem;
		
	}

	private void setFont(Object selectedItem) {
		this.fontSize = (Integer) selectedItem;
		
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == dial.cancel) {
			dial.dispose();
		}
		
		else if(e.getSource() == dial.save) {
			setColor(dial.colorBox.getSelectedItem());
			setFont(dial.fontBox.getSelectedItem());
			gui.serialaize();
			//setFontSize(dial.fontSizeBox.getSelectedItem());
			//System.out.println(color + " " + font + " " + fontSize);
		}
		
	}


	
}
