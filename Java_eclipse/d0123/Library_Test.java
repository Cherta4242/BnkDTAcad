package jjw_Library;

import java.util.Scanner;

public class Library_Test {
	
	
	public static void main(String[] args) throws Exception {
		Service sv = new Service();
		Scanner sc = new Scanner(System.in, "EUC-KR");
		
		String id;
		String pw;
		
		int slc;
		
		// 관리자
		
		//sv.updateBook();
		
		
		System.out.println("================================");
		System.out.println("        안녕하세요! jjwLibrary입니다!");
		while(true) {
			System.out.println("================================");
			System.out.println("            어떤것을 도와드릴까요?");
			System.out.println("--------------------------------");
			System.out.println("1. 회원가입    2. 로그인    3. 책 조회");
			System.out.println("그 외: 그만하겠습니다.");
			System.out.print("--------------------------------\n>> ");
			slc = sc.nextInt();
			System.out.println();
			if(slc == 1) {
				sv.librarySignUp();
				
			}else if(slc == 2) {
				BookLogin blg = new BookLogin();
				BookSearch bs = new BookSearch();
				
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
				if(sv.manager(id, pw) == 1) {
					System.out.println("관리자입니다!");
					while(true) {
						System.out.println("---------------------------------------");
						System.out.println("사용하시려는 기능을 선택해주세요");
						System.out.println("한 명당 하나의 책만 대출이 가능합니다.");
						System.out.println("1. 대출     2. 반납    3. 책 조회    4. 책 추가   그 외: 뒤로가기");
						System.out.print(">> ");
						slc = sc.nextInt();
						System.out.println();
						if(slc == 1) {
							if(sv.BookLoanMem(id, pw) != null) {
								System.out.println("이미 대출중인 책이 있습니다.");
								continue;
							}
							sv.showAllBook();
							sv.loanBook();	
							
						}else if(slc == 2){
							if(sv.BookLoanMem(id, pw) == null) {
								System.out.println("현재 대출 중인 책이 없습니다.");
							}else {
								System.out.println("현재 대출 중인 책: " + sv.BookLoanMem(id, pw));
								System.out.println("반납하시겠습니까?(1. Y      2. N");
								slc = sc.nextInt();
								if(slc == 1) {
									sv.returnBook(sv.BookLoanMem(id, pw), id);
									continue;
								}else {
									continue;
								}							
							}
						}else if(slc == 3) {
							sv.showAllBook();
							System.out.println("확인이 끝나면 아무 숫자키를 입력해주세요");
							System.out.println(">> ");
							slc = sc.nextInt();
						}else if(slc == 4) {
							sv.insertBook();
						}else{
							System.out.println("프로그램을 종료하겠습니다.");
							break;
						}
					}
					System.out.println("좋은 하루 되십시오");
				}else {
					while(true) {
						System.out.println("---------------------------------------");
						System.out.println("사용하시려는 기능을 선택해주세요");
						System.out.println("한 명당 하나의 책만 대출이 가능합니다.");
						System.out.println("1. 대출     2. 반납    3. 책 조회    그 외: 뒤로가기");
						System.out.print(">> ");
						slc = sc.nextInt();
						if(sv.BookLoanMem(id, pw) != null) {
							System.out.println("이미 대출중인 책이 있습니다.");
						}
						System.out.println();
						if(slc == 1) {
							sv.showAllBook();
							sv.loanBook();	
							
						}else if(slc == 2){
							if(sv.BookLoanMem(id, pw) == null) {
								System.out.println("현재 대출 중인 책이 없습니다.");
							}else {
								System.out.println("현재 대출 중인 책: " + sv.BookLoanMem(id, pw));
								System.out.println("반납하시겠습니까?(1. Y      2. N");
								slc = sc.nextInt();
								if(slc == 1) {
									sv.returnBook(sv.BookLoanMem(id, pw), id);
									continue;
								}else {
									continue;
								}							
							}
						}else if(slc == 3) {
							sv.showAllBook();
							System.out.println("확인이 끝나면 아무 숫자키를 입력해주세요");
							System.out.println(">> ");
							slc = sc.nextInt();
						}else{
							System.out.println("프로그램을 종료하겠습니다.");
							break;
						}
					}
					System.out.println("좋은 하루 되십시오");
					break;
				}
			}else if(slc == 3) {
				System.out.println("사용하실 기능을 선택해주세요.");
				System.out.println("1. 전체 책 조회   2. 검색 조회");
				System.out.println("그 외: 되돌아가기");
				System.out.println(">> ");
				slc = sc.nextInt();
				System.out.println();
				if(slc == 1) {
					sv.showAllBook();
					System.out.println("확인이 끝나면 아무 숫자키를 입력해주세요");
					System.out.println(">> ");
					slc = sc.nextInt();
				}else if(slc == 2) {
					sv.searchBook();
					System.out.println("확인이 끝나면 아무 숫자키를 입력해주세요");
					System.out.println(">> ");
					slc = sc.nextInt();
				}else {
				}
			}else {
				break;
			}
		}
		sc.close();
	}
	
}