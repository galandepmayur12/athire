
$(document).ready(function(){
	alert('working');
	//var valid = true;
$('#fname').on('input', function() {
	var input=$(this);
	var is_name=input.val();
	if(is_name){
	//	valid = true;
		$('#fname1').html('');
	}
	else{
	//	valid = false;
		$('#fname1').html('Plz Enter first name');
		//input.removeClass("valid").addClass("invalid");
	}
});

$('#lname').on('input', function() {
	var input=$(this);
	var is_name=input.val();
	if(is_name){
		//valid = true;
		$('#lname1').html('');
	}
	else{
		//valid = false;
		$('#lname1').html('Plz Enter last name');
		//input.removeClass("valid").addClass("invalid");
	}
});

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

$('#dob_dd').on('input', function() {
	var input=$(this);
	var name=input.val();
	if(name){
		if($.isNumeric(name) && name<32){
			//valid = true;
			$('#dd1').html('');
		}
		else	{
			//valid = false;
			$('#dd1').html('Plz Enter valid day');
		}
	}
	else{
		//valid = false;
		$('#dd1').html('Plz Enter day');
	}
});

$('#dob_mm').on('input', function() {
	var input=$(this);
	var name=input.val();
	if(name){
		if($.isNumeric(name) && name<13){
			//valid = true;
			$('#mm1').html('');
		}
		else	{
			//valid = false;
			$('#mm1').html('Plz Enter valid month');
		}
	}
	else{
		//valid = false;
		$('#mm1').html('Plz Enter month');
	}
});

$('#dob_yyyy').on('input', function() {
	var input=$(this);
	var name=input.val();
	if(name){
		if($.isNumeric(name) && name<2002){
			//valid = true;
			$('#yyyy1').html('');
		}
		else	{
			//valid = false;
			$('#yyyy1').html('Plz Enter valid year(only before 2002)');
		}
	}
	else{
		//valid = false;
		$('#yyyy1').html('Plz Enter year');
	}
});

$('#city').on('input', function() {
	var input=$(this);
	var is_name=input.val();
	if(is_name){
		//valid = true;
		$('#city1').html('');
	}
	else{
		//valid = false;
		$('#city1').html('Plz Enter city');
	}
});

$('#mob').on('input', function() {
	var input=$(this);
	var name=input.val();
	if(name){
		if($.isNumeric(name) && name.length>9){
		//	valid = true;
			$('#mob1').html('');
		}
		else	{
		//	valid = false;
			$('#mob1').html('Plz Enter valid mob no.');
		}
	}
	else{
		//valid = false;
		$('#mob1').html('Plz Enter mob no.');
	}
});

$('input[type="checkbox"]').click(function(){
	if($('input[type="checkbox"]:checked').length>0){
		//alert('entered');
		//valid = true;
    }
	else{
		//valid = false;
		$('#checkbox').html('plz check at least 1 checkbox');
	}
 });

$(".submit").click(function(event){
		alert("working again");
		var fname1 = $('#fname1').text();
		var lname1 = $("#lname1").text();
		//var mname = $("#middlename").val();
		var email1 = $("#mail1").text();
		//var add1 = $("#addline1").text();
		//var add2 = $("#addline2").val();
		//var add3 = $("#addline3").val();
		var city1 = $("#city1").text();
		//var state = $("#state").val();
		//var zipcode = $("#zipcode").val();
		var dd1 = $("#dd1").text();
		var mm1 = $("#mm1").text();
		var yyyy1 = $("#yyyy1").text();
		var pno1 = $("#mob1").text();
		
		var fname2 = $('#fname').val();
		var lname2 = $("#lname").val();
		//var mname = $("#middlename").val();
		var email2 = $("#mail").val();
		//var add1 = $("#addline1").text();
		//var add2 = $("#addline2").val();
		//var add3 = $("#addline3").val();
		var city2 = $("#city").val();
		//var state = $("#state").val();
		//var zipcode = $("#zipcode").val();
		var dd2 = $("#dd").val();
		var mm2 = $("#mm").val();
		var yyyy2 = $("#yyyy").val();
		var pno2 = $("#mob").val();
		// Returns successful data submission message when the entered information is stored in database.
		if(/*fname1=='' && lname1=='' && email1=='' && city1=='' && dd1=='' && yyyy1=='' && pno1=='' && fname2=='' && lname2=='' && email2=='' && city2=='' && dd2=='' && yyyy2=='' && pno2==''*/true){
			// AJAX Code To Submit Form.
			//alert("smart mayur");
/*			var arr = {
    "address": {
        "add_line1": "flat no 103",
        "add_line2": "suyash apartments",
        "city": "behind vedbhavan,kothrud",
        "country": "INDIA",
        "state": "mahatrashtra",
        "street_name": "pune",
        "zipcode": 411138
    },
    "client_id": 123,
    "client_name": {
        "f_name": "fas",
        "l_name": "D",
        "m_name": "ASDn"
    },
    "comp_name": "null",
    "dob": {
        "dd": 12,
        "mm": 2,
        "yyyy": 1998
    },
    "email_id": "hi@gmail.com",
    "ph_no": [
        9762272834,
        9923301694
    ]
};*/
			$.ajax({
				type: 'POST',
				url: 'http://localhost:8080/EventHumanResource/rest/SignUpClient',
				data: JSON.stringify({
    address: {
        add_line1: "flat no 103",
        add_line2: "suyash apartments",
        city: "behind vedbhavan,kothrud",
        country: "INDIA",
        state: "mahatrashtra",
        street_name: "pune",
        zipcode: 411138
    },
    client_id: 123,
    client_name: {
        f_name: "sarth",
        l_name: "patil"
    },
    comp_name: "ifsdbh",
    dob: {
        dd: 12,
        mm: 2,
        yyyy: 1998
    },
    email_id: "vikassfi@gmail.com",
    ph_no: [
        9762272834,
        9923301694
    ]
}),
				contentType: 'application/json'/*; charSet=UTF-8'*/,
				dataType: 'text',
				/*headers: {
                'Access-Control-Allow-Origin':  'http://localhost'
				},*/
                crossDomain: true,
				//async: false,
				success: function(msg) {
						alert("it should work");
						alert(msg);
						alert(msg);
				}
				
			});
		
		}
		else{
			alert('Plz fill all valid information');
		}			
		return false;
	});
});
