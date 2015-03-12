$(document).ready(function() {
	$("#estado").change(function() {
		$.getJSON("city/" + $("#estado").val(), function(json) {
			$("#cidade").html("");
			for(i = 0; i < json.length; i++) {
				console.log(json[i].name);
				$("#cidade").append("<option value=" + json[i].id + ">" + json[i].name + "</option>");
			}
		})
	});
});