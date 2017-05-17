<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./commons/res/taglibs.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>综合统计系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<c:import url="./commons/res/css.jsp" />
		<script>var $$ctx = '${ctx}';var $$res = '${res}';var $$my = '${my}';</script>
	</head>
	<body class="no-skin">
		<input id="countStore" type="hidden" value="">
		<input id="userNameOfCognos" type="hidden" value="${userNameOfCognos }"><!-- 用户名 -->
		<input id="pswOfCognos" type="hidden" value="${pswOfCognos }"><!-- 密码 -->
		<c:import url="./commons/page/navbar.jsp" charEncoding="UTF-8"/>
		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container', 'fixed')}catch(e){}
			</script>
			<c:import url="./commons/page/sidebar.jsp" charEncoding="UTF-8"/>
			<!-- /section:basics/sidebar -->
			<div class="main-content">
				<c:import url="./commons/page/breadcrumbs.jsp" charEncoding="UTF-8"/>
				<div class="page-content">
					<%-- <c:import url="../commons/page/settings.jsp" /> --%>
					<!-- /section:settings.box -->
					<div class="page-content-area">
						<!-- ajax content goes here -->
					</div><!-- /.page-content-area -->
				</div><!-- /.page-content -->
			</div><!-- /.main-content -->
			<c:import url="./commons/page/footer.jsp" charEncoding="UTF-8"/>
		</div><!-- /.main-container -->
		<jsp:include page="./commons/res/js.jsp"></jsp:include>
	</body>
</html>