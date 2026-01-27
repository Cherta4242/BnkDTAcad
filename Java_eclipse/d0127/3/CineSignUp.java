package d0127_3;

import java.sql.Connection;
import java.sql.PreparedStatement;

// DB access 용도의 파일
public class CineSignUp {
	
	String id;
	String pw;
	String name;
	
	
	CineSignUp(String id, String pw, String name) throws Exception{
		this.id = id;
		this.pw = pw;
		this.name = name;
		
		Connection conn = DBcon.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO cinemember (ciid, cipw, ciname) VALUES (?, ?, ?)");
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, name);
		pstmt.executeUpdate();
		System.out.println("회원가입이 완료되었습니다.");
	}
	
	public String getID() {
		return id;
	}
	public String getPW() {
		return pw;
	}
	public String getName() {
		return name;
	}
	
}
// 회원가입 -> 로그인 -> 예약 끝!