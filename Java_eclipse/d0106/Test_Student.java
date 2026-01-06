package d0106;


public class Test_Student {

	public static void main(String[] args) {
		
		// 이렇게도 쓸 수 있다.
		// System.out.println(Student.sno);
		
		// class 예시
		// Student.java파일을 만들고 새로운 클래스를 만들기.
		// 및!

		// 학생 5명의 정보를 만들어서 (남자 2 여자 3)저장하는 학생 배열을 만들어서 저장하기.
		// class 배열 만들기.
		// Ex) Student[] students = new Student[5];
		
		
		Student stu = new Student();
		
		stu.no = 1;
		stu.name = "홍길동";
		stu.gender = 'M';
		
		
		Student stu2 = new Student();
		stu2.no = 1;
		stu2.name = "검성 고길동";
		stu2.gender = 'M';
		
		
		Student stu3 = new Student();		
		stu3.no = 1;
		stu3.name = "심청이";
		stu3.gender = 'W';
		
		
		Student stu4 = new Student();		
		stu4.no = 1;
		stu4.name = "라일락";
		stu4.gender = 'W';
		
		
		Student stu5 = new Student();		
		stu5.no = 1;
		stu5.name = "현순이";
		stu5.gender = 'W';
		
		

		
		
		Student[] stus = new Student[5];
		
		stus[0] = stu;
		stus[1] = stu2;
		stus[2] = stu3;
		stus[3] = stu4;
		stus[4] = stu5;
		
		int man = 0;
		int woman = 0;
		String gend = " ";
		
		
		
		for(int i = 0; i < 5; i++) {
			System.out.println();

			if(stus[i].gender == 'M') {
				gend = "남자";
				man++;
			}else {
				gend = "여자";
				woman++;
			}
			System.out.print(">==========<\n" + "학생" + (i+1) + "\n------------\n나이: "+ stus[i].no + "\n이름: " + stus[i].name + "\n성별: " + gend);
			System.out.print("\n============\n");
		}

		System.out.print("남자는 총 " + man + "명\n\n여자는 총 " + woman + "명");
		
		
		
		for(int i = 0; i < 5; i++) {
			stus[i].showStudentInfo();
		}
		
	}

}
