package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.ActionItems;
import action.ActionOrder;
import entities.Order;
import entities.User;
import manager.MCategory;
import manager.MSession;
import util.Const;


@WebServlet("/ManageItem")
public class ManageItem extends HttpServlet {
	private static final long serialVersionUID = 1L;       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = MSession.getSession(request);
		User user = (User)session.getAttribute("user");
	   if(user!=null) {
			
			
			if(user.getRole().equals(Const.ROLE_ADMIN))
			{
				request.setAttribute("categories", MCategory.getCategories());
				request.getRequestDispatcher("/WEB-INF/newProduct.jsp").forward(request, response);
					//response.getWriter().append("Served at: ").append(request.getContextPath());
			}
			else
			{
				request.getRequestDispatcher(Const.PATH_PAGE_LOGIN).forward(request, response);
			}
		
	   }
	   else {
	   request.getRequestDispatcher(Const.PATH_PAGE_LOGIN).forward(request, response);
	   }
	   
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
	    if(	 ActionItems.createItem(request, response)) {
	    	
	        request.setAttribute("message", "product Added successfully !");
	    	doGet(request,response);
	    }
	    else {
	    	 request.setAttribute("message", "Something went wrong try agian later !");
	    }
		
	}

}
