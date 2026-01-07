package d0107;

public class Test_Human {

	public static void main(String[] args) {
		// Human 메소드가 잘 사용되는지 확인.
		Human hm1 = new Human(25, "장진우", 'M');
		hm1.setTabaco(4);
		hm1.soju(2);
		System.out.println(hm1.showHmInfo());
	}

}
