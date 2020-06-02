<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"
	import="com.github.dockerjava.api.model.Container,com.github.dockerjava.api.model.Info,com.alibaba.fastjson.JSONObject"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List<Container> b=(List) request.getAttribute("dockerlist");
	Info info=(Info) request.getAttribute("info");
String resultJson = JSONObject.toJSONString(b);
	int i=0;
	int containersStopped=info.getContainersStopped();
	int containersRunning=info.getContainersRunning();
	int containersPaused=info.getContainersPaused();
%>



<jsp:include page="Navigation.jsp" flush="true" />
<link href="assets/css/themify-icons.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
<link href="assets/css/pe-icon-7-stroke.min.css" rel="stylesheet">

<span id="hjson" style="display:none">
	
<%= containersStopped%>;<%=containersRunning%>;<%=containersPaused%>

</span>

<div class="row">
	<div class="col-lg-3 col-md-6">
		<div class="card">
			<div class="card-body">
				<div class="stat-widget-five">
					<div class="stat-icon dib flat-color-1">
						<i class="pe-7s-cash"></i>
					</div>
					<div class="stat-content">
						<div class="text-left dib">
							<div class="stat-text">
								<span class="count"><%=info.getContainers() %></span>
							</div>
							<div class="stat-heading">��������</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="col-lg-3 col-md-6">
		<div class="card">
			<div class="card-body">
				<div class="stat-widget-five">
					<div class="stat-icon dib flat-color-2">
						<i class="pe-7s-cart"></i>
					</div>
					<div class="stat-content">
						<div class="text-left dib">
							<div class="stat-text">
								<span class=""><%=info.getOsType()%></span>
							</div>
							<div class="stat-heading">ϵͳ����</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="col-lg-3 col-md-6">
		<div class="card">
			<div class="card-body">
				<div class="stat-widget-five">
					<div class="stat-icon dib flat-color-3">
						<i class="pe-7s-browser"></i>
					</div>
					<div class="stat-content">
						<div class="text-left dib">
							<div class="stat-text">
								<span id="good" class=""><%=info.getServerVersion()%></span>
							</div>
							<div class="stat-heading">�汾��</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="col-lg-3 col-md-6">
		<div class="card">
			<div class="card-body">
				<div class="stat-widget-five">
					<div class="stat-icon dib flat-color-4">
						<i class="pe-7s-users"></i>
					</div>
					<div class="stat-content">
						<div class="text-left dib">
							<div class="stat-text">
								<span id="error" class="count"><%=info.getMemTotal()/1024/1024%></span>MB
							</div>
							<div class="stat-heading">�ڴ�</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<div class="content">
	<div class="animated fadeIn">

		<div class="row">

			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<div class="chartjs-size-monitor"
							style="left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; visibility: hidden; position: absolute; z-index: -1; pointer-events: none;">
							<div class="chartjs-size-monitor-expand"
								style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
								<div
									style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div>
							</div>
							<div class="chartjs-size-monitor-shrink"
								style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
								<div
									style="position:absolute;width:200%;height:200%;left:0; top:0"></div>
							</div>
						</div>
						<h4 class="mb-3">����ͳ��:<%=info.getOperatingSystem()%></h4>
						<canvas width="592" height="295" class="chartjs-render-monitor"
							id="doughutChart"
							style="width: 423px; height: 211px; display: block;"></canvas>
					</div>
				</div>
			</div>
			<div class="col-lg-6" style="display:none">
				<div class="card">
					<div class="card-body">
						<div class="chartjs-size-monitor"
							style="left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; visibility: hidden; position: absolute; z-index: -1; pointer-events: none;">
							<div class="chartjs-size-monitor-expand"
								style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
								<div
									style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div>
							</div>
							<div class="chartjs-size-monitor-shrink"
								style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
								<div
									style="position:absolute;width:200%;height:200%;left:0; top:0"></div>
							</div>
						</div>

						<h4 class="mb-3"></h4>

						<canvas width="631" height="631" class="chartjs-render-monitor"
							id="pieChart"
							style="width: 451px; height: 451px; display: block;"></canvas>
					</div>
				</div>

			</div>


			<div class="col-lg-6" style="display:none">
				<div class="card">
					<div class="card-body">
						<h4 class="mb-3">�������豸��������</h4>
						<canvas id="sales-chart"></canvas>
					</div>
				</div>
			</div>
			<!-- /# column -->

			<div class="col-lg-6" style="display:none;">
				<div class="card">
					<div class="card-body">
						<h4 class="mb-3">Team Commits</h4>
						<canvas id="team-chart"></canvas>
					</div>
				</div>
			</div>
			<!-- /# column -->

			<div class="col-lg-6" style="display:none;">
				<div class="card">
					<div class="card-body">
						<h4 class="mb-3">Bar chart</h4>
						<canvas id="barChart"></canvas>
					</div>
				</div>
			</div>
			<!-- /# column -->

			<div class="col-lg-6" style="display:none;">
				<div class="card">
					<div class="card-body">
						<h4 class="mb-3">Rader chart</h4>
						<canvas id="radarChart"></canvas>
					</div>
				</div>
			</div>
			<!-- /# column -->

			<div class="col-lg-6" style="display:none;">
				<div class="card">
					<div class="card-body">
						<h4 class="mb-3">Line Chart</h4>
						<canvas id="lineChart"></canvas>
					</div>
				</div>








			</div>

		</div>
		<!-- .animated -->

			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<strong class="card-title">��������</strong>
					</div>
					<div class="card-body">
						<table id="bootstrap-data-table"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>����ID</th>
									<th>����</th>
									<th>ip</th>
									<th>mac</th>
									<th>����ʱ��</th>
									<th>״̬</th>
									<th>ֹͣ</th>
									<th>����</th>
									<th>ɾ��</th>
								</tr>

							</thead>
							<tbody>
							<%for(i=0;i<b.size();i++){%>
									<tr>
								
										<td><%=i%></td>
										<td><%=b.get(i).getNames()[0]%></td>
										<td><%=b.get(i).getNetworkSettings().getNetworks().get("bridge").getIpAddress()%></td>
										<td><%=b.get(i).getNetworkSettings().getNetworks().get("bridge").getMacAddress()%></td>
										<td><%=b.get(i).getStatus()%></td>
										<td><%=b.get(i).getState()%></td>
										<td><a id="<%=b.get(i).getId()%>" href="#" onclick="danyi(this)"> ֹͣ</span></a></td>
										<td><a id="<%=b.get(i).getId()%>" href="#" onclick="danyi(this)">����</a></td>
										<td><a id="<%=b.get(i).getId()%>" href="#" onclick="danyi(this)"> ɾ��<span></span></a></td>
									</tr>
					<%}%>
								

							</tbody>
						</table>
					</div>
				</div>
			</div>


		</div>

<div class="card">
                                <div class="card-header">
                                    <strong>������������ </strong>
                                                                   </div>
                                <div class="card-body">


                                    <button class="btn btn-secondary btn-lg btn-block" id="1" onclick="alloff(this.id)" type="button">ȫ��ֹͣ</button>
                                    <button class="btn btn-success btn-lg btn-block" id="2" onclick="alloff(this.id)" type="button">ȫ������</button>

                                    <button class="btn btn-danger btn-lg btn-block" id="3" onclick="alloff(this.id)" type="button">ȫ��ɾ��</button>

                                </div>
                            </div>









<div class="col-lg-6">
                        <div class="card">
                            <div class="card-header">
                                <strong class="card-title">����</strong>
                            </div>
                            <div class="card-body">
                                <!-- Credit Card -->
                                <div id="pay-invoice">
                                    <div class="card-body">
                                        <div class="card-title">
                                            <h3 class="text-center">������ִ������</h3>
                                        </div>
                                        <hr>

                                                                                      <div class="form-group">
                                                <label class="control-label mb-1" for="cc-payment">����</label>
                                                <input id="cmd" name="cc-payment" class="form-control" aria-invalid="false" aria-required="true" type="text" value="ls">
                                            </div>
                                                                                        <div>
                                                <button class="btn btn-lg btn-info btn-block"  onclick="cmd()">
                                                    <i class="fa fa-lock fa-lg"></i>&nbsp;
                                                    <span >ִ ��</span>
                                                    <span id="payment-button-sending" style="display:none;">Sending��</span>
                                                </button>
                                            </div>
                                        
                                    </div>
   <label class="control-label mb-1" for="cc-payment">���</label>
<textarea name="textarea-input" class="form-control" id="data11" placeholder="���..." rows="9"></textarea>
                                </div>

                            </div>
                        </div> <!-- .card -->

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

<script type="text/javascript">
 function cmd(){
var a=document.getElementById("cmd").value;
	$.ajax({
				type : "post",
				url : "cmdexe.do",
				data : {
				"cmd":a,
				},
				cache : false,
				dataType : "text", //json,xml,script,html
				success : function(data) {
					document.getElementById("data11").value=data;												},
				error : function(data11) {
					alert("ִ������ʧ��");				
				}
			});

}





 function danyi(a){
var s="";
if(a.innerHTML=="����"){
s="on.do";
}else if(a.innerHTML="ֹͣ"){
s="off.do";
}else if(a.innerHTML=="ɾ��" ){
s="dele.do";
}

			$.ajax({
				type : "post",
				url : s,
				data : {
				"id":a.id,
													},
				cache : false,
				dataType : "text", //json,xml,script,html
				success : function(data) {
					alert("�����ɹ� ");
					window.location.reload();

													},
				error : function(data) {
					alert("����ʧ��");				
				}
			});



}


 function alloff(id){
var s="";
if(id==1){
s="offall.do";
}else if(id==2){
s="onall.do";
}else if(id==3){

s="deleall.do";
}

$.ajax({
				type : "post",
				url : s,
				data : {
													},
				cache : false,
				dataType : "text", //json,xml,script,html
				success : function(data) {
				

						alert("�����ɹ� ");
window.location.reload();
									},
				error : function(data) {
					alert("����ʧ��");				}
			});
}

</script>
</body>
</html>
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@2.7.3/dist/Chart.bundle.min.js"></script>
<script src="assets/js/init/chartjs-init.js"></script>
