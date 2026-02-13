<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main_Page</title>
<style>
	header{
		border-bottom: 1px solid gray;
		padding-bottom: 30px
	}
	.header_chart{
		margin: 0 auto;
		margin-top: 30px;
		width: 1100px;
		height: 80px;
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	a{
		text-decoration: none;
		color: inherit;
	}
	.header_chart ul{
		display: flex;
		gap: 30px;
	}
	.header_chart li{
		list-style: none;
	}
	.menu{
		border: 1px solid black;
	}
</style>
</head>
<body>
	<header>
		<div class="header_chart">
			<div>로고</div>
			<div>
				<div>
					<ul>
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="signup.jsp">회원가입</a></li>
					</ul>
				</div>
				<div class="menu">메뉴들~~~~</div>
			</div>
		</div>
	</header>
</body>
</html>