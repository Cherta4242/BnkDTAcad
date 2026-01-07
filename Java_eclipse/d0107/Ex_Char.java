package d0107;

import java.util.Scanner;

public class Ex_Char {
	
	public static void main(String[] args) {
		
		char c = 'A';
		char d = 66;		// Asciicode 방식
		char e = '\u0043';	// Unicode 방식
		char f = '\uAC00';
		
		System.out.println(c);	// A
		System.out.println(d);	// B
		System.out.println(e);	// C
		System.out.println(f);	// 가
		System.out.println((int)c);
		
		System.out.println("char 크기: " + Character.BYTES + "bytes");
		System.out.println("char 최대값: " + (int)Character.MAX_VALUE);
		System.out.println("char 최소값: " + (int)Character.MIN_VALUE);		
		
		for(char i = 'A'; i <= 'Z'; i++) {	// A(65) 부터 Z(90)까지 출력하기
			System.out.print(i + " ");		// 입력받은 i값 출력
		}
		System.out.println();
		for(int i = 65; i <= 90; i++) {		// A(65) 부터 Z(90)까지 출력하기
			System.out.print((char)i + " ");	// 입력받은 i값 char로 바꾸어서 출력(ascii code 사용)
		}
		
		System.out.println();
		System.out.println('A' + 'B');	// -> A(65) + B(66)과 같다.

		//char[] arr = {'A', 'B', 'C'};
		
		Scanner sc = new Scanner(System.in);	// Scanner 사용선언하기
		System.out.println("Input >> ");		// Input에 넣을 값을 입력하세요 출력.
		
		//int input = sc.nextInt();				// 정수 입력받기.
		String cinput = sc.next();				// 문자열 입력받기.
		
		System.out.println(cinput);				// 입력받은 문자열 출력.

		// sc.nextLine()은 이전에 입력했던 것들의 Enter도 받아감. 즉 바로이전에 Enter를 누르는 순간 사용 불가.
		// 따라서 sc.nextLine()을 하나 놔두어주어 이전에 있었던 Enter를 제거한다.
		sc.nextLine();
		String input_nextLine = sc.nextLine();	// nextLine() = 문자뿐만 아닌 문장을 입력받는 함수

		System.out.println(input_nextLine);		// 입력받은 문장 출력
		
		
		
		
		
		sc.close();		// 사용했던 Scanner 닫아주기.
		
	}
}