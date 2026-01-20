package d0120_Exam;

import java.util.HashMap;

public class Exam {

	
	public static void main(String[] args) {
		
		HashMap<Integer, String> five = new HashMap<Integer, String>();
		five.put(1, "James");
		five.put(2, "Ann");
		five.put(3, "David");
		
		
		
		System.out.println("5번 문제 - Map, Key사용해서 출력");
		for(int key : five.keySet()) {
			
			System.out.println("Key: " + key + "\tValue: " + five.get(key));
		}
		
		System.out.println("=======================================\n");
		System.out.println("6번 문제. ");
		
		
	}
}