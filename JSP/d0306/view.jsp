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
<title></title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%@ include file="header.jsp" %>
	
<%
	int id = Integer.parseInt(request.getParameter("id")); 
	String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
	String user = "green";
	String pw = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "SELECT * FROM jjw_board WHERE id=?";
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, pw);
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		rs.next();
%>
	<section id="view_section">
		<h2>상세보기 페이지</h2>
		<div id="view_title_name">
			<div id="view_title">
				제목: <b><%= rs.getString("title") %></b>
			</div>
			<div id="view_name">
				작성자: <b><%= rs.getString("name") %></b>
			</div>
		</div>
		<div id="view_content">
			<%= rs.getString("content") %>
		</div>
		<div id="view_update"><a href="update.jsp">수정하기</a></div>
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