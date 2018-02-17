$(document).ready(function(){
		
	$.ajax({
		type: 'GET',
		url: 'http://localhost:8080/EventHumanResource/rest/default-package',
		//contentType: 'application/json; charset=utf-8',
		//data: ,
		dataType: 'json',
		//async: false,
		success: function(data) {
//			data1.push(data);
			$.each(data,function(key,val){
//					data1[key]=val;
				$('#'+key+'quote').append(' '+val.package_quote);
//					des[key]=val.event_desc;
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
	
	
	
	
	$('.button').click(function(){
		alert('You need to login first');
		window.location.replace('login.html');
	});
});