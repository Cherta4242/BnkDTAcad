package d0113_2;

public class PrinterUser {

	
	public static void main(String[] args) {
	
		Printable p = new CannonPrinter();
		
		p.turnOn();
		
		p.Print();
	}
}
