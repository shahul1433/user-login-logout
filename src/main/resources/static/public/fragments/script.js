function doLogout(){
	var url = window.location.origin + "/logout";
	console.log(url);
	$.post(url,{},function(data,status){
		alert("Data : "+data+" , Status : "+status);
	});
}