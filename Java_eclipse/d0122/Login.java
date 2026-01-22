package d0122;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// DB Access - 로그인 기능
public class Login {
	
	// DB 연결 변수 선언
	String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
	String user = "green";
	String pw = "1234";
	
	// 로그인 할 때 사용
	public int newLogin(String id, String pwd) throws Exception{
		Connection conn = DriverManager.getConnection(url, user, pw);
		PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) AS cnt FROM Member WHERE id = ? AND password = ?");
		
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int result = rs.getInt("cnt");
		
		return result;
	}
	
	// id만 확인하는 함수
	public int idCheck(String id) throws Exception{
		Connection conn = DriverManager.getConnection(url, user, pw);
		PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) AS cnt FROM Member WHERE id = ?");
		
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		int result = rs.getInt("cnt");
		
		return result;
	}
	
	// login 생성자
	Login(){
		
	}
	
	
}
