package d0107;

public class Test_StudentBus {

	public static void main(String[] args) {
		
		// System.out.println(사용할 것.getClass().getSimpleName());
		// 이렇게 하면 어디에서 선언한 것인지 알 수 있음.
		
		// 학생 선언
		StudentBus stdb1 = new StudentBus("장진우", 1, 2000);
		StudentBus stdb2 = new StudentBus("김건엽", 2, 5000);
		StudentBus stdb3 = new StudentBus("허봉식", 7, 20000);
		
		// 버스 선언
		BusStudent bus0 = new BusStudent("189-1");
		BusStudent bus1 = new BusStudent("47");		

		// 현재 버스 정보보기
		System.out.println(bus1.busInfo());
		
		
		// 버스 탑승(김건엽)
		stdb2.getOnBus(bus1);
		
		// 학생 정보보기
		System.out.println(stdb1.stuInfo());	// 장진우
		System.out.println(stdb2.stuInfo());	// 김건엽

		// 버스 정보 보기
		System.out.println("----------------------");
		System.out.println( bus1.busInfo());

		
		// 버스 탑승시키기.
		stdb3.getOnBus(bus0);
		stdb1.getOnBus(bus1);
		
		// 현재 버스 정보 보기
		System.out.println("----------------------\n현재 버스 정보");
		System.out.println(bus1.busInfo());
		System.out.println(bus0.busInfo());
		
		// 현재 학생 정보 보기
		System.out.println("----------------------\n현재 학생 정보");
		System.out.print(stdb1.stuInfo());
		System.out.print(stdb2.stuInfo());
		System.out.print(stdb3.stuInfo() + "\n");
		System.out.print("----------------------");
		
	}

}
