package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class OracleDeleteTest {

	public static void main(String[] args) throws Exception{
		String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
		String user = "green";
		String pw = "1234";
		
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		
		conn = DriverManager.getConnection(url, user, pw);
		pstmt = conn.prepareStatement("DELETE testTbl where id = ?");
		
		int id = 6;
		
		pstmt.setInt(1, id);
		
		int result = pstmt.executeUpdate();
		System.out.println(result + "건 삭제 완료!");
		
		conn.close();
		pstmt.close();
	}
}
