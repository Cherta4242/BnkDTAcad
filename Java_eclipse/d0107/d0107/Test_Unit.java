package d0107;

public class Test_Unit {
	
	public static void main(String[] args) {
		
		// Unit 스테이터스 설정
		System.out.println("------------------------");
		Unit un1 = new Unit("blue", 2, 15);
		Unit un2 = new Unit("blue", 6, 15);
		System.out.println("------------------------");

		// Unit들 정보 출력
		System.out.println("------------------------");
		System.out.println(un1.unitInfo());
		System.out.println(un2.unitInfo());
		System.out.println("------------------------");
		
		
		// Unit1이 Unit2 공격
		un1.attack(un2);

		// 다시 한 번 Unit들 정보 출력
		System.out.println("------------------------");
		System.out.println(un1.unitInfo());
		System.out.println("------------------------");
		System.out.println(un2.unitInfo());
		
		
	}
}
