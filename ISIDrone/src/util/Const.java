package util;

public class Const {
	
	public static String COMP_NAME = "Isi Drone";
	
	/*********
	 * Paths *
	 *********/
	
	// Private
	public static String PATH_PRIVATE = "/WEB-INF/";
	
	private static String PATH_INCLUDES = PATH_PRIVATE +  "includes/";
	
	private static String PATH_GLOBAL_INCLUDES = PATH_INCLUDES +  "_global/";
	private static String PATH_INDEX_INCLUDES = PATH_INCLUDES +  "index/";
	
	
	
	// Public
	
	public static String isEnvType_production="false";
	public static String PATH_EnvType_production_dbPropery="/opt/tomcat/apache-tomcat-9.0.16/webapps/db.properties";

	
	
	
	// Global;
	
	public static String ROLE_ADMIN="admin";
	public static String ROLE_USER="customer";
	public static String PATH_IMG = "images/";
	public static String PATH_IMG_PRODUCT = "images/products/";
	public static String ORDER_ACTION_UPDATE_STATUS="changeStatus";
	public static String ORDER_ACTION_CANCEL="cancelOrder";
	
	public static String PATH_HEAD_JSP = PATH_GLOBAL_INCLUDES + "head.jsp";			// <head>
	public static String PATH_FOOTER_JSP = PATH_GLOBAL_INCLUDES + "footer.jsp";		// Footer
	public static String PATH_MENU_JSP = PATH_GLOBAL_INCLUDES + "menu.jsp";			// Menu
	public static String PATH_CART_DROPDOWN_JSP = PATH_GLOBAL_INCLUDES + "cart_dropdown.jsp";			// Menu
	public static String PATH_CATEGORY_JSP = PATH_GLOBAL_INCLUDES + "category.jsp";
	
	public static String PATH_PAGE_HOME = PATH_PRIVATE + "index.jsp";
	public static String PATH_PAGE_ITEMS = PATH_PRIVATE + "items.jsp";
	public static String PATH_PAGE_ABOUT = PATH_PRIVATE + "about.jsp";
	public static String PATH_PAGE_CONTACT = PATH_PRIVATE + "contact.jsp";
	public static String PATH_PAGE_ITEM = PATH_PRIVATE + "item.jsp";
	public static String PATH_PAGE_LOGIN = PATH_PRIVATE + "login.jsp";
	public static String PATH_PAGE_SIGNUP = PATH_PRIVATE + "signUp.jsp";
	public static String PATH_PAGE_SIGNUP_COMPLETE = PATH_PRIVATE + "signUpComplete.jsp";
	public static String PATH_PAGE_CART = PATH_PRIVATE + "cart.jsp";
	public static String PATH_PAGE_INVOICE = PATH_PRIVATE + "invoice.jsp";
	public static String PATH_PAGE_SUMMARY = PATH_PRIVATE + "summary.jsp";
	public static String PATH_PAGE_CARTUSER = PATH_PRIVATE + "cartuser.jsp";
	public static String PATH_PAGE_ORDERHISTORY = PATH_PRIVATE + "order-history.jsp";
	public static String PATH_PAGE_SERVICE = PATH_PRIVATE + "service.jsp";
	public static String PATH_PAGE_ALLCUSTOMERORDER=PATH_PRIVATE + "customers-orders.jsp";

	public static String PATH_PAGE_LISTCATEGORY=PATH_PRIVATE+"listCategory.jsp";

	
	// Index
	public static String PATH_MENU_BANNER = PATH_INDEX_INCLUDES + "banner.jsp";		// Banner
	
	//public static String PATH_MENU_PRODUCT = PATH_IMG + "product.png";	// Place Holder Product
}
