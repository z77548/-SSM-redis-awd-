<%@ page language="java" import="java.util.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<jsp:include page="Navigation.jsp" flush="true" />
<div class="content">
	<div class="animated fadeIn">
		<div class="row">
			<div class="col-lg-6">
				<div class="card">
					<div class="card-header">
						<strong>系统设置</strong>
					</div>
					<div class="card-body card-block">
						<form action="#" method="post" enctype="multipart/form-data"
							class="form-horizontal">
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="password-input" class=" form-control-label">修改MAC地址</label>
								</div>
								<div class="col-12 col-md-9">
									<input id="mac" name="mac" value="${mac}"
										class="form-control"><small id="a-mac"
										class="help-block form-text">请输入本机MAC地址</small>

								</div>
							</div>

							<div class="submit">
								<input id="submit"
									class="btn btn-success btn-flat m-b-30 m-t-30" name="submit"
									type="button" onclick="cc();" value="修改设置"
									style="
    margin-top: 4%;">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- .animated -->
	</div>
	<script src="<%=basePath%>/user/js/mac.js" type="text/javascript"></script>
	<%@ include file="foot.jsp"%>