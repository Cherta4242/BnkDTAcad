package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DTO.SignupDTO;

public class SignupDAO {
	
	String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
	String user = "green";
	String pw = "1234";
	
	String sql = "INSERT INTO viewing(veno, veid, vepw, vename, veph) VALUES(viewing_seq.NEXTVAL, ?, ?, ?, ?)";
	Connection con() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url, user, pw);
	}
	
	public int signUpviewing(SignupDTO sdto) throws ClassNotFoundException, SQLException{
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = con();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sdto.getId());
			pstmt.setString(2, sdto.getPw());
			pstmt.setString(3, sdto.getName());
			pstmt.setString(4, sdto.getPh());				
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		
		return result;
	}

}
