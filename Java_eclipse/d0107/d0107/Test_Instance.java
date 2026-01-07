package d0107;

class A{	
	static int n = 100;		// n = 정적변수가 되는것. (static을 사용했기 때문에)
	char c;
	
	// f()가 출력되면 C라는 클래스에 Z가 저장되게 하는 함수 만들기.
	void f() {
		c = 'Z';
	}

}

public class Test_Instance {

	public static void main(String[] args) {
		A a = new A();	// A를 a로도 사용하겠다고 선언. -> 참조변수
		a.c = 'T';		// A의 c에 T를 저장.
		
		// 예시
		A b = new A();	// A를 b로 사용하겠다고 선언.
		A c = new A();	// A를 c로 사용하겠다고 선언.
		
		a.c = 'A';	// a.c에는 A
		b.c = 'B';	// b.c에는 B
		c.c = 'C';	// c.c에는 C
		
		
		System.out.println(a.c);	// A
		System.out.println(b.c);	// B
		System.out.println(c.c);	// C
		
		/*
		System.out.println(a.n);	// 100
		b.n= 200;		// n의 값을 200으로 변경.
		System.out.println(b.n);	// 200 
		System.out.println(c.n);	// 200	-> n은 정적변수이기 때문에 값이 바뀐다. 즉, static n 은 공유하는 변수라는 말.
		
		a.f();			// A에서 선언된 함수 F를 불러옴.
		System.out.println(a.c);	// a.c를 출력해서 (b.c, c.c 둘 다 상관 X) f()가 잘 적용되는지 확인.
		*/
		
		
	}

}
