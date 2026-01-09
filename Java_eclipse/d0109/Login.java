package d0109;


public class Login {
	// 이 파일은 Test_SignLog, SignUp 과 연계됩니다.
	
	// 회원가입 iD, PASSWORD, 이름, 성별(남자, 여자)
	// 필수항목 표시를 하는데 ID, Password, 이름 세 가지.
	// 프로그램을 시작하면 메뉴가 두개 - 1. 회원가입, 2. 로그인.
	// 회원가입 - 아이디, 패스워드, 이름  - 회원가입이 완료되었습니다. 로그인 하시겠습니까?
	// 아이디(4글자 이상), 패스워드(8글자 이상)
	// 로그인 - 아이디, 패스워드를 입력하세요 출력.
	// 제대로 입력하면 "길동님 로그인 되었습니다" 출력.
	
	
	
	SignUp[] member = new SignUp[2];
	
	String id;
	String password;
	int index = 0;

	// 오류뜰까봐 그냥 써놓았습니다.
	Login() {
		
	}

	
	void inputSignup(SignUp member) {
		System.out.println("회원으로 등록되었습니다.");
		this.member[index] = member;
		index++;			
	}
	
	
	
	
	
}
