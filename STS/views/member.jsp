<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보관리 페이지</title>
<style>
	#signup{
		border: 1px solid black;
	}
	#login{
		border: 1px solid black;
	}
</style>
</head>
<body>
<h1>회원가입</h1>
<div id="signup">
	<input type="text" id="id" placeholder="insert ID"><button type="button" onclick="checking()">중복확인</button><br>
	<input type="text" id="pw" placeholder="insert PW"><br>
	<input type="text" id="name" placeholder="insert NAME"><br>
	<button type="button" onclick="inserting()">회원가입</button>
</div>
<hr>
<h1>로그인</h1>
<div id="login">
	<input type="text" id="id2" placeholder="check ID">
	<input type="text" id="pw2" placeholder="check PW">
	<button type="button" onclick="login()">로그인</button>
</div>

<script>
	const id = document.getElementById("id");
	const pw = document.getElementById("pw");
	const name = document.getElementById("name");
	const id2 = document.getElementById("id2");
	const pw2 = document.getElementById("pw2");
	
	function checking(){
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			const rs = xhr.responseText;
			alert(rs);
		};
		xhr.open("GET", "/checking?id="+id.value);
		xhr.send();
	};
	
	function inserting(){
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			alert(xhr.responseText);	
		};
		xhr.open("GET", "/insertMb?id="+id.value+"&pw="+pw.value+"&name="+name.value);
		xhr.send();
	};
	
	function login(){
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			alert(xhr.responseText);
		};
		xhr.open("Get", "/login?id="+id2.value+"&pw="+pw2.value);
		xhr.send();
	};
	
</script>

</body>
</html>