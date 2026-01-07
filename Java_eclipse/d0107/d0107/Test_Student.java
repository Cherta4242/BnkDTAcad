package d0107;

public class Test_Student {

	public static void main(String[] args) {
		
		Student std1 = new Student("장진우", 'M');		// std1의 값을 지불
		Student std2 = new Student("고길동", 'M');		
		Student std3 = new Student("배진우", 'M');
		Student std4 = new Student("김진숙", 'W');
		Student std5 = new Student("김경민", 'W');
		
		// 태어다는 아이 번호는 6, 이름은 길동이, 성별은 남자로 정해지게 만들기.
		Student std6 = new Student("홍길동", 'M');		
		
		
		// for 문을 사용해서 각 배열에 값을 넣고 출력을 쉽게 만들어볼까용?
		
		Student[] stds = new Student[Student.cnt];	// 생성자 배열 생성
		stds[0] = std1;		// 각 생성자 배열에 사람들 값 넣기.
		stds[1] = std2;		// 마찬가지
		stds[2] = std3;		// 마찬가지
		stds[3] = std4;		// 마찬가지
		stds[4] = std5;		// 마찬가지
		stds[5] = std6;		// 마찬가지
		
		// for 문을 사용하여 출력할 때 여러개를 한 번에 출력시키기.
		/*
		System.out.println("\n총 학생 수: " + Student.cnt);
		for(int i = 0; i < Student.cnt; i++) {
			System.out.print("\n=========="+"\n번호: " + stds[i].num + "\n이름: " + stds[i].name + "\n성별: " + stds[i].gen + "\n==========");
			// 번호: n, 이름: ABC, 성별: MW | 를 출력하는 것.
			
		}
		*/
		
		// InfotoString() 를 사용하여 문자열로 출력하기.		
		/*
		System.out.println("\n*std1~stdn 중 원하는거 출력하기\n" + std2.InfotoString());
		*/
	
		// 이름과 성별 변경 메소드 만들기!
		// 변경 전 확인용.
		/*
		System.out.println(std2.InfotoString());		
		
		// 변경하기
		std2.setName("장진우");
		std2.getName();
		std2.setGen('W');
		std2.getGen();
		
		// 변경되었는지 확인하기.
		System.out.println(std2.InfotoString());		
		*/
		
		std1.setAge(1);		// age에 값 넣기
		System.out.println(std1.getAge());		// age 출력.
		
		
		
	}
}
