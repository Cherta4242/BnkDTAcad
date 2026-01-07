package d0107;

public class Human {
	
	// class 이름은 Human, 사람은 100살 까지 살 수 있다고 가정.
	// 담배를 1개비 피우면 1살씩 줄어든다. 
	// 술을 한 병 마실때마다 나이는 2살씩 줄어든다.
	// 사람이니까 이름도 있을것이고, 성별도 있을것이다.
	// 사람 생성, 일부는 술, 담배를 했고, 수명이 줄어들었는지 명단(?)만들기.
	
	private int life = 100;	// 남은 수명
	private int age;
	private String name;		// 이름을 생성
	private char gen;			// 성별을 생성
	private int smksoju = 0;
	
	// Human 메소드를 Test_Human 클래서에서 사용했을 때 수정하지 못하게 할 것.
	Human(int age, String name, char gen){
		this.age = age;
		life = 100;		// 나이를 100살로 대입
		this.name = name;	// 이름을 받은 값 그대로 대입
		this.gen = gen;		// 성별을 받은 값 그대로 대입
	}
	
	
	// 이름 수정될 수 있죠?
	//--------------------------------------------------
	void setName(String name) {	// 이름 수정 값 받고 대입
		this.name = name;
	}
	String getName() {			// 이름 수정 값 출력
		return name;
	}
	
	
	// 성별 수정될 수 있죠?
	//--------------------------------------------------
	void setGen(char gen) {		// 성별 수정 값 받고 대입
		this.gen = gen;
	}
	char getGen() {				// 성별 수정 값 출력
		return gen;
	}	
	
		
	// 이제 술과 담배피는 애들 수명 빼줘야죠.
	//--------------------------------------------------
	int setTabaco(int smksoju) {
		this.smksoju = this.smksoju + smksoju;
		
		return this.smksoju;
	}
	
	int soju(int smksoju) {
		this.smksoju = this.smksoju + smksoju*2;
		
		return this.smksoju;
	}
	
	// 남은 수명 구해볼까요?
	//--------------------------------------------------
	int setAge() {
		life = 100 - age - smksoju;
		return life;
	}
	
	// 출력하기
	//--------------------------------------------------
	String showHmInfo(){
		setAge();
		return "\n이름	: " + name + "\n현재 나이	: " + age + "\n성별	: " + gen + "\n남은 수명	: " + life;
	}

}
