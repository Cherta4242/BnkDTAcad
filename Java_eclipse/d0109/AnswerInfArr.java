package d0109;

public class AnswerInfArr {
	private int[] arr;
	private int idx;
	
	AnswerInfArr(){
		arr = new int[3];
	}
	public void add(int n) {
		if(idx >= arr.length){
			int[] temp = new int[arr.length + 3];
			for(int i = 0; i < arr.length; i++) {
				temp[i] = arr[i];
			}
			arr = temp;
		}
		arr[idx] = n;
		idx++;
		
	}
	
	public void showArr() {
		for(int i = 0; i < idx; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
}
