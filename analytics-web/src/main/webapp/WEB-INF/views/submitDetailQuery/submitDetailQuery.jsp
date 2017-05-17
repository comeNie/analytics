<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		手工数据报送>数据报送 <small> <i
			class="ace-icon fa fa-angle-double-right"></i> 报送情况查询 <span
			class="my-button-group"> </span>
		</small>
	</h1>
</div>
<!-- /.page-header -->
<!-- row -->
<!-- <div id="submitDetail" class="modal" data-backdrop="static"
	tabindex="-1">
	<div class="modal-dialog" style="width: 50%">
		<div class="modal-content"> -->
<div id="submitDetail" tabindex="-1"
	class="modal fade bs-example-modal-lg" data-backdrop="static">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="form-horizontal">
				<div class="modal-header">
					<button id="close-detail" type="button" class="close"
						data-dismiss="modal">&times;</button>
					<h4 class="blue bigger">
						<i class="glyphicon glyphicon-eye-open"></i> 报表情况信息
					</h4>
				</div></br>
				<!-- <form id="role-form" action="" class="form-horizontal"
				name="role-form" method="post"> -->
				<input id="id" type="hidden" value="">
				<input id="workflowId" type="hidden" value="">
				<div style="border: 2px">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label>报表编号：</label>
					<input id="detailNo" type="text" name="no" value=""
						readonly="readonly" style="width: 260px" /> 
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>报表名称：</label>
					<input id="detailName" type="text" name="name" value=""
						readonly="readonly" style="width: 260px" /></br> </br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label>报表周期：</label>
					<input id="detailCycle" type="text" name="cycle" value=""
						readonly="readonly" style="width: 260px" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label>报送日期：</label>
					<input id="detailTime" type="text" name="time" value=""
						readonly="readonly" style="width: 260px" />
				</div>
				<div class="modal-body">
					<!-- start -->
					<div class="row">
						<!-- row -->
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="row">
								<div class="col-xs-12">
									<table id="detail-tbl"
										class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>序号</th>
												<th>报送机构</th>
												<th>报送状态</th>
												<th>报送日期</th>
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
					<!-- end -->
				</div>
			</div>
		</div>
	</div>
</div>

<!-- row -->
<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<!-- row -->
			<div class="col-xs-12">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">数据截止日期的起始时间：</label> <span
							class="input-icon input-icon-right"> <input id="startTime"
							type="text" placeholder="数据截止日期的起始时间" value="" style="width: 230px"
							readonly="readonly"> <i class="ace-icon fa fa-calendar"></i>
						</span>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">数据截止日期的终止时间：</label> <span
							class="input-icon input-icon-right"> <input id="endTime" style="width: 230px"
							type="text" placeholder="数据截止日期的终止时间" value=""
							readonly="readonly"> <i class="ace-icon fa fa-calendar"></i>
						</span>
					</div>
					<!-- <div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">报送截止日期时间段：</label>
						<span class="input-icon input-icon-right"> <input
							id="startTime" type="text" for="form-field-1"
							placeholder="请选择截止日期的开始日期" value="">
							<i class="ace-icon fa fa-calendar"></i>
						</span> <span class="input-icon input-icon-right"> <input
							id="endTime" type="text" for="form-field-1"
							placeholder="请选择截止日期的终止日期" value="">
							<i class="ace-icon fa fa-calendar"></i>
						</span>
					</div> -->
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">状态：</label> <select name="sumState"
							id="sumState" class="col-xs-8 col-sm-4" style="width: 230px">
							<option value="" selected="selected">全部</option>
							<option value="0">未汇总</option>
							<option value="1">已汇总</option>
							<option value="2">已发布</option>
						</select>
					</div>
					
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">填报周期：</label> <select name="cycle" id="cycle"
							class="col-xs-8 col-sm-4" style="width: 230px">
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
							for="form-field-1">报表名称：</label> <input type="text" name="name"
							id="name" style="width: 230px" />
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
						</div>
					</div>
				</form>
			</div>
		</div>
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
									<th>状态</th>
									<th>创建人</th>
									<th>已报送/应报送</th>
									<th>操作</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- end row -->
	</div>
</div>
</div>
<script type="x-tmpl-mustache" id="dt-row-operation">
	<div class="btn-group ">
		<button role="detail" value="{{id}}" name="{{workflowId}}" class="btn btn-xs btn-info" title="查看"><i class="glyphicon glyphicon-eye-open"></i></i></button>
	</div>
</script>
<script type="x-tmpl-mustache" id="dt-row-detail-operation">
	<div class="btn-group ">
		<button role="download" data-file-path="{{filePath}}" class="btn btn-xs btn-info" title="下载"><i class="ace-icon fa fa-download"></i></button>
	</div>
</script>
<script type="text/javascript">
	ace.load_ajax_scripts([], function() {
	})
	seajs.use("${my}/js/submitDetailQuery/main", function(main) {
		main.init();
	});
</script>