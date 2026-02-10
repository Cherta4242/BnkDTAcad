<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>P4 page</h1>
	<hr>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String[] hobby = request.getParameterValues("hobby");
		String gen = request.getParameter("gen");
		String color = request.getParameter("user_color");
		String oneanswer = request.getParameter("oneanswer");
	%>
	<h3>ID: <%= id%></h3>
	<h3>PW: <%= pw%></h3>
	<h3>취미: 
		<%
			if(hobby != null){
				for(String h:hobby){
					out.print(h + " ");
				}
			}else{
				out.print("선택한 취미 없음");
			}
		%>
	</h3>
	<h3>성별: <%= gen%></h3>
	<h3>좋아하는 색: <%= color%></h3>
	<h3>당신의 한마디: <%= oneanswer %></h3>
</body>
</html>