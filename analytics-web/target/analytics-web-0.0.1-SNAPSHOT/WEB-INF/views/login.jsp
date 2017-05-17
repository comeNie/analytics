<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="./commons/res/taglibs.jsp"%>
<!DOCTYPE html> 
<html lang="zh-cn">
	<head>
		<meta charset="utf-8">
		<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

		<title>东方邦信小贷综合统计系统</title>
		 
		<meta name="description" content="">
		<meta name="author" content="">

		<!-- Use the correct meta names below for your web application
			 Ref: http://davidbcalhoun.com/2010/viewport-metatag 
			 
		<meta name="HandheldFriendly" content="True">
		<meta name="MobileOptimized" content="320">-->
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="${res}/css/bootstrap.min.css">	
		<link rel="stylesheet" type="text/css" media="screen" href="${res}/css/font-awesome.min.css">

		<!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
		<link rel="stylesheet" type="text/css" media="screen" href="${res}/css/smartadmin-production.css">
		<link rel="stylesheet" type="text/css" media="screen" href="${res}/css/smartadmin-skins.css">	
		
		<!-- SmartAdmin RTL Support is under construction
			<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.css"> -->
		
		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/demo.css">

		<!-- FAVICONS -->
		<link rel="shortcut icon" href="${my}/img/favicon/favicon.ico" type="image/x-icon">
		<link rel="icon" href="${my}/img/favicon/favicon.ico" type="image/x-icon">

		<!-- GOOGLE FONT -->
		<!--20141011
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">
     -->


	</head>
	<body id="login" class="animated fadeInDown">
		<!-- possible classes: minified, no-right-panel, fixed-ribbon, fixed-header, fixed-width-->
		<header id="header">
			<!--<span id="logo"></span>-->

			<div id="logo-group">
				<span id="logo"> <img src="${my}/img/logo.png" alt="东方邦信"> </span>
				<!-- END AJAX-DROPDOWN -->
			</div>

			<span id="login-header-space"> <span class="hidden-mobile">没有账户?</span> <a href="mailto:zhtjxt_bxhr@coamc.com" class="btn btn-danger">申请登账户</a> </span>

		</header>

		<div id="main" role="main">

			<!-- MAIN CONTENT -->
			<div id="content" class="container">

				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-7 col-lg-8 hidden-xs hidden-sm">
						<h1 class="txt-color-blue login-header-big">东方邦信融通控股股份有限公司</h1>
						<div class="hero">
							<div class="pull-left login-desc-box-l">
								<!--
								<h4 class="paragraph-header">It's Okay to be Smart. Experience the simplicity of SmartAdmin, everywhere you go!</h4>
								-->
								<img src="${res}/img/demo/bxtj.png" alt="综合统计系统">
								<div class="login-app-icons">
									<a href="javascript:void(0);" class="btn btn-danger btn-sm">系统使用入门</a>
									<a href="javascript:void(0);" class="btn btn-danger btn-sm">移动报表介绍</a>
								</div>
							</div>
							<img src="${res }/img/demo/erebview.png" class="pull-right display-image" alt="" style="width:210px">
						</div>

            
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<h5 class="about-heading">东方邦信综合统计系统</h5>
								<p>&nbsp;&nbsp;&nbsp;&nbsp;●&nbsp;助您洞悉企业经营动态 </p>
				                <p>&nbsp;&nbsp;&nbsp;&nbsp;●&nbsp;全面、及时、准确，为企业经营决策提供依据 </p>
				                <p>&nbsp;&nbsp;&nbsp;&nbsp;●&nbsp;构建面向未来的IT环境 </p>
 							</div>
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<h5 class="about-heading">移动统计，无论在路上、办公室或任何地方</h5>
								
								<!--Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi voluptatem accusantium!-->
				                <p>&nbsp;&nbsp;&nbsp;&nbsp;●&nbsp;小贷业务统计分析 </p>
				                <p>&nbsp;&nbsp;&nbsp;&nbsp;●&nbsp;财务数据分析汇总 </p>
				                <p>&nbsp;&nbsp;&nbsp;&nbsp;●&nbsp;满足您全部移动统计分析需求</p>
							</div>
						</div>

					</div>
					<div class="col-xs-12 col-sm-12 col-md-5 col-lg-4">
						<div class="well no-padding">
							<form action="login" method="post" id="login-form" class="smart-form client-form">
								<header>
									用户登陆
								</header>
								<fieldset>
									<section>
										<label class="label">用户ID：</label>
										<label class="input"> <i class="icon-append fa fa-user"></i>
											<input type="required" name="username">
											<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i> 请填写用户名</b></label>
									</section>

									<section>
										<label class="label">密 码：</label>
										<label class="input"> <i class="icon-append fa fa-lock"></i>
											<input type="password" name="password"  >
											<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i> 请填写用户密码</b> </label>
										<div class="note">
											<a href="mailto:zhtjxt_bxhr@coamc.com">忘记密码?</a>
										</div>
									</section>

									<section>
										<label class="checkbox">
											<input type="checkbox" name="remember" checked="">
											<i></i>记住用户名</label>
									</section>
								</fieldset>
								<footer>
									<button type="submit" class="btn btn-primary">
										登录
									</button>
								</footer>
							</form>

						</div>
						<h5 class="text-center"> - 访问东方邦信其他应用系统 -</h5>
							<ul class="list-inline text-center">
								<li>
									<a href="javascript:void(0);" class="btn btn-primary btn-circle"><i class="fa fa-facebook"></i></a>
								</li>
								<li>
									<a href="javascript:void(0);" class="btn btn-info btn-circle"><i class="fa fa-twitter"></i></a>
								</li>
								<li>
									<a href="javascript:void(0);" class="btn btn-warning btn-circle"><i class="fa fa-linkedin"></i></a>
								</li>
							</ul>
					</div>
				</div>
			</div>

		</div>

		<!--================================================== -->	

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
		<script src="js/plugin/pace/pace.min.js"></script>

	    <!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
	    <!--  20141011
	    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	    -->
	    
	    <script src="static/libs/jquery.min.js"></script>
	    
	    
		<script> if (!window.jQuery) { document.write('<script src="js/libs/jquery-2.0.2.min.js"><\/script>');} </script>

	  
	  <!--20141011
	    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
		-->
		
		<script src="static/libs/jquery-ui.min.js"></script>
		
		
		<script> if (!window.jQuery.ui) { document.write('<script src="js/libs/jquery-ui-1.10.3.min.js"><\/script>');} </script>

		<!-- JS TOUCH : include this plugin for mobile drag / drop touch events 		
		<script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

		<!-- BOOTSTRAP JS -->		
		<script src="js/bootstrap/bootstrap.min.js"></script>

		<!-- CUSTOM NOTIFICATION -->
		<script src="js/notification/SmartNotification.min.js"></script>

		<!-- JARVIS WIDGETS -->
		<script src="js/smartwidgets/jarvis.widget.min.js"></script>
		
		<!-- EASY PIE CHARTS -->
		<script src="js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>
		
		<!-- SPARKLINES -->
		<script src="js/plugin/sparkline/jquery.sparkline.min.js"></script>
		
		<!-- JQUERY VALIDATE -->
		<script src="js/plugin/jquery-validate/jquery.validate.min.js"></script>
		
		<!-- JQUERY MASKED INPUT -->
		<script src="js/plugin/masked-input/jquery.maskedinput.min.js"></script>
		
		<!-- JQUERY SELECT2 INPUT -->
		<script src="js/plugin/select2/select2.min.js"></script>

		<!-- JQUERY UI + Bootstrap Slider -->
		<script src="js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>
		
		<!-- browser msie issue fix -->
		<script src="js/plugin/msie-fix/jquery.mb.browser.min.js"></script>
		
		<!-- FastClick: For mobile devices -->
		<script src="js/plugin/fastclick/fastclick.js"></script>
		
		<!--[if IE 7]>
			
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
			
		<![endif]-->

		<!-- MAIN APP JS FILE -->
		<script src="js/app.js"></script>

		<script type="text/javascript">
			runAllForms();

			$(function() {
				// Validation
				$("#login-form").validate({
					// Rules for form validation
					rules : {
						username : {
							required : true,
							email : false
						},
						password : {
							required : true,
							minlength : 1,
							maxlength : 20
						}
					},

					// Messages for form validation
					messages : {
						username : {
							required : '请输入用户ID',
							email : '请输入用户ID'
						},
						password : {
							required : '请输入密码'
						}
					},



					// Do not change code below
					errorPlacement : function(error, element) {
						error.insertAfter(element.parent());
					}
				});
			});
			if(window.location.href.indexOf('${ctx}/main')>=0){
				window.location.href="${ctx}";
			}
		</script>

	</body>
</html>