package d0106;

public class Student {
	static int sno = 1;
	
	int no;
	String name;
	char gender;
	
	
	Student(){
		
	}
	
	void showStudentInfo() {
		System.out.print(">==========<\n" + "학생" + "\n------------\n나이: " + no + "\n이름: " + name + "\n성별: " + gender);
		System.out.print("\n============\n");
	}
	
}
