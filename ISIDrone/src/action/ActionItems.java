package action;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import manager.MDB;
import manager.MItem;

public class ActionItems {
	
	public static void getItems(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("items", MItem.getItems(ActionCategory.getSelectedCategory(request, response)));
	}

	public static void getItemById(int id, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("item", MItem.getItemById(id));
	}
	

	public static boolean createItem(HttpServletRequest request, HttpServletResponse response ) {

		
		//validateProduct(request,response);
		int reslt=-1;
		try {
			MDB.connect();
			String query = " insert into product (category,name,description, price, serialNumber, imgName, stockQty)"
			        + " values (?, ?, ?, ?, ?,?,?)";
			
			PreparedStatement ps = MDB.getPS(query);

			ps.setInt(1, Integer.parseInt(request.getParameter("product-category")) );
			ps.setString(2,request.getParameter("productName"));
			ps.setString(3,request.getParameter("description"));
			ps.setDouble(4, Double.parseDouble( request.getParameter("price")) );
			ps.setString(5, request.getParameter("serialNumber"));
			ps.setString(6, "1.jpg");
			ps.setInt(7 ,Integer.parseInt(request.getParameter("stkqty"))  );
			

			 reslt=ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MDB.disconnect();
		}
		
		return reslt>0 ? true : false;
		
		
	}

	
}
