package Client;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.StockServerBean;

/**
 * Servlet implementation class StockServerServlet
 */
@WebServlet("/getQuotes")
public class StockServerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB StockServerBean myServer; 
	
	
    public StockServerServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String symbol = request.getParameter("symbol");
		myServer.getQuotes(symbol);
		
		
	}

	/**
	 * @param Принимает запрос и ответ сервлета.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	


}
