
public class HomePage {
	private static String link = "https://www.google.kz";
	private  String expTitle = "Поиск в Google";
	private static  String query = "audaru.kz";
	
	//BrowserFF browserF = new BrowserFF();
	/*public static HomePage HomePage() {
		HomePage homePage = new HomePage();
		return homePage;
		
	}*/
	
	public static  void go() {
		BrowserFF.open(link);	
	}

	public static  boolean isAt() {
		return BrowserFF.isLogoPresent();
	}

	public static  void close() {
		BrowserFF.close();
		
	}

	public static  void typeSearchQuery() {
		BrowserFF.search(query);
		
	}

	public static  boolean isAtLink() {
		return BrowserFF.isLinkPresent();
		
	}

	public static  void openAudaru() {
		BrowserFF.opentTheFirstLink();
		
	}

	public static boolean isOnAudaru() {
		return BrowserFF.assertAudaruPage();
	}
	
	


}
