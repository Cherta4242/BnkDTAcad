package d0115_4;

import java.util.ArrayList;

public class Board {
	
	// 각 기능들을 만들어서 스크린에다가 다 받을 생각으로 해볼까?
	ArrayList<TitleAndContent> tac = new ArrayList<TitleAndContent>();
	
	// C
	public void insertBoard(TitleAndContent t) {
		tac.add(t);
	}

	
	// R
	public void showSubject() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		for(int i = 0; i < tac.size(); i++) {
			System.out.print(i+1 + "번 게시물: ");
			tac.get(i).getT();
			System.out.println();
			System.out.println("=====================================");
		}
	}
	
	// R
	public void selectSubject(int idx){
		for(int i = 0; i < 15; i++) {
			System.out.println();			
		}
		System.out.println("=========================================");
		System.out.println("                Just Board               ");
		System.out.println("=========================================");
		System.out.print("   제목: "); 
		tac.get(idx).getT();
		System.out.println("=========================================");
		System.out.print("   내용: ");
		tac.get(idx).getC();
		for(int i = 0; i < 15; i++) {
			System.out.println();			
		}
		System.out.println("=========================================");
		System.out.println("   댓글: ");
		System.out.println();	
		System.out.println();
		System.out.println("=========================================");

	
	}
	
	
	// U
	public void updateTitle(int idx, TitleAndContent std) {
		tac.set(idx, std);
	}
	
	
	// D
	public void deleteSubject(int i) {
		tac.remove(i - 1);
	}
	
	
	
}
