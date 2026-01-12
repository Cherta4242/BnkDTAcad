package d0112;

public class TestFly {
	public static void main(String[] args) {
		
		Flyable[] flight = new Flyable[3];
		
		Bird bird = new Bird();
		Car car = new Car();
		Person person = new Person();
		
		flight[0] = bird;
		flight[1] = car;
		flight[2] = person;
		
		for(int i = 0; i < flight.length; i ++) {
			flight[i].fly();
		}
		
		
		
		
		
		
		
	}
}
