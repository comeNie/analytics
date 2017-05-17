define(function(require, exports, module) {
	var model = require("./model");
	var rm = require("./rm");
	var constants = require("my/js/utils/constants");
	var createNode = $("#nodeId").val()=="100510"?true:false;//用来标示新建模板的环节
	var flag = true;//用来标示是暂存还是提交
	var view = Backbone.View.extend({
		el: "div.main-container",
		flag:true,
		initialize:function(){
			this.model=new model();
			this.render();
		},
		events:{
			"change #sumType":"selectSumType",
			"click #btn-templateCreate" : "templateCreateSubmit",
			"click #submitAudit" : "submitAudit",
			"click button[role='btn-concel-detail']":"concel",
			"click button[role='close-detail']":"closedetail"
		},
		render:function(){
			this.initForm();
			this.initData();
			this.initTimeLine();
			this.initButton();
			this.initCommentList();
			this.initTaskReceiver();
			this.audit();
		},
		initForm: function() {
			$("#ruleForm").validate({
				rules: rm.rules,
				messages: rm.messages
			});
		},
		selectSumType:function(){
			var sumType = $("#sumType").val();
			if(sumType==2){
				$("#startRow").attr("disabled", true);
				$("#startRow").attr("class",""); 
				$("#startRow").val(""); 
			}else if(sumType==1){
				$("#startRow").attr("disabled", false);
				$("#startRow").attr("class","required"); 
				$("#startRow").val($("#startRowValue").val());
			}
		},
		templateCreateSubmit:function(){
			var viewSelf = this;
			 var b = $("#ruleForm").valid();
		        if (b) {
					if(flag){
						$("#ruleForm").attr("action", $$ctx + "/templateMng/addReportTemplate");
						document.getElementById("saveOrSubmit").value='save';
						$("#ruleForm").ajaxSubmit(function(r){
							if(r=='creatSuccess'){
								bootbox.alert("暂存成功!", function() {
		                        	window.opener.winOperate();
		        					window.close();
		                        });
							}else{
								bootbox.alert("<span style='font-size:16px;'>暂存失败！</span>");
							}						
							});
						
					}else{
						document.getElementById("saveOrSubmit").value="submit";
						$("#ruleForm").attr("action", $$ctx + "/templateMng/addReportTemplate");
						$("#ruleForm").ajaxSubmit(function(r){
							if(r=='creatSuccess'){

								var self = $("#submitAudit");
								$("#actionCode").val(self.data("ac"));
				            	var parameterJosn = {
				            			workflowCode: $("#workflowCode").val(),
										workflowId: $("#workflowId").val(),
										nodeId: $("#nodeId").val(),
										wfTaskId: $("#wfTaskId").val(),
										actionCode: $("#actionCode").val(),
					                    comments: $("#comments").val()
				            	};
				            	$("#submitAudit").attr("disabled", true);
				            	viewSelf.model.auditNext(parameterJosn, function(result2) {
				                    if (result2.success) {
				                        bootbox.alert("提交成功!", function() {
				                        	window.opener.winOperate();
				        					window.close();
				                        }
				                        );
				                    } else {
				                        bootbox.alert("提交失败,请稍后重试");
				                    }
				                });
							
							}				
							});
					}
		        }
		},
		initData: function() {
			var viewSelf = this;
			viewSelf.model.getReportTemplateById($("#workflowId").val(), function(obj) {
				$.each($("#ruleForm").find("input, select"), function() {
					if (obj[$(this).attr("name")] != null && obj[$(this).attr("name")] != undefined && obj[$(this).attr("name")] != "undefined") {
						$(this).val(obj[$(this).attr("name")]);
					}
				});
				viewSelf.loadRoles(obj.checkRole);
				viewSelf.loadOrgs(obj.submitOrg);
				if(createNode){
					var sumType = obj.sumType;
					$("#startRowValue").val(obj.startRow);
					if(sumType==2){
						$("#startRow").attr("disabled", true);
						$("#startRow").attr("class","");
					}else if(sumType==1){
						$("#startRow").attr("disabled", false);
						$("#startRow").attr("class","required"); 
					};
					var state = obj.state;
					$("#state").val(state);
				}
			});
			if(createNode){
				$("#fileDiv").show();
				$("#buttonDiv").show();
				$("#disCreateDownload").hide();
			}else{
				$('input,select,textarea',$('#step-container')).attr('disabled',true);
			}
		},
		loadRoles:function(checkRoleValue){// 加载所有角色 
			var viewSelf = this;
			$.ajax({
				type:"POST",
				url: $$ctx + "/roleMng/findAllRole",
				dataType:"json",
				success:function(result){
					if(result.success == true){
						var rid=[];
						var roleStr = checkRoleValue.split(",");
						$(".role-select").html("");
						$.each(result.data,function(i,item){
							if(createNode){
								$("<option value ='"+item.id+"'>"+item.name+"</option>").appendTo(".role-select");
							}
							for(var i=0;i<roleStr.length;i++){
								if(item.id == roleStr[i]){
									if(!createNode){
										$("<option value ='"+item.id+"'>"+item.name+"</option>").appendTo(".role-select");
									}
									rid.push(item.id);
								}
							}
						});
						if(createNode){
							var config = {
									'.role-select'					 : {},
									'.role-select-deselect'	: {allow_single_deselect:true},
									'.role-select-no-single' : {disable_search_threshold:10},
									'.role-select-no-results': {no_results_text:'没有数据!'},
									'.role-select-width'		 : {width:"100%"}
								}
								for (var selector in config) {
									$(selector).chosen(config[selector]);
								}
							$('.role-select').addClass('tag-input-style');
							$('.role-select').trigger("chosen:updated");
							$('#checkRole').val(rid);
							$('.role-select').trigger("chosen:updated");
						}
					}
				}
			});
			
		},
		loadOrgs:function(submitOrgValue){// 加载所有组织机构
			var viewSelf = this;
			$.ajax({
				type:"POST",
				url: $$ctx + "/templateMng/findAllOrg",
				dataType:"json",
				success:function(result){
					if(result.success == true){
						var orgid=[];
						var orgStr = submitOrgValue.split(",");
						$(".org-select").html("");
						$.each(result.data,function(i,item){
							if(createNode){
								$("<option value ='"+item.id+"'>"+item.name+"</option>").appendTo(".org-select");
							}
							for(var i=0;i<orgStr.length;i++){
								if(item.id == orgStr[i]){
									if(!createNode){
										$("<option value ='"+item.id+"'>"+item.name+"</option>").appendTo(".org-select");
									}
									orgid.push(item.id);
								}
							}
						});
						if(createNode){
							var config = {
									'.org-select'					 : {},
									'.org-select-deselect'	: {allow_single_deselect:true},
									'.org-select-no-single' : {disable_search_threshold:10},
									'.org-select-no-results': {no_results_text:'没有数据!'},
									'.org-select-width'		 : {width:"100%"}
								}
								for (var selector in config) {
									$(selector).chosen(config[selector]);
								}
							$('.org-select').addClass('tag-input-style');
							$('.org-select').trigger("chosen:updated");
							$('#submitOrg').val(orgid);
							$('.org-select').trigger("chosen:updated");
						}
					}
				}
			});
		},
		//--- 流程相关 ---//
		initButton: function(){
			var viewSelf = this;
			//初始化审核按钮
			var nodeId = $("#nodeId").val();
			viewSelf.model.getTaskActions(nodeId, function(r){
				if (r.success) {
					var html = "";
					for ( var i in r.data) {
						if(r.data[i].actionCode == '1') {//提交按钮
							html += "<button type='button' class='btn btn-sm btn-success' data-loading-text='正在提交..' " +
									"data-ac='" + r.data[i].actionCode + "' " +
									"data-anc='" + r.data[i].actionNameCn + "' " +
									"data-ane='" + r.data[i].actionNameEn + "' " +
									"data-io='" + r.data[i].isOpen + "' " +
									"id='submitAudit' >" +
							"<i class='ace-icon fa fa-check-square-o'></i>" + r.data[i].actionNameCn + "</button> &nbsp;&nbsp;";
						} else if(r.data[i].actionCode == '2') {
							html += "<button type='button' class='btn btn-sm btn-danger btn-next' data-loading-text='正在退回..' " +
								"data-ac='" + r.data[i].actionCode + "' " +
								"data-anc='" + r.data[i].actionNameCn + "' " +
								"data-ane='" + r.data[i].actionNameEn + "' " +
								"data-io='" + r.data[i].isOpen + "' " +
								"id='denyAudit' >" +
							"<i class='ace-icon fa fa-floppy-o'></i>" + r.data[i].actionNameCn + "</button>";
						} 
					}
					$("#actionButtonNext").html(html);
				}
			});
		},
        initTimeLine : function () {
            var nodeId = $("#nodeId").val();
            var pointerHtml = "<i class='ace-icon fa fa-hand-o-left grey bigger-125'></i>";
            var highLight = function (selector){
                $(selector).addClass("purple").removeClass("green").parent().append($(pointerHtml));
            };
            highLight("span[nodeId='" + nodeId + "']");
        },
		initCommentList: function() {
        	var viewSelf = this;
    		$("#wfDetailWarp").html("");
			var workflowId = $("#workflowId").val();
			viewSelf.model.fetchCommentDetail({workflowId:workflowId},function(result){
				if(result.success){
					for ( var index in result.data) {
						wfDetail = result.data[index];
						var htmlContent = "";
//						console.log(wfDetail);
						htmlContent += '<div class="timeline-item clearfix\">';
						htmlContent += '	<div class="timeline-info">';
						
						var isDone = wfDetail.taskStatus=='82';
						var _taskStatus = "";
						if (wfDetail.taskStatus == "80") {
							_taskStatus = "待处理";
						} else if (wfDetail.taskStatus == "81") {
							_taskStatus = "进行中";
						} else if (wfDetail.taskStatus == "82") {
							_taskStatus = "已完成";
						} 
						if(!isDone){
							continue;
						}
						var _stageNameCn = wfDetail.stageNameCn;
						var _actionNameCn = wfDetail.actionNameCn;
						
						if(isDone) {
							htmlContent += '		<i class="timeline-indicator ace-icon fa fa-check-square-o btn btn-info no-hover"></i>';
						}else {
							htmlContent += '		<i class="timeline-indicator ace-icon fa fa-hand-o-right btn btn-warning no-hover"></i>';
						}
						htmlContent += '	</div>';

						htmlContent += '	<div class="widget-box '+(isDone?'transparent':'widget-color-orange')+'">';
						htmlContent += '		<div class="widget-header widget-header-small">';
						htmlContent += '			<h5 class="widget-title smaller">';
						htmlContent += '				<span class="">'+ wfDetail.taskAssigneeCn + '---'+ _stageNameCn + '(' + _taskStatus + ')' + '  操作:' + _actionNameCn + '</span>';
						htmlContent += '			</h5>';

						htmlContent += '			<span class="widget-toolbar no-border">';
						htmlContent += '				<i class="ace-icon fa fa-clock-o bigger-110"></i>';
						if (wfDetail.endTime) {
							htmlContent += wfDetail.endTime ;
						}
						htmlContent += '			</span>';

						htmlContent += '		</div>';

						htmlContent += '		<div class="widget-body">';
						htmlContent += '			<div class="widget-main">';
						htmlContent += '审批意见:' + (wfDetail.comments||'无审批意见');				
						htmlContent += '			</div>';
						htmlContent += '		</div>';
						htmlContent += '	</div>';
						htmlContent += '</div>';
						$(htmlContent).appendTo($("#wfDetailWarp"));
					}
					if(result.data.length <= 0) {
						$("暂无审批意见记录").appendTo($("#wfDetailWarp"));
					}
				}else{
					bootbox.alert("查看详细失败请稍后重试");
				}
			});
        },
        audit: function() {
        	var viewSelf = this;
        	$(document).on("click", "#denyAudit", function(e) { 
        		var self = $(this);
        		$("#actionCode").val(self.data("ac"));
        		var _comments = $("#comments").val();
            	if($.trim(_comments) === "") {
            		bootbox.alert("必须输入意见!");
            		return ;
            	}
            	var parameterJosn = {
            			workflowCode: $("#workflowCode").val(),
						workflowId: $("#workflowId").val(),
						nodeId: $("#nodeId").val(),
						wfTaskId: $("#wfTaskId").val(),
						actionCode: $("#actionCode").val(),
	                    comments: $("#comments").val(),
            	};
            	$("#denyAudit").attr("disabled", true);
            	$("#submitAudit").attr("disabled", true);
            	viewSelf.model.auditNext(parameterJosn, function(result) {
                    if (result.success) {
                    	//待办统计数字
                    	utils.todoListToltalNum();
                        bootbox.alert("提交成功!", function() {
                        	window.opener.winOperate();
        					window.close();
                            /*$("#proxyIFrame").attr("src", constants.portalLoginUrl + "/iframe?" + new Date().getTime());
                        	$("#proxyIFrame").on("load",function(){
            					window.close();
            			    });*/
                        });
                    } else {
                        bootbox.alert("提交失败,请稍后重试");
                    }
                });
			});
        	
        	$(document).on("click", "button[role='btn-download']", function(e) {
        		var path = $("#path").val();
        		if(path != null && path != "") {
        			viewSelf.model.download(path);
        		}
			});
        	
        },
        //TODO
        submitAudit:function(){
        	var viewSelf = this;
        	var self = $("#submitAudit");
        	flag = false;
    		if(createNode){
    			 var b = $("#ruleForm").valid();
 		        if (b) {
 		        document.getElementById("saveOrSubmit").value="submit";
 		       $("#lookTemplate").modal("show");
//				//$("#receivers").val(id);
			    $(document).on("click", "button[role='comfirmNextPeople']", function(e) {
				var treeObj_dashboard = $.fn.zTree.getZTreeObj("taskReceiver");
				var nodes_dashboard = treeObj_dashboard.getCheckedNodes();
					var id="";
					$.each(nodes_dashboard, function(i, node) {
						id=node.ssoId+","+id;
					});
				if(id==null||id==''){
					alert("请选择下一环节处理人！");
					return;
				}else{
				$("#ruleForm").attr("action", $$ctx + "/templateMng/addReportTemplate");
				$("#ruleForm").ajaxSubmit(function(r){
					if(r=='creatSuccess'){
						var self = $("#submitAudit");
						$("#actionCode").val(self.data("ac"));
		            	var parameterJosn = {
		            			workflowCode: $("#workflowCode").val(),
								workflowId: $("#workflowId").val(),
								nodeId: $("#nodeId").val(),
								wfTaskId: $("#wfTaskId").val(),
								actionCode: $("#actionCode").val(),
			                    comments: $("#comments").val(),
			                    receivers: id,
		            	};
		            	$("#submitAudit").attr("disabled", true);
		            	viewSelf.model.auditNext(parameterJosn, function(result2) {
		                    if (result2.success) {
		                    	utils.todoListToltalNum();
		                        bootbox.alert("提交成功!", function() {
		                        	window.opener.winOperate();
		        					window.close();
		                        }
		                        );
		                    } else {
		                        bootbox.alert("提交失败,请稍后重试");
		                    }
		                });
					
					}				
					});
 		        }
    		});
 		        }
			}else{
    			self.attr("type", "button");
        		$("#actionCode").val(self.data("ac"));
        		var _comments = $("#comments").val();
        		
            	if($.trim(_comments) === "") {
            		bootbox.alert("必须输入意见!");
            		return ;
            	}
            	
            	var parameterJosn = {
            			workflowCode: $("#workflowCode").val(),
						workflowId: $("#workflowId").val(),
						nodeId: $("#nodeId").val(),
						wfTaskId: $("#wfTaskId").val(),
						actionCode: $("#actionCode").val(),
	                    comments: $("#comments").val()
            	};
            	$("#denyAudit").attr("disabled", true);
            	$("#submitAudit").attr("disabled", true);
            	viewSelf.model.auditNext(parameterJosn, function(result) {
                    if (result.success) {
                    	utils.todoListToltalNum();
                        bootbox.alert("提交成功!", function() {
                            //window.parent.denyAudit();
                        	window.opener.winOperate();
        					window.close();
//                            $("#proxyIFrame").attr("src", constants.portalLoginUrl + "/iframe?" + new Date().getTime());
//                        	$("#proxyIFrame").on("load",function(){
//                        		window.opener.winOperate();
//            					window.close();
//            			    });
                        });
                    } else {
                        bootbox.alert("提交失败,请稍后重试");
                    };
			});
//				}
			};
        },
        
        initTaskReceiver:function(){
        	var url;
        	var nodeId = $("#nodeId").val();
        	var orgId;
        	if(nodeId=='100510'){
        		roleId=392;
        		url="/templateMng/findtaskReceiverMenuList?orgId="+roleId;
    		$.fn.zTree.init($("#taskReceiver"), {
    			async: {
    				enable: true,
    				url:$$ctx + url
    			},
    			data: {
    				simpleData: { enable: true, idKey: "ssoId", pIdKey: "pid"},
    				key: { name: "userName" }
    			},
    			check: { enable: true, chkStyle: "checkbox",chkboxType:{ "Y" : "ps", "N" : "ps" }},
    			callback: {
    				onAsyncSuccess: function() {
    					var treeObj = $.fn.zTree.getZTreeObj("taskReceiver");
    					treeObj.expandAll(false);//全不展开
    				}
    			}
    		});
        };
	},
	
	concel: function() {
		$("#submitAudit").attr("disabled", false);
	},
	closedetail: function() {
		$("#submitAudit").attr("disabled", false);
	}
	
        
	});
	module.exports = view;
});