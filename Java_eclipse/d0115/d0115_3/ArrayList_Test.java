package d0115_3;

import java.util.ArrayList;

public class ArrayList_Test {

	public static void main(String[] args) {
		ArrayList<String> fruits = new ArrayList<String>();
	
		System.out.println("1. 빈 ArrayList 생성: " + fruits);
		System.out.println(" 초기 크기: " + fruits.size());
		System.out.println(" 비어있나: " + fruits.isEmpty());
		
		// 요소 추가
		fruits.add("사과");
		fruits.add("바나나");
		fruits.add("오렌지");
		fruits.add("포도");
		fruits.add("사과");
		fruits.add("바나나");
		System.out.println();
		
		System.out.println("2. 요소 추가 후: " + fruits);
		System.out.println(" 현재 크기: " + fruits.size());
		System.out.println(" 비어있나: " + fruits.isEmpty());
		System.out.println();
		
		// 특정 위치에 요소 추가
		fruits.add(1, "배");
		System.out.println("3. 특정 위치에 요소 추가 후: " + fruits);
		System.out.println(" 현재 크기: " + fruits.size());
		System.out.println(" 비어있나: " + fruits.isEmpty());
		System.out.println();
		
		// 특정 위치의 요소의 값 얻기
		String s = fruits.get(3);
		System.out.println("4. 특정 위치의 요소의 값 얻기: " + s);
		System.out.println();
		
		// 마지막에 있는거 얻으려면?
		String last = fruits.get(fruits.size()-1);
		System.out.println("5. 마지막 위치의 요소의 값 얻기, 1번 방법: " + last);
		String last2 = fruits.getLast();
		System.out.println("5. 마지막 위치의 요소의 값 얻기, 2번 방법: " + last2);
		System.out.println();
		
		//특정 위치의 요소의 값 수정
		System.out.println("6. 특정 위치의 요소의 값 수정");
		System.out.println(fruits);
		fruits.set(2, "메론");
		System.out.println(fruits);
		System.out.println();
		
		// 요소의 삭제
		System.out.println("7. 특정 요소의 삭제");
		System.out.println(fruits);
		fruits.remove(1);
		System.out.println(fruits);	
		fruits.remove("오렌지");
		System.out.println(fruits);
		System.out.println();
		
		// 열에 특정 단어가 있는지 확인
		System.out.println("배열 내에 포도가 있는가?");
		boolean tf = fruits.contains("포도");
		System.out.println(tf? "있어요" : "없어요");
		System.out.println();
		
		// 리스트 내의 몇번째 인덱스에 있는지 확인
		System.out.println("배열 내에 몇번째 인덱스에 메론이 있는가?");
		System.out.println(fruits.indexOf("메론"));
		System.out.println();
		
		// 리스트는 중복을 허용하는가?
		fruits.add("사과");
		System.out.println(fruits);
		System.out.println("리스트는 중복을 허용");

		// 검색
		System.out.println(fruits.indexOf("사과"));
		System.out.println(fruits.lastIndexOf("사과"));
		System.out.println("순차 검색이라 못함");
		System.out.println();
		
		// 모든 위치 검색
		System.out.println("사과의 모든 위치 인덱스 값을 받으려면?");
		for(int i = 0; i < fruits.size(); i++) {
			if(fruits.get(i) == "사과") {
				System.out.print(i + " ");
			}
			// System.out.print(fruits.get(i) + " ");
		}
		/*
		System.out.println();
		
		for(String x : fruits) {
			System.out.print(x + " ");
		}
		*/
	}
	
	
}