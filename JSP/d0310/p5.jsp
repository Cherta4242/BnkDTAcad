<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>P5 Page</title>
</head>
<body>
<h1>P5 Page</h1>
<hr>
<%
	session.removeAttribute("username");
%>
<a href="p6.jsp">p6</a>
</body>
</html>