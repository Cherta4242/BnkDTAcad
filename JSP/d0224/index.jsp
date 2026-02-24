<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show member page!</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>
<%
	String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
	String user = "green";
	String pwd = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	
	try{
		// 드라이버 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// DB 연결
		conn = DriverManager.getConnection(url, user, pwd);
		// DB 작성
		String sql = "SELECT * FROM viewing";
		// DB 실행
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
%>
	<header>
		<div id="header_menu">
			<ul>
				<li><a href="index.jsp">전체목록</a></li>
				<li>/</li>
				<li><a href="signup.jsp">등록</a></li>
				<li>/</li>
				<li><a href="search.jsp">검색조회</a></li>
			</ul>
		</div>
	</header>
	<section>
		<div id="section_view">
			<table>
				<tr>
					<th style="width: 200px">가입 번호</th>	
					<th style="width: 200px">이름</th>
					<th style="width: 200px">휴대전화 번호</th>					
				</tr>
				<% while(rs.next()){%>
				<tr>
					<td><%= rs.getInt("veno")%></td>
					<td><%= rs.getString("vename")%></td>
					<td><%= rs.getString("veph")%></td>
				</tr>				
				<%}%>
			</table>
			
<%
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) pstmt.close();
		}
%>
		</div>
	</section>

</body>
</html>