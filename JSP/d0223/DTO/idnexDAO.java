package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DTO.indexDTO;
// DAO는 직접 DB와 연결해주는 역할(Data Access Object)
public class idnexDAO {
	// DB에 연결 준비
	String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
	String user = "green";
	String pw = "1234";
	// SQL문 준비
	String sql = "INSERT INTO idpw(id, pw) VALUES(?, ?)";
	
	
	// 연결 -> 평소에 연결하던 방식이 안되길래 바꿈
	Connection con() throws SQLException, ClassNotFoundException{
		// JDBC에서 데이터베이스 드라이버를 로딩하는 코드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// con()을 사용하면 여느때와 같이 url, user, pw가 들어간 DriverManager가 반환되게 return 설정
		return DriverManager.getConnection(url,user,pw); 
	}
		
	// DB에 넣을 수 있게 도와주는 함수
	public int insert(indexDTO d) throws ClassNotFoundException, SQLException{
		// 기본 셋팅
		int result = 0;		// 성공했나 실패했나 반환값
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 닫아야 하니까 con()을 conn에 담기
			conn = con();
			// PreparedStatement로 SQL문 준비
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d.getId());		// 1번 물음표 설정
			pstmt.setString(2, d.getPw());		// 2번 물음표 설정
			// SQL문 실행
			result = pstmt.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 실행 끝나면 닫기
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
		}
		// 실행결과 (성공/실패 -> 1/0) 반환
		return result;
	}
	
	
	
}

