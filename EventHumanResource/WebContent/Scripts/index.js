/**
 * 
 */


$(document).ready(function(){

	var Sdata=localStorage.getItem('url');
	var data=JSON.parse(Sdata);
	
	if(!data) {
		
	}else{
		if ((data.url).indexOf("client") >= 0){
			window.location.replace('Employer_profile.html');
		}
		else{
			window.location.replace('Employee_profile.html');
		}
	}
	
	
	$('#custom').click(function(){
		alert('You need to login first');
		window.location.replace('login.html');
	});
	
	
});