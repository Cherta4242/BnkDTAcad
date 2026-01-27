package d0127;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

public class Date_Test {
	
	public static void main(String[] args)throws SQLException{
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		LocalDateTime today2 = LocalDateTime.now();
		System.out.println(today2);
		
		Connection conn = DBcon.getConnection();
		
		String query = "INSERT INTO testTime (name) VALUES ('ddd')";
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		// 문자열로 날짜 추가하기
		//pstmt.setString(1, "2025-12-11");
		
		// 날짜형으로 추가하기
		//LocalDateTime now = LocalDateTime.now();
		//pstmt.setTimestamp(1, Timestamp.valueOf(now));
		//pstmt.setTimestamp(2, Timestamp.valueOf(now));
		
		
		int result = pstmt.executeUpdate();
		System.out.println(result + "행 추가됨");

		pstmt.close();
		conn.close();
		
		
		conn = DBcon.getConnection();
		query = "SELECT * FROM testTime";
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		rs.next();
		System.out.println(rs.getString("date1"));
		
		/*
		// 테이블의 name 컬럼의 값 받기
		String name = rs.getString("name");
		// 테이블의 date1 컬름의 값 받기
		LocalDateTime date1 = rs.getTimestamp("date1").toLocalDateTime();
		// 테이블의 date2 컬럼의 값 받기
		LocalDateTime date2 = rs.getTimestamp("date2").toLocalDateTime();
		
		System.out.println("name: " + name + "\ndate1: " + date1 + "\ndate2: " + date2);
		
		
		// 날짜.시간. 데이터 형식 지정
		DateTimeFormatter df1 = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		System.out.println(date1.format(df1));
		
		DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yy/MM/DD HH:mm:SS");
		System.out.println(date2.format(df2));
		*/
		
	}
}
