

$(document).ready(function(){
	var Sdata = localStorage.getItem('url');
	var data = JSON.parse(Sdata);
	
	if(/*$.cookie("Session")==""*/ !data)
	{	
		alert("Sorry you are not authorized!! Need to login")
		window.location.replace('http://localhost:8080/EventHumanResource');
	}
	else{
		var url = data.url;
//	$(window).load(function() {
//		alert("heelo");
//		var cookie = document.cookie;
//		if(cookie == null){
//			alert("User need to login");
//			window.location.replace('http://localhost:8080/EventHumanResource/');
//		}	
//	});

//	alert("working");
	
//	alert(url.contains("client"));	
//	alert(data.url);
	$.ajax({
		type: 'GET',
		url: data.url,
		contentType: 'application/json; charset=utf-8',
		data:{},
		dataType: 'json',
		//async: false,
		success: function(data) {
			//alert(data.email_id);
			//alert(data.url.contains("client"));	
				if((url).indexOf("client")>=0) {
					$('<div>'+data.email_id+'</div>').appendTo('#mail');
					$('<div>'+data.client_name.f_name+' '+data.client_name.l_name+'</div>').appendTo('#fname');
					$('<div>'+data.client_name.f_name+' '+data.client_name.l_name+'</div>').appendTo('#prof_name');
					$('<div>'+data.client_name.f_name+' '+data.client_name.l_name+'</div>').appendTo('#uname');
					$('<div>'+data.ph_no+'</div>').appendTo('#mob');
					$('<div>'+data.address.add_line1+'</div>').appendTo('#bio');
					$('<div>'+data.address.zipcode+'</div>').appendTo('#zip');
					$('<div>'+data.address.city+'</div>').appendTo('#city');
					$('<div>'+data.comp_name+'</div>').appendTo('#Company');
					$('<div>'+data.dob.dd+'</div>').appendTo('#dob_dd');
					$('<div>/'+data.dob.mm+'</div>').appendTo('#dob_mm');
					$('<div>/'+data.dob.yyyy+'</div>').appendTo('#dob_yyyy');
				} else {
					var skill = [];

					$.each(data.skills,function(key,val){
						skill.push(val.skill_name);

					});
					
					$('<div>'+data.email_id+'</div>').appendTo('#mail');
					$('<div>'+data.freelancer_name.f_name+' '+data.freelancer_name.l_name+'</div>').appendTo('#fname');
					$('<div>'+data.freelancer_name.f_name+' '+data.freelancer_name.l_name+'</div>').appendTo('#prof_name');
					$('<div>'+data.freelancer_name.f_name+' '+data.freelancer_name.l_name+'</div>').appendTo('#uname');
					$('<div>'+data.ph_no+'</div>').appendTo('#mob');
					$('<div>'+data.address.add_line1+'</div>').appendTo('#bio');
					$('<div>'+data.address.zipcode+'</div>').appendTo('#zip');
					$('<div>'+data.address.city+'</div>').appendTo('#city');
					$('<div>'+data.dob.dd+'</div>').appendTo('#dob_dd');
					$('<div>/'+data.dob.mm+'</div>').appendTo('#dob_mm');
					$('<div>/'+data.dob.yyyy+'</div>').appendTo('#dob_yyyy');
					$('<div>'+skill +'</div>').appendTo('#Profession');
					/*$.each(skill,function(key,val){
						val + ','
					})*/
					
					$('<div>'+data.work_environment+'</div>').appendTo('#job');
				}
				//alert(data.eventDate);
			}
			//alert(data);
		
	});
	$('#logout').click(function(){
//		alert("zindabad" + data.url + "/logout");
		$.ajax({
			type: 'GET',
			url: data.url + '/logout',
//			data : "",
			contentType: 'text/plain',
			dataType: 'text',
//			async: false,
			success: function(data) {
				alert(data);
				localStorage.clear('url');
				window.location.replace('http://localhost:8080/EventHumanResource/');
			}
				});
	});
	/*var arr2 = { eventType : upcoming };
	$.ajax({
		type: 'POST',
		url: '',
		data: arr2,
		contentType: 'application/json; charset=utf-8',
		dataType: 'json',
		async: false,
		success: function(data) {
			$.each(data, function(i, item) {
				alert(item.eventName);
				alert(item.eventDate);
			});
			//alert(data);
		}
	});*/
	}
});