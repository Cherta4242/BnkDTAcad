package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DTO.orderDTO;

public class orderDAO{

	String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
	String user = "green";
	String pw = "1234";
	String sql = "INSERT INTO tbl_order_202101(orderno, shopno, orderdate, pcode, amount) "
			+ "VALUES (?, ?, ?, ?, ?)";
	
	
	Connection conn() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url, user, pw);
	}
	
	public int insertOreder(orderDTO odt) throws SQLException, ClassNotFoundException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;



		try {
			conn = conn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, odt.getOrderno());
			pstmt.setString(2, odt.getShopname());
			pstmt.setString(3, odt.getOrderdate());
			pstmt.setString(4, odt.getPcode());
			pstmt.setInt(5, odt.getAmount());
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
