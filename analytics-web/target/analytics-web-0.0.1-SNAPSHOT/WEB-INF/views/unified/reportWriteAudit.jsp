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
			.main-left{border:1px solid #eee;text-align:center;height:200px}
			.main-left h4{font-size:16px;border-bottom:1px solid #eee;padding:10px 0px;}
			.main-left ul{list-style: none;line-height: 35px;margin:0 0 0 -13px; }
			.main-left ul li.current{color:red;}
			.main_right{border:1px solid #eee;}
			#uploadify{margin-top:10px;}
			.tags{width:100%;}
			.inline{width:52%}
			.input-group .form-control{width:342px}
			.input-group-addon, .input-group-btn{width:0%;}
			.file{ position:absolute; top:0; right:80px; height:24px; filter:alpha(opacity:0);opacity: 0;width:260px }
			.brower{ background-color:#FFF; border:1px solid #CDCDCD;height:24px; width:70px;}
			.file-box{ position:relative;width:340px}
			.file {height: 30px;opacity: 0;position: absolute;right: 50px;top: 0;width: 279px;
}
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
																<form action="" class="form-horizontal" role="form" enctype="multipart/form-data" id="myform" method="post">
																	<input type="hidden" name="workflowId" value="${taskInfo.workflowId}"/>
																	<div class="form-group">
																		<label class="col-sm-3 control-label no-padding-right" for="templateId"> 报表编号 </label>
																		<div class="col-sm-9">
																			<input type="text" id="templateId" name="templateId" class="col-xs-10 col-sm-5" disabled />
																		</div>
																	</div>
																	<div class="space-4"></div>
																	<div class="form-group">
																		<label class="col-sm-3 control-label no-padding-right" for="templateName"> 报表名称 </label>
																		<div class="col-sm-9">
																			<input type="text" id="templateName" name="templateName" class="col-xs-10 col-sm-5" disabled />
																		</div>
																	</div>
																	
																	<div class="space-4"></div>
																	<div class="form-group">
																		<label class="col-sm-3 control-label no-padding-right" for="cycle"> 报表周期 </label>
																		<div class="col-sm-9">
																			<input type="text" name="cycle" id="cycle" class="col-xs-10 col-sm-5" disabled />
																		</div>
																	</div>
																	
																	<div class="space-4"></div>
																	<div class="form-group">
																		<label class="col-sm-3 control-label no-padding-right" for="timeLimit">报表时限:</label>
																		<div class="col-sm-8">
																			统计周期后&nbsp;
																			<input disabled type="text" id="timeLimit" name="timeLimit" style="width:5%" maxlength="3" />&nbsp;&nbsp;&nbsp;天以内
																		</div>
																	</div>
																	
																	<div class="space-4"></div>
																	<div class="form-group">
																		<label class="col-sm-3 control-label no-padding-right">填报机构</label>
																		<div class="col-sm-9">
																			<div class="inline">
																				<div class="tags" id="submitOrg"></div>
																			</div>
																		</div>
																	</div>
																	
																	<div class="space-4"></div>
																	<div class="form-group">
																		<label class="col-sm-3 control-label no-padding-right">查阅角色</label>
																		<div class="col-sm-9">
																			<div class="inline">
																				<div class="tags" id="checkRole"></div>
																			</div>
																		</div>
																	</div>
																	
																	<div class="space-4"></div>
																	<div class="form-group">
																		<label class="col-sm-3 control-label no-padding-right" for="sumType"> 汇总方式</label>
																		<div class="col-sm-9">
																			<input type="text" id="sumType" name="sumType" class="col-xs-10 col-sm-5" disabled />
																		</div>
																	</div>
																	
																	<div class="startRow">
																		<div class="space-4"></div>
																		<div class="form-group">
																			<label class="col-sm-3 control-label no-padding-right" for="sumType"> 汇总开始行</label>
																			<div class="col-sm-9">
																				<input type="text" id="startRow" name="startRow" class="col-xs-10 col-sm-5" disabled></input>
																			</div>
																		</div>
																	</div>
																	<div class="space-4"></div>
																	<div class="form-group">
																		<label class="col-sm-3 control-label no-padding-right label-reportResult" for="path">报表模版</label>
																		<div class="col-sm-9" style="width:62.5%">
																			<input class="col-xs-10 col-sm-5" type="text" id="path" name="path" disabled />
																			<input class="col-xs-10 col-sm-5" type="hidden" id="realPath" name="realPath" />
																			<button class="btn btn-info btn-sm" type="button" role="downloadBtn">
																				<i class="ace-icon fa fa-download"></i>
																				下载
																			</button>
																		</div>
																	</div>
																<!-- 如果是报表审核环节，则下载按钮隐藏 -->
																<c:if test="${taskInfo.nodeId != '100612'}">
																<div class="space-4"></div>
																<div class="form-group">
																	<label class="col-sm-3 control-label no-padding-right" for="form-field-tags">报表结果</label>
																	<div class="col-sm-5 file-box">
																		<input type="text" name="textfield" id="textfield" class="col-xs-8 col-sm-8" />
																		<input type='button' class='btn btn-sm btn-info' value='浏览...' id="brower" style="width:67px"/>  
																		<input id="filename" name="filename" class="file" type="file" onchange="document.getElementById('textfield').value=this.value">
																	</div>
																</div>
																<div class="clearfix form-actions">
																	<div class="col-md-offset-3 col-md-9">
																		<button class="btn btn-info btn-sm" type="button" id="fileBtn" value="false" role="fileBtn">
																			<i class="ace-icon fa fa-check bigger-110"></i>
																			提交上传
																		</button>
													
																		&nbsp; &nbsp; &nbsp;
																		<button class="btn btn-sm" type="button" role="btn-reset" id="btn-reset">
																			<i class="ace-icon fa fa-undo bigger-110"></i>
																			重 置
																		</button>
																	</div>
																</div>
																<div class="hr hr-24"></div>
																</c:if>
															</form>
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
				<input type="hidden" id="orgId" value="${taskInfo.orgId}">
			</form>
		</div><!-- /.main-container -->
		<iframe id="proxyIFrame" src="" height="0" width="0"></iframe>
		<!-- 内容结束 -->
		<jsp:include page="../commons/res/unified_js.jsp"></jsp:include>
		
		<script type="text/javascript">
			seajs.use('${my}/js/unified/reportWriteAudit/main');
		</script>
		<script type="text/javascript">
			function getPath(obj){
				if(obj){
					if (window.navigator.userAgent.indexOf("MSIE")>=1){
						alert(document.selection.createRange().text);
						obj.select();
						return document.selection.createRange().text;
					}else if(window.navigator.userAgent.indexOf("Firefox")>=1){
						if(obj.files){
							alert(obj.value);
							//alert(obj.files.item(0).getAsDataURL());
							return obj.files.item(0).getAsDataURL();}
							alert(obj.value);
						return obj.value;
					}
					return obj.value;
				}
			}
		</script>
	</body>
</html>