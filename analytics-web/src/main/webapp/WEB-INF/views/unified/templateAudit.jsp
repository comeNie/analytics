<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../commons/res/taglibs.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>综合统计系统</title>
		<link rel="stylesheet" href="${res}/css/chosen.css" type="text/css"></link>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		
		<c:import url="../commons/res/css.jsp" />
		
		<script>var $$ctx = '${ctx}';var $$res = '${res}';var $$my = '${my}';</script>
	</head>
	
	<body class="no-skin">
	<!-- 下一环节处理人弹出框 -->
	
	
	
		<!-- 内容开始 -->
		<div class="main-container" id="main-container">
			<div class="main-content">
				<div class="page-content">
				<div id="lookTemplate" class="modal fade bs-example-modal-sm"
		data-backdrop="static" tabindex="-1">
		<div class="modal-dialog" style="width: 800px">
			<div class="modal-content">
				<div class="modal-header">
					<button id="close-detail" role="close-detail" type="button" class="close"
						data-dismiss="modal">&times;</button>
					<h4 class="blue bigger">
						<i class="glyphicon glyphicon-eye-open"></i> 下一环节处理人
					</h4>
				</div>
				<div class="modal-body">
					<div class="row">
				<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right"
						for="name">
				</label>
				 <div class="col-sm-4">
					<ul class="ztree" id="taskReceiver" style="-moz-user-select: none;">
					 	<li></li>
					</ul>
					<input type="hidden" id="receivers" value="">
				</div>
			   </div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" role="comfirmNextPeople" id="download-detail"
						class="btn btn-info btn-sm" title="确定" data-dismiss="modal">
						<i class="glyphicon glyphicon-ok-circle">确定</i>
					</button>
					<button id="btn-concel-detail" role="btn-concel-detail" name="btn-cancel" type="button"
						class="btn btn-sm btn-default btn-cancel" data-dismiss="modal">
						<i class="ace-icon fa fa-times"></i> 取消
					</button>
				</div>
			</div>
		</div>
	</div>
					<div class="page-header">
						<h1>
							模板审核发布流程
							<small>
								<i class="ace-icon fa fa-angle-double-right"></i>模板审核
							</small>
						</h1>
					</div><!-- /.page-header -->
				<form action="" id="ruleForm" name="ruleForm" class="form-horizontal" method="post" enctype="multipart/form-data">
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
																	<span class="timeline-date"></span> <i class="timeline-indicator btn btn-info no-hover"></i>
																</div>
																<div class="widget-box transparent">
																	<div class="widget-body">
																		<div class="widget-main no-padding">
																			<span nodeId="100510" class="green bolder">新建模板</span>
																		</div>
																	</div>
																</div>
															</div>
															<div class="timeline-item clearfix">
																<div class="timeline-info">
																	<span class="timeline-date"></span> <i
																		class="timeline-indicator btn btn-info no-hover"></i>
																</div>
																<div class="widget-box transparent">
																	<div class="widget-body">
																		<div class="widget-main no-padding">
																			<span nodeId="100511" class="green bolder">部门审核</span>
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
																			<span nodeId="100512" class="green bolder">统计组审核</span>
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
																			<span nodeId="100513" class="green bolder">负责人审核</span>
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
																			<span nodeId="100514" class="green bolder">模板发布</span>
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
																<input type="hidden" class="form-control" id="id" name="id" /> 
																<input type="hidden" name="workflowId" value="${reportTemplate.workflowId}"/>
																<div class="form-group">
																	<label class="col-sm-2 control-label no-padding-right"
																		for="name"> 报表编号<span class="red">*</span>
																	</label>
																	<div class="col-sm-8">
																		<input type="text" id="no" name="no" class="form-control" maxlength="50"/>
																	</div>
																</div>
																<div class="form-group">
																	<label class="col-sm-2 control-label no-padding-right"
																		for="name"> 报表名称<span class="red">*</span>
																	</label>
																	<div class="col-sm-8">
																		<input type="text" id="name" name="name" class="form-control" maxlength="50""/>
																	</div>
																</div>
																<div class="form-group">
																	<label class="col-sm-2 control-label no-padding-right"
																		for="name"> 报表周期<span class="red">*</span>
																	</label>
																	<div class="col-sm-8">
																		<div class="clearfix">
																			<select id="cycle" class="form-control" name="cycle">
																				<option value="1">一次性填报</option>
																				<option value="2">年报</option>
																				<option value="3">半年报</option>
																				<option value="4">季报</option>
																				<option value="5">月报</option>
																				<option value="6">旬报</option>
																				<option value="7">周报</option>
																			</select>
																		</div>
																	</div>
																</div>
																<div class="form-group">
																	<label class="col-sm-2 control-label no-padding-right"
																		for="name"> 报送时限<span class="red">*</span>
																	</label>
																	<div class="col-sm-8">
																		统计周期后&nbsp;&nbsp;&nbsp;
																		<input type="text" id="timeLimit" name="timeLimit" style="width:30%" 
																			maxlength="3" />&nbsp;&nbsp;&nbsp;天以内
																	</div>
																</div>
																<div class="form-group">
																	<label class="col-sm-2 control-label no-padding-right"
																		for="name"> 填报机构（多选）<span class="red">*</span>
																	</label>
																	<div class="col-sm-8">
																		<select data-placeholder=" " id="submitOrg" class="col-xs-10 col-sm-12 org-select" 
																		name="submitOrg" multiple="multiple"></select>
																	</div>
																</div>
																<div class="form-group">
																	<label class="col-sm-2 control-label no-padding-right"
																		for="name"> 查阅角色（多选）<span class="red">*</span>
																	</label>
																	<div class="col-sm-8">
																		<select data-placeholder=" " id="checkRole" class="col-xs-10 col-sm-12 role-select" 
																		name="checkRole" multiple="multiple"></select>
																	</div>
																</div>
																<div class="form-group">
																	<label class="col-sm-2 control-label no-padding-right"
																		for="name"> 汇总方式<span class="red">*</span>
																	</label>
																	<div class="col-sm-8">
																		<div class="clearfix">
																			<select id="sumType" class="form-control" name="sumType">
																				<option value="1">按行汇总</option>
																				<option value="2">按页汇总</option>
																			</select>
																		</div>
																	</div>
																</div>
																<div class="form-group">
																	<label class="col-sm-2 control-label no-padding-right"
																		for="name"> 表头行数
																	</label>
																	<div class="col-sm-8">
																		<input type = "hidden" id="startRowValue" >
																		<input type="text" id="startRow" name="startRow" class="form-control" maxlength="2" style="width:100%"/>
																	</div>
																</div>
																<div class="form-group">
																	<label class="col-sm-2 control-label no-padding-right"
																		for="name"> 报表模板<span class="red">*</span>
																	</label>
																	<div class="col-sm-4" style="display:none" id="fileDiv">
																		<input type="file" id="uploadFile" name="uploadFile" style="width:100%;" extension="xlsx" onchange="clearPath()"/>
																		<input type="text" id="oldPath" name="path" style="width:100%;"/>
																	</div>
																	<div class="col-sm-8">
																		<input type="hidden" id="path" name="path"/>
																		<button role="btn-download" class="btn btn-sm btn-yellow" type="button" id="disCreateDownload">
																			<i class="ace-icon fa fa-download bigger-110"></i>
																			下载
																		</button>
																		<input type="hidden" id="state" name="state"/>
																	</div>
																</div>
																<div class="form-group" style="display:none" id="buttonDiv">
																	<label class="col-sm-2 control-label no-padding-right"
																		for="name">
																	</label>
																	<div class="col-sm-8">
																		<input type="hidden" id="path" name="path"/>
																		<button role="btn-download" class="btn btn-sm btn-yellow" type="button" >
																			<i class="ace-icon fa fa-download bigger-110"></i>
																			下载
																		</button>
																		<button id="btn-templateCreate" class="btn btn-sm btn-primary" type="button">
																			<i class="ace-icon fa fa-save"></i> 
																			暂存
																		</button>
																		<input type="hidden" id="saveOrSubmit" name="saveOrSubmit" value=""/>
																	</div>
																</div>
															</div>
														</div><!-- /.row -->
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div><!-- /.widget-main -->
						</div><!-- /.widget-body -->
					</div><!-- /.widget-box -->
					
					<div id="nextAudit">
						<div class="widget-box transparent" >
							<div class="widget-header widget-header-flat">
								<h4 class="widget-title lighter">
									<i class="ace-icon fa fa-signal"></i>
									审批意见
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
													<div class="col-xs-8" style="height:150px">
														<div class="timeline-container timeline-style2">
															<span class="timeline-label"><b>审批意见</b></span>
															<div class="form-group2">
																<label for="inputInfo" class="col-xs-8 col-sm-2 control-label" style="margin-top: 15px;"></label>
																<div class="col-xs-8 col-sm-10" style="margin-left:-15px;margin-top: 15px;">
																	<textarea id="comments" class="form-control" style="height: 110px;"></textarea>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
											<!-- /.timeline-container -->
											<hr>
											<div class="wizard-actions" style="text-align:center;" id="actionButtonNext">
												
											</div>
										</div>
									</div>
								</div><!-- /.widget-main -->
							</div><!-- /.widget-body -->
						</div><!-- /.widget-box -->
					</div>
					</form>
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
				</div><!-- /.page-content -->
			</div><!-- /.main-content -->
			<form id="redirectForm">
				<input type="hidden" id="workflowCode" value="${taskInfo.workflowCode}">
				<input type="hidden" id="nodeId" value="${taskInfo.nodeId}">
				<input type="hidden" id="taskId" value="${taskInfo.taskId}">
				<input type="hidden" id="wfTaskId" value="${taskInfo.wfTaskId}">
				<input type="hidden" id="workflowId" value="${taskInfo.workflowId}">
				<input type="hidden" id="actionCode">
			</form>
		</div><!-- /.main-container -->
		<iframe id="proxyIFrame" src="" height="0" width="0"></iframe>
		<!-- 内容结束 -->
		<jsp:include page="../commons/res/unified_js.jsp"></jsp:include>
		<script src="${res}/js/jquery.ztree.all-3.5.min.js"></script>
		<script src="${res}/js/chosen.jquery.min.js"></script>
		<script type="text/javascript">
			// DO NOT REMOVE : GLOBAL FUNCTIONS!
			ace.load_ajax_scripts([], function() {
			})
			//utils.todoListToltalNum();
			seajs.use('${my}/js/unified/templateAudit/main');
		</script>
		<script type="text/javascript">
			function clearPath(){
			$("#oldPath").css("display","none");
			}
		</script>
	</body>
</html>