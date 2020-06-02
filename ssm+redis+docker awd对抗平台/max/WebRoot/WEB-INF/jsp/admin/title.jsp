<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="Navigation.jsp" flush="true" />


<div class="breadcrumbs">
	<div class="breadcrumbs-inner">
		<div class="row m-0">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>发布题目</h1>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="page-header float-right">
					<div class="page-title">
						<ol class="breadcrumb text-right">
							<li><a href="#">发布题目</a></li>
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
						<strong>发布题目</strong>
					</div>
					<div class="card-body card-block">
						<form action="#" method="post" enctype="multipart/form-data"
							class="form-horizontal">

							<div class="row form-group">
								<div class="col col-md-3">
									<label for="text-input" class=" form-control-label">赛事ID</label>
								</div>
								<div class="col-12 col-md-9">
									<a class="form-text text-muted" name="ssid" id="ssid-input">赛事ID</a>
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="text-input" class=" form-control-label">赛事名称</label>
								</div>
								<div class="col-12 col-md-9">
									<a class="form-text text-muted" id="ssmc-input">赛事名称</a>
								</div>
							</div>


							<div class="row form-group">


								<div class="col col-md-3">
									<label for="textarea-input" class=" form-control-label">题目类型</label>
								</div>
								<div class="col-12 col-md-9">
									<select id="pid" class="form-control" tabindex="1"
										onchange="gradeChange()">
										<option value="1" label="单项选择"></option>
										<option value="2" label="多项选择"></option>
										<option value="3">flag</option>

									</select>
								</div>

							</div>



							<div id="mc" class="row form-group" style="display:none;">
								<div class="col col-md-3">
									<label for="password-input" class=" form-control-label">题目名称</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" name="mc" id="mc-input" placeholder="题目名称"
										class="form-control"><small
										class="help-block form-text">题目名称</small>
								</div>
							</div>

							<div id="jj" class="row form-group" style="display:none;">
								<div class="col col-md-3">
									<label for="password-input" class=" form-control-label">题目简介</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" id="jj-input" name="outtime"
										placeholder="题目简介" class="form-control"><small
										class="help-block form-text">题目简介</small>
								</div>
							</div>


							<div id="xz" class="row form-group">
								<div class="col col-md-3">
									<label for="file-input" class=" form-control-label">题目+选项</label>
								</div>
								<div class="col-12 col-md-9">
									<textarea name="xz" id="xz-input" rows="9"
										placeholder="示例：在html中，样式表按照应用方式可以分为三种类型，其中不包括（     ）。 
A. 内嵌样式表
B. 行内样式表
C. 外部样式表文件
D. 类样式表 "
										class="form-control"></textarea>
								</div>
							</div>
							<div id="fj" class="row form-group" style="display:none;">
								<div class="col col-md-3">
									<label for="file-input" class=" form-control-label">题目附件</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="file" id="fj-input" name="file"
										class="form-control-file">
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="file-input" class=" form-control-label">答案</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" name="da" id="da-input" name="outtime"
										placeholder="答案" class="form-control">
								</div>
							</div>

						</form>
					</div>
					<div class="card-footer">
						<button id="btn" type="submit" class="btn btn-primary btn-sm"
							onclick="cc();">
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
<!-- .content -->

<%@ include file="foot.jsp"%>
<script src="<%=basePat%>admin/js/jquery.js" type="text/javascript"></script>
<script src="<%=basePat%>admin/js/jque2.js" type="text/javascript"></script>
<script type="text/javascript">
	function gradeChange() {
		var a = document.getElementById("pid");
		var b = a.options[a.selectedIndex].value;
		if (b == 3) {
			document.getElementById("mc").style.display = "";
			document.getElementById("jj").style.display = "";
			document.getElementById("fj").style.display = "";
			document.getElementById("xz").style.display = "none";
		} else if (b == 1 || b == 2) {
			document.getElementById("xz").style.display = "";
			document.getElementById("mc").style.display = "none";
			document.getElementById("jj").style.display = "none";
			document.getElementById("fj").style.display = "none";
		} else {
			location.replace(document.referrer);
		}
	}
</script>


</body>
</html>