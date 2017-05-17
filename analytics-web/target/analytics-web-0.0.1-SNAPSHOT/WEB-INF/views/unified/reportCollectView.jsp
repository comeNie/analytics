<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../commons/res/taglibs.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>综合统计系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<c:import url="../commons/res/css.jsp" />
		<script>var $$ctx = '${ctx}';var $$res = '${res}';var $$my = '${my}';</script>
	</head>
	<body class="no-skin">
		<!-- 内容开始 -->
		<div class="main-container" id="main-container">
			<div class="main-content">
				<div class="page-content">
					<div class="page-header">
						<h1>
							手工数据报送流程
							<small>
								<i class="ace-icon fa fa-angle-double-right"></i>报表收集
							</small>
						</h1>
					</div><!-- /.page-header -->
					<div class="widget-box transparent">
						<div class="widget-header widget-header-flat">
							<h4 class="widget-title lighter">
								<i class="ace-icon fa fa-signal"></i>
								基本信息
							</h4>
							<div class="widget-toolbar">
								<a href="#" data-action="collapse">
									<i class="ace-icon fa fa-chevron-up"></i>
								</a>
							</div>
						</div>
						<div class="widget-body">
							<div class="widget-main padding-4">
								<div class="row">
									<div class="col-xs-12">
										<form class="form-horizontal" role="form">
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-field-1">报表编号：</label>
												<div class="col-sm-4">
													<input type="text" id="no" name="no" class="form-control" maxlength="33" readonly="readonly"/>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-field-1">报表名称：</label>
												<div class="col-sm-4">
													<input type="text" id="name" name="name" class="form-control" maxlength="33" readonly="readonly"/>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-field-1">报表周期：</label>
												<div class="col-sm-4">
													<input type="text" id="cycle" name="cycle" class="form-control" maxlength="33" readonly="readonly"/>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-field-1">报送日期：</label>
												<div class="col-sm-4">
													<input type="text" id="sub_time" name="sub_time" class="form-control" maxlength="33" readonly="readonly"/>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-field-1">汇总方式：</label>
												<div class="col-sm-4">
													<input type="text" id="sum_type" name="sum_type" class="form-control" maxlength="33" readonly="readonly"/>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-field-1">查阅部门：</label>
												<div class="col-sm-4">
													<input type="text" id="org" name="org" class="form-control" maxlength="33" readonly="readonly"/>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-field-1">汇总状态：</label>
												<div class="col-sm-4">
													<input type="text" id="status" name="status" class="form-control" maxlength="33" readonly="readonly"/>
													<input id="templatePath" name="templatePath" class="form-control" maxlength="100" type="hidden" />
													<input id="reportSumPath" name="reportSumPath" class="form-control" maxlength="100" type="hidden" />
												</div>
											</div>
										</form>
															<!-- 查看意见 -->
					<div id="detailModal" class="modal fade bs-example-modal-sm" data-backdrop="static" tabindex="-1">
						<div class="modal-dialog" style="width: 800px">
							<div class="modal-content">
								<div class="modal-header">
									<button id="close-detail" type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="blue bigger">
										<i class="glyphicon glyphicon-eye-open"></i> 意见记录
									</h4>
								</div>
								<div class="modal-body">
									<div class="row">
										<div class="col-xs-20" id="div-search" style="padding: 0px 0px 0px 0px;">
											<div class="timeline-container">
												<div class="timeline-label">
													<span class="label label-primary arrowed-in-right label-lg">过程意见</span>
												</div>
												<div class="timeline-items" id="wfDetailWarp">
													<div class="timeline-item clearfix">
														<div class="timeline-info">
															<i class="timeline-indicator ace-icon fa fa-hand-o-right btn btn-success no-hover"></i>
														</div>
														<div class="widget-box transparent">
															<div class="widget-header widget-header-small">
																<h5 class="widget-title smaller">
																	<span class="grey">录入业务申请信息</span>
																</h5>
																<span class="widget-toolbar no-border">
																	<i class="ace-icon fa fa-clock-o bigger-110"></i>2014-08-29 16:22
																</span>
															</div>
															<div class="widget-body">
																<div class="widget-main">无审批意见</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button id="btn-concel-detail" role="btn-concel-detail" name="btn-cancel" type="button" class="btn btn-sm btn-default btn-cancel" data-dismiss="modal">
										<i class="fa fa-power-off"></i> 关闭
									</button>
								</div>
							</div>
						</div>
					</div>
										<div class="clearfix form-actions">
											<div id="actionButtonNext" class="col-md-offset-2 col-md-9" style="text-align: center;">
												<button id="query" class="btn btn-sm btn-purple" type="button" role="query">
													<i class="ace-icon fa fa-search bigger-110"></i> 查看汇总
												</button>
											<!--	&nbsp; &nbsp; &nbsp;
											 	<button id="summarize" class="btn btn-sm btn-pink"
													type="button" role="summarize">
													<i class="ace-icon fa fa-undo bigger-110"></i> 汇总
												</button>
												&nbsp; &nbsp; &nbsp; -->
											</div>
										</div>
										<div>
											<table id="tbl_cusmanager" class="table table-striped table-hover">
												<thead>
													<tr>
													<!--  	<th style="width: 40px;"><input type="checkbox" id="cusmanager_ck_all" /></th> -->
														<th style="width: 40px;">
														<th style="width: 100px;">报送机构</th>
														<th style="width: 100px;">报送状态</th>
														<th style="width: 150px;">报送日期</th>
														<th style="width: 100px;">操作</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
										<!-- PAGE CONTENT BEGINS -->
									</div>
								</div>
							</div><!-- /.widget-main -->
						</div><!-- /.widget-body -->
					</div><!-- /.widget-box -->
				</div><!-- /.page-content -->
			</div><!-- /.main-content -->
			<form id="redirectForm">
				<input type="hidden" id="workflowCode" value="${taskInfo.workflowCode}">
				<input type="hidden" id="workflowId" value="${taskInfo.workflowId}">
			</form>
			<input type="hidden" name="reportTemplateId" id="reportTemplateId" value="${reportTemplateId}" />
		</div><!-- /.main-container -->
		<!--<script type="x-tmpl-mustache" id="dt-user-operation">
			<div class="btn-group ">
				<input  type="checkbox" name="check_user_id" value="{{id}}">
			</div>
		</script> -->
		<script type="x-tmpl-mustache" id="dt-row-operation">
			<div class="btn-group">
				<button role='detail' data-orgid="{{orgId}}" data-id="{{id}}" class="btn btn-xs btn-info glyphicon glyphicon-eye-open" title="查看"></button>
			</div>
		</script>
		<script type="x-tmpl-mustache" id="dt-row-operation_hidden">
			<div class="btn-group">
				<input  data-orgid="{{orgId}}" data-id="{{id}}" class="btn btn-xs btn-info" title="" id="resendButton" type="hidden" />
                <input  data-file-path="{{path}}" class="btn btn-xs btn-info" title="" id="" type="hidden" />
			</div>
		</script>
		<!-- 内容结束 -->
		<jsp:include page="../commons/res/unified_js.jsp"></jsp:include>
		<script type="text/javascript">
			seajs.use('${my}/js/unified/reportCollectView/main');
		</script>
	</body>
</html>