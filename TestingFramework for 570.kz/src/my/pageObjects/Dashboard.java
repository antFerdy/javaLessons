package my.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Dashboard {
	
	
	public static boolean isTrue() {
		WebElement title = Browser.instance.findElement(By.tagName("h4"));
		if(title.getText().equals("ƒобро пожаловать в панель управлени€")) {
			return true;
		} else {
			return false;
		}
		
	}

	public static void GoToCompany() {
		Browser.instance.get("http://dev.570-570.kz/admin/ru/companies");
		
	}
	
}
