<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//pageContext.setAttribute("name", "James");
	request.setAttribute("name", "Ann");
	//session.setAttribute("name", "Khan");
	//application.setAttribute("name", "David");
	
	request.getRequestDispatcher("p2.jsp").forward(request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>p1 page</title>
</head>
<body>
<h1>P1 page</h1>
<hr>
name : ${name }<br>
<hr>
<a href="p2.jsp">Go p2~~</a>
</body>
</html>