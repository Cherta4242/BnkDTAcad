package jjw_Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// DB Access
public class BookInsert {

	String url = "jdbc:oracle:thin:@//localhost:1521/testdb";
	String user = "green";
	String pw = "1234";
	
	// 책 코드
	private String code;

	// 책 이름
	private String name;
	// 책 입고 날짜?
	private String date;
	// 책 위치?
	private String location;
	
	BookInsert(){}

	
	public void inserting(String code, String name, String date, String location) throws Exception {
		this.code = code;
		this.name = name;
		this.date = date;
		this.location = location;
		Connection conn = DriverManager.getConnection(url, user, pw);
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO library(bcode, bname, bdate, blocation) VALUES (?, ?, ?, ?)");
		pstmt.setString(1, code);
		pstmt.setString(2, name);
		pstmt.setString(3, date);
		pstmt.setString(4, location);
		pstmt.executeUpdate();
		
		System.out.println("실행되었습니다.");
	}
	
	public String getCode() {return code;}
	public void setCode(String code) {this.code = code;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getDate() {return date;}
	public void setDate(String date) {this.date = date;}
	
	public String getLocation() {return location;}
	public void setLocation(String location) {this.location = location;}
}
