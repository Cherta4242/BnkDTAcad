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
<title>Insert title here</title>
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
	
	try{
		// 드라이버 loading
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// DB 연결
		conn = DriverManager.getConnection(url, user, pw);
		// SQL 작성
		String sql = "SELECT m.*, TO_CHAR(joindate, 'YYYY-MM-DD') AS joindate_str FROM member_tbl_02 m";
		// SQL 실행
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
	
%>

	<header>
		<h2>쇼핑몰 회원관리 ver1.0</h2>
	</header>
	<nav>
		<div><a href="member_signup.jsp">회원등록</a></div>
		<div><a href="member_search.jsp">회원목록조회/수정</a></div>
		<div><a href="member_money.jsp">회원매출조회</a></div>
		<div><a href="index.jsp">홈으로</a></div>
	</nav>
	<section id="member_search_section">
		<div class="titling"><h3>회원목록 조회/수정 </h3></div>
		<div id="member_search_change_section">
			<table>
				<tr>
					<td>회원번호</td>
					<td>회원성명</td>
					<td style="width: 170px">전화번호</td>
					<td class="addressing">주소</td>
					<td style="width: 170px">가입일자</td>
					<td>고객등급</td>
					<td>거주지역</td>
				</tr>
				<%
					while(rs.next()){
				%>
				<tr>
					<td><a href="member_modify.jsp"><%= rs.getInt("custno") %></a></td>
					<td><%= rs.getString("custname") %></td>
					<td><%= rs.getString("phone") %></td>
					<td><%= rs.getString("address") %></td>
					<td><%= rs.getString("joindate_str") %></td>
					<td><%= rs.getString("grade") %></td>
					<td><%= rs.getString("city") %></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
<%
	}catch(Exception e){
		e.printStackTrace();
	}finally{
	    if(rs != null) rs.close();
	    if(pstmt != null) pstmt.close();
	    if(conn != null) conn.close();
	}
%>
	</section>
	<footer>
		<div>
			<p>HRDKOREA Copyright ⓒ 2026-02-20 수업내용입니다.</p>
		</div>
	</footer>
</body>
</html>