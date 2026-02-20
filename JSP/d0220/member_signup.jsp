<%@page import="java.time.LocalDate"%>
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
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
	String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
	String user = "green";
	String pw = "1234";
	
	String today = LocalDate.now().toString();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	
	if(request.getMethod().equals("POST")){
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		if(name == "" || phone == "" || address == "" || grade == "" || city == ""){
%>
			<script>alert("칸을 모두 채워주십시오.");</script>
<%
		}else{
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, pw);
				sql = "INSERT INTO member_tbl_02(custno, custname, phone, address, joindate, grade, city)"
					+ "VALUES(member_seq.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, name);
				pstmt.setString(2, phone);
				pstmt.setString(3, address);
				pstmt.setString(4, grade);
				pstmt.setString(5, city);

				int result = pstmt.executeUpdate();
				
				if(result > 0){
%>					
					<script>alert("등록되었습니다.");</script>
<%				
				}else{
%>					
					<script>alert("등록에 실패하였습니다.")</script>			
<%
				}
				
			}catch(Exception e){
				e.printStackTrace();
%>
				<script>alert("오류발생")</script>
<%
			}			
		}
	}
	try{

		conn = DriverManager.getConnection(url, user, pw);
		sql = "SELECT NVL(MAX(custno),0) + 1 AS max_custno FROM member_tbl_02";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			int no = rs.getInt("max_custno");
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
	<section id="member_signup_section">
		<div class="titling"><h3>홈쇼핑 회원등록</h3></div>
		<div id="member_register">
			<form id="member_signup_form" method="POST">
				<table>
					<tr>
						<td>회원번호(자동 발생)</td>
						<td><input type="text" value="<%= no %>"></td>
					</tr>
					<tr>
						<td>회원성명</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>회원전화</td>
						<td><input type="text" name="phone"></td>
					</tr>
					<tr>
						<td>회원주소</td>
						<td><input type="text" name="address"></td>
					</tr>
					<tr>
						<td>가입일자</td>
						<td><input type="text" value="<%= today %>"></td>
					</tr>
					<tr>
						<td>고객등급[A:VIP, B:일반, C:직원]</td>
						<td><input type="text" name="grade"></td>
					</tr>
					<tr>
						<td>도시코드</td>
						<td><input type="text" name="city"></td>
					</tr>
					<tr>
						<td colspan="2"><button type="submit" name="action" value="signup">등록</button><button type="button" onclick="linked()">조회</button></td>
					</tr>
				</table>
			</form>
		</div>
<%
		}
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
	
	<script>
		function linked(){
			location.href="member_search.jsp";
		}
	</script>
</body>
</html>