$(document).ready(function(){
	//alert('work');
	$('#mail').on('input', function() {
		var name=$('#mail').val();
		var re = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/;
		var email=re.test(name);
		if(name){	
			if(email){
				//valid = true;
				$('#valid').html('');
			}
			else{
				//valid = false;
				$('#valid').html('Plz Enter valid email');
			}
		}
		else{
			//valid = false;
			$('#valid').html('Plz Enter email');
			//input.removeClass("valid").addClass("invalid");
		}
	});

	$('#submit').click(function(){
		if($('#mail').val()==''||$('#valid').text()!=''){
			alert('plz enter the Username');
		}
		else{
			//alert("mail:" + $('#mail').val());
			$.ajax({
				type:'PUT',
				url:'rest/forgot-password?username=' + $('#mail').val() ,
				//data:JASON.stringify({email_id : $('#mail').val()}),
				data:{},
				datatype:'text',
				async: false,
				success : function(data){
					alert(data);
					if(data=='Password Changed Successfully!!')
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
	//alert(query);
	//mail = document.getElementById('mail');
	if (window.XMLHttpRequest) { 
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("GET", "http://localhost:8080/EventHumanResource/rest/validate?" +"email_id1"+ "=" + query, true);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState != 4 && xmlhttp.status == 200) {
			document.getElementById(field).innerHTML = "Validating..";
		} else if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			//alert("asdjk");
			document.getElementById(field).innerHTML = xmlhttp.responseText;
		} else {
			//alert(xmlhttp.readyState + " " + xmlhttp.status);
			document.getElementById(field).innerHTML = "Error Occurred.";
		}
	};
	xmlhttp.send(null);
	
}   