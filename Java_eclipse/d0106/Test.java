package d0106;

import java.util.Random;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		// 이진분배의 방법을 구현해보자.
		/*
		int[] A = {-1, 10, 13, 21, 36, 47};
		int start = 0;
		int end = 6;
		int mid = 0;
		int target = ;
		boolean flag = false;
		
		while(start <= end) {
			mid = (start + end)/2;
			System.out.println("mid: " + mid);
			if(target == A[mid]) {
				flag = true;
				System.out.printf("%d번 인덱스에서 발견하였습니다.", mid);
				break;
			}else {
				if(target > A[mid]) {
					start = mid + 1;
				}else {
					end = mid -1;
				}
			}
		}
		if(!flag) {
			System.out.println("배열 안에 선택하신 수가 없습니다.");
		}
		*/

		
		
		// 로또번호 추출기를 만들어보자.
		// 현실 그대로 1~48까지의 수 중 6가지를 출력하고 나는 입력해서
		// 1~5등까지 뽑아볼까요?
		// 6가지의 수를 출력하는 것.
		
		int[] A = new int[6];
		int[] user = new int[6];
		int setup = 0;
		// 1. 각 배열에 숫자 뽑기	
		// 2. 첫번째 배열에 숫자를 뽑기.
		// 3. 두 번째 배열부터 여섯번째 배열까지 숫자를 뽑기. 
		
		// 4. 이전 배열에 곂치는 숫자가 있는지 확인하기.

		// 5. 만약 곂치는 숫자가 있다면? 곂치지 않는 숫자가 나올때까지 뽑기.
		// 6. 곂치지 않는 숫자가 나와야지만 다음 숫자 뽑기.
		// 이걸 6번째 숫자가 나올 때까지 반복.
		for(int i = 0; i < 6; i++) {
		    boolean flag = true;	// 먼저 flag값을 true로 설정.

		    while(flag) {			// 무한정 반복문을 위해 while문을 사용
		    	flag = false;		// flag 값을 먼저 거짓으로 바꾸어 실행이 끝나게 바꿈
		        A[i] = rd.nextInt(6) + 1;		// A[i]에 랜덤한 값을 대입

		        for(int j = 0; j < i; j++) {		// for문을 사용하여 A[j]가 [i]이전의 모든 값을 비교.
		            if(A[i] == A[j]) {				// 만약 A[i]의 값과 배열 A의 모든 값 중 같은 값이 있다면? 
		                flag = true;				// flag를 참으로 바꾸어서 다시 무한 반복문을 사용함
		                break;						// 이후 while문의 최초로 다시 돌아가서 새로운 값을 대입.
		            }
		        }
		    }
		}
		

		System.out.println("로또를 시작하겠습니다. 6가지 숫자를 골라주세요.");	// user의 입력 차례
		for(int i = 0; i < 6; i++) {
			System.out.print((i+1) + "번 숫자를 골라주세요: ");
			user[i] = sc.nextInt();			// 입력받기
		}
		System.out.println("숫자를 모두 고르셨으니 대조해보겠습니다.");	// 숫자 대조 시작
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				if(user[i] == A[j]) {
					setup++;		// 하나가 맞을 때마다 등수 올림
				}
			}
		}
		
		System.out.print("당첨 번호는: ");		// 등수 올림에 따라서 자신의 등수 나오게 하기
		for(int i = 0; i < 6; i++) {
			System.out.print(A[i] + " ");
		}	
		System.out.println("였습니다!");
		
		System.out.println("맞추신 숫자의 개수는 총 " + setup + "개 입니다.");
		if(setup <= 1) {
			System.out.println("낙첨입니다!");			
		}else if(setup == 2) {
			System.out.println("당신의 등수는 5등입니다!");
		}else if(setup == 3) {
			System.out.println("당신의 등수는 4등입니다!");			
		}else if(setup == 4) {
			System.out.println("당신의 등수는 3등입니다!");
		}else if(setup == 5) {
			System.out.println("당신의 등수는 2등입니다!");
		}else {
			System.out.println("당신의 등수는 1등입니다!");
		}
	
		
		
		
		
		sc.close();
	}
}
