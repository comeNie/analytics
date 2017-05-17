<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="request" />
<c:set var="res" value="${ctx}/static/assets" scope="request" />
<c:set var="my" value="${ctx}/static/my" scope="request" />
<c:set var="res_libs" value="${ctx}/static/libs" scope="request" />
<c:set var="ipPort" value="http://localhost:8080/" scope="request" />
<c:set var="uumIp" value="localhost:8080" scope="request" />
<%-- <c:set var="ipPort" value="http://10.1.32.38:7001/" scope="request" />
<c:set var="uumIp" value="localhost:7001" scope="request" /> --%>

<%-- <c:set var="ipPort" value="172.16.49.243:7001/" scope="request" />
<c:set var="uumIp" value="localhost:7001" scope="request" /> --%>
<c:set var="cognos" value="http://23.4.160.32" scope="request" />