package d0119;

@FunctionalInterface
interface Calculaterable<T>{
	T calc(T n, T m);
}

public class LambdaGeneric {
	
	public static void main(String[] args) {
		Calculaterable<Integer>add;
		Calculaterable<Integer>sub;
		Calculaterable<Integer>mul;
		Calculaterable<Double>div;
		Calculaterable<Double>mod;
		
		add = (n, m) -> n + m;
		sub = (n, m) -> n - m;
		mul = (n, m) -> n * m;
		div = (n, m) -> n / m;
		mod = (n, m) -> n % m;
		
		System.out.println(add.calc(5, 2));
		System.out.println(sub.calc(5, 2));
		System.out.println(mul.calc(5, 2));
		System.out.println(div.calc(5d, 2d));	// double의 약자.
		System.out.println(mod.calc(5d, 2d));
	}
}
