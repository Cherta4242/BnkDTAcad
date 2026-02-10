<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 성적 입력</title>
<style>
body{
    font-family: Arial, sans-serif;
    background-color: #f2f4f7;
}

.container{
    width: 400px;
    margin: 80px auto;
    padding: 30px;
    background-color: white;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    text-align: center;
}

input[type="text"]{
    width: 90%;
    padding: 10px;
    margin: 8px 0;
    border: 1px solid #ccc;
    border-radius: 5px;
}

input[type="submit"]{
    width: 95%;
    padding: 10px;
    margin-top: 15px;
    border: none;
    background-color: #4CAF50;
    color: white;
    font-size: 16px;
    border-radius: 5px;
    cursor: pointer;
}

input[type="submit"]:hover{
    background-color: #45a049;
}
</style>
</head>
<body>

<div class="container">
    <h1>학생 성적 입력</h1>
    <p>학생의 성적을 입력해주세요.</p>

    <!-- 핵심: method="get" -->
    <form action="showall.jsp" method="get">
        <input type="text" placeholder="이름을 입력해주세요" name="name" required>
        <input type="text" placeholder="국어 점수" name="kor" required>
        <input type="text" placeholder="영어 점수" name="eng" required>
        <input type="text" placeholder="수학 점수" name="math" required>
        <input type="submit" value="등록">
    </form>
</div>

</body>
</html>
