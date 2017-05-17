define(function(require, exports, module) {
	var rm = {
		rules:{
			/*indexCode: {
				required: true,
			},*/
			indexName: {
				required: true,
			},
			indexMeaning: {
				required: true,
				maxlength: 100
			}
	},
	messages:{
		/*indexCode:{
			required: "指标代码不能为空！",
		},*/
		indexName:{
			required: "指标名称不能为空！",
		},
		indexMeaning:{
			required: "指标含义不能为空！",
			maxlength:"指标含义长度最多是100"
		}
	}
};
	module.exports = rm;
});