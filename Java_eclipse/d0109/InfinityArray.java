package d0109;

public class InfinityArray {
	// Test_InfinityArray와 연계됩니다.
	// 무한배열 만들기.
	// 최초의 배열 길이 값은 3.
	// 삭제기능도 구현하기
	
	
	// 먼저, 개념을 정리하자면
	// 1. 다른 배열에 같은 값 넣음. 
	// 2. 원래 배열의 길이를 새로 지정함.
	// 3. 다시 다른배열에 있던 값을 원래 배열에 넣음
	// 4. 이후에 받은 값 다시 넣음.

	// 0이 출력되지 않게 한다면? 그럼 scanner에 0을 넣게 된다면? -> Scanner에 0을 못넣게 막으면 됨.
	// 그렇다고 0을 무조건 출력되지 않게 하면.. 음
	
	// arrb에 값이 다 차면 새로운 배열로 생성하도록.
	
	
	
	
	
	
	
	
	
	// 배열 생성
	int[] arr = new int[3];
	int[] arrb = new int[arr.length];	// 배열끼리 이리지리 인덱스 안의 값을 주고받기 위해 만들어준 배열
	
	int index = 0;
	// count 가 주어져있는 모든 값을 고정적으로 바꿀 수 있는 값이 필요함 -> static
	static int count = 3;	// 새로운 배열을 생성할 때 사용할 변수
	static int count2 = 0;	// 배열에 순차적으로 값을 대입시킬 때 필요한 변수
	
	// 생성자 생성
	InfinityArray() {
	}
	
	// 값을 받고 배열의 index에 대입시킴
	void insert(int a) {

		
		if(a == 0) {	// 아예 0을 못넣게 만들기.
			System.out.println("0은 넣을 수 없습니다.");
		}else {
			for(int i = 0; i < arr.length; i++) {	// arrb[index]에 arr[index]의 모든 값을 저장
				arrb[i] = arr[i];
			}
			
			// arr의 주소에 새로운 배열 길이를 쥐여줌
			arr = new int[count+1];			// arr에 배열길이가 늘어난 주소 대입
			
			for(int i = 0; i < arrb.length; i++) {
				arr[i] = arrb[i];
			}

			arr[count2] = a;
			arrb = new int[count+1];
			index++;
			count++;	// 다음 배열 생성을 위해 증가
			count2++;	// 다음 값 대입을 위해 증가
		}

	}
	
	// 출력문
	void showArray() {
		System.out.print("현재 배열에 저장되어 있는 값은: ");
		for(int i = 0; i < index; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
	
	void deleteArray(int a) {
		if(a > index) {
			System.out.println("값을 잘못 선택하셨습니다.");
		}else {
			for(int i = 0; i < arr.length; i++) {
				arrb[i] = arr[i];
			}
			for(int i = a; i < arrb.length; i++) {
				arr[i - 1] = arrb[i];
			}
			index--;
			count2--;
		}
	}
	

	
}
