package d0107;

public class Student {
	
	
	// Student 클래스를 만들고, 번호, 이름, 성별을 만듬. cnt 변수를 정적변수로 만들고 0으로 고정.
	// 5명의 학생을 만들고, 현재까지 만들어진 학생의 값을 저장하는 정적변수 cnt 를 만들어라.
	// private는 같은 class안에서는 자유롭게 사용가능하지만, 외부에서는 사용 불가.
	private int num = 0;		// 번호
	private String name;		// 이름
	private char gen;			// 성별
	static int cnt = 0;	// 학생 수
	

	
	Student(){

	}
	
	Student(String name, char gen){
		// 생성자에 값을 받고, 안에서 대입시키기.
		num = ++cnt;	// num++; 를 해봤는데 안되더군요.
		this.name = name;	// 이름 값 대입시켜주기.
		this.gen = gen;		// 성별 값 대입시켜주기.
	}
	
	
	// 학생의 정보를 문자열로 반환하겠다.
	// sysout 처럼 그냥 출력하면 문자열이 되는거라더군요.
	String InfotoString(){
		
		
		return "번호: " + num + ", 이름: " + name + ", 성별: " + gen;
		// 근데 num, name, gen은 변수지만 그냥 출력하면 문자열이 된데요. 이게 참 신기하고 이상하네요;
		// 그리고 return 을 이렇게 ""로 적을 수 있는것도 처음 알았음.
		// 외워둘 것.
	}
	
	
	
	// 학생 이름을 바꿀 수 있는 메소드.
	// 즉 이름을 바꿀 수 있는 전용 메소드를 만들기.
	// 보안을 위해 name변수를 private로 잠기게 설정하면 name을 외부에서 사용 불가. 
	// 이후 setName 메소드로 바꿀이름을 받고 Student 안에서 name값을 변경. 
	// 이후 getName 메소드에서 이름값을 return 해주고, return받은 값이 외부에 적용되는 보안을 위한 메소드이다.
	void setName(String name) {
		this.name = name;
	}
	String getName() {
		return name;
	}	
	// 성별도 바꾸는거 만들기.
	void setGen(char gen) {
		this.gen = gen;	
	}
	
	char getGen() {
		return gen;
	}
	
	private int age;
	
	// private age 라는 변수를 만들고 이 변수에 대한 setter를 만들 때 age가 음수는 처리되지 않게 만들기.
	void setAge(int age) {
		if(age < 0) {
			this.age = 0;
			System.out.println("음수는 처리할 수 없으므로 0으로 설정되었습니다.");
		}else {
			this.age = age;
		}
		
	}
	
	int getAge() {
		return age;
	}
	
	

	
	
	
	
}