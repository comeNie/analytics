define(function(require, exports, module) {
	var rm = {
		rules:{
			uploadFile:{
				required: true,
				extension:"xlsx"
			},
			financingForm:{
				required: true
			},
			lengBalance:{
				required: true
			},
			cashSourceName:{
				required: true
			},
			arriveDate:{
				required: true
			}
			
		},
		messages:{
			uploadFile:{
				required: "请上传文件",
				extension:"只允许上传后缀名为.xlsx的文件！"
			},
			financingForm:{
				required: "请填写融资方式"
			},
			lengBalance:{
				required: "请填写拆借余额"
			},
			cashSourceName:{
				required: "请填写资金来源与运用"
			},
			arriveDate:{
				required: "请选择到期日"
			},
			
		}
	};
	module.exports = rm;
});