package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Account;
import model.Category;
import model.Order;
import model.Product;

public class AdminDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public boolean addProduct(Product product) {
		String query = "insert into Product values (?, ?, ?, ?, ?, ?)";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, product.getName());
			ps.setString(2, product.getImage());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getTitle());
			ps.setString(5, product.getDescription());
			ps.setInt(6, product.getCategory());
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return true;
	}
	
	public boolean editProduct(Product product) {
		String query = "UPDATE Product "
				+ "SET name = ?, image = ?, price = ?, title = ?, description = ?, cateId = ? "
				+ "WHERE id = ?;";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, product.getName());
			ps.setString(2, product.getImage());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getTitle());
			ps.setString(5, product.getDescription());
			ps.setInt(6, product.getCategory());
			ps.setInt(7, product.getId());
			ps.executeUpdate();
		} catch (Exception e) {
		 	return false;
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return true;
	}
	
	public void deleteProduct(int id) {
		String query = "delete Product where id = " + id;
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
		} catch (Exception e) {
			return;
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public boolean addCategory(Category category) {
		String query = "insert into Category values(?)";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, category.getName());
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return true;
	}
	
	public boolean editCategory(Category category) {
		String query = "update Category set name = ? where id = ?";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, category.getName());
			ps.setInt(2, category.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			return false;
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return true;
	}
	
	public void deleteCategory(int id) {
		String query = "delete Category where id = " + id;
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
		} catch (Exception e) {
			return;
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public List<Order> getAllOrder() {
		List<Order> list = new ArrayList<Order>();
		String query = "select * from Orders";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getDate(8), rs.getBoolean(9)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}
	
	public boolean updateStatudOrder(int id, boolean status) {
		String query = "update Orders\r\n"
				+ "set status = ?\r\n"
				+ "where id = ?";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			ps.setBoolean(1, !status);
			ps.setInt(2, id);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return false;
	}
	
//	public List<Account> getAllAccount() {
//		List<Account> list = new ArrayList<Account>();
//		String query = "select * from Account";
//		
//		try {
//			conn = new DBContext().connect();
//			ps = conn.prepareStatement(query);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				Account acc = new Account(rs.getInt(1), 
//						rs.getString(2),
//						rs.getString(3), 
//						rs.getString(4), 
//						rs.getInt(5));
//				list.add(acc);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			try {
//				conn.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		
//		return list;
//	}
	
	public static void main(String[] args) {
//		Product p = new Product(8, "Men shoes 4", "hero_1.png", 500, "Men shoes 4", "Men shoes 4");
//		Category c = new Category(5, "Shoes 3");
//		AdminDAO dao = new AdminDAO();
//		System.out.println(d);
	}
}
