package d0122;

import java.util.Scanner;

// 모든 DB Access 들을 모은 파일
public class Service {	
	Scanner sc = new Scanner(System.in);
	Login log = new Login();
	
	// SignUp 에서 회원가입 기능을 받음.
	public void signUp() throws Exception{
		String id;
		String pw;
		String name;
		
		System.out.println("회원가입을 시작하겠습니다.\n");
		while(true) {
			System.out.print("사용하실 ID를 입력해주세요!\n>> ");
			id = sc.next();
			if(log.idCheck(id) == 1) {
				System.out.print("사용할 수 없는 ID입니다.\n다시 한 번 ");
			}else {
				break;
			}
		}
		System.out.print("\n사용하실 Password를 입력해주세요!\n>> ");
		pw = sc.next();
		System.out.print("\n사용하실 이름을 입력해주세요!\n>> ");
		name = sc.next();
		
		new SignUp(id, pw, name);
		
	}
	
	// Login 에서 로그인 기능을 받음
	public void logIn()throws Exception{
		Login log = new Login();
		String id;
		String pw;
		
		System.out.println("로그인을 시작하겠습니다.");
		while(true) {
			System.out.print("ID를 입력해주세요!\n>> ");
			id = sc.next();
			System.out.print("\nPassword를 입력해주세요!\n>> ");
			pw = sc.next();
			
			if(log.newLogin(id, pw) == 1) {
				System.out.println("\n로그인 되었습니다.");
				break;
			}else {
				System.out.print("\n로그인을 실패하였습니다.\n다시 한 번 ");
			}
			
		}
		
	}
	
}
