<%@page import="java.text.DecimalFormat"%>
<%@page import="entities.ItemCart"%>
<%@page import="entities.Order"%>
<%@page import="entities.Category" %>
<%@page import="java.util.List"%>
<%@page import="util.Const"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	//Format a deux decimaldf
	DecimalFormat df = new DecimalFormat("####0.00");

    // get list of all customer orders
	@SuppressWarnings("unchecked")
	List<Category> categoryList = (List<Category>)session.getAttribute("categories");
%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>


  <div class="container">
	<div class="row">
    	<div class="col-md-12">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h3 class="panel-title"><strong>Category List</strong>&nbsp;&nbsp;&nbsp;&nbsp;
    				<button type="button" class="btn btn-primary">Add New Category</button></h3>
    			</div>
    			
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<%
    							if(categoryList.size() != 0){
    						%>
    						<thead>
                                <tr>
        							
        							<td class="text-center"><strong>Name</strong></td>
        							<td class="text-center"><strong>Order of Appearance</strong></td>
        							
        							
        							<td class="text-center"><strong>Action</strong></td>
                                </tr>
    						</thead>
    						<%
    							}else{
    						%>
    							<span>No Category available</span>
    						<%
    							}
    						%>
    						<%
    							int i = 0;
    							for(Category category: categoryList){
    								i++;

    								boolean  isActive= category.isActive();
    								
    								
    									
    						%>
    							
	    							<tr>
	    								
	    								<td class="text-center"><%=category.getName()%></td>
	    								<td class="text-center"><%=category.getOrder()%>
	    								
	    									
	    								
	    								
	    								
	    								
	    								<td class="text-center"><button <%=category.getId() %>type="button" class="btn btn-primary">Edit</button>
	    								
	    								
	    								<button  <%=category.getId() %> type="button" class="btn btn-danger">Delete</button>
	    								
	    								</td>
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