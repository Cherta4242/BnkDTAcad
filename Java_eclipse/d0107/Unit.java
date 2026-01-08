package d0107;

public class Unit {
	
	// 체력은 5 이름은 red 거나 blue 거나.
	// 블루의 에너지는 3. 예? 집중좀 하자.
	// 공격받은 아이는 2만큼 줄어든다. 
	// 정보은닉 적용
	
	private String unitName;	// 생성되는 유닛의 이름
	private int energy;	// 생성되늰 unit의 체력 = 5
	private int damage;
	
	
	// ------------------------------------------------------	
	// 유닛의 스텟 설정하기.
	
	Unit(String unitName, int Damage, int energy){
		this.unitName = unitName;
		if(Damage >= 5) {
			System.out.println("저희 유닛의 최대 공격력인 4로 설정되었습니다.");
			this.damage = 4;
		}else {
			System.out.println("공격력이 설정되었습니다.");
			this.damage = Damage;
		}
		if(energy > 15) {
			System.out.println("저희 유닛의 최대 체력인 15로 설정되었습니다.");
			this.energy = 15;
		}else {
			System.out.println("유닛의 체력이 설정되었습니다.");
			this.energy = energy;
		}
		System.out.println("유닛 설정이 완료되었습니다.");
	}
	

	// ------------------------------------------------------
	// 유닛 정보 출력
	String unitInfo() {
		return "유닛 이름: " + unitName + "\n유닛 체력: " + energy + "\n데미지: " + damage;
	}
	
	
	// ------------------------------------------------------
	// Unit Name 설정
	void setUnitname(String unitName) {
		this.unitName = unitName;
	}
	String getUnitName() {
		return unitName;
	}
	
	// ------------------------------------------------------
	// Unit Damage 설정
	void setUnitDmg(int damage) {
		this.damage = damage;
	}
	int getUnitDmg() {
		return damage;
	}
	
	int attack(Unit un) {
		un.energy = un.energy - damage;
		
		return energy;
	}
	// 집가서 해보자.
}
