<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="css/signup.css">
</head>
<body>
<%@ include file="header.jsp" %>

<section id="signup_section">
	<h3>ID 입력</h3>
	<input type="text" id="id" placeholder="사용하실 id를 입력해주세요.">
	<h3>Pass Word 입력</h3>
	<input type="text" id="pw" placeholder="사용하실 pw를 입력해주세요.">
	<h3>Name 입력</h3>
	<input type="text" id="name" placeholder="사용하실 이름을 입력해주세요.">
	<div id="signup_btn" onclick="signup()">회원가입하기</div>
</section>

<%@ include file="footer.jsp" %>

<script>
	function signup(){
		const id = document.getElementById("id");
		const pw = document.getElementById("pw");
		const name = document.getElementById("name");
		
		const obj = {
			id: id.value,
			pw: pw.value,
			name: name.value
		};
		
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			alert(xhr.responseText);
			location.href = "login.jsp";
		};
		xhr.open("POST", "SignupServlet");
	    xhr.setRequestHeader("Content-Type", "application/json");
		xhr.send(JSON.stringify(obj));
	}
</script>
</body>
</html>