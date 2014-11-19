
<%@page import="com.menu.manager.BllManager"%>
<%@ page language="java"
	import="java.util.*,java.sql.*,db.Connect,org.apache.logging.log4j.*,cn.modernfarming.weixin.*,cn.modernfarming.mis.*,java.util.Date"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	Logger logger = LogManager.getLogger(request.getRequestURI());
    //更新查询种类，牛只，疾病，繁殖
    
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String openID=request.getParameter("OpenID");
	if(openID!=null){
		if(Services.CheckBind(openID).equals("")){
				response.sendRedirect("MIS_Bind.jsp?OpenID="+openID);
		}
	}else{
	response.sendRedirect("NotWeixin.jsp");
	}
	//牧场厂长来查
	
	String txt="";
	String txt_form="";
	/**
	if(!BllManager.IsCheckPermisssion(openID,"12"))
	{
		txt="没有权限查询";
		 txt_form="";
	}else{
	*/
	
	
	String dt = "";
	
    /* txt_form ="<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"
			+"<tr>"
			+"<td><img src=\"images/t.jpg\" width=\"320\" height=\"23\"></td>"
			
			+"</tr>"
			+"<tr><td align=\"center\" style=\"background:url(images/t.jpg) repeat-y top center\">"
			+"<table width=\"86%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"; */
	txt_form = "<form id=form1 action=\"\" method=\"post\" target=\"_self\">";
	txt_form += "<label style=\"font-size:14px\" for=\"cowID\">牛号</label><input  style=\" line-height:28px; height:28px; margin-top:3px; background:url(images/iin.jpg) repeat; border:0\" id=\"cowID\" name=\"cowID\" type=\"text\" />";
	txt_form += " <button class=\"search\" onclick=\"form1.submit();\" ><div style=\"font-size: 15px;color:white; \"  >查询</div></button>";
			
	txt_form += "</form>";
	//txt_form +=</table></td></tr></table>";
	String ChartX = "", ChartData = "", ChartData1 = "", ChartData2 = "";

	String cowID = request.getParameter("cowID");

	txt += "<div ><table width=\"98%\" id=\"table-custom-2\" data-mode=\"columntoggle\" class=\"ui-body-d ui-shadow table-stripe ui-responsive\" data-column-btn-theme=\"b\" data-column-btn-text=\"选择要查看的列\" data-column-popup-theme=\"a\"><tr><th  colspan=\"10\"> <span class=\"STYLE7\">"
			+ (cowID == null ? "":cowID) 
			+ "繁殖进程数据</th></tr><tr class=\"ui-bar-d\"><th bgcolor=\"a69c7f\">进程</th><th bgcolor=\"a69c7f\">事件日期</th><th bgcolor=\"a69c7f\">当时牛只类别</th><th bgcolor=\"a69c7f\">当时泌乳状态</th><th bgcolor=\"a69c7f\">当时繁殖状态</th><th bgcolor=\"a69c7f\">当时胎次</th><th bgcolor=\"a69c7f\">详细信息</th></tr>";
	if (cowID != null) {

		txt += Services.getBreedingInfoHtml(cowID);

		}
	//txt += "</table></div></table>";
	
	BllManager.updateSearchType("breed",openID);
//	}
		
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport"
	content="device-width,device-height,initial-scale=1,user-scalable=1" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="css/mystyle.css" rel="stylesheet" type="text/css" />

<link
	href="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile.theme-1.4.3.css"
	rel="stylesheet" type="text/css" /> 
<link
	href="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile.structure-1.4.3.min.css"
	rel="stylesheet" type="text/css" />
	<!--  
<link
	href="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile-1.4.3.min.css"
	rel="stylesheet" type="text/css" />-->
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

<title>繁殖进程查询</title>
<style>

</style>
<script type="text/javascript">
function onBridgeReady(){
 WeixinJSBridge.call('hideOptionMenu');
}

if (typeof WeixinJSBridge == "undefined"){
    if( document.addEventListener ){
        document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
    }else if (document.attachEvent){
        document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
        document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
    }
}else{
    onBridgeReady();
}
</script>

<style>
td{
border:1px solid gray;
font-size:11px;
}
th{


border:1px solid gray;
font-size:11px;

}
.STYLE7 {
   color: #FFFFFF;
	font-size: 14px;
}
</style>
<script type="text/javascript">
function onBridgeReady(){
 WeixinJSBridge.call('hideOptionMenu');
}

if (typeof WeixinJSBridge == "undefined"){
    if( document.addEventListener ){
        document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
    }else if (document.attachEvent){
        document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
        document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
    }
}else{
    onBridgeReady();
}
</script>
</head> 
<body>

<div id="content">
	<%=txt_form %>
		<%=txt %>
</div>

	</body>


</html>
