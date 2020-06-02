<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Navigation.jsp" flush="true" />
<div class="breadcrumbs">
	<div class="breadcrumbs-inner">
		<div class="row m-0">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>发布赛事</h1>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="page-header float-right">
					<div class="page-title">
						<ol class="breadcrumb text-right">
							<li><a href="#">发布赛事</a></li>
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
						<strong>发布赛事设置</strong>
					</div>
					<div class="card-body card-block">
						<form action="../ssfb" method="post" id="form" name="form"
							enctype="multipart/form-data" class="form-horizontal">

							<div class="row form-group">
								<div class="col col-md-3">
									<label for="text-input" class=" form-control-label">赛事名称</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" id="name" name="name" placeholder="请输入赛事名称"
										class="form-control"><small
										class="form-text text-muted">赛事名称</small>
								</div>
							</div>

							<div class="row form-group">
								<div class="col col-md-3">
									<label for="password-input" class=" form-control-label">开始时间</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="datetime-local" id="intime" name="intime"
										placeholder="Password" class="form-control"><small
										class="help-block form-text">赛事开放时间</small>
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="password-input" class=" form-control-label">结束时间</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="datetime-local" id="outtime" name="outtime"
										placeholder="Password" class="form-control"><small
										class="help-block form-text">赛事关闭时间</small>
								</div>
							</div>

							<div class="row form-group">
								<div class="col col-md-3">
									<label for="textarea-input" class=" form-control-label">赛事简介</label>
								</div>
								<div class="col-12 col-md-9">
									<textarea name="jianjie" id="jianjie" rows="9"
										placeholder="Content..." class="form-control"></textarea>
								</div>
							</div>
							<div class="row form-group">


								<div class="col col-md-3">
									<label class=" form-control-label" for="textarea-input">赛事模式</label>
								</div>
								<div class="col-12 col-md-9">
									<select tabindex="1" class="form-control" id="pid" name="pid">
										<option value="1" label="普通模式"></option>
										<option value="2" label="AWD对抗模式"></option>
									</select>
								</div>

							</div>

							<div class="row form-group">
								<div class="col col-md-3">
									<label for="file-input" class=" form-control-label">赛事文件</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="file" id="file" name="file"
										class="form-control-file">
								</div>
							</div>

						</form>
					</div>
					<div class="card-footer">
						<button type="button" value="update" onclick="update()"
							class="btn btn-primary btn-sm">
							<i class="fa fa-dot-circle-o"></i> 提交
						</button>
						<button type="reset" class="btn btn-danger btn-sm">
							<i class="fa fa-ban"></i> 重置
						</button>
					</div>
				</div>

			</div>

		</div>


	</div>
	<!-- .animated -->
</div>
<script>
	function update() {
alert("发布成功");

		document.form.action = "releasesubmit.do";
		document.form.submit();
			}


</script>

<%@ include file="foot.jsp"%>
<!-- .content -->