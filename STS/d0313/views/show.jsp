<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Page!</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<%@ include file="header.jsp" %>

<section id="show_section">
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="b" items="${list}" varStatus="s">
			<tr onclick="location.href='/view?jbbno=${b.jbbno}'">
				<td><b>${s.count }</b></td>
				<td>${b.jbbtitle }</td>
				<td>${b.jbname }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</section>

</body>
</html>