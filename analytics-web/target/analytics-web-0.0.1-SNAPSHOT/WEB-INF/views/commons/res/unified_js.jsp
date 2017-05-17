<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- basic scripts -->

<!--[if !IE]> -->
<script type="text/javascript">
	window.jQuery || document.write("<script src='${res}/js/jquery.min.js'>" + "<"+"/script>");
</script>
<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
	window.jQuery || document.write("<script src='${res}/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
	if ('ontouchstart' in document.documentElement)
		document.write("<script src='${res}/js/jquery.mobile.custom.min.js'>" + "<"+"/script>");
</script>
<script src="${res}/js/bootstrap.min.js"></script>

<!-- ace scripts -->
<script src="${res}/js/ace-elements.min.js"></script>
<script src="${res}/js/ace.min.js"></script>

<!-- time css -->
<script src="${res}/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="${res}/js/date-time/bootstrap-datepicker-cn.js"></script>
<script src="${res}/js/date-time/bootstrap-timepicker.min.js"></script>
<script src="${res}/js/date-time/daterangepicker.min.js"></script>

<!-- jquery form -->
<script type="text/javascript" src='${res}/js/jquery.form.min.js'></script>

<!-- jquery validation -->
<script type="text/javascript" src="${res}/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${res}/js/additional-methods.min.js"></script>
<script type="text/javascript" src="${res}/js/messages_zh.js"></script>
<script type="text/javascript" src="${my}/js/utils/validator.js"></script>
<link rel="stylesheet" href="${my}/css/validate.css" />

<script src="${res}/js/jquery.dataTables.min.js"></script>
<script src="${res}/js/jquery.dataTables.bootstrap.js"></script>

<script src="${res}/js/bootbox.min.js"></script>

<script src="${my}/js/commons.js"></script>
<script src="${my}/js/utils.js"></script>

<!-- mvc -->
<script src="${res}/js/underscore.min.js"></script>
<script src="${res}/js/backbone.min.js"></script>

<!-- template -->
<script src="${res}/js/mustache.min.js"></script>

<!-- module -->
<script src="${res}/js/sea.js"></script>
<script src="${my}/js/sea/config.js"></script>