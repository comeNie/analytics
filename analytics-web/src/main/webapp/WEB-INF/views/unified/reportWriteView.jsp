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
		<style type="text/css">
			.inline{width:85%;}
			.tags{width:67%;}
		</style>
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
								<i class="ace-icon fa fa-angle-double-right"></i>报表填写
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
										<form id="ruleForm" name="ruleForm" class="form-horizontal">
											<input type="hidden" name="workflowId" value="${reportTemplate.workflowId}"/>
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="templateId">报表编号</label>
												<div class="col-sm-6">
													<input type="text" name="templateId" id="templateId" value="" class="col-xs-10 col-sm-5" readonly="readonly">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="templateName">报表名称</label>
												<div class="col-sm-6">
													<input type="text" name="templateName" id="templateName" class="col-xs-10 col-sm-5" readonly="readonly">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="cycle">报表周期</label>
												<div class="col-sm-6">
													<input type="text" name="cycle" id="cycle" class="col-xs-10 col-sm-5" readonly="readonly">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="timeLimit">报表时限</label>
												<div class="col-sm-8">
													统计周期后&nbsp;
													<input disabled type="text" id="timeLimit" name="timeLimit" style="width:5%" maxlength="3" />&nbsp;&nbsp;&nbsp;天以内
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="submitOrg">填报机构</label>
												<div class="col-sm-9">
													<div class="inline">
														<div class="tags" id="submitOrg"></div>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="checkRole">查阅角色</label>
												<div class="col-sm-9">
													<div class="inline">
														<div class="tags" id="checkRole"></div>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="sumType">汇总方式</label>
												<div class="col-sm-6">
													<select name="sumType" id="sumType"  class="col-xs-10 col-sm-5" disabled="disabled"></select>
												</div>
											</div>
											<div class="startRow">
												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right" for="startRow">汇总开始行</label>
													<div class="col-sm-6">
														<input type="text" name="startRow" id="startRow"  class="col-xs-10 col-sm-5" readonly="readonly">
													</div>
												</div>
											</div>
											<div class="space-4"></div>
											<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right label-reportResult" for="path"> 报表模板
											</label>
											<div class="col-sm-8">
												<input type="text" name="realPath" id="realPath" value="" class="col-xs-10 col-sm-5" readonly="readonly">
												<!-- <input class="col-xs-10 col-sm-5" type="hidden" id="realPath" name="realPath" /> -->
												<button role="downloadBtn_01" id="btn-download_01" class="btn btn-sm btn-yellow" type="button" >
													<i class="ace-icon fa fa-download bigger-110"></i>
													下载 
												</button>
											</div>
										</div>
										</form>
										<!-- 过程意见 -->
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
								<!--审批意见 -->
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
												</div><!-- /.timeline-items -->
											</div><!-- /.timeline-container -->
										</div>
									</div>
								</div>
							</div><!-- /.widget-main -->
						</div><!-- /.widget-body -->
					</div><!-- /.widget-box -->
								</div>
							</div><!-- /.widget-main -->
						</div><!-- /.widget-body -->
					</div><!-- /.widget-box -->
				</div><!-- /.page-content -->
			</div><!-- /.main-content -->
			<form id="redirectForm">
				<input type="hidden" id="workflowCode" value="${taskInfo.workflowCode}">
				<input type="hidden" id="nodeId" value="${taskInfo.nodeId}">
				<input type="hidden" id="taskId" value="${taskInfo.taskId}">
				<input type="hidden" id="wfTaskId" value="${taskInfo.wfTaskId}">
				<input type="hidden" id="workflowId" value="${taskInfo.workflowId}">
				<input type="hidden" id="actionCode">
				<input type="hidden" id="orgId" value="${taskInfo.orgId}">
			</form>
		</div><!-- /.main-container -->
		
		<!-- 内容结束 -->
		<jsp:include page="../commons/res/unified_js.jsp"></jsp:include>
		
		<script type="text/javascript">
			seajs.use('${my}/js/unified/reportWriteView/main');
		</script>
	</body>
</html>