package com.practicalJava.Lesson7.tryit;
import javax.swing.*;
import java.awt.GridLayout;
public class SimpleCalculatorGrid {

	public static void main(String[] args) {
		//1)Create JPanel
		JPanel windowContent = new JPanel();
		
		//2)Assign Layout Manager to it
		GridLayout g1 = new GridLayout(4,2);
		windowContent.setLayout(g1);
		
		//3)Instance some Swing controls 
		 JLabel label1 = new JLabel("Number 1:");
		 JTextField field1 = new JTextField(10);
		 JLabel label2 = new JLabel("Number 2:");
		 JTextField field2 = new JTextField(10);
		 JLabel label3 = new JLabel("Sum: ");
		 JTextField result = new JTextField(10);
		 JButton go = new JButton("Add");
		 
		//4) Add them to the panel  	
		 windowContent.add(label1); 
		 windowContent.add(field1);
		 windowContent.add(label2);
		 windowContent.add(field2);
		 windowContent.add(label3);
		 windowContent.add(result);
		 windowContent.add(go);
		 
		 //5)Add the panel to the top-level container - JFrame
		 JFrame frame = new JFrame("My First Calculator");
		 frame.setContentPane(windowContent);
		 
		 //6)Set the Frame's size and make it visible
		 frame.setSize(400, 100);
		 frame.setVisible(true);

	}

}
