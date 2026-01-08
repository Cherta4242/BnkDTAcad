package d0108;

public class Ex_String {
	public static void main(String[] args) {

		// 문자열을 다루게 될 때 많이 쓰이는 메소드들
		
		
		String str1 = "Hello, world";
		String str2 = "Java Programming";
		String str3 = "    Hello Java      ";
		
		// 1. 문자열의 길이: length()
		System.out.println("1. length(): " + str1.length());
		System.out.println("1. length(): " + str2.length());
		System.out.println("1. length(): " + str3.length());
		
		// 2. 특정 위치의 문자 변환: charAt(위치 - index)
		System.out.println("2. charAt()" + str1.charAt(8));
		
		// 3. 부분 문자열 추출: substring()
		System.out.println("3. substring(7): " + str1.substring(7));
		
		// 4. 문자(열)의 첫번째 위치 찾기: indexOf();
		System.out.println("4. indexOf(\"world\"): " + str1.indexOf(str3));
		
		// 5. 문자열의 마지막 위치 찾기: lastIndexOf()
		System.out.println("5. lastIndexOf(\"world\")" + str1.lastIndexOf(str3));
		
		// 6. 대소문자 변환
		System.out.println("6. 대문자 변환 -> toUpperCase(): " + str3.toUpperCase());
		System.out.println("6. 소문자 변환 -> toLowerCase(): " + str3.toLowerCase());
		
		// 7. 앞 뒤 공백 제거: trim()
		System.out.println("7. 앞 뒤에 ' 붙이려면? -> trim(): " + str3.trim() + "'");
		
		// 8. 문자/문자열 치환 - replace()
		System.out.println("8. replace('l', 'L'" + str3.replace('l', 'L'));
		System.out.println("8. replace(\"World\",\"Java\"):" + str3.replace("world", "java"));
		System.out.println(str3);
		
		// 9. 문자열 분할: split()
		String[] words = str1.split(", ");
		System.out.println("9. split(\", \")");
		for(String word: words) {
			System.out.println("  - " + word);
		}
		
		// 10. 문자열 비교: equals()
		String s1 = "abc";
		String s2 = "abcd";
		System.out.println(s1.equals(s2));
		
		
		
		
		
		
	}
}
