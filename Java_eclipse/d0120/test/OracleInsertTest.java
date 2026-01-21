package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.Statement;
import java.util.Scanner;

public class OracleInsertTest {

	public static void main(String[] args) throws Exception{
		String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
		String user = "green";
		String pw = "1234";
		
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		conn = DriverManager.getConnection(url, user, pw);
		stmt = conn.createStatement();
		pstmt = conn.prepareStatement("INSERT INTO testTbl (id, name) VALUES (?,?)");
		
		
		ResultSet rs = stmt.executeQuery("SELECT id, name FROM testTbl");
		
		while(rs.next()) {
			System.out.println(
				rs.getInt("id") + " " + 
				rs.getString("name")
			);
		}
		
		System.out.println("========================================");
		
		
		System.out.print("테이블에 추가하실 id를 입력해주세요\n>>");
		int id = sc.nextInt();
		System.out.print("\n테이블에 추가하실 name을 입력해주세요\n>>");
		String name = sc.next();
		System.out.println("\n입력이 완료되었습니다.");
		
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		
		int result = pstmt.executeUpdate();
		
		// int result = stmt.executeUpdate("INSERT INTO testTbl (id, name) VALUES (" + id + ", '" + name + "')");
		
		System.out.println(result + "건 등록 완료!");
	
		
		conn.close();
		stmt.close();
		pstmt.close();
		sc.close();
		rs.close();
	}
}
