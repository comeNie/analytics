define(function(require, exports, module) {
	var model = require("./model");
	var rm = require("./rm");
	var view = Backbone.View.extend({
		el: "div.ajax-content",
		initialize:function(){
			this.model=new model();
		},
		events:{
			"click button[role='save']":"save",//保存
		},
		render:function(){
			this.initForm();//表单校验
		},
		save:function(){
			var viewSelf = this;
//			if($("form").valid()){
			if(true){
				var cellValues = [];
				$(".table").find("tr").each(function(){
					var tdArr = $(this).children();
					var itemId = tdArr.eq(0).text();
					var itemName = tdArr.eq(1).text();
					var balance = tdArr.eq(2).find("input").val();
					if(balance=="" || balance==null){
						balance = "no";
					}
					var profit = tdArr.eq(3).find("input").val();
					if(profit=="" || profit==null){
						profit = "no";
					}
					cellValues.push(itemId+","+itemName+","+balance+","+profit);
					
				});
				cellValues.shift();//删除第一个元素
				console.log(cellValues);
				$.ajax({
					type:'POST',
					url:$$ctx + "/fillFormItem/save",
					data:{
						cellValues:cellValues,
						fillDate:$("#fillDate").val(),
						memo:$("#memo").val()
					},
					success:function(result){
						bootbox.alert(result);
					}
				});
				
				
				
				
			}
		},
		initForm: function() {
			$("#form").validate({
				rules: rm.rules,
				messages: rm.messages,
				errorPlacement:function(error,element){
					error.appendTo(element.parent());//把错误信息放在验证的元素后面。
				}
			});
		}
	});
	module.exports = view;
});