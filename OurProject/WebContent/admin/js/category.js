$(document).ready(function(){
	 $("#dalei").change(function() {SelectChange();});
	 function SelectChange() {
        //获取下拉框选中项的value属性值
        var dalei= $("#dalei").val()      
        $.get("../../Menu1", {category_fanumber:dalei}, function(m){	
        	$("#xiaolei :gt(0)").remove();
			$("#xiaolei").append(m);
        });
	 }
	 
	 $("#xiaolei").change(function() {SelectChange1();});
	 function SelectChange1() {
        //获取下拉框选中项的value属性值
        var xiaolei= $("#xiaolei").val(); 
        
        $.get("../../Menu1", {category_fanumber:xiaolei}, function(m1){		
        	$("#pinzhong :gt(0)").remove();
			$("#pinzhong").append(m1);
        });
	 }
      
});