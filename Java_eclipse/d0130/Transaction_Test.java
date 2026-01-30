package d0130;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class Transaction_Test {

	public static void main(String[] args) throws Exception{
		String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
		String uid = "green";
		String upw = "1234";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Savepoint sp1 = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			conn.setAutoCommit(false);	// AUTO COMMIT 해제
			

			
			// 1. A 계좌 출금
			String withdrawSql = "UPDATE account SET balance = ? WHERE acid = ?";
			
			pstmt = conn.prepareStatement(withdrawSql);
			pstmt.setInt(1, 300);	// 300 출금
			pstmt.setInt(2, 2);		
			
			pstmt.executeUpdate();
			
			// SAVEPOINT 설정
			sp1 = conn.setSavepoint("SP1");
			
			
			// 2. B 계좌 입금
			String depositSql = "UPDATE account SET balance = balance + ? WHERE acid = ?";
			
			pstmt = conn.prepareStatement(depositSql);
			pstmt.setInt(1, 300);
			pstmt.setInt(2, 2);
			
			// 오류 발생
			// int n = 4/0;
			if(true) {
				throw new RuntimeException("강제 오류 발생!");
			}
			
			
			pstmt.executeUpdate();					
			conn.commit();
			
			
			
			System.out.println("이체 성공");
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println("오류 발생 --> 롤백 수행");
			try {
				conn.rollback();
				conn.commit();
			}catch(SQLException ee) {
				ee.printStackTrace();
			}
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
