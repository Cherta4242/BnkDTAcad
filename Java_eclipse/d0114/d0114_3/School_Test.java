package d0114_3;


public class School_Test {

	public static void main(String[] args) {

		/*	1차 목표.
		All all =  new All();
		
		all.insertSS(new StdScore(new Student(1, "장진우"), new Subject("국어", 100)));
		all.insertSS(new StdScore(new Student(1, "김건엽"), new Subject("영어", 90)));
		all.insertSS(new StdScore(new Student(1, "허 윤"), new Subject("코딩", 100)));
		all.insertSS(new StdScore(new Student(1, "아이고"), new Subject("수학", 50)));
		all.insertSS(new StdScore(new Student(1, "드디어"), new Subject("아진자", 20)));
		all.showAll();
		*/
		
		// 2차 목표
		Hybrid hyb = new Hybrid();
		
		hyb.insertStdSc(new Student(1, "장진우", new Subject("국어", 100), new Subject("영어", 100), new Subject("수학", 100)));
		hyb.showStudentScore();
	}

}
