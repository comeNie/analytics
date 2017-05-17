define(function(require, exports, module) {
	var rm = {
		rules:{
			type:{
				required: true
			},
			theDate:{
				required: true
			},
			name:{
				required: true
			},
			uploadFile:{
				required: true,
			}
			
		},
		messages:{
			type:{
				required: "请选择业务类型"
			},
			theDate:{
				required: "请选择事件时间"
			},
			name:{
				required: "请输入事件名称"
			},
			uploadFile:{
				required: "请选择文件",
			}
			
		}
	};
	module.exports = rm;
});