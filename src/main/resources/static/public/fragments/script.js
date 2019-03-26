function doLogout(){
	var urlLogout = window.location.origin + "/logout";
	var urlLogin = window.location.origin + "/login";
	$.post(urlLogout,{},function(data,status){
		location.replace(urlLogin);
	});
}