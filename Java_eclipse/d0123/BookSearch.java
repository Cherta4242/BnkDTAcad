package jjw_Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookSearch {
	String url = "jdbc:oracle:thin:@//localhost:1521/testdb";
	String user = "green";
	String pw = "1234";
	
	BookSearch(){
		
	}
	
	// 책 이름 및 위치 출력
	public void showAll() throws Exception{
		Connection conn = DriverManager.getConnection(url, user, pw);
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM library");
		
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		while(rs.next()) {
			System.out.println("-------------------------------");
			System.out.println("책 이름: " + rs.getString("bname"));
			System.out.println("책 위치: " + rs.getString("blocation"));
			System.out.println("책 상태: " + rs.getString("bsituation"));
			System.out.println("-------------------------------");
		}
	}
	
	// 책 검색
	public void searchBook(String name) throws Exception{
		Connection conn = DriverManager.getConnection(url, user, pw);
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM library WHERE bname = ?");

		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println("책 이름: " + rs.getString("bname"));
			System.out.println("책 위치: " + rs.getString("blocation"));
			System.out.println("책 상태: " + rs.getString("bsituation"));
		}
	}
	
	
	// 책 코드가 있는지 확인
	public int searchCode(String code) throws Exception{
		int i;
		Connection conn = DriverManager.getConnection(url, user, pw);
		PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) AS cnt FROM library WHERE bcode = ?");
		
		pstmt.setString(1, code);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		i = rs.getInt("cnt");
		
		return i;
	}
	// 아이디가 이미 있는지 확인
	public int searchId(String id) throws Exception{
		int i;
		Connection conn = DriverManager.getConnection(url, user, pw);
		PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) AS cnt FROM libmember WHERE lid = ?");
		
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		i = rs.getInt("cnt");
		
		return i;
	}
	
	// 특정 사람 이름 출력
	public String searchName(String id, String pw) throws Exception{
		String name = null;
		
		Connection conn = DriverManager.getConnection(url, user, pw);
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM libmember WHERE lid = ? AND lpw = ?");

		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		name = rs.getString("lname");
		
		
		return name;
	}
	
}
