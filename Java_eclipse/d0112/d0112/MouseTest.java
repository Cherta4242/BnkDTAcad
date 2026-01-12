package d0112;

class Mouse{
	public void clickLeft() {
		System.out.println("왼쪽 클릭..");
	}
	public void clickRight() {
		System.out.println("오른쪽 클릭..");
	}

}

class WheelMouse extends Mouse{
	public void scroll(){
		System.out.println("스크롤...");
	}
	@Override
	public void clickLeft() {
		System.out.println("휠마우스로 왼쪽 클릭...");		// 이런걸 "재정의 라고 함" (메서드 오버라이딩)
	}
	@Override			// (어노테이션)이름까지 확인해주는 역할.
	public void clickRight() {
		System.out.println("휠마우스로 오른쪽 클릭...");		// 값을 새로 준다가 아니라
	}
}

class OpticalMouse extends Mouse{
	public void clickLeft() {
		System.out.println("광마우스로 왼쪽 클릭...");
	}
	public void clickRight() {
		System.out.println("광마우스로 오른쪽 클릭...");
	}
}

public class MouseTest {

	public static void main(String[] args) {
		
		Mouse[] mouse = new Mouse[3];
		
		mouse[0] = new Mouse();
		mouse[1] = new WheelMouse();
		mouse[2] = new OpticalMouse();
		
		
		for(int i = 0; i < 3; i++) {
			if(mouse[i] instanceof Mouse == true) {
				System.out.println(i + 1 + "번째는 Mouse를 가지고 있습니다.");
			}else if(mouse[i] instanceof WheelMouse == true) {
				System.out.println(i + 1 + "번째는 WheelMouse를 가지고 있습니다.");
			}else if(mouse[i] instanceof OpticalMouse == true) {
				System.out.println(i + 1 + "번째는 OpticalMouse를 가지고 있습니다.");
			}else{
				System.out.println("찾지 못했습니다.");
			}
		}
		
		System.out.println("========================================");
		for(int i = 0; i < 3; i++) {
			if(mouse[i].getClass().equals(Mouse.class)) {
				System.out.println(i + 1 + "번째는 Mouse를 가지고 있습니다.");
			}else if(mouse[i].getClass().equals(WheelMouse.class)) {
				System.out.println(i + 1 + "번째는 WheelMouse를 가지고 있습니다.");
			}else if(mouse[i].getClass().equals(OpticalMouse.class)) {
				System.out.println(i + 1 + "번째는 OpticalMouse를 가지고 있습니다.");
			}else{
				System.out.println("찾지 못했습니다.");
			}
		}
		// 위 for문 을 간단하게 작성한다면
		/*
		for(Mouse x : mouse) {
			System.out.println(x.getClass().getSimpleName() + "입니다.");
		
		
		}
		*/
	}

}