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
			<div id="signup_section_view">
				<div class="enter">
					<h3>사용하실 ID를 입력해주세요.</h3>
					<input type="text" id="id" placeholder="What you want use ID?"><br>				
				</div>
				<div class="enter">
					<h3>사용하실 PW를 입력해주세요.</h3>
					<input type="text" id="pw" placeholder="What you wnat use PW?"><br>				
				</div>
				<div class="enter">
					<h3>당신의 이름을 입력해주세요</h3>				
					<input type="text" id="name" placeholder="What is your NAME?"><br>
				</div>
				<div class="enter">
					<h3>당신의 휴대전화 번호를 입력해주세요.</h3>			
					<input type="text" id="ph" placeholder="What is your Phone number"><br>
				</div>
				<button type="button" onclick="sendViewing()">회원 등록</button>
				<div id="result"></div>
			</div>
		</div>
	</section>

	<script>
		// 데이터들 받아오기
		const result = document.getElementById("result");
		const id = document.getElementById("id");
		const pw = document.getElementById("pw");
		const name = document.getElementById("name");
		const ph = document.getElementById("ph");
		
		function sendViewing(){
			// 전송할 데이터
			const obj = {
				id: id.value,
				pw: pw.value,
				name: name.value,
				ph: ph.value
			};
			// 비동기통신용 객체생성
			const xhr = new XMLHttpRequest();
			// 서버에서 응답보내면 실행되는 콜백함수
			xhr.onload = function(){
				result.textContent = xhr.responseText;
			};
			// 서버에 POST방식으로 보냄
			xhr.open("POST", "viewSignUp");
			// JSON형식임을 알려줌
			xhr.setRequestHeader("Content-type", "application/json");
			// 빌드업한거 모두 json형식의 문자열로 변환시키고 보내기.
			xhr.send(JSON.stringify(obj));
		}
	</script>
</body>
</html>