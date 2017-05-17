<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>

<%@include file="../commons/page_header.jsp"%>
<style type="text/css">
.t_dialog {
	width: 100%;
	display: none;
}
</style>
<div class="row">
	<form class="form-horizontal" role="form">
		<div class="col-xs-12">
			<div class="row">
				<div class="col-xs-12">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">指标名称：</label>
						<div class="col-sm-9">
							<select name="names" id="names" class="col-xs-8 col-sm-4">
								<optgroup label="请选择指标">
									<c:forEach items="${indexs}" var="ind" varStatus="L">
										<option value="${ind[0]}">${ind[1]}</option>
									</c:forEach>
								</optgroup>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">月份：</label>
						<div class="col-sm-9">
							<select name="months" id="months" class="col-xs-8 col-sm-4">
								<optgroup label="请选择月份">
									<c:forEach items="${months}" var="month">
										<option value="${month}">${month}</option>
									</c:forEach>
								</optgroup>
							</select>
						</div>
					</div>
					<div class="clearfix form-actions">
						<div class="col-md-offset-8 col-md-10">
							<label> <input type="checkbox" id="iscopy" /> 复制上月数据
							</label>
							<button type="button" class="btn btn-primary btn-sm" id="init"
								role="init">初始化</button>
							&nbsp;
							<button type="button" class="btn btn-success btn-sm" id="save"
								role="save">保 存</button>
							&nbsp;
							<button type="button" class="btn btn-primary btn-sm" id="excelDownload" 
							    role="download" >下载Excel</button>
						</div>
					</div>
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
									<tr align="center">
										<th>序号</th>
										<th>机构</th>
										<th>数值（请保留两位小数）</th>
										<th>备注</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
					<div class="t_dialog">
						<center>
							<span class="ajax_msg"> <img src="${my}/img/loading.gif" />
							</span>
						</center>
					</div>
				</div>
			</div>
			<!-- end row -->
		</div>
		<textarea style="display: none;" id="hideText"></textarea>
	</form>
</div>
<!-- end row -->
<script type="text/javascript" src="${my}/js/data/fixednum/clipboard.js"></script>
<script type="text/javascript">
	// DO NOT REMOVE : GLOBAL FUNCTIONS!
	ace.load_ajax_scripts([], function() {
	})
	seajs.use("${my}/js/data/fixednum/main", function(main) {
		main.init();
	});
	//默认月份是当月
	$(function(){
		var d = new Date(),str="",year,month;
		year = d.getFullYear();
		month = d.getMonth()+1;
		if(month < 10){
			month="0"+month;//不足两位补零
		}
		str+=year+""+month;
		//遍历
		$("#months option").each(function(){
			if($(this).text() == str){
				$(this).attr("selected",true).text(str);
			}
		});
		
	});
	
</script>
