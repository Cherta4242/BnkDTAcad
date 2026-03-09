<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@ include file="header.jsp" %>
	<section id="write_section">
		<h2>등록하기 페이지</h2>
		<div id="write_title_name">
			<div id="write_title">
				<input type="text" id="input_title" placeholder="제목을 작성해주세요.">
			</div>
			<div id="write_name">
				<div id="input_name"><%= loginName %></div>
			</div>
		</div>
		<div id="write_content">
			<input type="text" id="input_content" placeholder="내용을 작성해주세요.">
		</div>
		<div id="write_button_div" onclick="writeBoard()">등록하기</div>
	</section>


<%@ include file="footer.jsp" %>


<script>
	const title = document.getElementById("input_title");
	const content = document.getElementById("input_content");
	function writeBoard(){
	    const obj = {
	        title: title.value,
	        name: '<%= loginId %>',
	        content: content.value
	    };
	    console.log(obj.value)
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