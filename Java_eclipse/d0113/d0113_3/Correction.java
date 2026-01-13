package d0113_3;

public class Correction{

	// 수정
	
	void changeName(Save save, int i, String name) {
		save.std[i-1].setName(name);
		System.out.println("이름이 " + name + "으로 변경되었습니다.");
	}
	
	void ChangeNum(Save save, int i, int j) {
		save.std[i-1].setAge(j);
	}
}
