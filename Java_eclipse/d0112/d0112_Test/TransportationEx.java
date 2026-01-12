package d0112_Test;


public class TransportationEx {

	
	public static void main(String[] args) {
		Bus bs = new Bus();
		Train tr = new Train();
		BusanTravel bt = new BusanTravel();
		
		bt.goBusan(bs);
		bt.goBusan(tr);	
	}
}
