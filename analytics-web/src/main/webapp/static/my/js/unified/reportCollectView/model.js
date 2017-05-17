define(function(require, exports, module) {
	var model = Backbone.Model.extend({
		initialize: function() {
			// do nothing
		},
		getReportTemplateById: function(id, callback) {
			$.post($$ctx + "/unified/get/" + id, function(obj) {
				callback(obj);
			});
		},
		getTaskActions: function(nodeId, callback) {
			$.post($$ctx + "/unified/getTaskActions/" + nodeId, function(r) {
				callback(r);
			});
		},
		fetchCommentDetail : function(data,callback){
			$.post($$ctx + "/unified/detail",data).success(function(r) {
				callback(r);
			}).error(function(){bootbox.alert("查看详细失败.请稍后再试");});
		},
		fetchResendComments : function(data,callback){
			$.post($$ctx + "/unified/resendComments",data).success(function(r) {
				callback(r);
			}).error(function(){bootbox.alert("查看详细失败.请稍后再试");});
		},
		auditNext: function(data, callback) {
			$.post($$ctx + "/unified/auditNext",data).success(function(r) {
				callback(r);
			}).error(function(){bootbox.alert("提交失败请稍后重试");});
		},
		resend: function(data, callback) {
			$.post($$ctx + "/unified/resend",data).success(function(r) {
				callback(r);
			}).error(function(){bootbox.alert("提交失败请稍后重试");});
		},
		download: function(fileName){
			$.get($$ctx+"/unified/fileIsExists?fileName=" + fileName,function(r_data){
				if (r_data == "") {
					window.location.href = $$ctx+"/unified/download?fileName="+fileName;
				} else {
					alert(r_data);
				}
			});
		},
		
		
		
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
					bootbox.alert("<span style='font-size:16px;'>保存成功！</span>");
				}
			});
		},
		deleteFunction: function(roleNum) {
			$.post($$ctx + "/roleMng/deleteRoleFunction",{roleId:roleNum},function(result){
				if(result.success == true){
					bootbox.alert("<span style='font-size:16px;'>保存成功！</span>");
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
		},
		downloadReport:function(fileName){
			$.get($$ctx+"/submitDetailQuery/fileIsExists?fileName="+fileName,function(r_data){
				if (r_data == "") {
					window.location.href = $$ctx+"/submitDetailQuery/download?fileName="+fileName;
				} else {
					bootbox.alert({
						buttons:{
							ok:{
								label:"确定"
							}
						},
						message:r_data
					});
				}
			});
		}
	});
	module.exports = model;
});