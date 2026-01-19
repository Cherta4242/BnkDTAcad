package d0119_2;

public class Member_Test {

	public static void main(String[] args) {
		Member m1 = new Member("장진우", Role.ADMIN);
		Member m2 = new Member("김겁엽", Role.GUEST);
		
		m1.showMmb();
		m2.showMmb();
		m1.getRole().go();
		// or
		m1.linkStart();
		
	}
}
