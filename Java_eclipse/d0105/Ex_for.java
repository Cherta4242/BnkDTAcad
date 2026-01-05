package d0105;


public class Ex_for {

	public static void main(String[] args) {
		
		// for 문의 기본구조.
		// for(변수의 초기 값; 변수의 반복 조건; 변수의 증가){
		//		반복할 코드가 들어갑니다.
		// }
		// 
		
		// i값이 3이 되면 반복문을 종료하세요
		// break는 종료하는 것
		// continue는 뒤에있는 코드를 스킵하고 다음회차 반복으로 넘어가는 것
		/*
		System.out.println("i의 값이 3이되면 반복문을 종료하기.");	
		for(int i = 0; i< 5; i++) {
			System.out.println("i의 값은: " + i);
			if(i == 3) {
				System.out.println("i의 값이 3이 되었으므로 종료하겠습니다.");
				break;
				
			}
		}
		*/
		
		// i++와 ++i의 차이
		/*
		int r = 0;
		int i = 0;
		r = 3 + i++;	// 3 출력 -> i가 먼저 더해짐
		r = 3 + ++i;	// 4 출력 -> 1이 증가된 i가 더해짐
		*/
		// System.out.println(r);
		System.out.println();
		
		// 중첩반복문
		System.out.print("중첩반복문의 예시");
		for(int k = 0;k < 3;k++) {
			System.out.println("바깥쪽 반복문 실행....");
			for(int m = 0;m < 5; m++) {
				System.out.println("\t안쪽 반복문 실행....");
			}
		}
		System.out.println();
		
		// 중첩반복문을 사용한 구구단 만들기
		System.out.println("구구단을 실행하여 보겠습니다.");
		for(int n=0;n<1;n++) {
			for(int m = 0;m < 9; m++) {
				System.out.print((m+1) + "단 입니다." + "\t");
			}
			System.out.print("\n");
			for(int j = 1; j<10;j++) {
				for(int k = 1; k<10;k++) {
					System.out.print("\t" + k + "X" + j + "=" + (k*j) + "\t");
				}
				System.out.print("\n");
			}

		}
		System.out.println();
		
		// *이 다섯개씩 다섯 번 나오게 하기
		System.out.print("*이 다섯개씩 다섯 번 나오게 하기\n");
		for(int i = 0; i<5; i++) {
			for(int l = 0; l<5; l++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		// *이 하나씩 증가해서 다섯 개 찍히게 만들기
		// *
		// **
		// ***
		// ****
		// ***** 이렇게
		System.out.println("별이 한 줄당 하나씩 증가해서 다섯 줄에  다섯 개가 찍히게 만들기");
		for(int i = 0; i<5; i++) {
			for(int l = 0; l <= i; l++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
