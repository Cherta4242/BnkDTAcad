package d0116_4;

import java.util.HashMap;
import java.util.Map;

public class Map_Test {

	public static void main(String[] args) {
		
		// 맵 생성
		Map<String, Integer> map = new HashMap<>();
		// List<String> list = new List<>();
		
		// 맵 요소 추가
		map.put("사과", 1500);
		map.put("바나나", 2000);
		map.put("오랜지", 3000);
		map.put("포도", 4000);
		
		// 맵 요소 조회
		Integer price = map.get("사과");
		System.out.println("사과(key)의 값(value)은" + price + "원 입니다.");		
		Integer price2 = map.get("바나나");
		System.out.println("바나나(key)의 값(value)은" + price2 + "원 입니다.");
		Integer price3 = map.get("키위");
		System.out.println("키위(key)의 값(value)은" + price3 + "원 입니다.");
		
		price = map.getOrDefault("키위", 0);
		System.out.println("키위의 값은 " + price + "입니다.");
		
		
		// 맵의 크기 조회
		System.out.println("맵에 저장된 자료의 개수: " + map.size());
		
		// 맵이 비어있는지 확인하기
		System.out.println("맵이 비어있나요? >> " + map.isEmpty());
		
		// 맵 비우기
		//map.clear();
		
		System.out.println("맵이 비어있나요? >> " + map.isEmpty());
		System.out.println("맵에 저장된 자료의 개수: " + map.size());
		
		// keySet은 키의 집합
		for(String key : map.keySet()) {
			System.out.println("key: " + key + "이고, price: " + map.get(key) + "입니다.");
		}
		
		
		
		
	}
}
