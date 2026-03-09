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
<title>상세보기 페이지</title>
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
	String sql = "SELECT jb.id, jm.name AS mbid, jb.title AS title, jb.content AS content "
				+ "FROM jjw_board jb "
				+ "JOIN jjw_member jm ON jb.mbid = jm.mbid "
				+ "WHERE jb.id = ?";
	
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
				작성자: <b><%= rs.getString("mbid") %></b>
			</div>
		</div>
		<div id="view_content">
			<%= rs.getString("content") %>
		</div>
		<div id="view_update_delete">
		<% if(rs.getString("mbid").equals(loginName)){%>
			<a href="update.jsp?id=<%= id %>" id="view_update">수정하기</a>
			<div id="view_delete" onclick="deleting()">삭제하기</div>	
		<%} else{}%>
		</div>
	</section>

	<%@ include file="footer.jsp" %>
	
<script>
	function deleting(){
	    const obj = {
	        id: <%= id %>
	    };
	    console.log(obj.id);
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
	        alert(xhr.responseText);
	        location.href = "show.jsp";
		};
	    
	    xhr.open("POST", "DeleteServlet");
	    xhr.setRequestHeader("Content-Type", "application/json");
	    xhr.send(JSON.stringify(obj));
	}

</script>

<%
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
%>
</body>
</html>