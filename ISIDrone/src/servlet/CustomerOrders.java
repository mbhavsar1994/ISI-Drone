package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.ActionOrder;
import entities.Order;
import entities.User;
import manager.MSession;
import util.Const;

/**
 * Servlet implementation class CustomerOrders
 */
@WebServlet(name="customer-orders" , urlPatterns = { "/customerorders"})
public class CustomerOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = MSession.getSession(request);
		User user = (User)session.getAttribute("user");
	   if(user!=null) {
			
			
			if(user.getRole().equals(Const.ROLE_ADMIN))
			{
				 List<Order> orderList= ActionOrder.getCustomersOrder();

					session.setAttribute("orderList", orderList.isEmpty()?null: orderList);
					request.getRequestDispatcher(Const.PATH_PAGE_ALLCUSTOMERORDER).forward(request, response);
					
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
		// TODO Auto-generated method stub
		
		HttpSession session = MSession.getSession(request);
		User user = (User)session.getAttribute("user");
		   if(user!=null) {
			   
			   String orderId=request.getParameter("orderid");
			   String actionMethod=request.getParameter("action");
			   System.out.println(actionMethod);
			   if(actionMethod.equals(Const.ORDER_ACTION_UPDATE_STATUS))
			    {
				   
				   if( ! ActionOrder.updateOrderStatus( Integer.parseInt(orderId) )) {
					   response.getWriter().write("Already Shipped!");
				   }  
			   }
			   else if(actionMethod.equals(Const.ORDER_ACTION_CANCEL)) {
				   
				   
				   if( ! ActionOrder.cancelOrder( Integer.parseInt(orderId) )) {
					   response.getWriter().write("Already Shipped!");
				   } 
				   else
				   {
					   System.out.println("aaaa");
					   response.getWriter().write("Order Is Canceled! ");
				   }
			   }
			  
		   }
		   else {
			   request.getRequestDispatcher(Const.PATH_PAGE_LOGIN).forward(request, response);
			   }
			
	}

}
