$(document).ready(function() {
	$("#inspect-button").click(function() {
		if ($("#inspect-tutorial").hasClass("hidden")) {
			$("#inspect-tutorial").slideDown(400, function() {
				$("#inspect-tutorial").removeClass("hidden");
				$("#inspect-button").html("Hide Your Knowledge");
			});
			$("#inspect-tutorial").addClass("active");
		} else {
			$("#inspect-tutorial").slideUp(400, function() {
				$("#inspect-tutorial").removeClass("active");
				$("#inspect-button").html("Boost Your Knowledge");
			});
			$("#inspect-tutorial").addClass("hidden");
		}
	});
});