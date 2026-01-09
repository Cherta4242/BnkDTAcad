package d0109;

import java.util.Scanner;

public class Test_VendingMachine {

	public static void main(String[] args) {
		// VendingMachine과 연계됩니다.
		Scanner sc = new Scanner(System.in);
		// 선언
		Drink drk = new Drink();
		int userSelect;
		char userSelect2;
		int userPay;
		int penny = 0;
		boolean flag = true;
		//VendingMachine vmMa = new VendingMachine(음료 이름, 음료 가격);
		
		// 음료를 하나 넣기 테스트
		VendingMachine vmMa1 = new VendingMachine("사이다", 1000);
		VendingMachine vmMa2 = new VendingMachine("콜라", 1000);
		VendingMachine vmMa3 = new VendingMachine("음료1", 1000);
		VendingMachine vmMa4 = new VendingMachine("음료2", 1000);
		VendingMachine vmMa5 = new VendingMachine("음료3", 1000);
		VendingMachine vmMa6 = new VendingMachine("음료4", 1000);
		VendingMachine vmMa7 = new VendingMachine("환타", 1500);
		VendingMachine vmMa8 = new VendingMachine("음료6", 1500);
		VendingMachine vmMa9 = new VendingMachine("음료7", 1500);
		VendingMachine vmMa10 = new VendingMachine("음료8", 2000);
		VendingMachine vmMa11 = new VendingMachine("음료9", 2000);
		VendingMachine vmMa12 = new VendingMachine("음료10", 2000);
		drk.registerDrk(vmMa1);
		
		drk.showDrink();
		
		vmMa1.drinkVending();
		String drknm; 
		System.out.println("어떤 음료를 선택하시겠습니까?");
		System.out.print(">> ");
		userSelect = sc.nextInt();
		switch(userSelect) {
			case 1:
				drknm = vmMa1.drinkname;
				System.out.println("\n비용은 1000원 입니다.");
				break;
			case 2:
				drknm = vmMa2.drinkname;
				System.out.println("\n비용은 1000원 입니다.");
				break;
			case 3:
				drknm = vmMa3.drinkname;
				System.out.println("\n비용은 1000원 입니다.");
				break;
			case 4:
				drknm = vmMa4.drinkname;
				System.out.println("\n비용은 1000원 입니다.");
				break;
			case 5:
				drknm = vmMa5.drinkname;
				System.out.println("\n비용은 1000원 입니다.");
				break;
			case 6:
				drknm = vmMa6.drinkname;
				System.out.println("\n비용은 1000원 입니다.");
				break;
			case 7:
				drknm = vmMa7.drinkname;
				System.out.println("\n비용은 1500원 입니다.");
				break;
			case 8:
				drknm = vmMa8.drinkname;
				System.out.println("\n비용은 1500원 입니다.");
				break;
			case 9:
				drknm = vmMa9.drinkname;
				System.out.println("\n비용은 1500원 입니다.");
				break;
			case 10:
				drknm = vmMa10.drinkname;
				System.out.println("\n비용은 2000원 입니다.");
				break;
			case 11:
				drknm = vmMa11.drinkname;
				System.out.println("\n비용은 2000원 입니다.");
				break;
			case 12:
				drknm = vmMa12.drinkname;
				System.out.println("\n비용은 2000원 입니다.");
				break;
			default:
				System.out.println("\n잘못 선택하셨습니다.");
		}
		System.out.println("값을 지불하시겠습니까?");
		System.out.print(">> ");
		userSelect2 = sc.next().charAt(0);
		
		if(userSelect2 ==  'Y'||userSelect2 == 'y') {
			System.out.println("\n값을 지불하여주십시오");
			System.out.print(">> ");
			userPay = sc.nextInt();
			while(flag) {
				if(userPay >= vmMa1.drinkpay) {
					penny = vmMa1.drinkpay - userPay;
					flag = false;
				}else {
					System.out.println("돈이 부족홥니다.");
				}
			}
			System.out.println(vmMa1.drinkname + "가(이) 구매되었습니다.");
			
		}
		
		
	}

}
