package d0109;

import java.util.Scanner;

public class Test_InfinityArray {

	public static void main(String[] args) {
		// InfinityArray와 연계됩니다.
		// 무한배열 만들기.
		// 최초의 배열 길이 값은 3.

		int a;			// 배열에 대입시킬 값을 입력받을 변수
		int select;		// (Yes or No)입력받을 변수
		boolean flag = true;		// 무한 반복문을 위한 참 거짓 값.
		int del;
		
		// 스캐너 On
		Scanner sc = new Scanner(System.in);
		// 배열 생성자 선언
		InfinityArray ifarr = new InfinityArray();		// 배열 생성
		
		while(flag) {	// 유저가 원하는 만큼 넣을 수 있도록 무한 반복 작동
			

			System.out.println("1. 숫자 넣기   2. 숫자 삭제   3. 그만");
			System.out.print(">> ");
			select = sc.nextInt();	// 문자열의 첫번째 값을 char 로 변수에 대입
			if(select == 1) {		// 숫자 넣기
				System.out.println("넣고 싶은 값을 작성");
				System.out.print(">> ");
				a = sc.nextInt();
				ifarr.insert(a);		// 스캐너로 받은 값을 ifarr 배열 안에 저장.
				ifarr.showArray();	// 현재 저장되어 있는 배열값들을 불러옴
				System.out.println("계속 진행하겠습니다.");		
				System.out.println("----------------------");		// 구분선
			}else if(select == 2) {	// 숫자 삭제
				System.out.println("몇번째 값을 삭제하시겠습니까?");
				System.out.println(">> ");
				del = sc.nextInt();
				ifarr.deleteArray(del);
				ifarr.showArray();
			}else{					// 1, 2 를 제외한 모든 것들
				System.out.println("그만하겠습니다.");
				flag = false;			// 그만하겠습니다를 선택하면 반복문 종료
			}
		}
	
		sc.close();		// 스캐너 닫기.
	}

}
