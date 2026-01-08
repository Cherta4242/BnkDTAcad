package d0108;

public class SaveMember {
	// Member, Execution 과 연계되는 클래스입니다.
	
	
	// 회원정보를 저장.
	// member 클래스를 만들고, 속성은 이름, 전화번호, 성별, 주소(서울, 부산, 인천 등등)
	// 회원 등록 프로그램, 등록하면, 저장되어있어야함.
	// 조회 = 여태까지 등록시킨 사람의 목록 출력.
	// member, 실행, member 들을 저장하는 용도의 클래스까지 3개를 만들어서 main 에서 실행시켜보기.
	// 회원은 최대 10명까지라고 합시다.

	
	
	// 저장할 배열 생성
	Member[] members = new Member[10];		// 배열을 생성하고, 총 10명까지만 들어갈 수 있게 설정
	private int index = 0;			// 회원이 증가되면 총 몇 명인지 알 수 있는 수
	
	// 오류뜰까봐 그냥 생성자 생성 했습니다.
	SaveMember() {

	}
	
	// 멤버 대입시키기.
	void inputMember(int count, Member members) {		// 회원을 등록할 번호와 멤버 정보를 입력받음
		System.out.println("회원으로 등록되었습니다.");		// "회원으로 등록되었습니다" 라는 문구 출력
		this.members[count-1] = members;			// 회원은 1번~10번, 인덱스는 0~9까지 이므로 -1을 통해 인덱스 값에 맞게 출력
		index++;			// index값을 1 증가시키고 자동으로 등록시켰을 때 총 회원이 몇명인지 미리 설정
	}
	
	// 현재 멤버 출력문 작성
	void showMember() {
		for(int i = 0; i < index; i++) {
			System.out.println("----------------------");		// 구분 선 
			System.out.println("회원 " + (i+1));			// 배열의 인덱스는 0부터 시작하기 때문에 1 증가
			System.out.println("이름	: " + members[i].setName());		// setName을 통해 이름 등록
			System.out.println("전화번호	: " + members[i].setPh());		// setPh를 통해 전화번호 등록
			System.out.println("성별	: " + members[i].setGen());			// setGen을 통해 성별 등록
			System.out.println("지역	: " + members[i].setRoad());		// setRoad를 통해 주소 등록
			System.out.println("----------------------");			// 구분 선
		}

	}
	int getIndex() {
		return index;
	}
	
	
}
