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

//������� ������� ��� � ����� "/HelloWorldServlet" �����
@WebServlet("/HelloWorldServlet") 

//����������� �� ��������� � ����� ������� ��� ��������� ������ ����� � ������.
public class HelloWorldServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	
	//������� ��������� ������ ����, ������ ����� ����� �������� ����� �������� Context.lookup
	@EJB MyBean bean; 

	//��������� ��������� get �������.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�������� ��� ������ �� ������������� ����
		String clientString = bean.sayHello();
		
		//�������� ������������ �� ������ (response)
		//��� ������������� �� ������ ������ ��������� ������ ����� ������ ���������. � ������ ������ ����� ��� �� ������
		PrintWriter out = response.getWriter();
		
		//�������� ���� ������
		//����� ����� ������� response.getWriter().println(bean.sayHello());
		out.println(clientString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//�� ��������� ���� ������� �������� ��� ������.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
