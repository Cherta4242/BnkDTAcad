package d0113_1;

public class LTv extends TV implements TVInterFace{

	// 전원 켜기
	public void tvOn() {
		System.out.println("LG TV 전원을 켭니다.");
	}
	// 전원 끄기
	public void tvOff() {
		System.out.println("LG TV 전원을 끕니다.");
	}
	// 볼륨 높이기
	public void volumeUp() {
		System.out.println("볼륨을 높입니다.");
	}
	// 볼륨 줄이기
	public void volumeDown() {
		System.out.println("볼륨을 줄입니다.");
	}
		
}
