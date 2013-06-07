/**
 * @namespace Root namespace of the PageExitWarningBehavior.
 */
var PageExitWarningBehavior = PageExitWarningBehavior || {};

/**
 * Activates the page exit warning for the current page.
 */
PageExitWarningBehavior.activateWarning = function() {
	console.log("activating PageExit Warning!");
	window.onbeforeunload = function(e) {
		var message = "Do you really want to leave this page?";
		var e = e || window.event;
		if (e) {
			e.returnValue = message;
		}
		return message;
	}
}