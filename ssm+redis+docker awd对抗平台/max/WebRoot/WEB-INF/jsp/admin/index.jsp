<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<jsp:include page="Navigation.jsp" flush="true" />
<img src="<%=basePath%>admin/images/bk.jpg"></img>


<%@ include file="foot.jsp"%>