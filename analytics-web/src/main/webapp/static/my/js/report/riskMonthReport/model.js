define(function(require, exports, module) {
	var model = Backbone.Model.extend({
		initialize: function() {
			// do nothing
		},
		downloadFile:function(url){
			window.location.href=url;
		}
	});
	module.exports=model;
})