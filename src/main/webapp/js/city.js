$(document).ready(function() {
	inputState = "#zipcode-state";
	inputCity = "#zipcode-city"

	$(inputState).change(function() {
		findByState(inputState, inputCity);
	});

	function findByState(state, city) {
		$.getJSON("city/" + $(state).val(), function(json) {
			$(city).html("");
			for(i = 0; i < json.length; i++) {
				$(city).append("<option value=" + json[i].id + ">" + json[i].name + "</option>");
			}
		})
	}
});