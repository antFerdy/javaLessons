<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	Enter the ticker:
				<form method = get>
					<input type = Text name = symbol>
					<input type = Submit value = Search> 
				</form>
    <jsp:useBean id="server" class="defaultPackage.StockServer" /> 
    <jsp:setProperty property="*" name="server"/>
	<p>The price is <%=server.getPrice() %>
    
    
	
	
	
	
	
	
	<%-- StockServer st = new StockServer();
		out.println(st.getStockPrice(request.getParameter("symbol")));
		<jsp:useBean id="server" class="java.lesson28part3.src.StockServer"></jsp:useBean>
  	<jsp:setProperty property="symbol" name="StockServer" value = <%=request.getParameter("symbol") %>/>
		
		+ server.getPrice() 
		
		
		<% if(request.getParameter("symbol") != null) out.println("The symbol's: " +  request.getParameter("symbol") +  " price is: " 
    + server.getPrice()	);%>
    
        

    
	--%>
	
	
</body>
</html>