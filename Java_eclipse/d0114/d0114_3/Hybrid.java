package d0114_3;

public class Hybrid {

	// 2차 목표용
	private Student[] std = new Student[5];
	private int count=0;
	
	public void insertStdSc(Student std) {
		this.std[count] = std;
	}
	
	public void showStudentScore(){
		for(int i = 0; i < 5; i++) {
			if(std[i] == null) {
				System.out.println(i + "번째 에서 멈추었습니다.");
				break;
			}
			System.out.println("=============");
			System.out.print("학 번: ");
			std[i].getSno();
			System.out.print("이 름: ");
			std[i].getName();
			std[i].getSco();	
			System.out.println("=============");
		}
	}
}
