<%@page import="util.Misc"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>

<%@page import="java.util.ArrayList, entities.Category"%>
<%
ArrayList<Category> categories=null;
categories= (ArrayList<Category>) request.getAttribute("categories");
 String msg=(String) request.getAttribute("message");
%>
 
<!-- Page Content -->
<div class="container">


    
	  	<form action="ManageItem" method="post" class="panel panel-primary form-horizontal col-sm-12 col-lg-12 col-md-12" style="float: unset; margin: auto;">
	  	  <% if(msg !=null){ %>
	  		<div class="alert alert-success" style="margin: 20px; white-space: pre-line;"><%=msg %></div>
	  		
	  		<%} %>
	  		<div class="panel-heading">
	  			<h3 class="panel-title">Add New Product</h3>
	  		</div>
	  		<div class="panel-body">
		  		<fieldset class="col-sm-9 col-lg-9 col-md-9 col-md-offset-2">
		  			<legend> Product Information</legend>



					<div class="form-group">
						<div class="col-sm-10">
						<label for="product-category" class="col-sm-4 control-label">Select Product Category  </label>
							<select class="selectpicker form-control" name="product-category">
							
							
							<% for (int i=0 ; i<categories.size();i++){%>
								
						<option value="<%=categories.get(i).getId() %>">  <%=categories.get(i).getName()%></option>  
							<% } %>
						      
						      
						      </select>
						</div>
					</div>



					<div class="form-group">
						<div class="col-sm-10">
							
							<input type="text" id="productName" class="form-control" placeholder="Enter product name" name="productName" value="" required />
						</div>
					</div>


					<div class="form-group">	
						<div class="col-sm-10">
						
							<input type="text" id="description" class="form-control" name="description" placeholder="Enter description" value="" required />
						</div>
					</div>
					
					


					<div class="form-group">	
						<div class="col-sm-10">
						
							<input type="number" id="price" class="form-control" name="price" placeholder="Enter Price" value="" required />
						</div>
					</div>
					


					<div class="form-group">	
						<div class="col-sm-10">
						
							<input type="text" id="serialNumber" class="form-control" name="serialNumber" placeholder="Enter serialNumber" value="" required />
						</div>
					</div>
					


					<div class="form-group">	
						<div class="col-sm-10">
						
							<input type="number" id="stkqty" class="form-control" name="stkqty" placeholder="Enter Stock Qty" value="" required />
						</div>
					</div>

				</fieldset>
			
				
				<div class="form-group text-center" style="clear: left; top: 15px; margin-bottom: 15px;">
						<button type="submit" class="btn btn-default"> Submit</button>
				</div>
			</div>
		</form>
    </div>
<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>
