package d0112_Test2;

public class Regular extends Company{
	int salary;
	String name;
	String num;

	
	// 정규직 추가
	Regular(String num, String name, int salary){
		this.num = num;
		this.name = name;
		this.salary = (((minwage * salary)/10) + (minwage * salary)) * 25;
	}
	

	// 이름
	public void getName() {
		System.out.println("");
	}
	// 사번
	public void getNum() {
		
	}
	
	public void Show() {
		
		System.out.println("사번:\t" + num);
		System.out.println("이름:\t" + name);
		System.out.println("월급:\t" + salary + "원");
	}

	
	
}
