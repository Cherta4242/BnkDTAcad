package d0108;

public class Ex_String {
	
	public static void printLine() {
		for(int i=0; i<45; i++) {
			System.out.print("_");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {

		// 문자열을 다루게 될 때 많이 쓰이는 메소드들
		// 대입시키기
		String str1 = "Hello, world!";
		String str2 = "Java Programming";
		String str3 = "    Hello Java      ";
		printLine();
		
		// 1. 문자열의 길이: length()
		System.out.println("1. str1.length(): " + str1.length());	// 0부터 시작
		System.out.println("1. str2.length(): " + str2.length());
		System.out.println("1. str3.length(): " + str3.length());
		printLine();
		
		// 2. 특정 위치의 문자 변환: charAt(위치 - index)
		System.out.println("2. charAt(): " + str1.charAt(8));		// 8번째 문자 출력
		printLine();
		
		// 3. 부분 문자열 추출: substring()
		System.out.println("3. substring(7): " + str1.substring(7));	// 7번 위치에 있는 문자열 출력
		printLine();
		
		// 4. 문자(열)의 첫번째 위치 찾기: indexOf();
		System.out.println("4. indexOf(\"world\"): " + str1.indexOf(str3));
		printLine();
		
		// 5. 문자열의 마지막 위치 찾기: lastIndexOf()
		System.out.println("5. lastIndexOf(\"world\")" + str1.lastIndexOf(str3));
		printLine();
		
		// 6. 대소문자 변환
		System.out.println("6. 대문자 변환 -> toUpperCase(): " + str3.toUpperCase());
		System.out.println("6. 소문자 변환 -> toLowerCase(): " + str3.toLowerCase());
		printLine();
		
		// 7. 앞 뒤 공백 제거: trim()
		System.out.println("7. 앞 뒤에 ' 붙이려면? -> trim(): " + str3.trim() + "'");
		printLine();
		
		// 8. 문자/문자열 치환 - replace()
		System.out.println("8. replace('l', 'L'" + str3.replace('l', 'L'));
		System.out.println("8. replace(\"World\",\"Java\"):" + str3.replace("world", "java"));
		System.out.println(str3);
		printLine();
		
		// 9. 문자열 분할: split()
		String[] words = str1.split(", ");
		System.out.println("9. split(\", \")");
		for(String word: words) {
			System.out.println("  - " + word);
		}
		printLine();
		
		// 10. 문자열 비교: equals()
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1.equals(s2));
		String s3 = new String("abc");
		System.out.println(s1 == s3);
		System.out.println(s1.equals(s3));
		printLine();
		
		// 11. 접두사/접미사 확인: startsWith()/endsWith()
		System.out.println("11. startsWith(\"Hello\"): " + str1.startsWith("Hello"));	// 시작 하는게 Hello 가 맞는가?
		System.out.println("11. endsWith(\"!\": " + str1.endsWith("!"));				// 끝이 !가 맞는가?
		printLine();
		
		// 12. 부분 문자열 포함: contains()
		System.out.println("12. contains(\"World\"): " + str1.contains("World"));	// str1 에서 World라는 문자를 포함하고 있는가?(대, 소문자 구분 함)
		printLine();
		
		// 13. 문자열 비교(대소문자 구분 없이): equalsIgnoreCase()
		String s4 = "hello, world!";
		System.out.println("13. equals(s4): " + str1.equals(s4));				// 대, 소문자 구분 하고 비교
		System.out.println("13. equalsIgnoreCase(s4): " + str1.equalsIgnoreCase(s4));			// 대, 소문자 구분 없이 비교
		printLine();
		
		// 14. 문자열의 사전적 순서 비교: compareTo()
		String s5 = "abc";
		String s6 = "bcd";
		System.out.println("14. compareTo(\"Hello\"): " + s6.compareTo(s5));
		System.out.println("14. compareTo(\"Hello\"): " + s5.compareTo(s6));		
		printLine();
		
		// 15. 문자열 연결:  concat()
		System.out.println("15. concat(\"Welcome\"): " + s5.concat("Welcome"));
		printLine();
		
		// 16. 다른 타입을 문자열로 변환: valueOf()
		int num = 123;
		double d = 12.35;
		System.out.println("16. valueOf(int): " + String.valueOf(num));
		System.out.println("16. valueOf(int): " + String.valueOf(d));
		printLine();
		
		// 17. 형시화된 문자열: format()
		String formatted = String.format("이름: %s, 나이: %d, 키: %.1f", "홍길동", 25, 175.3);
		System.out.println("17. format(): " + formatted);
		printLine();
		
		
		
		
	}
}
