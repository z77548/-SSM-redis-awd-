<%@ page language="java"
	import="java.util.*,com.ssm.chapter.dao.NewsDao,com.ssm.chapter.pojo.OneNew,com.ssm.chapter.pojo.OrdinaryUsers"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>

<%
	ServletContext sc = this.getServletContext();
	ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
	NewsDao newsDao = (NewsDao) ac.getBean("newsDao");
	OrdinaryUsers ordinaryUsers = (OrdinaryUsers) session.getAttribute("user");
	List<OneNew> list1 = newsDao.getNews(ordinaryUsers.getId());
	int count = list1.size();
%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>

<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="">
<!--<![endif]-->
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>农大CTF</title>
<meta name="description" content="农大CTF">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">
<link rel="shortcut icon" href="https://i.imgur.com/QRAUqs9.png">
一般的图标尺寸都是16px*16px
<link rel="stylesheet"
	href="<%=basePath%>admin/assets/css/normalize.min.css">
<link rel="stylesheet"
	href="<%=basePath%>admin/assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=basePath%>admin/assets/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=basePath%>admin/assets/css/themify-icons.css">
<link rel="stylesheet"
	href="<%=basePath%>admin/assets/css/pe-icon-7-stroke.min.css">
<link rel="stylesheet"
	href="<%=basePath%>admin/assets/css/flag-icon.min.css">
<link rel="stylesheet"
	href="<%=basePath%>admin/assets/css/cs-skin-elastic.css">
<link rel="stylesheet"
	href="<%=basePath%>admin/assets/css/lib/datatable/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>admin/assets/css/style.css">
<link
	href='<%=basePath%>admin/assets/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>

</head>

<body>
	<!-- Left Panel -->
	<aside id="left-panel" class="left-panel">
		<nav class="navbar navbar-expand-sm navbar-default">
			<div id="main-menu" class="main-menu collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<%=basePath%>home.do"><i
							class="menu-icon fa fa-laptop"></i>主页 </a></li>
					<li class="menu-title">导航</li>
					<!-- /.menu-title -->

									<li class="menu-item-has-children dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> <i
							class="menu-icon fa fa-th"></i>比赛
					</a>
						<ul class="sub-menu children dropdown-menu">
							<li><i class="menu-icon fa fa-th"></i><a
								href="<%=basePath%>admin/release.do">发布比赛</a></li>
							<li><i class="menu-icon fa fa-th"></i><a
								href="<%=basePath%>admin/management.do">比赛管理</a></li>
	<li><i class="menu-icon fa fa-th"></i><a
								href="<%=basePath%>admin/topicall.do">题目管理</a></li>

						</ul></li>
					<li class="menu-item-has-children dropdown"><a
						class="dropdown-toggle" aria-expanded="false" aria-haspopup="true"
						href="#" data-toggle="dropdown"> <i
							class="menu-icon fa fa-tasks"></i>成绩
					</a>
						<ul class="sub-menu children dropdown-menu">
							<li class="subtitle"><i class="menu-icon fa fa-tasks"></i>成绩展示</li>
							<li><i class="menu-icon fa fa-fort-awesome"></i><a
								href="<%=basePath%>admin/ranking.do">AWD比赛成绩</a></li>
						</ul></li>

<li class="menu-item-has-children dropdown">
                        <a class="dropdown-toggle" aria-expanded="false" aria-haspopup="true" href="#" data-toggle="dropdown"> <i class="menu-icon fa fa-glass"></i>管理</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-sign-in"></i><a href="<%=basePath%>admin/UserMan.do">用户管理</a></li>
                            <li><i class="menu-icon fa fa-sign-in"></i><a href="<%=basePath%>admin/TeamMan.do">战队管理</a></li>
                            <li><i class="menu-icon fa fa-paper-plane"></i><a href="<%=basePath%>admin/Service.do">服务器管理</a></li>
                        </ul>
                    </li>




					<li class="menu-item-has-children dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> <i
							class="menu-icon fa fa-cogs"></i>设置
					</a>
						<ul class="sub-menu children dropdown-menu">

							<li><i class="fa fa-id-badge"></i><a
								href="<%=basePath%>admin/Personal_information.do">账户设置</a></li>

							<li><i class="fa fa-id-card-o"></i><a
								href="<%=basePath%>admin/Mac.do">系统设置</a></li>

						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>
	</aside>
	<div id="right-panel" class="right-panel">
		<!-- Header-->
		<header id="header" class="header">
			<div class="top-left">
				<div class="navbar-header">
					<a class="navbar-brand" href="<%=basePath%>home.do"><img
						src="<%=basePath%>admin/images/logo.png" alt="Logo"></a> <a
						class="navbar-brand hidden" href="<%=basePath%>home.do"><img
						src="<%=basePath%>admin/images/logo2.png" alt="Logo"></a> <a
						id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
				</div>
			</div>
			<div class="top-right">
				<div class="header-menu">
					<div class="header-left">
						<div class="dropdown for-notification">



							<div class="dropdown for-message">
								<button class="btn btn-secondary dropdown-toggle" type="button"
									id="message" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">
									<i class="fa fa-envelope"></i> <span id="conut"
										class="count bg-primary"><%=count%></span>
								</button>
								<div class="dropdown-menu" aria-labelledby="message">

									<p id="er" class="red">
										您有<%=count%>条消息(点击删除)
									</p>
									<%
										for (int i = 0; i < list1.size(); i++) {
									%>

									<a class="dropdown-item media" href="#"
										id="<%=list1.get(i).getId()%>" onclick=" myclick(this.id) ">
										<span class="photo media-left"><%=list1.get(i).getId()%></span>
										<div class="message media-body">
											<span class="name float-left"> 发送者:<%=list1.get(i).getPublisher_name()%></span>

											<span class="time float-right">时间：<%=list1.get(i).getTime()%></span>
											<p>
												内容:<%=list1.get(i).getData()%></p>

										</div>
									</a>

									<%
										}
									%>
								</div>
							</div>
						</div>

						<div class="user-area dropdown float-right">
							<a href="#" class="dropdown-toggle active" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"> <img
								class="user-avatar rounded-circle"
								src="<%=basePath%>user/images/admin.jpg" alt="User Avatar">
							</a>

							<div class="user-menu dropdown-menu">
								<a class="nav-link"><i class="fa fa-user"></i>我的账户</a> <a
									class="nav-link" href="<%=basePath%>user/Mac.do"><i
									class="fa fa-cog"></i>系统设置</a> <a class="nav-link"
									href="<%=basePath%>logoin/quit.do"><i
									class="fa fa-power-off"></i>注销</a>
							</div>
						</div>
					</div>
				</div>
		</header>
		<script type="text/javascript">
			function myclick(id) {
				$.ajax({
					type : "get",
					url : "<%=basePath%>admin/delectnews.do?id=" + id,
					cache : false,
					dataType : "text", //json,xml,script,html
					success : function(data) {
						if (data == "true") {
							var my = document.getElementById(id);
							var count = document.getElementById("conut");
							i = count.innerHTML - 1;
							count.innerHTML = count.innerHTML - 1;
							var er = document.getElementById("er");
							er.innerHTML = "您有" + i + "条消息(点击删除)";
							if (my != null)
								my.parentNode.removeChild(my);
						} else {
							alert("error");
						}
					},
					error : function(data) {
						alert("error");
					}
				});
				return false;
			}
		</script>
