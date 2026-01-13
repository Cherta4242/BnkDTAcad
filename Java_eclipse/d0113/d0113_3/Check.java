package d0113_3;

public class Check{

	// 조회
	
	void showAll(Save save) {
        for (int i = 0; i < save.getCount(); i++) {
            save.std[i].showStd();
        }
    }
	
	
}
