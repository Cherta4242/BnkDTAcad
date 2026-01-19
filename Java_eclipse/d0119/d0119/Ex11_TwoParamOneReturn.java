package d0119;

@FunctionalInterface
interface Calculate{
	int add(int n, int m);
}

/*
interface Calculate{
	int add(int n, int m);
	default int sub(int n, int m) {
		return n - m;
	}
	static int mul(int n, int m) {
		return n * m;
	}
}
*/
public class Ex11_TwoParamOneReturn {

	public static void main(String[] args) {
		Calculate calc;
		
		calc = (n , m) -> n + m;
		System.out.println(calc.add(2, 1));
		
	}
}
