package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
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
	
	public static void main(String[] args) {
		DAO dao = new DAO();
		List<Product> list = dao.getAllProduct();
		System.out.println(list);
	}
}
