package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import model.Cart;
import model.Category;
import model.Product;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String indexPage = request.getParameter("index");
		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		
		// load data
		DAO dao = new DAO();
		
		// pagination
		int count = dao.getCountProduct();//13
		int endPages = count/9;
		if (count%9!= 0) {
			endPages++;
		}
		
		List<Product> list = dao.getProductPaging(index);
		List<Category> listC = dao.getAllCategory();

		// set data into jsp
		request.setAttribute("index", index);
		request.setAttribute("endPages", endPages);
		request.setAttribute("listProduct", list);
		request.setAttribute("listCategory", listC);
		request.getRequestDispatcher("/views/user/product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
