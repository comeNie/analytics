define(function(require, exports, module) {
	var model = require("./model");
	var view = Backbone.View.extend({
		el: "body",
		initialize:function(){
			this.model=new model();
			this.render();
		},
		events:{
			
		},
		render:function(){
			this.initData();
			this.initCommentList();//加载意见记录 @add by wangxy 20150906
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
			});
			$('input,select,textarea',$('form[name="ruleForm"]')).attr('disabled',true);
			$(document).on("click", "#btn-download", function(e) {
        		var path = $("#path").val();
        		if(path != null && path != "") {
        			viewSelf.model.download(path);
        		}
			});
		},
		loadRoles:function(checkRoleValue){// 加载所有角色 
			var viewSelf = this;
			$.ajax({
				type:"POST",
				url: $$ctx + "/roleMng/findAllRole",
				dataType:"json",
				success:function(result){
					if(result.success == true){
						//var checkRoleValue = $("#checkRoleValue").val();
						var rid=[];
						var roleStr = checkRoleValue.split(",");
						$(".role-select").html("");
						$.each(result.data,function(i,item){
							for(var i=0;i<roleStr.length;i++){
								if(item.id == roleStr[i]){
									$("<option value ='"+item.id+"'>"+item.name+"</option>").appendTo(".role-select");
									rid.push(item.id);
								}
							}
						});
						/*var config = {
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
						$('.role-select').trigger("chosen:updated");*/
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
						//var submitOrgValue = $("#submitOrgValue").val();
						var orgid=[];
						var orgStr = submitOrgValue.split(",");
						$(".org-select").html("");
						$.each(result.data,function(i,item){
							for(var i=0;i<orgStr.length;i++){
								if(item.id == orgStr[i]){
									$("<option value ='"+item.id+"'>"+item.name+"</option>").appendTo(".org-select");
									orgid.push(item.id);
								}
							}
						});
						/*var config = {
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
						$('.org-select').trigger("chosen:updated");*/
					}
				}
			});
		}
	});
	module.exports = view;
})