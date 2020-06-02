<%@ page language="java"
	import="java.util.*,java.sql.*,com.ssm.chapter.pojo.ChooseTopicEntity,com.ssm.chapter.pojo.FileTopicEntity,com.ssm.chapter.pojo.MultipleTopicEntity"
	pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	List<ChooseTopicEntity> list1 = (List<ChooseTopicEntity>) request.getAttribute("choose");	
List<MultipleTopicEntity> list2 = (List) request.getAttribute("multiple");
	List<FileTopicEntity> list3 = (List) request.getAttribute("file");
%>



<jsp:include page="Navigation.jsp" flush="true" />

<div class="breadcrumbs">
	<div class="breadcrumbs-inner">
		<div class="row m-0">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>��Ŀ����</h1>
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
						<strong class="card-title">ѡ����</strong>
					</div>
					<div class="card-body">
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>ID</th>
									<th>����ID</th>
									<th>��Ŀ����</th>
									<th>��Ŀ����</th>
<th>��Ŀ����</th>

									<th>����</th>
								<th>�޸�</th>
								<th>ɾ��</th>

								</tr>

							</thead>
							<tbody>
					<%for(int i=0;i<list1.size();i++){%>
																	<tr>
										<td><%=list1.get(i).getId()%></td>
										<td><%=list1.get(i).getEvent_id()%></td>
										<td><%=list1.get(i).getName()%></td>
										<td><%=list1.get(i).getChoose_content()%></td>
										<td><%=list1.get(i).getFraction()%></td>
 										<td><a href="ChangeUsery.do?Name=${i.name}">�޸�</a></td>
										<td><a href="#" id="<%=list1.get(i).getId()%>" onclick="dele(1,this.id)">ɾ��</a></td>

									</tr>


<%}%>
							</tbody>
						</table>
					</div>
				</div>
			</div>


		</div>

	</div>
<div class="animated fadeIn">
		<div class="row">

			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<strong class="card-title">��ѡ��</strong>
					</div>
					<div class="card-body">
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>ID</th>
									<th>����ID</th>
									<th>��Ŀ����</th>
									<th>��Ŀ����</th>
<th>��Ŀ����</th>

									<th>����</th>
								<th>�޸�</th>
								<th>ɾ��</th>

								</tr>

							</thead>
							<tbody>
					<%for(int i=0;i<list2.size();i++){%>
																	<tr>
										<td><%=list2.get(i).getId()%></td>
										<td><%=list2.get(i).getEvent_id()%></td>
										<td><%=list2.get(i).getName()%></td>
										<td><%=list2.get(i).getTopic_content()%></td>
										<td><%=list2.get(i).getFraction()%></td>
 										<td><a href="ChangeUsery.do?Name=${i.name}">�޸�</a></td>
										<td><a href="#" id="<%=list1.get(i).getId()%>" onclick="dele(1,this.id)">ɾ��</a></td>

									</tr>


<%}%>
							</tbody>
						</table>
					</div>
				</div>
			</div>


		</div>

	</div>
	<!-- .animated -->

	<!-- .animated -->

<div class="animated fadeIn">
		<div class="row">

			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<strong class="card-title">flag��Ŀ</strong>
					</div>
					<div class="card-body">
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>ID</th>
									<th>����ID</th>
									<th>��Ŀ����</th>
									<th>��Ŀ����</th>
<th>��Ŀ����</th>
									<th>�ļ�����</th>
									<th>����</th>
								<th>�޸�</th>
								<th>ɾ��</th>

								</tr>

							</thead>
							<tbody>
					<%for(int i=0;i<list2.size();i++){%>
																	<tr>
										<td><%=list3.get(i).getId()%></td>
										<td><%=list3.get(i).getEvent_id()%></td>
										<td><%=list3.get(i).getTopic_name()%></td>
										<td><%=list3.get(i).getIntroduction()%></td>
										<td><%=list3.get(i).getFile()%></td>
										<td><%=list3.get(i).getFraction()%></td>
 										<td><a href="ChangeUsery.do?Name=${i.name}">�޸�</a></td>
										<td><a href="#" id="<%=list1.get(i).getId()%>" onclick="dele(1,this.id)">ɾ��</a></td>

									</tr>


<%}%>
							</tbody>
						</table>
					</div>
				</div>
			</div>


		</div>

	</div>






</div>








<!-- .content -->


<script type="text/javascript">
 function dele(a,b){

	$.ajax({
				type : "post",
				url : "deletTopic.do",
				data : {
				"id":a,
				"type":b,
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
