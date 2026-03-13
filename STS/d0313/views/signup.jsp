<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp Page</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<%@ include file="header.jsp"%>

<section id="signup_section">
	<form action="/signup" method="POST">
		<h3>사용하실 아이디를 입력해주세요.</h3>
		<input type="text" name="jbid" id="signup_jbid" placeholder="Insert Id to you want!"><br>
		<h3>사용하실 패스워드를 입력해주세요.</h3>
		<input type="password" name="jbpw" id="signup_jbpw" placeholder="Insert Pw to you want!"><br>
		<h3>사용하실 이름을 입력해주세요.</h3>
		<input type="text" name="jbname" id="signup_jbname" placeholder="Insert Name to you want!"><br><br>
		<button type="submit">회원가입</button>
	</form>
	
	
</section>

<script>
	const msg = "${signupmsg}";
	
	if(msg === "no"){
		alert("이미 있는 아이디입니다.");
	};
	if(msg === "ok"){
		if(confirm("회원가입 성공! 로그인하시겠습니까?")){
			location.href="/lgpage";
		}else{
			alert("메인페이지로 돌아가겠습니다.");
			location.href="/";
		}
	};
</script>
</body>
</html>