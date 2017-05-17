define(function(require, exports, module) {
	var rm = {
		rules:{
			balance:{
				required: true
			},
			profit:{
				required: true
			}
		},
		messages:{
			balance:{
				required: "请输入余额"
			},
			profit:{
				required: "请输入收益"
			}
		}
	};
	module.exports = rm;
});