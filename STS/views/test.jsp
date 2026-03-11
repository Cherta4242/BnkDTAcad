<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>id name 출력하기</title>
</head>
<body>
<h1>Id, Name 출력하기!</h1>
<hr>
<button onclick="clicking()">누르면 출력되요!</button>
<div id="id">id</div>
<div id="name">name</div>
<script>
	const iddiv = document.getElementById("id");
	const namediv = document.getElementById("name");
</script>

</body>
</html>