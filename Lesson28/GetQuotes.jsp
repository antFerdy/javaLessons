<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>GlassFish JSP Page</title>
  </head>
  <body>
   Enter the ticker:
				<form method = get>
					<input type = Text name = symbol>
					<input type = Submit value = Search> 
				</form>
    
	<%@ page import="def.src.StockServer"  %>
	
	<%! 
    	StockServer st = new StockServer(); 
    	String ticker;
    	String price;
    %>
    
   	<%
    	ticker = request.getParameter("symbol");
    	price = st.getStockPrice(ticker);
    	if(price == null) {
    		
    %><p>Please correct your symbol <%= out.println(ticker) %></p>
    
    <%} else { %>
     		<p>Your <%= out.println(ticker) %> price is: <%= out.println(price) %></p>
    <%}%>
    
    
  </body>
</html> 
