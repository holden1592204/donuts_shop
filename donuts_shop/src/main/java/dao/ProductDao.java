package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import donuts.Product;
import donuts.SqlConnection;

public class ProductDao extends SqlConnection {
	public List<Product> retrieveProductInfoAll(){
		try (Connection con = this.getConnection()){
			String sql = "SELECT product_code, "
					+ "		product_name, "
					+ "		cost, "
					+ "		price, "
					+ "		product_detail, "
					+ "		product_stock, "
					+ "		img_url "
					+ "	  FROM products;";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			 List<Product> productList = new ArrayList<>();
			while (rs.next()) {
				Product product = new Product(
												rs.getString("product_code"),
												rs.getString("product_name"),
												rs.getInt("cost"),
												rs.getInt("price"),
												rs.getString("product_detail"),
												rs.getInt("product_stock"),
												rs.getString("img_url")
												);
				
				productList.add(product);
			}
			return productList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Product retrieveProductInfo(String code) {
		try (Connection con = this.getConnection()){
			String sql = "SELECT product_code, "
					+ "		product_name, "
					+ "		cost, "
					+ "		price, "
					+ "		product_detail, "
					+ "		product_stock, "
					+ "		img_url "
					+ "	  FROM products "
					+ "	  WHERE product_code = ?;";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Product product = new Product(
						rs.getString("product_code"),
						rs.getString("product_name"),
						rs.getInt("cost"),
						rs.getInt("price"),
						rs.getString("product_detail"),
						rs.getInt("product_stock"),
						rs.getString("img_url")
						);
				return product;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
