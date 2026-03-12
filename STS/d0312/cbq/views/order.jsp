<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Page</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<%@ include file="header.jsp" %>
<section id="main_section">
	<h2>주문등록</h2>
	<table>
		<tbody>
			<tr>
				<td>주문번호</td>
				<td><input type="text" id="orderno" placeholder="Insert here order Number!"></td>
			</tr>
			<tr>
				<td>주문점포</td>
				<td>
					<select name="shopname" id="shopno">
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
				<td><input type="text" id="orderdate" placeholder="today!"></td>
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
				<td><input type="text" id="amount" placeholder="Insert here Quantity"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button id="insertOrder" onclick="insert()">주문등록</button>
					<button id="retry" onclick="retry()">다시쓰기</button>
				</td>
			</tr>
		</tbody>
	</table>
</section>

<script>
	const orderno = document.getElementById("orderno");
	const shopno = document.getElementById("shopno");
	const orderdate = document.getElementById("orderdate");
	const pcode = document.getElementById("pcode");
	const amount = document.getElementById("amount");

	function insert(){
		const obj = {
			orderno: orderno.value,
			shopno: shopno.value,
			orderdate: orderdate.value,
			pcode: pcode.value,
			amount: amount.value
		}
		console.log(obj);
		fetch("/orderisrt", {
		    method: "POST",
		    headers: {
		        "Content-Type": "application/json"
		    },
		    body: JSON.stringify(obj)
		})
	    .then(response => response.text())
	    .then(data => {
	        if(data === "ok"){
	            alert("등록 성공");
	        }else{
	        	alert("등록 실패");
	        }
	    });
	};
</script>


</body>
</html>