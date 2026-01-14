package d0114_4;


public class Test {

	public void f1() throws MyException {
		
		try {
			f2();
		}catch(NullPointerException e) {
			
			System.out.println("f1() catch....");
			throw new MyException(e.getMessage());
		}
		
	}
	public void f2() throws NullPointerException, ArithmeticException, IndexOutOfBoundsException {

		//FileReader fr = new FileReader("a.txt");
		
		String s = null;
		int n = s.length();
		
	}
	
	
	public static void main(String[] args) throws NullPointerException{
	
		Test t = new Test();
		try {
			t.f1();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		try {
			t.f1();
		}catch(NullPointerException e) {
			System.out.println("안되용");
		}catch(ArithmeticException e) {
			System.out.println("안되용");			
		}catch(IndexOutOfBoundsException e) {
			System.out.println("안되용");
		}
		*/
		System.out.println("end....");	
		
	}
}

