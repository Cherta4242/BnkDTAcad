package d0114_3;

public class Subject{
	
	// 과목은 국, 영, 수
	private String subname;
	private int score;
	
	Subject(String subname, int score){
		this.subname = subname;
		this.score = score;
	}	
	
	public String setSubname(){
		return subname;
	}
	public void getSubname() {
		System.out.print(subname + ": ");
		
	}
	
	public int setScore() {
		return score;
	}
	public void getScore() {
		System.out.print(score);
	}
	
}