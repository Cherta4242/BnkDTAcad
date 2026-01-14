package d0113_3;


public class Delete {
	
	// 삭제
	void Cut(Save save, int j) {
		save.std[j-1] = null;
		
		System.out.println("삭제하였습니다.");
	}
	
	
}
