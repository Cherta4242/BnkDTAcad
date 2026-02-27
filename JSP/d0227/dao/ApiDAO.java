package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.ApiDTO;

public class ApiDAO {

	String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
	String user = "green";
	String pw = "1234";
	
	Connection conn() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url, user, pw);
	}
	
	public int insert(ApiDTO dto) throws Exception{
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// INSERT 할 SQL문 작성
		String sql = "INSERT INTO cult(cultnum, address, myongching) VALUES (?, ?, ?)";
		
		try {
			conn = conn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getCultnum());
			pstmt.setString(2, dto.getCultaddress());
			pstmt.setString(3, dto.getCultname());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			result = 0;
		}finally {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		return result;
	}
}
