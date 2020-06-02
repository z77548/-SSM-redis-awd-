<%@ page language="java"
	import="java.util.*,java.sql.*,com.ssm.chapter.pojo.AwdteamEntity"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	List<AwdteamEntity> list = (List<AwdteamEntity>) request.getAttribute("list");
%>



<jsp:include page="Navigation.jsp" flush="true" />
<div class="breadcrumbs">
	<div class="breadcrumbs-inner">
		<div class="row m-0">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>成绩展示</h1>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="page-header float-right">
					<div class="page-title">
						<ol class="breadcrumb text-right">
							<li><a href="#"></a></li>
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
									<th>ID</th>
									<th>战队ID</th>
									<th>赛事ID</th>
									<th>成绩</th>

								</tr>

							</thead>
							<tbody>
								<c:forEach items="${list}" var="i">
									<tr>
										<td>${i.id}</td>
										<td>${i.teamid}</td>
										<td>${i.eventid}</td>
										<td>${i.source}</td>

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
