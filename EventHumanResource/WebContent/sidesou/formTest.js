$(document).ready(function(){
	alert("working");
	$("#submit").click(function(event){
		$.ajax({
			type: 'GET',
			url: "http://localhost:8080/EventHumanResource/rest/user/123/client/",
			dataType: 'json',
			//async: false,
			success: function(result){
				alert(result);
				//$.each(result,function(i,item){
				//	item
				//})
			}
		});
	});
});