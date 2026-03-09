<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/header.css">
<header>
	<div id="header_title">
		<h1><a href="index.jsp">JJW Board</a></h1>
	</div>
	<div id="header_menu">
		<%
		String loginName = (String)session.getAttribute("loginName");
		String loginId = (String)session.getAttribute("loginId");
		String loginPw = (String)session.getAttribute("loginPw");
		%>
		<ul id="header_lgsg">
		<%
		if(loginName == null){
		%>
			<li><a href="login.jsp">로그인</a></li>
			<li>/</li>
			<li><a href="signup.jsp">회원가입</a></li>
		<%
		}else{
		%>
			<li><%=loginName%>님</li>
			<li>/</li>
			<li><a href="modify.jsp">내정보수정</a></li>
			<li>/</li>
			<li><a href="LogoutServlet" onclick="return confirm('로그아웃 하시겠습니까?')">로그아웃</a></li>
		<%
		}
		%>
		</ul>
		<ul id="header_menu_three">
<%			if(loginName == null){	%>
				<li><a href="show.jsp"><b>목록보기</b></a></li>
				<li>/</li>
				<li><a href="#"><b>그냥 페이지</b></a></li>
<%			}else{%>
				<li><a href="show.jsp"><b>목록보기</b></a></li>
				<li>/</li>
				<li><a href="write.jsp"><b>등록하기</b></a></li>
				<li>/</li>
				<li><a href="#"><b>그냥 페이지</b></a></li>
<% 			}%>
		</ul>
	</div>
</header>