package org.tigerhost.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private ConnectionUtil() {
//		Utility classes should not have public constructors.
	}
		public static Connection getConnection() throws SQLException {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Class wasn't found.");
				e.printStackTrace();
			}

			//Hard-coded credentials - url connects to localhost and database schema.
//			String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=sales_tracker";
			//Use environment variables to access url, username, and password.
			String url = System.getenv("DB_URL_AWS");
			String username = System.getenv("DB_USERNAME");
			String password = System.getenv("DB_PASSWORD");

			return DriverManager.getConnection(url, username, password);
		}// end getConnection()
}// end ConnectionUtil
