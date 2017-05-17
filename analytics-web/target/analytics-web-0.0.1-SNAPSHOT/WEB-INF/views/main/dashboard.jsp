<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/res/taglibs.jsp"%>
<div class="breadcrumbs" id="breadcrumbs">
	<ul class="breadcrumb">
		<li>
			<i class="ace-icon fa fa-home home-icon"></i>
			<span>主页</span>
		</li>
		<li>
			<span>管理看板</span>
		</li>
	</ul>
</div>
<br>
<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="tabbable">
			<ul class="nav nav-tabs padding-18 tab-size-bigger" id="myTab">
				<c:if test="${fn:contains(listToString, '2001001')}">
					<input type=hidden id="picture1" name="picture1" value="yes" />
					<li class="active"><a data-toggle="tab" href="#faq-tab-1">
							<i class="blue ace-icon fa fa-info-circle bigger-120"></i>
							结存贷款
					</a></li>
				</c:if>

				<c:if test="${fn:contains(listToString, '2001002')}">
					<input type=hidden id="picture2" name="picture2" value="yes" />
					<li><a data-toggle="tab" href="#faq-tab-2"> <i
							class="green ace-icon fa fa-user bigger-120"></i> 投放贷款
					</a></li>
				</c:if>

				<c:if test="${fn:contains(listToString, '2001003')}">.
									<input type=hidden id="picture3" name="picture3" value="yes" />
					<li><a data-toggle="tab" href="#faq-tab-3"> <i
							class="orange ace-icon fa fa-check-circle-o bigger-120"></i>
							回收贷款
					</a></li>
				</c:if>

				<c:if test="${fn:contains(listToString, '2001004')}">
					<input type=hidden id="picture4" name="picture4" value="yes" />
					<li><a data-toggle="tab" href="#faq-tab-4"> <i
							class="yellow ace-icon fa fa-credit-card bigger-120"></i>
							预计回收贷款
					</a></li>
				</c:if>
				
				<c:if test="${fn:contains(listToString, '2001005')}">
					<input type=hidden id="picture5" name="picture5" value="yes" />
					<li><a data-toggle="tab" href="#faq-tab-5"> <i
							class="red ace-icon fa fa-question-circle bigger-120"></i>
							逾期贷款
					</a></li>
				</c:if>
			</ul>
			
            <input type=hidden id="currentMonth" name="currentMonth" value="${currentMonth}" />
            <input type=hidden id="nextMonth" name="nextMonth" value="${nextMonth}" />

			<div class="tab-content no-border padding-24">

				<c:if test="${fn:contains(listToString, '2001001')}">
					<div id="faq-tab-1" class="tab-pane fade in active">
						<div class="row">
						<div class="col-xs-12 widget-container-col ui-sortable">
							<div class="widget-box">
								<div class="widget-header">
									<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i>
									</span>
									<h5 class="widget-title"></h5>
									<!-- #section:custom/widget-box.toolbar -->
									<div class="widget-toolbar">
										<a href="#" data-action="fullscreen" class="orange2"> <i
											class="ace-icon fa fa-expand"></i>
										</a>

										<!-- <a href="#" data-action="reload">
									<i class="ace-icon fa fa-refresh"></i>
								</a> -->

										<a href="#" data-action="collapse"> <i
											class="ace-icon fa fa-chevron-up"></i>
										</a> 
									<!--	<a href="#" data-action="close"> <i
											class="ace-icon fa fa-times"></i>
										</a>-->
									</div>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<div id="picture1_1"></div>
										<div style="padding-left: 18px">
											<table border="2">
												<tr height="45px">
													<td style="color: #424200; width: 80px; text-align: center; font-size: 20px">
														<strong> 月份 </strong>
													</td>
													<c:forEach items="${monthOfCurrentYear}" var="item">
														<td style="width: 63px; text-align: center;">
															${item}</td>
													</c:forEach>
												</tr>
												<tr height="45px">
													<td style="color: #4572A7; width: 80px; text-align: center; font-size: 20px">
														<strong> 金额 </strong>
													</td>
													<c:forTokens items="${list11}" var="item" delims="@">
														<td style="width: 63px; text-align: center;">
															${item}</td>
													</c:forTokens>
												</tr>
												<tr height="45px">
													<td style="color: #89A54E; width: 80px; text-align: center; font-size: 20px">
														<strong> 户数 </strong>
													</td>
													<c:forEach items="${list12}" var="item">
														<td style="width: 63px; text-align: center;">
															${item}</td>
													</c:forEach>
												</tr>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
					<div class="col-xs-12">
						<div class="row">
							<div class="col-xs-12 widget-container-col ui-sortable">
								<div class="widget-box ui-sortable-handle">
									<div class="widget-header">
										<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i>
										</span>
										<h5 class="widget-title"></h5>
										<!-- #section:custom/widget-box.toolbar -->
										<div class="widget-toolbar">
											<a href="#" data-action="fullscreen" class="orange2"> <i
												class="ace-icon fa fa-expand"></i>
											</a>

											<!-- <a href="#" data-action="reload">
													<i class="ace-icon fa fa-refresh"></i>
											</a> -->

											<a href="#" data-action="collapse"> <i
												class="ace-icon fa fa-chevron-up"></i>
											</a>
											<!-- <a href="#" data-action="close"> <i
												class="ace-icon fa fa-times"></i>
											</a> -->
										</div>

									</div>
									<div class="widget-body">
										<div class="widget-main">
											<div id="picture1_2"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
	<!-- /row -->
		<c:if test="${fn:contains(listToString,'2001002')}">
			<div id="faq-tab-2" class="tab-pane fade">

					<div class="row">
						<div class="col-xs-12 widget-container-col ui-sortable">
							<div class="widget-box">
								<div class="widget-header">
									<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i>
									</span>
									<h5 class="widget-title"></h5>
									<!-- #section:custom/widget-box.toolbar -->
									<div class="widget-toolbar">
										<a href="#" data-action="fullscreen" class="orange2"> <i
											class="ace-icon fa fa-expand"></i>
										</a>

										<!-- <a href="#" data-action="reload">
									<i class="ace-icon fa fa-refresh"></i>
								</a> -->

										<a href="#" data-action="collapse"> <i
											class="ace-icon fa fa-chevron-up"></i>
										</a> 
										<!--<a href="#" data-action="close"> <i
											class="ace-icon fa fa-times"></i>
										</a>-->
									</div>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<div id="picture2_1"></div>
										<div style="padding-left: 18px">
											<table border="2">
												<tr height="45px">
													<td
														style="color: #424200; width: 80px; text-align: center; font-size: 20px">
														<strong> 月份 </strong>
													</td>
													<c:forEach items="${monthOfCurrentYear}" var="item">
														<td style="width: 63px; text-align: center;">
															${item}</td>
													</c:forEach>
												</tr>
												<tr height="45px">
													<td
														style="color: #4572A7; width: 80px; text-align: center; font-size: 20px">
														<strong> 金额 </strong>
													</td>
													<c:forTokens items="${list21}" var="item" delims="@">
														<td style="width: 63px; text-align: center;">${item}
														</td>

													</c:forTokens>
												</tr>
												<tr height="45px">
													<td
														style="color: #89A54E; width: 80px; text-align: center; font-size: 20px">
														<strong> 户数 </strong>
													</td>
													<c:forEach items="${list22}" var="item">
														<td style="width: 63px; text-align: center;">${item}
														</td>

													</c:forEach>
												</tr>
												<tr height="45px">
													<td
														style="color: #9F4D95; width: 80px; text-align: center; font-size: 20px">
														<strong> 笔数 </strong>
													</td>
													<c:forEach items="${list23}" var="item">
														<td style="width: 63px; text-align: center;">${item}
														</td>

													</c:forEach>
												</tr>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				<div class="row">
					<div class="col-xs-12">
						<div class="row">
							<div class="col-xs-12 widget-container-col ui-sortable">
								<div class="widget-box ui-sortable-handle">
									<div class="widget-header">
										<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i>
										</span>
										<h5 class="widget-title"></h5>
										<!-- #section:custom/widget-box.toolbar -->
										<div class="widget-toolbar">
											<a href="#" data-action="fullscreen" class="orange2"> <i
												class="ace-icon fa fa-expand"></i>
											</a>

											<!-- <a href="#" data-action="reload">
								<i class="ace-icon fa fa-refresh"></i>
							</a> -->

											<a href="#" data-action="collapse"> <i
												class="ace-icon fa fa-chevron-up"></i>
											</a> 
											<!--<a href="#" data-action="close"> <i
												class="ace-icon fa fa-times"></i>
											</a>-->
										</div>

									</div>
									<div class="widget-body">
										<div class="widget-main">
											<div id="picture2_2"></div>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		
		
		<c:if test="${fn:contains(listToString,'2001003')}">
			<div id="faq-tab-3" class="tab-pane fade">
				<div class="row">
						<div class="col-xs-12 widget-container-col ui-sortable">
							<div class="widget-box">
								<div class="widget-header">
									<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i>
									</span>
									<h5 class="widget-title"></h5>
									<!-- #section:custom/widget-box.toolbar -->
									<div class="widget-toolbar">
										<a href="#" data-action="fullscreen" class="orange2"> <i
											class="ace-icon fa fa-expand"></i>
										</a>

										<!-- <a href="#" data-action="reload">
									<i class="ace-icon fa fa-refresh"></i>
								</a> -->

										<a href="#" data-action="collapse"> <i
											class="ace-icon fa fa-chevron-up"></i>
										</a>
										<!-- <a href="#" data-action="close"> <i
											class="ace-icon fa fa-times"></i>
										</a>-->
									</div>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<div id="picture3_1"></div>
										<div style="padding-left: 18px">
											<table border="2">
											<tr height="45px">
																	<td
																		style="color: #424200; width: 80px; text-align: center; font-size: 20px">
																		<strong> 月份 </strong>
																	</td>
																	<c:forEach items="${monthOfCurrentYear}" var="item">
																		<td style="width: 63px; text-align: center;">
																			${item}</td>

																	</c:forEach>
												</tr>
												<tr height="45px">
															<td
																style="color: #4572A7; width: 80px; text-align: center; font-size: 20px">
																<strong> 本金 </strong>
															</td>
															<c:forTokens items="${list31}" var="item" delims="@">
																<td style="width: 63px; text-align: center;">
																	${item}</td>

															</c:forTokens>
														</tr>
														<tr height="45px">
															<td
																style="color: #89A54E; width: 80px; text-align: center; font-size: 20px">
																<strong> 利息 </strong>
															</td>
															<c:forTokens items="${list32}" var="item" delims="@">
																<td style="width: 63px; text-align: center;">
																	${item}</td>

															</c:forTokens>
												</tr>
												<tr height="45px">
															<td
																style="color: #930000; width: 80px; text-align: center; font-size: 20px">
																<strong> 罚息 </strong>
															</td>
															<c:forTokens items="${list33}" var="item" delims="@">
																<td style="width: 63px; text-align: center;">
																	${item}</td>

															</c:forTokens>
												</tr>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

						<div class="row">
					<div class="col-xs-12">
						<div class="row">
							<div class="col-xs-12 widget-container-col ui-sortable">
								<div class="widget-box ui-sortable-handle">
									<div class="widget-header">
										<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i>
										</span>
										<h5 class="widget-title"></h5>
										<!-- #section:custom/widget-box.toolbar -->
										<div class="widget-toolbar">
											<a href="#" data-action="fullscreen" class="orange2"> <i
												class="ace-icon fa fa-expand"></i>
											</a>

											<!-- <a href="#" data-action="reload">
								<i class="ace-icon fa fa-refresh"></i>
							</a> -->

											<a href="#" data-action="collapse"> <i
												class="ace-icon fa fa-chevron-up"></i>
											</a>
											<!-- <a href="#" data-action="close"> <i
												class="ace-icon fa fa-times"></i>
											</a>-->
										</div>

									</div>
									<div class="widget-body">
										<div class="widget-main">
											<div id="picture3_2"></div>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
	

<c:if test="${fn:contains(listToString,'2001004')}">
	<div id="faq-tab-4" class="tab-pane fade">
		<div class="row">
						<div class="col-xs-12 widget-container-col ui-sortable">
							<div class="widget-box">
								<div class="widget-header">
									<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i>
									</span>
									<h5 class="widget-title"></h5>
									<!-- #section:custom/widget-box.toolbar -->
									<div class="widget-toolbar">
										<a href="#" data-action="fullscreen" class="orange2"> <i
											class="ace-icon fa fa-expand"></i>
										</a>

										<!-- <a href="#" data-action="reload">
									<i class="ace-icon fa fa-refresh"></i>
								</a> -->

										<a href="#" data-action="collapse"> <i
											class="ace-icon fa fa-chevron-up"></i>
										</a>
										<!-- <a href="#" data-action="close"> <i
											class="ace-icon fa fa-times"></i>
										</a>-->
									</div>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<div id="picture4_1"></div>
										<div style="padding-left: 18px">
											<table border="2">
											<tr height="45px">
																	<td
																		style="color: #424200; width: 80px; text-align: center; font-size: 20px">
																		<strong> 月份 </strong>
																	</td>
																	<c:forEach items="${monthOfNextYear}" var="item">
																		<td style="width: 63px; text-align: center;">
																			${item}</td>

																	</c:forEach>
												</tr>
												<tr height="45px">
													<td
														style="color: #4572A7; width: 80px; text-align: center; font-size: 20px">
														<strong> 金额 </strong>
													</td>
													<c:forTokens items="${list41}" var="item" delims="@">
														<td style="width: 63px; text-align: center;">${item}
														</td>

													</c:forTokens>
												</tr>
												<tr height="45px">
													<td
														style="color: #89A54E; width: 80px; text-align: center; font-size: 20px">
														<strong> 利息 </strong>
													</td>
													<c:forTokens items="${list42}" var="item" delims="@">
														<td style="width: 63px; text-align: center;">${item}
														</td>

													</c:forTokens>
												</tr>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				<div class="row">
					<div class="col-xs-12">
						<div class="row">
							<div class="col-xs-12 widget-container-col ui-sortable">
								<div class="widget-box ui-sortable-handle">
									<div class="widget-header">
										<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i>
										</span>
										<h5 class="widget-title"></h5>
										<!-- #section:custom/widget-box.toolbar -->
										<div class="widget-toolbar">
											<a href="#" data-action="fullscreen" class="orange2"> <i
												class="ace-icon fa fa-expand"></i>
											</a>

											<!-- <a href="#" data-action="reload">
								<i class="ace-icon fa fa-refresh"></i>
							</a> -->

											<a href="#" data-action="collapse"> <i
												class="ace-icon fa fa-chevron-up"></i>
											</a>
											<!-- <a href="#" data-action="close"> <i
												class="ace-icon fa fa-times"></i>
											</a>-->
										</div>

									</div>
									<div class="widget-body">
										<div class="widget-main">
											<div id="picture4_2"></div>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
</c:if>

<c:if test="${fn:contains(listToString,'2001005')}">
	<div id="faq-tab-5" class="tab-pane fade">
		<div class="row">
						<div class="col-xs-12 widget-container-col ui-sortable">
							<div class="widget-box">
								<div class="widget-header">
									<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i>
									</span>
									<h5 class="widget-title"></h5>
									<!-- #section:custom/widget-box.toolbar -->
									<div class="widget-toolbar">
										<a href="#" data-action="fullscreen" class="orange2"> <i
											class="ace-icon fa fa-expand"></i>
										</a>

										<!-- <a href="#" data-action="reload">
									<i class="ace-icon fa fa-refresh"></i>
								</a> -->

										<a href="#" data-action="collapse"> <i
											class="ace-icon fa fa-chevron-up"></i>
										</a>
										<!-- <a href="#" data-action="close"> <i
											class="ace-icon fa fa-times"></i>
										</a>-->
									</div>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<div id="picture5_1"></div>
										<div style="padding-left: 18px">
											<table border="2">
												<tr height="45px">
													<td style="color: #424200; width: 80px; text-align: center; font-size: 20px">
														<strong> 月份 </strong>
													</td>
													<c:forEach items="${monthOfCurrentYear}" var="item">
														<td style="width: 63px; text-align: center;">
															${item}</td>
													</c:forEach>
												</tr>
												<tr height="45px">
													<td style="color: #4572A7; width: 80px; text-align: center; font-size: 20px">
														<strong> 逾期率 </strong>
													</td>
													<c:forEach items="${list51}" var="item">
														<td style="width: 63px; text-align: center;">${item}
														</td>
													</c:forEach>
												</tr>
												<tr height="45px">
													<td style="color: #89A54E; width: 80px; text-align: center; font-size: 20px">
														<strong> 不良率 </strong>
													</td>
													<c:forEach items="${list52}" var="item">
														<td style="width: 63px; text-align: center;">${item}
														</td>
													</c:forEach>
												</tr>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				<div class="row">
					<div class="col-xs-12">
						<div class="row">
							<div class="col-xs-12 widget-container-col ui-sortable">
								<div class="widget-box ui-sortable-handle">
									<div class="widget-header">
										<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i>
										</span>
										<h5 class="widget-title"></h5>
										<!-- #section:custom/widget-box.toolbar -->
										<div class="widget-toolbar">
											<a href="#" data-action="fullscreen" class="orange2"> <i
												class="ace-icon fa fa-expand"></i>
											</a>

											<!-- <a href="#" data-action="reload">
								<i class="ace-icon fa fa-refresh"></i>
							</a> -->

											<a href="#" data-action="collapse"> <i
												class="ace-icon fa fa-chevron-up"></i>
											</a>
											<!-- <a href="#" data-action="close"> <i
												class="ace-icon fa fa-times"></i>
											</a>-->
										</div>

									</div>
									<div class="widget-body">
										<div class="widget-main">
											<div id="picture5_2"></div>
                                      		<div style="padding-left: 18px">
											<table border="2">
											<tr height="45px">
												<td style="color: #642100; width: 80px; text-align: center; font-size: 20px">
													<strong> ${adminOrOrg} </strong>
												</td>
												<c:forEach items="${list55}" var="item">
													<td style="width: 63px; text-align: center;">${item}
													</td>
												</c:forEach>
											</tr>
											<tr height="45px">
												<td style="color: #4572A7; width: 80px; text-align: center; font-size: 20px">
													<strong> 逾期率 </strong>
												</td>
												<c:forEach items="${list53}" var="item">
													<td style="width: 63px; text-align: center;">${item}
													</td>
												</c:forEach>
											</tr>
											<tr height="45px">
												<td style="color: #89A54E; width: 80px; text-align: center; font-size: 20px">
													<strong> 不良率 </strong>
												</td>
												<c:forEach items="${list54}" var="item">
													<td style="width: 63px; text-align: center;">${item}
													</td>
												</c:forEach>
											</tr>
											</table>
										</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
</c:if>



<!-- PAGE CONTENT ENDS -->
</div>
<!-- /.col -->
</div>
<!-- /.row -->
</div>
</div>


















<!-- row -->
<div class="row">
	<div class="col-xs-12">
		<!-- row -->
		<div class="row">
			<div class="col-xs-12"></div>
		</div>
		<!-- /row -->
		<div class="row">
			<div class="col-xs-12"></div>
		</div>
	</div>
</div>
<!--/ row -->
<script src="${res_libs}/Highcharts-4.0.4/js/highcharts.js"></script>
<script src="${my}/js/dashboard.js"></script>
<script type="text/javascript">
ace.load_ajax_scripts([], function() {
})
dashboard.init();
</script>
