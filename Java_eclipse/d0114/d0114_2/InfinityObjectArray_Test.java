package d0114_2;

public class InfinityObjectArray_Test {

	public static void main(String[] args) {
		InfinityObjectArray arr = new InfinityObjectArray();
		
		arr.Add(new A());
		arr.Add(new A());
		arr.Add(new A());
		arr.Add(new A());
		arr.Add(new A());
		arr.Add(new A());
		
		arr.showArray();
		
	}
}
