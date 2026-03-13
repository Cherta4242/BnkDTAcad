<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/header.css">
    
<header>
<%
	String jbid = (String)session.getAttribute("jbid");
	String jbpw = (String)session.getAttribute("jbpw");
	String jbname = (String)session.getAttribute("jbname");
%>

	<div id="header_menu">
		<h1 id="header_banner"><a href="/">JJW Board2</a></h1>
		<div id="ls_sw">
			<div id="login_signup">
				<ul>
<%				if(jbname == null){ %>
					<li><a href="/lgpage">로그인</a></li>
					<li>/</li>
					<li><a href="/sgupage">회원가입</a></li>
<%				} else{%>
					<li><a href="/mypage">"${sessionScope.jbname}"</a>님</li>
					<li>/</li>
					<li><a href="/logout" onclick="logouting()">로그아웃</a>
<%				}%>
				</ul>
			</div>
			<div id="show_write">
				<ul>
<%				if(jbname == null){ %>
					<li><a href="/show">게시글 목록</a></li>
					<li>/</li>
					<li><a href="/pleaseTT">제작자 후원</a></li>
<%				} else{%>
					<li><a href="/showpage">게시글 목록</a></li>
					<li>/</li>
					<li><a href="/writepage">게시글 등록</a></li>
					<li>/</li>
					<li><a href="/pleaseTT">제작자 후원</a></li>
<%				}%>
				</ul>
			</div>			
		</div>
	</div>
</header>
<script>
	function logouting(){
		alert("로그아웃되셨습니다!");
	}
</script>