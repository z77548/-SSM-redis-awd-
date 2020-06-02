<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String message = null;
	try {

		request.setCharacterEncoding("utf-8"); // 按中文接收
		int a = Integer.parseInt((String) request.getParameter("message")); // 接收参数的名称
	
		if (a == 0) {
			message = "错误访问";
		} else if (a == 1) {
		
			message = "您已经加入战队，如果想重新操作请先退出当前战队！";
		}else{
		
			message = "错误访问";
		
		}
	} catch (Exception e) {

	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传结果</title>
</head>
<body>
	<center>
		<h2><%=message%></h2>
	</center>
</body>
</html>