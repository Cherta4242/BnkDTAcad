package d0120;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HistoryWriter_Test {
	
	public static void main(String[] args) {
		
		FileWriter his = null;
		Scanner sc = new Scanner(System.in);
		
		String history;
		
		
		try {
			his = new FileWriter("history.txt");
			his.write("================= My History =================\n");
			System.out.println("단문을 입력해주세요");
			while(true) {
				System.out.print(">> ");
				history = sc.nextLine();
				if(history.equals("end")) {
					break;
				}
				his.write(history);
				System.out.println();
			}


			his.write("\n==============================================");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(his != null) {
					his.close();
					sc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("파일 쓰기가 완료되었습니다.");
	}

}
