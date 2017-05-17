define(function(require, exports, module) {
	var model = require("./model");
	var view = Backbone.View.extend({
		el: "body",
		initialize:function(){
			this.model=new model();
			this.render();
		},
		events:{
			"click button[role='downloadBtn_01']" : "downloadFile",
		},
		render:function(){
			this.initData();
			this.initCommentList();//加载意见记录 @add by wangxy 20150906
		},
		initCommentList: function() {
        	var viewSelf = this;
    		$("#wfDetailWarp").html("");
			var workflowId = $("#workflowId").val();
			var curOrgId = $("#orgId").val();//机构Id
			viewSelf.model.fetchCommentDetail({workflowId:workflowId},function(result){
				if(result.success){
					viewSelf.model.fetchResendComments({workflowId:workflowId,orgId:curOrgId},function(resultComments){
					var obj=resultComments;
					var strToobj=$.parseJSON(obj);
					console.log(result.data);
//					console.log(strToobj.length);
					for ( var index in result.data) {
						wfDetail = result.data[index];
						var htmlContent = "";
						if(wfDetail.orgId == curOrgId){
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
		downloadFile : function() {// 下载文件
			var viewSelf = this;
			if($.trim($("#realPath").val()) === ""){
				bootbox.alert("下载文件为空！");
			}else{
				var nodeId = $("#nodeId").val();
				if(nodeId == "100612" || nodeId== "100611"){
					viewSelf.model.download($("#realPath").val());
				}
			}
		},
		initData: function() {
			var nodeId = $("#nodeId").val();
			if(nodeId == "100612" || nodeId == "100611"){
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
					$("#templateId").val(result.data.no);
					$("#templateName").val(result.data.name);
					//报表周期
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
					if($.trim(result.data.sumType) == "1"){
						$("#sumType").html("<option>按行汇总</option>");
					}else if($.trim(result.data.sumType) == "2"){
						$("#sumType").html("<option>按页汇总</option>");
						$(".startRow").css("display","none");
					}
					$("#startRow").val(result.data.startRow);
					//$("#path").val(result.data.path);
					$("#realPath").val(result.data.releasePeople);
					$("#subPeople").val(result.data.subPeople);
					$("#subTime").val(result.data.subTime);
				}
			});
		}
	});
	module.exports = view;
})