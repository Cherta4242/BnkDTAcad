package d0109;

public class VendingMachine {
	// Test_VendingMachine과 연계됩니다.
	// 음료가 들어있는 class 는 Drink 입니다.
	
	// 선생님) 너희가 포트폴리오에 작성할 수 있을때까지 가져갔으면 좋겠어.
	// 그러면 무인 자판기같은걸 만들 수 있잖아.
	
	// 1. 내가 고객이 되어서 요청
	// 이러~이러~한 자판기를 만들어주세요.
	
	// ----------------------------------------------------------------------
	// 고객으로서 나).
	// 자판기 종류 - 음료 자판기.
	// 
	// 음료의 종류는 가로 4칸, 세로 3칸 총 12가지.		
	// 생김새.
	// ========================
	//         ~~ 자판기
	// ========================
	//  종류  1  종류  2  종류  3
	//
	//  종류  4  종류  5  종류  6
	//
	//  종류  7  종류  8  종류  9
	//
	//  종류 10  종류 11  종류 12
	// ========================
	//         현금 투입구
	// ========================
	//         음료 투출구
	// ========================
	//
	// 가격.
	// 미관이 좀 별론데 아무튼.
	// 종류 1 ~ 6은 1000원.
	// 종류 7 ~ 9는 1500원.
	// 종류 10 ~ 12는 2000원.
	// 
	// 종류를 선택하고 , 그 종류에 맞는 가격을 안내해줌.
	// 사용자는 현금으로 결제.
	// 결제가 완료되면 음료가 나옴.
	// 
	// 음료 추가기능과 제외기능이 있으면 좋겠네요
	// 음료는 외부에서 새로운 종류로 바꿀 수 없음.
	// 돈은 1000원짜리, 10000원짜리만 받고, 잔돈은 내어줌.
	// 가능하신가요?
	
	
	// ----------------------------------------------------------------------
	// 2. 개발자로서 요청 받은 거 처리
	// 되는것, 안되는것 받고 가능한 범위까지만 가능하다 라고 처리.
	
	// 개발자로서의 나
	// 추가기능과 제외기능을 제외하고 다 가능할것같은데요?
	// (그래야 돈을 번다 그죠~?)
	
	// Coding start)
	
	
	// 외관이 제일 중요하긴 해;
	// 돈 먹는건 알빠No
	
	String drkoutlet = "음료투출구";	// 이게 출력되는 음료 이름이 될겁니다.
	String drinkname;				// 음료 이름
	int drinkpay;					// 음료 가격
	
	// 생성자 생성
	VendingMachine(String drinkname, int drinkpay){
		this.drinkname = drinkname;
		this.drinkpay = drinkpay;
	}
	
	void input(String drinkname, int drinkpay) {
		this.drinkname = drinkname;
		this.drinkpay = drinkpay;
	}
	
	void setDrkName(String drinkname) {
		this.drinkname = drinkname;
	}
	String getDrkName() {
		return drinkname;
	}
	String getDrkPay() {
		return "" + drinkpay;
	}
	
	// 외관
	void drinkVending(){
		System.out.println("========================");
		System.out.println("        ~~ 자판기");
		System.out.println("========================");
		System.out.println(" 종류  1  종류  2  종류  3");
		System.out.println();
		System.out.println(" 종류  4  종류  5  종류  6");
		System.out.println();
		System.out.println(" 종류  7  종류  8  종류  9");
		System.out.println();
		System.out.println(" 종류 10  종류 11  종류 12");
		System.out.println("========================");
		System.out.println(" 어떤 음료수를 선택하시겠습니까?");
		System.out.println("========================");
		System.out.println("        " + drkoutlet);
		System.out.println("========================");
	}
	
	
	// 돈 받기
//	int payMent(int pay) {
//		if(pay >= drinkpay) {
//			pay
//		}
//		System.out.println("값을 지불하세요");
//		
//		return ;
//	}
}
