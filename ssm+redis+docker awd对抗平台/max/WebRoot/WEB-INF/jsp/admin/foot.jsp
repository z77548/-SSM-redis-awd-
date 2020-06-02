<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String pat = request.getContextPath();
	String basePat = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ pat + "/";
%>

<div class="clearfix"></div>

<footer class="site-footer">
	<div class="footer-inner bg-white">
		<div class="row">
			<div class="col-sm-6"> </div>
			<div class="col-sm-6 text-right">
				Designed by <a href="#">Liu Yun Wei</a>
			</div>
		</div>
	</div>
</footer>

</div>
<!-- /#right-panel -->

<!-- Right Panel -->

<!-- Scripts -->
<script src="<%=basePat%>admin/assets/js/jquery.min.js"></script>
<script src="<%=basePat%>admin/assets/js/popper.min.js"></script>
<script src="<%=basePat%>admin/assets/js/bootstrap.min.js"></script>
<script src="<%=basePat%>admin/assets/js/jquery.matchHeight.min.js"></script>
<script src="<%=basePat%>admin/assets/js/main.js"></script>
<script src="<%=basePat%>admin/assets/js/jquery.js" type="text/javascript"></script>


</body>
</html>