<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%@ include file="header.jsp"%>
<%
	String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
	String user = "green";
	String pw = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "SELECT id, title FROM jjw_board";
	int i = 1;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, pw);
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
%>
	<section id="show_section">
		<h2>목록보기 페이지</h2>
		<table>
			<thead>
				<tr>
					<th id="th_num">번호</th>
					<th>제목</th>
				</tr>
			</thead>
			<tbody>
				<% while(rs.next()){%>
				<tr onclick="location.href='view.jsp?id=<%= rs.getInt("id") %>'">
					<td id="td_num"><%= i++ %></td>
					<td><%= rs.getString("title") %></td>
				</tr>
				<% } %>
			</tbody>
			
		</table>
	</section>
	
<%
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}

%>


<%@ include file="footer.jsp" %>
	

	
	
</body>
</html>