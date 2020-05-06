	<%@page import="java.text.DecimalFormat"%>
<%@page import="entities.ItemCart"%>
<%@page import="entities.Order"%>
<%@page import="java.util.List"%>
<%@page import="util.Const"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Format a deux decimaldf
	DecimalFormat df = new DecimalFormat("####0.00");

	// Recupere la liste de commande
	@SuppressWarnings("unchecked")
	List<Order> orderList = (List<Order>)session.getAttribute("orderList");
%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>

<div class="container">
	<div class="row">
    	<div class="col-md-12">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h3 class="panel-title"><strong>Order History</strong></h3>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<%
    							if(orderList.size() != 0){
    						%>
    						<thead>
                                <tr>
        							<td><strong>ID</strong></td>
        							<td class="text-center"><strong>Date</strong></td>
        							<td class="text-center"><strong>Order Status</strong></td>
        							<td class="text-center"><strong>Number of Products</strong></td>
        							<td class="text-right"><strong>Total</strong></td>
                                </tr>
    						</thead>
    						<%
    							}else{
    						%>
    							<span>No Order Available</span>
    						<%
    							}
    						%>
    						<%
    							int i = 0;
    							for(Order order: orderList){
    								i++;
    								
    						%>
    							
	    							<tr>
	    								<td style=":hover"><%="<a href='order?no=" +  order.getId()  + "'>View # " + order.getId() + "</a>"%></td>
	    								<td class="text-center"><%=order.getDate()%></td>
	    								<td class="text-center" style='color: #eb9f36 !important;font-weight: bold;'><%
	    								if(order.isCanceled()){
	    									
	    									out.print("Order is canceled");
	    								}
	    								else {
	    									out.print("Order is Shipped");
	    								}
	    								
	    								%></td>
	    								<td class="text-center">
	    								<%
	    									int size = 0;
	    									for (ItemCart itemC : order.getCart().values()) {
	    										size += itemC.getQty();
	    									}
	    		 	               			out.println(size); %>
	    								</td>
	    								<td class="text-right"><Strong><%=df.format(order.generateTotal())%>$</Strong></td>
	    							</tr>
    							
    						<%	
    								}
    						%>
    					</table>
    				</div>
    			</div>
			</div>
		</div>
	</div>

</div>

<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>