package d0116;

import java.util.Arrays;

public class CopyArray_Test {

	public static void main(String[] args) {
		
		double[] arOrg = {1.1, 2.2, 3.3, 4.4, 5.5};
		
		// 1. arOrg의 길이만큼 카피
		double[] arCpy1 = Arrays.copyOf(arOrg, arOrg.length);
		// 2. arOrg의 2번 인덱스까지 카피
		double[] arCpy2 = Arrays.copyOf(arOrg, 3);
		// 3. arOrg의 2번 인덱스부터 3번 인덱스까지 카피
		double[] arCpy3 = Arrays.copyOfRange(arOrg, 2, 4);

		// 1번 실행문
		for(double d : arCpy1) {
			System.out.print(d + "\t");
		}
		System.out.println();
		// 2번 실행문
		for(double d : arCpy2) {
			System.out.print(d + "\t");
		}
		System.out.println();
		// 3번 실행문
		for(double d : arCpy3) {
			System.out.print(d + "\t");
		}
		
		// 새 배열 생성
		double[] cpy = new double[5];
		// 카피할 거, 어디서부터, 카피 받을거, 어디서부터, 어디까지
		System.arraycopy(arOrg, 0, cpy, 1, 4);
		System.out.println();
		for(double d : cpy) {
			System.out.print(d + "\t");
		}
		System.out.println();
		System.out.println("=============================================");
		
//		MySystem<Double> ms2 = new MySystem<Double>();
		
		Double[] arr = {1.1, 1.2, 1.3, 1.4, 1.5};
		
		Double[] ms = new Double[5];
		
		MySystem.arraycopy(arr, 0, ms, 1, 4);
		
		/*
		for(int i = 0; i < ms.length; i++) {
			System.out.print(ms[i] + "\t");			
		}
		System.out.println();
		*/
		
		MySystem.printArray(ms);
		
		
		
	}
}
