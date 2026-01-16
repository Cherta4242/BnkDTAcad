package d0116_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Dictionary {

	static Map<String, String> map = new HashMap<String, String>();

	
	public static void Add(String kor, String eng) {
		map.put(kor, eng);
	}
	
	public static void showDiction(Dictionary dict) {
		int i = 1;
		System.out.println("한 - 영 사전");
		System.out.println("=============================================");
		for(String key : map.keySet()) {
			System.out.println(" " + i + "  Kor : " + key + "\t|  Eng : " + map.get(key));
			i++;
		}
		System.out.println("=============================================");
	}
	
	public static void quection() {

		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		char yn;
		int jeongdap = 0;

		System.out.println("한국어를 보고 문제를 맞추어 보세요!");
		System.out.println("하시겠습니까(Y/N)");
		System.out.print(">> ");
		yn = sc.next().charAt(0);
		if(yn == 'Y' || yn == 'y' || yn == 'ㅛ') {
			System.out.println();
			System.out.println("게임을 시작하겠습니다!");
			System.out.println("다음 단어들의 영어를 작성해주세요!");
			
			while(flag) {
				gameStart();
				jeongdap++;
				if(kor() == null) {
					flag = false;
					System.out.println("맞추신 개수는 " + jeongdap + "개 입니다.");
				}
				

				
			}	
		}else {
			System.out.println("그만하겠습니다.");
		}
				
		sc.close();
	}
	
	public static String kor() {
		for(String key : map.keySet()) {
			return key;
		}
		return null;
	}
	
	
	public static int gameStart() {
		Scanner sc = new Scanner(System.in);
		
		
		int i = 1;
		int count=0;
		String answer;
		Set<String> key = map.keySet();
		
		System.out.println(i + "번 문제: " + kor());
		System.out.print("정답은? >> ");
		answer = sc.next();
		if(answer.equals(map.get(kor()))) {
			System.out.println("정답");
			map.remove(kor());
			count++;
		}else {
			System.out.println("오답");
		}
		
		
		return count;
	}
	
	
	
	
}
