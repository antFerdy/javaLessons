package my.test;



import my.pageObjects.Browser;
import my.pageObjects.Companies;
import my.pageObjects.Dashboard;
import my.pageObjects.EditPage;
import my.pageObjects.LoginPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestChange_CompanyStatus {

	@Before
	public void setUp() throws Exception {
		Browser.initialize();
	}

	@After
	public void tearDown() throws Exception {
		Browser.close();
	}

	@Test
	public void test() {
		LoginPage.GoTo();
		
		LoginPage.loginAs("admin")
		.withPassword("admin")
		.login();
		
		Dashboard.GoToCompany();
		Companies.filter();
		//assertEquals(true, Companies.checkStatus());
		EditPage.edit();
		
		
		
	}

}
