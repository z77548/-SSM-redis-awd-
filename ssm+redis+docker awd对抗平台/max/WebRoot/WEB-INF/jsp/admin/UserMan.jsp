<%@ page language="java"
	import="java.util.*,java.sql.*,com.ssm.chapter.pojo.Accout"
	pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	List<Accout> list = (List<Accout>) request.getAttribute("list");
%>



<jsp:include page="Navigation.jsp" flush="true" />
<div class="breadcrumbs">
	<div class="breadcrumbs-inner">
		<div class="row m-0">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>用户管理</h1>
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
						<strong class="card-title">用户管理</strong>
					</div>
					<div class="card-body">
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>ID</th>
									<th>用户名</th>
									<th>真实姓名</th>
								
<th>身份证</th>
<th>手机号码</th>
<th>邮箱</th>
<th>类型</th>
<th>战队ID</th>
<th>队长</th>
<th>MAC</th>
<th>修改</th>
<th>删除</th>
								</tr>

							</thead>
							<tbody>
								<c:forEach items="${list}" var="i">
									<tr>
										<td>${i.id}</td>
										<td>${i.name}</td>
										<td>${i.truename}</td>
										<td>${i.idcard}</td>
										<td>${i.iphone}</td>
										<td>${i.email}</td>
										<td>${i.type}</td>
										<td>${i.team_id}</td>
										<td>${i.captain}</td>
										<td>${i.mac}</td>
									<td><a href="ChangeUsery.do?Name=${i.name}">修改</a></td>
										<td><a href="#" id="${i.id}" onclick="dele(this.id)">删除</a></td>

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
				url : "DeleteUser.do",
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
