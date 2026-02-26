package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDTO;

public class MemberDAO {

	String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
	String user = "green";
	String pw = "1234";
	
	Connection conn() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url, user, pw);
	}
	
	public int insert(MemberDTO idto) throws SQLException{
		String sql = "INSERT INTO member2(id, pw, nickname) VALUES (?, ?, ?)";
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = conn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idto.getId());
			pstmt.setString(2, idto.getPw());
			pstmt.setString(3, idto.getNickname());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		return result;
	}
	
	public ArrayList<MemberDTO> membershow() throws SQLException{
		ArrayList<MemberDTO> al = new ArrayList<MemberDTO>();
		String sql = "SELECT * FROM member2";
		MemberDTO dto = new MemberDTO();		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = conn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setNickname(rs.getString("nickname"));
				
				al.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		return al;
	}
}
