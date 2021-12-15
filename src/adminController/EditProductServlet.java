package adminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import dao.DAO;
import model.Product;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/EditProduct")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("pid");
		DAO dao = new DAO();
		Product product = dao.getProductById(productId);
		request.setAttribute("product", product);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/editProduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("Submit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			double price = Double.parseDouble(request.getParameter("price"));
			String image = request.getParameter("img[]");
			Product product = new Product(id, name, image, price, title, description);
			
			AdminDAO dao = new AdminDAO();
			boolean success = dao.editProduct(product);
			if (success) {
				response.sendRedirect("ProductAdmin");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("EditProduct?pid=" + id);
				dispatcher.forward(request, response);
			}			
		} else {
			response.sendRedirect("ProductAdmin");
		}
	}

}
