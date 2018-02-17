

$(document).ready(function(){
	var Sdata=localStorage.getItem('url');
	var data=JSON.parse(Sdata);
	if(!data)
	{
	$('#mail').on('input', function() {
		var input=$(this);
		var name=input.val();
		var re = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
		var email=re.test(name);
		if(name){	
			if(email){
				//valid = true;
				$('#mail1').html('');
			}
			else{
				//valid = false;
				$('#mail1').html('Plz Enter valid email');
			}
		}
		else{
			//valid = false;
			$('#mail1').html('Plz Enter email');
			//input.removeClass("valid").addClass("invalid");
		}
	});

	$('#pass').on('input', function() {
		var input=$(this);
		var name=input.val();
		if(name){	
			$('#pass1').html('');
		}
		else{
			//valid = false;
			$('#pass1').html('Plz Enter password');
			//input.removeClass("valid").addClass("invalid");
		}
	});
	
	
	function make_base_auth(user, password) {
		  var tok = user + ':' + password;
		  var hash = btoa(tok);
		  return "Basic " + hash;
		}
	
	$("#submit").click(function(){
		//alert('entered');
		var email = $("#mail").val();
		var pass = $("#pass").val();
		var email1 = $("#mail1").text();
		// Returns successful data submission message when the entered information is stored in database.
		//alert(email1);
		if(email=='' || pass=='' || email1=='Plz Enter valid email')
		{
			alert("Plz Enter valid Email and Password!!");
			
		}
		else
		{
			// AJAX Code To Submit Form.
			//var arr = {email_id : email , password : pass };
			$.ajax({
				type: "POST",
				url: "rest/login/verify-user?username=" + email,
				data: {},
				contentType: 'application/jason; charset=utf-8',
				dataType: 'json',
				//async: false,
				headers: {
				    'Authorization': "Basic " + btoa(email + ":" + pass)
				  },
//				beforeSend: function (xhr){ 
//			        xhr.setRequestHeader('Authorization', make_base_auth(email, pass)); 
//			    },
			
				success: function(data){
//					alert(data.url);​
					if(data.url=='wrong email and password')
						alert(data.url);
					else{
						localStorage.setItem('url',JSON.stringify(data));
						window.location.replace(data.url);o
					}
				}
//				 error: function(xhr, status, error) {
//					  var err = eval("(" + xhr.responseText + ")");
//					  alert(err.Message);
//				} 
			});
		}
		return false;
	});
	}
	else{
		if ((data.url).indexOf("client") >= 0){
			window.location.replace('Employer_profile.html');
		}
		else{
			window.location.replace('Employee_profile.html');
		}
	}
});