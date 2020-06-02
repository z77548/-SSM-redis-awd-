<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<jsp:include page="Navigation.jsp" flush="true" />
<div class="content">
	<div class="animated fadeIn">
		<div class="row">
			<div class="col-lg-6">
				<div class="card">
					<div class="card-header">
						<strong>账户信息</strong>
					</div>
					<div class="card-body card-block">
						<form action="#" method="post" enctype="multipart/form-data"
							class="form-horizontal">
							<div class="row form-group">
								<div class="col col-md-3">
									<label class=" form-control-label">战队ID</label>
								</div>
								<div class="col-12 col-md-9">
									<p class="form-control-static">${TeamInformation.id}</p>
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label class=" form-control-label">战队名称</label>
								</div>
								<div class="col-12 col-md-9">
									<p class="form-control-static">${TeamInformation.name}</p>
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label class=" form-control-label">队长</label>
								</div>
								<div class="col-12 col-md-9">
									<p class="form-control-static">${TeamInformation.captain_name}</p>
								</div>
							</div>

							<div class="row form-group">
								<div class="col col-md-3">
									<label class=" form-control-label">队员1</label>
								</div>
								<div class="col-12 col-md-9">
									<p class="form-control-static">${TeamInformation.team_member_1_name}</p>
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label class=" form-control-label">队员2</label>
								</div>
								<div class="col-12 col-md-9">
									<p class="form-control-static">${TeamInformation.team_member_2_name}</p>
								</div>
							</div>

							<div class="submit">
								<a id="quit" href="#" onclick="quit()"
									class="btn btn-success btn-flat m-b-30 m-t-30"
									style="margin-top: 4%;color:white;">解散战队 </a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- .animated -->
</div>
<script>
	if ("${TeamInformation.name}" == "") {
		document.getElementById("quit").href = "#";
		alert("请先加入战队");
		window.location.href = "../home.do";
	}
	function quit() {
		$.ajax({
			type : "get",
			url : "<%=basePath%>captain/dissolution.do",
			cache : false,
			dataType : "text", //json,xml,script,html
			success : function(data) {
				if (data == "true") {
					alert("解散战队成功");
					window.location.href = "../home.do";
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
<%@ include file="foot.jsp"%>