
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;




public class BrowserFF {
	static WebDriver browser = new FirefoxDriver();
	
	
	
	//Open the link
	public static  void open(String link) {
		browser.navigate().to(link);
		
	}
	//Logo
	public static  boolean isLogoPresent() {
		WebElement loginBtn = browser.findElement(By.id("hplogo"));
		return loginBtn.isDisplayed();
		
	}

	
	//SearchBox
	public static void search(String query) {
		WebElement searchBox = browser.findElement(By.id("gbqfq"));
		searchBox.sendKeys(query);
		searchBox.submit();
		browser.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}
	
	//Is link present
	public static boolean isLinkPresent() {
		WebElement firstLink = browser.findElement(By.className("r"));
		return firstLink.getText().contains("Помощь в переводах");
	}
	
	//Close the browser
	public static  void close() {
		browser.close();
	}
	
	
	public static void opentTheFirstLink() {
		WebElement firstLink = browser.findElement(By.className("r"));
		firstLink.click();
		
	}
	public static boolean assertAudaruPage() {
		WebElement audaruPage = browser.findElement(By.id("logo"));
		return audaruPage.isDisplayed();
	}
	

}
