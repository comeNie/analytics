define(function(require, exports, module) {
	var model = require("./model");
	var rm = require("./rm");
	var view = Backbone.View.extend({
		el : "body",
		initialize : function() {
			this.model = new model();
			this.render();
		},
		events : {
			"click button[role='downloadBtn']" : "downloadFile",
			"click #btn-save" : "save",
			"click #btn-submittedAudit" : "submittedAudit"
		},
		render : function() {
			 this.initData();
			this.validateForm();
		},
		validateForm : function() {
			var viewSelf = this;
			$("#myform").attr("action", $$ctx + "/dataEntry/upload");
			$("#myform").validate({
				rules : rm.rules,
				messages : rm.messages,
				submitHandler : function(form) {
					var formSelf = $(form);
					viewSelf.model.fileUpload(formSelf, function(result) {
						bootbox.alert(result.msg);
					});
				}
			});
		},
		downloadFile : function() {// 下载文件
			var viewSelf = this;
			//下载文件不能为空
			if($.trim($("#path").val()) === ""){
				bootbox.alert("下载文件为空！");
			}else{
				viewSelf.model.downloadReport($("#path").val());
			}
		},
		initData : function() {// 初始化模版数据
			$.ajax({
				type : "POST",
				url : $$ctx + "/dataEntry/getTemplate",
				data : {
					workflowId : $("#workflowId").val()
				},
				success : function(result) {
					console.log(result.data);
					$("#templateId").val(result.data.id);
					$("#templateName").val(result.data.name);
					$("#cycle").val(result.data.cycle);
					$("#timeLimit").val(result.data.timeLimit);
					$("#submitOrg").val(result.data.submitOrg);
					$("#checkRole").val(result.data.checkRole);
					if (result.data.sumType == "1") {
						$("#sumType").val("按行汇总");
					} else if (result.data.subType == "2") {
						$("#sumType").val("按页汇总");
					}
					$("#path").val(result.data.path);
					$("#subPeople").val(result.data.subPeople);
					$("#subTime").val(result.data.subTime);
				}
			});
		},
		save : function() {// 暂存
			if ($("#fileName").val() == "") {
				bootbox.alert("请先上传文件！");
			} else {
				$.ajax({
					type : "POST",
					url : $ctx + "/dataEntry/save",
					data : {
						templateId : $("#templateId").val(),
						submitOrg : $("#submitOrg").val(),
						cycle : $("#cycle").val(),
						fileName : $("#fileName").val(),
						subPeople : $("#subPeople").val(),
						subTime : $("#subTime").val()
					},
					success : function(result) {
						if (result.success) {
							bootbox.alert("保存成功！");
						} else {
							bootbox.alert("保存失败！");
						}
					}
				});
			}
		},
		submittedAudit : function() {// 上报审核
			$.ajax({
				type : "POST",
				url : $$ctx + "/dataEntry/submittedAudit",
				data : {
					workflowId : $("#workflowId").val(),
					workflowCode : $("#workflowCode").val(),
					wfTaskId : $("#wfTaskId").val(),
					nodeId : $("#nodeId").val(),
					actionCode : $("actionCode").val()
				},
				success : function(result) {
					console.log(result);
				}
			});
		}

	});
	module.exports = view;
})