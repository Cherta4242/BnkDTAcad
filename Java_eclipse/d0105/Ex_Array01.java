package d0105;

import java.util.Random;

public class Ex_Array01 {

	public static void main(String[] args) {
		// 코딩 왤케 재밌지 ㅋㅋㅋㅋ
		// java에서의 배열
		/*
		int[] A = {1, 2, 3};
		
		System.out.println(A[0]);
		
		int[] B = new int[3];
		System.out.println(B[0]);
		B[0] = 10;
		System.out.println(B[0]);
		*/
		
		
		// A = 1, 3, 5, 7, 9, B = 2, 4, 6, 8, 10가 있다. 배열 C에 순차적으로 넣으세요.
		/*
		int[] A = {1, 3, 5, 7, 9};
		int[] B = {2, 4, 6, 8, 10};
		
		int[] C = new int[10];
		
		for(int i = 0; i < 5; i++) {
			C[i*2] = A[i];
			C[i*2+1] = B[i];
		}

		for(int j = 0; j<10; j++) {
			System.out.println("C의 " + j + "번 인덱스 -> " + C[j]);	
		}
		
		// 각 배열의 합을 구해볼까?		
		int sum = 0;
		for(int i = 0; i<10; i++) {
			sum = sum + C[i];
		}
		System.out.println("\n각 배열의 합" + "\n" + sum + "\n");
		
		
		// 배열을 반대로 출력해보기
		int c;
		for(c=C.length-1;c>=0;c--) {
			System.out.println("C의" + c + "번 인덱스 ->" + C[c]);
		}
		System.out.println("\n");
		
		
		// 배열을 1, 2, 3, 4, ... 8, 9, 10으로 출력하는데 마지막에 ,가 출력되지 않게 출력하기.
		System.out.println("배열을 1, 2, 3, 4, ... 8, 9, 10으로 출력하는데 마지막에 ,가 출력되지 않게 출력하기.");
		System.out.print("배열 C의 [0]부터 [9]까지 출력하겠습니다 -> (");
		for(int i = 0; i < 10; i++) {
			System.out.print(C[i]);
			if(i != 9) {
				System.out.print(", ");			
			}else {
				break;
			}
		}
		System.out.print(")");
		
		System.out.println("\n");
		*/

		
		// 주사위가 있다. 10번 굴려서 1, 2, 3, 4, 5, 6이 몇개 나왔는지 집계하기.
		System.out.println("주사위를 10번 굴려서 1, 2, 3, 4, 5, 6이 각 각 몇개 나왔는지 집계하기.");
		
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int six = 0;
		
		Random rd = new Random();
		
		for(int i = 0; i<10; i++) {
			int Dice = rd.nextInt(6) + 1;	
			if(Dice == 1) {
				one = one + 1;
			}else if(Dice == 2) {
				two = two + 1;
			}else if(Dice == 3) {
				three = three + 1;
			}else if(Dice == 4) {
				four = four + 1;
			}else if(Dice == 5) {
				five = five + 1;
			}else {
				six = six + 1;
			}
		}
		System.out.println("1번 주사위는 " + one + "개, 2번 주사위는 " + two + "개, 3번 주사위는 " + three + 
				"개, \n4번 주사위는 " + four + "개, 5번 주사위는 " + five + "개, 6번 주사위는 " + six + "개 나왔습니다.");
		
		System.out.println();
		
		
		// 이걸 배열로 만든다면?
		System.out.println("이걸 배열로 만든다면?");
		int[] RanDice = {0, 0, 0, 0, 0, 0};
		for(int i = 0; i < 10; i++) {
			int Dice = rd.nextInt(6) + 1;
			RanDice[Dice - 1] = RanDice[Dice -1 ] + 1;
			
		}
		System.out.println("1번 주사위는" + RanDice[0] + "개, 2번 주사위는 " + RanDice[1] + "개, 3번 주사위는 " + RanDice[2] + 
				"개,\n4번 주사위는 "  + RanDice[3] + "개, 5번 주사위는 "  + RanDice[4] + "개, 6번 주사위는 "  + RanDice[5] + "개 나왔습니다. " );
		
		System.out.println();
		
		
		// 2차원 배열
		// int [] A = new int[n][N]; -> 배열 생성
		/*
		int [][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
		A[1][2] = 10;
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<3; j++) {
				System.out.println("A[" + i + "][" + j + "]번" + "인덱스 숫자 -> " + A[i][j]);				
			}

		}
		*/
		
		// 4행 5열의 2차원 배열에 1~20까지의 값을 각 각 대입시키기. 
		/*
		int k = 0;
		int[][] arr = new int[4][5];
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				k++;
				arr[i][j] = k;
			}
		}

		for(int i = 0; i<4; i++) {
			for(int j = 0; j<5; j++) {
				System.out.print(arr[i][j] + "\t");				
			}
			System.out.println();
		}

		// 각 배열의 값을 모두 더한다면?
		int summ = 0;
		int count = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				if(arr[i][j] % 2 == 0) {
					summ = summ + arr[i][j];
					count++;
				}
			}
		}
		System.out.println("각 배열의 짝수의 값을 모두 더한 값은: " + summ + "\n짝수의 개수: " + count + "개");
		*/
		// 특정 배열 역순으로 저장하기.
		// 1, 2, 3, 4, 5
		// 10, 9, 8, 7, 6
		// 11, 12, 13, 14, 15
		// 20, 19, 18, 17, 16
		// 이렇게~
		
		// 방법 1
		/*
		int k = 0;
		int[][] arr = new int[4][5];
		
		for(int i = 0; i < 4; i++) {
			switch(i) {
				case 0:
					for(int j = 0; j < 5; j++) {
						k++;
						arr[i][j] = k;
					}
				case 1:
					for(int j = 4; j >= 0; j--) {
						k++;
						arr[i][j] = k;
					}
				case 2:
					for(int j = 0; j < 5; j++) {
						k++;
						arr[i][j] = k;
					}
				case 3:
					for(int j = 4; j >= 5; j--) {
						k++;
						arr[i][j] = k;
					}
			}
		}
		

		for(int i = 0; i<4; i++) {
			for(int j = 0; j<5; j++) {
				System.out.print(arr[i][j] + "\t");				
			}
			System.out.println();
		}
		*/ 
		
		// 방법 2
		/*
		int k = 0;
		boolean TF = true;
		int j;
		int[][] arr = new int[4][5];
		
		for(int i = 0; i < 4; i++) {
			if(TF) {
				for(j = 0; j < 5; j++) {
					k++;
					arr[i][j] = k;
				}
				TF = false;
			}else {
				for(j = 4; j >= 0; j--) {
					k++;
					arr[i][j] = k;
				}
				TF = true;
			}
		}
		
		for(int i = 0; i<4; i++) {
			for(j = 0; j<5; j++) {
				System.out.print(arr[i][j] + "\t");				
			}
			System.out.println();
		}
		*/
		
		
		
		
	}

}
