<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp_Page</title>
<style>
	body{
		margin: 0 auto
	}
	.signup_page{
		border: 1px solid black;
		margin: 0 auto;
		margin-top: 200px;
		width: 400px;
		height: 400px;
		padding-top: 50px;
		text-align: center;
	}
</style>
</head>
<body>
	<%	
		// 연결할 때 사용할것들
		String url="jdbc:oracle:thin:@//localhost:1521/orcl";
		String user = "green";
		String pw = "1234";
		
		// 사용할 sql문들
		String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        String sql2 = "SELECT COUNT(*) FROM users WHERE username = ?";
        
		// request로 값을 받아 와 변수에 넣어주기
		String action = request.getParameter("action");		// 버튼의 이름 = action and value를 받아오기 -> check or signup
		String username = request.getParameter("username");		// 이름이 username인 텍스트박스의 value를 받아오기
		

		
		
		if(action != null){	
			// 버튼을 눌렀을 때 버튼의 값이 check인 버튼을 눌렀는가?(중복확인버튼)
			if ("check".equals(action)) {
				// 아이디 비어있지 않게 저장
				if(username != null) username = username.trim();
				// 아이디 비어있나 검사
			    if(username == null || username.isEmpty()){
			    	out.println("<script>alert('아이디를 입력하세요'); history.back();</script>");
			    	return;
			    }
			    // 아이디 길이 검사
			    if (username.length() < 4 || username.length() > 12) {
			        out.println("<script>alert('아이디는 4~12자여야 합니다'); history.back();</script>");
			        return;
			    }
				
				
			    Connection conn = null;
			    PreparedStatement pstmt = null;
			    ResultSet rs = null;
				
				try{
					// oracle 연결해주기
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, user, pw);
					
					// sql 안에 뒤져보고 아이디 중복되는거 있는지 보기
			        pstmt = conn.prepareStatement(sql2);
			        pstmt.setString(1, username);
					
			        // ResultSet을 통해 변수에 값을 받아오기위해 sql 실행시켜주기
			        rs = pstmt.executeQuery();
			        rs.next();
			        // 를 count에 넣기
			        int count = rs.getInt(1);
					
			        // sql안에 아이디가 있으면 사용중, 없으면 사용가능.
			        // 이 때 history.back()을 사용했는데 이거 없으면 다시 입력해야하니까 화날까봐
			        if (count > 0) {
			            out.println("<script>alert('이미 사용중인 아이디입니다'); history.back();</script>");
			        } else {
			            out.println("<script>alert('사용 가능한 아이디입니다'); history.back();</script>");
			        }
			        
			        // 종료
			        return;					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					// 확인 끝나면 무조건 닫기
			        try{ if(rs!=null) rs.close(); }catch(Exception e){}
			        try{ if(pstmt!=null) pstmt.close(); }catch(Exception e){}
			        try{ if(conn!=null) conn.close(); }catch(Exception e){}
			    }
				
				return;
		    }
			
			// username이 비어있다면 실행 X 비어있지 않다면 실행	
			if("signup".equals(action)){
				// 아이디 비어있지 않게 저장
				if(username != null) username = username.trim();
				// 아이디 비어있나 검사
			    if(username == null || username.isEmpty()){
			    	out.println("<script>alert('아이디를 입력하세요'); history.back();</script>");
			    	return;
			    }
			    // 아이디 길이 검사
			    if (username.length() < 4 || username.length() > 12) {
			        out.println("<script>alert('아이디는 4~12자여야 합니다'); history.back();</script>");
			        return;
			    }
				
				
				// password와 email도 같이 받아오기
				String password = request.getParameter("password");
				String email = request.getParameter("email");

			    // 비밀번호 확인하기
			    if (password == null || password.trim().isEmpty()) {
			        out.println("<script>alert('비밀번호를 입력하세요'); history.back();</script>");
			        return;
			    }
			    
			    Connection conn = null;
			    PreparedStatement pstmt = null;
				
				try{
					// oracle 연결해주기
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, user, pw);
					
					// jdbc에 sql문 입력해주려는거 적어주고
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, username);
					pstmt.setString(2, password);
					pstmt.setString(3, email);
					
					// sql 진짜로 실행
					pstmt.executeUpdate();
					
					// 회원가입sql실행문이 문제 없이 완료되면 confirm으로 확인 or 취소 뛰워주기
					out.println(
					    "<script>" +						// out.print를 실행하면 안에있는 html도 읽을 수 있더군요.
						    "if(confirm('회원가입이 완료되었습니다. 바로 로그인 화면으로 넘어가시겠습니까?')) {" +		// 확인 or 취소로 true, false값 반환
						    	"location='login.jsp';" +	// true라면 login.jsp페이지로 넘어가기
						    "}else{" +
						    	"location='index.jsp';" +	// flase라면 index.jsp페이지로 넘어가기
						    "}" +
					    "</script>"
					);
	
				//에러 방지 무조건!
				}catch(java.sql.SQLIntegrityConstraintViolationException e){
			        out.println("<script>alert('이미 사용중인 아이디입니다'); history.back();</script>");
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					// 확인 끝나면 무조건 닫기
			        try{ if(pstmt!=null) pstmt.close(); }catch(Exception e){}
			        try{ if(conn!=null) conn.close(); }catch(Exception e){}
			    }
			}
		}
		
	%>
	<div class="signup_page">
		<form method="post">
			<h3>Id를 입력해주세요</h3>
			<input name="username" placeholder="insert your ID for used">
			<button type="submit" name="action" value="check">중복확인</button><br>
			<h3>Password를 입력해주세요</h3>
			<input name="password" placeholder="insert your PW for used"><br>
			<h3>Email을 입력해주세요</h3>
			<input name="email" placeholder="insert your Email for used"><br>
			<button type="submit" name="action" value="signup">SignUp</button>
		</form>
	</div>
</body>
</html>