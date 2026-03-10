<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Learning Page!</title>
</head>
<body>
<h1>P3 Page(Session 연습)</h1>
<hr>
<%
	session.setAttribute("username", "chrome");
%>
<a href="p4.jsp">p4</a>
</body>
</html>