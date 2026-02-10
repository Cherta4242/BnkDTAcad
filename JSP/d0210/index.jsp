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
	<hr>
	<h2>p4 페이지에 회원가입 정보 넘겨주기</h2>
	<form action="p4.jsp">
		<!-- ID & PW 입력 -->
		<input name="id" type="text" placeholder="Id를 입력해주세요"><br>
		<input name="pw" type="text" placeholder="Pw를 입력해주세요"><br><br>
		<!-- 취미 입력 -->
		<input name="hobby" type="checkbox" value="게임">게임<br>
		<input name="hobby" type="checkbox" value="체스">체스<br>
		<input name="hobby" type="checkbox" value="코딩">코딩<br><br>
		<!-- 성별 입력 -->
		<input name="gen" type="radio" value="남자">남자<br>
		<input name="gen" type="radio" value="여자">여자<br>
		<br>
		<!-- 좋아하는 색 입력 -->
		<label for="user_color">좋아하는 색</label><br>
		<select id="user_color" name="user_color">
			<option vlaue="red">Red</option>
			<option vlaue="blue">Blue</option>
			<option vlaue="Green">Green</option>
		</select>
		<br><br>
		<!-- 유저의 한마디 -->
		<h4>한마디</h4>
		<textarea rows="8" cols="25" name="oneanswer"></textarea>
		<!-- 확인 버튼 -->
		<input type="submit" value="확인">
		<hr>
		<h1>Test 페이지 작성</h1>
		<!-- arraylist를 만들고 사람이름 5명을 테이블로 출력하기  -->
		<a href="test1.jsp">Test1 페이지로 이동</a>
		<br>
		<!-- 이름을 입력할 때마다 값이 증가하고 테이블이 추가되는 화면 출력 -->
		<a href="test0.jsp">Test0 페이지로 이동</a>
		
	</form>
</body>
</html>