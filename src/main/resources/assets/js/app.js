$("#btn_Submit").click(function() {
    //var isbn = this.id;
	var user= $("#username").val();
	var pass=$("#password").val();
    $.ajax({
    url: "/v1/users/login",
    type: 'POST',
    async: 'false',
    data:'username='+user+'&password='+pass,
    contentType: 'application/x-www-form-urlencoded',
    success: function(response) {
    	//alert(response.username);
    	$('#usrnm').text(response.username);
    	$('#deptnm').text(response.department);
    	//alert("hell"+$('#usrnm').text()+"HELL"+$('#deptnm').text());
    	

    $("#Admin").show();
	 $("#login").hide();
	 if(location.port==9001)

	 {

	 $("#delete").hide();

	 }
	 
	fireWater();
	 fireWater2();
	 //storeListener();
	 
    },
    error: function(data,status,er){
    	    	
    	alert("You are Invalid User!!!Please enter Correct Credentials");
    	console.log("error ", data.error+""+status)}
    	
    });
});
$("#btn_Send").click(function() {
    $.ajax({
    url: "/v1/users/storeEmail",
    type: 'GET',
    async: 'false',
    contentType: 'application/json',
    success: function(response) {
    	 
    },
    error: function(data,status,er){
    }
    });
});