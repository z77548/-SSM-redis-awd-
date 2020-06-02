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
						<h1>�û�����</h1>
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
						<strong class="card-title">�û�����</strong>
					</div>
					<div class="card-body">
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>ID</th>
									<th>�û���</th>
									<th>��ʵ����</th>
								
<th>���֤</th>
<th>�ֻ�����</th>
<th>����</th>
<th>����</th>
<th>ս��ID</th>
<th>�ӳ�</th>
<th>MAC</th>
<th>�޸�</th>
<th>ɾ��</th>
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
									<td><a href="ChangeUsery.do?Name=${i.name}">�޸�</a></td>
										<td><a href="#" id="${i.id}" onclick="dele(this.id)">ɾ��</a></td>

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
					if(data=="true"){alert("ɾ���ɹ�");window.location.reload();	}	else{alert("ɾ��ʧ��");	}								},
				error : function(data11) {
					alert("ɾ��ʧ��");				
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
