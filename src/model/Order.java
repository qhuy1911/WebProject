package model;

import java.util.Date;

public class Order {
	private int id;
	private String username;
	private String name;
	private String phone;
	private String address;
	private String product;
	private int total;
	private Date date;

	public Order() {
	}
	public Order( String username, String name, String phone, String address, String product, int total) {
		this.username = username;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.product = product;
		this.total = total;
		this.date = new Date();
	}
	public Order(int id, String username, String name, String phone, String address, String product, int total,
			Date date) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.product = product;
		this.total = total;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Order {id= " + id + ", username= " + username + ", name=" + name + ", phone= " + phone + ", address= "
				+ address + ", product" + product + "," + " total= " + total + ", date= " + date;
	}
	public static void main(String[] args) { 	
//		Date ngay=new Date(new java.util.Date().getTime());
//		System.out.println(ngay);
		}
}
