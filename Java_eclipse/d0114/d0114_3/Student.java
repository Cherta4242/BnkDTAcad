package d0114_3;

public class Student {
	
	// 학생은 5명
	// 학생들 성적표를출력하는 것.
	
	// 학번
	private int sno;
	// 이름
	private String name;
	// ?
	Subject[] sub = new Subject[3];
	
	Student(int sno, String name, Subject kor, Subject math, Subject eng){
		this.sno = sno;
		this.name = name;
		sub[0] = kor;
		sub[1] = math;
		sub[2] = eng;
		
	}
	
	public int setSno() {
		return sno;
	}
	public void getSno(){
		System.out.println(sno);
	}
	
	public String setName() {
		return name;
	}
	public void getName() {
		System.out.println(name);
	}
	public void getSco() {
		sub[0].getSubname();
		sub[0].getScore();
		System.out.println();
		sub[1].getSubname();
		sub[1].getScore();
		System.out.println();
		sub[2].getSubname();
		sub[2].getScore();
		System.out.println();
	}
}
