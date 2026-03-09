<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 만들기 2</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<section id="index_section">
		<h2>메인페이지</h2>
		<div id="index_title">
			<h1>반갑습니다! JJW BOARD에 접속하신 당신을 환영합니다!</h1>
		</div>
		<div id="index_content">
			<div id="index_content_title">
				<h3>만들고 있는 것들을 적어보겠습니다.</h3>
			</div>
			<ol>
				<li>화면헤더: header.jsp</li>
				<li>메인화면: index.jsp</li>
				<li>목록화면: show.jsp</li>
				<li>귀찮으니까 그만 적을게요</li>
			</ol>
		</div>
	</section>
	
	<%@ include file="footer.jsp" %>
</body>
</html>