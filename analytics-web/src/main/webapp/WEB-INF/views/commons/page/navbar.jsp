<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="request" />

<div id="navbar" class="navbar navbar-default">
	<script type="text/javascript">
		try{ace.settings.check('navbar' , 'fixed')}catch(e){};
		var $$ctx='${ctx}';
	</script>

	<div class="navbar-container" id="navbar-container">
		<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
			<span class="sr-only">Toggle sidebar</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		
		<div class="navbar-header pull-left">
			<a href="main#todoList" class="navbar-brand" style="pasition:absolute;margin-top:-13px;height: 58px">
				<small>
					<!-- <!-- <i class="fa fa-leaf"></i> -->
					<img alt="东方邦信" src="${my }/img/logo-dfbx.png">
					综合统计系统
				</small>
			</a>
		</div>

		<div class="navbar-buttons navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<li class="light-blue">
					<c:choose>
						<c:when test="${empty orgMap }">
							<a href="javascript:void(0);">
								<i class="ace-icon fa fa-bookmark"></i>
								<shiro:principal property="orgName"/>
								<!-- <i class="ace-icon fa fa-caret-down"></i> -->
							</a> 
						</c:when>
						<c:otherwise>
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<shiro:principal property="orgName"/>
								<i class="ace-icon fa fa-caret-down"></i>
							</a>
							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<c:forEach items="${orgMap }" var="org">
									<li><a href="checkOrgCode?orgCode=${org.key }">${org.value }</a></li>
									<%-- <li><input class="light-blue" id="${org.key }">${org.value }</a></li> --%>
								</c:forEach>
							</ul>
						</c:otherwise>
					</c:choose>
				</li>
				<li class="light-blue">
					<a data-toggle="dropdown" href="#" class="dropdown-toggle">
						<img class="nav-user-photo" src="${res}/avatars/user.jpg" alt="Jason's Photo" />
						<span class="user-info">
							<small>您好,</small>
							<shiro:principal property="userName"/>
						</span>
						<i class="ace-icon fa fa-caret-down"></i>
					</a>

					<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<!-- <li>
							<a href="#">
								<i class="ace-icon fa fa-cog"></i>
								设置
							</a>
						</li>

						<li>
							<a href="../profile.html">
								<i class="ace-icon fa fa-user"></i>
								个人资料
							</a>
						</li>

						<li class="divider"></li> -->

						<li>
							<a href="javascript:void(0);" id="singleSignOut">
								<i class="ace-icon fa fa-power-off"></i>
								登出
							</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>
<script>
	
</script>