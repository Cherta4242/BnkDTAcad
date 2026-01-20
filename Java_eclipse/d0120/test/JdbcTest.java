package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {

	public static void main(String[] args) {
		// 선생님은 testdb로 사용했지만 나는 orcl로 사용해야 함.
		String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
		String user = "green";
		String password = "1234";
		
		Connection conn = null;
		
		try {
			// (JDBC 4.0 이상에서는 생략 가능)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("Oracle DB 연결 성공!");
		}catch(ClassNotFoundException e) {
			System.out.println("Oracle JDBC 드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					System.out.println("DB 연결 종료");
					conn.close();	
				}catch(SQLException e) {
					
				}
				
			}
		}

	}

}
