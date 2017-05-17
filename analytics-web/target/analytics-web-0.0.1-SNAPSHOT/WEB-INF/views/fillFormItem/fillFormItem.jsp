<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>

<style>
small {
	font-family: "Microsoft YaHei";
}
</style>
<div class="ajax-content">
	<div class="page-header">
		<h1>
			资金头寸表填报<small> <i class="ace-icon fa fa-angle-double-right"></i>资金头寸表填报</small>
		</h1>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<form class="form-horizontal" role="form" method="post">
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="name">填报日期：</label>
					<div class="col-sm-4">
						<input type="text" id="fillDate" value="" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="name">填报机构：</label>
					<div class="col-sm-4">
						<input type="text" id="fillOrgName" value="" />
					</div>
					<!-- <label class="col-sm-2 control-label no-padding-right" for="name">保存</label> -->
					<div class="col-sm-4">
						<button class="btn btn-sm btn-primary" type="button" role="uploadExcel">
							<i class="ace-icon fa fa-file-text"></i> 保存
						</button>
					</div>
				</div>
				<div class="clearfix form-actions">
					<span class="my-button-group"> 
						<a id="btn-add" class="btn btn-sm btn-primary"><i class="ace-icon fa fa-plus"></i>新增</a>
						<button class="btn btn-sm btn-primary" type="button" role="exportExcel">
							<i class="ace-icon fa fa-cloud-download"></i> 导出数据
						</button>
					</span>
				</div>
			</form>
		</div>
	</div>
</div>
<script src="${res}/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="${res}/js/date-time/bootstrap-datepicker-cn.js"></script>
<script src="${res}/js/date-time/bootstrap-timepicker.min.js"></script>
<script src="${res}/js/date-time/daterangepicker.min.js"></script>
<script type="text/javascript">
	ace.load_ajax_scripts([], function() {
	});
	seajs.use("${my}/js/fillFormItem/main", function(main) {
		$(".datepicker").datepicker({
			minView : "month", //选择日期后，不会再跳转去选择时分秒 
			format : "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
			language : 'zh-CN', //汉化 
			autoclose : true
		//选择日期后自动关闭 
		});
		/* $("#arriveDate_add").datepicker({
			minView : "month", //选择日期后，不会再跳转去选择时分秒 
			format : "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
			language : 'zh-CN', //汉化 
			autoclose : true
		//选择日期后自动关闭 
		}); */
		main.init();
	});
</script>