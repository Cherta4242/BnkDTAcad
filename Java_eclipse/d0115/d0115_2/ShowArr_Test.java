package d0115_2;

public class ShowArr_Test {
	public static void main(String[] args) {
	
		showArr aa = new showArr();
		showArr dd = new showArr();
		showArr ss = new showArr();
		
		Integer[] a = {1, 2, 3};
		Double[] f = {1.1, 1.2, 1.3};
		String[] s = {"장진우", "김건엽", "허 윤"};
		
		// 배열의 요소를 출력해주는 클래스
		// 정수배열, 실수배열, 문자열배열을 실행클래스에 하나 만들고, 배열을 출력해주는 클래스를 하나 만들어서 테스트

		aa.showAry(a);
		dd.showAry(f);
		ss.showAry(s);
	}

}
