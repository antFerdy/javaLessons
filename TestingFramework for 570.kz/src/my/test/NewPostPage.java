package my.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import my.pageObjects.Browser;

public class NewPostPage {

	public static void GoTo() {
		WebElement pages = Browser.instance.findElement(By.id("edit"));
		pages.click();
		
		WebElement mainPage = Browser.instance.findElement(By.linkText("������� ��������"));
		mainPage.click();

		WebElement editNews = Browser.instance.findElement(By.linkText("�������� �������"));
		editNews.click();
	}

	public static Post createPost() {
		// TODO Auto-generated method stub
		return new Post();
	}

}
