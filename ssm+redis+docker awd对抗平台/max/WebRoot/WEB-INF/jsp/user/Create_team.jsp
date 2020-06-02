<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<jsp:include page="Navigation.jsp" flush="true"/> 


		<div class="breadcrumbs">
			<div class="breadcrumbs-inner">
				<div class="row m-0">
					<div class="col-sm-4">
						<div class="page-header float-left">
							<div class="page-title">
								<h1>创建战队</h1>
							</div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="page-header float-right">
							<div class="page-title">
								<ol class="breadcrumb text-right">
									<li><a href="#">åå¸èµäº</a></li>
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
					<!--/.col-->



					<div class="col-lg-6">
						<div class="card">
							<div class="card-header">
								<strong>创建战队</strong>
							</div>
							<div class="card-body card-block">
								<form action="../ssfb" method="post" id="form" name="form"
									enctype="multipart/form-data" class="form-horizontal">

									<div class="row form-group">
										<div class="col col-md-3">
											<label for="text-input" class=" form-control-label">战队名称</label>
										</div>
										<div class="col-12 col-md-9">
											<input type="text" id="name" name="name"
												placeholder="请输入战队名称"><a id="a-name" name="a-name"></a>
										</div>
									</div>

								</form>
							</div>
							<div class="card-footer">
								<button type="button" id="submit" name="submit" onclick="cc()"
									class="btn btn-primary btn-sm">
									<i class="fa fa-dot-circle-o"></i> 提交
								</button>

							</div>
						</div>

					</div>

				</div>


			</div>
			<!-- .animated -->
		</div>
		<!-- .content -->
	<script src="<%=basePath%>/user/js/jque.js" type="text/javascript"></script>


<%@ include file="foot.jsp" %>
