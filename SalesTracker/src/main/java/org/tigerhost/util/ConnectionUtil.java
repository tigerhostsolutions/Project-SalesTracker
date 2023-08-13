package org.tigerhost.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
		public static Connection getConnection() throws SQLException {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Class wasn't found.");
				e.printStackTrace();
			}
//			String url = "jdbc:postgresql://localhost:5432/postgres";
			String url = "jdbc:postgresql://mytigerhostx-1.cdmgpvquhqgx.us-east-2.rds.amazonaws.com/";
			String username = "postgres";
			String password = "password";
			return DriverManager.getConnection(url, username, password);
		}// end getConnection()
}// end ConnectionUtil
