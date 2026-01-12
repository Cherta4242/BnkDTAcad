package d0112;

public class Person extends God implements Flyable, Swimable{
	@Override
	public void fly() {
		System.out.println("사람이 하늘을 납니다.");
	}
	public void swim() {
		System.out.println("사람이 수영을 합니다.");
	}
}