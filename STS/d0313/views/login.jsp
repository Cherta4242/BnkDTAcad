<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<%@ include file="header.jsp"%>

<section id="login_section">
	<form action="/login" method="POST">
		<h3>아이디를 입력해주세요.</h3>
		<input type="text" name="jbid" id="login_jbid" placeholder="Insert your ID!"><br>
		<h3>비밀번호를 입력해주세요.</h3>
		<input type="password" name="jbpw" id="login_jbpw" placeholder="Insert your PW!"><br><br>
		<button type="submit">로그인</button>
	</form>
	
</section>

<script>
	const msg = "${loginmsg}";
	
	if(msg === "no"){
		alert("아이디 또는 비밀번호를 잘못 입력하셨습니다.");
	};
	if(msg === "ok"){
		alert("로그인 성공하셨습니다.");
		location.href="/";
	};
	
</script>
</body>
</html>