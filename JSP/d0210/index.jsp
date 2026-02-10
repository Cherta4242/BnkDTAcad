<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page</h1>
	<hr>
	<a href=p1.jsp?x=1&y=2>p1 페이지로 이동</a>
	<hr>
	<h2>p2페이지에 값 넘기기</h2>
	<form action="p2.jsp" method="get">
	<input name="name" type="text" placeholder="input data...."><br>
	<input type="submit" value="제출">
	</form>
	<hr>
	<h2>p3 페이지에 로그인하기</h2>
	<form action="p3.jsp">
	<input name="id" type="text" placeholder="Id를 입력해주세요"><br>
	<input name="pw" type="text" placeholder="Pw를 입력해주세요"><br>
	<input type="submit" value="확인">
	</form>
</body>
</html>
