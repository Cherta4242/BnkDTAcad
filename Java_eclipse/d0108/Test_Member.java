package d0108;

import java.util.Scanner;

public class Test_Member {
	public static void main(String[] args) {
		// Member, Execution, SaveMember 와 연계되는 실행 클래스파일 입니다.
		
		// 회원정보를 저장.
		// member 클래스를 만들고, 속성은 이름, 전화번호, 성별, 주소(서울, 부산, 인천 등등)	-> 완료
		// 회원 등록 프로그램, 등록하면 회원들의 정보가 저장되어 있어야함.
		// 조회 = 여태까지 등록시킨 사람의 목록 출력. 
		// member, 실행, member 들을 저장하는 용도의 클래스까지 3개를 만들어서 main 에서 실행시켜보기.
		// 회원은 최대 10명까지라고 합시다.
		
		// Main 에서 회원정보를 생성자를 통해 저장. -> 저장은 SaveMember 안에.
		
		// Member(이름, 전화번호(010-nnnn-nnnn), 성별, 주소(부산, 서울 등등))으로 작성해야 합니다.
		
		// SaveMember 에 저장할 생성자 선언
		SaveMember members = new SaveMember();	
		// Member 생성자 호출 및 멤버 생성
		// 1 ~ 5번 멤버를 등록
		Member mb1 = new Member("장진우", "010-0000-0000", 'M', "부산");		// 멤버 1
		Member mb2 = new Member("김건엽", "010-1234-5678", 'M', "부산");		// 멤버 2
		Member mb3 = new Member("허 윤", "010-9999-9999", 'M', "부산");		// 멤버 3
		Member mb4 = new Member("허봉식", "010-9876-5432", 'M', "부산");		// 멤버 4
		Member mb5 = new Member("김주현", "010-2468-1012", 'M', "부산");		// 멤버 5
		
		
		// 멤버를 스캐너로 입력받아서 등록하기.
		// 스캐너 호출
		Scanner sc = new Scanner(System.in);
		
		
		// 1 ~ 5번 멤버를 회원으로 등록
		members.inputMember(1, mb1);		// 회원 1
		members.inputMember(2, mb2);		// 회원 2
		members.inputMember(3, mb3);		// 회원 3
		members.inputMember(4, mb4);		// 회원 4
		members.inputMember(5, mb5);		// 회원 5
		
		
		// 생각 확장) 유저에게 공지사항 알려주고, 스캐너를 통해 정보 입력받아 회원등록하기.
		System.out.println("회원으로 등록하시기 전 주의사항입니다.");		// 주의사항 출력
		System.out.println("Member(이름, 전화번호(010-nnnn-nnnn), 성별, 주소(부산, 서울 등등))으로 작성해야 합니다.");		// 주의사항 출력
		System.out.println("현재 회원은 총 " + members.getIndex() + "명 있습니다.");			// 인덱스에 몇 명 있는지 알려주기
		System.out.println("자동으로 " + (members.getIndex() + 1) + "으로 저장됩니다.");		// 자동으로 등록하기 -> 오류고치기 싫어서
		System.out.println("등록하시겠습니까?\n  Y     N");		// 등록여부 받음(Y or N)
		System.out.print(">> ");
		char user = sc.next().charAt(0);
		if(user == 'Y') {		
			System.out.print("\n이름	: ");			// 이름 입력받기
			String name = sc.next();
			System.out.print("\n휴대전화 번호	: ");	// 전화번호 입력받기
			String ph = sc.next();
			System.out.print("\n성별	: ");			// 성별 입력받기
			char gen = sc.next().charAt(0);
			System.out.print("\n주소	: ");			// 주소 입력받기
			String road = sc.next();
			
			int num = (members.getIndex() + 1);			// 회원에 등록할 때 -1을 해주었기 때문에 index 가 count가 증가되어 인덱스 출력 오류가 발생.
			Member mb = new Member(name, ph, gen, road);		// 스캐너로 입력받은 값으로 멤버 등록
			members.inputMember(num, mb);				// 멤버를 회원에 등록(번호, 멤버정보)
		}else {
					
		}
		
		


		System.out.println("\n현재 회원들을 출력하시겠습니까?");		// 현재까지 등록된 회원들 출력할것인가 물어보기
		System.out.println(" Y       N   ");
		System.out.print(">> ");
		user = sc.next().charAt(0);	// 유저 선택 받기(Y or N)
		if(user == 'Y') {
			System.out.println();
			// SaveMember에 등록되어있는 멤버 출력
			members.showMember();
		}else {
			// 종료
			System.out.println("출력을 종료합니다.");
		}
		
		// 테스트용
		// members.showMember();

		sc.close();		// 스캐너 닫아주기.
	}

}
