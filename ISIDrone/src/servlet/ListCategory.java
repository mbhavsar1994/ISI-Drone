package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.ActionCategory;
import action.ActionOrder;
import entities.Category;
import entities.User;
import manager.MCategory;
import manager.MSession;
import util.Const;

/**
 * Servlet implementation class ListCategory
 */
@WebServlet(name="listCategory" , urlPatterns = { "/listcategory"})
public class ListCategory extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = MSession.getSession(request);
		 if(session!=null) {
				User user = (User)session.getAttribute("user");
				
				if(user.getRole().equals(Const.ROLE_ADMIN))
				{
						
						session.setAttribute("categories", MCategory.getCategories());
						request.getRequestDispatcher("/WEB-INF/listCategory.jsp").forward(request, response);
						//response.getWriter().append("Served at: ").append(request.getContextPath());
				}
				else
				{
					request.getRequestDispatcher(Const.PATH_PAGE_HOME).forward(request, response);
				}
			
		   }
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
