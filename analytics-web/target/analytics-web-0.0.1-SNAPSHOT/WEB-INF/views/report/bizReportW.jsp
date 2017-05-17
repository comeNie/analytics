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
					<select data-placeholder=" " multiple
						class="col-xs-10 col-sm-5 chorg-select" name="orgsId" id="orgsId">
					</select>
					<a href="javascript:void(0);" id="all-select" title="全选">
						<i class="ace-icon glyphicon glyphicon-ok"></i>
					</a>
					<a href="javascript:void(0);" id="all-select-excTeam" title="全选(不含工作组)">
						<i class="ace-icon glyphicon glyphicon-edit"></i>
					</a>
					<a href="javascript:void(0);" id="del-select" title="取消">
						<i class="ace-icon glyphicon glyphicon-remove"></i>
					</a>
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
					for="form-field-1">请选择资金来源：</label>
				<div class="col-sm-9">
					<select data-placeholder=" " multiple
						class="col-xs-10 col-sm-5 chfund-select" name="fundId" id="fundId">
						<optgroup label="请选择资金来源"></optgroup>
					</select> <a href="javascript:void(0);" id="fund_all-select" title="全选"><i
						class="ace-icon glyphicon glyphicon-ok"></i></a> <a
						href="javascript:void(0);" id="fund_del-select" title="取消"><i
						class="ace-icon glyphicon glyphicon-remove"></i></a>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right"
					for="form-field-1">请选择统计结束日期：</label>
				<div class="col-sm-9">
					<span class="input-icon input-icon-right"> <input
						id="endDate" type="text" id="form-field-2" placeholder="请选择统计结束日期"
						value="${now}" readonly="readonly"> 
						<input id="orgCodeId" type="hidden" name="orgCodeId" value="${orgId}" >
						<i class="ace-icon fa fa-calendar"></i>
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
	$('#endDate').datepicker({format : 'yyyy-mm-dd',autoclose : true});
	$("#query").click(function() {
		var orgIds = $('#orgsId').val();
		var apksId = $('#apksId').val();
		var fundId = $('#fundId').val();
		var startDate = $('#startDate').val();
		var endDate = $('#endDate').val();
		var date = new Date();
		date.setDate(date.getDate() + 10);
		document.cookie = "orgId="+orgIds+";expires=" + date.toGMTString();
		document.cookie = "apksId="+apksId+";expires=" + date.toGMTString();
		document.cookie = "fundId="+fundId+";expires=" + date.toGMTString();
		document.cookie = "endDate="+endDate+";expires=" + date.toGMTString();
		var orgId="";
		var orgCodeId=$('#orgCodeId').val();
		
		var fundIds = new Array();
		if(fundId == null){
			fundIds= "";
		}else{
			for(var i =0;i<fundId.length;i++){
				fundIds[i]="<"+fundId[i]+">";
			}
		}
		
		if(orgCodeId=='10001'){
		   orgId = $('#orgsId').val();
		var apks = new Array();
		if(apksId == null){
			apks= "";
		}else{
			for(var i =0;i<apksId.length;i++){
				apks[i]="<"+apksId[i]+">";
			}
		}
		utils.openReport("${menu.url}",startDate,endDate,orgId,apks,null,null,fundIds);
		}else{
		   if($('#orgsId').val()!=null&&$('#orgsId').val()!=''){
		   orgId = $('#orgsId').val();
		var apks = new Array();
		if(apksId == null){
			apks= "";
		}else{
			for(var i =0;i<apksId.length;i++){
				apks[i]="<"+apksId[i]+">";
			}
		}
		utils.openReport("${menu.url}",startDate,endDate,orgId,apks,null,null,fundIds);
		   }else{
		   $.post("${ctx}/bizReport/loadOrgDeptsData",function(r,status){
		     if (status == "success") {
                  $.each(r,function(i,item){
                  orgId=orgId+item.id+',';
                  });
                  orgId=orgId.substring(0,orgId.length-1);
		var apks = new Array();
		if(apksId == null){
			apks= "";
		}else{
			for(var i =0;i<apksId.length;i++){
				apks[i]="<"+apksId[i]+">";
			}
		}
		utils.openReport("${menu.url}",startDate,endDate,orgId,apks,null,null,fundIds);
		     }
		   });
		      }    
		}
	});

	//重置
	$("#reset").click(function() {
		$("#orgsId").val([]);
		$("#orgsId").trigger("chosen:updated");
		$("#apksId").val([]);
		$("#apksId").trigger("chosen:updated");
		$('#fundId').val([]);
		$("#fundId").trigger("chosen:updated");
	});
	//统计机构
	$.post("${ctx}/bizReport/loadOrgDeptsData", function(r, status) {
		if (status == "success") {
			var ids = [];
			var $$premLevel = ${user.premLevel};
			if ($$premLevel == '1') {
				$("<option value='' selected>全部</option>").appendTo(".chorg-select");
			}
			var selectedIds = [];
			var arrStr = document.cookie.split(";");
			for(var i=0; i<arrStr.length; i++){
				var temp = arrStr[i].split("=");
				if(temp[0].trim() == "orgId"){
					var arr = temp[1].split(",");
					for(var j=0; j<arr.length; j++){
						selectedIds.push(arr[j]);
					}
				}else if(temp[0].trim() == "startDate"){
					$("#startDate").val(temp[1]);
				}else if(temp[0].trim() == "endDate"){
					$("#endDate").val(temp[1]);
				}else if(temp[0].trim() == "year"){
					$("#year").val(temp[1]);
				}
			}
			$.each(r, function(i, item) {
				$("<option value='"+item.id+"'>" + item.desc + "</option>")
						.appendTo(".chorg-select");
				ids.push(item.id);
			});
			$("#orgsId").val(selectedIds);
			var config = {
				'.chorg-select' : {},
				'.chorg-select-deselect' : {
					allow_single_deselect : true
				},
				'.chorg-select-no-single' : {
					disable_search_threshold : 10
				},
				'.chorg-select-no-results' : {
					no_results_text : 'Oops, nothing found!'
				},
				'.chorg-select-width' : {
					width : "100%"
				}
			}
			for ( var selector in config) {
				$(selector).chosen(config[selector]);
			}
			$('.chorg-select').addClass('tag-input-style');
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
				if(temp[0].trim() == "apksId"){
					var arr = temp[1].split(",");
					for(var j=0; j<arr.length; j++){
						apksIds.push(arr[j]);
					}
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
		}
	}, "json");
	
	$.post("${ctx}/bizReport/loadFundSource", function(r, status) {//资金来源
		if (status == "success") {
			var ids = [];
			var fundIds = [];
			var arrStr = document.cookie.split(";");
			for(var i=0; i<arrStr.length; i++){
				var temp = arrStr[i].split("=");
				if(temp[0].trim() == "fundId"){
					var arr = temp[1].split(",");
					for(var j=0; j<arr.length; j++){
						fundIds.push(arr[j]);
					}
				}
			}
			$.each(r, function(i, item) {
				$("<option value='"+item.id+"'>" + item.name + "</option>")
						.appendTo(".chfund-select optgroup");
				ids.push(item.id);
			});
			$("#fundId").val(fundIds);
			var config = {
				'.chfund-select' : {},
				'.chfund-select-deselect' : {
					allow_single_deselect : true
				},
				'.chfund-select-no-single' : {
					disable_search_threshold : 10
				},
				'.chfund-select-no-results' : {
					no_results_text : 'Oops, nothing found!'
				},
				'.chfund-select-width' : {
					width : "100%"
				}
			}
			for ( var selector in config) {
				$(selector).chosen(config[selector]);
			}
			$('.chfund-select').addClass('tag-input-style');
			//全选
			$("#fund_all-select").click(function() {
				$("#fundId").val(ids);
				$("#fundId").trigger("chosen:updated");
			})
			//全不选
			$("#fund_del-select").click(function() {
				$("#fundId").val([]);
				$("#fundId").trigger("chosen:updated");
			})
		}
	}, "json");
	//统计机构(不含工作组)
	$.post("${ctx}/bizReport/loadOrgDeptsDataExcTeam", function(r, status) {
		if (status == "success") {
			var ids = [];
			var $$premLevel = ${user.premLevel};
			if ($$premLevel == '1') {
// 				$("<option value='' selected>全部</option>").appendTo(".chorg-select");
			}
			var selectedIds = [];
			var arrStr = document.cookie.split(";");
			for(var i=0; i<arrStr.length; i++){
				var temp = arrStr[i].split("=");
				if(temp[0].trim() == "orgId"){
					var arr = temp[1].split(",");
					for(var j=0; j<arr.length; j++){
						selectedIds.push(arr[j]);
					}
				}else if(temp[0].trim() == "startDate"){
					$("#startDate").val(temp[1]);
				}else if(temp[0].trim() == "endDate"){
					$("#endDate").val(temp[1]);
				}else if(temp[0].trim() == "year"){
					$("#year").val(temp[1]);
				}
			}
			$.each(r, function(i, item) {
				/* $("<option value='"+item.id+"'>" + item.desc + "</option>")
						.appendTo(".chorg-select"); */
				ids.push(item.id);
			});
			$("#orgsId").val(selectedIds);
			var config = {
				'.chorg-select' : {},
				'.chorg-select-deselect' : {
					allow_single_deselect : true
				},
				'.chorg-select-no-single' : {
					disable_search_threshold : 10
				},
				'.chorg-select-no-results' : {
					no_results_text : 'Oops, nothing found!'
				},
				'.chorg-select-width' : {
					width : "100%"
				}
			}
			for ( var selector in config) {
// 				$(selector).chosen(config[selector]);
			}
			$('.chorg-select').addClass('tag-input-style');
			//全选(不含工作组)
			$("#all-select-excTeam").click(function() {
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
</script>