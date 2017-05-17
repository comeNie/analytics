<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>

<style>
small {
	font-family: "Microsoft YaHei";
}
</style>
<div class="ajax-content">
	<div class="page-header">
		<h1>
			手工数据报送 <small> <i class="ace-icon fa fa-angle-double-right"></i>模板管理页面
			</small>
		</h1>
	</div>
	<!-- /.page-header -->
	<!-- 详情表 -->
	<div class="modal fade bs-example-modal-sm" data-backdrop="static"
		tabindex="-1">
	
		<table id="tb_q" class="table table-striped table-bordered table-hover">
			<tr>
				<td><span>报表编号：</span><input type="text" id="reportCode" /></td>
				<td><span>报表名称：</span><input type="text" id="reportName" /></td>
			</tr>
			<tr>
				<td><span>报表周期：</span><input type="text" id="reportCycle" /></td>
				<td><span>报送时限：统计周期后</span> <input type="number" id="timeLimit"
					style="width: 50px;" /><span> 天以内</span></td>
			</tr>
			<tr>
				<!-- <td><span>填报机构：</span>
					<input type="text" id="submitOrg" />
				</td> -->
				<td width=""><span>填报机构：</span><select id="submitOrg"></select></td>
				<td><span>查阅部门：</span><input type="text" id="checkRole" /></td>
			</tr>
			<tr>
				<td><span>汇总方式：</span><input type="text" id="sumType" /></td>
				<td><span>报表模板：</span><input type="text" id="path" /></td>
			</tr>
		</table>
	</div>
	<!-- 查看 -->
	<div id="lookTemplate" class="modal fade bs-example-modal-sm"
		data-backdrop="static" tabindex="-1">
		<div class="modal-dialog" style="width: 800px">
			<div class="modal-content">
				<div class="modal-header">
					<button id="close-detail" type="button" class="close"
						data-dismiss="modal">&times;</button>
					<h4 class="blue bigger">
						<i class="glyphicon glyphicon-eye-open"></i> 模板查询
					</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-20" id="div-search"
							style="padding: 0px 0px 0px 0px;"></div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" role="download" id="download-detail"
						class="btn btn-info btn-sm" title="下载" data-dismiss="modal">
						<i class="glyphicon glyphicon-save">下载</i>
					</button>
					<button id="btn-concel-detail" name="btn-cancel" type="button"
						class="btn btn-sm btn-default btn-cancel" data-dismiss="modal">
						<i class="fa fa-power-off"></i> 关闭
					</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 模板调整 -->
	<div id="templateAdjust" class="modal fade bs-example-modal-sm"
		data-backdrop="static" tabindex="-1">
		<div class="modal-dialog" style="width: 800px">
			<div class="modal-content">
				<div class="modal-header">
					<button id="close-adjust" type="button" class="close"
						data-dismiss="modal">&times;</button>
					<h4 class="blue bigger">
						<i class="glyphicon glyphicon-wrench"></i> 模板调整
					</h4>
				</div>
				<div>
					<h5 align="center">
						<button role="btn-adjust" value="7" type="button"
							id="suspendExcute" class="btn btn-info btn-sm">暂停执行</button>
						&nbsp;&nbsp;&nbsp;
						<button role="btn-adjust" value="5" type="button"
							id="recoverExcute" class="btn btn-info btn-sm">恢复执行</button>
						&nbsp;&nbsp;&nbsp;
						<button role="btn-adjust" value="6" type="button" 
							id="endExcute" class="btn btn-info btn-sm">终止执行</i>
						</button>
					</h5>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-20" id="div-adjust"
							style="padding: 0px 0px 0px 0px;"></div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" role="download" id="download-adjust"
						class="btn btn-info btn-sm" title="下载" data-dismiss="modal">
						<i class="glyphicon glyphicon-save">下载</i>
					</button>
					<button id="btn-concel-adjust" name="btn-cancel" type="button"
						class="btn btn-sm btn-default btn-cancel" data-dismiss="modal">
						<i class="fa fa-power-off"></i> 关闭
					</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-xs-12">
	
			<div class="row">
				<!-- row -->
				<div class="col-xs-12">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-1">模板创建开始日期：</label> <span
								class="input-icon input-icon-right"> <input
								id="begin-time" type="text" readonly="readonly"
								placeholder="请选择创建开始日期" value="${beginTime}"> <i
								class="ace-icon fa fa-calendar"></i>
							</span>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-1">模板创建截止日期：</label> <span
								class="input-icon input-icon-right"> <input id="end-time"
								type="text" placeholder="请选择创建截止日期" value="" readonly="readonly">
								<i class="ace-icon fa fa-calendar"></i>
							</span>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">模板状态：</label>
							<select name="template-status" id="template-status"
								class="col-xs-8 col-sm-4" style="width: 185px">
								<option value="">--请选择--</option>
								<option value="1">未提交</option>
								<option value="2">部门审核</option>
								<option value="3">统计组审核</option>
								<option value="4">负责人审核</option>
								<option value="9">模板发布</option>
								<option value="5">报表收集（已发布）</option>
								<option value="6">已失效</option>
								<option value="7">暂停执行</option>
								<option value="8">已退回</option>
							</select>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">报表周期：</label>
							<select name="cycle" id="report-cycle" class="col-xs-8 col-sm-4"
								style="width: 185px">
								<option value="" >--请选择--</option>
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
								for="form-field-1">报表名称：</label> <input type="text"
								id="report-name" name="reportName" value="" style="width: 185px" />
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
							<button type="button" id="btn-create" role="create"
								class="btn btn-success btn-sm"
								style="float: right; display: none;">
								<i class="glyphicon glyphicon-plus">创建模板 </i>
							</button>
							<input type="hidden" id="loginName" name="loginName" value="${loginName}">
						</div>
						</div>
					</form>
				</div>
			</div>
			
			<div class="row">
				<!-- row -->
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<div class="row">
						<div class="col-xs-12">
							<table id="tbl"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>序号</th>
										<th>报表名称</th>
										<th>报表周期</th>
										<th>创建日期</th>
										<th>创建人</th>
										<th>审核人</th>
										<th>状态</th>
										<th id="operate">操作</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- end row -->
<!-- SCRIPT -->
<script src="${res}/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="${res}/js/date-time/bootstrap-datepicker-cn.js"></script>
<script src="${res}/js/date-time/bootstrap-timepicker.min.js"></script>
<script src="${res}/js/date-time/daterangepicker.min.js"></script>
<script type="text/javascript">
	/* location.reload(); */
	ace.load_ajax_scripts([], function() {
	});
	seajs.use("${my}/js/templateMng/main/main", function(main) {
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
<!-- /SCRIPT -->