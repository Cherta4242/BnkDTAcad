<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
<h1>SignUp Page!</h1>
<hr>
<input type="text" id="id" placeholder="Insert use Id">
<input type="text" id="pw" placeholder="Insert use Pw">
<input type="text" id="name" placeholder="Insert use Name">
<button type="button" onclick="signup()">회원가입하기</button>

<script>
	const id = document.getElementById("id");
	const pw = document.getElementById("pw");
	const name = document.getElementById("name");
	
	function signup(){
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			alert(xhr.responseText);
		}
		
		xhr.open("GET", "signup?" + id + "&pw=" + pw + "&name=" + name);
		xhr.send();
	}
	
</script>

</body>
</html>