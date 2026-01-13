package d0113_3;

public class Save implements ManageMent{

	// 저장
	private int count = 0;
	Register[] std = new Register[3];
	int i=1;
	
	
	void AddStd(Register std) {
		this.std[count] = std;
		System.out.println(i + "번째 학생 등록 완료");
		count++;
		i++;
	}
	
	public int getCount(){
		return count;
	}
	
	
}
