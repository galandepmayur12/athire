/*function checkSignup() {
	//alert("ok fine");
	var fname = document.getElementById("fname").value;
	//alert(fname);
	var lname = document.getElementById("lname").value;
	//var mname = document.getElementById("middlename").value;
	var email = document.getElementById("mail").value;
	//var addline = document.getElementById("addline1").value;
	//var st_name = document.getElementById("street_name").value;
	var city = document.getElementById("city").value;
	//var state = document.getElementById("state").value;
	//var country = document.getElementById("country").value;
	//var zipcode = document.getElementById("zipcode").value;
	//alert(city);
	var dd = document.getElementById("dob_dd").value;
	var mm = document.getElementById("dob_mm").value;
	var yyyy = document.getElementById("dob_yyyy").value;
	var pno = document.getElementById("mob").value;

	if (fname == '' || lname == '' || email == '' || city == '' || dd == '' || mm == '' || yyyy == '' || pno == '') {
		alert("Fill All mendatory fields");
	} else {

		//var fname = document.getElementById("fname").value;
		//var lname = document.getElementById("lname").value;
		//var mname = document.getElementById("middlename").value;
		var email = document.getElementById("mail");
		//var addline = document.getElementById("addline1").value;
			//var st_name = document.getElementById("street_name").value;
		//var city = document.getElementById("city").value;
		//var state = document.getElementById("state").value;
		//var country = document.getElementById("country").value;
		//var zipcode = document.getElementById("zipcode").value;
		var dd = document.getElementById("dob_dd");
		var mm = document.getElementById("dob_mn");
		var yyyy = document.getElementById("dob_yyyy");
		var pno = document.getElementById("mob_no");
		var date = dd + '/' + mm + '/' + yyyy;
		if (getElementById(mail1)=='Email already exists!!' || getElementById(mail1)== 'Invalid Email!!' || getElementById(dd1) == '' || getElementById(mm1)== '' ||getElementById(yyyy1)== '' || pno == '') {
			alert("Fill Valid Information");
		} else {

			document.getElementById("myForm").submit();
		}
	}
}*/
$(document).ready(function(){
//	alert("ready");
	/*
	$("#submit").click(function(){
		var fname = $("#fname").val();
		var lname = $("#lname").val();
		//var mname = $("#middlename").val();
		var email = $("#mail").val();
		//var add1 = $("#addline1").val();
		//var add2 = $("#addline2").val();
		//var add3 = $("#addline3").val();
		var city = $("#city").val();
		//var state = $("#state").val();
		//var zipcode = $("#zipcode").val();
		var dd = $("#dob_dd").val();
		var mm = $("#dob_mn").val();
		var yyyy = $("#dob_yyyy").val();
		//var date = dd + '/' + mm + '/' + yyyy;
		var pno = $("#mob_no").val();
		// Returns successful data submission message when the entered information is stored in database.
		//var dataString = 'fname='+ fname + '&lname='+ lname + '&email1='+ email + '&addline1='+ add1 + '&addline2='+ add2 + '&addline3='+ add3 + '&city='+ email + '&state='+ state + '&zipcode='+ zipcode + '&day='+ dd + '&month='+ mm + '&year='+ yyyy +'&pno='+ pno;
		
		var jsondata = {
			    address:{
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
		        f_name: "mayur",
		        l_name: "galande"
		    },
		    comp_name: "ifsdbh",
		    dob: {
		        dd: 12,
		        mm: 2,
		        yyyy: 1998
		    },
		    email_id: "vikassaini@gmail.com",
		    ph_no: [
		        9762272834,
		        9923301694
		    ]
		};
		
			// AJAX Code To Submit Form.
			$.ajax({
				type: "POST",
				url: "ajaxsubmit",
				data: dataString,
				cache: false,
				success: function(result){
					alert(result);
				}
			});
		return false;
	});*/
	$(".submit").click(function(event){
//		alert($(this).attr('id'));
		//alert();
//		alert("working");
		//var fname1 = $('#fname1').text();
		//var lname1 = $("#lname1").text();
		//var mname = $("#middlename").val();
		var email1 = $("#mail1").text();
		
		//var add1 = $("#add1").text();
		//var add2 = $("#addline2").val();
		//var add3 = $("#addline3").val();
		//var city1 = $("#city1").text();
		//var state = $("#state").val();
		var zip1 = $("#zip1").text();
		var dd1 = $("#dd1").text();
		var mm1 = $("#mm1").text();
		var yyyy1 = $("#yyyy1").text();
		//var pno1 = $("#mob1").text();
		//var comp1 = $("#company1").text();
		var pass_employee = $("#pass11").text();
		var pass_employer = $("#pass12").text();
		
		var fname2 = $('#fname').val();
		var lname2 = $("#lname").val();
//		alert(fname2);
		//var mname = $("#middlename").val();
		var email2 = $("#mail").val();
		var add2 = $("#bio").val();
		//var add2 = $("#addline2").val();
		//var add3 = $("#addline3").val();
		var city2 = $("#city").val();
		//var state = $("#state").val();
		var zip2 = $("#zip").val();
		var dd2 = $("#dob_dd").val();
		var mm2 = $("#dob_mm").val();
		var yyyy2 = $("#dob_yyyy").val();
		var pno2 = $("#mob").val();
		var comp2 = $("#Company").val();
		var pass2_employer = $("#employer_pass").val();
		var pass2_employee = $("#employee_pass").val();
		var valid = false;
			if($('input[type="checkbox"]:checked').length>0){
				//alert('entered');
				valid = true;
		    }
			else{
				valid = false;
				//$('#checkbox').html('plz check at least 1 checkbox');
			}
		
//			var obj = new object();
//			obj.value = 12;
			
		prof= [];
	//	prof.push('{}');
		var prof=[];
		$('input[type="checkbox"]:checked').each(function() {
			//prof.push(' skill_name:' + this.value + '');
			item = {}
	        item ["skill_name"] = this.value;
	       prof.push(item);
		});
		var job = $( "#job option:selected" ).text();
		//alert(email1);
		// Returns successful data submission message when the entered information is stored in database.
		if(email1=='' && dd1=='' && mm1=='' && pass_employee=='' && yyyy1=='' && zip1 == '' &&  !(fname2=='' || lname2=='' || email2=='' || city2=='' || dd2=='' || yyyy2=='' || pno2=='' || zip2 == '' || add2 == '' )){
			//alert('haha');
			if($(this).attr('id')=='employee' && valid==true && pass2_employee!=''){
			// AJAX Code To Submit Form.
//				alert('hela');
				var arr =JSON.stringify({
				    address: {
				        add_line1: add2,
				    
				        city: city2,

				        zipcode: zip2
				    },
				    dob: {
				        dd: dd2,
				        mm: mm2,
				        yyyy: yyyy2
				    },
				    email_id: email2,
				    freeLancer_id: 123,
				    freelancer_name: {
				        f_name: fname2,
				        l_name: lname2
				    },
				    "password": pass2_employee,
				    ph_no: [
				        pno2
				    ],
				    "skills": prof,
	
				    //skills: [{}],
				    work_environment: job
				  
				});
			//alert(arr);
			$.ajax({
				type: 'POST',
				url: 'http://localhost:8080/EventHumanResource/rest/SignUpFreelancer',
				data: arr,
				contentType: 'application/json; charset=utf-8',
				dataType: 'text',
//				async: false,
				success: function(msg) {
//					alert("hoja");
					alert(msg);
					window.location.replace('http://localhost:8080/EventHumanResource/login.html');
					
				},
				error: function (jqXHR, exception) {
					alert("error");
				}
			});
			}else if($(this).attr('id')=='employer' && pass_employer=='' && comp2!='' && pass2_employer!=''){
			// AJAX Code To Submit Form.
//				alert('hela2');
				var arr = JSON.stringify({
				    "address": {
				        "add_line1": add2,
				       
				        "city": city2,
				        "zipcode": zip2
				    },
				    "client_id": 123,
				    "client_name": {
				        "f_name": fname2,
				        "l_name": lname2
			
				    },
				    "comp_name": comp2,
				    "dob": {
				        "dd":dd2,
				        "mm": mm2,
				        "yyyy": yyyy2
				    },
				    "email_id": email2,
				    "password":pass2_employer,
				    "ph_no": [
				        pno2
				        
				    ]
				});
//				alert(arr);
				$.ajax({
					type: 'POST',
					url: 'http://localhost:8080/EventHumanResource/rest/SignUpClient',
					data: arr,
					contentType: 'application/json; charset=utf-8',
					dataType: 'text',
					async: false,
					success: function(msg) {
						alert(msg);
						window.location.replace('http://localhost:8080/EventHumanResource/login.html');

					}
				});
			}else{
				alert('Plz fill all valid information');
			}
			
		}else{
			alert('Plz fill all valid information');
		}			
		return false;
	});
});

function validate(field, query, var_name) {
	var xmlhttp;
	mail = document.getElementById('mail');
	if (window.XMLHttpRequest) { 
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("GET", "http://localhost:8080/EventHumanResource/rest/validate?" + var_name + "=" + query, true);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState != 4 && xmlhttp.status == 200) {
			document.getElementById(field).innerHTML = "Validating..";
		} else if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			//alert("asdjk");
			document.getElementById(field).innerHTML = xmlhttp.responseText;
		} else {
			document.getElementById(field).innerHTML = "Error Occurred.";
		}
	};
	xmlhttp.send(null);
	
} 







/*
function validate() {
	var xmlhttp;
	if (window.XMLHttpRequest) { 
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("GET", "http://localhost:8080/EventHumanResource/validate?email_id=jsdA", true);
	xmlhttp.onreadystatechange = function() {
		var email_id = document.getElementById('email_id');
		if (xmlhttp.readyState != 4 && xmlhttp.status == 200) {
			document.getElementById(field).innerHTML = "Validating..";
		} else if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById(field).innerHTML = "";
		} else if(xmlhttp.readyState == 1){
			email.innerHTML += "status 1:</br>";
		}else if(xmlhttp.readyState == 2){
			email.innerHTML += "status 2:</br>";
		}else if(xmlhttp.readyState == 3){
			email.innerHTML += "processing 3:</br>";
		} else {
			document.getElementById(field).innerHTML = "Error Occurred.";
		}
	};
	xmlhttp.send(null);
	
} */