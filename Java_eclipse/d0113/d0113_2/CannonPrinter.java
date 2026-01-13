package d0113_2;

public class CannonPrinter implements Printable, Copyable, Scanable{


	public void turnOn(){
		System.out.println("Cannon 전원을 켭니다.");
	}
	public void Print() {
		System.out.println("프린트 되었습니다.");
	}
	public void scan() {
		System.out.println("스캔 완료되었습니다.");
	}
	public void copy() {
		System.out.println("카피 완료되었습니다.");
	}
}
