package jjw_Library;

import java.util.Scanner;

// 모든 기능들 모음.
public class Service {
	Scanner sc = new Scanner(System.in);
	
	// 생성자
	Service(){
		System.out.println("JJW Library입니다!");
		// System.out.println("어떤것을 실행하실 건가요?");
	}
	
	// 책 검색
	public void searchBook() throws Exception{
		BookSearch bs = new BookSearch();

		String bname;
		System.out.println("찾으시려는 책 이름을 입력하세요.\n>> ");
		bname = sc.next();
		System.out.println("찾으시려는 책 목록입니다.");
		System.out.println("-------------------------------");
		bs.searchBook(bname);
		System.out.println("-------------------------------");
	}
	// 모든 책 보기
	public void showAllBook() throws Exception{
		BookSearch bs = new BookSearch();
		
		System.out.println("전체 책 제목 및 위치를 출력합니다.");
		bs.showAll();
	}
	
	// 도서관 회원 회원가입
	public void librarySignUp() throws Exception{
		BookMemberSignUp bmsu = new BookMemberSignUp();
		BookSearch bs = new BookSearch();
		
		String id;
		String pwd;
		String name;
		int manager;
		
		int check;
		
		System.out.println("회원가입을 시작하겠습니다.");
		System.out.print("사용하실 ID를 입력해주세요\n>> ");
		id = sc.next();
		while(true) {
			check = bs.searchId(id);
			if(check == 1) {
				System.out.println("이미 존재하는 ID입니다.");
				System.out.println("다시 한 번 사용하실 ID를 입력해주세요!\n>> ");
				id = sc.next();
			}else {
				break;
			}
		}
		System.out.print("사용하실 PASSWORD를 입력해주세요\n>> ");
		pwd = sc.next();
		System.out.print("사용하실 이름을 입력해주세요\n>> ");
		name = sc.next();
		
		// 가입할 때 이미 매니저는 아니라고 선언.
		manager = 0;
		
		// 회원가입 완
		bmsu.SignUp(id, pwd, name, manager);
		
		
	}
	
	
	// 도서관 관리자 회원가입
	public void managerSignUp() throws Exception{
		BookMemberSignUp bmsu = new BookMemberSignUp();
		BookSearch bs = new BookSearch();
		String id;
		String pwd;
		String name;
		int manager;
		
		int check;
		
		System.out.println("이 기능은 관리자 회원가입입니다.");
		System.out.println("회원가입을 시작하겠습니다.");
		System.out.print("사용하실 ID를 입력해주세요\n>> ");
		id = sc.next();
		while(true) {
			check = bs.searchId(id);
			if(check == 1) {
				System.out.println("이미 존재하는 ID입니다.");
				System.out.println("다시 한 번 사용하실 ID를 입력해주세요!\n>> ");
				id = sc.next();
			}else {
				break;
			}
		}
		System.out.print("사용하실 PASSWORD를 입력해주세요\n>> ");
		pwd = sc.next();
		System.out.print("사용하실 이름을 입력해주세요\n>> ");
		name = sc.next();
		manager = 1;
		bmsu.SignUp(id, pwd, name, manager);
	}
		
	// 로그인
	public void libraryLogin() throws Exception{
		BookLogin blg = new BookLogin();
		BookSearch bs = new BookSearch();

		String id;
		String pw;
		int loginchk;
		System.out.println("로그인하겠습니다.");
		while(true) {
			System.out.print("아이디를 입력해주세요!\n>> ");
			id = sc.next();
			System.out.print("\n비밀번호를 입력해주세요!\n>> ");
			pw = sc.next();
			loginchk = blg.login(id, pw);
			
			if(loginchk == 1) {
				System.out.println("로그인 되었습니다.");
				System.out.println("***환영합니다 "+ bs.searchName(id, pw) + "님!***");
				break;
			}else {
				System.out.println("아이디, 비밀번호가 틀렸습니다. 다시 입력해주세요!");
			}
		}
	}
		

		// 책 추가
	public void insertBook() throws Exception{
		BookInsert bi = new BookInsert();
		// 책 코드
		String code;
		// 책 이름
		String name;
		// 책 입고 날짜?
		String date;
		// 책 위치?
		String location;
		
		System.out.print("책을 입고하시겠습니까?(Y/N)\n>> ");
		char userselect = sc.next().charAt(0);
		if(userselect == 'Y' || userselect == 'y' || userselect == 'ㅛ') {
			System.out.println("책 코드를 입력해주세요.\n>> ");
			code = sc.next();
			System.out.println("책 이름을 입력해주세요.\n>> ");
			name = sc.next();
			System.out.println("책 입고 날짜를 입력해주세요.\n>> ");
			date = sc.next();
			System.out.println("책 배치 위치를 입력해주세요.\n>> ");
			location = sc.next();
			bi.inserting(code, name, date, location);
		}	
	}
	
	// 책 상태 변경
	public void updateBook() throws Exception{
		BookUpdate bu = new BookUpdate();
		BookSearch bs = new BookSearch();
		String code;
		int i;
		
		System.out.println("1. 책 코드를 작성해주세요.");
		code = sc.next();

		while(true) {
			i = bs.searchCode(code);
			if(i == 0) {
				System.out.println("없는 책입니다.\n다시 한 번 코드를 작성해주세요.");
				code = sc.next();
			}else {
				System.out.println("책을 확인하였습니다.");
				break;
			}	
		}
		
		System.out.println("책 상태를 무엇으로 변경하시겠습니까?");
		System.out.println("1. 미 대출\t 2. 대출 중");
		i = sc.nextInt();
		bu.updating(code, i);
		
		System.out.println("책 상태 변경이 완료되었습니다.");
		
	}
	
	
	
	
}
