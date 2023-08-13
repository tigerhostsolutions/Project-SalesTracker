package org.tigerhost;

import org.tigerhost.model.MainMenu;
import org.tigerhost.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class ECommerceMain {
	public static void main(String[] args) {
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("**CONNECTION SUCCESSFUL**");
		}catch (SQLException e) {
			e.printStackTrace();
		}//end try-catch
		MainMenu menu = new MainMenu();
		menu.mainMenu();
	}// end main()
}// end ECommerceMain Class
