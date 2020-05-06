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

    // get list of all customer orders
	@SuppressWarnings("unchecked")
	List<Order> orderList = (List<Order>)session.getAttribute("orderList");
%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>

<div id="confirm" class="modal fade" role="dialog">

<div class="modal-dialog modal-md">
      <div class="modal-content">
<div class="modal-header">
Confirm Order Shipment 
</div>
  <div class="modal-body">
    Order is being Shipped?
  </div>
  <div class="modal-footer">
    <button type="button" data-dismiss="modal" class="btn btn-primary" id="confirm_Yes">Yes</button>
    <button type="button" data-dismiss="modal" class="btn "  id="confirm_Cancel">Cancel</button>
  </div>
  </div>
  </div>
</div>

<div class="container">
<div class="row">
<div style="display: none;" class="alert alert-success" id="ord_cncel" role="alert">
	  		 Order is canceled!
	  	</div>
</div>
</div>

<div class="container">
	<div class="row">
    	<div class="col-md-12">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h3 class="panel-title"><strong>Customer orders</strong></h3>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<%
    							if(orderList.size() != 0){
    						%>
    						<thead>
                                <tr>
        							<td><strong>Order ID</strong></td>
        							<td class="text-center"><strong>Date</strong></td>
        							<td class="text-center"><strong>Number of Products</strong></td>
        							<td  class="text-center"><strong>Order Status</strong></td>
        							<td class="text-center"><strong>Action</strong></td>
                                </tr>
    						</thead>
    						<%
    							}else{
    						%>
    							<span>No order available</span>
    						<%
    							}
    						%>
    						<%
    							int i = 0;
    							for(Order order: orderList){
    								i++;
    								boolean  a= order.isShipped();
    								boolean isCanceled= order.isCanceled();
    								
    								if(a==false && isCanceled== false){
    								
    						%>
    							
	    							<tr>
	    								<td style=":hover"><%="<a href='order?no=" + order.getId() + "'>View # "  + order.getId() + "</a>"%></td>
	    								<td class="text-center"><%=order.getDate()%></td>
	    								<td class="text-center">
	    								<%
	    									int size = 0;
	    									for (ItemCart itemC : order.getCart().values()) {
	    										size += itemC.getQty();
	    									}
	    		 	               			out.println(size);
	    								%>
	    								</td>
	    								<td class="text-center"><% 
	    								
	    								
	    									out.println("<span style='color: #eb9f36 !important;font-weight: bold;' id='sts_"+order.getId()+"'> In Shipment </span>");
	    									
	    								
	    								  %> </td>  

	    								<td class="text-center">

	    								<%
	    								
	    								
	    									out.println("<input class='toggle-event' id="+order.getId()+" type='checkbox'  data-toggle='toggle' data-on='Shipped' data-off='In shipment'  data-style='slow' data-onstyle='success'>"); 
	    								 %>
	    								 
	    								 <button  type="button" id="cncl_<%=order.getId() %>" class="btn btn-danger cancl-ordr">Cancel Order</button>
	    								
	    								</td>
	    							</tr>
    							
    						<%	
    							}}
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