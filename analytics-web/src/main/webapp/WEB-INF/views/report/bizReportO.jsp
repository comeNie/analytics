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
					for="form-field-1">请选择统计机构：</label>
				<div class="col-sm-9">
					<select data-placeholder=" " class="col-xs-10 col-sm-5 org-select"
						name="orgsId" id="orgsId">
						<optgroup label="请选择统计机构"></optgroup>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1">请选择转出资产包：</label>
				<div class="col-sm-9">
					<select data-placeholder=" " multiple
						class="col-xs-10 col-sm-5 ch-select" name="apksId" id="apksId">
						<optgroup label="请选择转出资产包"></optgroup>
					</select> <a href="javascript:void(0);" id="apks_all-select" title="全选"><i
						class="ace-icon glyphicon glyphicon-ok"></i></a> <a
						href="javascript:void(0);" id="apks_del-select" title="取消"><i
						class="ace-icon glyphicon glyphicon-remove"></i></a>
				</div>
			</div>
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
						value="${now}" readonly="readonly"> <i
						class="ace-icon fa fa-calendar"></i>
					</span>
				</div>
			</div>

			<div class="clearfix form-actions">
				<div id="buttonGroup" class="col-md-offset-3 col-md-9">
					<button class="btn btn-sm btn-purple" type="button" id="query">
						<i class="ace-icon fa fa-search bigger-110"></i> 查询
					</button>

					&nbsp; &nbsp; &nbsp;
					<button class="btn btn-sm btn-purple" type="reset" id="reset">
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
<script src="${res}/js/chosen.jquery.min.js"></script>
<link rel="stylesheet" href="${res}/css/chosen.css" type="text/css"></link>
<script type="text/javascript">
	// DO NOT REMOVE : GLOBAL FUNCTIONS!
	ace.load_ajax_scripts([], function() {
	})
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
		var orgId = $('#orgsId').val();
		var startDate = $('#startDate').val();
		var endDate = $('#endDate').val();
		var apksId = $('#apksId').val();
		var apks = new Array();
		if (apksId == null) {
			apks = "";
		} else {
			for (var i = 0; i < apksId.length; i++) {
				apks[i] = "<"+apksId[i]+">";
			}
		}
		var date = new Date();
		date.setDate(date.getDate() + 10);
		document.cookie = "orgSingleId="+orgId+";expires=" + date.toGMTString();
		document.cookie = "apksId="+apksId+";expires=" + date.toGMTString();
		document.cookie = "startDate="+startDate+";expires=" + date.toGMTString();
		document.cookie = "endDate="+endDate+";expires=" + date.toGMTString();
		utils.openReport("${menu.url}", startDate, endDate, orgId, apks);
	});

	$.post("${ctx}/bizReport/loadOrgDeptsData", function(r, status) {
		if (status == "success") {
			var ids = [];
			var $$premLevel = ${user.premLevel};
			if ($$premLevel == '1') {
				$("<option value='' selected>全部</option>").appendTo(
						".org-select optgroup");
			}
			$.each(r, function(i, item) {
				$("<option value='"+item.id+"'>" + item.desc + "</option>")
						.appendTo(".org-select optgroup");
				var arrStr = document.cookie.split(";");
				for(var i=0; i<arrStr.length; i++){
					var temp = arrStr[i].split("=");
					if(temp[0].trim() == "orgSingleId"){
						if(item.id == temp[1]){
							$("#orgsId").val(item.id);
						}
					}
				}
				ids.push(item.id);
			});
			var config = {
				'.org-select' : {},
				'.org-select-deselect' : {
					allow_single_deselect : true
				},
				'.org-select-no-single' : {
					disable_search_threshold : 10
				},
				'.org-select-no-results' : {
					no_results_text : 'Oops, nothing found!'
				},
				'.org-select-width' : {
					width : "100%"
				}
			}
			for ( var selector in config) {
				$(selector).chosen(config[selector]);
			}
			$('.org-select').addClass('tag-input-style');
			//全选
			$("#all-select").click(function() {
				$("#orgsId").val(ids);
				$("#orgsId").trigger("chosen:updated");
			})
			//全不选
			$("#del-select").click(function() {
				$("#orgsId").val([]);
				$("#orgsId").trigger("chosen:updated");
			})
		}
	}, "json");

	$.post("${ctx}/bizReport/loadApksData", function(r, status) {
		if (status == "success") {
			var ids = [];
			var apksIds = [];
			var arrStr = document.cookie.split(";");
			for(var i=0; i<arrStr.length; i++){
				var temp = arrStr[i].split("=");
				var arr = temp[1].split(",");
				if(temp[0].trim() == "apksId"){
					for(var j=0; j<arr.length; j++){
						apksIds.push(arr[j]);
					}
				}else if(temp[0].trim() == "startDate"){
					$("#startDate").val(temp[1]);
				}else if(temp[0].trim() == "endDate"){
					$("#endDate").val(temp[1].substr(0,10));
				}else if(temp[0].trim() == "year"){
					$("#year").val(temp[1].substr(0,10));
				}
			}
			$.each(r, function(i, item) {
				$("<option value='"+item.id+"'>" + item.name + "</option>")
						.appendTo(".ch-select optgroup");
				ids.push(item.id);
			});
			$("#apksId").val(apksIds);
			var config = {
				'.ch-select' : {},
				'.ch-select-deselect' : {
					allow_single_deselect : true
				},
				'.ch-select-no-single' : {
					disable_search_threshold : 10
				},
				'.ch-select-no-results' : {
					no_results_text : 'Oops, nothing found!'
				},
				'.ch-select-width' : {
					width : "100%"
				}
			}
			for ( var selector in config) {
				$(selector).chosen(config[selector]);
			}
			$('.ch-select').addClass('tag-input-style');
			//全选
			$("#apks_all-select").click(function() {
				$("#apksId").val(ids);
				$("#apksId").trigger("chosen:updated");
			})
			//全不选
			$("#apks_del-select").click(function() {
				$("#apksId").val([]);
				$("#apksId").trigger("chosen:updated");
			})
			//重置
			$("#reset").click(function() {
				$("#orgsId").val([ '' ]);
				$("#orgsId").trigger("chosen:updated");
				$("#apksId").val([]);
				$("#apksId").trigger("chosen:updated");
			});
		}
	}, "json");
</script>