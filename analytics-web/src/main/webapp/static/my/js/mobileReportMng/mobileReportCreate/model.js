define(function(require, exports, module) {
	var model = Backbone.Model.extend({
		addTemplate:function($form,callback){
			$form.ajaxSubmit(function(r){
				callback(r);
			});
		}
		
	});
	module.exports=model;
})