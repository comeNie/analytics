<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>
<%@include file="../reportShows/reportShows.jsp"%><!-- 重要！添加/取消收藏,多维分析等功能均在其js中 add by wangxy -->
<!-- ajax layout which only needs content area -->
<div class="ajaxContent">
	<div class="page-header">
		<h1>
			${menu.name} <small> <i
				class="ace-icon fa fa-angle-double-right"></i> 输入报表条件
			</small>
		</h1>
	</div>
<!-- /.page-header -->
<!-- row -->
<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<!-- row -->
			<div class="col-xs-12">
				<form id="cr_form" class="form-horizontal" role="form">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">请选择机构：</label>
						<div class="col-sm-9">
							<select name="orgCd" id="orgCd" class="col-xs-10 col-sm-5 ">
								<c:if test="${curUser.premLevel=='1'}">
									<option value="0">所有小贷机构</option>
								</c:if>
								<c:if test="${curUser.premLevel=='1'}">
									<option value="01">所有小贷机构(不含天津鼎信)</option>
								</c:if>
								<c:if test="${curUser.premLevel=='1'}">
									<option value="">全部</option>
								</c:if>
								<c:if test="${curUser.premLevel=='1'}">
									<option value="02">全部(不含天津鼎信)</option>
								</c:if>
								<c:forEach items="${orgs}" var="org">
									<option value="${org.id}">${org.desc}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">请选择统计年月：</label>
						<div class="col-sm-9">
							<select class="col-xs-10 col-sm-3" name="year" id="year">
								<c:forEach items="${years}" var="v">
									<c:choose>
										<c:when test="${v==curYears}">
											<option value="${v}" selected="selected">${v}年</option>
										</c:when>
										<c:otherwise>
											<option value="${v}">${v}年</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select> <select class="col-xs-10 col-sm-2" name="month" id="month">
								<c:forEach items="${months}" var="v">
									<c:choose>
										<c:when test="${v==curMonths}">
											<option value="${v}" selected="selected">${v}月</option>
										</c:when>
										<c:otherwise>
											<option value="${v}">${v}月</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="clearfix form-actions">
						<div class="col-md-offset-3 col-md-9">
							<button class="btn btn-sm btn-yellow" type="button"
								role="download">
								<i class="ace-icon fa fa-download bigger-110"></i> 下载
							</button>
							&nbsp; &nbsp; &nbsp;
							<button class="btn btn-sm" type="reset" role="reset">
								<i class="ace-icon fa fa-undo bigger-110"></i> 重置
							</button>
							&nbsp; &nbsp; &nbsp; 
							<a id="reportId" class="btn btn-sm btn-purple">
								<i class="glyphicon glyphicon-book"></i> 指标说明
							</a>
							&nbsp; &nbsp; &nbsp; 
							<a id="storeId" class="btn btn-sm btn-purple"> <i
								class="glyphicon glyphicon-inbox"></i> 添加收藏
							</a>
							&nbsp; &nbsp; &nbsp; 
							<a id="cancelStore" class="btn btn-sm btn-purple"> 
								<i class="glyphicon glyphicon-inbox"></i> 取消收藏
						    </a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- end row -->
	</div>
</div>
<!-- end row -->
</div>

<div id="progressDiv" class="modal fade" data-backdrop="static"
	tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog" style="width: 80%">
		<div class="modal-content">
			<div class="progress" style="margin-bottom: 0px;">
				<div class="progress-bar progress-bar-info progress-bar-striped"
					role="progressbar" aria-valuenow="0" aria-valuemin="0"
					aria-valuemax="100">
					<input type="hidden" id="pageStep" name="pageStep"> <span
						class="text"></span>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	ace.load_ajax_scripts([], function() {
	})
	seajs.use("${my}/js/report/createReport/main", function(main) {
		main.init();
	});
</script>
<!-- /SCRIPT -->