package d0116_3;

public class ArrSort {

	int num;

	public ArrSort(int num) {
		this.num = num;
		
	}
	
	
	public static void arrSort(ArrSort[] arr) {
		ArrSort[] selectsort = arr;

		System.out.println("\n초기값");
		
		for(int i = 0; i < selectsort.length; i++) {
			System.out.print(arr[i].num + " ");	
		}
		System.out.println("\n======");


        for (int j = 0; j < arr.length - 1; j++) {
            int minIdx = j;

            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i].num < arr[minIdx].num) {
                    minIdx = i;
                }
            }

            
            ArrSort temp = arr[j];
            arr[j] = arr[minIdx];
            arr[minIdx] = temp;

            System.out.println((j + 1) + "차 시도");
            for (ArrSort a : arr) {
                System.out.print(a.num + " ");
            }
            System.out.println();
        }
	}
}

