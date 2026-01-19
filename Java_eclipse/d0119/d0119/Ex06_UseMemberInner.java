package d0119;

interface Printable{
   void print();
}

class Papers{
   private String con;
   
   public Papers(String s) {
      con = s;
   }
   
   public Printable getPrinter() {
	   class Printer implements Printable{
	      @Override
	      public void print() {
	         System.out.println(con);
	      }
	   }
	   
	   return new Printer();
   }
   
}	
	
public class Ex06_UseMemberInner {

   public static void main(String[] args) {
	   
      Papers p = new Papers("서류내용 : 안녕하세요. ");
      // Papers.Printer pp = p.new Printer();
      Printable prn = p.getPrinter();
      prn.print();
      // pp.print();
      
   }
}
