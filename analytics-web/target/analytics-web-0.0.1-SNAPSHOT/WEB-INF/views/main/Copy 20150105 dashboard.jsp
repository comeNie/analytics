<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>
<!-- row -->
<div class="row">
	<div  class="col-xs-12">
<!-- row -->
<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<div class="col-xs-12 widget-container-col ui-sortable">
				<div class="widget-box ui-sortable-handle">
					<div class="widget-header">
						<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i> </span>
						<h5 class="widget-title">新增贷款</h5>
						<!-- #section:custom/widget-box.toolbar -->
						<div class="widget-toolbar">
							<a href="#" data-action="fullscreen" class="orange2">
								<i class="ace-icon fa fa-expand"></i>
							</a>
		
							<!-- <a href="#" data-action="reload">
								<i class="ace-icon fa fa-refresh"></i>
							</a> -->
		
							<a href="#" data-action="collapse">
								<i class="ace-icon fa fa-chevron-up"></i>
							</a>
		
							<a href="#" data-action="close">
								<i class="ace-icon fa fa-times"></i>
							</a>
						</div>
						
					</div>
					<div class="widget-body">
						<div class="widget-main"><div id="dashboard_AddLoanArea"></div></div> 
					</div>
				</div>
		</div>
		</div>
	</div>
</div>
<!-- /row -->
<!-- row -->
<div class="row">
	<div class="col-xs-12">
		<!-- row -->
		<div class="row">
			<div class="col-xs-12 col-sm-6 widget-container-col">
				<div class="widget-box">
					<div class="widget-header">
						<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i> </span>
						<h5 class="widget-title">当前结存贷款-担保方式分类</h5>
							<!-- #section:custom/widget-box.toolbar -->
							<div class="widget-toolbar">
								<a href="#" data-action="fullscreen" class="orange2">
									<i class="ace-icon fa fa-expand"></i>
								</a>
	
								<!-- <a href="#" data-action="reload">
									<i class="ace-icon fa fa-refresh"></i>
								</a> -->
	
								<a href="#" data-action="collapse">
									<i class="ace-icon fa fa-chevron-up"></i>
								</a>
	
								<a href="#" data-action="close">
									<i class="ace-icon fa fa-times"></i>
								</a>
							</div>
					</div>
					<div class="widget-body no-padding">
						<div class="widget-main"><div id="dashboard_LbGuarModePie"></div></div>
					</div>
				</div>
		 	</div>
			<div class="col-xs-12 col-sm-6 widget-container-col">
				<div class="widget-box">
					<div class="widget-header">
						<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i> </span>
						<h5 class="widget-title">当前结存贷款-金额分类</h5>
								<!-- #section:custom/widget-box.toolbar -->
								<div class="widget-toolbar">
									<a href="#" data-action="fullscreen" class="orange2">
										<i class="ace-icon fa fa-expand"></i>
									</a>
		
									<!-- <a href="#" data-action="reload">
										<i class="ace-icon fa fa-refresh"></i>
									</a> -->
		
									<a href="#" data-action="collapse">
										<i class="ace-icon fa fa-chevron-up"></i>
									</a>
		
									<a href="#" data-action="close">
										<i class="ace-icon fa fa-times"></i>
									</a>
								</div>
						
					</div>
					<div class="widget-body no-padding">
						<div class="widget-main"><div id="dashboard_LbAmtPie"></div></div>
					</div>
				</div>
			</div>
		</div><!-- /row -->
	</div>
</div>
<!-- /row -->
<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<div class="col-xs-12 col-sm-6 widget-container-col ui-sortable">
				<div class="widget-box ui-sortable-handle">
					<div class="widget-header">
						<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i> </span>
						<div class="widget-title">结存贷款</div>
						<!-- #section:custom/widget-box.toolbar -->
						<div class="widget-toolbar">
							<a href="#" data-action="fullscreen" class="orange2">
								<i class="ace-icon fa fa-expand"></i>
							</a>
		
							<!-- <a href="#" data-action="reload">
								<i class="ace-icon fa fa-refresh"></i>
							</a> -->
		
							<a href="#" data-action="collapse">
								<i class="ace-icon fa fa-chevron-up"></i>
							</a>
		
							<a href="#" data-action="close">
								<i class="ace-icon fa fa-times"></i>
							</a>
						</div>
					</div>
					<div class="widget-body">
						<div class="widget-main">
							<div id="dashboard_LoanBalancesBar"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-6 widget-container-col ui-sortable">
				<div class="widget-box ui-sortable-handle">
					<div class="widget-header">
						<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i> </span>
						<div class="widget-title">新增贷款</div>
						<!-- #section:custom/widget-box.toolbar -->
						<div class="widget-toolbar">
							<a href="#" data-action="fullscreen" class="orange2">
								<i class="ace-icon fa fa-expand"></i>
							</a>
		
							<!-- <a href="#" data-action="reload">
								<i class="ace-icon fa fa-refresh"></i>
							</a> -->
		
							<a href="#" data-action="collapse">
								<i class="ace-icon fa fa-chevron-up"></i>
							</a>
		
							<a href="#" data-action="close">
								<i class="ace-icon fa fa-times"></i>
							</a>
						</div>
					</div>
					<div class="widget-body">
						<div class="widget-main">
							<div id="dashboard_addLoanLine"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
</div><!--/ row -->
<script src="${res_libs}/Highcharts-4.0.4/js/highcharts.js"></script>
<script src="${my}/js/dashboard.js"></script>
<script type="text/javascript">
ace.load_ajax_scripts([], function() {
})
dashboard.init();
</script>
