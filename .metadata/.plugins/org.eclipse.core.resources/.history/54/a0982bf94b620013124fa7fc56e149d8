package my.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	public static WebDriver instance;


	public static void initialize() {
		// TODO Auto-generated method stub
		instance = new FirefoxDriver();
		instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	public static void close() {
		// TODO Auto-generated method stub
		instance.close();
	}
}
