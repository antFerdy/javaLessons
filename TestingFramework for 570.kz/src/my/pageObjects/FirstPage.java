package my.pageObjects;

import my.test.Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FirstPage {
	//WebDriver driver = new FirefoxDriver();
	private String textInField;
	private WebElement PageImage;
	
	//Getters
	public String getTextInField() { 
		return textInField;
	}
	
	public WebElement getPageImage() {
		return PageImage;
	}
	
	
	//Constructor
	public FirstPage() {
		PageFactory.initElements(Browser.instance, this);
	}
	
	//Main Methods
	public void goTo() {
		Browser.instance.get("http://dev.570-570.kz/");
	}

	public void callThe570() {
		
		WebElement btn5 = Browser.instance.findElement(By.name("5"));
		WebElement btn7 = Browser.instance.findElement(By.name("7"));
		WebElement btn0 = Browser.instance.findElement(By.name("0"));
		
		btn5.click();
		btn7.click();
		btn0.click();
		btn5.click();
		btn7.click();
		btn0.click();
		
		WebElement numberField = Browser.instance.findElement(By.id("digital"));
		textInField = numberField.getAttribute("value");
		
		WebElement btnOK = Browser.instance.findElement(By.id("ok"));
		btnOK.click();
		//System.out.println(textInField);
	}

	public void pressOkBtn() {
		// TODO Auto-generated method stub
		PageImage = Browser.instance.findElement(By.className("imgl"));
		//welcomeTextField = welcomeText.getText();
		//System.out.println(target.getText());
	}

	
	
	
	
	
}

	
