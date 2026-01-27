package d0127_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 영화 넣기
public class CineInsmv {
	
	
	String moviename;
	
	// 영화 등록
	public void madeMovie(String moviename, String movietime, String moviesttim, String movieentim) throws Exception{
		this.moviename = moviename;
		
		Connection conn = DBcon.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO cinema (moviename, movietime, moviesttim, movieentim, seatnum) VALUES(?, ?, TO_DATE(?, 'YY/MM/DD HH/MI/SS'), TO_DATE(?, 'YY/MM/DD HH/MI/SS'), ?)");
		
		pstmt.setString(1, moviename);
		pstmt.setString(2, movietime);
		pstmt.setString(3, moviesttim);
		pstmt.setString(4, movieentim);

		for(int i = 1; i <= 10; i++) {
			pstmt.setInt(5, i);
			pstmt.executeUpdate();
		}

	}
	
	// 예약하기
	public void reserve(String id, String pw, int number) throws Exception{
		String updt = "UPDATE seat SET reserve = '예약' WHERE seatnum = ?";
		
		Connection conn = DBcon.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) AS cnt FROM cinemember WHERE ciid = ? AND cipw = ?");
		
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		if(rs.getInt("cnt") == 1) {
			pstmt = conn.prepareStatement(updt);
			pstmt.setInt(1, number);
			pstmt.executeUpdate();
			System.out.println("예약 완료되었습니다.");
		}else {
			System.out.println("아이디, 비밀번호가 틀렸습니다.");
		}
	}
	
	
	
}
