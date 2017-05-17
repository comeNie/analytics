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
					for="form-field-1">请选择统计年月：</label>
				<div class="col-sm-9">
					<select class="col-xs-10 col-sm-3" name="year" id="year">
						<optgroup label="年份">
							<option value="2010">2010年</option>
							<option value="2011">2011年</option>
							<option value="2012">2012年</option>
							<option value="2013">2013年</option>
							<option value="2014">2014年</option>
							<option value="2015">2015年</option>
							<option value="2016">2016年</option>
						</optgroup>
					</select> <select class="col-xs-10 col-sm-2" name="month" id="month">
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
					<input id="orgCodeId" type="hidden" name="orgCodeId" value="${orgId}" >
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
	var now = new Date();
	$('#year').val(now.getFullYear());
	var init_month = now.getMonth() + 1;
	$('#month').val(init_month < 10 ? ('0' + init_month) : (init_month + ''));
	$("#query").click(function() {
		var orgIds = $('#orgsId').val();
		var year = $('#year').val();
		var month = $('#month').val();
		var date = new Date();
		date.setDate(date.getDate() + 10);
		document.cookie = "orgId="+orgIds+";expires=" + date.toGMTString();
		document.cookie = "year="+year+";expires=" + date.toGMTString();
		document.cookie = "month="+month+";expires=" + date.toGMTString();
	var orgId="";
		var orgCodeId=$('#orgCodeId').val();
		if(orgCodeId=='10001'){
		   orgId = $('#orgsId').val();
		utils.openReport("${menu.url}",null,null,orgId,null,year,month);
		}else{
		   if($('#orgsId').val()!=null&&$('#orgsId').val()!=''){
		   orgId = $('#orgsId').val();
		utils.openReport("${menu.url}",null,null,orgId,null,year,month);
		   }else{
		   $.post("${ctx}/bizReport/loadOrgDeptsData",function(r,status){
		     if (status == "success") {
                  $.each(r,function(i,item){
                  orgId=orgId+item.id+',';
                  });
                  orgId=orgId.substring(0,orgId.length-1);
		utils.openReport("${menu.url}",null,null,orgId,null,year,month);
		     }
		   });
		      }    
		}

	});

	$.post("${ctx}/bizReport/loadOrgDeptsData", function(r, status) {
		if (status == "success") {
			var ids = [];//机构
			var xds = [];//小贷
			var $$premLevel = ${user.premLevel};
			if ($$premLevel == '1') {
				$("<option value='' selected>全部</option>").appendTo(
						".ch-select");
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
					$("#startDate").val(temp[1].substr(0,10));
				}else if(temp[0].trim() == "endDate"){
					$("#endDate").val(temp[1].substr(0,10));
				}else if(temp[0].trim() == "year"){
					$("#year").val(temp[1]);
				}else if(temp[0].trim() == "month"){
					$("#month").val(temp[1]);
				}
			}
			$.each(r, function(i, item) {
				$("<option value='"+item.id+"'>" + item.desc + "</option>")
						.appendTo(".ch-select");
				if (item.id.substring(0, 1) == 6) {
					xds.push(item.id);
				}
				ids.push(item.id);
			});
			$("#orgsId").val(selectedIds);
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
			//所有机构
			$("#all-jg-select").click(function() {
				$("#orgsId").val(ids);
				$("#orgsId").trigger("chosen:updated");
			})
			//所有小贷
			$("#all-xd-select").click(function() {
				$("#orgsId").val(xds);
				$("#orgsId").trigger("chosen:updated");
			})

			//全不选
			$("#del-select").click(function() {
				$("#orgsId").val([]);
				$("#orgsId").trigger("chosen:updated");
			})

			//重置
			$("#reset").click(function() {
				$("#orgsId").val([]);
				$("#orgsId").trigger("chosen:updated");
			});
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