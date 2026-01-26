package jjw_Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookUpdate {
	String url = "jdbc:oracle:thin:@//192.168.0.184:1521/orcl";
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
	
	public void loan(String bookname, String id) throws Exception{
		Connection conn = DriverManager.getConnection(url, user, pw);
		PreparedStatement pstmt = conn.prepareStatement("UPDATE library SET bsituation = ? WHERE bname = ?");
		PreparedStatement pstmt2 = conn.prepareStatement("UPDATE libmember SET lbname = ? WHERE lid = ?");
		
		pstmt.setString(1, situation);
		pstmt.setString(2, bookname);
		
		pstmt2.setString(1, bookname);
		pstmt2.setString(2, id);
		
		pstmt.executeUpdate();
		pstmt2.executeUpdate();

		
		System.out.println("책을 대출하였습니다.");
	}
	
	public void bookReturn(String bookname, String id) throws Exception{
		Connection conn = DriverManager.getConnection(url, user, pw);
		PreparedStatement pstmt = conn.prepareStatement("UPDATE library SET bsituation = ? WHERE bname = ?");
		PreparedStatement pstmt2 = conn.prepareStatement("UPDATE libmember SET lbname = ? WHERE 	lid = ?");
		
		pstmt.setString(1, situation2);
		pstmt.setString(2, bookname);
		
		pstmt2.setString(1, null);
		pstmt2.setString(2, id);
		
		pstmt.executeUpdate();
		pstmt2.executeUpdate();

		
		System.out.println("책을 반납하였습니다.");
	}
	
}