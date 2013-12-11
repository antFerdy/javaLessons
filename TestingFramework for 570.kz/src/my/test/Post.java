package my.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import my.pageObjects.Browser;

public class Post {
	private FileInputStream in; 
	private InputStreamReader reader;
	private BufferedReader buff;
	private String title;
	private String text;
	
	
	public Post isLocateOnMainPage(String option) {
		
		Select status = new Select(Browser.instance.findElement(By.name("status")));
		status.selectByVisibleText(option);
		return this;
	}

	public void create() {
		// TODO Auto-generated method stub
		try {
			in = new FileInputStream("C://Users/zhumagulov_r/workspace/TestingFramework for 570.kz/src/TestingResourses/news.txt");
			reader = new InputStreamReader(in);
			buff = new BufferedReader(reader);
			
			boolean eof = false;
			title = buff.readLine();
			text = buff.readLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				buff.close();
				reader.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		WebElement titleInput = Browser.instance.findElement(By.name("title"));
		titleInput.sendKeys(title);
		
		//��� � �� ����� ��������� ���� ���������� �� JS. ���� ���� ������ ��������. JS + Selenium
		//WebElement textInput = Browser.instance.findElement(By.className("editor"));
		//textInput.sendKeys(text);
		
		WebElement sendBtn = Browser.instance.findElement(By.id("send"));
		sendBtn.click();
		
		
	}

}
