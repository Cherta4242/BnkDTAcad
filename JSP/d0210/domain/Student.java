package domain;

public class Student {
    String name;
    int kor;
    int eng;
    int math;
    int all;
    Student(){
    }

    public Student(String name, int kor, int eng, int math, int all){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.all = all;
    }

    public String getName() {
        return name;
    }
    public int getKor() {
        return kor;
    }
    public int getEng() {
        return eng;
    }
    public int getMath() {
        return math;
    }
    public int getAll() {
    	return all;
    }
    
    
    @Override
    public String toString() {
        return "이름: " + name + "<br>" +
               "국어: " + kor + "<br>" +
               "영어: " + eng + "<br>" +
               "수학: " + math;
    }
}
