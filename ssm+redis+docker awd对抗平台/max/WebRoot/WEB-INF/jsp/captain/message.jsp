<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String message = null;
	try {

		request.setCharacterEncoding("utf-8"); // 按中文接收
		message = request.getAttribute("message").toString(); // 接收参数的名称
		System.out.print(message);
	} catch (Exception e) {
		System.out.print(e);
		message = "信息传递出错";
	}
%>

<%
	response.setHeader("refresh", "3;URL=index.jsp");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提示</title>
</head>
<body>
	<center>
		<h2><%=message%></h2>
	</center>
</body>
</html>