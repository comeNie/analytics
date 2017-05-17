define(function(require, exports, module) {
	var model = Backbone.Model.extend({
		
		addRole:function($form,callback){
			$form.ajaxSubmit(function(r){
				callback(r);
			});
		},
		modifyRole:function($form,callback){
			$form.ajaxSubmit(function(r){
				callback(r);
			});
		},
		saveFunction: function(roleNum,id) {
			$.post($$ctx + "/roleMng/saveRoleFunction",{roleId:roleNum,functionId:id},function(result){
				if(result.success == true){
					bootbox.alert({
						buttons:{
							ok:{
								label:"确定"
							}
						},
						message:"<span style='font-size:16px;'>保存成功！</span>"
					});
				}
			});
		},
		deleteFunction: function(roleNum) {
			$.post($$ctx + "/roleMng/deleteRoleFunction",{roleId:roleNum},function(result){
				if(result.success == true){
					bootbox.alert({
						buttons:{
							ok:{
								label:"确定"
							}
						},
						message:"<span style='font-size:16px;'>保存成功！</span>"
					});
				}
			});
		},
		
		
		
		
		saveDashboardFunction: function(roleNum,id) {
			$.post($$ctx + "/roleMng/saveDashboardRoleFunction",{roleId:roleNum,functionId:id},function(result){
				
			});
		},
		deleteDashboardFunction: function(roleNum) {
			$.post($$ctx + "/roleMng/deleteDashboardRoleFunction",{roleId:roleNum},function(result){
				
			});
		}
		
		
		
		
		
	});
	module.exports=model;
})