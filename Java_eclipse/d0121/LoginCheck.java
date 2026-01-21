package d0121;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;




public class LoginCheck {

	Scanner sc = new Scanner(System.in);
	
	String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
	String user = "green";
	String pw = "1234";
	
	// 로그인하기.
	boolean Login(String id, String pwd) throws Exception {
		ViewMember vem = new ViewMember();
		
		
		int result = 0;
		
		Connection conn = DriverManager.getConnection(url, user, pw);
		PreparedStatement pstmt = null;
		
		String src = "SELECT COUNT(*) AS cnt FROM TestMember WHERE id = ? AND pw = ?";
		
		pstmt = conn.prepareStatement(src);
		
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		result = rs.getInt("cnt");
		
		if(result == 1) {
			System.out.println("로그인 되었습니다.");
			System.out.println("*****" + vem.getName(id, pwd) + "님 환영합니다!*****");
			return true;
		}else {
			System.out.println("아이디, 비밀번호가 틀렸습니다.");
			return false;
		}
	}
}
