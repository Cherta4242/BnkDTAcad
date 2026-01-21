package d0121;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewMember {
	String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
	String user = "green";
	String pw = "1234";
	
	// 전체 회원 정보 보기.
	void view() throws Exception{
		
		int count = 1;
		
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM TestMember");
		System.out.println("조회합니다.");
		while(rs.next()) {
			System.out.println("------------------------\n회원" + count + "번");
			System.out.println("id:\t" + 
				rs.getString("id") + "\npw:\t" + 
				rs.getString("pw") + "\nname:\t" +
				rs.getString("name")
			);
			System.out.println("------------------------");
			count++;
		}
	}
	public void showAllMember() throws Exception{
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		int count = 1;
		ResultSet rs = stmt.executeQuery("SELECT * FROM TestMember");
		
		System.out.println("전체 회원의 이름을 출력합니다.");
		System.out.println("=======================");
		while(rs.next()) {
			System.out.println("회원 " + count + ":\t" + rs.getString("name"));
			count++;
		}
		System.out.println("=======================");
		
	}
	
	public String getName(String id, String pwd) throws Exception{
		String name = null;
		
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM TestMember where id ='" + id + "' AND pw ='" + pwd + "'");
		while(rs.next()) {
			name = rs.getString("name");
		}
		
		return name;
	}
}
