package d0127;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {

	public static Connection getConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@//192.168.0.184:1521/orcl";
		String uid = "green";
		String upw = "1234";
		Connection conn = DriverManager.getConnection(url, uid, upw);
		
		return conn;
	}
	
}
