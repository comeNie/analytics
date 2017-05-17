<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./commons/res/taglibs.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>东方邦信小贷综合统计系统</title>

		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<!-- FAVICONS -->
		<link rel="shortcut icon" href="${my}/img/favicon/favicon.ico" type="image/x-icon">
		<link rel="icon" href="${my}/img/favicon/favicon.ico" type="image/x-icon">
		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${res}/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${res}/css/font-awesome.min.css" />
		<script src="${res}/js/jquery.min.js"></script>		
		<script src="${res}/js/bootstrap.min.js"></script>		
		<script>var $$ctx = '${ctx}';var $$res = '${res}';var $$my = '${my}';</script>
	</head>
	
<body>
	<div class="container">
		<div class="panel panel-danger">
	      <div class="panel-heading">
	        <h2 class="panel-title"><span class="glyphicon glyphicon-info-sign"></span>子系统登录失败</h2>
	      </div>
	      <div class="panel-body">
	      	<h4>该系统用户信息暂时不存在，请联系管理员！如有需要，请进入门户选择其他系统！</h4>
	      	<h1><a href="${portalUrl}">门户</a></h1>
	      </div>
	    </div>
	</div>
</body>
</html>