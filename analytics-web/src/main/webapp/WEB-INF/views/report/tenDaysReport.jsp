<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>
<%@include file="../commons/page_header.jsp"%>
<%@include file="../reportShows/reportShows.jsp"%><!-- 重要！添加/取消收藏,多维分析等功能均在其js中 add by wangxy -->
<div class="ajaxContent">
	<div class="row">
		<div class="col-xs-12">
			<form class="form-horizontal" role="form">
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">请选择统计年份：</label>
					<div class="col-sm-9">
						<select class="col-xs-10 col-sm-3" name="year" id="year" >
							<optgroup label="年份">
								<option value="2013">2013年</option>
								<option value="2014">2014年</option>
								<option value="2015">2015年</option>
								<option value="2016">2016年</option>
							</optgroup>
						</select>
						<input type="hidden" id="curYear" name="curYear" value="${curYear }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">请选择统计月份：</label>
					<div class="col-sm-9">
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
						<input type="hidden" id="curMonth" name="curMonth" value="${curMonth }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1">请选择统计旬度：</label>
					<div class="col-sm-9">
						<select class="col-xs-10 col-sm-2" name="decadDays" id="decadDays">
							<optgroup label="旬度">
								<option value="1">上旬</option>
								<option value="2">中旬</option>
								<option value="3">下旬</option>
							</optgroup>
						</select>
						<input type="hidden" id="curDecadDays" name="curDecadDays" value="${curDecadDays }">
					</div>
				</div>
				<div class="clearfix form-actions">
					<div class="col-md-offset-3 col-md-9">
						<button class="btn btn-sm btn-purple" type="button" id="queryForDownload">
							<i class="ace-icon fa fa-search bigger-110"></i> 查询
						</button>
						&nbsp; &nbsp; &nbsp;
						<button class="btn btn-sm" type="reset" id="reset">
							<i class="ace-icon fa fa-undo bigger-110"></i> 重置
						</button>
						&nbsp; &nbsp; &nbsp; 
						<a id="reportId" class="btn btn-sm btn-purple">
							<i class="glyphicon glyphicon-book"></i> 指标说明
						</a>
						&nbsp; &nbsp; &nbsp; 
						<a id="storeId" class="btn btn-sm btn-purple"> <i
							class="glyphicon glyphicon-inbox"></i> 添加收藏
						</a>
						&nbsp; &nbsp; &nbsp; 
						<a id="cancelStore" class="btn btn-sm btn-purple"> 
							<i class="glyphicon glyphicon-inbox"></i> 取消收藏
					    </a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<script src="${res}/js/chosen.jquery.min.js"></script>
<link rel="stylesheet" href="${res}/css/chosen.css" type="text/css"></link>

<script type="text/javascript">
	ace.load_ajax_scripts([], function() {
	})
	seajs.use("${my}/js/report/tenDaysReport/main", function(main) {
		main.init();
	});
</script>