package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import locale.Locale;

public  class MysqlClient extends Client {

	private static Connection conn = null;

	public static MysqlClient() {
		try {
			// The newInstance() call is a work around for some
			// broken Java implementations

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			// handle the error
		}

	}

	public  MysqlClient Connect() {
		try {
			conn =
			   DriverManager.getConnection("jdbc:mysql://" + getServerAddr() + "?"
										   + "user=" + getUserAccount() + "&password=" + getPasswd());
			
			// Do something with the Connection
		

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
}
