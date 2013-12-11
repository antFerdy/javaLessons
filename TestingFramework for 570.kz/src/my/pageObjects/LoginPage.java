package my.pageObjects;



public class LoginPage {
	private static String url = "http://dev.570-570.kz/ru/login";
	
	/**
	 * Opening hard coded url in browser
	 * @return no returns
	 */
	public static void GoTo() {
		Browser.instance.get(url);
	}

	public static LoginCommand loginAs(String userName) {
		// TODO Auto-generated method stub
		return new LoginCommand(userName);
	}

	
	

}
