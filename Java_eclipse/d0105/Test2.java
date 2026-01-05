package d0105;

import java.util.Random;
import java.util.Scanner;


public class Test2 {

	public static void main(String[] args) {
		// 랜덤수를 저장하는 방법.
		/*
		Random rd = new Random();	// 랜덤 수 함수를 rd로 사용한다
		int rdNum = rd.nextInt();	// 랜덤 수 함수를 사용하여 변수에 저장
		System.out.println("reNum: " + rdNum);	// 랜덤 수 출력
		*/
		
		// 유저에게 입력받는 방법.
		/*
		Scanner sc = new Scanner(System.in);	// 스캐너 함수를 sc로 사용한다.
		System.out.println("수를 입력하세요 >>");	// 사용자가 알아볼 수 있도록 print문을 사용하여 출력
		int input = sc.nextInt();	// sc를 사용하여 수를 입력받고 input에 입력받은 수 저장
		System.out.println("input :" + input);	// 입력받은 수 출력
		*/
		

		
		//가위바위보를 만들기(단, 함수는 사용하지 않음)

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int com = rd.nextInt(3) + 1;
		
		System.out.println("가위바위보 게임을 시작하겠습니다.");
		System.out.print("1. 가위, 2. 바위, 3. 보자기 중 선택하실 숫자를 입력하세요.\n >> ");
		int user = sc.nextInt();
		
		
		if(user == 1) {
			System.out.println("당신은 가위를 선택하셨습니다.");
		}else if(user == 2) {
			System.out.println("당신은 바위를 선택하셨습니다.");
		}else if(user == 3) {
			System.out.println("당신은 보자기를 선택하셨습니다.");
		}else {
			System.out.println("잘못 선택하셨습니다.");
		}
		if(user > 3||user < 0) {
			System.out.println("종료합니다.");
		}else {
			if(com == 1) {
				System.out.println("컴퓨터는 가위를 선택하였습니다.");
			}else if(com == 2) {
				System.out.println("컴퓨터는 바위를 선택하였습니다.");
			}else{
				System.out.println("컴퓨터는 보자기를 선택하였습니다.");
			}
			
			if(user == com) {
				System.out.println(".\n.\n.\n비겼습니다!");
			}else {
				if(user == 1&&com == 2) {
					System.out.println(".\n.\n.\n당신이 졌습니다!");				
				}else if(user == 1&&com == 3) {
					System.out.println(".\n.\n.\n당신이 이겼습니다!");
				}else if(user == 2&&com == 1) {
					System.out.println(".\n.\n.\n당신이 이겼습니다!");
				}else if(user == 2&&com == 3) {
					System.out.println(".\n.\n.\n당신이 졌습니다!");				
				}else if(user == 3&&com == 1) {
					System.out.println(".\n.\n.\n당신이 졌습니다!");
				}else {
					System.out.println(".\n.\n.\n당신이 이겼습니다!");
				}
			}
			
			System.out.println("\n가위바위보 게임을 종료합니다!");
		}

	}
}
