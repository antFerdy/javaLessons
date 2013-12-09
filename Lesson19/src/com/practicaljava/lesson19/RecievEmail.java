package com.practicaljava.lesson19;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;

public class RecievEmail {
	private static Store st = null; 

	public static void main(String[] args) {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props);
		String host = "pop.mail.ru";
		String port = "995";
		String user = "rusteam1991@mail.ru";
		String password = "!Q@W3e4r";
		
		try {
			st = session.getStore("pop3s");
			st.connect(host, user, password);
			Folder fold = st.getDefaultFolder();
			fold = fold.getFolder("Inbox");
			fold.open(Folder.READ_ONLY);
			
			Message[] message  = fold.getMessages();
			/*String authorStr = null;
			String content = null;*/
			for(int i = 0; i < message.length; i++) {
				//String content = (String)message[i].getBodyPart();
				String subject = message[i].getSubject();
				System.out.println("Вы получили письмо" + ".\n Тема письма: " + subject);
				
			}
			
		} catch (Exception e) {
			System.out.println("В джунглях непорядок!");
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
