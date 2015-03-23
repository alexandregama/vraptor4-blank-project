$(document).ready(function() {
	$("#zipcode-value").keyup(function() {
		if ($("#zipcode-value").val().length == 8) {
			$.getJSON("zipcode/" + $("#zipcode-value").val(), {}, function(zipcodeJson) {
				console.log(zipcodeJson);
				console.log(zipcodeJson.zipcode.address);
				$("#zipcode-address").val(zipcodeJson.zipcode.address);
			})
		}
	});
});