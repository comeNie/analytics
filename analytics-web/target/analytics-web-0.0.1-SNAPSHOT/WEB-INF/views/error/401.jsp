<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@include file="../../commons/taglibs.jsp" %> --%>
<%@include file="../commons/res/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh">
	<head>
		<base href="${ctx}/">
		<title>统计系统</title>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<meta name="description" content="Dashboard page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		
		<c:import url="../../commons/pre-include.jsp" charEncoding="UTF-8" />
		
		<!-- page specific plugin styles START -->
		<!-- page specific plugin styles END -->
		
		<!-- inline styles related to this page -->
		<script>var $$ctx = "${ctx}/";</script>
	</head>
	<body class="no-skin">
		
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>
			
			<div class="main-content">

				<div class="page-content">

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->

							<div class="error-container">
								<div class="well">
									<h1 class="grey lighter smaller">
										<span class="blue bigger-125">
											<i class="ace-icon fa fa-random"></i>
											401
										</span>
										Something Went Wrong
									</h1>

									<hr />
									<h3 class="lighter smaller">
										But we are working
										<i class="ace-icon fa fa-wrench icon-animated-wrench bigger-125"></i>
										on it!
									</h3>

									<div class="space"></div>

									<div>
										<h4 class="lighter smaller">Meanwhile, try one of the following:</h4>

										<ul class="list-unstyled spaced inline bigger-110 margin-15">
											<li>
												<i class="ace-icon fa fa-hand-o-right blue"></i>
												Read the faq
											</li>

											<li>
												<i class="ace-icon fa fa-hand-o-right blue"></i>
												Give us more info on how this specific error occurred!
											</li>
										</ul>
									</div>

									<hr />
									<div class="space"></div>

									<div class="center">
										<a href="javascript:history.back()" class="btn btn-grey">
											<i class="ace-icon fa fa-arrow-left"></i>
											Go Back
										</a>
									</div>
								</div>
							</div>

							<!-- PAGE CONTENT ENDS -->
						</div><!-- /.col -->
					</div><!-- /.row -->
				</div><!-- /.page-content -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->
		<!-- page specific plugin scripts START -->
		<!-- page specific plugin scripts END -->

		<!-- inline scripts related to this page -->
	</body>

</html>