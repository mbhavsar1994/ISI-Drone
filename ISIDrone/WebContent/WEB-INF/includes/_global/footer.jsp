<%@page import="util.Misc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="util.Const"%>

    <div class="container">

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; <%=Const.COMP_NAME%> <%= Misc.getCurrYear() %></p>
                </div>
            </div>
        </footer>

    </div>
      <%
	    String pageUrl = request.getRequestURI();
		String fileName = Misc.getFileNameFromUrl(pageUrl);
		
		switch(fileName){
		case "cart":{
			out.println("<script src='js/cart.js'></script>");
			break;
		}		
		case "invoice":{
			out.println("<script src='js/3rd/jQuery.print.js'></script>");
			out.println("<script src='js/invoice.js'></script>");
			break;
		}
		}
	%>

    <!-- jQuery -->
    <script src="js/3rd/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/3rd/bootstrap.min.js"></script>
    
	<!--     AJAX cart dropdown menu -->
    <script src="js/cart_dropdown.js"></script>
    
    <!-- User -->
    <script src="js/userPanelToogle.js"></script>
    
    <!-- AutoComplete Search -->
  	<script type="text/javascript" src="js/3rd/jquery.autocomplete.min.js"></script>
  	<script type="text/javascript" src="js/drone-autocomplete.js"></script>
  	
  	<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
  
</body>

</html>