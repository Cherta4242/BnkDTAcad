package d0108;


public class Calculator {
	
	
	// 혹시 오류날까봐 그냥 선언한겁니다.
	Calculator(){
		
	}
	
	
	
	
	// 연산자 만들기.
	// static을 선언하면 객체 없이 사용할 수 있기 때문에.
	static int add(int n, int m) {	// 덧셈
		return n + m;
	}
	static int sub(int n, int m) {	// 뺄셈
		return n - m;
	}
	static int mul(int n, int m) {	// 곱셈
		return n * m;
	}
	static int dev(int n, int m) {	// 나눗셈
		return n / m;
	}
	
}
