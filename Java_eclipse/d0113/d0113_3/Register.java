package d0113_3;

public class Register implements ManageMent{

	// 등록

	// 1. 학생의 번호
	private int num=0;
	// 2. 학생의 나이
	private int age;
	// 3. 학생의 이름
	private String name;
	
	

	Register(int num, int age, String name){
		this.num = num;
		this.age = age;
		this.name = name;

	}
	
	public int getNum() {
		return num;
	}
	
	
	public void setName(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	void showStd(){
		System.out.println("=================");
		System.out.println("학번\t: " + num);
		System.out.println("학년\t: " + age);
		System.out.println("이름\t: " + name);
		System.out.println("=================");
	}
}
