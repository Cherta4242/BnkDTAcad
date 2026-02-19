<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Test Page</h1>
<hr>
<a href="getJson">JSON 데이터 요청하기</a>
<hr>
<button onclick="getJson()">JSON 데이터 요청하기(Ajax)</button>
<div id="result"></div>
<hr>
<!-- 
<form action="getJson">
<input name="no" placeholder="번호를 입력해주세요">
<input name="id" placeholder="아이디를 입력해주세요">
<input name="name" placeholder="이름을 입력해주세요">
<button onclick="getJson2()">입력한 데이터 요청하기</button>
</form>
 -->
<button onclick="getJson2()">이름을 David로!</button>
<div id="result2"></div>
<hr>
<input type="text" id="login" placeholder="id입력">
<button onclick="getJson3()">중복확인</button>
<br>
<div id="result3"></div>


<script>
	const result = document.getElementById("result");
	function getJson(){
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			const user = JSON.parse(xhr.responseText);
			console.log(user);
			result.textContent = user.no + ", " + user.id + ", " + user.name;
		}
		xhr.open("GET", "getJson");
		xhr.send();
	}
	
	const result2 = document.getElementById("result2");
	function getJson2(){
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			const user = JSON.parse(xhr.responseText);
			console.log(user);
			result2.textContent = user.no + ", " + user.id + ", " + user.name;
		}
		xhr.open("GET", "getJson?name=David");
		xhr.send();
	}
	
	const id = document.querySelector("#login");
	const result3 = document.getElementById("result3");
	function getJson3(){
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
			result3.textContent = xhr.responseText;
		}
		console.log(id.value);
		xhr.open("GET", "getJson?id="+ id.value);
		xhr.send();
	}
</script>

</body>
</html>