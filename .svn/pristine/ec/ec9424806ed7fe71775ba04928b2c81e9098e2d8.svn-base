define(function(require, exports, module) {
	var model = require("./model");
	var rm = require("./rm");
	var view = Backbone.View.extend({
	el: "body",
	initialize:function(){
		this.model=new model();
		this.render();
	},
	events:{
		"click button[role='query']":"queryReport",
		"click button[role='summarize']":"summarizeReport",
		"click button[role='detail']":"openDetail",//查看意见记录
	},
	render:function(){
		this.initTemplateTable();
		this.initDataTables();
		this.clickFunction();
		//this.initCommentList();//加载意见记录 @add by wangxy 20150906
	},
	openDetail : function(e){
		var viewSelf = this;
		var $btn=$(e.currentTarget);//获得当前操作按钮
		var curOrgId = $btn.data('orgid');
		viewSelf.initCommentList(curOrgId);
		$("#detailModal").modal("show");
	},
	initCommentList: function(curOrgId) {
    	var viewSelf = this;
		$("#wfDetailWarp").html("");
		var workflowId = $("#workflowId").val();
		viewSelf.model.fetchCommentDetail({workflowId:workflowId},function(result){
			if(result.success){
				viewSelf.model.fetchResendComments({workflowId:workflowId,orgId:curOrgId},function(resultComments){
					var obj=resultComments;
					var strToobj=$.parseJSON(obj);
					for ( var index in result.data) {
						wfDetail = result.data[index];
						if(wfDetail.orgId == curOrgId){//当前机构
							var htmlContent = "";
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
	initDataTables : function(){
    	var viewSelf = this;
    	var workflowId = $("#workflowId").val();
		var cusManagerTable = $("#tbl_cusmanager").dataTable({
			bServerSide: true,
			bFilter: false,
			bLengthChange: false,
			bSort: false,
			ajax: {
				type: "POST",
				url: $$ctx + "/dataSummarize/findAll",
				data:{
		    		workflowId : $("#workflowId").val()//workflowId
				},
			},
			columns: [
				{data: "id", render : function(data, type, rowdata) {
//						return "<input type='checkbox' value='" + rowdata.id + "' name='cusmanager_ck_id' id='cusmanager_ck_id' />";
					    return "";
	            }},
				{data: "orgName"},
		        {data: "submitState",render:function(data,type,row){
		        	if($.trim(row.submitState) == '1'){
		        		return '已报送';
		        	}else{
		        		return '未报送';
		        	}
		        }},
		        {data: "subTime",render:function(data,type,row){
		        	
		        	return $.trim(row.subTime).substring(0,10);
		        }},
		        {data: null, render: function(data, type, row ) {
		        	if($.trim(row.submitState) == '1'){
						return Mustache.render($("#dt-row-operation").html(), {orgId: row.orgId,path: row.path,id: row.id});
			        	}else{
			        		return Mustache.render($("#dt-row-operation_hidden").html(), {orgId: row.orgId,path: row.path});
			        	}
	                }}
		    ],
		});
    },
    initTemplateTable:function(e){
		var id=$("#reportTemplateId").val();
		var workflow_id=$("#workflowId").val();
		$.ajax({
			type : "POST",
			url : $$ctx + "/dataSummarize/templateInit",
			data : {
				templateId : id,
				workflowId : workflow_id,
				},
			success : function(result){
				$("#no").val($.trim(result.no));
				$("#name").val($.trim(result.name));
				 var cycle = $.trim(result.cycle);
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
				$("#sub_time").val($.trim(result.releasePeople));
				var type=$.trim(result.sumType);
				var sumType;
				if(type==1){
					sumType="按行汇总";
				} else if(type==2){
					sumType="按页汇总";
				}else{
					sumType="无";
				}
				$("#sum_type").val(sumType);
				$("#org").val($.trim(result.checkRole));
				
				var sta=$.trim(result.state);
				var status;
				if(sta=='0'){
					status="未汇总";
				} else if(sta=='1'){
					status="已汇总";
				}else if(sta=='2'){
					status="已发布";
				}
				$("#status").val(status);
				$("#templatePath").val($.trim(result.path));
			}
			});
		},
		clickFunction: function() {
			var viewSelf = this;
			//已提交的Excel查看
			$("#tbl_cusmanager").on("click", "button[role='download']", function(e) {
				var btnSelf=$(this);
				viewSelf.model.downloadReport(btnSelf.data("file-path"));
			});
			//TODO 查看汇总 modified by wangxy 20150901
			$("#actionButtonNext").on("click", "button[role='query']", function(e) {
				var workflowId = $("#workflowId").val();
				$.ajax({
					type : "POST",
					url : $$ctx + "/dataSummarize/reportSumInit",
					data : {
						workflowId : workflowId
					},
					success : function(result){
						
						viewSelf.model.downloadReport(result);
					}
				});
			});
		},
        summarizeReport: function() {
			if ($('#cusmanager_ck_id').get(0).checked) {
				var checkedId = "";
				$('input[name="cusmanager_ck_id"]:checked').each(
					function() {
						checkedId = checkedId + " ' "
								+ $(this).val() + " ', ";
					});
				$.ajax({
					type : "POST",
					url : $$ctx + "/dataSummarize/summarizeReport",
					data : {
						ck_Id : checkedId
					},
					success : function(result) {
						if (result.msg == "OK")
							alert("汇总成功！");
					}
				});
			} else {
				alert("请选择一条记录！");
			}
		}
	});
	module.exports = view;
})