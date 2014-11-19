package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	public static String url = "jdbc:sqlserver://211.149.219.21:1433;DatabaseName=Weixin_muye";
	public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String username = "sa";
	public static String password = "2014UESTC!@#$";
/**
	public static String url = "jdbc:sqlserver://weixindb\\DEV_SCAC;DatabaseName=muye";
	public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String username = "sa";
	public static String password = "!Q@W3e4r";
*/


	public static Connection connect() {
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return connection;
	}
}
