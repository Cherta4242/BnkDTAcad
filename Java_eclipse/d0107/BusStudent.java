package d0107;

public class BusStudent {
	// 학생은 이름, 학년, 가진돈으로구성된다.
	// 학생은 버스를 탄다.
	// 버스를 탈 때 가진 돈의 1000원을 버스요금으로 지불한다. 
	// 학생은 자기 정보 콘솔 출력기능을 제공한다.
	
	// 버스는 버스번호와 승객 수, 요금 합계로 구성된다.
	// 버스는 돈을 받으면 승객 수를 1 증가시키고, 요금 합계가 받은 요금만큼 증가한다. 
	// 버스는 자기 정보콘솔 출력기능을 제공한다. 
	// 학생 클래스와 버스 클래스 실행클래스를 작성하시오.
	
	
	private String number;	// 버스 번호
	private int buscount;	// 버스 승객 수
	private	int allMoney = 0;	// 요금 합계
	
	
	// 버스의 정보 입력하기.
	BusStudent(String number){
		this.number = number;	// 버스 번호 대입
		buscount = 0;			// 버스 승객 수 대입
		allMoney = 0;			// 버스가 가지고 있는 돈 대입
	}
	
	//-------------------------------------
	// 버스 이름 변경
	void getNumber(String number) {
		this.number = number;
	}
	String setNumber() {
		return number;
	}
	
	
	//-------------------------------------
	// 현재 버스 승객 수 출력
	int setBusCount() {
		return buscount;
	}
	
	//-------------------------------------
	// 현재 버스 소지금
	int setAllmoney() {
		return allMoney;
	}
	
	//-------------------------------------	
	// 버스를 탔을 때
	void getOnBus() {
		buscount = buscount + 1;
		allMoney = allMoney + 1000;
	}
	
	// 버스 내렸을 때
	void getOffBus() {
		buscount = buscount - 1;
	}
	
	//-------------------------------------
	// 버스의 탑승객 수 출력
	public String busInfo() {
		return "버스 번호: " + number + "버스 탑승객 수는: " + buscount + "명 입니다.";
	}
	
	
	
	
	
	
	
	
	
}
