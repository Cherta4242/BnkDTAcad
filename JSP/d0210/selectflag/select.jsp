<%@page import="domain.Count"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Count ct = (Count)session.getAttribute("count");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%
	int cnt = Integer.parseInt(request.getParameter("cnt"));
	String portugal = request.getParameter("portugal");
	if(portugal.equals("포르투갈")){
		ct.plusCount();
		cnt = cnt + 1;
	}
	%>
		<h2>맞춘 개수: <%= ct.getCount() %>개 입니다.</h2>
		<h2>맞춘 개수: <%= cnt %>개 입니다.</h2>
</body>
</html>