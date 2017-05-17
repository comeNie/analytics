define(function(require, exports, module) {
	var model = Backbone.Model.extend({
		initialize: function() {
			
		},
		createReport:function(data,callback){
			$.post($$ctx+'/bizReport/createReport',data,function(r_data){
				callback(r_data);
			});
		},
		downloadFile:function(url){
			window.location.href=url;
		}
	});
	module.exports=model;
})