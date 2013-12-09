
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import= "com.java.lesson28.quotes.StockServer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action = http://192.168.1.42:8080/Lesson28/StockQuotes.jsp method = get>
			<input type = Text name = symbol>
			<input type = Submit value = Search> 
	</form>
	
	<%! 
	String symbol;
	String price;
	StockServer st = new StockServer();
	%>
<% 
	
%>

	
</body>
</html>