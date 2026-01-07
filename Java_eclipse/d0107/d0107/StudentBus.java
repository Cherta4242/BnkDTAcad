package d0107;

public class StudentBus {
	// 학생은 이름, 학년, 가진돈으로구성된다.
	// 학생은 버스를 탄다.
	// 버스를 탈 때 가진 돈의 1000원을 버스요금으로 지불한다. 
	// 학생은 자기 정보 콘솔 출력기능을 제공한다.
	
	// 버스는 버스번호와 승객 수, 요금 합계로 구성된다.
	// 버스는 돈을 받으면 승객 수를 1 증가시키고, 요금 합계가 받은 요금만큼 증가한다. 
	// 버스는 자기 정보콘솔 출력기능을 제공한다. 
	// 학생 클래스와 버스 클래스 실행클래스를 작성하시오.
	
	// private 를 사용하여 외부에서 접근 거부
	private String name;	// 이름
	private int grade;		// 학년
	private int money = 0;	// 소지금
	
	// 학생의 정보 입력하기.
	StudentBus(String name, int grade, int money){
		this.name = name;	// 학생 이름 대입
		this.grade = grade;	// 학생 학년 대입
		this.money = money;	// 학생 초기 소지금 대입
	}
	
	//-------------------------------------
	// 학생 이름
	void getName(String name) {
		this.name = name;
	}
	String setName() {
		return name;
	}

	//-------------------------------------
	// 학생 학년
	void getGrade(int grade) {
		this.grade = grade;
	}
	int setGrade() {
		return grade;
	}
	
	//-------------------------------------
	// 가지고 있는 돈
	void getMoney(int money) {
		this.money = this.money + money;
	}
	int setMoney() {
		return money;
	}
	
	//-------------------------------------
	// 정보 출력 기능
	String stuInfo() {
		return "\n이름: " + name + "\n학년: " + grade + "학년\n소지금: " + money + "\n";
	}
	
	//-------------------------------------
	int getOnBus(BusStudent bs) {
		bs.getOnBus();
		money = money - 1000;
		return money;
	}
	
	//-------------------------------------

	
	
}
