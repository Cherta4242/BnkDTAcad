package d0113_3;

public class Student{
	public static void main(String[] args) {

		// 학원 안에 학생, 선생 등록
		// 저장, 조회, 수정, 삭제 기능 구현
		Save std = new Save();
		Check check = new Check();
		Correction change = new Correction();
		
		
		std.AddStd(new Register(1, 2, "장진우"));
		std.AddStd(new Register(2, 3, "김건엽"));
		std.AddStd(new Register(3, 1, "허 윤"));
		
		check.showAll(std);
		
		change.changeName(std, 3, "신정훈");
		
		check.showAll(std);
				
		
		
		
		
		
	}
	
}
