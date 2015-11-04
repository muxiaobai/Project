var Gid  = document.getElementById ;
var showArea = function(){
	Gid('show').innerHTML = "<h3>省" + Gid('Province').value + " - 市" + 	
	Gid('City').value + " - 县/区" + 
	Gid('District').value + "</h3>"
							}
Gid('District').setAttribute('onchange','showArea()');