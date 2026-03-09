<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
<%@ include file="header.jsp" %>

<section id="login_section">
	<h3>ID 입력</h3>
	<input type="text" id="mbid" placeholder="id를 입력해주세요.">
	<h3>Pass Word 입력</h3>
	<input type="text" id="mbpw" placeholder="pw를 입력해주세요.">
	<div id="login_btn" onclick="jjwLogin()">로그인</div>
</section>

<%@ include file="footer.jsp" %>

<script>
	function jjwLogin(){
	    const id = document.getElementById("mbid").value;
	    const pw = document.getElementById("mbpw").value;

	    const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			if(xhr.responseText === "로그인 성공"){
				alert("로그인 성공");
				location.href = "index.jsp";
			}else{
				alert("아이디 또는 비밀번호가 틀립니다.");
			}
		};
	    xhr.open("POST", "LoginServlet");
	    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

	    xhr.send("mbid=" + encodeURIComponent(id) + "&mbpw=" + encodeURIComponent(pw));
	}
</script>
</body>
</html>