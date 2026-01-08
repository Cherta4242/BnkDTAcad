package d0108;

import java.util.Scanner;

public class Test_GessingGame {

	public static void main(String[] args) {
		// 스캐너 선언.
		Scanner sc = new Scanner(System.in);
		// 생성자 선언.
		GessingGame GG = new GessingGame();
		
		int count = 0;

		char Answer;
		// 먼저 맞추어야 되는 별 개수 출력해주기.
		GG.changeword();
		GG.changeStar();
		GG.printstar();
		GG.changeSame();
		
		// 답으로 낼 단어를 대입시킬 변수.
		System.out.println("문자 적기. 제한은 " + (GG.star.length + 2) + "번");
		for(int i = 0; i < (GG.star.length+2); i++) {

			System.out.print(">>");
			Answer = sc.next().charAt(0);
			GG.compare(Answer);

			count = 0;	// 비교해서 맞는 만큼 카운터 값 증가시킬거 .
			
			for(int j = 0; j < GG.star.length; j++) {
				if(GG.same[j] == GG.star[j]) {
					count++;
				}
			}
			
			if(count == GG.word.length) {	// 카운트값이 문자열의 길이와 같아지면
				System.out.println("맞추셨습니다.");	// 맞췄다고 알려주고
				break;	// 끝내기
			}
			
		}
		if(count != GG.word.length) {	// 만약 카운트값이 문자열의 길이와 다르다면?
			System.out.println("맞추셨습니다.");	// for 문 안에서 확인하고 나온거니까 못맞췄다고 알려주기.
		}
		
		

		

	sc.close();
	}

}
