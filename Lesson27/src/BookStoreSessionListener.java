import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class BookStoreSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent e) {
		HttpSession ses = e.getSession();
		System.out.println("The session created. Session id : " + ses.getId());
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession ses1 = arg0.getSession();
		System.out.println("The session is destroyed. Session id: " + ses1.getId());
		
	}

}
