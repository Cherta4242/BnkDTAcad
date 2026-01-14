package d0114_3;

public class StdScore {
	// 1차 목표용
	private Student stu;
	private Subject sub;
	
	StdScore(Student stu, Subject sub){
		this.stu = stu;
		this.sub = sub;
	}
	
	public void showStdSco(){
		System.out.print("학 번: ");
		stu.getSno();
		System.out.print("이 름: ");
		stu.getName();
		System.out.print("과목명: ");
		sub.getSubname();
		System.out.print("점 수: ");
		sub.getScore();
	}
	public void getSNO() {
		stu.getSno();
	}

}
