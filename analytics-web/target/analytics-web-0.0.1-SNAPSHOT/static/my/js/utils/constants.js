define(function(require, exports, module) {
	var acHost = "http://localhost:8080";
	var portalHost = "http://localhost:8080";
	
	var constants = {
		acLogoutUrl: acHost + "/ac/logout",
		portalLoginUrl: portalHost + "/portal"
	};
	
	module.exports = constants;
});