package com.practicaljava.lesson19;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.HeaderTokenizer.Token;
import javax.mail.internet.*;
import javax.mail.*;
import java.text.*;

public class Mailer {

public ArrayList <String> friendsList = new ArrayList<String>();

private Session session;
String senderAddress = "r.zhumagulov@yahoo.com";
String emailSubject = "Good Day";
String emailText = "Здравствуйте %s.\n";
static String recepientAddress = null;
static String recepientName = null;

//создаем сессию в конструкторе класса
Mailer () {
	Properties props = new Properties();
	//Host
	props.put("mail.smtp.host", "smtp.mail.yahoo.com");
	//User
	props.put("mail.smtp.user", senderAddress);
	//Port
	props.put("mail.smtp.port", "25");
	//Auth
	props.put("mail.smtp.auth", "true");
	
	MyMailAuth authenticator = new MyMailAuth();
	
	session = Session.getInstance(props, authenticator);
	
	
}


	//Читаем файл с днюхами
	private void readBirthdayFile() throws IOException {
		FileInputStream flIn = null;
		BufferedReader buff = null;
		
		FileInputStream flIn1 = null;
		BufferedReader buff1 = null;
		try {
			flIn = new FileInputStream("C:\\Users\\zhumagulov_r\\workspace\\Lesson19\\src\\com\\practicaljava\\lesson19\\birthDay.txt");
			buff = new BufferedReader(new InputStreamReader(flIn));
			
			flIn1 = new FileInputStream("C:\\Users\\zhumagulov_r\\workspace\\Lesson19\\src\\com\\practicaljava\\lesson19\\Text.txt");
			buff1 = new BufferedReader(new InputStreamReader(flIn1));

			//Загружаем данные в коллекцию
			String friend; 
			while((friend = buff.readLine())  != null) {
				friendsList.add(friend);
			}
			
			//Загружаем текст сообщения.
			String text;
			while((text = buff1.readLine()) != null) {
				emailText +=text;
			}
			
			//Проходим по списку друзей и устанавливаем адрес и имя подходящего получателя
			iterateThroughFrends();
			
			

		} catch (FileNotFoundException e) {
			System.out.println("Файл с датами не найден");
		} finally {
			flIn.close();
			buff.close();
		}
		
		
	}
	
	
	//Создаем итератор для вызова деления по символам
	private void iterateThroughFrends() {
		Iterator<String> it = friendsList.iterator();
		while(it.hasNext()) {
			tokenizing(it.next());
		}
		
	}



	//Делим коллекцию на составляющие
	private void tokenizing (String toSplit) {
		String [] data = toSplit.split(",");
		
		//Устанавливаем имя и адрес получателя
		if(compareDate(data[0])) {
			
			recepientAddress = data[2];
			recepientName = data[1];
			

		}
	}
	
	//Сравниваем дату с текущей
	private boolean compareDate (String str) {
		if(str.equals(GetCurrentDate())) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	//Получаем дату 
	private String GetCurrentDate() {
		
		return new SimpleDateFormat("MMM-d", Locale.US).format(new GregorianCalendar().getTime());
		
	}
	
	//Создаем сообщение с созданными параметрами и отправляем его
	private void sendMessage(String recepientAddress, String recepientName) {
		emailText = String.format(emailText, recepientName);
		//Создаем сообщение и его параметры с данной сессией
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(senderAddress));
		    message.setRecipients(Message.RecipientType.TO, 
                    InternetAddress.parse(recepientAddress, false));
			message.setSubject(emailSubject);
			message.setText(emailText);
			message.setSentDate(new Date());
			//Отправляем сообщение
			Transport.send(message);
			System.out.println("Сообщение было успешно отправлено отправителю: " + recepientAddress);
			
		} catch (AddressException e) {
			System.out.println("Вы ввели некорректный адресс");
			
		} catch (MessagingException e) {
			System.out.println("Не удалось отправить сообщение. Проверьте настройки");
			
		}
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// Создаем экземпляр класса и вызываем метод чтения и установки параметром а также отправку
		Mailer mail = new Mailer();
		try {
			mail.readBirthdayFile();
			mail.sendMessage(recepientAddress, recepientName);
		} catch (IOException e) {
			//Ошибка при чтении файла
			System.out.println("Ошибка при чтении файла или при отправке");
		}
		
	}

}
