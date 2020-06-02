<%@ page language="java" import="java.util.*,com.ssm.chapter.pojo.Event"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	int i = 0;
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	ArrayList list = (ArrayList) request.getAttribute("list");
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

			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<strong class="card-title">赛事列表</strong>
					</div>
					<div class="card-body">
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>ID</th>
									<th>名称</th>
									<th>开始时间</th>
									<th>结束时间</th>
									<th></th>

								</tr>

							</thead>
							<tbody>
								<c:forEach items="${list}" var="i">
									<tr>
										<td><span class="count">${i.id}</span></td>
										<td><span class="name">${i.name}</span></td>
										<td><span class="time">${i.intime}</span></td>
										<td><span class="time">${i.outime}</span></td>
										<td><c:if test="${i.state eq '开始比赛'}">
												<a href="#" id="${i.id}" onclick="bm(this.id)"
													class="btn btn-success" style="color:white;">报名比赛</a>
											</c:if> <c:if test="${i.state eq '比赛关闭'}">
												<a href="#" class="btn btn-success"
													style="color:white;background:#555555;"> 比赛关闭</a>
											</c:if></td>

									</tr>

								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>


		</div>
	</div>
	<!-- .animated -->
</div>
<!-- .content -->
<script type="text/javascript">
	function bm(id) {
		$.ajax({
			type : "get",
			url : "<%=basePath%>captain/bm.do?id=" + id,
			cache : false,
			dataType : "text", //json,xml,script,html
			success : function(data) {
				if (data == "true") {
					alert("赛事报名成功")
				} else {
					alert("赛事报名失败,您已经报名过此比赛或者您不符合报名条件");
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