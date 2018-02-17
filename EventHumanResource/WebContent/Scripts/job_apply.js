$(document).ready(function(){
	
	
//	alert('here');
	//$('.job').append('<tr class="0"><td class="id">1</td><td >qwe</td><td >asd</td><td >a</td><td >12</td><td >a</td><td >123</td><td >bio</td><td >800</td><td><button class="button" value="0">Apply</button></td></tr>');
	//$('.job').append('<tr class="sd"><td class="id">sd</td><td >sd</td><td >sd</td><td >sd</td><td >sd</td><td >sd</td><td >sd</td><td >sd</td><td >sd</td><td><button class="button" value="sd">Apply</button></td></tr>');
	var data = localStorage.getItem('url');
	var Sdata = JSON.parse(data);	
	if(!Sdata)
	{	
		alert("Sorry you are not authorized!! Need to login");
		window.location.replace('login.html');
	}
	else{
		var url = data.url;
	var data1=[];
	//var client_name;
	//var client_ph_no = [];
	var event_loc;
	var skill_name;
	//alert(Sdata.freelancer_name.f_name+' '+Sdata.freelancer_name.l_name);
	$('<div>'+Sdata.freelancer_name.f_name+' '+Sdata.freelancer_name.l_name+'</div>').appendTo('#prof_name');
	//$('<div>'+Sdata.freelancer_name.f_name+' '+Sdata.freelancer_name.l_name+'</div>').appendTo('#uname');
	

	
	
	$.ajax({
		type: 'GET',
		url: Sdata.url+"/jobs/job-search",
		contentType: 'application/json; charset=utf-8',
		//data: ,
		dataType: 'json',
		//async: false,
		success: function(data) {
			//alert(data.length);
			if(data.length<1){
				//alert('wow');
				$('.job').append('<td style="text-align:center">No jobs are Available</td>');
			}
			else{
			
			$.each(data,function(key,val){
				
				
				data1.push(val);
				
				//alert("Date:"+val.date.dd+val.date.mm+val.date.yyyy);
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
						var client_name;
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
								
								$('.job').append('<tr class='+key+'><td >'+val.job_title+'</td><td >'+val.job_desc+'</td><td >'+val.work_environment+'</td><td >'+val.date.dd+'/'+val.date.mm+'/'+val.date.yyyy+'</td><td >'+client_name+'</td><td >'+event_loc+'</td><td >'+val.wage+'</td><td><button class="button" value='+key+'>Apply</button></td></tr>');
								
								
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
	
	/* orginal ajax
	
	$.ajax({
		type: 'GET',
		url: Sdata.url+"/jobs/job-search",
		contentType: 'application/json; charset=utf-8',
		//data: ,
		dataType: 'json',
		//async: false,
		success: function(data) {
			$.each(data,function(key,val){
				data1.push(val);
				$('.job').append('<tr class='+key+'><td class="id">'+val.job_id+'</td><td >'+val.job_title+'</td><td >'+val.job_desc+'</td><td >'+val.work_environment+'</td><td >'+val.date.dd+'/'+val.date.mm+'/'+val.date.yyyy+'</td><td >'+val.job_title+'</td><td >'+val.client_id+'</td><td >'+val.event_id+'</td><td >'+val.wage+'</td><td><button class="button" value='+key+'>Apply</button></td></tr>');
				
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
				
			});
		}
			//alert(data);
	});
	

	*/
	/*$(".button").click(function(){	
	$(".button").on("click", "p.test", function(){
		
	}*/
	
	$('.job').on('click','.button', function() {
//		alert('yooo');
//		alert($("."+apply+" .id").text());
		var apply = $(this).val();
		//var job_id=$(apply).val();
		//var arr={
		//	data1[apply];
//		alert(apply);
		$.ajax({
			type: 'POST',
			//+$(".1.id").text()+
			url:Sdata.url + '/jobs/'+data1[apply].job_id+'/apply',
			//contentType: 'application/json; charset=utf-8',
			//data:{},
			dataType: 'text',
			//async: false,
			success: function(data) {
				alert(data);
				window.location.replace("http://localhost:8080/EventHumanResource/Employee_job_search.html");
			}
		});
	});
	
	$('#logout').click(function(){
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
	}
});