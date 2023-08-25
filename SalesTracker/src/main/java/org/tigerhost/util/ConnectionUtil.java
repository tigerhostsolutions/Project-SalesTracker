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

			//Hard-coded credentials - Poor practice, consider hibernate or placing in external file.
			//Connect to localhost and specific schema
//			String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=sales_tracker";
			String url = "jdbc:postgresql://mytigerhostx-postgresql.cdmgpvquhqgx.us-east-2.rds.amazonaws.com/"; //Connect to AWS RDS
			String username = "postgres";
			String password = "password";

			return DriverManager.getConnection(url, username, password);
		}// end getConnection()
}// end ConnectionUtil
