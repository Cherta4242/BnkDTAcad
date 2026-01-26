package jjw_Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookLogin {

	String url = "jdbc:oracle:thin:@//192.168.0.184:1521/orcl";
	String user = "green";
	String pw = "1234";
	
	BookLogin(){
		
	}
	
	// 로그인
	public int login(String id, String pwd) throws Exception{
		int i;
		Connection conn = DriverManager.getConnection(url, user, pw);
		PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) AS cnt FROM libmember WHERE lid = ? AND lpw = ?");
		
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		i = rs.getInt("cnt");
		return i;
	}
	
	
}