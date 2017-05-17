define(function(require, exports, module) {
	var rm = {
		rules : {
			filename : {
				required : true,
				extension : "xlsx"
			}
		},
		 messages: {  
             filename: {  
                 required: "请选择上传文件",  
                 extension: "文件格式不支持，请上传 xlsx格式的文件"  
             }  
         }
	};
	module.exports = rm;
});