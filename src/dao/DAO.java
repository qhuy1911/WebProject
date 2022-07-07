package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import context.DBContext;
import model.Account;
import model.Category;
import model.Order;
import model.Product;

public class DAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<Product>();
		// query
		String query = "Select * from Product";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7)));
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
	
	public int getCountProduct() {
		String query = "select count(*) from Product";
		
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
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
		
		return 0;
	}
	
	public List<Product> getProductPaging(int index) {
		List<Product> list = new ArrayList<>();
		String query = "select * from product order by id offset ? Rows fetch next 9 rows only";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index-1)*9);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
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
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
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
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7)));
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

	public Product getProductById(String id) {
		String query = "select * from product where id = ?";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
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
		return null;
	}

	public Category getCategoryById(String id) {
		String query = "select * from category where id = ?";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Category(rs.getInt(1), rs.getString(2));
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
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
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
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
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
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public boolean addOrder(Order order) {
		String query = "insert into Orders values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, order.getUsername());
			ps.setString(2, order.getName());
			ps.setString(3, order.getPhone());
			ps.setString(4, order.getAddress());
			ps.setString(5, order.getProduct());
			ps.setInt(6, order.getTotal());
			ps.setBoolean(7, order.isStatus());

			Date d = new Date(order.getDate().getTime());
			ps.setDate(7, (java.sql.Date) d);
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

	public List<Order> getOrderByUsername(String username) {
		List<Order> list = new ArrayList<Order>();
		String query = "select * from Orders where username = ?";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
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
	public List<Product> getShortByPriceLow() {
		List<Product> list = new ArrayList<Product>();
		// query
		String query = "Select * from Product order by price";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7)));
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
	public List<Product> getShortByPriceHight() {
		List<Product> list = new ArrayList<Product>();
		// query
		String query = "Select * from Product order by price desc";
		try {
			conn = new DBContext().connect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7)));
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


	public static void main(String[] args) {
		DAO dao = new DAO();
		System.out.println(dao.getCountProduct());
	}
}
