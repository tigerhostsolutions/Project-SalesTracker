package org.tigerhost.dao;

import org.tigerhost.model.Product;
import org.tigerhost.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDoa implements DoaInterface<Product> {
	@Override
	public List<Product> listAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			ResultSet rs = null;
			String sql = "SELECT * FROM products;";
			Statement s = conn.createStatement();
			rs = s.executeQuery(sql);
			List<Product> productList = new ArrayList<>();
			while (rs.next()) {
				Product product = new Product(rs.getInt("product_number"), rs.getString("product_name"),
						rs.getString("product_description"), rs.getString("product_category"), rs.getDouble("product_price"));
				productList.add(product);
			} // end while
			log.info("User viewed 'Product' list");
			return productList;
		} catch (SQLException e) { // if something goes wrong accessing our data, it will get caught
			System.out.println("Something went wrong when trying to access your DB");
			e.printStackTrace();
		}
		return null;
	}// end listAll()

	@Override
	public void add(Product product) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO products (product_number, product_name, product_description, product_category, " +
						 "product_price)"
					+ "VALUES (?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, product.product_number());
			ps.setString(2, product.product_name());
			ps.setString(3, product.product_description());
			ps.setString(4, product.product_category());
			ps.setDouble(5, product.product_price());
			ps.executeUpdate();
			System.out.println("New product: " + product.product_name() + " added!");
			log.info("User added product");
		} catch (SQLException e) {
			System.out.println("New product not added.");
			e.printStackTrace();
		} // end try-catch
	}// end add()

	@Override
	public void delete(int product_number) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM products WHERE product_number = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, product_number);
			ps.executeUpdate();
			System.out.println("Product: " + product_number + " removed!");
			log.info("User removed product");
		} catch (SQLException e) {
			System.out.println("Product not deleted!");
			e.printStackTrace();
		} // end try-catch
	}// end delete()
}//end class ProductDao
