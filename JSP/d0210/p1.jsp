<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>P1 page!</h1>
	<hr>
	<%
	String x = request.getParameter("x");
	String y = request.getParameter("y");
	// 스크립틀릿(Scriptlet)
		int n1 = 10;
		int n2 = 20;
		int sum = n1 + n2;
		String s = "안녕";
	%>
	<h2><%= n1 + n2 %></h2>
	<h2><%= s %></h2>
	<h2>x = <%= x %></h2>
	<h2>y = <%= y %></h2>
</body>
</html>