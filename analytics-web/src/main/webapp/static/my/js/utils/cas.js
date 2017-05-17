define(function(require, exports, module) {
	var constants = require("./constants");
	
	var cas = {
		singleSignOut: function() {
			$.get(constants.acLogoutUrl, function() {
				window.location.href = constants.portalLoginUrl;
			});
		}
	};
	
	module.exports = cas;
});