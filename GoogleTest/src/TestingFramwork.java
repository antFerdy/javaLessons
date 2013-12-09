
import org.junit.*;


public class TestingFramwork {
	
	@Test
	public void Can_go_to_homePage() {
		HomePage.go();
		Assert.assertEquals(true, HomePage.isAt());
	}
	
	@Test
	public void findAudaru() { 
		HomePage.typeSearchQuery();
		Assert.assertEquals(true, HomePage.isAtLink());
		
	}
	@Test
	public void openAudaruMainPage() { 
		HomePage.openAudaru();
		Assert.assertTrue(HomePage.isOnAudaru());
	}
	
	/*@After
	public void CleanUp() {
		HomePage.close();
	}*/
	
	
}
