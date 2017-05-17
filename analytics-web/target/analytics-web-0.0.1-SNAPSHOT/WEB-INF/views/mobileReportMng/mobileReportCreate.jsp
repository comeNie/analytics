<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			分析报告<small> <i class="ace-icon fa fa-angle-double-right"></i>
				新建报告
			</small>
		</h1>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<form action="${ctx}/mobileReport/saveReportData" class="form-horizontal" id="reportForm" name="reportForm" method="post" enctype="multipart/form-data" >
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="name"> 报告名称<span class="red">*</span></label>
					<div class="col-sm-4">
						<div class="clearfix">
							<select id="reportName" class="form-control" name="reportName" value="">
								<option value="1">月度分析报告</option>
								<option value="2">全辖月度通报分析</option>
								<option value="3">旬度报告</option>
								<option value="4">风险报告</option>
								<option value="5">财务报告</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="name"> 报告机构<span class="red">*</span></label>
					<div class="col-sm-4">
						<div class="clearfix">
							<select id="belongsOrgId" class="form-control" name="orgIds" value="">
								<option value="10001">邦信惠融投资控股股份有限公司</option>
								<c:forEach items="${orgIds }" var="org">
									<option value="${org.id }">${org.name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
<!-- 				<div class="form-group"> -->
<!-- 					<label class="col-sm-2 control-label no-padding-right" for="name"> 报告机构<span class="red">*</span></label> -->
<!-- 					<div class="col-sm-8"> -->
<!-- 						<select data-placeholder=" " multiple class="col-xs-10 col-sm-6 ch-orgselect" name="orgIds" id="belongsOrgId"> -->
<!-- 							<optgroup label="请选择机构"></optgroup> -->
<!-- 						</select> -->
<!-- 						<a href="javascript:void(0);" id="orgs_all-select" title="全选"><i class="ace-icon glyphicon glyphicon-ok"></i></a> -->
<!-- 						<a href="javascript:void(0);" id="orgs_del-select" title="取消"><i class="ace-icon glyphicon glyphicon-remove"></i></a> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="name">报告周期<span class="red">*</span></label>
					<div class="col-sm-8">
						<select class="col-xs-10 col-sm-2" name="year" id="year">
							<optgroup label="年份">
								<option value="2014">2014年</option>
								<option value="2015">2015年</option>
								<option value="2016">2016年</option>
							</optgroup>
						</select>
						<select class="col-xs-10 col-sm-2" name="month" id="month">
							<optgroup label="月份">
								<option value="01">1月</option>
								<option value="02">2月</option>
								<option value="03">3月</option>
								<option value="04">4月</option>
								<option value="05">5月</option>
								<option value="06">6月</option>
								<option value="07">7月</option>
								<option value="08">8月</option>
								<option value="09">9月</option>
								<option value="10">10月</option>
								<option value="11">11月</option>
								<option value="12">12月</option>
							</optgroup>
						</select>
						<select class="col-xs-10 col-sm-2" name="tenDays" id="tenDays" disabled="disabled">
							<optgroup label="旬度">
								<option value="00">无</option>
								<option value="01">上旬</option>
								<option value="02">中旬</option>
								<option value="03">下旬</option>
							</optgroup>
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="name"> 摘要<span class="red">*</span></label>
					<div class="col-sm-8">
						<textarea name="description" id="description" rows="3" cols="42"></textarea>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="name"> 上传文件<span class="red">*</span></label>
					<div class="form-group">
						<div class="col-sm-4">
							<div class="fileInput left">
					          <input type="file" multiple="" name="uploadFile" id="uploadFile" class="upfile" onchange="getPath()" style="position:absolute;left:47px;line-height:34px;filter:alpha(opacity=0); opacity:0"/>
					          <input class="upFileBtn" type="button" value="上传文档" onclick="document.getElementById('uploadFile').click()" />
					        </div>
							<label id="filenameOfliulan" style="position:absolute;left:115px;top:8px;background:#fff;z-index:999">
								<input type="hidden" name="file-format" id="id-file-format" class="ace" /><span id="filePath"></span>
							</label>
						</div>
					</div>
				</div>
				<div class="clearfix form-actions">
					<div class="col-md-offset-4  col-md-6">
						<button id="save" class="btn btn-sm btn-success" type="button" role="save">
							<i class="ace-icon fa fa-check"></i>保存
						</button>
						<button class="btn btn-sm btn-default" type="button" onclick="javascript:history.go(-1);">
							<i class="ace-icon fa fa-arrow-left"></i>返回
						</button>
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
	ace.load_ajax_scripts([], function() {})
	$.post("${ctx}/mobileReport/loadOrgDepts",function(orgr,status){
		if (status == "success") {
			var orgids=[];
			var id = $("#id").val();
			if(id != null&&id != ''){
			   var belongsOrgIdValue = $("#belongsOrgIdValue").val();
			   var orgStr = belongsOrgIdValue.split(",");
			   $.each(orgr,function(i,orgitem){
				   $("<option value='"+orgitem.id+"'>"+ orgitem.name+"</option>").appendTo(".ch-orgselect optgroup");
					for(var i=0;i<orgStr.length;i++){
						if(orgitem.id == orgStr[i]){
							orgids.push(orgitem.id);
						}
					}
				});
				$('#belongsOrgId').val(orgids);
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
				$("#belongsOrgId").val(orgids);
				$("#belongsOrgId").trigger("chosen:updated");
			});
			//全不选
			$("#orgs_del-select").click(function(){
				$("#belongsOrgId").val([]);
				$("#belongsOrgId").trigger("chosen:updated");
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
	seajs.use("${my}/js/mobileReportMng/mobileReportCreate/main", 
		function(main) {
			$("#busiDate").datepicker({
				minView : "month", //选择日期后，不会再跳转去选择时分秒 
				format : "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
				language : 'zh-CN', //汉化 
				//dateFormat: 'yy-mm',
				autoclose : true
			//选择日期后自动关闭 
			});
			main.init();
		});
</script>