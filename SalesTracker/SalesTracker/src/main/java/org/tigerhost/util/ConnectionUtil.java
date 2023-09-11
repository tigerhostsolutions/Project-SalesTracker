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

        //Environment variables used to access url, username, and password.
        String username = System.getenv("DB_USERNAME");

        //Remote connection-Postgres: AWS RDS
//        String password = System.getenv("DB_PASSWORD_AWS");
//        String url = System.getenv("DB_URL_AWS");

        //Default connection-Postgres: localhost:5433
        String password = System.getenv("DB_PASSWORD_LOCAL");
        String url = System.getenv("DB_URL_LOCAL");

        return DriverManager.getConnection(url, username, password);

    }// end getConnection()
}// end ConnectionUtil
