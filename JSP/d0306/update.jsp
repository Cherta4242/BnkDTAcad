<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>



<%@ include file="header.jsp" %>
	<section id="update_section">
		<h2>수정하기 페이지</h2>
		<div id="update_title_name">
			<div id="update_title">
				<input type="text" id="input_title_update" placeholder="제목을 작성해주세요.">
			</div>
			<div id="update_name">
				<input type="text" id="input_name_update" placeholder="작성자 이름">
			</div>
		</div>
		<div id="update_content">
			<input type="text" id="input_content_update" placeholder="내용을 작성해주세요.">
		</div>
		<div id="update_button_div" onclick="updateBoard()">등록하기</div>
	</section>


<%@ include file="footer.jsp" %>

<input type="text" value="<% %>">
<script>
	const title = document.getElementById("input_title_update");
	const name = document.getElementById("input_name_update");
	const content = document.getElementById("input_content_update");
	function updateBoard(){
	    const obj = {
	        title: title.value,
	        name: name.value,
	        content: content.value
	    };
		const xhr = new XMLHttpRequest();
		xhr.onload = function(){
            alert(xhr.responseText);
            location.href = "show.jsp";
		};
	    
	    xhr.open("POST", "servlet");
	    xhr.setRequestHeader("Content-Type", "application/json");
	    xhr.send(JSON.stringify(obj));
	}
</script>
</body>
</html>