<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>P2 page</h1>
	<hr>
	<%
		String name = request.getParameter("name");
	%>
	<h2>안녕하세요 <%= name %>님!</h2>
</body>
</html>