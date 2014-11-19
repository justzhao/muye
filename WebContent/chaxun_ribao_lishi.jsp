<%@page import="com.menu.manager.BllManager"%>
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
	String openID=request.getParameter("OpenID");
	if(openID!=null){
		if(Services.CheckBind(openID).equals("")){
				response.sendRedirect("MIS_Bind.jsp?OpenID="+openID);
		}
	}else{
	response.sendRedirect("NotWeixin.jsp");
	}
	
	String txt = "", dt = "" , txt_form="";
	
	/**
	if(!BllManager.IsCheckPermisssion(openID,"12"))
	{
		txt="没有权限查询";
	
	}else
	{*/
	
		List<String> farmlist=Services.getAllFarmInfo();
	txt_form = "<form id=form1 action=\"chaxun_ribao_lishi_result.jsp?OpenID="+openID+"\" method=\"post\" target=\"_self\">";
	txt_form += "<label for=\"farmName\">牧场</label><select id=\"farmName\" name=\"farmName\" > "
			+ "<option selected>集团</option>";
			for(String s:farmlist)
			{
				txt_form+="<option>"+ s+"</option>";
			}
			
		
			txt_form+= " </select>";
			
			
			
	txt_form += "<label for=\"dt1\" >开始日期</label><input id=\"dt1\" name=\"dt1\" type=\"text\" readonly=true />";
	txt_form += "<label for=\"dt2\">结束日期</label><input id=\"dt2\" name=\"dt2\" type=\"text\" readonly=true />";
	txt_form += "<button class=\"search\" ; onclick=\"form1.submit();\" ><div style=\"color:white;\">查询</div></button>";
			

	txt_form += "</form>";
	String Dt1 = request.getParameter("dt1");
	String Dt2 = request.getParameter("dt2");
	String farmName = request.getParameter("farmName");
		txt += "<div><table width=\"100%\" id=\"table-custom-2\" data-mode=\"columntoggle\" class=\"ui-body-d ui-shadow table-stripe ui-responsive\" data-column-btn-theme=\"b\" data-column-btn-text=\"选择要查看的列\" data-column-popup-theme=\"a\"><tr class=\"ui-bar-d\"><th>牧场</th><th>总产量</th><th>成母牛单产</th><th>泌乳牛单产</th><th>蛋白质</th><th>脂肪</th><th>干物质</th><th>微生物</th><th>体细胞</th><th data-priority=\"1\">干奶牛比例</th></tr>";
	if (Dt1 != null) {

		try {
			Connection conn;
			ResultSet rsL1;
			Statement statementL1;
			String SSQL;
			conn = Connect.connect();
			statementL1 = conn.createStatement(
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			SSQL = "select convert(varchar,[dt],112) dt,[FARM],[TOTAL],[adult_cow],[Lactating_cow],[protein],[fat],[dry_matter],[germ],[soma],[proportion] from [REPORT_Dairy_Product_Summary] where 1=1"
					+ " and dt between '"
					+ Dt1
					+ "' and '"
					+ Dt2
					+ " 23:59:59'"
					+ " and FARM = '"
					+ farmName
					+ "'"
					+ " order by dt desc";
			logger.debug(SSQL);
			rsL1 = statementL1.executeQuery(SSQL);
			ResultSetMetaData rsmd1 = rsL1.getMetaData();
			int count = rsmd1.getColumnCount();
			logger.debug(count);
			while (rsL1.next()) {
				dt = rsL1.getString(1);
				txt += "<tr>";
				for (int i = 2; i <= count; i++) {
					if (i == 11) {
						txt += "<td>" + rsL1.getString(i) + "%</td>";
					} else {
						txt += "<td>" + rsL1.getString(i) + "</td>";
					}
				}
				txt += "</tr>";
			}
			rsL1.close();
			statementL1.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
		}

	}
		txt += "</table></div>";
	//}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="device-width,device-height,initial-scale=1,user-scalable=1" />

	
	

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
<title>日报</title>
<style>
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
<div id="contetn">
	<%=txt_form%>
	</div>

</body>
</html>
<script>
	$("#dt1").datepicker({
		dateFormat : 'yy-mm-dd'
	});
	$("#dt1").datepicker('setDate', (new Date()).getDate()-32);
	$("#dt2").datepicker({
		dateFormat : 'yy-mm-dd'
	});
	$("#dt2").datepicker('setDate', new Date());
</script>