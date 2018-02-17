$(document).ready(function(){
	//alert('work');
	/*var arr={
    "event_date": {
        "dd": 8,
        "mm": 10,
        "yyyy": 2017
    },
    "event_desc": "something is going to happen",
    "event_id": 123,
    "event_location": "kothrud",
    "event_name": "particul",
    "event_quote": 15000,
    "event_status": "Active",
    "event_type": "particular",
    "skill_needed": {
        "Anchor": 3,
        "Sound System": 2
    },
    "user_id": 123
};


alert(arr);
alert(arr.skill_needed.Anchor);
	if(arr.skill_needed.des){
		alert('wtf');
	}
	else{
		alert('working');
	}*/
	
	var data = localStorage.getItem('url');
	var Sdata = JSON.parse(data);
//	alert('here');
	var data1=[];
	var des=[];
	var button;
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
	//$('#detail'+'0').append('<li>photo</li>');
	$.ajax({
		type: 'GET',
		url: 'http://localhost:8080/EventHumanResource/rest/default-package',
		//contentType: 'application/json; charset=utf-8',
		//data: ,
		dataType: 'json',
		//async: false,
		success: function(data) {
			data1.push(data);
			$.each(data,function(key,val){
					data1[key]=val;
				$('#'+key+'quote').append(' '+val.package_quote);
					des[key]=val.event_desc;
				if(val.skill_needed.Anchor)
					$('#detail'+key).append('<li><p>'+val.skill_needed.Anchor+' </p>Anchor</li>');
				if(val.skill_needed.Decorators)
					$('#detail'+key).append('<li><p>'+val.skill_needed.Decorators+' </p>Decorators</li>');
				if(val.skill_needed.Sound_System)
					$('#detail'+key).append('<li><p>'+val.skill_needed.Sound_System+' </p>Sound system</li>');
				if(val.skill_needed.Caterers)
					$('#detail'+key).append('<li><p>'+val.skill_needed.Caterers+' </p>Caterers</li>');
				if(val.skill_needed.Designer)
					$('#detail'+key).append('<li><p>'+val.skill_needed.Designer+' </p>Designer</li>');
				if(val.skill_needed.Photographer)
					$('#detail'+key).append('<li><p>'+val.skill_needed.Photographer+' </p>Photographer</li>');
				if(val.skill_needed.Promoter)
					$('#detail'+key).append('<li><p>'+val.skill_needed.Promoter+' </p>Promoter</li>');
				if(val.skill_needed.Volunteer)
					$('#detail'+key).append('<li><p>'+val.skill_needed.Volunteer+' </p>Volunteer</li>');
				if(val.skill_needed.Event_Organizer)
					$('#detail'+key).append('<li><p>'+val.skill_needed.Event_Organizer+' </p>Security</li>');
				if(val.skill_needed.Choreographer)
					$('#detail'+key).append('<li><p>'+val.skill_needed.Choreographer+' </p>Security</li>');
				if(val.skill_needed.Singer)
					$('#detail'+key).append('<li><p>'+val.skill_needed.Singer+' </p>Security</li>');
				//$('#'+key).attr(.id).html(val.sample);
			});
		}
			//alert(data);
	});
	$(".button").click(function(){
		button = $(this).val();
//		alert(button);
	});
	
	
	
	$("#dob_dd").on('input',function(){
	//	alert('sin');
		if($('#dob_dd').val()>31 || !($.isNumeric($('#dob_dd').val()))){
			$('#date').html('Plz enter valid day');
		}else
			$('#date').html('');
	});

	$("#dob_mm").on('input',function(){
		if($('#dob_mm').val()>12 || !($.isNumeric($('#dob_mm').val())))
			$('#date').html('Plz enter valid month');
		else
			$('#date').html('');
	});

	$("#dob_yyyy").on('input',function(){
		if($('#dob_yyyy').val()<2017 || !($.isNumeric($('#dob_yyyy').val())))
			$('#date').html('Plz enter valid year');
		else
			$('#date').html('');
	});

	
	
	
	$(".submit").click(function(){
//		alert("working");
//		alert(des[button]);
		var json = data1[button].skill_needed;
//		alert(json);
//		alert($('#'+button+'name').text());
//		alert($('#bio').val()+', '+$('#city').val());
//		alert($('#'+button+'name').text());
//		alert(('#'+button+'quote').text());
//		alert($('#'+button+'name').text());

//		alert(arr);
		if($('#dob_dd').val()=='' || $('#dob_mm').val() =='' || $('#dob_yyyy').val() =='' || $('#bio').val() =='' || $('#city').val() =='' || $('#date').text() !=''){
			alert('Plz enter all valid information');
		}
		else
		{
		var arr = JSON.stringify({
			"event_date": {
				"dd": $('#dob_dd').val(),
				"mm": $('#dob_mm').val(),
				"yyyy": $('#dob_yyyy').val()
			},
			"event_desc": des[button],
			//"event_id": ('#dob_dd').val(),
			"event_location": $('#bio').val()+', '+$('#city').val(),
			"event_name": $('#'+button+'name').text(),
			//"event_quote": $('#'+button+'quote').text(),
			"event_type": "Default",
			"skill_needed": data1[button].skill_needed,
			//"user_id": Sdata.client_id
		});
		
		
//		var arr =JSON.stringify({
//		    "event_date": {
//		        "dd": 19,
//		        "mm": 10,
//		        "yyyy": 2017
//		    },
//		    "event_desc": "a",
//		    "event_id": 123,
//		    "event_location": "kothrud",
//		    "event_name": "particul",
//		    "event_quote": 15000,
//		    "event_status": "Completed",
//		    "event_type": "particular",
//		    "skill_needed": {
//		        "Anchor": "3",
//		        "Sound_System": "2"
//		    },
//		    "user_id": 123
//		});
		$.ajax({
			type: 'POST',
			url: Sdata.url+"/events/createEvent",
			//url: 'http://localhost:8080/EventHumanResource/rest/user/123/client/events/createEvent',
			data: arr,
			contentType: 'application/json; charset=utf-8',
			dataType: 'text',
			async: false,
			success: function(msg) {
				alert(msg);
				window.location.replace('http://localhost:8080/EventHumanResource/Employer_profile.html');
			}
		});
		}
	});
});
