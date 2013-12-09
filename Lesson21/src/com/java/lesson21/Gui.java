package com.java.lesson21;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import javax.swing.*;

public class Gui extends JFrame implements ActionListener {
	JPanel pnl;
	JButton btn;
	JTextArea textfield1;
	JTextArea textfield2;
	
	
	public Gui () {
		JPanel pnl = new JPanel();
		btn = new JButton("Get the news");
		textfield1 = new JTextArea();
		textfield2 = new JTextArea();
		
		pnl.setLayout(new GridLayout(1,3));
		
		pnl.add(textfield1);
		pnl.add(btn);
		pnl.add(textfield2);
		
		btn.addActionListener(this);
	
		this.setContentPane(pnl);		
		
	}
	
	public static void main(String[] args) {
		Gui gui = new Gui();
		gui.setBounds(0, 0, 500, 300);
		gui.setVisible(true);

	}

	
	public void actionPerformed(ActionEvent arg0) {
		NewsReader news = new NewsReader("C:\\Users\\zhumagulov_r\\workspace\\Lesson21\\src\\com\\java\\lesson21\\news.txt", this);
		NewsReader news1 = new NewsReader("C:\\Users\\zhumagulov_r\\workspace\\Lesson21\\src\\com\\java\\lesson21\\news1.txt", this);
		
		try {
			this.textfield1.setText(news1.doInBackground());
			this.textfield2.setText(news.doInBackground());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
