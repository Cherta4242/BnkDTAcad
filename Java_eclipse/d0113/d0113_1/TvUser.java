package d0113_1;

public class TvUser {

	public static void main(String[] args) {
	
//		TV tv = new LTv();
		TVInterFace tv = new LTv();
		TVFactory tvf = new TVFactory("samsung");
		
		
		
		tv.tvOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.tvOff();
		
		System.out.println("=============================");
		tvf.getBrand();
		
		
	}
}
