package d0116;

public class MySystem{

	Object[] objarray;
	
	//copyOf
	/*
	public <T> void copyOf(T[] t, int arraylength) {
		objarray = new Object[arraylength];
		
		for(int i = 0; i < arraylength; i++) {
			objarray[i] = t[i];
		}
	}
	*/
	
	public static <T> void arraycopy(T[] t1, int idx, T[] t2, int idx2, int idx3) {
		for(int i = idx2; i < idx3+1; i++, idx++) {
			t2[i] = t1[idx];
		}
	}
	
	static <T> void printArray(T[] t) {
		for(T t2 : t) {
			System.out.print(t2 + "\t");
		}
	}
}
