package d0108;

public class Member {
	// Execution, SaveMember 와 연계되는 클래스입니다.
	
	// 회원정보를 저장.
	// member 클래스를 만들고, 속성은 이름, 전화번호, 성별, 주소(서울, 부산, 인천 등등)
	// 회원 등록 프로그램, 등록하면, 저장되어있어야함.
	// 조회 = 여태까지 등록시킨 사람의 목록 출력.
	// member, 실행, member 들을 저장하는 용도의 클래스까지 3개를 만들어서 main 에서 실행시켜보기.
	// 회원은 최대 10명까지라고 합시다.
	
	
	//--------------------------------------
	private String name;	// 이름 변수
	private String ph;		// 전화번호 변수
	private char gen;		// 성별 변수
	private String road;	// 주소 변수

	//--------------------------------------
	// 생성자 설정
	Member(String name, String ph, char gen, String road){
		this.name = name;
		this.ph = ph;
		this.gen = gen;
		this.road = road;
	}
	
	// ↑ 이것들을 main 에서 생성하고 나오는 것들을 SaveMember 에 저장해야함.	
	//--------------------------------------
	// 이름 변경 값 필드
	void getName(String name) {
		this.name = name;
	}
	String setName() {
		return name;
	}
	//--------------------------------------
	// 휴대폰 번호 변경 값 필드
	void getPh(String ph) {
		this.ph = ph;
	}
	String setPh() {
		return ph;
	}
	//--------------------------------------
	// 성별 변경 값 필드
	char setGen() {
		return gen;
	}
	//--------------------------------------
	// 주소 변경 값 필드
	void getRoad(String road) {
		this.road = road;
	}
	String setRoad() {
		return road;
	}
	

	
	
}
