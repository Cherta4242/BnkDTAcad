package d0116_2;

public class Person implements Comparable<Person>{
	
	private String name;
	private int age;
	
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	// 인터페이스 Comparable의 int compareTo(Object o) 메소드를 구현하여 
	// 객체자료의 순서를 판단할 수 있도록 한다.
	// - 인자로 전달된 o가 작으면 양수 반환
	// - 인자로 전달된 o가 크면 음수 반환
	// - 인자로 전달된 o가 같으면 0 반환
	
	@SuppressWarnings("unused")
	public int compareTo(Person o) {
		
		/*
		// 나이 비교
		if(this.age > ((Person) o).age) {
			System.out.println("1 반환");
			return 1;
		}else if(this.age < ((Person) o).age) {
			System.out.println("-1 반환");
			return -1;
		}else {
			System.out.println("0 반환");
			return 0;
		}
		//return age - o.age;
		*/
		
		
		// 문자열 비교
		int aname = this.name.length();
		int bname = o.name.length();
		int len;
		if(aname > bname) {
			len = bname;
		}else if(aname < bname) {
			len = aname;
		}else {
			len = aname;
		}
		
		for(int i = 0; i < len; i++) {
			char ac = this.name.charAt(i);
			char bc = o.name.charAt(i);
			
			if(ac > bc) {
				return 1;
			}else if(ac < bc) {
				return -1;
			}else {
				return 0;
			}
		}
		return 0;
	}
	
	
	@Override
	public String toString() {
		return name + " : " + age;
	}
}
