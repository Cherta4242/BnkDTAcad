<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공공 문화제 API연결</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <!-- 공공데이터포털에서 API를 받아와 테이블에 출력하기. -->
    <!-- application에 저장하는 방식 -->
    <h1>공공데이터 포털의 API를 사용하여 출력</h1>
	<div class="div2">
		<div class="div0">
			<ul>
				<li><a href="index.jsp">application</a></li>
				<li>/</li>
				<li><a href="apisave.jsp">DB</a></li>
			</ul>
		</div>
	</div>
    <hr>
    
    <table>
    	<thead>
	    	<tr>
	    		<th>번호</th>
	    		<th>주소</th>
	    		<th>명칭</th>
	    	</tr>
    	</thead>
    	<tbody id="tbody1">
    	</tbody>
    </table>
    
	<div id="div1">abc</div>
	<button type="button" onclick="console_view()">콘솔출력</button>
	<button type="button" onclick="clearling()">지우기</button>
    
    <script>
    	const tbody = document.getElementById("tbody1");
    	const div1 = document.getElementById("div1");
    	
    	function console_view(){
    		tbody.innerHTML = "";
    		console.log("하잉?");
    		const xhr = new XMLHttpRequest();
    		
    		xhr.onload = function(){
    			const result = JSON.parse(xhr.responseText);
    			const item = result.gyeongnamculturallist.body.items.item;
    			console.log(item[0]);
    			console.log(item[1]);
    			let i = 1;
    		    item.forEach(cult => {
    		        const tr = document.createElement("tr");

    		        const tdnum = document.createElement("td");
    		        tdnum.textContent = i;
					i++;
    		        const tdaddress = document.createElement("td");
    		        tdaddress.textContent = cult.ADDRESS1;

    		        const tdmyongching = document.createElement("td");
    		        tdmyongching.textContent = cult.MYONGCHING;

    		        
    		        tr.appendChild(tdnum);
    		        tr.appendChild(tdaddress);
    		        tr.appendChild(tdmyongching);

    		        tbody.appendChild(tr);
    		    });
    		};
    		console.log("---------------------------------------------------------");
    		xhr.open("GET", "ApiSaveServlet");
    		xhr.send();
    		
    		
    	}
    	
    	function clearling(){
    		tbody.innerHTML ="";
    	}
    </script>
	
</body>
</html>