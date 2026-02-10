<%@page import="domain.Count"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Count ct = (Count)session.getAttribute("count");

if(ct == null){
    ct = new Count();
    session.setAttribute("count", ct);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
img{
	width: 300px;
}
</style>
</head>
<body>
	<form action="selectjapan.jsp?">
		<div>
			<img src="img/korea.png" value="korea"><br>
   			<input type="hidden" name="cnt" value="0">
			<input type="text" placeholder="이 국기의 나라의 이름은?" name="korea"><br>
		</div>
		<input type="submit" value="확인">	
	</form>
</body>
</html>