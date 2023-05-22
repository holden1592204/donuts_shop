package donuts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException  {
		String dbName = "donuts_shop";
		String user = "javauser"; //sa
		String password = "javauser"; //password
		
		String ConnectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;database=" + dbName 
				+ ";trustServerCertificate=true"
				+ ";user=" + user
				+ ";password=" + password;
		
		return DriverManager.getConnection(ConnectionUrl);
	}
}
