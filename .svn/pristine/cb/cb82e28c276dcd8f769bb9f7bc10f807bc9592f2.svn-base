<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			class="ace-icon fa fa-angle-double-right"></i>报送结果查询
		</small>
	</h1>
</div>
<!-- /.page-header -->

<div class="ajax-content">
	<div class="row">
		<div class="col-xs-12">
			<div class="row">
				<!-- row -->
				<div class="col-xs-12">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-1">汇总发布开始日期：</label> <span
								class="input-icon input-icon-right"> <input
								id="sum-time-begin" type="text" readonly="readonly"
								placeholder="请选择发布开始日期"> <i
								class="ace-icon fa fa-calendar"></i>
							</span>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-1">汇总发布截止日期：</label> <span
								class="input-icon input-icon-right"> <input
								id="sum-time-end" type="text" readonly="readonly"
								placeholder="请选择发布结束日期"> <i
								class="ace-icon fa fa-calendar"></i>
							</span>
						</div>
						<!-- <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">模板状态：</label>
						<select name="template-status" id="template-status"
							class="col-xs-8 col-sm-4" style="width: 185px">
							<option value="">--请选择--</option>
							<option value="1">未提交</option>
							<option value="2">部门审核</option>
							<option value="3">统计组审核</option>
							<option value="4">负责人审核</option>
							<option value="5">已发布</option>
							<option value="6">已失效</option>
							<option value="7">正在执行</option>
							<option value="8">暂停执行</option>
						</select>
					</div> -->
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">报表周期：</label>
							<select name="cycle" id="report-cycle" class="col-xs-8 col-sm-4"
								style="width: 185px">
								<option value="" selected="selected">全部</option>
								<option value="1">一次性填报</option>
								<option value="2">年报</option>
								<option value="3">半年报</option>
								<option value="4">季报</option>
								<option value="5">月报</option>
								<option value="6">旬报</option>
								<option value="7">周报</option>
							</select>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-1">汇总发布人：</label> <input type="text"
								id="sum-people" name="sum_people" value="" style="width: 185px" />
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-1">报表名称：</label> <input type="text"
								id="report-name" name="repor_name" value="" style="width: 185px" />
						<input type="hidden" id="loginName" name="loginName" value="${loginName}">
						<input type="hidden" id="ifPassRole" name="ifPassRole" value="${ifPassRole}">
						</div>

						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								<button type="button" id="btn-search"
									class="btn btn-sm btn-purple">
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

			<!-- PAGE CONTENT BEGINS -->
			<div class="row">
				<div class="col-xs-12">
					<table id="tb_r" class="table table-striped table-hover">
						<thead>
							<tr>
								<th>序号</th>
								<th>报表名称</th>
								<th>报表周期</th>
								<th>汇总日期</th>
								<th>汇总人</th>
								<th>操作</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div id="passModal" class="modal fade bs-example-modal-sm" data-backdrop="static" tabindex="-1">
		<div class="modal-dialog" style="width: 600px">
			<div class="modal-content">
				<div class="modal-header">
					<button id="close-detail" type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="blue bigger">
						选择传阅用户
					</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-20" id="div-passName" style="padding: 0px 0px 0px 0px;">
						
						</div>
						<!-- <div class="col-sm-4">
							<input type = "hidden" id="passUserSelected" value="">
							<select data-placeholder=" " id="passUsers" class="col-xs-10 col-sm-12 passUsers-select" name="passUsers" multiple="multiple"></select>
						</div> -->
						
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-sm btn-primary" role="saveFunction">
						<i class="ace-icon fa fa-save"></i> 保存
					</button>
					<button  class="btn btn-sm" data-dismiss="modal">
						<i class="ace-icon fa fa-times"></i> 取消
					</button>
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
	seajs.use("${my}/js/reportResultQuery/main", function(main) {
		$("#sum-time-begin").datepicker({
			minView : "month", //选择日期后，不会再跳转去选择时分秒 
			format : "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
			language : 'zh-CN', //汉化 
			autoclose : true
		//选择日期后自动关闭 
		});
		$("#sum-time-end").datepicker({
			minView : "month", //选择日期后，不会再跳转去选择时分秒 
			format : "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
			language : 'zh-CN', //汉化 
			autoclose : true
		//选择日期后自动关闭 
		});
		main.init();
	});
</script>
<!-- /SCRIPT -->