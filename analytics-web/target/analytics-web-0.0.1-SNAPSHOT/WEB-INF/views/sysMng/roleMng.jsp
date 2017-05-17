<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>
<style type="text/css">
	.t_dialog {
		width: 100%;
		display: none;
	}
</style>
<div class="ajax-content">
<div class="page-header">
	<h1>
		系统管理 <small> <i class="ace-icon fa fa-angle-double-right"></i>
			角色管理 <span class="my-button-group"> <a id="btn-add"
				class="btn btn-sm btn-success"><i class="ace-icon fa fa-plus"></i>
					新增</a>
		</span>
		</small>
	</h1>
</div>
<!-- 新增/修改窗口 -->
<div id="role-add" class="modal" data-backdrop="static" tabindex="-1">
	<div class="modal-dialog" style="width: 50%">
		<div class="modal-content">
			<form id="role-form" action="/analytics/roleMng/addOrModify" class="form-horizontal"
				name="role-form" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="blue bigger"></h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="form-group">
								<label class="col-sm-2 control-label no-padding-right"
									for="name"> 角色名称<span class="red">*</span>
								</label>
								<div class="col-sm-6">
									<input type="hidden" id="id" name="id" value="" /> 
									<input type="text" id="name" name="name" class="form-control" maxlength="10" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label no-padding-right"
									for="state"> 状态 </label>
								<div class="col-sm-6">
									<div class="clearfix">
										<select id="status" class="form-control" name="status">
											<option value="1">启用</option>
											<option value="2">禁用</option>
										</select>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" id="btn-addRole-submit"
						class="btn btn-sm btn-primary">
						<i class="ace-icon fa fa-save"></i> 保存
					</button>
					<button name="btn-cancel" type="button" class="btn btn-sm"
						data-dismiss="modal">
						<i class="ace-icon fa fa-times"></i> 取消
					</button>
				</div>
				<input type="hidden" name="flag" value="0" id="flag" class="flag" />
			</form>
		</div>
	</div>
</div>
<!-- 新增/修改窗口结束 -->
<div tabindex="-1" class="modal" id="right-form" data-backdrop="static"
	tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="form-horizontal">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="blue bigger">分配权限</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-12">
							<input type="hidden" id="id" name="id" />
							<div class="form-group">
								<label class="col-sm-2 control-label no-padding-right" for="name"> 角色名称<span class="red"></span></label>
								<div class="col-sm-6">
									<input type="hidden" id="roleId" name="roleId" value="" /> 
									<input type="text" id="roleName" name="roleName" class="form-control" readonly="readonly" />
								</div>
							</div>
							<div class="form-group">
								<label for="form-field-4" class="col-sm-2 control-label no-padding-right">查阅角色</label>
								<div class="col-sm-8">
									<input type="radio" id="checkRole1" name ="checkRole" value="1">是&nbsp;&nbsp;
									<input type="radio" id="checkRole0" name ="checkRole" value="0">否
								</div>
							</div>
							<div class="form-group">
								<label for="form-field-4" class="col-sm-2 control-label no-padding-right">权限选择</label>
								<div class="col-sm-8">
									<ul class="ztree" id="treeDemo" style="-moz-user-select: none;">
										<li></li>
									</ul>
								</div>
							</div>
							<div class="form-group">
								<label for="form-field-4" class="col-sm-2 control-label no-padding-right">管理看板</label>
								<div class="col-sm-8">
									<ul class="ztree" id="treeDemo_dashboard" style="-moz-user-select: none;">
										<li></li>
									</ul>
								</div>
							</div>
							
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-sm btn-primary" id="btn-saveRoleFunction">
						<i class="ace-icon fa fa-save"></i> 保存
					</button>
					<button data-dismiss="modal" class="btn btn-sm"
						data-dismiss="modal">
						<i class="ace-icon fa fa-times"></i> 取消
					</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- end -->
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
							<th>角色编号</th>
							<th>角色名称</th>
							<th>角色状态</th>
							<th>操作</th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="t_dialog">
				<center>
					<span class="ajax_msg"> <img src="${my}/img/loading.gif" />
					</span>
				</center>
			</div>
		</div>
	</div>
</div>
<!-- 分配用户窗口开始 -->
<div tabindex="-1" class="modal fade bs-example-modal-lg"
	id="ruser-form" data-backdrop="static">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="form-horizontal">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<ol class="breadcrumb">
						<li><a href="javaScript:void(0);"><h3>分配用户</h3></a></li>
						<li class="active" id="currentRole" style="font-size: 16px;"></li>
					</ol>
					<input type="hidden" id="hidden_role_id" value="" />
				</div>
				<div class="modal-body">
					<!-- start -->
					<div class="row">
						<!-- row -->
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="row">
								<div class="col-xs-12">
									<table id="user-tbl"
										class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>序号</th>
												<th>用户名称</th>
												<th>操作</th>
											</tr>
										</thead>
									</table>
								</div>
								<div class="t_dialog">
									<center>
										<span class="ajax_msg"> <img
											src="${my}/img/loading.gif" />
										</span>
									</center>
								</div>
							</div>
						</div>
					</div>
					<!-- end -->
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-sm btn-primary" id="allot-user-role">
					<i class="ace-icon fa fa-save"></i> 保存
				</button>
				<button data-dismiss="modal" class="btn btn-sm" data-dismiss="modal">
					<i class="ace-icon fa fa-times"></i> 取消
				</button>
			</div>
		</div>
	</div>
</div>
</div>
<!--分配用户窗口end -->
<!-- <button role="ruser" value="{{id}}" class="btn btn-xs btn-success" title="分配用户"><i class="glyphicon glyphicon-user"></i></button> -->
<!-- end row -->
<script type="x-tmpl-mustache" id="dt-row-operation">
	<div class="btn-group ">
		<button role="edit" value="{{id}}" class="btn btn-xs btn-primary" title="修改"><i class="glyphicon glyphicon-edit"></i></button>
		<button role="right" value="{{id}}" class="btn btn-xs btn-primary" title="分配权限"><i class="glyphicon glyphicon-indent-left"></i></button>
	</div>
</script>
<script type="x-tmpl-mustache" id="dt-user-operation">
	<div class="btn-group ">
		<input  type="checkbox" name="check_user_id" value="{{id}}">
	</div>
</script>

<script src="${res}/js/chosen.jquery.min.js"></script>
<script src="${res}/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript">
	// DO NOT REMOVE : GLOBAL FUNCTIONS!
	ace.load_ajax_scripts([], function() {
	})
	seajs.use("${my}/js/sysMng/role/main", function(main) {
		main.init();
	});
</script>