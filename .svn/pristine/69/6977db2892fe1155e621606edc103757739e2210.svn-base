define(function(require, exports, module) {
	var model = require("./model");
	var rm = require("./rm");
	var view = Backbone.View.extend({
		el: "div.aajax-content",
		initialize:function(){
			this.model=new model();
		},
		events:{
			"click #save" : "save",
			"change #reportName" : "showTenDays"
		},
		render:function(){
			this.initForm();//表单校验
		},
		showTenDays:function(){
			var reportName = $("#reportName").val();
			if(reportName == 3){
				$("#tenDays").attr("disabled",false);
			}else{
				$("#tenDays").attr("disabled","disabled");
			}
			
		},
		initForm: function() {
			$("#reportForm").validate({
				rules: rm.rules,
				messages: rm.messages
			});
		},
		save:function(){
			var viewSelf = this;
			var name = $("#reportName").val();
			if($("#reportForm").valid()) {
				$("#reportForm").ajaxSubmit(function(r){//ajaxSubmit()方法：需要controller中对应方法的参数名与表单中name属性值相同
					bootbox.alert("保存成功!",function(){
        				history.go(-1);
        			});
				});
	        }
		}
	});
	module.exports = view;
});