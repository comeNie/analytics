<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>
<link rel="stylesheet" href="${res}/css/chosen.css" type="text/css"></link>
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
			用户管理
		</small>
	</h1>
</div>

<!-- userTable begin-->
<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="row">
			<div class="col-xs-12">
				<table id="tbl"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>序号</th>
							<th>用户名称</th>
							<th>所在机构</th>
							<th>角色</th>
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
<!-- userTable end -->

<!-- modifyUser begin -->
<div id="modify-user" class="modal" data-backdrop="static" tabindex="-1">
		<div class="modal-dialog" style="width:50%">
			<div class="modal-content" >
				<form id="user-form"  class="form-horizontal" name="user-form" method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="blue bigger">分配角色</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12">
								<div class="form-group">
									<label class="col-sm-2 control-label no-padding-right" for="user_name">用户名称</label>
									<div class="col-sm-6">
										<input type="hidden" id="user_id" name="user_id"  value=""/>
										<input type="text" id="user_name" name="user_name" class="form-control" readonly="readonly" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label no-padding-right" for="user_role">用户角色 </label>
									<div class="col-sm-8">
										<select data-placeholder=" " id="user_role" class="col-xs-10 col-sm-8 role-select"  name="user_role" multiple="multiple"></select>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="btn-modifyuser" class="btn btn-sm btn-primary">
							<i class="ace-icon fa fa-save"></i> 保存
						</button>
						<button name="btn-cancel" type="button" class="btn btn-sm" data-dismiss="modal">
							<i class="ace-icon fa fa-times"></i> 取消
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- modifyUser end -->
<script type="x-tmpl-mustache" id="dt-row-operation">
	<div class="btn-group ">
		<button role="edit" id="{{uid}}" name="{{uname}}" value="{{rname}}"  class="btn btn-xs btn-primary" title="分配角色"><i class="glyphicon glyphicon-indent-left"></i></button>
	</div>
</script>
<script src="${res}/js/chosen.jquery.min.js"></script>
<script src="${res}/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript">
	// DO NOT REMOVE : GLOBAL FUNCTIONS!
	ace.load_ajax_scripts([], function() {
	})
	seajs.use("${my}/js/sysMng/userSso/main", function(main) {
		main.init();
	});
</script>