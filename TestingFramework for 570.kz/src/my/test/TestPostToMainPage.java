package my.test;

import static org.junit.Assert.*;

import my.pageObjects.Browser;
import my.pageObjects.LoginPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPostToMainPage {

	@Before
	public void setUp() throws Exception {
		Browser.initialize();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		LoginPage.GoTo();
		LoginPage.loginAs("admin")
		.withPassword("admin")
		.login();
		
		NewPostPage.GoTo();
		
		NewPostPage.createPost()
		.isLocateOnMainPage("��")
		.create();
	}

}
