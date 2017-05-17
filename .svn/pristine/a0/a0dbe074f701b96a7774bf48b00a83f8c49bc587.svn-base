<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>

<style>
small {
	font-family: "Microsoft YaHei";
}
</style>
<style type="text/css">
	.t_dialog {
	width: 100%;
	display: none;
	}
	.fileInput{width:102px;height:34px; background:blue
	;}
	.upfile{}
	.upFileBtn{position:absolute;width:102px;height:34px;cursor:pointer;color:#fff;background:#428bca;border:none;}
</style>
<div class="ajax-content">
	<div class="page-header">
		<h1>
			监控报告管理 <small> <i class="ace-icon fa fa-angle-double-right"></i>监控报告管理</small>
		</h1>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="row">
				<div class="col-xs-12">
					<div class="clearfix form-actions">
						<span class="my-button-group"> 
							<a id="btn-add" class="btn btn-sm btn-primary"><i class="ace-icon fa fa-plus"></i>新增</a>
						</span>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<div class="row">
						<div class="col-xs-12">
							<table id="tbl" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>序号</th>
										<th>业务类型</th>
										<th>事件时间</th>
										<th>事件名称</th>
										<th>事件报告</th>
										<th>上传时间</th>
										<th id="operate" width="8%">操作</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 新增 -->
	<div id="add-modal" class="modal" data-backdrop="static" tabindex="-1">
		<div class="modal-dialog" style="width:60%">
			<div class="modal-content" >
				<form action="${ctx}/monitorMng/doAdd" id="add-form"  class="form-horizontal" name="add-form" method="post" enctype="multipart/form-data">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="blue bigger">事件上传</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12">
								<div class="form-group">
									<label class="col-sm-2 control-label no-padding-right" for="name" >业务类型<font color='red'>*</font></label>
									<div class="col-sm-6">
										<select name="type" id="type" class="col-xs-8 col-sm-6">
											<option value="1">注册</option>
											<option value="2">充值</option>
											<option value="3">提现</option>
											<option value="4">投资</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label no-padding-right" for="name" >事件时间<font color='red'>*</font></label>
									<div class="col-sm-5">
										<input id="theDate" name="theDate" class="datepicker" type="text" readonly="readonly" placeholder="请选择事件时间"> 
										<i class="ace-icon fa fa-calendar"></i>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label no-padding-right" for="name" >事件名称<font color='red'>*</font></label>
									<div class="col-sm-5">
										<input type="text"  id="name" name="name" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label no-padding-right" for="name" >事件报告<font color='red'>*</font></label>
									<div class="col-sm-5">
										<input type="file" id=uploadFile name="uploadFile" />
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" role="btn-doAdd" class="btn btn-sm btn-primary">
							<i class="ace-icon fa fa-save"></i> 保存
						</button>
						<button type="button" role="btn-reset" class="btn btn-sm btn-primary">
							<i class="ace-icon fa fa-save"></i> 重置
						</button>
						<button type="button" name="btn-cancel" class="btn btn-sm" data-dismiss="modal">
							<i class="ace-icon fa fa-times"></i> 取消
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 查看 -->
	<div id="view-modal" class="modal" data-backdrop="static" tabindex="-1">
		<div class="modal-dialog" style="width:50%">
			<div class="modal-content" >
				<form id="view-form"  class="form-horizontal" name="view-form">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="blue bigger">事件查看</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12">
								<div class="form-group">
									<label class="col-sm-2 control-label no-padding-right" for="name" >业务类型</label>
									<div class="col-sm-5">
										<input id="type_view" name="type" type="text" size="30" readonly="readonly"> 
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label no-padding-right" for="name" >事件时间</label>
									<div class="col-sm-5">
										<input id="theDate_view" name="theDate" type="text" size="30" readonly="readonly"> 
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label no-padding-right" for="name" >事件名称</label>
									<div class="col-sm-5">
										<input type="text"  id="name_view" name="name" size="30" readonly="readonly"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label no-padding-right" for="name" >上传时间</label>
									<div class="col-sm-5">
										<input type="text"  id="uploadTime" name="uploadTime" size="30" readonly="readonly"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label no-padding-right" for="name" >文件下载</label>
									<div class="col-sm-5">
										<input type="text" id="downloadFile" name="downloadFile" size="30" readonly="readonly"/>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" role="download" id="download" class="btn btn-info btn-sm" title="下载" data-dismiss="modal">
							<i class="glyphicon glyphicon-save">下载</i>
						</button>
						<button type="button" name="btn-cancel" class="btn btn-sm" data-dismiss="modal">
							<i class="ace-icon fa fa-times"></i> 取消
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<script src="${res}/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="${res}/js/date-time/bootstrap-datepicker-cn.js"></script>
<script src="${res}/js/date-time/bootstrap-timepicker.min.js"></script>
<script src="${res}/js/date-time/daterangepicker.min.js"></script>
<script type="text/javascript">
	function getPath(){
		$(document).ready(function () {
			$('#filenameOfliulan').html($('#uploadFile').val());
		});
	}
</script>
<script type="text/javascript">
	ace.load_ajax_scripts([], function() {
	});
	seajs.use("${my}/js/monitorMng/main", function(main) {
		$(".datepicker").datepicker({
			minView : "month", //选择日期后，不会再跳转去选择时分秒 
			format : "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
			language : 'zh-CN', //汉化 
			autoclose : true//选择日期后自动关闭 
		});
		
		main.init();
	});
</script>