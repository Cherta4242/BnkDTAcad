<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login_Page</title>
<style>
	body{
		margin: 0 auto
	}
	.login_page{
		border: 1px solid black;
		margin: 0 auto;
		margin-top: 200px;
		width: 400px;
		height: 400px;
		padding-top: 50px;
		text-align: center;
	}
	button{
		margin-top: 30px;
	}
</style>
</head>
<body>
	<div class="login_page">
		<form action="login_process.jsp" method="post">
		    <h3>아이디를 입력해주세요</h3>
		    <input type="text" name="username"><br>
		    <h3>비밀번호를 입력해주세요</h3>
		    <input type="password" name="password"><br>
		    <button type="submit">확인</button>
		</form>
	</div>
</body>
</html>