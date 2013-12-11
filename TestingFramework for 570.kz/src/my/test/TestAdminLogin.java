package my.test;

import static org.junit.Assert.*;

import my.pageObjects.Browser;
import my.pageObjects.Dashboard;
import my.pageObjects.LoginPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAdminLogin {

	@Before
	public void setUp() throws Exception {
		Browser.initialize();
	}

	@After
	public void tearDown() throws Exception {
		Browser.close();
	}

	@Test
	public void Admin_can_login() {
		LoginPage.GoTo();
		LoginPage.loginAs("admin")
		.withPassword("admin")
		.login();
		
		assertTrue("Login Failed",Dashboard.isTrue());
	}

}
