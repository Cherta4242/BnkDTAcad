package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.BoardDTO;

public class BoardDAO {

	String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
	String user = "green";
	String pw = "1234";
	
	Connection conn() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url, user, pw);
	}
	
	public int writeBoard(BoardDTO dto) throws SQLException, ClassNotFoundException{
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO jjw_board(id, name, title, content) VALUES (jjw_board_seq.NEXTVAL, ?, ?, ?)";
		
		try {
			conn = conn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}finally {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}

		
		
		return result;
	}
}
