<%@ page language="java"
	import="java.util.*,java.sql.*,com.ssm.chapter.pojo.TeamInformation"
	pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	List<TeamInformation> list = (List<TeamInformation>) request.getAttribute("list");
%>



<jsp:include page="Navigation.jsp" flush="true" />
<div class="breadcrumbs">
	<div class="breadcrumbs-inner">
		<div class="row m-0">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>战队管理</h1>
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
						<strong class="card-title">战队管理</strong>
					</div>
					<div class="card-body">
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>战队ID</th>
									<th>战队名称</th>
									<th>队长ID</th>
								
<th>队长姓名</th>
<th>队员ID</th>
<th>队员姓名</th>
<th>队员ID</th>
<th>队员姓名</th>
<th>报名赛事ID</th>
<th>修改</th>
<th>删除</th>

								</tr>

							</thead>
							<tbody>
								<c:forEach items="${list}" var="i">
									<tr>
										<td>${i.id}</td>
										<td>${i.name}</td>
										<td>${i.captain_id}</td>
										<td>${i.captain_name}</td>
										<td>${i.team_member_1_id}</td>
										<td>${i.team_member_1_name}</td>
										<td>${i.team_member_2_id}</td>
										<td>${i.team_member_2_name}</td>
										<td>${i.event_id}</td>
										<th><a href="#">修改</a></th>
										<th><a herf="#" id="${i.id}" onclick="dele(this.id)">删除</a></th>										
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
 function dele(a){

	$.ajax({
				type : "post",
				url : "DeleteTeam.do",
				data : {
				"id":a,
				},
				cache : false,
				dataType : "text", //json,xml,script,html
				success : function(data) {
					if(data=="true"){alert("删除成功");window.location.reload();	}	else{alert("删除失败");	}								},
				error : function(data11) {
					alert("删除失败");				
				}
			});

}

</script>
<%@ include file="foot.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		$('#bootstrap-data-table-export').DataTable();
	});
</script>


</body>
</html>
