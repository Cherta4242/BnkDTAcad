package d0108;

public class GessingGame {
	
	// 그냥 생성자 선언해주기.
	GessingGame(){
		
	}
	// 단어맞추기 게임.
	// 단어는 ***로 출력
	// 맞추면 A**로 출력이 바뀌게 만들기.


	// 단어를 문자로 못바꾸어 주나
	// 되네
	
	// 단어를 문자열로 지정 해주기.
	String fiveword = "hello world";
	
	//char[] word = {'A', 'B', 'C', 'D', 'E'};
	char[] word = new char[fiveword.length()];	// 단어길이만큼 word 배열의 길이 지정해주고.
	char[] star = new char[word.length];	// *로 출력할 곳 길이 지정
	char[] same = new char[word.length];	// 비교하고 카운터값 만들거 지정.
	
	void changeword() {	// 단어 바꾸기
		for(int i = 0; i < fiveword.length();i++) {	// 반복문을 fivewold의 길이만큼 실행되게 하고
			word[i] = fiveword.charAt(i);	// word의 인덱스마다 fiveword의 같은 인덱스와 같은 값 넣기.
		}
	}
		

	
	// 띄어쓰기는 어떻게 구분할 수 있는건데??????
	// word 의 단어 길이만큼 *을 만들어주는 거 만들기.
	void changeStar() {
		for(int i = 0; i < word.length; i++) {
			if(star[i] == ' '){
				star[i] = ' ';
			}else {
				star[i] = '*';				
			}

		}
	}
	
	// chargeStar와 마찬가지로 다른 값을 대입시키기.
	void changeSame() {
		for(int i = 0; i < word.length; i++) {
			if(same[i] == ' '){
				same[i] = ' ';
			}else {
				same[i] = '=';				
			}
		}
	}
	
	
	// 너무 많이 써서 그냥 필드를 하나 만들기.
	void printstar() {
		for(int i = 0; i < star.length; i++) {
			System.out.print(star[i]);
		}
		System.out.println();
	}
	
	// same에 값이 제대로 들어가졌나 확인하는 용도
	/*
	void printsame() {
		for(int i = 0; i < same.length; i++) {
			System.out.print(same[i]);
			System.out.print(same[i]);
		}
		System.out.println();
	}
	*/

	
	// 문자 하나씩 대조해보기.
	void compare(char answer) {
		for(int i = 0; i < word.length; i++) {
			if(answer == word[i]) {
				star[i] = answer;
				same[i] = answer;
			}
		}
		printstar();
	}
	
	
}
