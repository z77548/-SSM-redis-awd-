<%@ page language="java" import="java.util.*,com.ssm.chapter.pojo.OrdinaryUsers"
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
						<strong>账户信息</strong>
					</div>
					<div class="card-body card-block">
						<form action="#" method="post" enctype="multipart/form-data"
							class="form-horizontal">
							<div class="row form-group">
								<div class="col col-md-3">
									<label class=" form-control-label">用户id</label>
								</div>
								<div class="col-12 col-md-9">
									<p class="form-control-static">${newordinaryUsers.id}</p>
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label class=" form-control-label">用户名称</label>
								</div>
								<div class="col-12 col-md-9">
									<p class="form-control-static">${newordinaryUsers.name}</p>
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label class=" form-control-label">真实名称</label>
								</div>
								<div class="col-12 col-md-9">
									<p class="form-control-static">${newordinaryUsers.truename}</p>
								</div>
							</div>

							<div class="row form-group">
								<div class="col col-md-3">
									<label class=" form-control-label">身份证</label>
								</div>
								<div class="col-12 col-md-9">
									<p class="form-control-static">${newordinaryUsers.idcard}</p>
								</div>
							</div>

							<div class="row form-group">
								<div class="col col-md-3">
									<label for="text-input" class=" form-control-label"> 电话</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" id="iphone" name="text-input"
										value="${newordinaryUsers.iphone}" class="form-control"><small
									id="a-iphone" class="help-block form-text"></small>
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="email-input" class=" form-control-label">邮箱</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="email" id="email" name="email-input"
										value="${newordinaryUsers.email}" class="form-control"><small
									id="a-email" class="help-block form-text"></small>
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="password-input" class=" form-control-label">修改密码</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="password" id="passwd"
										name="password-input" placeholder="Password"
										class="form-control"><small  id="a-passwd"
										class="help-block form-text"></small>

								</div>
							</div>

							<div class="row form-group">
								<div class="col col-md-3">
									<label for="password-input" class=" form-control-label">确认密码</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="password" id="passwd2"
										name="passwd2" placeholder="Password"
										class="form-control"><small id="a-passwd2"
										class="help-block form-text"></small>

								</div>
							</div>
							<div class="submit">
								<input id="submit"
									class="btn btn-success btn-flat m-b-30 m-t-30" name="submit"
									type="button" onclick="cc();" value="修改信息"
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
	
	<script src="<%=basePath%>/user/js/sha3.js"
		type="text/javascript"></script>
	<script src="<%=basePath%>/admin/js/jquery.js" type="text/javascript"></script>
	<script src="<%=basePath%>/admin/js/xiugai.js" type="text/javascript"></script>
	<%@ include file="foot.jsp"%>