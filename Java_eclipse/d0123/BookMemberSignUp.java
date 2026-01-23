package jjw_Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookMemberSignUp {
	
	String url = "jdbc:oracle:thin:@//localhost:1521/testdb";
	String user = "green";
	String pw = "1234";
	
	
	BookMemberSignUp(){
		
	}
	
	public void SignUp(String id, String pwd, String name, int manager) throws Exception{
	
		
		Connection conn = DriverManager.getConnection(url, user, pw);
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO libmember(lid, lpw, lname, lmanager) VALUES(?, ?, ?, ?)");
		
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		pstmt.setString(3, name);
		pstmt.setInt(4, manager);
		pstmt.executeUpdate();
		
		System.out.println("회원가입이 완료되었습니다.");
		
		
		
	}
	
}
