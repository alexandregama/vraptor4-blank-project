$(document).ready(function() {
	$("#zipcode-value").keyup(function() {
		if ($("#zipcode-value").val().length == 8) {
			$.getJSON("zipcode/" + $("#zipcode-value").val(), {}, function(zipcodeJson) {
				$("#zipcode-address").val(zipcodeJson.zipcode.address);
				console.log(zipcodeJson.zipcode.stateAbbreviation);
				if (zipcodeJson.zipcode.stateAbbreviation != "") {
					$('#zipcode-state option[value="' + zipcodeJson.zipcode.stateAbbreviation + '"]').prop('selected', true);
					$('#zipcode-city').html("<option value=" + zipcodeJson.zipcode.id + ">" + zipcodeJson.zipcode.city + "</option>");
					$('#zipcode-neighborhood').val(zipcodeJson.zipcode.neighborhood);
				}
			})
		}
	});
});