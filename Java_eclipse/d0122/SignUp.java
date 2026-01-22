package d0122;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// DB Access - 회원가입 기능
public class SignUp {	
	
	// DB 연결 변수 선언
	String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
	String user = "green";
	String pw = "1234";
	
	
	
	// 회원가입 할 때 사용할 생성자.
	SignUp(String id, String pwd, String name) throws Exception {
				
		// DB 접속
		Connection conn = DriverManager.getConnection(url, user, pw);		
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Member(id, password, name) VALUES (?, ?, ?)");
		
		// ??? -> 1, 2, 3번 자리에 id, pwd, name 세팅
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		pstmt.setString(3, name);
		
		// 확인용 변수 check	/	실행문 pstmt.executeUpdate()
		int check = pstmt.executeUpdate();
		if(check == 1) {
			System.out.println("회원가입 완료!");
		}else {
			System.out.println("회원가입 실패!");
		}
	}
	
	// 생성자만 선언할 때 사용
	SignUp(){
		
	}
	
}
