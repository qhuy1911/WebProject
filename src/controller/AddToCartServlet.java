package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import model.Cart;
import model.Item;
import model.Product;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qty = request.getParameter("qty");
		
		int quantity = 1;
		if (qty != null) {
			quantity = Integer.parseInt(qty);
		}
		
		DAO dao = new DAO();
		String pid = request.getParameter("pid");
		Product product = dao.getProductById(pid);
		if (product != null) {
			
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			if (cart == null) {
				cart = new Cart();
				List<Item> items = new ArrayList<Item>();
				Item item = new Item(product, quantity);
				items.add(item);
				cart.setItems(items);
				session.setAttribute("cart", cart);
			} else {
				List<Item> items = cart.getItems();
				boolean check = false;
				for (Item item : items) {
					if (product.getId() == item.getProduct().getId()) {
						item.setQuantity(item.getQuantity() + quantity);
						check = true;
					}
				}
				
				if (check == false) {
					Item item = new Item(product, quantity);
					items.add(item);
				}
				session.setAttribute("cart", cart);
			}
			response.sendRedirect("HomeServlet");
		} else {
			response.sendRedirect("HomeServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
