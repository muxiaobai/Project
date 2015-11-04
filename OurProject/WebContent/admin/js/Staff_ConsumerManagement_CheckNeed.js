$(document).ready(function(){
	
			$.get("../../Staff_ConsumerManagement_CheckNeed", { }, function(m){
				alert("a");
				$("table tr:gt(0)").remove();
				var tbl = "";
				
				for (var i = 0; i < m.rows.length; i++) {
					var r = m.rows[i];
					tbl += "<tr id='tr'" + r.supplierneed_id + "'><td>"+r.supplierneed_id+"</td><td>" + r.supplierneed_supplierid + "</td><td>" +r.supplierneed_number + "</td><td>"+ r.supplierneed_unit +"</td><td>" +r.supplierneed_highprice+"</td><td>" +r.supplierneed_lowprice+"</td><td>" +
					r.supplierneed_begintime+"</td><td>"+r.supplierneed_endtime + "</td><td>"+r.supplierneed_statetime + "</td><td><a data='" + r.supplierneed_id + "' class='btn btn-info'>审核通过</a></td></tr>";
				}
				$("table").append(tbl);
				
				
			
//				$("table a").click(function(){
//					var id = $(this).attr("data");
//					$.get("../../Staff_ConsumerManagement_CheckNeedUpdate", {need:id}, function(m1){    //传递参数
//						if (m1.S) { 
//							$("#tr" + id).remove();
//						}
//					});
//					
//				});
	 });
		
	});

