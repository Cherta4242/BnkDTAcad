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
<title>게시글 수정</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
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


<%@ include file="header.jsp" %>
	<section id="update_section">
		<h2>수정하기 페이지</h2>
		<div id="update_title_name">
			<div id="update_title">
				<input type="text" id="input_title_update" placeholder="제목을 작성해주세요." value="<%= rs.getString("title") %>">
			</div>
			<div id="update_name">
				<div id="input_name_update"><%= loginName %></div>
			</div>
		</div>
		<div id="update_content">
			<input type="text" id="input_content_update" placeholder="내용을 작성해주세요." value="<%= rs.getString("content") %>">
		</div>
		<div id="input_button_update" onclick="updateBoard()">수정하기</div>
	</section>


<%@ include file="footer.jsp" %>

<script>
	const title = document.getElementById("input_title_update");
	const content = document.getElementById("input_content_update");
	function updateBoard(){
	    const obj = {
	        title: title.value,
	        name: '<%= loginId %>',
	        content: content.value,
	        id: <%= rs.getInt("id") %>
	    	
	    };
	    console.log(obj.id);
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
	        alert(xhr.responseText);
	        location.href = "view.jsp?id=" + <%= rs.getInt("id") %>;
		};
	    
	    xhr.open("POST", "update");
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