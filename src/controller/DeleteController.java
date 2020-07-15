package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogDaoImpl;


@WebServlet(urlPatterns= {"/delete "})
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	System.out.println("Delete Blog");	
	try {
		deleteBlog(request,response);
	} catch (SQLException e) {
		
		e.printStackTrace();
	} catch (IOException e) {

		e.printStackTrace();
	}
	
	}

	private void deleteBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
	
		int id=Integer.parseInt(request.getParameter("id"));
		
		BlogDaoImpl blogDao = new BlogDaoImpl();
	
			try {
				blogDao.deleteBlog(id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("allblogs");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
