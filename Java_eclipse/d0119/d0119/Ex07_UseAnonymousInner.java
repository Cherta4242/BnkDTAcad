package d0119;


interface Printable2{
	void print();
}

class Papers2{
	private String con;
	
	public Papers2(String s) {
		con = s;
	}
	
	public Printable2 getPrinter() {
		/*
		class Printer implements Printable{
			@Override
			public void print() {
				System.out.println(con);
			}
		}
		*/
		/*
		return new Printable2() {
			@Override
			public void print() {
				System.out.println(con);
			}
		};
		*/
		return () -> System.out.println(con);
	}
}

public class Ex07_UseAnonymousInner {

	public static void main(String[] args) {
		Papers2 p = new Papers2("서류 내용: 정신을 차리자?");
		
		Printable2 prn = p.getPrinter();
		prn.print();
	}
}