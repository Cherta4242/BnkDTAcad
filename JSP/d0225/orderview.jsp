<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
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

	String sql = "SELECT A.shopno AS shopno, B.shopname AS shopname, A.orderno AS orderno,"
				+ "A.orderdate AS orderdate, A.pcode As pcode,"
				+ "C.pname AS pname, A.amount AS amount, C.cost AS cost,"
				+ "A.amount*C.cost AS price,"
				+ "A.amount*C.cost/100*(100-B.discount) AS sale FROM tbl_order_202101 A "
				+ "JOIN tbl_shop_202101 B ON A.shopno = B.shopno "
				+ "JOIN tbl_product_202101 C ON A.pcode = C.pcode "
				+ "ORDER BY A.orderno ASC";
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
	<section id="orderview_view_section">
		<div id="orderview_view">
			<h2>주문목록</h2>
			<table>
				<tr>
					<th>할인점코드</th>
					<th>점포명</th>
					<th>주문번호</th>
					<th>주문일자</th>
					<th>제품코드</th>
					<th>제품명</th>
					<th>주문수량</th>
					<th>단가</th>
					<th>소비자가격</th>
					<th>할인가격</th>
				</tr>
				<% while(rs.next()){ %>
				<tr>
					<td><%= rs.getString("shopno") %></td>
					<td><%= rs.getString("shopname") %></td>
					<td><%= rs.getString("orderno") %></td>
					<td><%= rs.getString("orderdate") %></td>
					<td><%= rs.getString("pcode") %></td>
					<td><%= rs.getString("pname") %></td>
					<td><%= rs.getInt("amount") %></td>
					<td><%= rs.getInt("cost") %></td>
					<td><%= rs.getInt("price") %></td>
					<td><%= rs.getInt("sale") %></td>
				</tr>
				<% } %>
			</table>
			<h3>commit을 습관화합시다.</h3>
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