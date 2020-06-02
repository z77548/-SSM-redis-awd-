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
						<h1>赛事管理</h1>
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
						<strong class="card-title">赛事管理</strong>
					</div>
					<div class="card-body">
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>赛事ID</th>
									<th>名称</th>
									<th>开始时间</th>
									<th>结束时间</th>
									<th>简介</th>
									<th>文件</th>
									<th>参赛队伍</th>
									<th>题目设置</th>
									<th>修改</th>
									<th>删除</th>
								</tr>

							</thead>
							<tbody>
								<c:forEach items="${list}" var="i">
									<tr>
										<td>${i.id}</td>
										<td>${i.name}</td>
										<td>${i.intime}</td>
										<td>${i.outime}</td>
										<td>${i.jianjie}</td>
										<td>${i.file}</td>
										<td><a href="show?number=${i.id}"> <i
												class="fa fa-tasks"></i>查看参赛队伍<span
												class="badge badge-danger pull-right"></span></a></td>
										<c:if test="${i.awd eq '0'}">
											<td><a href="title.do?number=${i.id}"> <i
													class="fa fa-bell-o"></i>题目设置<span
													class="badge badge-success pull-right"></span></a></td>
										</c:if>
										<c:if test="${i.awd eq '1'}">
											<td><a href="docker.do?eventid=${i.id}"> <i
													class="fa fa-bell-o"></i>题目设置<span
													class="badge badge-success pull-right"></span></a></td>
										</c:if>

										<td><a href="showmemory?number=${i.id}"> <i
												class="fa fa-bell-o"></i>修改<span
												class="badge badge-success pull-right"></span></a></td>

										<td><a href="showcpu?number=${i.id}"> <i
												class="fa fa-bell-o"></i>删除<span
												class="badge badge-success pull-right"></span></a></td>
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


<%@ include file="foot.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		$('#bootstrap-data-table-export').DataTable();
	});
</script>


</body>
</html>
