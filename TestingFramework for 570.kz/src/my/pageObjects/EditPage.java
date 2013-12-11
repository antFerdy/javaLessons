package my.pageObjects;




import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditPage {

	public static void edit() {
		//find link in table data with waiting statement
		Alert refreshingSplashScreen = (new WebDriverWait(Browser.instance, 10))
				  .until(ExpectedConditions.alertIsPresent());
		try {
			refreshingSplashScreen.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement editLink = Browser.instance.findElement(By
					.cssSelector("html body div#wrapper div#page-wrapper div.row div.col-lg-12 table#news.table tbody#tab tr td a"));
		editLink.click();
			
	
		
	}
	
	
	/*private Alert AlertIsPresent(WebDriver drv)
	{
	    try
	    {
	        // Attempt to switch to an alert
	        return drv.switchTo().alert();
	    }
	    catch (NoAlertPresentException e)
	    {
	        // We ignore this execption, as it means there is no alert present...yet.
	        return null;
	    }

	    // Other exceptions will be ignored and up the stack
	}*/
	
	

}
