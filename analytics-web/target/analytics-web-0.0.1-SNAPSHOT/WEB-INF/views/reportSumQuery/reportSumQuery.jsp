<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>
<style>
	small {
		font-family: "Microsoft YaHei";
	}
</style>

<div class="page-header">
	<h1>
		手工数据报送 <small> <i class="ace-icon fa fa-angle-double-right"></i>数据报送
			<i class="ace-icon fa fa-angle-double-right"></i>报送数据汇总 <i
			class="ace-icon fa fa-angle-double-right"></i>汇总统计查询
		</small>
	</h1>
</div>

<div class="ajax-content">
	<div class="row">
		<div class="col-xs-12">
			<div class="row">
				<div class="col-xs-12">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="form-field-1">报表发起开始日期：</label>
							<span class="input-icon input-icon-right"> 
								<input id="startTime" type="text" readonly="readonly" placeholder="请选择开始日期">
								<i class="ace-icon fa fa-calendar"></i>
							</span>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="form-field-1">报表发起结束日期：</label>
							<span class="input-icon input-icon-right">
								<input id="endTime" type="text" readonly="readonly" placeholder="请选择结束日期">
								<i class="ace-icon fa fa-calendar"></i>
							</span>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="form-field-1">机构名称：</label>
							<input type="text" id="orgName" name="orgName" value="" style="width: 185px" />
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="form-field-1">报表名称：</label>
							<input type="text" id="reportName" name="reporName" value="" style="width: 185px" />
						</div>

						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								<button type="button" id="query" class="btn btn-sm btn-purple" role="query">
									<i class="glyphicon glyphicon-search"> 查询</i>
								</button>
								&nbsp; &nbsp; &nbsp;
								<button type="reset" role="reset" class="btn btn-sm">
									<i class="ace-icon fa fa-undo bigger-110"> 重置 </i>
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<table id="tbl" class="table table-striped table-hover">
						<thead>
							<tr>
								<th>机构名称</th>
								<th>报表名称</th>
								<th>发起日期</th>
								<th>首次报送日期</th>
								<th>最后报送日期</th>
								<th>报送次数</th>
								<th>迟报天数</th>
								<th>填报人</th>
								<th>审核人</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- end row -->
<script src="${res}/js/chosen.jquery.min.js"></script>

<script src="${res}/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="${res}/js/date-time/bootstrap-datepicker-cn.js"></script>
<script src="${res}/js/date-time/bootstrap-timepicker.min.js"></script>
<script src="${res}/js/date-time/daterangepicker.min.js"></script>
<script type="text/javascript">
	ace.load_ajax_scripts([], function() {
	});
	
	seajs.use("${my}/js/reportSumQuery/main", function(main) {
		main.init();
	});
</script>
<!-- /SCRIPT -->