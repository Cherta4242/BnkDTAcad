package d0112;
	// 상속

class A{
	int n = 100;
	
	A(){
		System.out.println("A 클래스 인스턴스 생성...");
	}
	
	void f() {
		System.out.println("f() 함수 실행..." + n);
	}
}
class B extends A{
	String s = "A의 값: ";
	
	B(){
		System.out.println("B 클래스 인스턴스 생성...");
	}
	
	void f1() {
		System.out.println("(f1() 함수 시행...) " + s + "n = " + n);
	}
	
}
class C extends A{
	float f;
	
	
	C(){
		System.out.println("C 클래스 인스턴스 생성...");
	}
	void f2() {
		System.out.println("f2() 함수 실행... " + f);
	}
}

public class Test_Inheritence {
	public static void main(String[] args) {
		System.out.println("======================");
		A[] aa = new A[2];
		System.out.println("======================");
		aa[0] = new B();
		System.out.println("======================");
		aa[1] = new C();
		//B x = (B)ab;
		System.out.println("======================");
		B b = (B)aa[0];
		b.f1();
		System.out.println("======================");
		
	}
}
