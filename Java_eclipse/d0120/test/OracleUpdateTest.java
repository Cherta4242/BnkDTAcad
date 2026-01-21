package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.Statement;
import java.util.Scanner;

public class OracleUpdateTest {

	public static void main(String[] args) throws Exception{
		
		String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
		String user = "green";
		String pw = "1234";
		
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		
		conn = DriverManager.getConnection(url, user, pw);
		//stmt = conn.createStatement();
		pstmt = conn.prepareStatement("UPDATE testTbl SET name = ? WHERE id = ?");
		//pstmt = conn.prepareStatement("UPDATE testTbl SET id = ? WHERE name = ?");
		
		System.out.print("수정하는 칸의 id를 입력해주세요\n>> ");
		int id = sc.nextInt();
		System.out.print("수정하실 name을 입력해주세요\n>> ");
		String name = sc.next();
		System.out.print("\n수정이 완료되었습니다\n");
		
		pstmt.setString(1, name);
		pstmt.setInt(2, id);
		
		int result = pstmt.executeUpdate();
		System.out.println(result + "건 등록 완료!");
		
		conn.close();
		//stmt.close();
		pstmt.close();
		sc.close();
	}
}
