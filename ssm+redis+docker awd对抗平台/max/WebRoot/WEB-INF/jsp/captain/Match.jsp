<%@ page language="java" import="java.util.*,com.ssm.chapter.pojo.Topic"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
    int[] count = (int[]) request.getAttribute("count");
	int ss = (int)request.getAttribute("EventId");
%>
<jsp:include page="Navigation.jsp" flush="true" />
<div class="breadcrumbs">
	<div class="breadcrumbs-inner">
		<div class="row m-0">
			<div class="col-sm-4">
				<div class="page-header float-left">
					<div class="page-title">
						<h1>开始答题</h1>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="page-header float-right">
					<div class="page-title">
						<ol class="breadcrumb text-right">
							<li id="p1" class="active"></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="content">
	<div class="animated fadeIn">
		<div class="buttons">

			<!-- Left Block -->
			<div class="row">
				<div class="col-md-6">

					<div class="card">
						<div class="card-header">
							<strong> </strong> <small>一共30道题，每道题5分 </small>
						</div>
						<strong>单选题 </strong>
						<div class="card-body">
							<c:forEach begin="1" end="${count[0]}" var="i">
								<button type="button" class="btn btn-success" id="1.${i}"
									onclick="openNewDiv(this);return false;">${i}</button>
							</c:forEach>
						</div>
						<strong>多选题 </strong>
						<div class="card-body">
							<c:forEach begin="1" end="${count[1]}" var="i">
								<button type="button" class="btn btn-success" id="2.${i}"
									onclick="openNewDiv(this);return false;">${i}</button>

							</c:forEach>
						</div>
						<strong>flag </strong>
						<div class="card-body">

							<c:forEach begin="1" end="${count[2]}" var="i">
								<button type="button" class="btn btn-success" id="3.${i}"
									onclick="openNewDiv(this);return false;">${i}</button>

							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<!-- /# card -->




			<script type="text/javascript">
			var strfj = "";
    strfj += "\n";
    strfj += "\n";
    strfj += "			<div class=\"col-md-4\" id=\"fj\" style=\"max-width:100%;\">\n";
    strfj += "				<aside class=\"profile-nav alt\" style=\"width: 75%;padding-left: 30%;\">\n";
    strfj += "					<section class=\"card\">\n";
    strfj += "						<div class=\"card-header user-header alt bg-dark\">\n";
    strfj += "							<div class=\"media\">\n";
    strfj += "								<a href=\"#\"> <img\n";
    strfj += "									class=\"align-self-center rounded-circle mr-3\"\n";
    strfj += "									style=\"width:85px; height:85px;\" alt=\"\"\n";
    strfj += "									src=\"<%=basePath%>captain/images/admin.jpg\">\n";
    strfj += "								<\/a>\n";
    strfj += "								<div class=\"media-body\">\n";
    strfj += "									<h2 class=\"text-light display-6\">寻找flag<\/h2>\n";
    strfj += "									<a id=\"fjid\"><\/a> <span class=\"badge badge-primary pull-right\"\n";
    strfj += "										id=\"fjfs\"><\/span>\n";
    strfj += "								<\/div>\n";
    strfj += "								<a id=\"x\" href=\"#\" onclick=\"b();\" href=\"#power-off\"><i\n";
    strfj += "									class=\"fa fa-power-off\"><\/i> 关闭<\/a>\n";
    strfj += "							<\/div>\n";
    strfj += "						<\/div>\n";
    strfj += "						<ul class=\"list-group list-group-flush\">\n";
    strfj += "							<li class=\"list-group-item\"><a href=\"#\"> <i\n";
    strfj += "									class=\"fa fa-envelope-o\"><\/i> 题目名称：<a id=\"fjmc\"\n";
    strfj += "									style=\"white-space:pre-line;\"><\/a><\/li>\n";
    strfj += "							<li class=\"list-group-item\"><a href=\"#\"> <i\n";
    strfj += "									class=\"fa fa-envelope-o\"><\/i> 题目简介：<a id=\"fjjj\"\n";
    strfj += "									style=\"white-space:pre-line;\"><\/a><\/li>\n";
    strfj += "							<li class=\"list-group-item\"><a href=\"#\"> <i\n";
    strfj += "									class=\"fa fa-envelope-o\"><\/i> 题目附件：<a\n";
    strfj += "									style=\"white-space:pre-line;\"><\/a><a href=\"#\"\n";
    strfj += "									style=\"color:green;\" id=\"fjfj\">点击下载<\/a><\/li>\n";
    strfj += "							<li class=\"list-group-item\"><a href=\"#\"> <i\n";
    strfj += "									class=\"fa fa-bell-o\"><\/i> <input id=\"fjda\" type=\"text\"\n";
    strfj += "									placeholder=\"请输入flag\" style=\"width: 65%; border:0;\" />\n";
    strfj += "							<\/a><\/li>\n";
    strfj += "\n";
    strfj += "							<li class=\"list-group-item\">\n";
    strfj += "								<div class=\"fjcode\">\n";
    strfj += "									<i class=\"fa fa-bell-o\" style=\"float:left;margin-top:2%;\">验证码:<\/i><input\n";
    strfj += "										id=\"fjcd\" class=\"form-control\"\n";
    strfj += "										style=\"width:50%;float:left;margin-left:2%;\" name=\"code\"\n";
    strfj += "										placeholder=\"点击图片切换验证码\"> <a id=\"a-code\"><\/a> <img\n";
    strfj += "										style=\"float:left;margin-left:2%;\"\n";
    strfj += "										src=\"<%=basePath%>code/code.do\" id=\"codeimage\"\n";
    strfj += "										style=\"margin-right:-46px;margin-top:10px;\"\n";
    strfj += "										onclick=\"javascript:this.src='<%=basePath%>code/code.do?tm='+Math.random()\">\n";
    strfj += "								<\/div>\n";
    strfj += "							<\/li>\n";
    strfj += "							<li class=\"list-group-item\"><button class=\"btn btn-success\"\n";
    strfj += "								id=\"button3\"	onclick=\"submit(this);\" style=\"width: 100%;\">提交<\/button><\/li>\n";
    strfj += "						<\/ul>\n";
    strfj += "					<\/section>\n";
    strfj += "				<\/aside>\n";
    strfj += "			<\/div>\n";
    strfj += "\n";
		var strxz = "";
    strxz += "<div class=\"col-md-4\" id=\"xz\" style=\"max-width:100%;\" >\n";
    strxz += "				<aside class=\"profile-nav alt\" style=\"width: 75%;padding-left: 30%;\">\n";
    strxz += "					<section class=\"card\">\n";
    strxz += "						<div class=\"card-header user-header alt bg-dark\">\n";
    strxz += "							<div class=\"media\">\n";
    strxz += "								<a href=\"#\"> <img\n";
    strxz += "									class=\"align-self-center rounded-circle mr-3\"\n";
    strxz += "									style=\"width:85px; height:85px;\" alt=\"\"\n";
    strxz += "									src=\"<%=basePath%>captain/images/admin.jpg\">\n";
    strxz += "								<\/a>\n";
    strxz += "								<div class=\"media-body\">\n";
    strxz += "									<h2 class=\"text-light display-6\">单项选择<\/h2>\n";
    strxz += "									<a id=\"xzid\"><\/a> <span class=\"badge badge-primary pull-right\"\n";
    strxz += "										id=\"fs\"><\/span>\n";
    strxz += "								<\/div>\n";
    strxz += "								<a id=\"x\" href=\"#\" onclick=\"b();\" href=\"#power-off\"><i\n";
    strxz += "									class=\"fa fa-power-off\"><\/i> 关闭<\/a>\n";
    strxz += "							<\/div>\n";
    strxz += "						<\/div>\n";
    strxz += "						<ul class=\"list-group list-group-flush\">\n";
    strxz += "							<li class=\"list-group-item\"><a href=\"#\"> <i\n";
    strxz += "									class=\"fa fa-envelope-o\"><\/i> 题目：<a id=\"xztm\"\n";
    strxz += "									style=\"white-space:pre-line;\"><\/a><\/li>\n";
    strxz += "							<li class=\"list-group-item\"><a href=\"#\"> <i\n";
    strxz += "									class=\"fa fa-bell-o\" style=\"float:left;margin-top:2%;\">答 案:<\/i>\n";
    strxz += "									<select id=\"xzda\" class=\"form-control\"\n";
    strxz += "									style=\"width: 50%; margin-left: 4%; float: left;\">\n";
    strxz += "										<option value=\"A\">A<\/option>\n";
    strxz += "										<option value=\"B\">B<\/option>\n";
    strxz += "										<option value=\"C\">C<\/option>\n";
    strxz += "										<option value=\"D\">D<\/option>\n";
    strxz += "								<\/select><\/a><\/li>\n";
    strxz += "							<li class=\"list-group-item\">\n";
    strxz += "								<div class=\"code\">\n";
    strxz += "									<i class=\"fa fa-bell-o\" style=\"float:left;margin-top:2%;\">验证码:<\/i><input\n";
    strxz += "										name=\"\" id=\"xzcd\" class=\"form-control\"\n";
    strxz += "										style=\"width:50%;float:left;margin-left:2%;\"\n";
    strxz += "										placeholder=\"点击图片切换验证码\"> <a id=\"a-code\"><\/a> <img\n";
    strxz += "										style=\"float:left;margin-left:2%;\"\n";
    strxz += "										src=\"<%=basePath%>code/code.do\" id=\"codeimage\"\n";
    strxz += "										style=\"margin-right:-46px;margin-top:10px;\"\n";
    strxz += "										onclick=\"javascript:this.src='<%=basePath%>code/code.do?tm='+Math.random()\">\n";
    strxz += "								<\/div>\n";
    strxz += "							<\/li>\n";
    strxz += "\n";
    strxz += "							<li class=\"list-group-item\"><button class=\"btn btn-success\"\n";
    strxz += "									id=\"button1\" onclick=\"submit(this);\" style=\"width: 100%;\">提交<\/button><\/li>\n";
    strxz += "						<\/ul>\n";
    strxz += "					<\/section>\n";
    strxz += "				<\/aside>\n";
    strxz += "			<\/div>\n";
    
var strdx = "";
    strdx += "	<div class=\"col-md-4\" id=\"dx\" style=\"max-width:100%;\">\n";
    strdx += "				<aside class=\"profile-nav alt\" style=\"width: 75%;padding-left: 30%;\">\n";
    strdx += "					<section class=\"card\">\n";
    strdx += "						<div class=\"card-header user-header alt bg-dark\">\n";
    strdx += "							<div class=\"media\">\n";
    strdx += "								<a href=\"#\"> <img\n";
    strdx += "									class=\"align-self-center rounded-circle mr-3\"\n";
    strdx += "									style=\"width:85px; height:85px;\" alt=\"\"\n";
    strdx += "									src=\"<%=basePath%>captain/images/admin.jpg\">\n";
    strdx += "								<\/a>\n";
    strdx += "								<div class=\"media-body\">\n";
    strdx += "									<h2 class=\"text-light display-6\">多项选择<\/h2>\n";
    strdx += "									<a id=\"dxid\"><\/a> <span class=\"badge badge-primary pull-right\"\n";
    strdx += "										id=\"dxfs\"><\/span>\n";
    strdx += "								<\/div>\n";
    strdx += "								<a id=\"x\" href=\"#\" onclick=\"b();\" href=\"#power-off\"><i\n";
    strdx += "									class=\"fa fa-power-off\"><\/i> 关闭<\/a>\n";
    strdx += "							<\/div>\n";
    strdx += "						<\/div>\n";
    strdx += "						<ul class=\"list-group list-group-flush\">\n";
    strdx += "							<li class=\"list-group-item\"><a href=\"#\"> <i\n";
    strdx += "									class=\"fa fa-envelope-o\"><\/i> 题目：<a id=\"dxtm\"\n";
    strdx += "									style=\"white-space:pre-line;\"><\/a><\/li>\n";
    strdx += "							<li class=\"list-group-item\"><a href=\"#\"> <i\n";
    strdx += "									class=\"fa fa-bell-o\"><\/i> <input id=\"dxda\" type=\"text\"\n";
    strdx += "									placeholder=\"请输入答案\" style=\"width: 65%; border:0;\" />\n";
    strdx += "							<\/a><\/li>\n";
    strdx += "\n";
    strdx += "							<li class=\"list-group-item\">\n";
    strdx += "								<div class=\"code\">\n";
    strdx += "									<i class=\"fa fa-bell-o\" style=\"float:left;margin-top:2%;\">验证码:<\/i><input\n";
    strdx += "										id=\"dxcd\" class=\"form-control\"\n";
    strdx += "										style=\"width:50%;float:left;margin-left:2%;\" name=\"code\"\n";
    strdx += "										placeholder=\"点击图片切换验证码\"> <a id=\"a-code\"><\/a> <img\n";
    strdx += "										style=\"float:left;margin-left:2%;\"\n";
    strdx += "										src=\"<%=basePath%>code/code.do\" id=\"codeimage\"\n";
    strdx += "										style=\"margin-right:-46px;margin-top:10px;\"\n";
    strdx += "										onclick=\"javascript:this.src='<%=basePath%>code/code.do?tm='+Math.random()\">\n";
    strdx += "								<\/div>\n";
    strdx += "							<\/li>\n";
    strdx += "							<li class=\"list-group-item\"><button class=\"btn btn-success\"\n";
    strdx += "								id=\"button2\"	onclick=\"submit(this);\" style=\"width: 100%;\">提交<\/button><\/li>\n";
    strdx += "						<\/ul>\n";
    strdx += "					<\/section>\n";
    strdx += "				<\/aside>\n";
    strdx += "			<\/div>\n";
    strdx += "\n";
    strdx += "\n";
			var newDiv=null;
			var _id1=null;
			var m=null;
			var docEle = function() {
						return document.getElementById(arguments[0]) || false;
					}
					function submit(a) {	
					  var bid= $(a).attr("id");
					  var id=null;
					  var code=null;
					var da=null;
					var q=null;
					var t=null;
					var x=null;
  				if(bid=="button1"){
  				q=document.getElementById("xzid");
  				t=document.getElementById("xzcd");
  				x=document.getElementById("xzda");
  				id=q.innerHTML;
  				code=t.value;
  				da=x.value;
  				}else if(bid=="button2"){		
  		
  				id=document.getElementById("dxid").innerHTML;
  				code=document.getElementById("dxcd").value;
  								da=document.getElementById("dxda").value;
  				}else if(bid=="button3"){			
  				id=document.getElementById("fjid").innerHTML;
  				code=document.getElementById("fjcd").value;
  								da=document.getElementById("fjda").value;
  				}else{
  				alert("error");
  				}
  				if(code==null||code.length!=4){
  		      		alert("验证码错误");
  				}else{
  				if(da.length==0){
  		      		alert("答案不能为空");
  		      	}else{
  						var idtemp=id.split(".");
  						$.ajax({
							type : "post",
							url : "<%=basePath%>check/check.do",
							async: false,
							data : {
								id:idtemp[1],
								code:code,
								type:idtemp[0],
								answer:da,
								event_id:<%=ss%>,
							},
							cache : false,
							contentType: "application/x-www-form-urlencoded; charset=utf-8", 
							dataType : "json",
							success : function(data) {
							alert(data);
	 document.getElementById("codeimage").src = '../code/code.do?tm=' + Math.random();

							},
							error : function(data) {
	 document.getElementById("codeimage").src = '../code/code.do?tm=' + Math.random();

								alert(JSON.stringify(data["responseText"]));
							}
						}); 
						}
						}
					}
					
					
					
					function openNewDiv(_id) {
						var json=null;
						var type=null;
						var strs = new Array(); 
						strs = _id.id.split("."); 
						$.ajax({
							type : "post",
							url : "<%=basePath%>captain/Topicdq.do",
							async: false,
							data : {
								ssid :<%=ss%>,
								type : strs[0],
								count : strs[1],
							},
							cache : false,
							contentType: "application/x-www-form-urlencoded; charset=utf-8", 
							dataType : "json",
							success : function(data) {		
							json=data;
							type=strs[0];
							},
							error : function(data) {
								alert(data);
							}
						}); 
						if(type==1){;
							var divname="xz";
							a(_id,json,divname); 	
						}else if(type==2){					
							var divname="dx";
							a(_id,json,divname);
						}else if(type==3){
							var divname="fj";	
							a(_id,json,divname);
						}else{
							alert("error");
						}			
					}
						function newDivCenter() {
							newDiv.style.top = (document.body.scrollTop + document.body.clientHeight / 2 - newDivHeight / 2) + "px";
							newDiv.style.left = (document.body.scrollLeft + document.body.clientWidth / 2 - newDivWidth / 2) + "px";
						}
					function b() {
						if (document.all) {
								window.detachEvent("onscroll", newDivCenter);
							} else {
								window.removeEventListener('scroll', newDivCenter, false);
							}
							document.body.removeChild(docEle(_id1));
							document.body.removeChild(docEle(m));
							return false;
					}
					function a(_id,json,divname) {
						_id1=_id;
						m = "mask";
						if (docEle(_id)) document.body.removeChild(docEle(_id));
						if (docEle(m)) document.body.removeChild(docEle(m));
						var newMask = document.createElement("div");
						newMask.id = m;
						newMask.style.position = "absolute";
						newMask.style.zIndex = "1";
						_scrollWidth = Math.max(document.body.scrollWidth, document.documentElement.scrollWidth);
						_scrollHeight = Math.max(document.body.scrollHeight, document.documentElement.scrollHeight);
						newMask.style.width = _scrollWidth + "px";
						newMask.style.height = _scrollHeight + "px";
						newMask.style.top = "0px";
						newMask.style.left = "0px";
						newMask.style.background = "#33393C";
						newMask.style.filter = "alpha(opacity=40)";
						newMask.style.opacity = "0.40";
						document.body.appendChild(newMask);
						newDiv = document.createElement("div");
						newDiv.id = _id;
						newDiv.style.position = "absolute";
						newDiv.style.zIndex = "9999";
						newDivWidth = "100%";
						newDivHeight = "100%";
						newDiv.style.margin.left = "20%";
						newDiv.style.width = newDivWidth;
						newDiv.style.height = newDivHeight;
						newDiv.style.top = (document.body.scrollTop + document.body.clientHeight / 2 - newDivHeight / 2) + "px";
						newDiv.style.left = (document.body.scrollLeft + document.body.clientWidth / 2 - newDivWidth / 2) + "px";
						newDiv.style.padding.left= "20%";
						if(divname=="xz"){
						newDiv.innerHTML =strxz;
						}else if(divname=="dx"){
						newDiv.innerHTML =strdx;
						}else if(divname=="fj"){
						newDiv.innerHTML =strfj;
						}else{
						alert("error");					
						}
						newDiv.innerHTML += "&nbsp"	
						document.body.appendChild(newDiv);	
							var newA=document.getElementById("x");
					
								newA.onclick = function() {
							if (document.all) {
								window.detachEvent("onscroll", newDivCenter);
							} else {
								window.removeEventListener('scroll', newDivCenter, false);
							}
							document.body.removeChild(docEle(_id));
							document.getElementById("mask").remove();
							return false;
						}
								
						if(divname=="xz"){
					document.getElementById("xzid").innerHTML ="1."+json.id;
					document.getElementById("xztm").innerHTML =json.choose_content;
					document.getElementById("fs").innerHTML =json.fraction+"分";
						}else if(divname=="dx"){
					document.getElementById("dxid").innerHTML ="2."+json.id;
					document.getElementById("dxtm").innerHTML =json.topic_content;
					document.getElementById("dxfs").innerHTML =json.fraction+"分";
						}else if(divname=="fj"){
						document.getElementById("fjid").innerHTML ="3."+json.id;
					document.getElementById("fjmc").innerHTML =json.name;
					document.getElementById("fjjj").innerHTML =json.introduction;
					document.getElementById("fjfj").href ="../update/"+json.file;
					document.getElementById("fjfs").innerHTML =json.fraction+"分";
						}else{					
						alert("error");
						}
						if (document.all) {
							window.attachEvent("onscroll", newDivCenter);
						} else {
							window.addEventListener('scroll', newDivCenter, false);
								
						}
					
					}
					
					function closeDiv() {
						if (document.all) {
							window.detachEvent("onscroll", newDivCenter);
						} else {
							window.removeEventListener('scroll', newDivCenter, false);
						}
						document.body.removeChild(docEle(_id));
						document.body.removeChild(docEle(m));
						return false;
					}
					function toDate(n){
					        if(n<10){
					            return '0'+n;
					        }else{
					            return ''+n;
					        }
					    };
					    window.onload = function(){
					        function trick(){
								var oDate = new Date();
								var year = oDate.getFullYear();
								var month = oDate.getMonth() + 1;
								var day = oDate.getDate();
								if (month < 10) {
									    month = "0" + month;
									}
								if (day < 10) {
									    day = "0" + day;
									}
					            var H = toDate(oDate.getHours());
					            var M = toDate(oDate.getMinutes());
					            var S = toDate(oDate.getSeconds());
					            var t =year+"年"+month+"月"+day+"日"+"   "+ H +":"+ M +":"+S;
					            document.getElementById('p1').innerHTML = t;
					        }
					        setInterval(trick,1000);
					    };		
</script>
			<%@ include file="foot.jsp"%>