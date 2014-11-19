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
		
	String txt = "", dt = "",txt_form="";
	
	/**
	if(!BllManager.IsCheckPermisssion(openID,"12"))
	{
		txt="没有权限查询";
		 txt_form="";
	}else{
	*/
	 txt_form = "<form id=form1 action=\"\" method=\"post\" target=\"_self\">";
	txt_form += "<label for=\"cowID\"></label><input id=\"cowID\" name=\"cowID\" type=\"text\" placeholder=\"请输入牛号查询\" />";
	txt_form += "<button class=\"search\" ; onclick=\"form1.submit();\" ><div style=\"color:white;\">查询</div></button>";
			
	txt_form += "</form>";

	String ChartX = "", ChartData = "", ChartData1 = "", ChartData2 = "";


	String cowID = request.getParameter("cowID");

	/**
	txt += "<div><table width=\"98%\" id=\"table-custom-2\" data-mode=\"columntoggle\" class=\"ui-body-d ui-shadow table-stripe ui-responsive\" data-column-btn-theme=\"b\" data-column-btn-text=\"选择要查看的列\" data-column-popup-theme=\"a\"><tr><th colspan=\"17\">"
			+ (cowID == null ? "":cowID)
			+ "牛号</th></tr><tr class=\"ui-bar-d\"><th>离场日期</th><th>当前牧场</th><th>当前牛舍</th><th>牛只类别</th><th>泌乳状态</th><th>繁殖状态</th><th>当前胎次</th><th>禁配日期</th><th>禁配原因</th><th>离场方式</th><th>离场去向</th><th>离场原因</th><th>处理意见</th><th>是否主动淘汰</th><th>操作员</th><th>离场月龄</th></tr>";
	if (cowID != null) {

		txt += Services.getCowLeftInfoHtml(cowID);
         
		}
	txt += "</table></div>";
	*/
	txt += "<div><table width=\"100%\" id=\"table-custom-2\" data-mode=\"columntoggle\" class=\"ui-body-d ui-shadow table-stripe ui-responsive\" data-column-btn-theme=\"b\" data-column-btn-text=\"选择要查看的列\" data-column-popup-theme=\"a\"><tr><th colspan=\"2\"><span class=\"STYLE7\">"
			+ (cowID == null ? "":cowID)
			+ "牛号的离场信息</span> </th></tr><tr class=\"ui-bar-d\"><th width=\"30%\">栏目</th><th width=\"70%\">数据</th></tr>";
	if (cowID != null) {
		
        CowInfo info=Services.getCowLeftInfoHtml(cowID);
		//txt += Services.getCowLeftInfoHtml(cowID);
		if(info.getCurrFarm()!=null)
		{
		txt+="<tr><td>离场日期</td><td>"+ (info.getVariety()!=null?info.getVariety():"") +"</td></tr>";
		txt+="<tr><td>当前牧场</td><td>"+ (info.getCurrFarm()!=null?info.getCurrFarm():"") +"</td></tr>";
		txt+="<tr><td>当前牛舍</td><td>"+ (info.getCurrGroup()!=null?info.getCurrGroup():"") +"</td></tr>";
		txt+="<tr><td>牛只类别</td><td>"+ (info.getCurrCategory()!=null?info.getCurrCategory():"") +"</td></tr>";
		txt+="<tr><td>泌乳状态</td><td>"+ (info.getGroCode()!=null?info.getGroCode():"") +"</td></tr>";
		txt+="<tr><td>繁殖状态</td><td>"+ (info.getRepCode()!=null?info.getRepCode():"") +"</td></tr>";
		txt+="<tr><td>当前胎次</td><td>"+ info.getCurrLact() +"</td></tr>";
		txt+="<tr><td>禁配日期</td><td>"+ (info.getVarietyPurity()!=null?info.getVarietyPurity():"")  +"</td></tr>";
		txt+="<tr><td>禁配原因</td><td>"+ (info.getNomateReason()!=null?info.getNomateReason():"") +"</td></tr>";
		txt+="<tr><td>离场方式</td><td>"+ (info.getTID1()!=null?info.getTID1():"") +"</td></tr>";
		txt+="<tr><td>离场取向</td><td>"+ (info.getLeftWhere()!=null?info.getLeftWhere():"") +"</td></tr>";
		txt+="<tr><td>离场原因</td><td>"+ (info.getLeftReason()!=null?info.getLeftReason():"") +"</td></tr>";
		txt+="<tr><td>处理意见</td><td>"+ (info.getEPC()!=null?info.getEPC():"") +"</td></tr>";
		txt+="<tr><td>是否主动淘汰</td><td>"+ (info.getEarNO()!=null?info.getEarNO():"") +"</td></tr>";
		txt+="<tr><td>操作员</td><td>"+ (info.getLeftPerson()!=null?info.getLeftPerson():"") +"</td></tr>";
		txt+="<tr><td>离场月龄</td><td>"+ (info.getColor()!=null?info.getColor():"")+"</td></tr>";
		}
         
		}
	txt += "</table></div>";
	
//	BllManager.updateSearchType("disease",openID);
	
	//}

	
	
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<meta name="viewport"
	content="device-width,device-height,initial-scale=1,user-scalable=1" >
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
<title>牛的离场信息</title>
<style>
td{
border:1px solid gray;
font-size:11px;
}
th{
border:1px solid gray;
font-size:11px;
}
.search{
background:url(images/bbg.jpg) repeat top center;
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
