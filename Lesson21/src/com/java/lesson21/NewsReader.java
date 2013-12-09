package com.java.lesson21;

import java.io.*;

import javax.swing.SwingWorker;

public class NewsReader extends SwingWorker<String, Object> {
	String pathFile;
	String newsText;
	Gui gui;
	
	public NewsReader (String path, Gui gui) {
		pathFile = path;
		this.gui = gui;
	}
	
	
	
	protected String doInBackground() throws Exception {
		FileInputStream in = new FileInputStream(pathFile);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		while(true) {
			String currentLine = reader.readLine();
			if(currentLine != null) {
				newsText+=currentLine;
			} else {
				
				break;
			}
		}
		return newsText;
	}
	
	protected void done() {
		/*gui.textfield1.setText(newsText);
		gui.textfield2.setText(newsText);*/
		
		
		
	}
	
	
	
	

}
