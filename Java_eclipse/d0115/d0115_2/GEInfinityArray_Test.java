package d0115_2;

import d0115.Apple;

public class GEInfinityArray_Test {

	public static void main(String[] args) {
	
		GEinfinityArray<Apple> obn = new GEinfinityArray<Apple>();
		GEinfinityArray<String> obn2 = new GEinfinityArray<String>();
		
		obn.add(new Apple());
		obn.add(new Apple());
		obn.add(new Apple());
		obn.add(new Apple());
		
		obn.add(1, new Apple());
		
		obn2.add("장진우1");
		obn2.add("장진우2");
		obn2.add("장진우3");
		obn2.add("장진우4");
		obn2.add("장진우5");
		obn2.showall();
		
		System.out.println("============");
		obn2.add(4, "장진우 10");
		obn2.set(1, "김건엽");
		obn2.remove(4);
		String s = obn2.get(2);
		
		System.out.println(s);
		
		System.out.println("============");
		
		obn2.showall();
		boolean tf = obn2.contains("장진우0");
		System.out.println(tf);
		
		
	}

}
