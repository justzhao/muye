<%@ page language="java"
	import="java.util.*,java.sql.*,db.Connect,org.apache.logging.log4j.*,cn.modernfarming.weixin.*,cn.modernfarming.mis.*,java.util.Date"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	Logger logger = LogManager.getLogger(request.getRequestURI());

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String openID = request.getParameter("OpenID");
	if (openID != null) {
		if (Services.CheckBind(openID).equals("")) {
			response.sendRedirect("MIS_Bind.jsp?OpenID=" + openID);
		}
	} else {
		response.sendRedirect("NotWeixin.jsp");
	}
	String ChartX = "", ChartData = "", ChartData1 = "", ChartData2 = "";
	String txt = "", dt = "";

	String cowID = request.getParameter("cowID");

	txt += "<div><table width=\"98%\" id=\"table-custom-2\" data-mode=\"columntoggle\" class=\"ui-body-d ui-shadow table-stripe ui-responsive\" data-column-btn-theme=\"b\" data-column-btn-text=\"选择要查看的列\" data-column-popup-theme=\"a\"><tr><th colspan=\"10\">"
			+ (cowID == null ? "":cowID)
			+ "疾病进程数据</th></tr><tr class=\"ui-bar-d\"><th>牛号</th><th>发病日期</th><th>发病时月龄</th><th>牛只类别</th><th>泌乳状态</th><th>繁殖状态</th><th>当前胎次</th><th>疾病类型</th><th>疾病名称</th><th>转归情况</th><th>兽医</th></tr>";
	if (cowID != null) {

		txt += Services.getDiseaseInfoHtml(cowID);

		}
	txt += "</table></div>";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- meta name="viewport"
	content="device-width,device-height,initial-scale=1,user-scalable=1" / -->
<meta name="viewport" content=""/ >



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile.theme-1.4.3.css"
	rel="stylesheet" type="text/css" />
<link
	href="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile.structure-1.4.3.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile-1.4.3.min.css"
	rel="stylesheet" type="text/css" />
<link href="PlugIn/jQuery/jquery-ui-1.10.2/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script src="PlugIn/jQuery/jquery-1.11.1.js" type="text/javascript"></script>
<script
	src="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile-1.4.3.min.js"
	type="text/javascript"></script>

<script src="PlugIn/jQuery/jquery-ui-1.10.2/ui/jquery.ui.core.js"
	type="text/javascript"></script>
<script src="PlugIn/jQuery/jquery-ui-1.10.2/ui/jquery.ui.datepicker.js"
	type="text/javascript"></script>

<script src="PlugIn/jQuery/Highcharts-4.0.3/js/highcharts_1.js"
	type="text/javascript"></script>
<!-- <script src="PlugIn/jQuery/Highcharts-4.0.3/js/modules/exporting.js"
	type="text/javascript"></script> -->

<title>疾病进程查询</title>
<style>
a {
	font-size: 44px;
}

td {
	text-align: right;
	font-size: 28px;
	border: 2px solid gray;
}

body {
	font-size: 30px;
}
text {
	font-size: 30px;
}

th {
	text-align: center;
	font-size: 30px;
	border: 2px solid gray;
}
</style>
<script type="text/javascript">
	function onBridgeReady() {
		WeixinJSBridge.call('hideOptionMenu');
	}

	if (typeof WeixinJSBridge == "undefined") {
		if (document.addEventListener) {
			document.addEventListener('WeixinJSBridgeReady', onBridgeReady,
					false);
		} else if (document.attachEvent) {
			document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
			document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
		}
	} else {
		onBridgeReady();
	}
</script>
</head>
<body>
	<%=txt%>

</body>
</html>
