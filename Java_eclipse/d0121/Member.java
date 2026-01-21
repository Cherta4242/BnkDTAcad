package d0121;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class Member {	
	
	Scanner sc = new Scanner(System.in);
	
	String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
	String user = "green";
	String pw = "1234";
	
	String id;
	String pwd;
	String name;
	boolean flag = true;
	
	
	
	
	public void signUPLogin() throws Exception {
		LoginCheck lc = new LoginCheck();

		Connection conn = DriverManager.getConnection(url, user, pw);
		PreparedStatement pstmt = null;
		
		String src = "SELECT COUNT(*) AS cnt FROM TestMember WHERE id = ?";
		
		char yn;
		System.out.println("회원이십니까?(Y/N)");
		yn = sc.next().charAt(0);
		while(true) {
			if(yn == 'Y'||yn == 'y'||yn == 'ㅛ') {
				while(true) {
					// 회원 - 로그인하기
					System.out.print("아이디를 입력하세요\n>>");
					id = sc.next();
					System.out.println();
					System.out.print("비밀번호를 입력하세요\n>>");
					pwd = sc.next();
					System.out.println();
					if(lc.Login(id, pwd)) {
						break;
					}
				}
				break;
			}else {
				System.out.println("회원가입하겠습니다.");
				while(flag) {
					// 비회원 - 회원가입하기
					System.out.print("사용하실 아이디를 입력해주세요!\n>> ");
					id = sc.next();
					pstmt = conn.prepareStatement(src);
					pstmt.setString(1, id);
					ResultSet rs = pstmt.executeQuery();
					rs.next();
					int result = rs.getInt("cnt");
					
					if(result == 1) {	
						System.out.println("이미 존재하는 아이디입니다.");
						continue;
					}
					System.out.print("\n사용하실 비밀번호를 입력해주세요!\n>> ");
					pwd = sc.next();
					System.out.print("\n사용하실 이름을 입력해주세요!\n>> ");
					name = sc.next();
					System.out.println();
					new SignUp(id, pwd, name);
					flag = false;
				}
			}
			System.out.println("로그인 하시겠습니까?(Y/N)\n>> ");
			yn = sc.next().charAt(0);
			if(yn == 'Y'||yn == 'y'||yn == 'ㅛ') {
				continue;
			}else {
				System.out.println("시스템을 종료하겠습니다.");
				break;
			}
		}
	}
	
	public void show() throws Exception {
		ViewMember vm = new ViewMember();
		
		vm.view();
	}
	public void showAllName() throws Exception{
		ViewMember vm = new ViewMember();
		
		vm.showAllMember();
	}
}
