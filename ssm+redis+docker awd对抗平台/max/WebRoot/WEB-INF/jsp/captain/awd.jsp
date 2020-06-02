<%@ page language="java"
	import="java.util.*,com.github.dockerjava.api.model.Container"
	pageEncoding="GBK"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	int i = 0;
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Container c = (Container) request.getAttribute("container");
	String name = c.getNames()[0];
	System.out.println("sdsds"+c.toString());
	String[] a = name.split("m");
	int count = Integer.parseInt(a[1]);
	
%>
<jsp:include page="Navigation.jsp" flush="true" />
<div class="breadcrumbs">
	<div class="breadcrumbs-inner">
		<div class="row m-0">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>AWD</h1>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="page-header float-right">
					<div class="page-title">
						<ol class="breadcrumb text-right">

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

			<div class="col-lg-6">
				<div class="card">
					<div class="card-header">
						<strong>AWD</strong>
					</div>
					<div class="card-body card-block">
						<form class="form-horizontal" action="#"
							enctype="multipart/form-data" method="post">

							<div class="row form-group">
								<div class="col col-md-3">
									<label class=" form-control-label" for="text-input">SSH地址</label>
								</div>
								<div class="col-12 col-md-9">
									<a class="form-text text-muted">175.24.33.212:<%=count + 2200%></a>
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label class=" form-control-label" for="text-input">WEB地址</label>
								</div>
								<div class="col-12 col-md-9">
									<a class="form-text text-muted">175.24.33.212:<%=count + 8800%></a>
								</div>
							</div>
							<div class="row form-group">

								<div class="col-12 col-md-9">
									<input name="flag" class="form-control" id="flag" type="text"
										placeholder="提交flag">
								</div>
							</div>



							<div class="row form-group">

								<div class="col-12 col-md-9">
									<input name="code" class="form-control" id="code" type="text"
										placeholder="验证码">
								</div>
								<div class="col col-md-3">
									<div class="codegb">
										<img src="../code/code.do" id="codeimage"
											onclick="javascript:this.src='<%=basePath%>/code/code.do?tm='+Math.random()">
									</div>
								</div>

							</div>


							<div class="row form-group">

								<div class="col-12 col-md-9" style="width: 100%;">
									<button class="btn btn-success" style="width: 100%;"
										type="button" onclick="a()">提交</button>
								</div>

							</div>

						</form>
					</div>

				</div>

			</div>


		</div>
	</div>
	<!-- .animated -->
</div>
<!-- .content -->
<script>

	function codecheck() {
		var code = document.getElementById("code").value;
		if (code == "" || code.length != 4) {
			document.getElementById("code").style.border = '2px solid red';
			alert("验证码错误");
			return false;
		} else {
			document.getElementById("code").style.border = '2px solid green';
			return true;
		}

	}
	function getQueryVariable(variable) {
		var query = window.location.search.substring(1);
		var vars = query.split("&");
		for (var i = 0; i < vars.length; i++) {
			var pair = vars[i].split("=");
			if (pair[0] == variable) {
				return pair[1];
			}
		}
		return (false);
	}
	function flagcheck() {
		var code = document.getElementById("flag").value;
		if (code == "" || code.length < 7) {
			document.getElementById("flag").style.border = '2px solid red';
			alert("flag错误");
			return false;
		} else {
			document.getElementById("flag").style.border = '2px solid green';
			return true;
		}

	}

	function a() {
		var code = document.getElementById("code").value;
		var flag = document.getElementById("flag").value;
		var EventId = getQueryVariable("id");
		if (codecheck()) {
			if (flagcheck()) {
				$.ajax({
					type : "post",
					url : "flag.do",
					data : {
						"code" : code,
						"flag" : flag,
						"EventId" : EventId,
					},
					cache : false,
					dataType : "text", //json,xml,script,html
					success : function(data) {
						if (data == "提交成功") {
							alert("提交成功 ");
							document.getElementById("codeimage").src = '../code/code.do?tm=' + Math.random();
						} else {
							document.getElementById("codeimage").src = '../code/code.do?tm=' + Math.random();
							alert(data);
						}
					},
					error : function(data) {
						alert(data);
					}
				});
			}
		}
	}

	document.getElementById("code").onblur = function fn() {
		codecheck();
	}
	document.getElementById("flag").onblur = function fn() {
		flagcheck();
	}
</script>
<%@ include file="foot.jsp"%>