define(function(require, exports, module) {
	var model = require("./model");
	var rm = require("./rm");
	var view = Backbone.View.extend({
		el: "div.ajax-content",
		initialize:function(){
			this.model=new model();
		},
		events:{
			"click button[role='uploadExcel']":"uploadExcel",//上传文件
		},
		render:function(){
			this.initForm();//表单校验
		},
		initForm: function() {
			$("#reportForm").validate({
				rules: rm.rules,
				messages: rm.messages
			});
			$("#user-form").validate({
				rules: rm.rules,
				messages: rm.messages
			});
			$("#add-form").validate({
				rules: rm.rules,
				messages: rm.messages
			});
		}
	});
	module.exports = view;
});