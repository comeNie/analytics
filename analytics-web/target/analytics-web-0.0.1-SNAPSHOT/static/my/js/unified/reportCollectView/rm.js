define(function(require, exports, module) {
	var rm = {
		rules:{
			name: {
				required: true,
				remote:{//验证角色名称是否存在
					type:"POST",
					url:$$ctx + "/roleMng/validateRoleName",
					data:{
						name:function(){
							return $("#name").val();
						},
						flag:function(){
							return $("#flag").val();
						}
					}
				}
			}
	},
	messages:{
		name:{
			required: "角色名称不能为空！",
			remote:$.validator.format("角色名称已存在！")
		}
	}
};
	module.exports = rm;
});