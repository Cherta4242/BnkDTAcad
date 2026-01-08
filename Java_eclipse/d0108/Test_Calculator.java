package d0108;



public class Test_Calculator {

	public static void main(String[] args) {
		// 계산기만들기 - 이전엔 메인 메소드가 있는 실행 메소드에서사칙연산하는 각각의 함수를 만들어 메인에 불러서 사용했었다.
		// 이번엔 클래스를 분리시켜서 만들어보자.


		int n = 10;	// 숫자 1 지정
		int n2 = 5;	// 숫자 2 지정
		int result = 0;	// 결과값 받을 변수 지정
		int sel = 3;	// 연산 선택 변수 지정
		
		switch(sel) {	// 연산할 필드 선택
		case 1:
			result = Calculator.add(n, n2);	// 덧셈필드
			break;
		case 2:
			result = Calculator.sub(n, n2);	// 뺄셈 필드
			break;
		case 3:
			result = Calculator.mul(n, n2);	// 곱셈 필드
			break;
		case 4:
			result = Calculator.dev(n, n2);	// 나눗셈 필드
			break;
		default:
		}

		// 결과 출력
		System.out.println("결과: " + result);
		
		
	}

}
