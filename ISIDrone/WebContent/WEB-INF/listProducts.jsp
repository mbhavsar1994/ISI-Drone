<%@page import="java.text.DecimalFormat"%>
<%@page import="entities.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Category"%>
<%@page import="entities.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<%
@SuppressWarnings("unchecked")
	ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("items");
%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>


  <div class="container">
	<div class="row">
    	<div class="col-md-12">
    		<div class="panel panel-default">  
    			<div class="panel-heading">
    				<h3 class="panel-title" style="display: inline-block;"><strong>Product List</strong></h3>    <a href="ManageItem" style="display: inline-block; margin-left :20px;font-weight:bold" >Add New Product</a>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<%
    							if(items.size() != 0){
    								//if(items.size() > 0){
    						%>
    						<thead>
                                <tr>
        							<td><strong>Product ID</strong></td>
        							
        							<td class="text-center"><strong>Name</strong></td>
        							<td class="text-center"><strong>Price</strong></td>
        					   <td class="text-center"><strong>Qty</strong></td>
        						
                                </tr>
    						</thead>
    						<%
    							}else{
    						%>
    							<span>No Product available</span>
    						<%
    							}
    						%>
    						<%
    							int i = 0;
    						for(Item item : items) {
    								i++;
    						%>
    							
	    							<tr>
	    								<td style=":hover"><%="<a href='order?no=" + i + "'>" +item.getId() + "</a>"%></td>
	    								
	    								<td class="text-center"><%=item.getName()%></td>
	    								<td class="text-center"><%=item.getPrice()%></td>
	    								<td class="text-center"><%=item.getStock()%></td>
	    							
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