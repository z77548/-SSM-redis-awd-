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
						<h1>ս�ӹ���</h1>
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
						<strong class="card-title">ս�ӹ���</strong>
					</div>
					<div class="card-body">
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>ս��ID</th>
									<th>ս������</th>
									<th>�ӳ�ID</th>
								
<th>�ӳ�����</th>
<th>��ԱID</th>
<th>��Ա����</th>
<th>��ԱID</th>
<th>��Ա����</th>
<th>��������ID</th>
<th>�޸�</th>
<th>ɾ��</th>

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
										<th><a href="#">�޸�</a></th>
										<th><a herf="#" id="${i.id}" onclick="dele(this.id)">ɾ��</a></th>										
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
