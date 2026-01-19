package d0119_2;



public class Member {

	private static int cnt;
	private int mno;
	private String name;
	private Role role;
	
	Member(String name, Role role){
		mno = ++cnt;
		this.name = name;
		this.role = role;
		
	}
	
	public int getMno() {
		return mno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	public Role getRole() {
		return role;
	}
	
	public void showMmb() {
		System.out.println("========================");
		System.out.println("번호: " + mno);
		System.out.println("이름: " + name);
		System.out.println("직책: " + role);
		System.out.println("========================");
	}
	
	public void linkStart() {
		System.out.println();
		System.out.println("========================");
		System.out.println("환영합니다 " + name + "님!");
		System.out.println(role + " 직책입니다!");
		System.out.println();
		switch(role) {
		case ADMIN -> System.out.println("관리자 페이지에 접속합니다.");
		case MEMBER -> System.out.println("회원 페이지에 접속합니다.");
		case GUEST -> System.out.println("비회원 페이지에 접속합니다.");
		}
		System.out.println("========================");
	}
	
}
