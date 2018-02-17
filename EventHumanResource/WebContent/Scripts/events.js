/*function remove(i){
	alert('hahaszdm,fg');
    var index, table = document.getElementById('table');
              table.rows[i].cells[8].onclick = function()
              {
                  var c = confirm("do you want to delete this post?");
                  if(c === true)
                  {
                      index = this.parentElement.rowIndex;
                      table.deleteRow(i+1);
                  }
                  
                  //console.log(index);
              };
              
  }
*/

$(document).ready(function(){
	
	//alert('work');
	var data1=[];
	var data = localStorage.getItem('url');
	//var data1;
	Sdata=JSON.parse(data);
	if(!Sdata)
	{	
		alert("Sorry you are not authorized!! Need to login");
		window.location.replace('login.html');
	}
	else{
		$('<div>'+Sdata.client_name.f_name+' '+Sdata.client_name.l_name+'</div>').appendTo('#prof_name');
	//alert(Sdata.url);
	$.ajax({
		type: 'GET',
		url: Sdata.url + '/events/all',
		contentType: 'application/json; charset=utf-8',
		//data:{} ,
		dataType: 'json',
		//async: false,
		success: function(data) {
			//data1=data;
			//alert('success');
			//alert(data);
			$.each(data,function(key,val){
				//alert(val.event_id);
				data1[key]=val;
				$('.event').append('<tr ><td id="'+key+'">'+val.event_name+'</td><td >'+val.event_type+'</td><td >'+val.event_date.dd+'/'+val.event_date.mm+'/'+val.event_date.yyyy+'</td><td >'+val.event_location+'</td><td >'+val.event_quote+'</td><td >'+val.event_status+'</td><td  class="remove" value="'+key+'">remove</td></tr>');
				/*
				$('#'+key+' .id').html(val.sample);
				$('#'+key+' .domain').html(val.sample);
				$('#'+key+' .disc').html(val.sample);
				$('#'+key+' .mode').html(val.sample);
				$('#'+key+' .event_date').html(val.sample);
				$('#'+key+' .event_name').html(val.sample);
				$('#'+key+' .contact').html(val.sample);
				$('#'+key+' .add').html(val.sample);
				$('#'+key+' .pay').html(val.sample);
				//$('#'+key).attr(.id).html(val.sample);*/
			});
		}
			//alert(data);
	});
	var button
	/*$('.remove').click(function(){
		var button = $(this).attr('value');
	});*/
	
	
	$('.event').on('click','.remove',function(){
		//alert('lol');
		var id = $(this).attr('value');
		
		//alert(data1[id].event_id);
		
		$.ajax({			
			type: 'DELETE',
			url: Sdata.url+'/events/'+data1[id].event_id+'/delete',	
			//contentType: 'application/json; charset=utf-8',
			//data: ,
			dataType: 'text',
			//async: false,
			success: function(data) {
				alert(data);
				window.location.replace('http://localhost:8080/EventHumanResource/Employer_events.html');
			}
		});
		//remove(id);
	
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
	/*
	$.ajax({
		type: 'GET',
		url: Sdata.url,
		contentType: 'application/json; charset=utf-8',
		//data: ,
		dataType: 'json',
		//async: false,
		success: function(data) {
			//data1=data;
			$.each(data,function(key,val){
				$('#'+key+' .id').html(val.sample);
				$('#'+key+' .domain').html(val.sample);
				$('#'+key+' .disc').html(val.sample);
				$('#'+key+' .mode').html(val.sample);
				$('#'+key+' .event_date').html(val.sample);
				$('#'+key+' .event_name').html(val.sample);
				$('#'+key+' .contact').html(val.sample);
				$('#'+key+' .add').html(val.sample);
				$('#'+key+' .pay').html(val.sample);
				//$('#'+key).attr(.id).html(val.sample);
			});
		}
			//alert(data);*/
	}
});





