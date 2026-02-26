<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Select Page</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h1>서버구축, 사용자 등록, 조회 구현하기</h1>
	<hr>
	<table>
		<tr>
			<td>아이디 입력하기</td>
			<td>
				<input type="text" placeholder="사용하실 ID를 입력하세요" id="id">
			</td>
		</tr>
		<tr>
			<td>비밀번호 입력하기</td>
			<td>
				<input type="text" placeholder="사용하실 비밀번호를 입력하세요" id="pw">
			</td>
		</tr>
		<tr>
			<td>닉네임 입력하기</td>
			<td>
				<input type="text" placeholder="사용하실 닉네임을 입력하세요" id="nickname">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" onclick="inserting()">등록하기</button>
			</td>
		</tr>
		<tr>
			<td>등록 결과</td>
			<td><div id="tf"></div></td>
		</tr>
	</table>
	
	<table>
		<tr>
			<td><button type="button" onclick="showing()">목록조회</button></td>
		</tr>
	</table>
	
	<script>
		const id = document.getElementById("id");
		const pw = document.getElementById("pw");
		const nickname = document.getElementById("nickname");
		const tf = document.getElementById("tf");
		
		function inserting(){
			const obj = {
					id: id.value,
					pw: pw.value,
					nickname: nickname.value
			};
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
				tf.textContent = xhr.responseText;
			};
			xhr.open("POST", "MemberInsert");
			xhr.setRequestHeader("Content-type", "application/json")
			xhr.send(JSON.stringify(obj));
		}
		
		
		function showing(){
			console.log("하잉");
			const xhr = new XMLHttpRequest();
			xhr.onload = function(){
			};
			xhr.open("GET", "MemberShow?name=건엽");
			xhr.send()
		}
	</script>
</body>
</html>