<%@ page language="java"
	import="java.util.*,com.ssm.chapter.pojo.TeamApplicationEntity,com.ssm.chapter.pojo.TeamInformation"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	List<TeamApplicationEntity> list = new ArrayList();
	list = (ArrayList) request.getAttribute("teamapplication");
	TeamInformation t = (TeamInformation) request.getAttribute("teamInformation");
%>
<jsp:include page="Navigation.jsp" flush="true" />


<div class="content">
	<div class="animated fadeIn">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<strong class="card-title">申请管理</strong>
					</div>
					<div class="card-body">
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>ID</th>
									<th>申请战队ID</th>
									<th>申请人ID</th>
									<th>申请人名字</th>
									<th>同意</th>
									<th>拒绝</th>

								</tr>

							</thead>
							<tbody>
								<%
									for (int q = 0; q < list.size(); q++) {
										TeamApplicationEntity i = list.get(q);
								%>
								<tr id="t<%=i.getId()%>">
									<td><%=i.getId()%></td>
									<td><%=i.getTeam_id()%></td>
									<td><%=i.getApplicant_id()%></td>
									<td><%=i.getApplicant_name()%></td>

									<td><a href="#" onclick="ty(this.id)"
										id="<%=i.getId()%>-ty"> <i class="fa fa-tasks"></i>同意<span
											class="badge badge-danger pull-right"></span>
									</a></td>
									<td><a href="#" onclick="ty(this.id)"
										id="<%=i.getId()%>-jj"> <i class="fa fa-bell-o"></i>拒绝<span
											class="badge badge-success pull-right"></span>
									</a></td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
					</div>
				</div>




				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">队员管理</strong>
						</div>
						<div class="card-body">
							<table id="bootstrap-data-table"
								class="table table-striped table-bordered">
								<thead>
									<tr>
										<th>用户ID</th>
										<th>用户名称</th>
										<th>战队ID</th>
										<th>战队名称</th>
										<th>踢出战队</th>
										<th>委任队长</th>
									</tr>
								</thead>
								<tbody>
									<tr>

										<td><%=t.getCaptain_id()%></td>
										<td><%=t.getCaptain_name()%></td>
										<td><%=t.getId()%></td>
										<td><%=t.getName()%></td>
										<td>队长<span class="badge badge-danger pull-right"></span></td>
										<td>队长<span class="badge badge-success pull-right"></span>
										</td>
									</tr>
									<%
										if (t.getCount() > 1) {
									%>
									<tr>
										<td><%=t.getTeam_member_1_id()%></td>
										<td><%=t.getTeam_member_1_name()%></td>
										<td><%=t.getId()%></td>
										<td><%=t.getName()%></td>
										<td><a id="<%=t.getTeam_member_1_id()%>" href="#"
											onclick="kick(this.id)"> <i class="fa fa-tasks"></i>踢出<span
												class="badge badge-danger pull-right"></span></a></td>
										<td><a href="showmemory?number=<%=t.getId()%>&type=1">
												<i class="fa fa-bell-o"></i>委任<span
												class="badge badge-success pull-right"></span>
										</a></td>
									</tr>
									<%
										}
									%>


									<%
										if (t.getCount() > 2) {
									%>
									<tr>
										<td><%=t.getTeam_member_2_id()%></td>
										<td><%=t.getTeam_member_2_name()%></td>
										<td><%=t.getId()%></td>
										<td><%=t.getName()%></td>
										<td><a href="#" id="<%=t.getTeam_member_2_id()%>"
											onclick="kick(this.id)"> <i class="fa fa-tasks"></i>踢出<span
												class="badge badge-danger pull-right"></span></a></td>
										<td><a href="showmemory?number=<%=t.getId()%>&type=1">
												<i class="fa fa-bell-o"></i>委任<span
												class="badge badge-success pull-right"></span>
										</a></td>
									</tr>
									<%
										}
									%>
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


	<div class="clearfix"></div>

	<footer class="site-footer">
		<div class="footer-inner bg-white">
			<div class="row">
				<div class="col-sm-6">Copyright &copy; 2018 Ela Admin</div>
				<div class="col-sm-6 text-right">
					Designed by <a href="https://colorlib.com">Colorlib</a>
				</div>
			</div>
		</div>
	</footer>

</div>
<!-- /#right-panel -->

<!-- Right Panel -->

<!-- Scripts -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
<script src="assets/js/main.js"></script>


<script src="assets/js/lib/data-table/datatables.min.js"></script>
<script src="assets/js/lib/data-table/dataTables.bootstrap.min.js"></script>
<script src="assets/js/lib/data-table/dataTables.buttons.min.js"></script>
<script src="assets/js/lib/data-table/buttons.bootstrap.min.js"></script>
<script src="assets/js/lib/data-table/jszip.min.js"></script>
<script src="assets/js/lib/data-table/vfs_fonts.js"></script>
<script src="assets/js/lib/data-table/buttons.html5.min.js"></script>
<script src="assets/js/lib/data-table/buttons.print.min.js"></script>
<script src="assets/js/lib/data-table/buttons.colVis.min.js"></script>
<script src="assets/js/init/datatables-init.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		$('#bootstrap-data-table-export').DataTable();
	});
	function ty(id) {
		var a = id.split("-");
		var dz = null;
		if (a[0] != "" && a[1] == "ty") {
			dz = "appteam.do";
		} else if (a[1] == "jj") {
			dz = "Refused.do";
		}
		$.ajax({
			type : "get",
			url : dz + "?id=" + a[0],
			cache : false,
			dataType : "text", //json,xml,script,html
			success : function(data) {
				if (data == "true") {
					alert("操作成功");
				location.reload();
				} else {
					alert("操作失败,申请人或者战队不符合加入人条件！");
				}
			},
			error : function(data) {
				alert("error");
			}
		});
	}


	function kick(id) {
		$.ajax({
			type : "get",
			url : "Kick.do?id=" + id,
			cache : false,
			dataType : "text", //json,xml,script,html
			success : function(data) {
				if (data == "true") {
					alert("踢出队伍成功");
					location.reload();
				} else {
					alert("操作失败！");
				}
			},
			error : function(data) {
				alert("error");
			}
		});
	}
</script>


</body>
</html>
