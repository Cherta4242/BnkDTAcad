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
			<form id="member_signup_form">
				<table>
					<tr>
						<td>회원번호(자동 발생)</td>
						<td><input type="text" placeholder="10008"></td>
					</tr>
					<tr>
						<td>회원성명</td>
						<td><input type="text" ></td>
					</tr>
					<tr>
						<td>회원전화</td>
						<td><input type="text" ></td>
					</tr>
					<tr>
						<td>회원주소</td>
						<td><input type="text" ></td>
					</tr>
					<tr>
						<td>가입일자</td>
						<td><input type="text" placeholder="2026/02/20"></td>
					</tr>
					<tr>
						<td>고객등급[A:VIP, B:일반, C:직원]</td>
						<td><input type="text" ></td>
					</tr>
					<tr>
						<td>도시코드</td>
						<td><input type="text" ></td>
					</tr>
					<tr>
						<td colspan="2"><button onclick="access()">등록</button><button onclick="linked()">조회</button></td>
					</tr>
				</table>
			</form>
		</div>
		
		<script>
			function access(){
				
			}
			function linked(){
				
			}
		</script>
	</section>
	<footer>
		<div>
			<p>HRDKOREA Copyright ⓒ 2026-02-20 수업내용입니다.</p>
		</div>
	</footer>
</body>
</html>