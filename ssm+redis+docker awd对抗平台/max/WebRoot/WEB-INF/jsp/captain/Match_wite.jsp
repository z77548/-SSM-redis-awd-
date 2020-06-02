<%@ page language="java" import="java.util.*,com.ssm.chapter.pojo.Event"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Event saishi = (Event) request.getAttribute("event");
%>

<jsp:include page="Navigation.jsp" flush="true" />


<div class="breadcrumbs">
	<div class="breadcrumbs-inner">
		<div class="row m-0">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>赛事列表</h1>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="page-header float-right">
					<div class="page-title">
						<ol class="breadcrumb text-right">
							<li><a href="#">Dashboard</a></li>

						</ol>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="content">
	<div class="animated fadeIn">
		<div class="row">

			<div class="col-md-12" style="width:100%;">
				<div class="card">
					<div class="card-header">
						<strong class="card-title">赛事列表</strong>
					</div>
					<div class="card-body">
						<div class="col-md-4">
							<div class="card">
								<div class="card-header">
									<strong class="card-title">赛事须知 <small><span
											id="time" class="badge badge-danger float-right mt-1"></span></small></strong>
								</div>
								<div class="card-body">
									<p class="card-text"><%=saishi.getJianjie()%></p>

									<a style="color:green;"
										href="<%=basePath%>update/<%=saishi.getFile()%>"
										class="card-text">附件下载</a>

								</div>
								<a id="ok" href="#" class="btn btn-success" style="color:white;">开始答题</a>
							</div>
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>
	<!-- .animated -->
</div>
<!-- .content -->






<script type="text/javascript">
	window.onload = clock;
	function clock() {
		var today = new Date(); //当前时间
		var stopTime = new Date("<%=saishi.getIntime()%>"); //结束时间	
		var StartTime = new Date("<%=saishi.getOutime()%>"); //结束时间	
		var shenyu = stopTime.getTime() - today.getTime(), //倒计时毫秒数
			shengyuD = parseInt(shenyu / (60 * 60 * 24 * 1000)), //转换为天
			D = parseInt(shenyu) - parseInt(shengyuD * 60 * 60 * 24 * 1000), //除去天的毫秒数
			shengyuH = parseInt(D / (60 * 60 * 1000)), //除去天的毫秒数转换成小时
			H = D - shengyuH * 60 * 60 * 1000, //除去天、小时的毫秒数
			shengyuM = parseInt(H / (60 * 1000)), //除去天的毫秒数转换成分钟
			M = H - shengyuM * 60 * 1000; //除去天、小时、分的毫秒数
		S = parseInt((shenyu - shengyuD * 60 * 60 * 24 * 1000 - shengyuH * 60 * 60 * 1000 - shengyuM * 60 * 1000) / 1000); //除去天、小时、分的毫秒数转化为秒
		var shenyu1 = StartTime.getTime() - today.getTime(), //倒计时毫秒数
			shengyuD1 = parseInt(shenyu1 / (60 * 60 * 24 * 1000)), //转换为天
			D1 = parseInt(shenyu1) - parseInt(shengyuD1 * 60 * 60 * 24 * 1000), //除去天的毫秒数
			shengyuH1 = parseInt(D1 / (60 * 60 * 1000)), //除去天的毫秒数转换成小时
			H1 = D1 - shengyuH1 * 60 * 60 * 1000, //除去天、小时的毫秒数
			shengyuM1 = parseInt(H1 / (60 * 1000)), //除去天的毫秒数转换成分钟
			M1 = H1 - shengyuM1 * 60 * 1000; //除去天、小时、分的毫秒数
		S1 = parseInt((shenyu1 - shengyuD1 * 60 * 60 * 24 * 1000 - shengyuH1 * 60 * 60 * 1000 - shengyuM1 * 60 * 1000) / 1000); //除去天、小时、分的毫秒数转化为秒
		if (D < 0 || H < 0 || M < 0 || S < 0) {
			if (D1 < 0 || H1 < 0 || M1 < 0 || S1 < 0) {
				document.getElementById("time").innerHTML = ("比赛结束");
				document.getElementById("ok").innerHTML = ("关闭");
				document.getElementById("ok").style.backgroundColor = "#888888";
			} else {
				document.getElementById("time").innerHTML = ("比赛开始");
				var id = getQueryString("id");
			if(<%=saishi.getAwd()%>==0){
				document.getElementById("ok").href = "<%=basePath%>captain/Topic.do?EventId=" + id;
				document.getElementById("ok").innerHTML = ("开始答题");
				}else{
				document.getElementById("ok").href = "<%=basePath%>captain/awd.do?id=" + id;
				document.getElementById("ok").innerHTML = ("开始答题");
				}
				clearTimeout(i);
				alert("比赛开始");
			}
		} else {
			document.getElementById("ok").innerHTML = ("未开始");
			document.getElementById("ok").style.backgroundColor = "#888888";
			document.getElementById("ok").background = "red";
			document.getElementById("time").innerHTML = (shengyuD + "天" + shengyuH + "小时" + shengyuM + "分" + S + "秒" + "<br>");
			var i = setTimeout(clock, 500);

		}
	}
	function getQueryString(name) {
		var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
		var r = window.location.search.substr(1).match(reg);
		if (r != null) {
			return unescape(r[2]);
		}
		return null;
	}
</script>


<%@ include file="foot.jsp"%>