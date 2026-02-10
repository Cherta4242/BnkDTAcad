<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	border: 1px solid black;
	width: 400px;
	height: 400px;
}
th{
	border: 1px solid black;
	background-color: black;
	color: white;
}
.poem{
	border: 1px solid blakc;
}
</style>
</head>
<body>
	<%
		ArrayList<String> al = new ArrayList<String>();
		al.add("장진우");
		al.add("김건엽");
		al.add("허 윤");
		al.add("신정훈");
		al.add("이승규");
		
		int i = 1;
	%>
	
	
	<h1>Test1 page</h1>
	<hr>
	<table>
		<tr class="firstline">
			<th>번호</th>
			<th>이름</th>
		</tr>
		<%
			for(String name:al){
				%><tr class="poem">
					<td><%= i %></td>
					<td><%= name %></td>
					<% i++; %>
				</tr>
				<%
			}%>
	</table>
</body>
</html>