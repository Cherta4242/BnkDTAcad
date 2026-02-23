<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>All things from Regi's Form</h1>
	<hr>
	
	<!-- 방법 1. form을 사용하지 않고 XMLHttpRequest를 사용하여 id, pw를 DB에 넣기.
	--------------------------------------------------------------------------------- 
	<input type="text" id="id" placeholder="id"><br>
	<input type="text" id="pw" placeholder="pw"><br>
	<button type="button" onclick="registUser()">등록</button>
	<div id="result"></div>
	 -->
	 
	<!-- 방법 2. form을 사용하기
	---------------------------------------------------------------------------------
	<form id="frm">
		<input type="text" id="id" placeholder="id"><br>
		<input type="text" id="pw" placeholder="pw"><br>
		<button type="button" onclick="sendForm()">등록</button>
	</form>
	<div id="result"></div>
	 -->
	 
	 <!-- 방법 3. Json을 사용하기
	 --------------------------------------------------------------------------------
	 -->
	<input type="text" id="id" placeholder="id"><br>
	<input type="text" id="pw" placeholder="pw"><br>
	<button type="button" onclick="sendJson()">등록</button>
	<div id="result"></div>	
	
	
	<script>
		// 변수 선언
		const result = document.getElementById("result");
		const id = document.getElementById("id");
		const pw = document.getElementById("pw");
		
		// button에 클릭이벤트를 주려고 만든 함수
		function registUser(){
			// 버튼클릭 이벤트가 실행됐을 시 "registUser...." 라는 알림이 뜨게 함
			alert("registUser....")
			// dendData라는 변수를 선언하고, id, pw의 값들을 id=..&pw=.. 형식으로 담음
			const sendData = "id=" + id.value + "&pw=" + pw.value;
			// 전송하기 전에 id와 pw의 값을 확인하기 위한 알림이 뜨게 함
			alert(sendData);
			
			// 서버랑 통신
			// 서버와 비동기 통신을 하기 위한 객체 생성
			const xhr = new XMLHttpRequest();
			// 서버에서 응답을 보내면 자동으로 실행되는 콜백 함수
			xhr.onload = function(){
				result.textContent = xhr.responseText;		// id가 result인 div의 데이터는 서버에서 보낸 xhr.responseText를 출력
			}
			// regiUser라는 URL에 POST방식으로 요청 준비
			xhr.open("POST", "regiUser");
			// 서버에 이 데이터는 form 형식이라는 것을 알려주는것(때문에 위에서 "id=" + id.value + "&pw=" + pw.value를 sendData에 준비함)
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			// 이전에 설정한 모든 xhr들과 함께 sendData를 포함하여 서버에 전송
			xhr.send(sendData);
		}
		
		// button에 클릭이벤트를 주려고 만든 함수
		function sendForm(){
			// frm이라는 아이디를 가진 form의 값들을 받아옴
			const form = document.getElementById("frm");
			// form 안에 있는 입력값들을 묶어서 JSON형식으로 보냄
			const formData = new FormData(form);
			
			// 그냥 중간 확인
			console.log(formData)
			// regiUser 라는 URL로 formData를 POST방식으로 요청을 보내기
			fetch("regiUser", {
				method: "POST",
				body: formData
			})
			.then(res => res.text())		// 서버가 보낸 응답을 받음(Lamda형식으로 작성 -> 즉, return은 res.text()라는 것)
			.then(data => {					// 서버 응답 문자열을 화면에 출력 -> id가 result인 div의 데이터는 res.text()의 데이터를 출력
				result.textContent = data;	// id가 result라는 것은 const result = document.getElementById("result");를 사용했기 때문에
			});
			// 이렇게 까지가 버튼 클릭이벤트 함수
		}	
		
		// button에 클릭이벤트를 주려고 만든 함수
		function sendJson(){
			
			//전송할 데이터
			const obj = {
				id: id.value,		// input에 적은 id를 전송
				pw: pw.value		// input에 적은 pw를 전송
			};
			// 서버와 비동기 통신을 하기 위한 객체 생성
			const xhr = new XMLHttpRequest();
			// 서버에서 응답응ㄹ 보내면 자동으로 실행되는 콜백 함수(때문에 xhr은 비동기 통신을 사용)
			xhr.onload = function(){
				result.textContent = xhr.responseText;			// 서버에서 받은 응답인 xhr.responseText를 id가 result인 div에 출력
			};
			// 이름이 regiUser인 URL을 가진 서버에 POST방식으로 요청 준비
			xhr.open("POST", "regiUser");			
			// JSON형식이라는 것을 알려주는 것
			xhr.setRequestHeader("Content-type", "application/json");
			// 이전까지 했던 설정들과 obj를 문자형식으로 변환하여 서버에 요청
			xhr.send(JSON.stringify(obj));
		}
	</script>
</body>
</html>