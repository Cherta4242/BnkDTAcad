package d0115_2;

public class showArr {

	
	public <T> void showAry(T[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].getClass() == Integer.class) {
				System.out.println("a의 " + arr[i] + " 는 정수");
			}else if(arr[i].getClass() == Float.class) {
				System.out.println(arr[i] + "는 실수");
			}else if(arr[i].getClass() == String.class) {
				System.out.println(arr[i] + "는 문자열");
			}else {
				System.out.println("잘못 입력하신 것 같은데요?");
			}
		}
		
	}
	
}
