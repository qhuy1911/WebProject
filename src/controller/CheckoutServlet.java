package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import mail.SendMail;
import model.Account;
import model.Cart;
import model.Item;
import model.Order;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/Checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckoutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/checkout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		Account account = (Account) session.getAttribute("account");
		String fname = request.getParameter("c_fname");
		String lname = request.getParameter("c_lname");
		String address = request.getParameter("c_address");
		String phone = request.getParameter("c_phone");

		Cart cart = (Cart) session.getAttribute("cart");
		String product = "";
		for (Item i : cart.getItems()) {
			product += i.getProduct().getName() + " x " + i.getQuantity() + "</br>";
		}
		int total = (int) cart.getSumPrice();

		DAO dao = new DAO();
		Order order = new Order(account.getUsername(), fname + " " + lname, phone, address, product, total);
		boolean success = dao.addOrder(order);
		

		if (success) {
			SendMail.send(account.getEmail(), order, cart.getItems());
			System.out.println("order success");
		} else
			System.out.println("faild");

		session.removeAttribute("cart");
		response.sendRedirect("PlaceOrder");
	}

}
