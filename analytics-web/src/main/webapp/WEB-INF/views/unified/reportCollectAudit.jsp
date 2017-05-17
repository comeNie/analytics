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
					<div id="lookTemplate" class="modal fade bs-example-modal-sm" data-backdrop="static" tabindex="-1">
						<div class="modal-dialog" style="width: 800px">
							<div class="modal-content">
								<div class="modal-header">
									<button id="close-detail" role="close-detail" type="button" class="close"
										data-dismiss="modal">&times;</button>
									<h4 class="blue bigger">
										<i class="glyphicon glyphicon-eye-open"></i> 退回意见
									</h4>
								</div>
								<div class="modal-body">
									<div id="timeline-2">
										<div class="row">
											<div class="col-xs-8" style="height:150px">
												<div class="timeline-container timeline-style2">
													<!-- <span class="timeline-label"><b>审批意见</b></span> -->
													<div class="form-group2">
														<label for="inputInfo" class="col-xs-8 col-sm-2 control-label" style="margin-top: 10px;"></label>
														<div class="col-xs-8 col-sm-10" style="margin-left:-15px;margin-top: 10px;">
															<textarea id="resendComments" class="form-control" style="height: 110px;"></textarea>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button"  id="resendCommentsSubmit"
										class="btn btn-info btn-sm" title="提交" data-dismiss="modal">
										<i class="glyphicon glyphicon-ok-circle">提交</i>
									</button>
									<button id="btn-concel-detail" role="btn-concel-detail" name="btn-cancel" type="button"
										class="btn btn-sm btn-default btn-cancel" data-dismiss="modal">
										<i class="ace-icon fa fa-times"></i> 关闭
									</button>
								</div>
							</div>
						</div>
					</div>
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
										<!-- PAGE CONTENT BEGINS -->
										<div id="timeline-2">
											<div class="row">
												<div class="col-xs-4">
													<div class="timeline-container timeline-style2">
														<span class="timeline-label"><b>流程</b></span>
														<div class="timeline-items">
														<div class="timeline-item clearfix">
																<div class="timeline-info">
																	<span class="timeline-date"></span> <i
																		class="timeline-indicator btn btn-info no-hover"></i>
																</div>
																<div class="widget-box transparent">
																	<div class="widget-body">
																		<div class="widget-main no-padding">
																			<span nodeId="100611" class="green bolder">报表填写</span>
																		</div>
																	</div>
																</div>
															</div>
															<div class="timeline-item clearfix">
																<div class="timeline-info">
																	<span class="timeline-date"></span> <i class="timeline-indicator btn btn-info no-hover"></i>
																</div>
																<div class="widget-box transparent">
																	<div class="widget-body">
																		<div class="widget-main no-padding">
																			<span nodeId="100612" class="green bolder">报表审核</span>
																		</div>
																	</div>
																</div>
															</div>
															<div class="timeline-item clearfix">
																<div class="timeline-info">
																	<span class="timeline-date"></span> <i class="timeline-indicator btn btn-info no-hover"></i>
																</div>
																<div class="widget-box transparent">
																	<div class="widget-body">
																		<div class="widget-main no-padding">
																			<span nodeId="100610" class="green bolder">报表收集</span>
																		</div>
																	</div>
																</div>
															</div>
															
														</div>
													</div>
												</div>
												<!-- /.timeline-items -->
												<div class="col-xs-8" id="step-container">
													<div class="active">
														<div class="space-4"></div>
														<div class="space-4"></div>
														<div class="space-4"></div>
														<div class="row">
															<div class="col-xs-12">
																<!-- PAGE CONTENT BEGINS -->
																<form class="form-horizontal" role="form">
																	<div class="form-group">
																		<label class="col-sm-3 control-label no-padding-right"
																			for="form-field-1">报表编号：</label>
																		<div class="col-sm-4">
																			<input type="text" id="no" name="no"
																				class="form-control" maxlength="33" readonly="readonly"/>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-3 control-label no-padding-right"
																			for="form-field-1">报表名称：</label>
																		<div class="col-sm-4">
																			<input type="text" id="name" name="name"
																				class="form-control" maxlength="33" readonly="readonly"/>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-3 control-label no-padding-right"
																			for="form-field-1">报表周期：</label>
																		<div class="col-sm-4">
																			<input type="text" id="cycle" name="cycle"
																				class="form-control" maxlength="33" readonly="readonly"/>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-3 control-label no-padding-right"
																			for="form-field-1">报送日期：</label>
																		<div class="col-sm-4">
																			<input type="text" id="sub_time" name="sub_time"
																				class="form-control" maxlength="33" size="33" readonly="readonly"/>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-3 control-label no-padding-right"
																			for="form-field-1">汇总方式：</label>
																		<div class="col-sm-4">
																			<input type="text" id="sum_type" name="sum_type"
																				class="form-control" maxlength="33" readonly="readonly"/>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-3 control-label no-padding-right"
																			for="form-field-1">查阅部门：</label>
																		<div class="col-sm-4">
																			<input type="text" id="org" name="org"
																				class="form-control" maxlength="33" readonly="readonly"/>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="col-sm-3 control-label no-padding-right"
																			for="form-field-1">汇总状态：</label>
																		<div class="col-sm-4">
																			<input type="text" id="status" name="status"
																				class="form-control" maxlength="33" readonly="readonly"/>
																			<input id="templatePath" name="templatePath"
																				class="form-control" maxlength="100" type="hidden" />
																		</div>
																	</div>
																	
																</form>
															</div>
														</div><!-- /.row -->
													</div>
												</div>
												
												<div class="col-xs-12">
													<div class="clearfix form-actions">
														<div id="actionButtonNext" class="col-md-offset-3 col-md-9" style="text-align: center;">
															<button id="query" class="btn btn-sm btn-purple" type="button"
																role="query">
																<i class="ace-icon fa fa-search bigger-110"></i> 查看模板
															</button>
															&nbsp; &nbsp; &nbsp;
															<button id="summarize" class="btn btn-sm btn-pink"
																type="button" role="summarize">
																<i class="ace-icon fa fa-indent bigger-110"></i> 汇总
															</button>
															&nbsp; &nbsp; &nbsp;
															<button id="summarizeResult" class="btn btn-sm btn-pink"
																type="button" role="summarizeResult">
																<i class="ace-icon fa fa-indent bigger-110"></i> 查看汇总
															</button>
															&nbsp; &nbsp; &nbsp;
														</div>
													</div>
													<!-- <div class="table-responsive"> -->
													<!-- <div class="dataTables_borderWrap"> -->
													<div>
														<table id="tbl_cusmanager"
															class="table table-striped table-hover">
															<thead>
																<tr>
																	<th style="width: 40px;"><input type="checkbox" id="cusmanager_ck_all" /></th>
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
												</div>
											</div>
										</div>
									</div>
								</div>
							</div><!-- /.widget-main -->
						</div><!-- /.widget-body -->
					</div><!-- /.widget-box -->
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
												
												<div class="timeline-items" >
													<div class="timeline-item clearfix">
														<div class="timeline-info">
															<i class="timeline-indicator ace-icon fa fa-hand-o-right btn btn-success no-hover"></i>
														</div>
														<div class="widget-box transparent">
															<div class="widget-header widget-header-small">
																<h5 class="widget-title smaller">
																	<span class="">下一流程处理人：</span>
																</h5>
															</div>
															<div class="widget-body">
																<div class="widget-main" id="nextTaskAssignee"></div>
															</div>
														</div>
													</div>
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
									<button id="btn-concel-advice" role="btn-concel-advice" name="btn-cancel" type="button" class="btn btn-sm btn-default btn-cancel" data-dismiss="modal">
										<i class="fa fa-power-off"></i> 关闭
									</button>
								</div>
							</div>
						</div>
					</div>
					<!-- 
					<div class="widget-box transparent">
						<div class="widget-header widget-header-flat">
							<h4 class="widget-title lighter">
								<i class="ace-icon fa fa-signal"></i>
								意见记录
							</h4>
							<div class="widget-toolbar">
								<a href="#" data-action="collapse">
									<i class="ace-icon fa fa-chevron-up"></i>
								</a>
							</div>
						</div>
						<div class="widget-body">
							<div class="widget-main padding-4">
								<div id="">
									<div class="row">
										<div class="col-xs-12 col-sm-10 col-sm-offset-1">
											<div class="timeline-container">
												<div class="timeline-label">
													<span class="label label-primary arrowed-in-right label-lg">
													过程意见
													</span>
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
																	<i class="ace-icon fa fa-clock-o bigger-110"></i>
																	2014-08-29 16:22
																</span>
															</div>
						
															<div class="widget-body">
																<div class="widget-main">
																	无审批意见
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					 -->
				</div><!-- /.page-content -->
			</div><!-- /.main-content -->
			<form id="redirectForm">
				<input type="hidden" id="workflowCode" value="${taskInfo.workflowCode}">
				<input type="hidden" id="nodeId" value="${taskInfo.nodeId}">
				<input type="hidden" id="taskId" value="${taskInfo.taskId}">
				<input type="hidden" id="wfTaskId" value="${taskInfo.wfTaskId}">
				<input type="hidden" id="workflowId" value="${taskInfo.workflowId}">
				<input type="hidden" id="actionCode">
				<input type="hidden" id="curOrgId">
				<input type="hidden" id="submitTime">
			</form>
			<input type="hidden" name="reportTemplateId" id="reportTemplateId" value="${reportTemplateId}" />
			<input type="hidden" name="templateSumId" id="templateSumId" value="${templateSumId}" />
		</div><!-- /.main-container -->
		
		<script type="x-tmpl-mustache" id="dt-row-operation">
			<div class="btn-group">
				<button role="resend" data-orgid="{{orgId}}" data-id="{{id}}" data-submitState="{{submitState}}" class="btn btn-xs btn-info" title="退回" id="resendButton"><i class="ace-icon fa fa-undo"></i></button>
                <button role="download" data-file-path="{{path}}" data-submitState="{{submitState}}" class="btn btn-xs btn-info" title="下载"><i class="ace-icon fa fa-download"></i></button>
				<button role='detail' data-orgid="{{orgId}}" data-id="{{id}}" data-submitState="{{submitState}}" class="btn btn-xs btn-info" title="查看"><i class="ace-icon fa fa-eye"></i></button>
			</div>
		</script>
		<script type="x-tmpl-mustache" id="dt-row-operation_hidden">
			<div class="btn-group">
				<button role="resend" disabled="disabled" data-orgid="{{orgId}}" data-id="{{id}}" data-submitState="{{submitState}}" class="btn btn-xs btn-info" title="退回" id="resendButton"><i class="ace-icon fa fa-undo"></i></button>
                <button role="download" disabled="disabled" data-file-path="{{path}}" data-submitState="{{submitState}}" class="btn btn-xs btn-info" title="下载"><i class="ace-icon fa fa-download"></i></button>
				<button role='detail' data-orgid="{{orgId}}" data-id="{{id}}" data-submitState="{{submitState}}" class="btn btn-xs btn-info" title="查看"><i class="ace-icon fa fa-eye"></i></button>
			</div>
		</script>
		<!--  
		<script type="x-tmpl-mustache" id="dt-row-operation_hidden111">
			<div class="btn-group">
				<input  data-orgid="{{orgId}}" data-id="{{id}}" class="btn btn-xs btn-info" title="" id="resendButton" type="hidden" />
                <input  data-file-path="{{path}}" class="btn btn-xs btn-info" title="" id="" type="hidden" />
			</div>
		</script>
		-->
		<script type="x-tmpl-mustache" id="dt-user-operation">
			<div class="btn-group ">
				<input  type="checkbox" name="check_user_id" value="{{id}}">
			</div>
		</script>
		
		<iframe id="proxyIFrame" src="" height="0" width="0"></iframe>
		<!-- 内容结束 -->
		<jsp:include page="../commons/res/unified_js.jsp"></jsp:include>
		
		<script type="text/javascript">
			seajs.use('${my}/js/unified/reportCollectAudit/main');
		</script>
	</body>
</html>