<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>
<style type="text/css">
.t_dialog {
	width: 100%;
	display: none;
}
</style>
<div class="page-header">
	<h1>
		手工数据报送>数据报送 <small> <i
			class="ace-icon fa fa-angle-double-right"></i> 数据报送查询 <span
			class="my-button-group"> </span>
		</small>
	</h1>
</div>
<!--/.page-header -->
<!-- <div id="dateDetail" class="modal" data-backdrop="static" tabindex="-1">
	<div class="modal-dialog" style="width: 50%">
		<div class="modal-content">
			<form id="role-form" action="" class="form-horizontal"
				name="role-form" method="post"> -->
<div class="ajax-content">
<div id="dateDetail" tabindex="-1"
	class="modal fade bs-example-modal-lg" data-backdrop="static">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="form-horizontal">
				<div class="modal-header">
					<button id="close-detail" type="button" class="close"
						data-dismiss="modal">&times;</button>
					<h4 class="blue bigger">
						<i class="glyphicon glyphicon-eye-open"></i> 数据报送查看
					</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">报表编号：</label>
								<div class="col-sm-6">
									<input id="dateNo" type="text" name="no" value=""
										readonly="readonly" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">报表名称：</label>
								<div class="col-sm-6">
									<input id="dateName" type="text" name="name" value=""
										readonly="readonly" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">报表周期：</label>
								<div class="col-sm-6">
									<input id="dateCycle" type="text" name="cycle" value=""
										readonly="readonly" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">报送时限：</label>
								<div class="col-sm-6">
									统计周期后<input id="dateTimeLimit" type="text" name="time" value=""
										readonly="readonly" style="width: 30px" />天以内
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">填报机构：</label>
								<div class="col-sm-6">
									<input id="dateSubmitOrg" type="text" name="submitOrg" value=""
										readonly="readonly" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">查阅角色：</label>
								<div class="col-sm-6">
									<input id="dateCheckRole" type="text" name="checkRole" value=""
										readonly="readonly" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">汇总方式：</label>
								<div class="col-sm-6">
									<input id="dateSubType" type="text" name="subType" value=""
										readonly="readonly" class="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">报表：</label>
								<div class="col-sm-6">
									<input id="datePath" type="text" name="cycle" value=""
										readonly="readonly" class="form-control" placeholder="未报送"/>
								    <input id="realPath" type="hidden" name="realPath" value=""/>
								</div>
								<button class="btn btn-sm btn-primary" id="btn-saveRoleFunction">
									<i class="ace-icon fa fa-download"></i> 下载
								</button>
							</div>
						</div>
					</div>
				</div>
				<!-- </form> -->
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
							for="form-field-1">起始报送日期：</label> <span
							class="input-icon input-icon-right"> <input id="startDate"  style="width: 230px"
							type="text" placeholder="请选择起始报送日期" value="" readonly="readonly">
							<i class="ace-icon fa fa-calendar"></i>
						</span>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">终止报送日期：</label> <span
							class="input-icon input-icon-right"> <input id="endDate"  style="width: 230px"
							type="text" placeholder="请选择终止报送日期" value="" readonly="readonly">
							<i class="ace-icon fa fa-calendar"></i>
						</span>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">状态：</label>
						<select name="submitState" id="submitState"
							class="col-xs-8 col-sm-4"  style="width: 230px">
							<option value="" selected="selected">全部</option>
							<option value="0">未报送</option>
							<option value="1">已报送</option>
							<option value="3">已退回</option>
							<option value="2">已延迟</option>
						</select>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">填报周期：</label>
						<select name="cycle" id="cycle" class="col-xs-8 col-sm-4"
							 style="width: 230px">
							<option value="" selected="selected">全部</option>
							<option value="1">一次性填报</option>
							<option value="2">年报</option>
							<option value="3">半年报</option>
							<option value="4">季报</option>
							<option value="5">月报</option>
							<option value="6">旬报</option>
							<option value="7">周报</option>
						</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">报表名称：</label> <input id="name" type="text"
							name="name" style="width: 230px" />
					</div>
					<div class="clearfix form-actions">
						<div class="col-md-offset-3 col-md-9">
							<button id="query" class="btn btn-sm btn-purple" type="button"
							role="query">
							<i class="ace-icon fa fa-search bigger-110"></i> 查询
						</button>
						&nbsp; &nbsp; &nbsp;
						<button class="btn btn-sm" type="reset" role="reset">
							<i class="ace-icon fa fa-undo bigger-110"></i> 重置
						</button>
						</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<input type="hidden" id="id" value="">
		<!-- end row -->
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
									<th>填报周期</th>
									<th>统计开始日期</th>
									<th>统计结束日期</th>
									<th>报送日期</th>
									<th>创建部门</th>
									<th>创建人</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- end row -->
	</div>
</div>
<script type="x-tmpl-mustache" id="dt-row-operation">
	<div class="btn-group ">
		<button role="detail" value="{{id}}" name="{{submitId}}" class="btn btn-xs btn-info" title="查看"><i class="glyphicon glyphicon-eye-open"></i></button>
	</div>
</script>
<script type="text/javascript">
	ace.load_ajax_scripts([], function() {
	})
	seajs.use("${my}/js/dateSubmitQuery/main", function(main) {
		main.init();
	});
</script>
</div>