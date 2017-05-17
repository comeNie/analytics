<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>

<style>
small {
	font-family: "Microsoft YaHei";
}
</style>
<div class="ajax-content">
	<div class="page-header">
		<h1>
			分析报告 <small> <i class="ace-icon fa fa-angle-double-right"></i>报告管理</small>
		</h1>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="row">
				<div class="col-xs-12">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="name">报告周期：</label>
							<div class="col-sm-8">
								<select class="col-xs-10 col-sm-2" name="year" id="year">
									<option value=""></option>
									<option value="2014">2014年</option>
									<option value="2015">2015年</option>
									<option value="2016">2016年</option>
								</select>
								<select class="col-xs-10 col-sm-2" name="month" id="month">
									<option value=""></option>
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
								</select>
								<select class="col-xs-10 col-sm-2" name="tenDays" id="tenDays" >
									<option value=""></option>
									<option value="01">上旬</option>
									<option value="02">中旬</option>
									<option value="03">下旬</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="name"> 报告名称：</label>
							<div class="col-sm-3">
								<div class="clearfix">
									<select id="reportName" class="form-control" name="reportName" value="">
										<option value=""></option>
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
							<label class="col-sm-3 control-label no-padding-right" for="name">创建人：</label>
							<div class="col-sm-3">
								<input type="text" id="submitPersonName" name="submitPersonName" value="" />
							</div>
						</div>
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								<button type="button" id="btn-search" class="btn btn-sm btn-purple">
									<i class="glyphicon glyphicon-search"> 查询</i>
								</button>
								&nbsp; &nbsp; &nbsp;
								<button type="reset" role="reset" class="btn btn-sm">
									<i class="ace-icon fa fa-undo bigger-110"> 重置 </i>
								</button>
								<button type="button" id="btn-create" role="create" class="btn btn-success btn-sm" style="float: right;">
									<i class="glyphicon glyphicon-plus">创建报告 </i>
								</button>
								<input type="hidden" id="loginName" name="loginName" value="${loginName}">
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<div class="row">
						<div class="col-xs-12">
							<table id="tbl" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>序号</th>
										<th width="20%">报告机构</th>
										<th>报告周期</th>
										<th>报告名称</th>
										<th>创建人</th>
										<th>创建人机构</th>
										<th>创建时间</th>
										<th id="operate" width="5%">操作</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div id="condition-win" class="modal" data-backdrop="static" tabindex="-1">
				<div class="modal-dialog">
					<div class="modal-content">
						<form id="condition-form" class="form-horizontal" role="form" method="post">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="blue bigger"> 查看摘要</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group">
											<label class="col-sm-1 control-label no-padding-right" for="form-field-1"> 摘要 </label>
											<div class="col-sm-8">
												<textarea name="description" id="description" rows="5" cols="65"></textarea>
											</div>
											<input type="hidden" id="mobileId" value=""/>
										</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button id="btn-doSearch" type="button" class="btn btn-sm btn-primary">
									<i class="ace-icon fa fa-search"></i> 保存
								</button>
								<!-- <button type="button" class="btn btn-sm" data-dismiss="modal">
									<i class="ace-icon fa fa-times"></i> 取消
								</button> -->
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="${res}/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="${res}/js/date-time/bootstrap-datepicker-cn.js"></script>
<script src="${res}/js/date-time/bootstrap-timepicker.min.js"></script>
<script src="${res}/js/date-time/daterangepicker.min.js"></script>
<script type="text/javascript">
	ace.load_ajax_scripts([], function() {
	});
	seajs.use("${my}/js/mobileReportMng/main/main", function(main) {
		$("#begin-time").datepicker({
			minView : "month", //选择日期后，不会再跳转去选择时分秒 
			format : "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
			language : 'zh-CN', //汉化 
			autoclose : true
		//选择日期后自动关闭 
		});
		$("#end-time").datepicker({
			minView : "month", //选择日期后，不会再跳转去选择时分秒 
			format : "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
			language : 'zh-CN', //汉化 
			autoclose : true
		//选择日期后自动关闭 
		});
		main.init();
	});
</script>