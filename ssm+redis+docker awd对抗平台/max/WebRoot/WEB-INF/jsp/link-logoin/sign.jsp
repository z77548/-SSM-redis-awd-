<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>河北农业大学 CTF训练营注册</title>
<meta name="description" content="河北农业大学 CTF训练营注册">
<meta name="viewport" content="width=device-width, initial-scale=1">



<link rel="stylesheet"
	href="<%=basePath%>/link-logoin/assets/css/bootstrap.min.css">

<link rel="stylesheet"
	href="<%=basePath%>/link-logoin/assets/css/cs-skin-elastic.css">
<link rel="stylesheet"
	href="<%=basePath%>/link-logoin/assets/css/style.css">


<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
</head>
<body class="bg-dark">

	<div class="sufee-login d-flex align-content-center flex-wrap">
		<div class="container">
			<div class="login-content">
				<div class="login-logo">
					<a href="../index.do"> <img class="align-content"
						src="../link-logoin/images/logo.png" alt="">
					</a>
				</div>
				<div class="login-form">
					<form>
						<div class="form-group">
<div class="name">
				<input type="text" class="form-control" id="name" name="name" placeholder="请输入用户名" /><a
					class="a-name" id="a-name"></a>
			</div>
			<div class="passwd">
				<input type="password" class="form-control" id="passwd" name="passwd" placeholder="请输入密码" /><a
					class="a-passwd" id="a-passwd"></a>
			</div>
		<div class="passwd2">
				<input type="password" class="form-control" id="passwd2" name="passwd2" placeholder="请输入确认密码" /><a
					class="a-passwd" id="a-passwd2"></a>
			</div>
		<div class="truename">
				<input type="text" class="form-control" id="truename" name="truename" placeholder="请输入真实姓名" /><a
					class="a-truename" id="a-truename"></a>
			</div>	

		<div class="idcard">
				<input type="text" class="form-control" id="idcard" name="idcard" placeholder="请输入身份证号码" /><a
					class="a-idcard" id="a-idcard"></a>
			</div>	

		<div class="email">
				<input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱" /><a
					class="a-email" id="a-email"></a>
			</div>	

		<div class="iphone">
				<input type="text" class="form-control" id="iphone" name="iphone" placeholder="请输入手机号" /><a
					class="a-iphone" id="a-iphone"></a>
			</div>	

			<div class="code">
				<input id="code" class="form-control" name="code" placeholder="点击图片更换验证码" /><a
					class="a-code" id="a-code"></a>

			</div>
			<div class="codegb">
				<img src="../code/code.do" id="codeimage"
					style="margin-right:-46px;margin-top:10px;"
					onclick="javascript:this.src='../code/code.do?tm='+Math.random()">
			</div>
			<div class="submit">
				<input id="submit" class="btn btn-success btn-flat m-b-30 m-t-30" name="submit" type="button" onclick="cc();" value="立即注册" style="
    margin-top: 4%;">
			</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<script src="<%=basePath%>/link-logoin/assets/js/jquery.js"
	type="text/javascript">
	<script src="<%=basePath%>/link-logoin/assets/js/main.js"></script>
<script src="<%=basePath%>/link-logoin/assets/js/hash-sha3.js"
	type="text/javascript"></script>
<script src="<%=basePath%>/link-logoin/assets/js/jque.js"
	type="text/javascript"></script>
	</script>

</body>
</html>
