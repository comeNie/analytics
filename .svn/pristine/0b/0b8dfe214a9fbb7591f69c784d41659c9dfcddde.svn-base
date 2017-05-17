<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>
<%@include file="../commons/page_header.jsp"%>
<!-- row -->
<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<!-- row -->
			<div class="col-xs-12">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">请选择机构：</label>
						<div class="col-sm-9">
							<select name="orgId" id="orgId" class="col-xs-8 col-sm-4">
								<option value="" selected="selected">全部</option>
								<c:if test="${fn:startsWith(selfOrgId, '100')}">
									<option value="all_detail_total">所有机构汇总</option>
								</c:if>
								<c:forEach items="${orgs}" var="org">
									<option value="${org.id}">${org.desc}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">请选择报表类型：</label>
						<div class="col-sm-9">
							<select name="reportType" id="reportType"
								class="col-xs-8 col-sm-4">
								<option value="">全部</option>
								<c:forEach items="${typeCodes }" var="tc">
									<option value="${tc.code }">${tc.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">请选择统计起始日期：</label>
						<div class="col-sm-9">
							<span class="input-icon input-icon-right"> <input
								id="startDate" type="text" id="form-field-2"
								placeholder="请选择统计起始日期" value="${now}" readonly="readonly">
								<i class="ace-icon fa fa-calendar"></i>
							</span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">请选择统计终止日期：</label>
						<div class="col-sm-9">
							<span class="input-icon input-icon-right"> <input
								id="endDate" type="text" id="form-field-2"
								placeholder="请选择统计终止日期" value="" readonly="readonly"> <i
								class="ace-icon fa fa-calendar"></i>
							</span>
						</div>
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
									<th>机构名称</th>
									<th>报表名称</th>
									<th>报表日期</th>
									<th>文件格式</th>
									<th>报表生成日期</th>
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
<!-- end row -->
<script type="x-tmpl-mustache" id="dt-row-operation">
	<div class="btn-group">
		<button role="download" data-file-path="{{filePath}}" class="btn btn-xs btn-info" title="下载"><i class="ace-icon fa fa-download"></i></button>
	</div>
</script>
<!-- SCRIPT -->
<script type="text/javascript">
	ace.load_ajax_scripts([], function() {
	})
	seajs.use("${my}/js/report/historyReport/main", function(main) {
		main.init();
	});
</script>
<!-- /SCRIPT -->