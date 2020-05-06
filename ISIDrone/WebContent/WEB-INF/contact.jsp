<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
	<!-- /.container -->
    <!-- Page Content -->
    <div class="container">
    	<div class="col-md-5">
		    <div class="form-area">  
		        <form role="form" action="contact" method="post">
                    <h3 style="margin-bottom: 25px; text-align: center;">Formulaire de contact</h3>
    				<div class="form-group">
						<input type="text" class="form-control" id="name" name="name" placeholder="Nom" required>
					</div>
					<div class="form-group">
						<input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="subject" name="subject" placeholder="Sujet" required>
					</div>
                    <div class="form-group">
                    <textarea class="form-control" id="message" placeholder="Message" rows="7"></textarea>                  
                    </div>
		        	<button type="submit" id="submit" class="btn btn-default pull-left">Envoyer</button>
				</form>
    		</div>
    	</div>
   		<div class="col-md-5">
   			 <div class="span4">
	    		<h2>ISI Drone</h2>
	    		<address>	
	    			2100 Boulevard Maisonneuve Est<br>
	    			1er étage<br>
	    			Montréal (Québec)<br>
	    			H2K 4S1<br>
	    			<abbr title="email">Email: </abbr>info@isi-mtl.com<br>
	    			<abbr title="Téléphone">Tel: </abbr> (514)-842-2426
	    		</address>
	    	</div>
   			 <div class="span8">
	        	<iframe src="https://maps.google.com/maps?q=2100%20Boulevard%20de%20Maisonneuve%20East%2C%20Montr%C3%A9al%2C%20QC%20H2K%204S1&t=&z=13&ie=UTF8&iwloc=&output=embed" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
	    	</div>
   		</div>
	</div>
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>