package d0115_4;

import java.util.Scanner;

public class Board_test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Board board = new Board();
		int l;
		int two;
		boolean flag = true;
		
		board.insertBoard(new TitleAndContent(new Title("아 진짜"), new Content("알고 나니까 쉽긴 하네요")));
		board.insertBoard(new TitleAndContent(new Title("보겠습니다."), new Content("眚")));
		board.insertBoard(new TitleAndContent(new Title("진짜로"), new Content("어려워요 여기서 뭐 다이아몬드?<>?? 어후")));
		
		while(flag) {
			board.showSubject();
			System.out.println("4번 -> 나가기");
			System.out.println("몇 번을 선택하시겠습니까?");
			System.out.print(">> ");
			l = sc.nextInt()-1;
			switch(l) {
				case 1:
				case 2:
				case 3:
					board.selectSubject(l);
					System.out.println("1. 뒤로가기, 2. 삭제");
					two = sc.nextInt();
					if(two == 1) {
						continue;
					}else if(two == 2) {
						board.deleteSubject(l);						
					}
					break;
				default:
					flag = false;
					
			}
			
			
			
		}
		


		
		
		
		sc.close();
	}

}
