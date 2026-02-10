<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! ArrayList<String> al = new ArrayList<String>();%>
	<% 		
		String x = request.getParameter("name");
		al.add(x);
		int i = 1;
	%>
	
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
		</tr>
		<%
		for(String name:al){
		%>	
		<tr>
			<td><%= i %></td>
			<td><%= name %></td>
		</tr>
		<%
		i++;
		}
		%>
		<h3>인원수는 총 <%= al.size()%>명 입니다.</h3>
	</table>
</body>
</html>