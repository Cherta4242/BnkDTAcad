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
	<section id="member_money_section">
		<div class="titling"><h3>회원매출조회</h3></div>
		<div id="member_revenue">
			<table>
				<tr>
					<td style="width: 90px">회원번호</td>
					<td style="width: 90px">회원성명</td>
					<td style="width: 100px">고객등급</td>
					<td style="width: 100px">매출</td>
				</tr>
			</table>
		</div>
	</section>
	<footer>
		<div>
			<p>HRDKOREA Copyright ⓒ 2026-02-20 수업내용입니다.</p>
		</div>
	</footer>
</body>
</html>