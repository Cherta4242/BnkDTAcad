<%@page import="java.util.ArrayList"%>
<%@page import="domain.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 성적 목록</title>
<style>
body{
    font-family: Arial, sans-serif;
    background-color: #f4f6f8;
}

.container{
    width: 600px;
    margin: 40px auto;
}

.card{
    background-color: white;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    padding: 20px;
    margin-bottom: 20px;
}

.card h3{
    margin-bottom: 10px;
    color: #333;
}

.score{
    display: flex;
    justify-content: space-between;
    margin: 8px 0;
    font-size: 16px;
}

.title{
    text-align: center;
    margin-bottom: 30px;
}
.grade_std{
	display: flex;
	flex-direction: space-between;
}
</style>
</head>
<body>

<%! ArrayList<Student> al = new ArrayList<Student>(); %>
<%! ArrayList<Student> al2 = new ArrayList<Student>(); %>

<%
    String name = request.getParameter("name");
    int kor = Integer.parseInt(request.getParameter("kor"));
    int eng = Integer.parseInt(request.getParameter("eng"));
    int math = Integer.parseInt(request.getParameter("math"));
    int all = kor + eng + math;
    Student st = new Student(name, kor, eng, math, all);

    if(name != null){
        al.add(st);
    }
    int i = 1;
    
    if(al2.isEmpty()){
        al2.add(st);
    }else{
        boolean inserted = false;

        for(int j = 0; j < al2.size(); j++){
            if(st.getAll() >= al2.get(j).getAll()){
                al2.add(j, st);
                inserted = true;
                break;
            }
        }

        if(!inserted){
            al2.add(st);
        }
    }

%>

<div class="container">
    <h1 class="title">학생 성적 목록</h1>
	
	<div class="grade_std">
	    <% for(Student show : al){ %>
	        <div class="card">
	            <h3>학생 <%= i++ %></h3>
	            <div class="score"><span>이름</span><span><%= show.getName() %></span></div>
	            <div class="score"><span>국어</span><span><%= show.getKor() %></span></div>
	            <div class="score"><span>영어</span><span><%= show.getEng() %></span></div>
	            <div class="score"><span>수학</span><span><%= show.getMath() %></span></div>
	        </div>
	    <% } %>
	    <% for(Student show : al2){ %>
	        <div class="card">
	            <h3>학생 <%= i++ %></h3>
	            <div class="score"><span>이름</span><span><%= show.getName() %></span></div>
	            <div class="score"><span>국어</span><span><%= show.getKor() %></span></div>
	            <div class="score"><span>영어</span><span><%= show.getEng() %></span></div>
	            <div class="score"><span>수학</span><span><%= show.getMath() %></span></div>
	            <div class="score"><span>총점</span><span><%= show.getAll() %></span></div>
	            <div class="score"><span>평균</span><span><%= show.getAll()/3 %></span></div>
	        </div>
	    <% } %>
	</div>
	
</div>

</body>
</html>
