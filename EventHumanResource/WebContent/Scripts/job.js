/**
 * 
 */
/*
$(document).ready(function(){
	alert('kea');
	//$('#'+0+' .id').html('lol');
	var data = localStorage.getItem('url');
	var Sdata = JSON.parse(data);
	alert(Sdata.url);
	//var data1;
	$.ajax({
		type: 'GET',
		url: Sdata.url + "/jobs/applied-for",
		contentType: 'application/json; charset=utf-8',
		//data: {},
		dataType: 'json',
		//async: false,
		success: function(data) {
			//data1=data;
			$.each(data,function(key,val){
				$('#'+key+' .id').html(val.job_id);
				$('#'+key+' .domain').html(val.job_skill);
				$('#'+key+' .disc').html(val.job_desc);
				//$('#'+key+' .mode').html(val.sample);
				$('#'+key+' .event_date').html(val.date);
				$('#'+key+' .event_name').html(val.event_id);
				$('#'+key+' .contact').html(val.client_id);
				$('#'+key+' .add').html(val.event_id);
				$('#'+key+' .pay').html(val.wage);
				//$('#'+key).attr(.id).html(val.sample);
			});
		}
			//alert(data);
	});
});

*/

$(document).ready(function(){
//	alert('kea');
	var data = localStorage.getItem('url');
	var Sdata = JSON.parse(data);
	if(!Sdata)
	{	
		alert("Sorry you are not authorized!! Need to login");
		window.location.replace('login.html');
	}
	else{
	/*var client_name;
	var client_ph_no = [];*/
	//var event_loc;
	//var skill_name;
	
	$('#logout').click(function(){
		//alert('logout');
//		alert("zindabad" + data.url + "/logout");
		$.ajax({
			type: 'GET',
			url: Sdata.url + '/logout',
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
	
	//$('#job').text("<li><tr ><td >1</td><td >Photographer</td><td >Team</td><td >2/2/2017</td><td >xyz</td><td >1234567890</td><td >kothrud,MIT COE,Pune</td><td >500</td></tr><li>");
	
	//$('.job').append('<tr ><td >1</td><td >Photographer</td><td >Team</td><td >2/2/2017</td><td >xyz</td><td >1234567890</td><td >kothrud,MIT COE,Pune</td><td >500</td></tr>');			
	//$('#'+0+' .id').html('lol');
	
	$('<div>'+Sdata.freelancer_name.f_name+' '+Sdata.freelancer_name.l_name+'</div>').appendTo('#prof_name');
	$('<div>'+Sdata.freelancer_name.f_name+' '+Sdata.freelancer_name.l_name+'</div>').appendTo('#uname');
//	alert(Sdata.url);
	//var data1;
	$.ajax({
		type: 'GET',
		url: Sdata.url + "/jobs/applied-for",
		contentType: 'application/json; charset=utf-8',
		//data: ,
		dataType: 'json',
		//async: false,
		success: function(data) {
			data1=data;
			//alert("Data:" + data);
			if(data.length<1){
				//alert("in if");
				$('.job1').append('<tr><td  rowspan="4" style="text-align:center border: 0px">No jobs are Applied</td></tr>');
			}
			else{
				//alert("not in if");
			$.each(data,function(key,val){
//				{.job2').append('<tr ><td >'+val.job_id+'</td><td >'+val.job_skill+'</td><td >'+val.work_environment+'</td><td >'+val.date.dd+'/'+val.date.mm+'/'+val.date.yyyy+'</td><td >'+val.event_id+'</td><td >'+val.client_id+'</td><td >'+val.client_id+'</td><td >'+val.wage+'</td></tr>');
				
//				$('#'+key+' .id').html(val.sample);
//				$('#'+key+' .domain').html(val.sample);
//				$('#'+key+' .disc').html(val.sample);
//				$('#'+key+' .mode').html(val.sample);
//				$('#'+key+' .event_date').html(val.sample);
//				$('#'+key+' .event_name').html(val.sample);
//				$('#'+key+' .contact').html(val.sample);
//				$('#'+key+' .add').html(val.sample);
//				$('#'+key+' .pay').html(val.sample);
//				//$('#'+key).attr(.id).html(val.sample);
				
				$.ajax({
					
					type: 'GET',
					url: "http://localhost:8080/EventHumanResource/rest/" + val.client_id + "/client",
					//contentType: 'application/json; charset=utf-8',
					//data: ,
					dataType: 'json',
					//async: false,
					success: function(data) {
						var client_name;
						var client_ph_no = [];
//						alert("alert1"+data.client_name.f_name);
						client_name=data.client_name.f_name + " " + data.client_name.l_name;
						client_ph_no=data.ph_no;
//						alert("alert2"+client_name);
//						alert(client_ph_no);
						
						$.ajax({
							type: 'GET',
							url: "http://localhost:8080/EventHumanResource/rest/" + val.event_id + "/event",
							//contentType: 'application/json; charset=utf-8',
							//data: ,
							dataType: 'json',
							//async: false,
							success: function(data) {
								var event_loc;
								event_loc=data.event_location;
//								alert(event_loc);
								
								$.ajax({
									type: 'GET',
									url: "http://localhost:8080/EventHumanResource/rest/" + val.job_skill + "/skillset",
									//contentType: 'application/json; charset=utf-8',
									//data: ,
									dataType: 'text',
									//async: false,
									success: function(data) {
//										alert(data);
										$('.job1').append('<tr ><td >'+data+'</td><td >'+val.work_environment+'</td><td >'+val.date.dd+'/'+val.date.mm+'/'+val.date.yyyy+'</td><td >'+client_name+'</td><td >'+event_loc+'</td><td >'+val.wage+'</td></tr>');
									}
								});
								//$('.job2').append('<tr ><td >'+val.job_id+'</td><td >'+val.job_skill+'</td><td >'+val.work_environment+'</td><td >'+val.date.dd+'/'+val.date.mm+'/'+val.date.yyyy+'</td><td >'+client_name+'</td><td >'+client_ph_no+'</td><td >'+event_loc+'</td><td >'+val.wage+'</td></tr>');
							}
						});
						
						
					}
					
				});
			
				//alert(client_name);
				//$('.job2').append('<tr ><td >'+val.job_id+'</td><td >'+val.job_skill+'</td><td >'+val.work_environment+'</td><td >'+val.date.dd+'/'+val.date.mm+'/'+val.date.yyyy+'</td><td >'+client_name+'</td><td >'+client_ph_no+'</td><td >'+val.event_id+'</td><td >'+val.wage+'</td></tr>');
			});
			}
		}
			//alert(data);
	});
	
	$.ajax({
		type: 'GET',
		url: Sdata.url + "/jobs",
		contentType: 'application/json; charset=utf-8',
		//data: ,
		dataType: 'json',
		//async: false,
		success: function(data) {
			data1=data;
			if(data.length<1)
				$('.job2').append('<td style="text-align:center">No jobs Alloted</td>');
			else{
			$.each(data,function(key,val){
//				$('.job2').append('<tr ><td >'+val.job_id+'</td><td >'+val.job_skill+'</td><td >'+val.work_environment+'</td><td >'+val.date.dd+'/'+val.date.mm+'/'+val.date.yyyy+'</td><td >'+val.event_id+'</td><td >'+val.client_id+'</td><td >'+val.client_id+'</td><td >'+val.wage+'</td></tr>');
				
//				$('#'+key+' .id').html(val.sample);
//				$('#'+key+' .domain').html(val.sample);
//				$('#'+key+' .disc').html(val.sample);
//				$('#'+key+' .mode').html(val.sample);
//				$('#'+key+' .event_date').html(val.sample);
//				$('#'+key+' .event_name').html(val.sample);
//				$('#'+key+' .contact').html(val.sample);
//				$('#'+key+' .add').html(val.sample);
//				$('#'+key+' .pay').html(val.sample);
//				//$('#'+key).attr(.id).html(val.sample);
				
				$.ajax({
					
					type: 'GET',
					url: "http://localhost:8080/EventHumanResource/rest/" + val.client_id + "/client",
					//contentType: 'application/json; charset=utf-8',
					//data: ,
					dataType: 'json',
					//async: false,
					success: function(data) {
						
//						alert("alert1"+data.client_name.f_name);
						client_name=data.client_name.f_name + " " + data.client_name.l_name;
						client_ph_no=data.ph_no;
//						alert("alert2"+client_name);
//						alert(client_ph_no);
						
						$.ajax({
							type: 'GET',
							url: "http://localhost:8080/EventHumanResource/rest/" + val.event_id + "/event",
							//contentType: 'application/json; charset=utf-8',
							//data: ,
							dataType: 'json',
							//async: false,
							success: function(data) {
								event_loc=data.event_location;
//								alert(event_loc);
								
								$.ajax({
									type: 'GET',
									url: "http://localhost:8080/EventHumanResource/rest/" + val.job_skill + "/skillset",
									//contentType: 'application/json; charset=utf-8',
									//data: ,
									dataType: 'text',
									//async: false,
									success: function(data) {
//										alert(data);
										$('.job2').append('<tr ><td >'+data+'</td><td >'+val.work_environment+'</td><td >'+val.date.dd+'/'+val.date.mm+'/'+val.date.yyyy+'</td><td >'+client_name+'</td><td >'+client_ph_no+'</td><td >'+event_loc+'</td><td >'+val.wage+'</td></tr>');
									}
								});
								//$('.job2').append('<tr ><td >'+val.job_id+'</td><td >'+val.job_skill+'</td><td >'+val.work_environment+'</td><td >'+val.date.dd+'/'+val.date.mm+'/'+val.date.yyyy+'</td><td >'+client_name+'</td><td >'+client_ph_no+'</td><td >'+event_loc+'</td><td >'+val.wage+'</td></tr>');
							}
						});
						
						
					}
					
				});
				
				//alert(client_name);
				//$('.job2').append('<tr ><td >'+val.job_id+'</td><td >'+val.job_skill+'</td><td >'+val.work_environment+'</td><td >'+val.date.dd+'/'+val.date.mm+'/'+val.date.yyyy+'</td><td >'+client_name+'</td><td >'+client_ph_no+'</td><td >'+val.event_id+'</td><td >'+val.wage+'</td></tr>');
			});
		}
		}	//alert(data);
	});
	}
});