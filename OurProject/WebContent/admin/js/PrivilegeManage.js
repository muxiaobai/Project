$(document).ready(function(){
		pageURL=$('#Page').val();
		  $.post("../../PrivilegeManage",{page:pageURL},function(m){
			 			for(var i=0;i<m.rows.length;i++){
			 			 	var r=m.rows[i];
			 			for(var menu in r){
			 				//alert(menu);
							  //alert(menu+':'+r[menu]);
							  if(r[menu]=="false"){
								  $("#"+menu).remove();
							  }
			 			};
			 				
			 			}
		  
	  });
	  
		  
		  
	});
