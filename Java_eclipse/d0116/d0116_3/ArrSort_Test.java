package d0116_3;


public class ArrSort_Test {

	public static void main(String[] args) {
		
		
		ArrSort[] arr = {new ArrSort(8), new ArrSort(3), new ArrSort(5), new ArrSort(20), new ArrSort(33), new ArrSort(31)};
		
		ArrSort.arrSort(arr);
		
		// --------------------------------------------------------------------------------------
		int[] selectsort = {9, 7, 5, 3, 6};
		/*
		System.out.println("\n초기값");
		for(int i = 0; i < 5; i++) {
			System.out.print(selectsort[i]);	
		}System.out.println("\n======");
		*/
		int x = selectsort[0];
		int x2 = x;
		int x3 = 0;
		
		for(int j = 0; j < 5; j++) {
			x = selectsort[j];
			x2 = x;
			x3 = 0;
			for(int i = j; i < 5; i++) {
				if(x > selectsort[i]) {
					x = selectsort[i];
					x3 = i;
				}
			}
			if(selectsort[j] <= x) {
				
			}else {
				selectsort[j] = x;
				selectsort[x3] = x2;
			}
			/*
			System.out.println("\n" + (j+1) + "차 시도");
			for(int i = 0; i < 5; i++) {
				System.out.print(selectsort[i]);	
			}
			System.out.println();
			*/
		}
		// --------------------------------------------------------------------------------------		
		
		
		
		
		
		
		
		
		
		/*
		for(int i = 0; i < 5; i++) {
			if(x > selectsort[i]) {
				x = selectsort[i];
				x3 = i;
			}
		}
		if(selectsort[0] <= x) {
			
		}else {
			selectsort[0] = x;
			selectsort[x3] = x2;
		}
		for(int i = 0; i < 5; i++) {
			System.out.print(selectsort[i]);	
		}
		System.out.println("\n===========================");
		
		x = selectsort[1];
		x2 = x;
		x3 = 0;
		for(int i = 1; i < 4; i++) {
			if(x > selectsort[i]) {
				x = selectsort[i];
				x3 = i;
			}
		}
		if(selectsort[1] <= x) {
			
		}else {
			selectsort[1] = x;
			selectsort[x3] = x2;
		}
		for(int i = 0; i < 5; i++) {
			System.out.print(selectsort[i]);	
		}		
		System.out.println("\n===========================");
		
		x = selectsort[2];
		x2 = x;
		x3 = 0;
		for(int i = 2; i < 5; i++) {
			if(x > selectsort[i]) {
				x = selectsort[i];
				x3 = i;
			}
		}
		if(selectsort[2] <= x) {
			
		}else {
			selectsort[2] = x;
			selectsort[x3] = x2;
		}
		for(int i = 0; i < 5; i++) {
			System.out.print(selectsort[i]);	
		}		
		System.out.println("\n===========================");
		
		x = selectsort[3];
		x2 = x;
		x3 = 0;
		for(int i = 3; i < 5; i++) {
			if(x > selectsort[i]) {
				x = selectsort[i];
				x3 = i;
			}
		}
		if(selectsort[3] <= x) {
			
		}else {
			selectsort[3] = x;
			selectsort[x3] = x2;
		}
		for(int i = 0; i < 5; i++) {
			System.out.print(selectsort[i]);	
		}		
		System.out.println("\n===========================");
		*/

		

		
	}
}
