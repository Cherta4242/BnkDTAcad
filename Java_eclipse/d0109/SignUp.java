package d0109;

public class SignUp {
	// 이 파일은 Test_SignLog, Login 과 연계됩니다.
	
	// 회원가입 iD, PASSWORD, 이름, 성별(남자, 여자)
	// 필수항목 표시를 하는데 ID, Password, 이름 세 가지.
	// 프로그램을 시작하면 메뉴가 두개 - 1. 회원가입, 2. 로그인.
	// 회원가입 - 아이디, 패스워드, 이름  - 회원가입이 완료되었습니다. 로그인 하시겠습니까?
	// 아이디(4글자 이상), 패스워드(8글자 이상)
	// 로그인 - 아이디, 패스워드를 입력하세요 출력.
	// 제대로 입력하면 "길동님 로그인 되었습니다" 출력.
	
	
	private String id;
	private String password;
	private String name;
	private String gen;
	
	
	// 성별 포함 세가지 받기
	SignUp(String id, String password, String name){
		this.id = id;
		this.password = password;
		this.name = name;
		System.out.println("회원가입이 완료되었습니다.");
	}
	// 성별 포함 네가지 받기
	SignUp(String id, String password, String name, String gen){
		this.id = id;
		this.password = password;
		this.name = name;
		this.gen = gen;
		System.out.println("회원가입이 완료되었습니다.");
	}
	
	
	
	// 회원 정보 출력할거.
	void memberInfo(SignUp member) {
		System.out.println("--------------");
		member.getName();
		member.getGen();
		System.out.println("--------------");
	}

	
	
	
	
	// ID변경은 불가하게 합시다.
	String getId() {
		return id;
	}
	
	// Password getset
	void setPassword(String password) {
		this.password = password;
	}
	String getPassword() {
		return password;
	}
	
	// 이름 getset
	void setName(String name) {
		this.name = name;
	}
	String getName() {
		return name;
	}
	
	// 성별 변경도 불가하게 합시다.
	String getGen() {
		return gen;
	}
	
	
	
	
}
