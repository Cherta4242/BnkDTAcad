package d0119;

interface HowLong{
	int len(String s);
}

public class Ex10_OneParamOneReturn {

	public static void main(String[] args) {
		
		HowLong hl;
		
		hl = new HowLong() {
			@Override
			public int len(String s) {
				return s.length();
			}
		};
		System.out.println(hl.len("Hello"));
		
		hl = (s) -> {
			return s.length();
		};
		System.out.println(hl.len("Good"));
		
		hl = s -> s.length();
		System.out.println(hl.len("bye"));
		
	}
}
