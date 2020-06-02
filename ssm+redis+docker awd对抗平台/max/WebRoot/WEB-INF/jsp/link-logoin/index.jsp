<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
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
<title>河北农业大学 CTF训练营登陆</title>
<meta name="description" content="河北农业大学 CTF训练营登陆">
<meta name="viewport" content="width=device-width, initial-scale=1">



<link rel="stylesheet" href="link-logoin/assets/css/bootstrap.min.css">

<link rel="stylesheet" href="link-logoin/assets/css/cs-skin-elastic.css">
<link rel="stylesheet" href="link-logoin/assets/css/style.css">


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
					<a href="#"> <img class="align-content"
						src="link-logoin/images/logo.png" alt="">
					</a>
				</div>
				<div class="login-form">
					<form>
						<div class="form-group">

							<input type="text" class="form-control" id="name" name="name"
								placeholder="请输入用户名"> <a class="a-name" id="a-name"></a>
						</div>
						<div class="form-group">

							<input type="password" class="form-control" id="passwd"
								name="passwd" placeholder="请输入密码"> <a class="a-passwd"
								id="a-passwd"></a>
						</div>
						<div class="form-group">

							<div class="code">
								<input id="code" class="form-control" name="code"
									placeholder="点击图片切换验证码"><a id="a-code"></a>
							</div>
							<div class="codegb">
								<img src="code/code.do" id="codeimage"
									style="margin-right:-46px;margin-top:10px;"
									onclick="javascript:this.src='<%=basePath%>/code/code.do?tm='+Math.random()">
							</div>

						</div>
						<div class="checkbox">
							<label> <input type="checkbox"> 记住密码
							</label>
						</div>
						<button class="btn btn-success btn-flat m-b-30 m-t-30" id="submit"
							name="submit" type="button" onclick="cc();" value="立即登陆">
							立即登陆</button>
						<div class="register-link m-t-15 text-center">
							<p>
								没有账号 ? <a href="./logoin/sign.do">点击这里注册</a>
							</p>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
<script src="<%=basePath%>/link-logoin/assets/js/jquery.js"
	type="text/javascript">
	<script src="<%=basePath%>/link-logoin/assets/js/main.js"></script>
<script src="<%=basePath%>/link-logoin/assets/js/hash-sha3.js"
	type="text/javascript"></script>
<script src="<%=basePath%>/link-logoin/assets/js/jquery2.js"
	type="text/javascript"></script>
	</script>


</html>