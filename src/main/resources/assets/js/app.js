$(":button").click(function() {
	var isbn = this.id;
	var status = $(this).val();
	alert('About to report lost on ISBN ' + isbn);
	document.getElementById(isbn).disabled = true;
	$.ajax({
		url : "/library/v1/books/" + isbn + "?status=lost",
		type : 'PUT',
		dataType : 'json',
		success : function(result) {
			document.getElementById(isbn).disabled = true;
			if (status == "available") {

				//location.reload();  
				document.getElementById(isbn).disabled = true;
				document.getElementById('1').innerHTML = "Hii";

			}

		}
	});
	document.getElementById(isbn).disabled = true;
});
