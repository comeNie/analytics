<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>
<div class="ajax-content">
	<div class="page-header">
		<h1>
			系统管理>报表说明维护 <small> <i
				class="ace-icon fa fa-angle-double-right"></i> 统计指标说明维护 <span
				class="my-button-group"><a id="btn-add"
					class="btn btn-sm btn-success"><i class="ace-icon fa fa-plus"></i>
						新增</a> </span>
			</small>
		</h1>
	</div>

	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="row">
				<div class="col-xs-12">
					<table id="tbl"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th width="5%">序号</th>
								<th width="15%">指标代码</th>
								<th width="20%">指标名称</th>
								<th width="50%">指标含义</th>
								<th width="10%">操作</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


	<div id="detail" class="modal fade bs-example-modal-lg"
		data-backdrop="static">
		<div class="modal-dialog modal-lg"  style="width:1100px">
			<div class="modal-content">
				<div class="form-horizontal">
					<div class="modal-header">
						<button id="close-detail" type="button" class="close"
							data-dismiss="modal">&times;</button>
						<h4 class="blue bigger">
							<i class="glyphicon glyphicon-eye-open"></i> 查看报表
						</h4>
					</div>
					<div class="modal-body">
						<!-- start -->
						<div class="row">
							<!-- row -->
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="row">
									<div class="col-xs-12">
										<table id="report-tbl"
											class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th>序号</th>
													<th>报表名称</th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<!-- </form> -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="updateOrAdd" class="modal fade bs-example-modal-lg"
		data-backdrop="static">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<form id="index-form"
					action="/analytics/statisticsIndex/updateIndex"
					class="form-horizontal" name="index-form" method="post">
					<div class="form-horizontal">
						<div class="modal-header">
							<button id="close-detail" type="button" class="close"
								data-dismiss="modal">&times;</button>
							<h4 class="blue bigger">
								<i class="glyphicon glyphicon-edit"></i> 统计指标修改
							</h4>
						</div>
						<input id="indexId" name="indexId" type="hidden" value="">
						<input id="flag" name="flag" type="hidden" value="">
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">指标代码：</label>
										<div class="col-sm-6">
											<input id="indexCode" type="text" name="indexCode" value=""
												class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">指标名称：<span
											class="red">*</span></label>
										<div class="col-sm-6">
											<input id="indexName" type="text" name="indexName" value=""
												class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">指标含义：<span
											class="red">*</span></label>
										<div class="col-sm-6">
											<input id="indexMeaning" type="text" name="indexMeaning"
												value="" class="form-control" />
										</div>
									</div>
									<div class="modal-footer">
										<button type="submit" id="btn-addIndex-submit"
											class="btn btn-sm btn-primary">
											<i class="ace-icon fa fa-save"></i> 确定
										</button>
										<button name="btn-cancel" type="button" class="btn btn-sm"
											data-dismiss="modal">
											<i class="ace-icon fa fa-times"></i> 取消
										</button>
									</div>
								</div>
							</div>
						</div>
						<!-- </form> -->
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="x-tmpl-mustache" id="dt-row-operation">
	<div class="btn-group ">
		<button role="update" value="{{id}}" class="btn btn-xs btn-info" title="修改"><i class="glyphicon glyphicon-edit"></i></button>
		<button role="delete" value="{{id}}" class="btn btn-xs btn-info" title="删除"><i class="glyphicon glyphicon-trash"></i></button>
		<button role="detail" value="{{id}}" class="btn btn-xs btn-info" title="查看"><i class="glyphicon glyphicon-eye-open"></i></button>
	</div>
</script>
<script type="text/javascript">
	ace.load_ajax_scripts([], function() {
	})
	seajs.use("${my}/js/statisticsIndex/main", function(main) {
		main.init();
	});
</script>