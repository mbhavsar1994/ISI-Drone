package action;

import java.util.List;

import entities.Cart;
import entities.Order;
import entities.User;
import manager.MOrder;
import manager.MSendMail;

public class ActionOrder {
	
	// Methode executé lorse qu'une commande est completé
	public static int process(User user, Cart cart){
		
		// Ajoute la commande a la base de donnée
		int orderId = MOrder.add(user, cart);
		
		// Envoie d'un email de confirmation
		String to = user.getEmail();
		sendEmail(to);
		
		return orderId;
	}
	
	private static void sendEmail(String to){
		
		// Envoie d'un email de confirmation
		String sujet = "Achat completé";
		String message = "Félicitation, vous avez commander quelquechose.";
		
		MSendMail.sendEmail(message, to, sujet);
		
	}
	
	public static List<Order> getHistoryByUserID(){
		List<Order> orderList = MOrder.getAllOrdersByUserId();
		
		return orderList;
	}
	
	public static List<Order> getCustomersOrder(){
		
		List<Order> orderList = MOrder.getAllOrders();
		
		return orderList;
	}
	
	public static boolean updateOrderStatus(int orderId) {
		
		return MOrder.updateOrderStatus(orderId);
	}
	public static boolean cancelOrder(int orderId)
	{
		return MOrder.cancelOrder(orderId);
	}
}
