package d0112_Test2;

public class Salary {
	// 회사에 정규직, 비정규직이 있음.
	// 모든 직원은 입사 시 사번, 이름, 급여가 정해짐
	// 정규직 사번은 j 로 시작
	// 비정규직 사번은 b 로 시작
	// 직원들의 급여를 계산하는 프로그램 
	
	public static void main(String[] args) {
		Employee emp = new Employee();
		Company[] cp = new Company[5];
		cp[0] = new Regular("j1", "장진우", 7);
		cp[1] = new Regular("j2", "김건엽", 7);
		cp[2] = new Irregular("b3", "홍길동", 5);
		cp[3] = new Irregular("b4", "전우치", 6);
		cp[4] = new Irregular("b5", "가나다", 5);
		
		for(int i = 0; i < 5; i++) {
			System.out.println("=====================");
			System.out.println(i+1 + "번째 사원");
			emp.showEmp(cp[i]);	
			System.out.println("=====================");
		}
		
		
	}
	
}
