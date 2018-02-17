/**
 * 
 */

$(document).ready(function(){
	//alert('yooo');
	$("#mail").prop("readonly", true);
//		alert("working");
		var Sdata = localStorage.getItem('url');
		var data = JSON.parse(Sdata);
//		alert(data.url);
		if(!data)
		{
			alert('You should login before access this page');
			window.location.replace('login.html');
		}
		else{
		$.ajax({
			type: 'GET',
			url: data.url,
			contentType: 'application/json; charset=utf-8',
			data:{},
			dataType: 'json',
			//async: false,
			success: function(data) {
					var skill = [];
//					alert(data.skills);
					$.each(data.skills,function(key,val){
						skill.push(val.skill_name);
//						alert(val.skill_name);
					});
//					alert(data.email_id);
//					alert(data.client_name.f_name);
					//alert(data.ph_no[0]);
					$('#fname').val(data.freelancer_name.f_name);
					$('#lname').val(data.freelancer_name.l_name);
					$('<div>'+data.freelancer_name.f_name+' '+data.freelancer_name.l_name+'</div>').appendTo('#prof_name');
					$('<div>'+data.freelancer_name.f_name+' '+data.freelancer_name.l_name+'</div>').appendTo('#uname');
					$('#mob').val(data.ph_no[0]);
					$('#mail').val(data.email_id);
					$('#dob_dd').val(data.dob.dd);
					$('#dob_mm').val(data.dob.mm);
					$('#dob_yyyy').val(data.dob.yyyy);
					$('#city').val(data.address.city);
					$('#bio').val(data.address.add_line1);
					$('#zip').val(data.address.zipcode);
					//$('#Company').val(data.comp_name);
					$.each(skill,function(key,val){
//						alert("if ka"+val);
						if(val==="Photographer"){
//							alert('am in');
							$(".Photographer").prop('checked', true);
						}else if(val==="Choreographer"){
							
							$(".Choreographer").prop('checked', true);
						}else if(val==="Anchor"){
//							alert('am in Anchor');
							$(".Anchor").prop('checked', true);
						}else if(val==="Designer"){
							$(".Designer").prop('checked', true);
						}else if(val==="Volunteer"){
							$(".Volunteer").prop('checked', true);
						}else if(val==="Promoter"){
							$(".Promoter").prop("checked",true);
						}else if(val=="Caterers"){
							$(".Caterers").prop("checked",true);
						}else if(val==="Event_Organizer"){
//							alert("hii");
							$(".Event_Organizer").prop("checked",true);
						}else if(val==="Sound_System"){
							$(".Sound_System").prop("checked",true);
						}else{
							$(".Singer").prop("checked",true);
						}
						
						//skill.push(val.skill_name);
						//alert(val.skill_name);
					});
					if(data.work_environment=="Individually"){
						$("#job").val("Individually");
					}else if(data.work_environment=="In team"){
						$("#job").val("team");
					}else{
						$("#job").val("both");
					}
					//$('#employee_pass').val('********');
					//alert(data.eventDate);
				}
				//alert(data);
			
		});
		
		
		
		
		$('#logout').click(function(){
//			alert("zindabad" + data.url + "/logout");
			$.ajax({
				type: 'GET',
				url: data.url + '/logout',
//				data : "",
				contentType: 'text/plain',
				dataType: 'text',
//				async: false,
				success: function(data) {
					//alert(data);
					localStorage.clear('url');
					window.location.replace('http://localhost:8080/EventHumanResource/');
				}
					});
		});

	
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
			
//			alert($(this).attr('id'));
			//alert();
//			alert("working");
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
			//var pass_employee = $("#pass11").text();
			//var pass_employer = $("#pass12").text();
			
			var fname2 = $('#fname').val();
			var lname2 = $("#lname").val();
//			alert(fname2);
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
			//var pass2_employer = $("#employer_pass").val();
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
			if(email1=='' && dd1=='' && mm1=='' /*&& pass_employee==''*/ && yyyy1=='' && zip1 == '' &&  !(fname2=='' || lname2=='' || email2=='' || city2=='' || dd2=='' || yyyy2=='' || pno2=='' || zip2 == '' || add2 == ''|| prof=='')){
				
				// AJAX Code To Submit Form.
					
				// AJAX Code To Submit Form.
//					alert('hela2');
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
					    //"password": pass2_employee,
					    ph_no: [
					        pno2]
					    ,
					    skills: prof,
		
					    //skills: [{}],
					    work_environment: job
					  
					});
					//alert(arr);
					$.ajax({
						type: 'PUT',
						url: data.url + "/update-profile",
						data: arr,
						contentType: 'application/json; charset=utf-8',
						dataType: 'text',
						async: false,
						success: function(msg) {
							alert(msg);
							window.location.replace('http://localhost:8080/EventHumanResource/Employee_prof_update.html');

						}
					});
			}else{
				alert('Plz fill all valid information');
			}			
			return false;
		});
//		
//		$('#employee_pass').click(function(){
//			alert('check1');
//			window.location.replace('http://localhost:8080/EventHumanResource/changePass.html');
//		});
		
		$('#mail').on('input', function() {
			var input=$(this);
//			alert("hi");
			var name=input.val();
			var re = "/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/";
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
		}
	});

	function validate(field, query, var_name) {
		var xmlhttp;
		//alert(query);
		//mail = document.getElementById('mail');
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
				//alert(xmlhttp.readyState + " " + xmlhttp.status);
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
		
		
	//alert("yolo");
/*		
$('#submit').click(function() {
	//alert("entering");
	/*
	$.ajax({
		type: 'PUT',
		url: 'http://localhost:8080/EventHumanResource/rest/user/123/client/update-profile',
		data: {"address": { "add_line1": "smq 605/5","add_line2": "airforce station vimanagar","city": "Pune",        "country": "INDIA",
        "state": "Mahatrashtra",
        "street_name": "airfoce school",
        "zipcode": 411014
    },
    "client_id": 123,
    "client_name": {
        "f_name": "Mayur",
        "l_name": "Galande",
        "m_name": "Pravin"
    },
    "comp_name": "null",
    "dob": {
        "dd": 12,
        "mm": 2,
        "yyyy": 1998
    },
    "email_id": "galandepmayur@gmail.com",
    "ph_no": [
        9762272834,
        9923301694
    ]
},
	contentType:"application/json",
	dataType:"json",
		success: function() {
				alert("working");
			}
		});	
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
	alert(arr);
	$.ajax({
		type: 'POST',
		url: 'http://localhost:8080/EventHumanResource/rest/SignUpClient',
		data: arr,
		contentType: 'application/json; charset=utf-8',
		dataType: 'text',
		async: false,
		success: function(msg) {
			alert(msg);
			window.location.replace('http://localhost:8080/EventHumanResource/Employer_prof_update.html');

		}
	});
//	$.ajax({
//        type: 'PUT',
//        contentType: 'application/json',
//        url: 'http://localhost:8080/EventHumanResource/rest/user/123/client/update-profile',
//        dataType: "json",
//        data:JSON.stringify( {   "address": {"add_line1": "kothrud", "add_line2": "airforce station vimanagar","city": "Pune",
//            "country": "INDIA",
//            "state": "Mahatrashtra",
//            "street_name": "airfoce school",
//            "zipcode": 411015
//        },
//        "client_id": 123,
//        "client_name": {
//            "f_name": "Mayur",
//            "l_name": "Galande",
//            "m_name": "Pravin"
//        },
//        "comp_name": "null",
//        "dob": {
//            "dd": 12,
//            "mm": 2,
//            "yyyy": 1998
//        },
//        "email_id": "galandepmayur@gmail.com",
//        "ph_no": [
//            9762272834,
//            9923301694
//        ]
//    }),
//        success: function(data, textStatus, jqXHR){
//            alert('Wine updated successfully');
//        },
//        error: function(jqXHR, textStatus, errorThrown){
//            alert(errorThrown);
//        }
//    });
});*/

