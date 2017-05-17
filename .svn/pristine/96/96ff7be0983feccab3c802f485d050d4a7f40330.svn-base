<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>
<div class="page-header">
	<h1>
		${menu.name}
		<span class="my-button-group"> 
			<a id="btn-save" class="btn btn-sm btn-success">
			<i class="ace-icon fa fa-plus"></i>
			保 存</a>
			
			<button id="btn-submittedAudit" class="btn btn-sm btn-success" >
			<i class="ace-icon fa fa-plus"></i>
			上报审核</button>
		</span>
	</h1>
</div>
<style type="text/css">
	.main-left{border:1px solid #eee;text-align:center;height:200px}
	.main-left h4{font-size:16px;border-bottom:1px solid #eee;padding:10px 0px;}
	.main-left ul{list-style: none;line-height: 35px;margin:0 0 0 -13px; }
	.main-left ul li.current{color:red;}
	.main_right{border:1px solid #eee;}
	#uploadify{margin-top:10px;}
	.tags{width:80%;}
	.inline{width:52%}
	.input-group .form-control{width:342px}
	.input-group-addon, .input-group-btn{width:0%;}
</style>
<!-- /.page-header -->
<div class="row">
	<div class="col-xs-12">
		<form action="" class="form-horizontal" role="form" enctype="multipart/form-data" id="myform" method="post">
			<!-- #section:elements.form -->
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="templateId"> 报表编号 </label>
				<div class="col-sm-9">
					<input type="text" id="templateId" name="templateId" class="col-xs-10 col-sm-5" disabled />
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="templateName"> 报表名称 </label>
				<div class="col-sm-9">
					<input type="text" id="templateName" name="templateName" class="col-xs-10 col-sm-5" disabled />
				</div>
			</div>

			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="cycle"> 报表周期 </label>
				<div class="col-sm-9">
					<input type="text" name="cycle" id="cycle" class="col-xs-10 col-sm-5" disabled />
				</div>
			</div>

			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="timeLimit">报表时限:</label>
					<div class="col-sm-8">
						统计周期后&nbsp;
						<input disabled type="text" id="timeLimit" name="timeLimit" style="width:5%" maxlength="3" />&nbsp;&nbsp;&nbsp;天以内
					</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">填报机构</label>
				<div class="col-sm-9">
					<div class="inline">
						<div class="tags" id="submitOrg">
							<span class="tag">天津小贷</span>
							<span class="tag">东方金科</span>
						</div>
					</div>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right">查阅角色</label>
				<div class="col-sm-9">
					<div class="inline">
						<div class="tags" id="checkRole">
							<span class="tag">天津小贷负责人</span>
							<span class="tag">东方金科负责人</span>
						</div>
					</div>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="sumType"> 汇总方式</label>
				<div class="col-sm-9">
					<select type="text" id="sumType" name="sumType" class="col-xs-10 col-sm-5" disabled></select>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="sumType"> 汇总开始行</label>
				<div class="col-sm-9">
					<input type="text" id="startRow" name="startRow" class="col-xs-10 col-sm-5" disabled></input>
				</div>
			</div>
			
			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="path">报表模版</label>
				<div class="col-sm-9" style="width:62.5%">
					<input class="col-xs-10 col-sm-5" type="text" id="path" name="path" disabled />
					<button class="btn btn-info btn-sm" type="button" role="downloadBtn">
						<i class="ace-icon fa fa-download"></i>
						下载
					</button>
				</div>
			</div>

			<div class="space-4"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-tags">报表结果</label>
				<div class="col-sm-4">
					<input id="filename" name="filename" class="file" type="file" >
				</div>
			</div>

			<div class="clearfix form-actions">
				<div class="col-md-offset-3 col-md-9">
					<button class="btn btn-info" type="submit" id="fileBtn">
						<i class="ace-icon fa fa-check bigger-110"></i>
						提交上传
					</button>

					&nbsp; &nbsp; &nbsp;
					<button class="btn" type="reset">
						<i class="ace-icon fa fa-undo bigger-110"></i>
						重 置
					</button>
				</div>
			</div>

			<div class="hr hr-24"></div>
		</form>
	</div>
</div>
<!-- end row -->
<!-- <link rel="stylesheet" type="text/css" href="${res}/css/fileinput.css"> -->
<!-- <script src="${res}/js/fileinput/fileinput.js"></script> -->

<script type="text/javascript">
	// DO NOT REMOVE : GLOBAL FUNCTIONS!
	ace.load_ajax_scripts([], function() {})
	seajs.use("${my}/js/data/dataEntry/main", function(main) {
		new main();
	});
</script>
