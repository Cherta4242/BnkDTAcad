<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("x", "test_page");
	request.setAttribute("x", "test_requst");
	session.setAttribute("x", "test_session");
	application.setAttribute("x", "test_application");
	String s = "hello";
	
	String msg = request.getParameter("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testContext</title>
</head>
<body>
page: <%= pageContext.getAttribute("x") %><br>
request : <%= request.getAttribute("x") %><br>
session: <%= session.getAttribute("x") %><br>
application: <%= application.getAttribute("x") %><br>
<hr>
? : ${applicationScope.x }<br>
s : <%= s %><br>
s(EL) : ${x }<br>
msg : <%= msg %><br>
msg(EL) : ${param.msg}<br>
</body>
</html>