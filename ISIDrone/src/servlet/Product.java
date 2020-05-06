package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.ActionItems;
import entities.User;
import manager.MCategory;
import manager.MItem;
import manager.MSession;
import util.Const;

/**
 * Servlet implementation class Product
 */
@WebServlet(name="listProduct" , urlPatterns = { "/listProduct"})
public class Product extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = MSession.getSession(request);
		 if(session!=null) {
				User user = (User)session.getAttribute("user");
				
				if(user.getRole().equals(Const.ROLE_ADMIN))
				{
						
				         request.setAttribute("items",MItem.getAllItems());   	
						request.getRequestDispatcher("/WEB-INF/listProducts.jsp").forward(request, response);
						//response.getWriter().append("Served at: ").append(request.getContextPath());
				}
				else
				{
					request.getRequestDispatcher(Const.PATH_PAGE_ITEMS).forward(request, response);
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

