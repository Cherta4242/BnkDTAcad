package d0109;

public class Drink {
	// Test_VendingMachine, VendingMachine과 연계됩니다.
	
	VendingMachine[] vmDrink = new VendingMachine[12];
	private int index = 0;	// 음료 번호
	
	// 생성자 생성
	Drink() {

	}
	
	// 배열에 음료 등록
	void registerDrk(VendingMachine drink) {
		this.vmDrink[index] = drink;
		index++;
	}
	
	// 음료 이름 출력

	
	// 음료 나열
	void showDrink() {
		for(int i = 0; i < index; i++) {
			System.out.println("-------------");
			System.out.println("번호 " + (i+1) + "번");
			System.out.println(vmDrink[i].getDrkName());
			System.out.println(vmDrink[i].getDrkPay());
			System.out.println("-------------");
		}
	}





}

