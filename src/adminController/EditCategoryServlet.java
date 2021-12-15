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
import model.Category;

/**
 * Servlet implementation class EditCategoryServlet
 */
@WebServlet("/EditCategory")
public class EditCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		DAO dao = new DAO();
		
		Category category = dao.getCategoryById(cid);
		request.setAttribute("category", category);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/editCategory.jsp");
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
			Category category = new Category(id, name);
			
			AdminDAO dao = new AdminDAO();
			boolean success = dao.editCategory(category);
			
			if (success) {
				response.sendRedirect("CategoryAdmin");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("EditCategory?cid=" + id);
				dispatcher.forward(request, response);
			}
		} else {
			response.sendRedirect("CategoryAdmin");
		}
	}

}
