package d0109;

import java.util.Scanner;

public class Test_SignLog {

	public static void main(String[] args) {
		// 이 파일은 sign up, login 과 연계됩니다.		
		
		// 회원가입 iD, PASSWORD, 이름, 성별(남자, 여자)
		// 필수항목 표시를 하는데 ID, Password, 이름 세 가지.
		// 프로그램을 시작하면 메뉴가 두개 - 1. 회원가입, 2. 로그인.
		// 회원가입 - 아이디, 패스워드, 이름  - 회원가입이 완료되었습니다. 로그인 하시겠습니까?
		// 아이디(4글자 이상), 패스워드(8글자 이상)
		// 로그인 - 아이디, 패스워드를 입력하세요 출력.
		// 제대로 입력하면 "길동님 로그인 되었습니다" 출력.
		
		// 입력받아야 하니까 스캐너 선언.
		Scanner sc = new Scanner(System.in);
		
		Login lomb = new Login();
		
		// 생성자 선언하고 값 대입해보기.
		SignUp member1 = new SignUp("cherta42", "jjw3125227!", "장진우", "남자");
		lomb.inputSignup(member1);
		// 회원가입 할 때 입력받은 값을 넣을 변수
		String id = "";
		String password = "";
		String name = "";
		String gen = "";
		
		int genselect = 0; // 성별을 입력할건지 물어보는 변수
		
		
		boolean flag = true;
		
		System.out.println("하시려는걸 선택");
		System.out.println(" 1. 회원가입    2. 로그인");
		int select = sc.nextInt();
		if(select == 1) {		// 1. 회원가입 기능 구현
			System.out.println("회원가입을 시작하겠습니다.");
			
			// ID가 4자리 이상 입력할 때까지 반복
			while(flag) {
				System.out.println("사용하시려는 ID를 입력해주세요");
				System.err.println("필수 항목입니다");		// 필수항목이라고 err를 사용하여 빨간색 글 출력
				System.out.print(">> ");
				id = sc.next();
				if(id.length() < 4) {
					System.out.println("잘못 입력하셨습니다.\n\n\n");
				}else {
					flag = false;
				}
			}
			flag = true;
			
			// PASSWORD가 8글자 이상 입력할 때까지 반복
			while(flag) {
				System.out.println("사용하시려는 Password를 입력해주세요");
				System.err.println("필수 항목입니다");
				System.out.print(">> ");
				password = sc.next();
				if(password.length() < 8) {
					System.out.println("잘못 입력하셨습니다.\n\n\n");
				}else {
					flag = false;
				}
			}
			flag = true;
			
			// 입력을 제대로 받을때까지 무한반복 실행
			while(flag) {	
				System.out.println("사용하시려는 이름을 입력해주세요");
				System.err.println("필수 항목입니다");
				System.out.print(">> ");
				name = sc.next();
				if(name.length() < 1) {
					System.out.println("공백은 허용하지 않습니다.\\n\\n\\n");
				}else {
					flag = false;
				}
			}
			flag = true;
			
			// 성별 입력받기
			System.out.println("성별을 입력하시겠습니까?");
			System.out.println("1. 예   그 외. 아니오");
			System.out.print(">> ");
			genselect = sc.nextInt();
			// 예 입력받으면 if 실행
			if(genselect == 1) {
				while(flag) {		// 맞는 입력을 받을때까지 무한반복 실행
					System.out.println("성별을 입력해주세요");
					System.out.print(">> ");
					gen = sc.next();
					if(gen.equals("남자")) {	// 남자라고 제대로 입력했으면 반복문 탙출
						flag = false;
					}else if(gen.equals("여자")) {	// 여자라고 제대로 입력했으면 반복문 탈출
						flag = false;
					}else {
					}
				}
				flag = true;
				
			}else{
				System.out.println("넘어가겠습니다.");
			}
			
			
			if(genselect == 1) {
				SignUp member2 = new SignUp(id, password, name, gen);
				lomb.inputSignup(member2);
			}else {
				SignUp member2 = new SignUp(id, password, name);
				lomb.inputSignup(member2);
			}

			// 회원가입 완료("회원가입이 완료되었습니다" 출력 완료)
			System.out.println("로그인 하시겠습니까?");
		}else if(select == 2) {			// 2. 로그인 기능
			// 기존회원 아이디 입력하기
			System.out.println("ID를 입력해주세요.");
			System.out.println(">> ");
			id = sc.next();
			
			// 기존회원 비밀번호 입력하기
			System.out.println("password를 입력해주세요.");
			System.out.println(">> ");
			password = sc.next();
			if(id.equals(member1.getId()) && password.equals(member1.getPassword())) {
				lomb.inputSignup(member1);
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
		}
		
		
		
		
		sc.close();
	}

}
