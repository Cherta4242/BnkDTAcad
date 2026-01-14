package d0114;

public class Player {
	
	private PlayerLevel level;
	
	public Player(){
		level = new BeginnerLevel();
		level.showLevelMessage();
	}
	
	public PlayerLevel getLevel() {
	
		return level;
	}
	
	public void upgradeLevel(PlayerLevel level) {
		this.level = level;
		System.out.print("업그레이드 완료.\n현재 레벨: ");
		this.level.showLevelMessage();
		
	}
	
	public void play(int count){
		System.out.println("======================");
		level.go(count);
	}
	

	
}
