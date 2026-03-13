<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기 페이지!</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<%@ include file="header.jsp" %>

<section id="view_section">
	<div class="view_page">
		<div class="title_name">
			<div class="title">
				제목: ${dto.jbbtitle}
			</div>
			<div class="name">
				작성자: ${dto.jbname}
			</div>		
		</div>
		<div class="content">
			${dto.jbbcontent}
		</div>
	</div>
	
</section>


</body>
</html>