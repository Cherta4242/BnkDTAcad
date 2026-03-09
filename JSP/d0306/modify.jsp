<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<link rel="stylesheet" href="css/modify.css">
</head>
<body>
<%@ include file="header.jsp" %>

<section id="modify_section">
	<h3>ID는 수정이 불가합니다.</h3>
	<div>
		<%= loginId %>
	</div>
	<h3>수정하실 PassWord를 입력하세요.</h3>
	<input type="text" id="id" value="<%= loginPw %>">
	<h3>수정하실 이름을 입력하세요.</h3>
	<input type="text" id="pw" value="<%= loginName %>">
	<div id="modify_button" onclick="modifyBtn()">수정하기</div>
</section>

<%@ include file="footer.jsp" %>
</body>
</html>