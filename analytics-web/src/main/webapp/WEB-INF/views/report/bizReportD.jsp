<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>
<%@include file="../commons/page_header.jsp"%>
<div class="ajaxContent">
<div class="row">
	<div class="col-xs-12">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1">请选择统计开始日期：</label>
				<div class="col-sm-9">
					<span class="input-icon input-icon-right"> <input
						id="startDate" type="text" id="form-field-2"
						placeholder="请选择统计开始日期" value="${now}" readonly="readonly">
						<i class="ace-icon fa fa-calendar"></i>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1">请选择统计结束日期：</label>
				<div class="col-sm-9">
					<span class="input-icon input-icon-right"> <input
						id="endDate" type="text" id="form-field-2" placeholder="请选择统计结束日期"
						value="" readonly="readonly"> <i
						class="ace-icon fa fa-calendar"></i>
					</span>
				</div>
			</div>
			<div class="clearfix form-actions">
				<div id="buttonGroup" class="col-md-offset-3 col-md-9">
					<button id="query" class="btn btn-sm btn-purple" type="button"
						role="query">
						<i class="ace-icon fa fa-search bigger-110"></i> 查询
					</button>
					&nbsp; &nbsp; &nbsp;
					<button class="btn btn-sm btn-purple" type="reset">
						<i class="ace-icon fa fa-undo bigger-110"></i> 重置
					</button>
					&nbsp; &nbsp; &nbsp; <a id="reportId" class="btn btn-sm btn-purple">
						<i class="glyphicon glyphicon-book"></i> 指标说明
					</a>
					&nbsp; &nbsp; &nbsp; <a id="storeId" class="btn btn-sm btn-purple"> <i
						class="glyphicon glyphicon-inbox"></i> 添加收藏
					</a>
					&nbsp; &nbsp; &nbsp; <a id="cancelStore" class="btn btn-sm btn-purple"> <i
						class="glyphicon glyphicon-inbox"></i> 取消收藏
					</a>
					&nbsp; &nbsp; &nbsp; <a id="analysisId" class="btn btn-sm btn-purple"> <i
						class="glyphicon glyphicon-inbox"></i> 多维分析
					</a>
					&nbsp; &nbsp; &nbsp; <a id="detailQueryId" class="btn btn-sm btn-purple"> <i
						class="glyphicon glyphicon-inbox"></i> 明细查询
					</a>
				</div>
			</div>
		</form>
	</div>
</div>
<%@include file="../reportShows/reportShows.jsp"%>
</div>
<script type="text/javascript">
	// DO NOT REMOVE : GLOBAL FUNCTIONS!
	ace.load_ajax_scripts([], function() {
	})
	var arrStr = document.cookie.split(";");
			for(var i=0; i<arrStr.length; i++){
				var temp = arrStr[i].split("=");
				if(temp[0].trim() == "startDate"){
					$("#startDate").val(temp[1]);
				}else if(temp[0].trim() == "endDate"){
					$("#endDate").val(temp[1]);
				}
			}
	$('#startDate').datepicker({
		format : 'yyyy-mm-dd',
		autoclose : true
	}).on("changeDate", function(ev) {
		$("#endDate").datepicker("setStartDate", ev.date ? ev.date : "");

	});
	$('#endDate').datepicker({
		format : 'yyyy-mm-dd',
		autoclose : true
	}).on("changeDate", function(ev) {
		$("#startDate").datepicker("setEndDate", ev.date ? ev.date : "");

	});
	$("#query").click(function() {
		var startDate = $('#startDate').val();
		var endDate = $('#endDate').val();
		var date = new Date();
		date.setDate(date.getDate() + 10);
		document.cookie = "startDate="+startDate+";expires=" + date.toGMTString();
		document.cookie = "endDate="+endDate+";expires=" + date.toGMTString();
		utils.openReportOfSingleOrg("${menu.url}", startDate, endDate);
	});
</script>