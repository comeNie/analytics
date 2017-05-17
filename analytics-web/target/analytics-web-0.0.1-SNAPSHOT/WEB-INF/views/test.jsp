<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./commons/res/taglibs.jsp"%>
<div class="page-header">
	<h1>
		资金头寸 
		<small>
			<i class="ace-icon fa fa-angle-double-right"></i>
			输入查询条件
		</small>
	</h1>
</div><!-- /.page-header -->
<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<form class="form-horizontal" role="form">
			<!-- #section:elements.form -->
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Text Field </label>

				<div class="col-sm-9">
					<input type="text" id="form-field-1" placeholder="Username" class="col-xs-10 col-sm-5">
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1"> Full Length </label>

				<div class="col-sm-9">
					<input type="text" id="form-field-1-1" placeholder="Text Field" class="form-control">
				</div>
			</div>


			<div class="clearfix form-actions">
				<div class="col-md-offset-3 col-md-9">
					<button class="btn btn-info" type="button">
						<i class="ace-icon fa fa-check bigger-110"></i>
						Submit
					</button>

					&nbsp; &nbsp; &nbsp;
					<button class="btn" type="reset">
						<i class="ace-icon fa fa-undo bigger-110"></i>
						Reset
					</button>
				</div>
			</div>

			<div class="hr hr-24"></div>

		</form>

	</div><!-- /.col -->
</div>
<script type="text/javascript">
ace.load_ajax_scripts([], function() {
})
</script>