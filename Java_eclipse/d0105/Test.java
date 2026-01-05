package d0105;

public class Test {

	public static void main(String[] args) {

		// C++과 마찬가지로 print 에 ln 이 붙느냐 안에 \n 을 붙이느냐의 실행은 같다. 코드만 다를 뿐이다.
		System.out.print("Hello, Java!!\n");
		System.out.println("Hello, Java!!");

		
		
		
		int n = 10;
		System.out.println("n: " + n);
		
		int sum = 0;
		int cnt = 0;
		while(cnt < 5) {
			sum = sum + cnt;
			System.out.println(sum);
			cnt++;	// cnt = cnt + 1;라는 말과 같다.
			if(sum > 5) {
				System.out.println("sum 값이 5보다 큽니다. \n코드를 중지하겠습니다.");
				break;
			}
		}
		System.out.println("sum: " + sum);
	}

}
