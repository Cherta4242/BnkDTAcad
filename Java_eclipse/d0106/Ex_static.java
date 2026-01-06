package d0106;

import java.util.Scanner;

public class Ex_static {
	// 계산기를 만들어 봅니다.
	// 덧셈~나눗셈까지의 클래스를 모두 public static으로 만들고
	// 스스로 추가적인 발상을 해봅시다.
	
	
	public static int plus(int a, int b) {	// 덧셈 클래스
		int A = a + b;	// return할 A에 a + b값을 대입.
		
		return A;
	}
	public static int minus(int a, int b) {	// 뺄셈 클래스
		int A = a - b;	// return할 A에 a - b값을 대입.
		
		return A;
	}
	public static int mul(int a, int b) {	// 곱셈 클래스
		int A = a * b;	// return할 A에 a * b값을 대입.
		
		return A;
	}
	public static int div(int a, int b) {	// 나눗셈 클래스
		int A = a/b; // return할 A에 a / b값을 대입.
		return A;
	}
	public static int div2(int a, int b) {	// 나머지 클래스
		int A = a%b;	// return할 A에 a % b값을 대입.
		return A;
	}
	

	public static void calc(int a, int b) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("계산기 입니다.어떤 것을 선택하시겠습니까?");
		System.out.println("1. 더하기  2. 빼기  3. 곱하기  4. 나누기");
		int select = sc.nextInt();
		
		switch(select) {
			case 1:
				System.out.println(a+b);
				plus(a, b);
				break;
			case 2:
				System.out.println(a-b);
				minus(a, b);
				break;
			case 3:
				System.out.println(a*b);
				mul(a, b);
				break;
			case 4:
				div(a, b);
				System.out.println(a/b);
				div2(a, b);
				System.out.println(a%b);
				break;
			default:
				System.out.println("다시 실행하여 주십시오");
		}
		sc.close();
		
	}
	
	public static int[] divNew(int A[], int a, int b) {
		A[0] = a / b;
		A[1] = a % b;
		
		return A;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] A = new int[5];
		// int[] B = new int[2];
		int cnt = 0;
		int ending = 0;

		while(ending <= 1) {
			
			System.out.println("계산기를 실행하기전 실행하실 숫자를 입력해주세요.");
			System.out.print("숫자 1: ");
			int a = sc.nextInt();
			System.out.println("숫자 2: ");
			int b = sc.nextInt();
			
			for(int i = 0; i < 5; i++) {
				switch(i) {
					case 0:
						A[i] = plus(a, b);
						break;
					case 1:
						A[i] = minus(a, b);
						break;
					case 2:
						A[i] = mul(a, b);
						break;
					case 3:
						A[i] = div(a, b);
						break;
					case 4:
						A[i] = div2(a, b);
						break;
					default:
				}
			}
			calc(a, b);
			System.out.println(".\n.\n.\n.\n덧셈, 뺄셈, 곱셈, 나눗셈과 나머지의 값입니다.");
			
			for(int i = 0; i < 5; i++) {
				System.out.print(A[i]+ ", ");
			}
			
			System.out.println("계산기를 한 번 더 실행하시겠습니까?");
			System.out.println("1. Yes   2. No >> ");
			int user = sc.nextInt();
			if(user != 1) {
				ending++;
			}else {
				System.out.println("다시 실행시키겠습니다.");
				cnt++;
			}
			
			sc.close();
		}
		System.out.println("총 " + cnt + "번 실행하셨습니다.");

		System.out.println("\n\n");
		/*
		divNew(B, a, b);
		for(int i = 0; i < 2; i++) {
			System.out.print(B[i] + " ");
		}
		*/
		
		sc.close();

		// 이건 실패한 코드입니다.
		// 나중에 고쳐야지
	}

}
