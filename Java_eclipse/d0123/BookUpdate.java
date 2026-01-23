package jjw_Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookUpdate {
	String url = "jdbc:oracle:thin:@//localhost:1521/testdb";
	String user = "green";
	String pw = "1234";
	
	String situation = "대출 중";
	String situation2 = "미 대출"; 
	
	BookUpdate(){
		
	}
	
	public void updating(String code, int i) throws Exception{

		Connection conn = DriverManager.getConnection(url, user, pw);
		PreparedStatement pstmt = conn.prepareStatement("UPDATE library SET bsituation = ? WHERE bcode = ?");
		pstmt.setString(2, code);
		if(i == 1) {
			pstmt.setString(1, situation2);
		}else {
			pstmt.setString(1, situation);	
		}
		pstmt.executeUpdate();
		
		System.out.println("실행되었습니다.");
	}
}
