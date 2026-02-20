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
					<td>전화번호</td>
					<td class="addressing">주소</td>
					<td>가입일자</td>
					<td>고객등급</td>
					<td>거주지역</td>
				</tr>
				<tr>
					<td><a href="member_modify.jsp"></a></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
			<%
				try{
					Connection conn = DriverManager.getConnection(url, user, pw);
					PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM member_tbl_02");
					pstmt.executeQuery();
				}catch(Exception e){
					e.printStackTrace();
				}
				
			%>
		</div>
		
	</section>
	<footer>
		<div>
			<p>HRDKOREA Copyright ⓒ 2026-02-20 수업내용입니다.</p>
		</div>
	</footer>
</body>
</html>