package d0113_2;

public interface Printable {
	
	// 전원 켜기
	void turnOn();
	
	// 프린트하기
	void Print();
	// 엔딩메시지 보여주기
	default void showEndMessage() {
		System.out.println("출력이 완료되었습니다.");
	};
}
