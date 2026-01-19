package d0119;


interface Role{
	// interfaece 에서는 필드도 가지고있다. 이 필드의 변수는 'public static final'이 상시 붙어있다.
	int ADMIN = 1;
	int MEMBER = 2;
	int GUEST = 3;
}

public class Ex01_ClassBaseCount {

	public static void main(String[] args) {
		
		int role = Role.ADMIN;
		System.out.println("입력: " + Role.ADMIN);
		
		switch(role) {
		case Role.ADMIN:
			System.out.println("출력: 관리자..");
			break;
		case Role. MEMBER:
			System.out.println("출력: 멤버..");
			break;
		case Role.GUEST:
			System.out.println("출력: 손님..");
			break;
		default:
		System.out.println("?..");
		}
	}
}
