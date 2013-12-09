

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindBooks
 */
@WebServlet("/FindBooks")
public class FindBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create the session
		request.getSession(true);
		
		String symbol = request.getParameter("symbol");
		
		response.setContentType("text/html; charset = UTF-8");
		
		StockServer quotes = new StockServer();
		String price = quotes.getStockPrice(symbol);
		PrintWriter out = response.getWriter();
		
		if(price != null) {
			
			out.println("<html><body bgcolor = red>");
			out.println("<h2>The symbol:  " + symbol + " costs: " + price + "</h2>");
			//out.println("<p>Please insert your credic card number</p>");
			out.println("</body></html>");
		
		} else  {
			out.println("<html><body bgcolor = red>");
			out.println("<h2>The symbol not found. </h2>");
			out.println("<p>Please insert correct symbol</p>");
			out.println("</body></html>");
		}
		
	
		
		
		
		//Destroy the session 
		request.getSession(true).invalidate();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
