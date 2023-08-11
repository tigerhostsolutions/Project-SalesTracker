package org.tigerhost;

import org.tigerhost.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class ECommerceMain {
	public static void main(String[] args) {
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("Connection successful!");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		Menu menu = new Menu();
		menu.mainMenu();
	}// end main
}// end ECommerceMain
