package d0112_Test2;

public class Irregular extends Company{
	int salary;
	String num;
	String name;
	
	Irregular(String num, String name, int salary){
		this.num = num;
		this.name = name;
		this.salary = (10060 * salary) * 25;
		
	}
	
	public void getName() {
		
	}
	
	public void getNum() {
		
	}

	
	
	public void Show() {
		System.out.println("사번:\t" + num);
		System.out.println("이름:\t" + name);
		System.out.println("월급:\t" + salary + "원");
	}
}
