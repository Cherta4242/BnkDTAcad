<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<h1>Login Page!</h1>
<hr>
<input type="text" id="id" placeholder="Insert your Id">
<input type="text" id="pw" placeholder="Insert your Pw">
<button type="button">로그인 하기</button>

<script>
	const id = document.getElementById("id");
	const pw = document.getElementById("pw");
	
	function signup(){
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			alert(xhr.responseText);
		}
		
		xhr.open("GET", "login?" + id + "&pw=" + pw);
		xhr.send();
	}
	
</script>
</body>
</html>