package com.practicaljava.lesson32.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practicaljava.lesson32.ejb.MessageDrivenBean;
import com.practicaljava.lesson32.ejb.StockServerBean;

@WebServlet("/GetQuotes")
public class GetQuotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public GetQuotes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Context ctx;
		try {
			ctx = new InitialContext();
			
			StockServerBean server = (StockServerBean) ctx.lookup("java:global/Lesson32/StockServerBean");
			MessageDrivenBean client = (MessageDrivenBean) ctx.lookup("java:global/Lesson32/MessageDrivenBean");
			
			String ticker = request.getParameter("symbol");
			server.shareQuotes(ticker);
			
			PrintWriter out = response.getWriter();
			if(client.getText() != null) {
				out.println(client.getText());
			} 
			else { 
				out.println("N/A");
			}
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
