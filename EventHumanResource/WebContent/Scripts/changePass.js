$(document).ready(function(){
	var data = localStorage.getItem('url');
	var Sdata = JSON.parse(data);
	//alert('work');
	/*$('#pass2').on('input', function() {
		var name=$('#pass2').val();	
			if(name){
				//valid = true;
				$('#valid').html('Too short');
			}
		else{
			//valid = false;
			$('#valid').html('');
			//input.removeClass("valid").addClass("invalid");
		}
	});*/

	$('#submit').click(function(){
		if($('#pass2').val()=='' || $('#pass1').val()=='' || !($('#valid').text()=='')){
			alert('plz enter the required fields');
		}
		else{
			$.ajax({
				type:'PUT',
				url: Sdata.url + '/updatePassword',
				data:{},
				headers: {
				    'PasswordChange':btoa($('#pass1').val() + ":" + $('#pass2').val())
				},			
				datatype:'text',
				async: false,
				success : function(data){
					alert(data);
					if(data=='Password changed Successfully!!')
					{
						window.location.replace('login.html');
					}
				}
			});
		}
	});
	
	
});


function validate(field, query) {
	var xmlhttp;
	pass = document.getElementById('pass2');
	if (window.XMLHttpRequest) { 
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("GET", "http://localhost:8080/EventHumanResource/rest/validate?password=" + query, true);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState != 4 && xmlhttp.status == 200) {
			document.getElementById(field).innerHTML = "Validating..";
		} else if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			//alert("asdjk");
			document.getElementById(field).innerHTML = xmlhttp.responseText;
		} else {
			document.getElementById(field).innerHTML = "Error Occurred.";
		}
	};
	xmlhttp.send(null);
	
} 