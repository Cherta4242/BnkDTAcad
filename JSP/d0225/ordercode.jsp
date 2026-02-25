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
<title>주문목록조회</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
	String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
	String user = "green";
	String pw = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String sql = "SELECT pcode, pname, cost, cost/100*90 AS tenP, cost/100*85 AS fifP "
			+ "FROM tbl_product_202101 ";
	try{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, pw);
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
%>
	<header>
		<div id="header_view">
			<h1>할인점 주문프로그램 ver 1.0</h1>
		</div>
		<div id="header_menu">
			<div id="header_menu_view">
				<ul>
					<li><a href="order.jsp">주문등록</a></li>
					<li><a href="orderview.jsp">주문목록조회</a></li>
					<li><a href="ordershop.jsp">점포별주문현황</a></li>
					<li><a href="ordercode.jsp">제품코드조회</a></li>
					<li><a href="index.jsp">홈으로</a></li>
				</ul>			
			</div>
		</div>
	</header>
	<section id="ordercode_view_section">
		<div id="ordercode_view">
			<h2>제품코드조회</h2>
			<table>
				<tr>
					<th>제품코드</th>
					<th>제품명</th>
					<th>단가</th>
					<th>할인률(10%)</th>
					<th>할인율(15%)</th>
				</tr>
				<% while(rs.next()){ %>
				<tr>
					<td><%= rs.getString("pcode") %></td>
					<td><%= rs.getString("pname") %></td>
					<td><%= rs.getString("cost") %></td>
					<td><%= rs.getString("tenP") %></td>
					<td><%= rs.getString("fifP") %></td>
				</tr>
				<% } %>
			</table>
<%
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}

%>
		</div>
	</section>
</body>
</html>