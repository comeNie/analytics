<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../commons/res/taglibs.jsp" %>
<%@ include file="../commons/res/_ctx.jsp" %>
<%-- <link rel="stylesheet" href="${my}/css/dashboard.css" type="text/css" /> --%>
<div class="breadcrumbs" id="breadcrumbs">
<ul class="breadcrumb">
		<li>
			<i class="ace-icon fa fa-home home-icon"></i>
			<span>主页</span>
		</li>
		<li>
			<span>工作面板</span>
		</li>
	</ul>
</div>
<div class="ajax-content">
	<script type="text/javascript">
		try{ace.settings.check('main-container' , 'fixed')}catch(e){}
	</script>
	  
	<div class="main-content">
		<div class="page-content">
			<!-- 页面内容 -->
			<div class="row">
				<div class="col-xs-12">
					<div class="row">
						<div class="col-xs-12">
							<div class="widget-box transparent" id="recent-box">
								<div class="widget-header">
									<div class="widget-toolbar no-border pull-left">
										<ul class="nav nav-tabs" id="recent-tab">
											<li class="active">
												<a data-toggle="tab" href="#task-todo">待办任务</a>
											</li>
											<li>
												<a data-toggle="tab" href="#task-done">已办任务</a>
											</li>
										</ul>
									</div>
								</div>
								<div class="widget-body">
									<div class="widget-main padding-4">
										<div class="tab-content padding-8">
											<!-- 待办列表及查询 -->
											<div id="task-todo" class="tab-pane active">
												<form id="todo_search_conditions" action="" class="search_conditions" >
													<div class="row">
														<div class="col-md-9 form-group lbl-group" >
															<b class="">流程类型:</b>
															<span>
																<input type="radio" class=" hidden" value="" checked="checked" name="workflowCode_todo" />
																<label class="lbl lblchecked" >全部</label><span>  |  </span>
															</span>
															
															<span>
																<label class="lbl lbluncheck" >模板审核发布</label><span>  |  </span>
																<input type="radio" class="hidden" value="1005" name="workflowCode_todo" />
															</span>
															<span>
																<label class="lbl lbluncheck">手工数据报送</label>
																<input type="radio" class="hidden" value="1006" name="workflowCode_todo" />
															</span>
														</div>
													</div>
													<div class="col-md-12"></div>
													<div class="row">
														<div class="col-md-3 form-group">
													    	<b class="">任务主题:</b>
														  	<input type="text" id="taskSubject_todo" name="taskSubject" class="input-md" />
														</div>
													</div>
													<div class="row">
														<div class="col-md-3 form-group hidden">
													    	<b class="">分配人:</b>
														  	<input type="text" id="taskCreatorName_todo" name="taskCreatorName" class="input-md" />
														</div>
														<div class="col-xs-2 form-group">
															<div class="input-group">
															  	<span class="input-group-addon">分配时间</span>
															  	<input class="input-small date-picker" id="taskCreateDateStart_todo" name="taskCreateDateStart" 
															  		placeholder="分配时间" type="text" data-date-format="yyyy-mm-dd">
															</div>
														</div>

														<div class="col-xs-2 form-group">
															<div class="input-group">
																<span class="input-group-addon">至</span>
															  	<input class="input-small date-picker" id="taskCreateDateEnd_todo" name="taskCreateDateEnd" 
															  		placeholder="结束时间" type="text" data-date-format="yyyy-mm-dd"/>
															</div>
														</div>
															
														<div class="col-md-1 form-group">
															<button id="todo_search" type="button" class="btn btn-sm btn-purple">
															<i class="ace-icon fa fa-search"></i> 查询</button>
														</div>
													</div>
												</form>
												<table id="tbl_todo" class="table table-striped table-hover">
													<thead>
														<tr>
															<th width="">任务主题</th>
															<th width="">流程类型</th>
															<th width="">所处环节</th>
															<th width="">分配人</th>
															<th width="">分配时间</th>
															<th width="">操作</th>
														</tr>
													</thead>
													<tbody>
													</tbody>
												</table>
												<div class="hr hr-double hr8"></div>
											</div>
											<!-- 已办列表及查询 -->
											<div id="task-done" class="tab-pane">
												<form id="done_search_conditions" class="search_conditions">
													<div class="row hidden">
														<div class="col-xs-4 form-group">
															<b class="">分配人:</b>
														  	<input type="text" id="taskCreatorName_done" name="taskCreatorName" class="input-md" />
														</div>
													</div>
													<div class="row">
														<div class="col-xs-9 form-group lbl-group" >
															<b class="">流程类型:</b>
															<span>
																<input type="radio" class=" hidden" value="" checked="checked" name="workflowCode_done" />
																<label class="lbl lblchecked" >全部</label><span>  |  </span>
															</span>
															
															<span>
																<label class="lbl lbluncheck" >模板审核发布</label><span>  |  </span>
																<input type="radio" class="hidden" value="1005" name="workflowCode_done" />
															</span>
															<span>
																<label class="lbl lbluncheck">手工数据报送</label>
																<input type="radio" class="hidden" value="1006" name="workflowCode_done" />
															</span>
														</div>
													</div>
													<div class="row">
														<div class="col-md-3 form-group">
													    	<b class="">任务主题:</b>
														  	<input type="text" id="taskSubject_done" name="taskSubject" class="input-md" />
														</div>
													</div>
													<div class="row form-group">
														<div class="col-xs-2 ">
															<div class="input-group">
															  	<span class="input-group-addon">分配时间</span>
															  	<input class="input-small date-picker" id="taskAssignDateStart_done" name="taskAssignDateStart" placeholder="分配时间" type="text" data-date-format="yyyy-mm-dd"/>
														  	</div>
														</div>
														<div class="col-xs-2 ">
															<div class="input-group">
															  	<span class="input-group-addon">至</span>
															  	<input class="input-small date-picker" id="taskAssignDateEnd_done" name="taskAssignDateEnd" placeholder="结束时间" type="text" data-date-format="yyyy-mm-dd"/>
														  	</div>
														</div>
														<div class="col-xs-2 ">
															<div class="input-group">
																<span class="input-group-addon">处理时间</span>
																<input class="input-small date-picker" id="taskConfirmDateStart_done" name="taskConfirmDateStart" placeholder="开始时间" type="text" data-date-format="yyyy-mm-dd"/>
															</div>
														</div>
														<div class="col-xs-2 ">
															<div class="input-group">
															  	<span class="input-group-addon">至</span>
															  	<input class="input-small date-picker" id="taskConfirmDateEnd_done" name="taskConfirmDateEnd" placeholder="结束时间" type="text" data-date-format="yyyy-mm-dd"/>
															</div>
														</div>
														<div class="col-md-1 form-group">
															<button id="done_search" type="button" class="btn btn-sm btn-purple">
															<i class="ace-icon fa fa-search"></i> 查询</button>
														</div>
													</div>
													<input type="hidden" id="orgId" value="${curUser.orgCode }"/>
												</form>
												<table id="tbl_done" class="table table-striped table-hover">
													<thead>
														<tr>
															<th width="">任务主题</th>
															<th width="">流程类型</th>
															<th width="">处理环节</th>
															<th width="">当前环节</th>
															<th width="">分配时间</th>
															<th width="">处理时间</th>
															<th width="">操作</th>
														</tr>
													</thead>
													<tbody>
													</tbody>
												</table>
												<div class="hr hr-double hr8"></div>
											</div><!-- /.#member-tab -->
											
											<div id="todoTask-win" class="modal" data-backdrop="static" tabindex="-1">
												<div class="modal-dialog modal-lg" style="width:85%;height:80%;top: -28px;">
													<div class="modal-content" >
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal" for="closeIframe">&times;</button>
															<h4 class="blue bigger"></h4>
														</div>
														<div class="modal-body" style="height:100%;">
															<iframe id="todo-iframe" width="100%" height="100%" src="" frameborder="0" marginheight="0" marginwidth="0" 
																scrolling="yes">
															</iframe>
														</div>
													</div>
												</div>
											</div>
											
											<div id="doneTask-win" class="modal" data-backdrop="static" tabindex="-1">
												<div class="modal-dialog modal-lg" style="width:85%;height:80%">
													<div class="modal-content" >
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal" for="closeIframe">&times;</button>
															<h4 class="blue bigger"></h4>
														</div>
														<div class="modal-body" style="height:100%;">
															<iframe id="done-iframe" width="100%" height="100%" src="" frameborder="0" marginheight="0" marginwidth="0" 
																scrolling="yes">
															</iframe>
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
				</div><!-- /.col -->
			</div><!-- /.row -->
			<!-- 下流程接收人 -->
			<div id="detailModal" class="modal fade bs-example-modal-sm" data-backdrop="static" tabindex="-1">
				<div class="modal-dialog" style="width: 800px">
					<div class="modal-content">
						<div class="modal-header">
							<button id="close-detail" type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="blue bigger">
								<i class="glyphicon glyphicon-eye-open"></i> 当前环节处理人
							</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-20" id="div-search" style="padding: 0px 0px 0px 0px;">
									<div class="timeline-container">
										<div class="timeline-items" id="wfDetailWarp">
											
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
		</div><!-- /.page-content -->
	</div><!-- /.main-content -->
	<form id="redirectForm">
		<input type="hidden" id="workflowCode" name="workflowCode">
		<input type="hidden" id="nodeId" name="nodeId">
		<input type="hidden" id="taskId" name="taskId">
		<input type="hidden" id="wfTaskId" name="wfTaskId">
		<input type="hidden" id="workflowId" name="workflowId">
	</form>
	
	<div id="account-login" class="modal" data-backdrop="static" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="loginAcc-form" name="loginAcc-form" action="${ctx}/dashboard/registration" class="form-horizontal" role="form" method="post">
					<div class="modal-header">
						<h4 class="blue bigger"><i class="ace-icon fa fa-edit"></i> 登记账号</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12">
								<div class="form-group">
									<label class="col-sm-2 control-label no-padding-right" for="oldPassword"> 账号 </label>
									<div class="col-sm-8">
										<select class="form-control required" id="logname_r" name="logname" required="required" >
											
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label no-padding-right" for="newPassword" > 机构 </label>
									<div class="col-sm-8">
										<select class="form-control required" id="orgid_r" name="orgid"  required="required">
										
										</select>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button id="btn-r"  class="btn btn-sm btn-primary" type="button">
							<i class="ace-icon fa fa-arrow-right"></i><span class="bigger-110">登记</span>
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<div id="account-login-prompt" class="modal" data-backdrop="static" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="blue bigger"><i class="ace-icon fa fa-edit"></i> 登记账号</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="form-group">
								<img src="${my}/img/myloading.gif">
							</div>
							<div class="form-group">
								<label style="text-align: center;">正在加载用户，请稍等.</label>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		ace.load_ajax_scripts([], function() {
	})
		seajs.use("${my}/js/todoList/main", function(main) {
			main.init();
		});
	</script>
	<!-- <script type="text/javascript">
			var pw = parent.window.opener;
			pw.winOperate();
		</script> -->
</div>
