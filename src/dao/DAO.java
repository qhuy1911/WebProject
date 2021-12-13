package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Account;
import model.Category;
import model.Product;

public class DAO {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<Product>();
		//query
		String query = "Select * from Product";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList<Category>();
		String query = "select * from Category";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Product> getProductByCategory(String cateID) {
		List<Product> list = new ArrayList<Product>();
		String query = "select * from Product where cateID = ?";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, cateID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5), 
						rs.getString(6)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public Product getProductById(String id) {
		String query = "select * from product where id = ?";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3), 
						rs.getDouble(4),
						rs.getString(5), 
						rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public Account login(String username, String password) {
		String query = "select * from Account where username = ? and password = ?";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getInt(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public Account checkUsername(String username) {
		String query = "select * from Account where username = ?";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getInt(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public void signup(String username, String password, String email) {
		String query = "insert into Account values (?, ?, ?, 0)";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
//		DAO dao = new DAO();
//		List<Product> list = dao.getProductByCategory("1");
//		System.out.println(list);
	}
}
