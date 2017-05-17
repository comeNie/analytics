define(function(require, exports, module) {
	var model = require("./model");
	var rm = require("./rm");
	var constants = require("my/js/utils/constants");
	var view = Backbone.View.extend({
		el: "body",
		initialize:function(){
			this.model=new model();
			this.render();
		},
		events:{
			"click button[role='downloadBtn']" : "downloadFile",
			"click button[role='btn-reset']" : "clearFileName",
			"click button[role='fileBtn']" : "uploadFile",
		},
		render:function(){
			this.initData();
			this.fileUpload();
			this.initTimeLine();
			this.initButton();
			this.initCommentList();
			this.audit();
			
		},
		fileUpload : function() {//上传
			
			
			$("#myform").validate({
				rules : rm.rules,
				messages : rm.messages,
			});
		},
		
		uploadFile : function(e) {
        	
			var viewSelf = this;
			$("#myform").attr("action", $$ctx + "/dataEntry/upload");
			 var b = $("#myform").valid();
		        if (b) {
		        	$("#myform").ajaxSubmit(function(r){
			            if(r=='success'){
			            	$("#fileBtn").val("true");
							bootbox.alert("上传文件成功!");
						}else{
							bootbox.alert("上传文件失败!");
						}
					});
		        }
        	
		        
		        
			},
		
		downloadFile : function() {// 下载文件
			var viewSelf = this;
			//下载文件不能为空
			if($.trim($("#path").val()) === ""){
				bootbox.alert("下载文件为空！");
			}else{
				if($("#nodeId").val() == "100612"){
					viewSelf.model.download($("#realPath").val());
				}else{
				    viewSelf.model.download($("#path").val());
				}
			}
		},
		clearFileName : function(){//重置上传文件
			$("#textfield").val("");
			var file = $("#filename"); 
			file.after(file.clone().val("")); 
			file.remove();
		},
		initData: function() {
			if($("#nodeId").val() == "100612"){
				$(".label-reportResult").html("报表结果");
			}
			var viewSelf = this;
			$.ajax({
				type : "POST",
				url : $$ctx + "/dataEntry/getTemplate",
				data:{
						workflowId:$("#workflowId").val(),
						nodeId:$("#nodeId").val()
					},
				success:function(result){
//					console.log(result);
					$("#templateId").val(result.data.no);
					$("#templateName").val(result.data.name);
					 var cycle = $.trim(result.data.cycle);
					 var data;
						if(cycle==1){
			        		data="一次性填报";
			        	} else if(cycle==2){
			        		data="年报";
			        	} else if(cycle==3){
			        		data="半年报";
			        	} else if(cycle==4){
			        		data="季报";
			        	} else if(cycle==5){
			        		data="月报";
			        	} else if(cycle==6){
			        		data="旬报";
			        	} else if(cycle==7){
			        		data="周报";
			        	} else {
			        		data="无";
			        	}
					$("#cycle").val(data);
					$("#timeLimit").val(result.data.timeLimit);
					//机构
					var orgs = result.data.submitOrg.split("/");
					var org_span ="";
					$.each(orgs,function(index,data){
						org_span+="<span class='tag'>"+data+"</span>";
					});
					$("#submitOrg").html(org_span);
					//角色
					var roles = result.data.checkRole.split("/");
					var role_span ="";
					$.each(roles,function(index,data){
						role_span+="<span class='tag'>"+data+"</span>";
					});
					$("#checkRole").html(role_span);
					//汇总方式
					if(result.data.sumType == "1"){
						$("#sumType").val("按行汇总");
					}else if(result.data.sumType == "2"){
						$("#sumType").val("按页汇总");
						$(".startRow").css("display","none");
					}
					$("#startRow").val(result.data.startRow);
					$("#path").val(result.data.path);
					$("#realPath").val(result.data.releasePeople);
					$("#subPeople").val(result.data.subPeople);
					$("#subTime").val(result.data.subTime);
					$("#textfield").val(result.data.operation);
				}
			});
		},
		//--- 流程相关 ---//
		initButton: function(){
			var viewSelf = this;
			$('input,select,textarea',$('form[name="ruleForm"]')).attr('disabled',true);
			//初始化审核按钮
			var nodeId = $("#nodeId").val();
			viewSelf.model.getTaskActions(nodeId, function(r){
				var submitAuditBtn;
				if($.trim(nodeId) == "100612"){
					submitAuditBtn="审核通过";
				}else{
					submitAuditBtn="提交审核";
				}
				if (r.success) {
					var html = "";
					for ( var i in r.data) {
						if(r.data[i].actionCode == '1') {
							html += "<button type='button' class='btn btn-sm btn-success' data-loading-text='正在提交..' " +
									"data-ac='" + r.data[i].actionCode + "' " +
									"data-anc='" + r.data[i].actionNameCn + "' " +
									"data-ane='" + r.data[i].actionNameEn + "' " +
									"data-io='" + r.data[i].isOpen + "' " +
									"id='submitAudit' >" +
							"<i class='ace-icon fa fa-check-square-o'></i>" + submitAuditBtn + "</button> &nbsp;&nbsp;";
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
			var orgId = $("#orgId").val();//机构Id
		//	console.log(orgId+'---orgId---');
			viewSelf.model.fetchCommentDetail({workflowId:workflowId},function(result){
				if(result.success){
					viewSelf.model.fetchResendComments({workflowId:workflowId,orgId:orgId},function(resultComments){
					var obj=resultComments;
					var strToobj=$.parseJSON(obj);
					console.log(result.data);
//					console.log(strToobj.length);
					for ( var index in result.data) {
						wfDetail = result.data[index];
						var htmlContent = "";
						if(wfDetail.orgId == orgId){
							
							
							var isDone = wfDetail.taskStatus=='82';
							var _taskStatus = "";
							if (wfDetail.taskStatus == "80") {
								_taskStatus = "待处理";
							} else if (wfDetail.taskStatus == "81") {
								_taskStatus = "进行中";
							} else if (wfDetail.taskStatus == "82") {
								_taskStatus = "已完成";
							} 
							var _stageNameCn = wfDetail.stageNameCn;
							var _actionNameCn = wfDetail.actionNameCn;
							
							if(!isDone){
								for(var i=0;i<strToobj.length;i++){
									if(wfDetail.taskId==strToobj[i].taskId){
										console.log(strToobj[i].resendTime);
										var time = new Date(parseInt(strToobj[i].resendTime.time));	
									    var year = time.getFullYear();
						                var month =(time.getMonth() + 1).toString();
						                var day = (time.getDate()).toString();
									    var hour = (time.getHours()).toString();
									    var min = (time.getMinutes()).toString();
									    var sec = (time.getSeconds()).toString();
									    var resendTimes = year+'-'+month+'-'+day+' '+hour+':'+min+':'+sec;
									    wfDetail.comments=strToobj[i].comments;
									    htmlContent += '<div class="timeline-item clearfix">';
										htmlContent += '	<div class="timeline-info">';
										htmlContent += '		<i class="timeline-indicator ace-icon fa fa-hand-o-right btn btn-warning no-hover"></i>';
										htmlContent += '	</div>';
										
										htmlContent += '	<div class="widget-box widget-color-orange">';
										htmlContent += '		<div class="widget-header widget-header-small">';
										
										htmlContent += '			<h5 class="widget-title smaller">';
										htmlContent += '				<span class="">'+ strToobj[i].resendPeople + '---'+ '报表收集' + '(' + '已退回' + ')' + '  操作:' + '重发' + '</span>';
										htmlContent += '			</h5>';
				
										htmlContent += '			<span class="widget-toolbar no-border">';
										htmlContent += '				<i class="ace-icon fa fa-clock-o bigger-110"></i>';
										htmlContent += wfDetail.createTime;
										htmlContent += '			</span>';
				
										htmlContent += '		</div>';
										
				
										htmlContent += '		<div class="widget-body">';
										htmlContent += '			<div class="widget-main">';
										htmlContent += '审批意见:' + (strToobj[i].comments||'无审批意见');				
										htmlContent += '			</div>';
										htmlContent += '		</div>';
										htmlContent += '		</div>';
									}
									
								}
							}else{
							
							htmlContent += '<div class="timeline-item clearfix">';
							htmlContent += '	<div class="timeline-info">';
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
                               for(var i=0;i<strToobj.length;i++){
								if(wfDetail.taskId==strToobj[i].taskId){
									console.log(strToobj[i].resendTime);
									var time = new Date(parseInt(strToobj[i].resendTime.time));	
								    var year = time.getFullYear();
					                var month =(time.getMonth() + 1).toString();
					                var day = (time.getDate()).toString();
								    var hour = (time.getHours()).toString();
								    var min = (time.getMinutes()).toString();
								    var sec = (time.getSeconds()).toString();
								    var resendTimes = year+'-'+month+'-'+day+' '+hour+':'+min+':'+sec;
								    wfDetail.comments=strToobj[i].comments;
								    htmlContent += '<div class="timeline-item clearfix">';
									htmlContent += '	<div class="timeline-info">';
									htmlContent += '		<i class="timeline-indicator ace-icon fa fa-hand-o-right btn btn-warning no-hover"></i>';
									htmlContent += '	</div>';
									
									htmlContent += '	<div class="widget-box widget-color-orange">';
									htmlContent += '		<div class="widget-header widget-header-small">';
									
									htmlContent += '			<h5 class="widget-title smaller">';
									htmlContent += '				<span class="">'+ strToobj[i].resendPeople + '---'+ '报表收集' + '(' + '已退回' + ')' + '  操作:' + '重发' + '</span>';
									htmlContent += '			</h5>';
			
									htmlContent += '			<span class="widget-toolbar no-border">';
									htmlContent += '				<i class="ace-icon fa fa-clock-o bigger-110"></i>';
									htmlContent += wfDetail.createTime;
									htmlContent += '			</span>';
			
									htmlContent += '		</div>';
									
			
									htmlContent += '		<div class="widget-body">';
									htmlContent += '			<div class="widget-main">';
									htmlContent += '审批意见:' + (strToobj[i].comments||'无审批意见');				
									htmlContent += '			</div>';
									htmlContent += '		</div>';
									htmlContent += '		</div>';
								}
								
							}
                               
							}
							$(htmlContent).appendTo($("#wfDetailWarp"));
							
						
						}
					}
					if(result.data.length <= 0) {
						$("暂无审批意见记录").appendTo($("#wfDetailWarp"));
					}
				})
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
            	viewSelf.model.auditNext(parameterJosn, function(result) {
                    if (result.success) {
                    	//待办统计数字
                    	utils.todoListToltalNum();
                        bootbox.alert("提交成功!", function() {
                        	 $("#proxyIFrame").attr("src", constants.portalLoginUrl + "/iframe?" + new Date().getTime());
                        	 window.opener.winOperate();
         					 window.close();
                        });
                    } else {
                        bootbox.alert("提交失败,请稍后重试");
                    }
                });
			});
        	
        	$(document).on("click", "#submitAudit", function(e) {
        		var self = $(this);
        		$("#actionCode").val(self.data("ac"));
        		var _comments = $("#comments").val();
        		var _file =$("#textfield").val();//上传文件
        		var _nodeId=$("#nodeId").val();//审核环节不需要验证上传文件
        		if($.trim(_nodeId) === "100611" && $.trim(_file) === ""){
        			bootbox.alert("上传文件不能为空!");
            		return ;
        		}
        		var flag = $("#fileBtn").val();
        		if(flag == "false"){
        			bootbox.alert("请先提交上传文件!");
            		return ;
        		}
            	if($.trim(_comments) === "") {
            		bootbox.alert("必须输入意见!");
            		return ;
            	}
            	self.attr("disabled",true);//提交之后按钮禁用，防止重复提交
            	var parameterJosn = {
            			workflowCode: $("#workflowCode").val(),
						workflowId: $("#workflowId").val(),
						nodeId: $("#nodeId").val(),
						wfTaskId: $("#wfTaskId").val(),
						actionCode: $("#actionCode").val(),
	                    comments: $("#comments").val()
            	};
            	viewSelf.model.auditNext(parameterJosn, function(result) {
                    if (result.success) {
                    	utils.todoListToltalNum();
                        bootbox.alert("提交成功!", function() {
                            //window.parent.denyAudit();
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
        	
        	$(document).on("click", "#btn-download", function(e) {
        		var path = $("#path").val();
        		if(path != null && path != "") {
        			viewSelf.model.downloadReport(path);
        		}
			});
        }
	});
	module.exports = view;
})