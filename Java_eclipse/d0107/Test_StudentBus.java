package d0107;

public class Test_StudentBus {

	public static void main(String[] args) {
		StudentBus stdb1 = new StudentBus("장진우", 2, 2000);
		StudentBus stdb2 = new StudentBus("김건엽", 2, 5000);
		BusStudent bus1 = new BusStudent("47");		

		bus1.busInfo();
		
		stdb2.getOnBus();
		System.out.println(stdb1.stuInfo());
		System.out.println(stdb2.stuInfo());
		
		bus1.busInfo();
		
		
	}

}
