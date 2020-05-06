
var id=-1;
var str= "#sts_";

$(document).ready(function() {
	$("#user").click(function () {
		$("#userAction").toggle();
	});	
	
	//toggle event to change status for shipped order
    $('.toggle-event').change(function() 
    {
    	 id =$(this).attr('id');
       if( $(this).prop('checked')==true)
    	  {
    	 
    	  $('#confirm').modal({
    	      backdrop: 'static',
    	      keyboard: false
    	  })	 
    	 }
       else 
	      {		    	 
	    	  $(str.concat( id)).html("In Shippment");
	      };
    });
      
    //event to perform shipped confirmation cancel action
    $("#confirm_Cancel").click(function(){
 	  var s="#";
 	     $(s.concat(id)).bootstrapToggle('off')  ;
    });
    
    //event to perform shipped confirmation "YES" action
    $("#confirm_Yes").click(function(){
 	   $(str.concat( id)).html("Shipped");
 
  	  var s="#";
	    $.ajax({
	       type : "POST",
	       url : "customerorders",
	       data : "orderid=" + id + "&action=changeStatus",
	       success : function(msg) {	  
	    		  $(s.concat(id)).bootstrapToggle('disable');
	    		  $("#cncl_".concat(id)).attr('disabled', true);
	    		  id=-1; 
	       }
	       });
	      
    });
    
    $('.btn.btn-danger.cancl-ordr').click(function(){
 	  
  	 	var id = $(this).attr('id');
   
    	var orId= id.split("_")[1];
	    $.ajax({
	       type : "POST",
	       url : "customerorders",
       data : "orderid=" + orId + "&action=cancelOrder",
       success : function(msg) {
    	  		  
    		  $("#".concat(orId)).bootstrapToggle('disable')
    		  $("#".concat(id)).attr('disabled', true);
              $("#ord_cncel").show();
              $(str.concat( orId)).html("Canceled");
              
       }
	       });
	      
    });
    	
});

