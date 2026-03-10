<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Test Page</h1>
<hr>
<%
	String scheme = request.getScheme();
	String serverName = request.getServerName();
	int port = request.getServerPort();
	String uri = request.getRequestURI();
	String conPath = request.getContextPath();
	String queryString = request.getQueryString();
%>
<ul>
	<li><%= scheme %></li>
	<li><%= serverName %></li>
	<li><%= port %></li>	
	<li><%= conPath %></li>
	<li><%= uri.substring(5) %></li>
	<li><%= queryString %></li>
</ul>
<a href="a">A</a>
<a href="b">B</a>
<a href="c">C</a>
</body>
</html>