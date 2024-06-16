package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/Project", "root", "root123");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return conn;
	}
	
	

}
