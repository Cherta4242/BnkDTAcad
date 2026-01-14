package d0114_3;

public class All {

	// 1차 목표용
	StdScore[] ss = new StdScore[5];
	int count = 0;
	
	public void insertSS(StdScore ss) {
		this.ss[count] = ss;
		count++;
		System.out.println(count + "번 입력 완료");
	}
	
	public void showAll(){
		for(int i = 0; i < 5; i++) {
			if(ss[i] == null) {
				System.out.println(i + "번째 에서 멈추었습니다.");
				break;
			}
			System.out.println("=================");
			ss[i].showStdSco();
			System.out.println("=================");

		}


	}
	
	public void getSNNO() {
		System.out.println("=================");
		ss[0].getSNO();
	}
	
}
