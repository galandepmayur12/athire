/*$(document.ready(function(){
 * 
 
	//var Sdata = localStorage.getItem('url');
	//if(Sdata){
	//ata=JASON.parse(Sdata);
	//url=data.url;
	
		$(.button).click(function(){
			var Sdata = localStorage.getItem('url');
			if(!Sdata){
				alert('Login Required');
				/*window.location.replace(/*'<header>
    <h1 class="logo"><a href="#">HRS</a></h1>
    <nav>
        <ul id="menu">
        <li>
          <div class="dropdown">
          	<div class="chip" >
  					<img src="images/avatar.png" alt="Person" width="30" height="30" class="dropbtn" >
  					<!-- <li> <label id = "fname"></label></li>-->
  						<!-- <div id="prof_name"></div>-->
  						<div class="chip" id="prof_name"></div>
						</div>
			   <!-- <button class="dropbtn">Dropdown</button>-->
			    <div class="dropdown-content">
			      <a href="Employer_noti.html" class="button special">Notifications</a>
			      <a href="Employer_profile.html" class="button special">My profile</a>
			      <a href="Employer_prof_update.html" class="button special">profile Update</a>
            <a href="Employer_events.html" class="button special">My events</a>
			      <a href="#" class="button special">logout</a>
			    </div>
  			</div> 
        </li>
    </ul>
    </nav>
</header>');
			}
			else{
				//$('body').prepend();
			}
		});
		$(.submit).click(function(){
			var Sdata = localStorage.getItem('url');
			//if(Sdata){
			var arr = {
				"event_date": {
					"dd": $('#dob_dd').val(),
					"mm": $('#dob_mm').val(),
					"yyyy": $('#dob_yyyy').val()
				},
				"event_desc": $('#des').val(),
				//"event_id": ('#dob_dd').val(),
				"event_location": $('#bio').val()+''+$('#city').val(),
				"event_name": "particul_event",
				//"event_quote": 15000,
				"event_type": "particular",
				"skill_needed": {
					(this).val(): 1
				}
				"user_id": $('#id').val()
			};
			$.ajax({
				type: 'POST',
				url: ''
				data: arr,
				contentType: 'application/json; charset=utf-8',
				dataType: 'text',
				//async: false,
				success: function(msg) {
					alert(msg);
				}
			});
		});
		
});

*/


/*function check(){
	alert("gjkgjk");
	var data='{';
	var i=1;
	for(i=1;i<=11;i++){
		if(!(document.getElementById(i).value=='')){
			//alert(document.getElementById(i).name);
			data=data.concat(document.getElementById(i).name+ ':' +document.getElementById(i).value+',');
		}
	}
	
	data = data.substring(0,data.length - 1);
	data=data.concat('}');
	return data;
}*/



$(document).ready(function(){
	//alert('work4');
	var Sdata = localStorage.getItem('url');
	//if(Sdata){
	var data1 = JSON.parse(Sdata);
	//var data;
	if(!data1)
	{	
		alert("Sorry you are not authorized!! Need to login");
		window.location.replace('login.html');
	}
	else{
	var re = new RegExp("[0-5]");
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
				window.location.assign('http://localhost:8080/EventHumanResource/');
			}
				});
	});
	//var photo = $("#photo").val();
	$(".button").click(function(){
//		alert("hello:"+$('#1').val());
//		alert(re.test($("#1").val()));
//		alert($("#photo").val());
//		alert(re.test($("#photo").val()));
//		alert(re.test($("#1").val()));
		if( $("#1").val()=='0' && $("#2").val()=='0' && $("#3").val()=='0' && $("#4").val()=='0' && $("#5").val()=='0' && $("#6").val()=='0' && $("#7").val()=='0' && $("#8").val()=='0' && $("#9").val()=='0' && $("#10").val()=='0' && $("#11").val()=='0'){  		
			alert("plz hire atleast 1");
			window.location.replace('custom.html');
		}	
		else if($("#1").val()=='' || $("#2").val()=='' || $("#3").val()=='' || $("#4").val()=='' || $("#5").val()=='' || $("#6").val()=='' || $("#7").val()=='' || $("#8").val()=='' || $("#9").val()=='' || $("#10").val()=='' || $("#11").val()==''){
			alert("Can not leave a feild empty");
			window.location.replace('custom.html');
		}
		else if(!(re.test($("#1").val()) && re.test($("#2").val()) && re.test($("#3").val()) && re.test($("#4").val()) && re.test($("#5").val()) && re.test($("#6").val()) && re.test($("#7").val()) && re.test($("#8").val()) && re.test($("#9").val()) && re.test($("#10").val()) && re.test($("#11").val()))){
			alert("Plz Enter between 1 to 5");
			window.location.replace('custom.html');
		}
		else{
			//alert('success');	
		}
		
	});
	
	
	

	$("#dob_dd").on('input',function(){
		//alert('sin');
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

	
	
	/*$(".submit").click(function(){

	
		$(.button).click(function(){
			var Sdata = localStorage.getItem('url');
			if(!Sdata){
				alert('Login Required');
			}
			else{
				//$('body').prepend();
			}
		});*/
	$('.submit').click(function(){
		
		//alert("heelo0");
//		alert(check());
//		var skill_needed=JSON.stringify(check());
//		alert("heelo");

		//		var obj = $.parseHTML(check());
//		//alert(json);
//		
//		alert($('#dob_dd').val());
//		data=JSON.parse(obj);
//		alert("data:"+data);
//		alert("Photographer"+  $('#1').val()+
//				"Anchor" +  $('#2').val())
		if($('#dob_dd').val()=='' || $('#dob_mm').val() =='' || $('#dob_yyyy').val() =='' || $('#des').val() =='' || $('#bio').val() =='' || $('#city').val() =='' || $('#event_name').val() ==''|| $('#date').text() !=''){
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
			"event_desc": $('#des').val(),
			//"event_id": $('#dob_dd').val(),
			"event_location": $('#bio').val()+','+$('#city').val(),
			"event_name": $('#event_name').val(),
			//"event_quote": 15000,
			"event_type": "Custom_event",
			"skill_needed":{
				"Photographer":  $('#1').val(),		
				"Anchor" :  $('#2').val(),
				"Designer":  $('#3').val(),
				"Caterers" :  $('#4').val(),
				"Sound_System" :  $('#5').val(),
				"Promoter" :  $('#6').val(),
				"Volunteer" :  $('#7').val(),
				"Singer" :  $('#8').val(),
				"Event_Organizer" :  $('#9').val(),
				"Choreographer" :  $('#10').val(),
				"Decoraters" :  $('#11').val()		
			}
		});
		/*alert(arr);
		alert(data1.url);*/
		$.ajax({
			type: 'POST',
			url: data1.url+ "/events/createEvent",
			contentType: 'application/json; charset=utf-8',
			data: arr,
			
			dataType: 'text',
			async: false,
			success: function(msg) {
				alert(msg);
				window.location.href('http://localhost:8080/EventHumanResource/Employer_profile.html');
			}
		});
		}
	});
	}
});
