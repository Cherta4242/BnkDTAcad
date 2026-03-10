<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>P4 Page</h1>
<hr>
<%
	session.setAttribute("username", "Edge");
%>
<a href="p5.jsp">p5</a>
</body>
</html>