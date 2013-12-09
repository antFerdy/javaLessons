package com.practicaljava.lesson32.client;


import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practicaljava.lesson32.ejb.MyBean;

/**
 * Servlet implementation class HelloWorldServlet
 */

//Создаем сервлет вот с таким "/HelloWorldServlet" путем
@WebServlet("/HelloWorldServlet") 

//Наследуемся от сервлетов и затем сервлет сам затребует методы дуГет и дуПост.
public class HelloWorldServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	
	//Создаем экземпляр нашего бина, причем можно также находить через контекст Context.lookup
	@EJB MyBean bean; 

	//Описываем обработку get запроса.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Получаем наш стринг из подцепленного бина
		String clientString = bean.sayHello();
		
		//Получаем принтврайтер из ответа (response)
		//При инициализации мы всегда должны указывать откуда брать данный экземпляр. В данном случае берем его из ответа
		PrintWriter out = response.getWriter();
		
		//Принтуем нашу строку
		//Также можно вызвать response.getWriter().println(bean.sayHello());
		out.println(clientString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//На обработку пост запроса вызываем гет запрос.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
