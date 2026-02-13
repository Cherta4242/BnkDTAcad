<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%
	// 오라클 연결 준비
	String url="jdbc:oracle:thin:@//localhost:1521/orcl";
	String user = "green";
	String pw = "1234";
	
	// username, password를 받아서 준비
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	// username의 양쪽 공백을 제거한 상태로 저장
	if(username != null) username = username.trim();
	// 저장된 username의 데이터를 확인하고 id와 password가 비어있는지 아닌지 확인
	if(username == null || username.isEmpty() || password == null || password.isEmpty()){
	    out.println("<script>alert('아이디와 비밀번호를 입력하세요'); history.back();</script>");
	    return;
	}
	
	// 연결준비(conn, pstmt, rs)이 세가지를 finally에서 닫기 위해 전역변수로 선언
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// 연결 시작
	try{
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    conn = DriverManager.getConnection(url, user, pw);
	
	    String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
	    
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, username);
	    pstmt.setString(2, password);
		// 쿼리문 실행
	    rs = pstmt.executeQuery();
		
	    if(rs.next()){
	        // 세션으로 저장해서 다음 페이지에 계속해서 데이터를 넘겨줄 예정
	        session.setAttribute("loginUser", username);
			// 로그인 성공하면 성공했다고 하고 index.jsp 페이지로 넘어감
	        out.println("<script>alert('로그인 성공'); location='index.jsp';</script>");
	    }else{
	    	// 로그인 실패라면 둘 중 하나가 틀렸다고 알려줌(아이디인지 비밀번호인지 유저가 모르게)
	        out.println("<script>alert('아이디 또는 비밀번호가 틀렸습니다'); history.back();</script>");
	    }
	// 오류뜨면 출력
	}catch(Exception e){
	    e.printStackTrace();
	// rs, pstmt, conn 무조건 닫아주기
	}finally{
	    try{ if(rs!=null) rs.close(); }catch(Exception e){}
	    try{ if(pstmt!=null) pstmt.close(); }catch(Exception e){}
	    try{ if(conn!=null) conn.close(); }catch(Exception e){}
	}
%>

</body>
</html>