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
	<%
	

	int cnt = Integer.parseInt(request.getParameter("cnt"));
	String korea = request.getParameter("korea");
	if(korea.equals("대한민국")){
		ct.plusCount();
		cnt = cnt + 1;
	}
	
	
	%>
	<form action="selectbrazil.jsp?">
		<div>
			<img src="img/japan.png" value="japan"><br>
		    <input type="hidden" name="cnt" value="<%= cnt %>">
			<input type="text" placeholder="이 국기의 나라의 이름은?" name="japan"><br>
		</div>
		<input type="submit" value="확인">	
	</form>
	
	
</body>
</html>