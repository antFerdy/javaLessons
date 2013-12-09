
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Login {

	
	public static void main(String[] args) {
		//instantiate the driver
		
		try {
			WebDriver driver = new RemoteWebDriver(new URL("http://localhost:1479/wd/hub"), DesiredCapabilities.firefox());
			driver.get("https://portal.sk.kz/auth.php");
			
			//find
			WebElement login = driver.findElement(By.name("USER_LOGIN"));
			WebElement password = driver.findElement(By.name("USER_PASSWORD"));
			
			login.clear();
			login.sendKeys("test3");
			
			password.clear();
			password.sendKeys("364251");
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
		
		
		
	}

}
