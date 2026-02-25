<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문등록</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
    Date today = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String orderDate = sdf.format(today);
%>

	<header>
		<div id="header_view">
			<h1>할인점 주문프로그램 ver 1.0</h1>
		</div>
		<div id="header_menu">
			<div id="header_menu_view">
				<ul>
					<li><a href="order.jsp">주문등록</a></li>
					<li><a href="orderview.jsp">주문목록조회</a></li>
					<li><a href="ordershop.jsp">점포별주문현황</a></li>
					<li><a href="ordercode.jsp">제품코드조회</a></li>
					<li><a href="index.jsp">홈으로</a></li>
				</ul>			
			</div>
		</div>
	</header>
	<section id="order_section_view">
		<div id="order_view">
			<h2>주문등록</h2>
			<table>
				<tr>
					<td>주문번호</td>
					<td><input type="text" id="orderno" class="input_text"></td>
				</tr>
				<tr>
					<td>주문점포</td>
					<td>
						<select name="shopname" id="shopname">
							<option value="selected">점포선택</option>
							<option value="S001">AA할인점</option>
							<option value="S002">BB할인점</option>
							<option value="S003">CC할인점</option>
							<option value="S004">DD할인점</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>주문일자</td>
					<td><input type="date" id="orderdate" class="input_text" value="<%= orderDate %>"></td>
				</tr>
				<tr>
					<td>제품코드</td>
					<td>
						<select name="pcode" id="pcode">
							<option value="AAnone">코드선택</option>
							<option value="AA01">AA01</option>
							<option value="AA02">AA02</option>
							<option value="AA03">AA03</option>
							<option value="AA04">AA04</option>
							<option value="AA05">AA05</option>
							<option value="AA06">AA06</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>주문수량</td>
					<td><input type="text" id="amount" class="input_text"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" onclick="insert_order()">주문등록</button>
						<button type="button" onclick="clear_text()">다시쓰기</button>
					</td>
				</tr>
			</table>
			<div id="result">
			</div>
		</div>
	</section>
	
	<script>
		const result = document.getElementById("result");
		const orderno = document.querySelector("#orderno");
		const shopname = document.getElementById("shopname");
		const orderdate = document.getElementById("orderdate");
		const pcode = document.getElementById("pcode");
		const amount = document.getElementById("amount");
		
		function insert_order(){
			if(orderno.value == ''){
				alert("주문번호가 비어있습니다.");
				orderno.focus();
				return;
			}
			if(shopname.value == 'selected'){
				alert("주문점포를 선택해주세요");
				return;
			}
			if(pcode.value == 'AAnone'){
				alert("제품코드를 선택해주세요");
				return;
			}
			if(amount.value == ''){
				alert("수량을 선택해주세요");
				amount.focus();
				return;
			}
			
			const obj = {
				orderno: orderno.value,
				shopname: shopname.value,
				orderdate: orderdate.value,
				pcode: pcode.value,
				amount: amount.value
			};
			
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				result.textContent = xhr.responseText;
			};
			xhr.open("POST", "orderservlet");
			xhr.setRequestHeader("Content-type", "application/json");
			xhr.send(JSON.stringify(obj));
		}
		
		function clear_text(){
			orderno.value = '';
			shopname.value = 'selected';
			orderdate.value = ' ';
			amount.value = ' ';
		}
	</script>
</body>
</html>