package d0113;

import java.util.Objects;


class A{
	String s;
	
	A(){
		s = "aaa";
	}
	
	// 이퀄즈 오버라이드 기준
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!(obj instanceof A)) return false;
		
		A other = (A)obj;
		if(s == null) {
			return other.s == null;
		}
		// return s.equals(other.s);	
		return Objects.equals(s,  other.s);
	}	
	
	// 해쉬코드 오버라이드 기준
	@Override
	public int hashCode() {
		
		return Objects.hash(s);
	}
}

public class HashcodeAndEquals {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new A();
		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());
		System.out.println(a1.equals(a2));
	}
}
