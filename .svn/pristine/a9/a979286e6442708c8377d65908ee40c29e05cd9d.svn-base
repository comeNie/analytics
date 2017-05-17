<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>
<link rel="stylesheet" href="${res}/css/chosen.css" type="text/css"></link>
<style type="text/css">
	.t_dialog {
	width: 100%;
	display: none;
	}
	.fileInput{width:102px;height:34px; background:blue
	;}
	.upfile{}
	.upFileBtn{position:absolute;width:102px;height:34px;cursor:pointer;color:#fff;background:#428bca;border:none;}
</style>
<div class="aajax-content">
	<div class="page-header">
		<h1>
			手工报送<small> <i class="ace-icon fa fa-angle-double-right"></i>
				模板管理<i class="ace-icon fa fa-angle-double-right"></i>
					新建模板
			</small>
		</h1>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<form action="" class="form-horizontal" id="templateForm" name="templateForm" method="post" enctype="multipart/form-data" >
				<input type="hidden" class="form-control" id="id" name="id" value="${template.id}" /> 
				<input type="hidden" class="form-control" id="workflowId" name="workflowId" value="${template.workflowId}" /> 
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="name"> 报表编号<span class="red">*</span>
					</label>
					<div class="col-sm-4">
						<input type="text" id="no" name="no" class="form-control" maxlength="50" value="${template.no}"/>
					</div>
				</div>		
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="name"> 报表名称<span class="red">*</span>
					</label>
					<div class="col-sm-4">
						<input type="text" id="name" name="name" class="form-control" maxlength="50" value="${template.name }"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="name"> 报表周期<span class="red">*</span>
					</label>
					<div class="col-sm-4">
						<div class="clearfix">
							<input type = "hidden" id="cycleValue" value="${template.cycle }">
							<select id="cycle" class="form-control" name="cycle">
								<option value="1">一次性填报</option>
								<option value="2">年报</option>
								<option value="3">半年报</option>
								<option value="4">季报</option>
								<option value="5">月报</option>
								<option value="6">旬报</option>
								<option value="7">周报</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="name"> 报送时限<span class="red">*</span>
					</label>
					<div class="col-sm-4">
						统计周期后&nbsp;&nbsp;&nbsp;
						<input type="text" id="timeLimit" name="timeLimit" style="width:30%" value="${template.timeLimit }"
							maxlength="3" />&nbsp;&nbsp;&nbsp;天以内
					</div>
				</div>
				<div class="form-group">
					<%-- <label class="col-sm-2 control-label no-padding-right"
						for="name"> 填报机构（多选）<span class="red">*</span>
					</label>
					<div class="col-sm-4">
						<input type = "hidden" id="submitOrgValue" value="${template.submitOrg }">
						<select data-placeholder=" " id="submitOrg" class="col-xs-10 col-sm-12 org-select" 
						name="submitOrg" multiple="multiple"></select>
					</div> --%>
					<div class="form-group">
						<label class="col-sm-2 control-label no-padding-right"
							for="name"> 填报机构（多选）<span class="red">*</span>
						</label>
						<div class="col-sm-9">
						    <input type = "hidden" id="submitOrgValue" value="${template.submitOrg }">
							<select data-placeholder=" " multiple class="col-xs-10 col-sm-5 ch-orgselect" name="submitOrg" id="submitOrg">
								<optgroup label="请选择机构"></optgroup>
							</select>
							<a href="javascript:void(0);" id="orgs_all-select" title="全选"><i class="ace-icon glyphicon glyphicon-ok"></i></a>
							<a href="javascript:void(0);" id="orgs_del-select" title="取消"><i class="ace-icon glyphicon glyphicon-remove"></i></a>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="name"> 查阅角色（多选）<span class="red">*</span></label>
					<div class="col-sm-4">
						<input type = "hidden" id="checkRoleValue" value="${template.checkRole }">
						<select data-placeholder=" " id="checkRole" class="col-xs-10 col-sm-12 role-select" name="checkRole" multiple="multiple"></select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="name"> 汇总方式<span class="red">*</span></label>
					<div class="col-sm-4">
						<div class="clearfix">
							<input type = "hidden" id="sumTypeValue" value="${template.sumType }">
							<select id="sumType" class="form-control" name="sumType" value="">
								<option value="1">按行汇总</option>
								<option value="2">按页汇总</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="name"> 起始行数</label>
					<div class="col-sm-4">
						<input type = "hidden" id="startRowValue" value="${template.startRow }">
						<input type="text" id="startRow" name="startRow" style="width:100%;" maxlength="2" value="${template.startRow }" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="name"> 报表模板<span class="red">*</span>
					</label>
					<div class="form-group">
						<div class="col-sm-4">
						    <input type="hidden" id="pathValue" value="${template.path}">
							<!-- <input multiple="" type="file" id="uploadFile" name="uploadFile" onchange="getPath()"/> -->
							
							<div class="fileInput left">
					          <input type="file" multiple="" name="uploadFile" id="uploadFile" class="upfile" onchange="getPath()" style="position:absolute;left:47px;line-height:34px;filter:alpha(opacity=0); opacity:0"/>
					          <input class="upFileBtn" type="button" value="上传文档" onclick="document.getElementById('uploadFile').click()" />
					        </div>
					        
							<label id="filenameOfliulan" style="position:absolute;left:115px;top:8px;background:#fff;z-index:999">
								<input type="hidden" name="file-format" id="id-file-format" class="ace" /><span id="templatePath"></span>
							</label>
						</div>
					</div>
					<%-- <div class="col-sm-4">
						<input type="hidden" id="pathValue" value="${template.path}">
						<input type="file" id="uploadFile" name="uploadFile" style="width:100%;" extension="xlsx" class="required" value="${template.path}"/>
					    <input type="hidden" id="flags" name="flags" value="">
					</div> --%>
					<%-- <div class="col-sm-4">
					    <input type="hidden" id="pathValue" value="${template.path}">
						<!-- <input multiple="" type="file" id="uploadFile" name="uploadFile"  extension="xlsx" class="required" style="width:100%"/> -->
					    <!-- <label class="ace-file-input">
                        <input id="id-input-file-2" type="file" multiple="">
                        <span class="ace-file-container selected" data-title="浏览">
                        <button id="liulan" class="btn btn-sm btn-success" type="button" role="liulan">
						<i class="ace-icon fa fa-check"></i> 
						        浏览
					    </button>
                        <span class="ace-file-name" data-title="">
                        <i class=" ace-icon fa fa-file"></i>
                        </span>
                        </span>
                      </label> -->
					</div> --%>
				</div>
			    <div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="name"> 下一环节处理人
					</label>
					<div class="col-sm-4">
						<ul class="ztree" id="taskReceiver" style="-moz-user-select: none;">
							<li></li>
						</ul>
						<input type="hidden" id="receivers" value="">
						<input type="hidden" id="callback_receivers" value="${callback_receivers }">
					</div>
				</div> 
				<div class="clearfix form-actions">
					<div class="col-md-offset-4  col-md-6">
						<button id="download-detail" class="btn btn-info btn-sm" type="button" role="downloadEdit" >
							<i class="glyphicon glyphicon-save"></i>
							查看模板
						</button>
						<button id="btn-templateCreate" class="btn btn-sm btn-primary" type="button" role="btn-templateCreate">
							<i class="ace-icon fa fa-save"></i> 
							暂存
						</button>
						<button id="btn-templateSendAudit" class="btn btn-sm btn-success" type="button" role="btn-templateSendAudit">
							<i class="ace-icon fa fa-check"></i> 
							发送审核
						</button>
						<button id="goBack" class="btn btn-sm btn-default" type="button">
							<i class="ace-icon fa fa-arrow-left"></i>
							返回
						</button>
						</span>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<script src="${res}/js/chosen.jquery.min.js"></script>
<script src="${res}/js/jquery.ztree.all-3.5.min.js"></script>
<link rel="stylesheet" href="${res}/css/chosen.css" type="text/css"></link>

<script type="text/javascript">
	// DO NOT REMOVE : GLOBAL FUNCTIONS!
	ace.load_ajax_scripts([], function() {})
	$.post("${ctx}/templateMng/loadOrgDepts",function(orgr,status){
		if (status == "success") {
			var orgids=[];
			var id = $("#id").val();
			if(id != null&&id != ''){
			   var submitOrgValue = $("#submitOrgValue").val();
			   var orgStr = submitOrgValue.split(",");
			   $.each(orgr,function(i,orgitem){
				   $("<option value='"+orgitem.id+"'>"+ orgitem.name+"</option>").appendTo(".ch-orgselect optgroup");
					for(var i=0;i<orgStr.length;i++){
						if(orgitem.id == orgStr[i]){
							orgids.push(orgitem.id);
						}
					}
				});
				$('#submitOrg').val(orgids);
				$('.ch-orgselect').trigger("chosen:updated");
/* 				$.each(orgr,function(i,orgitem){
					$("<option value='"+orgitem.id+"'>"+ orgitem.name+"</option>").appendTo(".ch-orgselect optgroup");
					orgids.push(orgitem.id);
				}); */
			}else{
				$.each(orgr,function(i,orgitem){
					$("<option value='"+orgitem.id+"'>"+ orgitem.name+"</option>").appendTo(".ch-orgselect optgroup");
					orgids.push(orgitem.id);
				});
			}
			var config = {
					'.ch-orgselect'					 : {},
					'.ch-select-deselect'	: {allow_single_deselect:true},
					'.ch-select-no-single' : {disable_search_threshold:10},
					'.ch-select-no-results': {no_results_text:'Oops, nothing found!'},
					'.ch-select-width'		 : {width:"100%"}
				};
				for (var selector in config) {
					$(selector).chosen(config[selector]);
				};
				/* if( id!=null && id!="" ){
					$('#submitOrg').val(orgids);
					$('.ch-orgselect').trigger("chosen:updated");
						} */
			$('.ch-orgselect').addClass('tag-input-style');
			//全选
			$("#orgs_all-select").click(function(){
				$("#submitOrg").val(orgids);
				$("#submitOrg").trigger("chosen:updated");
			});
			//全不选
			$("#orgs_del-select").click(function(){
				$("#submitOrg").val([]);
				$("#submitOrg").trigger("chosen:updated");
			});
		}
	},"json");
	
</script>
<script type="text/javascript">
	function getPath(){
		$(document).ready(function () {
			$('#filenameOfliulan').html($('#uploadFile').val());
			
		    /* $("#filenameOfliulan").each(function () {
		        var myvalue = "";
		        $("#filenameOfliulan").html(myvalue);
		    });  */
		});
	}
</script>
<script type="text/javascript">
	ace.load_ajax_scripts([], function() {});
	seajs.use("${my}/js/templateMng/templateCreate/main", 
		function(main) {
			main.init();
		});
</script>