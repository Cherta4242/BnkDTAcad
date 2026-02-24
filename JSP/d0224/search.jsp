<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show member page!</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

	<header>
		<div id="header_menu">
			<ul>
				<li><a href="index.jsp">전체목록</a></li>
				<li>/</li>
				<li><a href="signup.jsp">등록</a></li>
				<li>/</li>
				<li><a href="search.jsp">검색조회</a></li>
			</ul>
		</div>
	</header>
	<section>
		<div id="section_view">
			<div id="search_section_view">
				<input type="text" id="search_section" placeholder="검색하실 이름을 적어주세요!">
				<button type="button" id="lets_search">검색하기</button>			
			</div>
			<table>
				<tr>
					<th style="width: 200px">가입 번호</th>	
					<th style="width: 200px">이름</th>
					<th style="width: 200px">휴대전화 번호</th>					
				</tr>
			</table>
			
		</div>
	</section>

</body>
</html>