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
			<form class="form-horizontal" id="form" method="post">
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="name">填报日期：</label>
					<div class="col-sm-5">
						<input type="text" id="fillDate" value="${strDate }" size="26" readonly="readonly" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right" for="name">填报机构：</label>
					<div class="col-sm-7">
						<input type="text" id="fillOrgName" value="${orgName }" size="26" readonly="readonly" />
					</div>
					<div class="col-sm-2">
						<button class="btn btn-sm btn-primary" type="button" role="save">
							<i class="ace-icon fa fa-file-text"></i> 保存
						</button>
					</div>
				</div>
				<div class="form-group">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th style="text-align: center;">序号</th>
								<th style="text-align: center;">填报项</th>
								<th style="text-align: center;">余额（单位：元）</th>
								<th style="text-align: center;">收益（单位：元）</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${boList }" var="bo">
								<tr>
									<td style="vertical-align:middle; text-align:center;">${bo.itemId }</td>
									<td style="vertical-align:middle; text-align:center;">${bo.itemName }</td>
									<td style="vertical-align:middle; text-align:center;">
										<input type="text" name="balance" id="${bo.itemId }" value="${bo.balance }" />
									</td>
									<td style="vertical-align:middle; text-align:center;">
										<input type="text" name="profit" id="${bo.itemId }" value="${bo.profit }" />
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="form-group">
					<label for="name">备注：</label>
				</div>
				<div class="form-group">
					<div class="col-sm-2">
						<textarea id="memo" rows="5" cols="120" maxlength="500" >${memo }</textarea>
					</div>
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