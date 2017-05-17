define(function(require, exports, module) {
	var rm = {
		rules:{
			no: {
				required: true,
				remote:{//验证模板编号是否存在
					type:"POST",
					url:$$ctx + "/templateMng/validateTemplateNo",
					data:{
						no:function(){
							return $("#no").val();
						},
						id:function(){
							return $("#id").val();
						}
					}
				}
			},
			name: {
				required: true,
				remote:{//验证模板名称是否存在
					type:"POST",
					url:$$ctx + "/templateMng/validateTemplateName",
					data:{
						name:function(){
							return $("#name").val();
						},
						id:function(){
							return $("#id").val();
						}
					}
				}
			},
			timeLimit:{
				required: true,
				digits: true
			},
			submitOrg:{
				required: true
			},
			checkRole:{
				required: true
			},
			startRow:{
				digits: true
			},
			checkRole:{
				required: true
			},
			uploadFile:{
//				required: true,
				extension:"xlsx"
			}
		},
		messages:{
			no:{
				required: "报表编号不能为空！",
				remote:$.validator.format("报表编号已存在！")
			},
			name:{
				required: "模板名称不能为空！",
				remote:$.validator.format("模板名称已存在！")
			},	
			timeLimit:{
				required: "报送时限不能为空！"
			},
			submitOrg:{
				required: "填报机构不能为空！"
			},
			checkRole:{
				required: "查阅角色不能为空！"
			},
			uploadFile:{
				required: "报表模板不能为空！",
				extension:"只允许上传后缀名为.xlsx的文件！"
			}
			
		}
	};
	module.exports = rm;
});