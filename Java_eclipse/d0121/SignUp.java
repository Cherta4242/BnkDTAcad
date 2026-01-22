package d0121;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class SignUp{
	
	Scanner sc = new Scanner(System.in);
	
	SignUp(String id, String pwd, String name) throws Exception{
		String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
		String user = "green";
		String pw = "1234";
		
		Connection conn = DriverManager.getConnection(url, user, pw);
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO TestMember(id, pw, name) VALUES (?,?,?)");
		
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		pstmt.setString(3, name);
		
		System.out.println("회원가입이 완료되었습니다.");
		int result = pstmt.executeUpdate();
		System.out.println(result + "건 등록 완료!");
	}
	

}
