package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	private final String SERVER_NAME = "localhost";
	private final String DB_NAME = "ShopOnline";
	private final String PORT_NUMBER = "1433";
	private final String USER_ID = "sa";
	private final String PASSWORD = "191100";

	public Connection connect() {
		String sql = "jdbc:sqlserver://" + SERVER_NAME + ":" + PORT_NUMBER + ";databaseName=" + DB_NAME;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connect = DriverManager.getConnection(sql, USER_ID, PASSWORD);
			return connect;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}
