package adminController;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.AdminDAO;
import dao.DAO;
import model.Category;
import model.Product;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/EditProduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 10,
maxRequestSize = 1024 * 1024 * 50
)
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String SAVE_DIR = "images";
       
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
		List<Category> listC = dao.getAllCategory();
		
		request.setAttribute("product", product);
		request.setAttribute("listC", listC);

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
			Part filePart = request.getPart("imageFile");
			String fileName = getFileName(filePart);
			int category = Integer.parseInt(request.getParameter("category"));
			
			// Upload file
			String appPath = "E:\\Nam 4\\HK1\\LTW-PROJECT\\WebProject\\WebContent\\views\\user";
			
			String savePath = appPath + File.separator + SAVE_DIR;
			
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			
			filePart.write(savePath + File.separator + fileName);
			
			Product product = new Product(id, name, fileName, price, title, description, category);
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
	
	private String getFileName(Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}

}
