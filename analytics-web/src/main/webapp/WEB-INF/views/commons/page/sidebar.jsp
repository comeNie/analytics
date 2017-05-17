<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- #section:basics/sidebar -->
<div id="sidebar" class="sidebar responsive">
	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
	</script>
	<ul class="nav nav-list">
		<li class="">
			<a data-url="dashboard" href="main#dashboard">
				<i class="menu-icon fa fa-tachometer"></i>
				<span class="menu-text"> 管理看板 </span>
			</a>
			<b class="arrow"></b>
		</li>
		<%-- <li class="">
			<a data-url="todoList" href="main#todoList">
				<i class="menu-icon fa fa-flag-o"></i>
				<span class="menu-text""> 工作面板 
	 			 <c:choose>
				 <c:when test='${todoListToltal>=1}'>
				 <span id="todoListToltalNum" style="padding:3px 8px; border-radius:4px; background:#ff4000; color:#fff;">${todoListToltal}</span>
				 </c:when>
				 </c:choose>
				</span>
			</a>
			<b class="arrow"></b>
		</li> --%>
		<c:choose>
			<c:when test='${ifTodoList == "1" }'>
				<li class="">
					<a data-url="todoList" href="main#todoList">
						<i class="menu-icon fa fa-flag-o"></i>
						<span class="menu-text""> 工作面板 
				 			 <c:choose>
								 <c:when test='${todoListToltal>=1}'>
								 	<span id="todoListToltalNum" style="padding:3px 8px; border-radius:4px; background:#ff4000; color:#fff;">${todoListToltal}</span>
								 </c:when>
							 </c:choose>
						</span>
					</a>
					<b class="arrow"></b>
				</li>
			</c:when>
		</c:choose>
		<li class="">
			<a href="#" class="dropdown-toggle">
				<i class="menu-icon fa fa-folder"></i>
				<span class="menu-text"> 我的收藏夹</span>
				<b class="arrow fa fa-angle-down"></b>
			</a>
			<b class="arrow"></b>
			<ul class="submenu">
				<!-- <li class="">
					<a href="#" class="dropdown-toggle">
						<i class="menu-icon fa fa-caret-right"></i>
						收藏的报表
						<b class="arrow fa fa-angle-down"></b></a>
						<b class="arrow"></b>
					<ul class="submenu"> -->
				<c:forEach items="${mblist}" var="store_menu">
					<li class="">
						<a data-url="bizReport/store?type=${store_menu.actionType }&functionId=${store_menu.id}" href="main#bizReport/store?type=${store_menu.actionType }&functionId=${store_menu.id}">
							<i class="menu-icon fa fa-caret-right"></i>
								${store_menu.name }
						</a>
						<b class="arrow fa fa-angle-down"></b>
						<b class="arrow"></b>
					</li>
				</c:forEach>
					<!-- </ul>
				</li> -->
			</ul>
		</li>
		<c:forEach items="${menuList}" var="f_menu">
				<li class="">
					<a href="#" class="dropdown-toggle">
						<i class="menu-icon fa fa-folder"></i>
						<span class="menu-text"> ${f_menu.name }</span>
						<b class="arrow fa fa-angle-down"></b>
					</a>
					<b class="arrow"></b>
					<ul class="submenu">
						<c:forEach items="${f_menu.children}" var="s_menu">
						<li class="">
							<a href="#" class="dropdown-toggle">
								<i class="menu-icon fa fa-caret-right"></i>
								${s_menu.name }
								<b class="arrow fa fa-angle-down"></b></a>
								<b class="arrow"></b>
							<ul class="submenu">
								<c:forEach items="${s_menu.children}" var="t_menu">
								<li class="">
									<c:choose>
									<c:when test="${t_menu.action=='DoCognosBWXDAction' }">
										<a data-url="bizReport?type=${t_menu.actionType }&functionId=${t_menu.id}" href="main#bizReport?type=${t_menu.actionType }&functionId=${t_menu.id}">
										<i class="menu-icon fa fa-caret-right"></i>
										${t_menu.name }</a>
										<b class="arrow"></b>
									</c:when>
									<c:when test="${t_menu.actionType=='SYS' }">
										<a data-url="${t_menu.action}?functionId=${t_menu.id}" href="main#${t_menu.action}?functionId=${t_menu.id}">
										<i class="menu-icon fa fa-caret-right"></i>
										${t_menu.name }</a>
										<b class="arrow"></b>
									</c:when>
									<c:when test="${t_menu.actionType=='templMng' }">
										<a data-url="${t_menu.action}?type=${t_menu.action}" href="main#${t_menu.action}?type=${t_menu.action}">
										<i class="menu-icon fa fa-caret-right"></i>
										${t_menu.name }</a>
										<b class="arrow"></b>
									</c:when>  
									<c:otherwise>
										<a data-url="historyReport?functionId=${t_menu.id}" href="main#historyReport?functionId=${t_menu.id}">
										<i class="menu-icon fa fa-caret-right"></i>
										${t_menu.name }</a>
										<b class="arrow"></b>
									</c:otherwise>
									</c:choose>
								</li>
								</c:forEach>
							</ul>
						</li>
						</c:forEach>
					</ul>
				</li>
			</c:forEach>
	</ul><!-- /.nav-list -->

	<!-- #section:basics/sidebar.layout.minimize -->
	<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
		<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>

	<!-- /section:basics/sidebar.layout.minimize -->
	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
	</script>
	<script type="text/javascript">
		function clear(){
		  return true;
		}
	</script>
</div>