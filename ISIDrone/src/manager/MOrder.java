package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Cart;
import entities.Item;
import entities.ItemCart;
import entities.Order;
import entities.User;

public class MOrder {
	public static int add(User user, Cart cart) {
		
		int orderId = 0;
		
		try {
			// TODO Faire une transaction
			MDB.connect();

			// Partie 1
			// Creer une commande et récupere le ID
			String query = "INSERT INTO `order` (`user_id`, `date`) VALUES (?, now())";
			
			PreparedStatement ps = MDB.getPS(query, 1);

			ps.setInt(1, user.getId());

			ps.executeUpdate();
			
			ResultSet generatedKeys = ps.getGeneratedKeys();
            
			if (generatedKeys.next()) {
                orderId = generatedKeys.getInt(1);
            }
			
			// Partie 2
			// Ajoute tout les items de la commande dans la table order_info
			
			for (ItemCart itemC : cart.getCart().values()) {
				
				query = "INSERT INTO `order_info` (`order_id`, `product_id`, `qty`, `price`) VALUES (?, ?, ?, ?)";
				ps = MDB.getPS(query);
				
				ps.setInt(1, orderId);
				ps.setInt(2, itemC.getId());
				ps.setInt(3, itemC.getQty());
				ps.setDouble(4, itemC.getPrice());
				
				ps.executeUpdate();
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MDB.disconnect();
		}

		return orderId;
		
	}
	public static List<Order> getAllOrdersByUserId(){

		
		List<Order> orderList= new ArrayList<Order>();
		
		try {
			
			MDB.connect();

			String query = "SELECT `order`.id, `order`.date,`order`.user_id,`order`.isShipped,`order`.isCanceled,"
					+ " `order_info`.order_id, `order_info`.product_id, `order_info`.qty, `order_info`.price "
					+ "FROM `order` INNER JOIN `order_info` ON `order`.id = `order_info`.order_id ;";
			
			PreparedStatement ps = MDB.getPS(query);

			
			ResultSet rs = ps.executeQuery();

			int orderId = 0;
			
			Order order = new Order();
			
			// Une ligne = un item avec qte
			while(rs.next()) 
			{
				if(rs.getBoolean("order.isShipped")==true || rs.getBoolean("order.isCanceled")==true) 
				{
					if(orderId != rs.getInt("id"))
					{
						
						// Ecraser le orderId de condition
						orderId = rs.getInt("id");
						
						// Nouvelle commande
						order = new Order();
						
						order.setId(orderId);
						order.setUserId( rs.getInt("order.user_id"));
						order.setDate(rs.getString("order.date"));
						order.setShipped(rs.getBoolean("order.isShipped"));
						order.setCanceled(rs.getBoolean("order.isCanceled"));
						
						// Ajouter la commande a la liste	
						orderList.add(order);
					}
					
					// Recupérer l'item suivant
					int itemId = rs.getInt("order_info.product_id");
					
					// Recuperer l'item complet de la BD
					Item item = MItem.getItemById(itemId);
					
					// Ecraser le prix et ajouter la quantité
					ItemCart itemC = new ItemCart(item);
					itemC.setQty(rs.getInt("order_info.qty"));
					itemC.setPrice(rs.getDouble("order_info.price"));
					
					// Ajouter l'itemPanier au panier
					order.addItem(itemC.getSerial(), itemC);
					
				}
				// Si nouvel commande, creer une nouvelle commande
				
			}
			
			//orderList.add(order);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MDB.disconnect();
		}
		
		return orderList;
	}
	
	
public static List<Order> getAllOrders(){


		
		List<Order> orderList= new ArrayList<Order>();
		
		try {
			
			MDB.connect();

			String query = "SELECT `order`.id,`order`.user_id , `order`.date, `order`.isShipped,`order`.isCanceled,"
					+ " `order_info`.order_id, `order_info`.product_id, `order_info`.qty, `order_info`.price "
					+ "FROM `order` INNER JOIN `order_info` ON `order`.id = `order_info`.order_id;";
			
			PreparedStatement ps = MDB.getPS(query);

			
			ResultSet rs = ps.executeQuery();

			int orderId = 0;
			
			Order order = new Order();
			
			// Une ligne = un item avec qte
			while(rs.next()) {
				
				// Si nouvel commande, creer une nouvelle commande
				if(orderId != rs.getInt("id")){
					
					// Ecraser le orderId de condition
					orderId = rs.getInt("id");
					
					// Nouvelle commande
					order = new Order();
					
					order.setId(orderId);
					order.setUserId(rs.getInt("order.user_id"));
					order.setDate(rs.getString("order.date"));
					order.setShipped(rs.getBoolean("order.isShipped"));
					order.setCanceled(rs.getBoolean("order.isCanceled"));
					
					// Ajouter la commande a la liste	
					orderList.add(order);
				}
				
				// Recupérer l'item suivant
				int itemId = rs.getInt("order_info.product_id");
				
				// Recuperer l'item complet de la BD
				Item item = MItem.getItemById(itemId);
				
				// Ecraser le prix et ajouter la quantité
				ItemCart itemC = new ItemCart(item);
				itemC.setQty(rs.getInt("order_info.qty"));
				itemC.setPrice(rs.getDouble("order_info.price"));
				
				// Ajouter l'itemPanier au panier
				order.addItem(itemC.getSerial(), itemC);
			}
			
			//orderList.add(order);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MDB.disconnect();
		}
		
		return orderList;
	} 
	

public static boolean updateOrderStatus(int orderId) {
	
	int row =0;
	try {
		
		MDB.connect();

		String query = "update isidrone.order set isShipped=true where id=?;";	
		PreparedStatement ps = MDB.getPS(query);
		ps.setInt(1,orderId);
	    row = ps.executeUpdate();
	    
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		MDB.disconnect();
	}
	
	return row>0? true: false;
}
public static boolean cancelOrder(int orderId)
{
	int row =0;
	try {
		
		MDB.connect();
		
		String qry = "SELECT  `order`.isShipped FROM `order` where `order`.id =?";
		
		PreparedStatement p = MDB.getPS(qry);
		p.setInt(1,orderId);
		
		ResultSet rs = p.executeQuery();
		
		while(rs.next())
		{
			if( rs.getInt("isShipped")==0)
					{
				
				String query = "update isidrone.order set isCanceled=true where id=?;";	
				PreparedStatement ps = MDB.getPS(query);
				ps.setInt(1,orderId);
			    row = ps.executeUpdate();
			    if(row>0) {
			    	return true;
			    }
				
			}
			else {
				return false;
			}
		}
		

		
	    
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		MDB.disconnect();
	}
	
	return row>0? true: false;
}
}
