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
							模板审核发布流程
							<small>
								<i class="ace-icon fa fa-angle-double-right"></i>模板审核
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
												<input type="text" id="startRow" name="startRow" class="form-control" maxlength="10" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label no-padding-right"
												for="name"> 报表模板<span class="red">*</span>
											</label>
											<div class="col-sm-8">
												<input type="hidden" id="path" name="path"/>
												<button id="btn-download" class="btn btn-sm btn-yellow" type="button" >
													<i class="ace-icon fa fa-download bigger-110"></i>
													下载
												</button>
											</div>
										</div>
									</form>
									<!-- 意见记录 -->
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
		</div><!-- /.main-container -->
		
		<!-- 内容结束 -->
		<jsp:include page="../commons/res/unified_js.jsp"></jsp:include>
		
		<script type="text/javascript">
			seajs.use('${my}/js/unified/templateView/main');
		</script>
	</body>
</html>