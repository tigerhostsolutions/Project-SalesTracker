package org.tigerhost.dao;

import org.tigerhost.model.SalesRep;
import org.tigerhost.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesRepDoa implements DoaInterface<SalesRep> {
	@Override
	public List<SalesRep> listAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			ResultSet rs = null;
			String sql = "SELECT * FROM sales_representatives;";
			Statement s = conn.createStatement();
			rs = s.executeQuery(sql);
			List<SalesRep> salesRepList = new ArrayList<>();
			while (rs.next()) {
				SalesRep salesRep = new SalesRep(rs.getInt("sales_rep_id"), rs.getString("sales_rep_first_name"),
						rs.getString("sales_rep_last_name"), rs.getString("sales_rep_phone_number"),
						rs.getString("sales_rep_email"));
				salesRepList.add(salesRep);
			} // end while
			log.info("User viewed 'Sales Rep' list");
			return salesRepList;
		} catch (SQLException e) { // if something goes wrong accessing our data, it will get caught
			System.out.println("Something went wrong when trying to access your DB");
			e.printStackTrace();
			return null;
		}// end try-catch

	}// end listAll()

	@Override
	public void add(SalesRep salesRep) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO sales_representatives (sales_rep_id, sales_rep_first_name, sales_rep_last_name,"
					+ "sales_rep_phone_number, sales_rep_email)" + "VALUES (?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, salesRep.sales_rep_id());
			ps.setString(2, salesRep.sales_rep_first_name());
			ps.setString(3, salesRep.sales_rep_last_name());
			ps.setString(4, salesRep.sales_rep_phone_number());
			ps.setString(5, salesRep.sales_rep_email());
			ps.executeUpdate();
			System.out.println("New sales rep: " + salesRep.sales_rep_first_name() + " added!");
			log.info("User added sales rep");
		} catch (SQLException e) {
			System.out.println("New sales rep not added.");
			e.printStackTrace();
		} // end try-catch
	}// end add()

	@Override
	public void delete(int sales_rep_id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM sales_representatives WHERE sales_rep_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sales_rep_id);
			ps.executeUpdate();
			System.out.println("Sales rep: " + sales_rep_id + " removed!");
			log.info("User removed sales rep");
		} catch (SQLException e) {
			System.out.println("Sales rep not deleted!");
			e.printStackTrace();
		} // end try-catch
	}// end delete()
}// end class SalesRepDoa
