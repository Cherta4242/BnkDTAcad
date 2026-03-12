<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OrderShop Page</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<%@ include file="header.jsp" %>
	<h2>주문목록</h2>
	<table>
		<thead>
			<tr>
				<th>할인점코드</th>
				<th>점포명</th>
				<th>주문번호</th>
				<th>주문일자</th>
				<th>제품코드</th>
				<th>제품명</th>
				<th>주문수량</th>
				<th>단가</th>
				<th>소비자 가격</th>
				<th>할인가격</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=  %></td>
				<td><%=  %></td>
				<td><%=  %></td>
				<td><%=  %></td>
				<td><%=  %></td>
				<td><%=  %></td>
				<td><%=  %></td>
				<td><%=  %></td>
				<td><%=  %></td>
			</tr>
		</tbody>
	</table>
</body>
</html>