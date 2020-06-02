<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="Navigation.jsp" flush="true" />


<div class="breadcrumbs">
	<div class="breadcrumbs-inner">
		<div class="row m-0">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>发布题目</h1>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="page-header float-right">
					<div class="page-title">
						<ol class="breadcrumb text-right">
							<li><a href="#">发布题目</a></li>
							<li><a href="#"></a></li>
							<li class="active"></li>
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
			<!--/.col-->



			<div class="col-lg-6">
				<div class="card">
					<div class="card-header">
						<strong>发布题目</strong>
					</div>
					<div class="card-body card-block">
						<form action="#" method="post" enctype="multipart/form-data"
							class="form-horizontal">

							<div class="row form-group">
								<div class="col col-md-3">
									<label for="text-input" class=" form-control-label">赛事ID</label>
								</div>
								<div class="col-12 col-md-9">
									<a class="form-text text-muted" id="ssid" name="ssid">赛事ID</a>
								</div>
							</div>



							<div class="row form-group">


								<div class="col col-md-3">
									<label for="textarea-input" class=" form-control-label">模板选择</label>
								</div>
								<div class="col-12 col-md-9">
									<select id="model" name="model" class="form-control"
										tabindex="1">
										<option value="web_yunnan_simple" label="web_yunnan_simple"></option>
										<option value="web_server" label="web_serve"></option>
										<option value="web_beego">web_beego</option>
<option value="web_cliphp">web_cliphp</option>

<option value="web_flaskbb">web_flaskbb</option>

<option value="web_nodecms">web_nodecms</option>

<option value="web_phpmyadmin">web_phpmyadmin</option>

<option value="web_server">web_server</option>

<option value="web_tpshop">web_tpshop</option>

<option value="web_yunsi_week2">web_yunsi_week2</option>

									</select>
								</div>
							</div>


							<div class="row form-group">
								<div class="col col-md-3">
									<label for="file-input" class=" form-control-label">容器数量</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" name="da" id="count" name="count"
										placeholder="容器数量" class="form-control">
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="file-input" class=" form-control-label">主机地址</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" name="da" id="ipaddr" name="ipaddr"
										placeholder="主机地址" class="form-control">
								</div>
							</div>
						</form>
					</div>
					<div class="card-footer">
						<button id="btn" type="submit" class="btn btn-primary btn-sm"
							onclick="cc();">
							<i class="fa fa-dot-circle-o"></i> 提交
						</button>
						<button type="reset" class="btn btn-danger btn-sm">
							<i class="fa fa-ban"></i> 重置
						</button>
					</div>
				</div>

			</div>

		</div>


	</div>
	<!-- .animated -->
</div>
<!-- .content -->

<%@ include file="foot.jsp"%>
<script src="<%=basePat%>admin/js/jquery.js" type="text/javascript"></script>
<script src="<%=basePat%>admin/js/jque.js" type="text/javascript"></script>
<script>

	function GetQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) return unescape(r[2]);
		return null;
	}

	// 调用方法
	document.getElementById("ssid").innerHTML = GetQueryString("eventid");
</script>



</body>
</html>