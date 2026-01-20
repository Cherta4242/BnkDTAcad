package d0120;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HistoryReader_Test {

	public static void main(String[] args) {
		
		FileReader hir = null;

		try {
			hir = new FileReader("history.txt");
			int ch;
			
			while((ch = hir.read()) != -1) {
				System.out.print((char)ch);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(hir != null) hir.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n파일 읽기가 완료되었습니다.");
	}
}
