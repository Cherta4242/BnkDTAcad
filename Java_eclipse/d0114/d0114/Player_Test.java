package d0114;

public class Player_Test {

	public static void main(String[] args) {
		// Player 생성
		Player player = new Player();
		
		// Player 업그레이드
		player.upgradeLevel(new AdvancedLevel());

		player.upgradeLevel(new SuperLevel());
		
		// Play 실행
		player.play(1);
	}
}
