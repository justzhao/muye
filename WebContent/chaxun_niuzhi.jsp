<%@page import="com.menu.manager.BllManager"%>
<%@ page language="java"
	import="java.util.*,java.sql.*,db.Connect,org.apache.logging.log4j.*,cn.modernfarming.weixin.*,cn.modernfarming.mis.*"
	pageEncoding="UTF-8"%>
<%
	Logger logger = LogManager.getLogger(request.getRequestURI());

     //更新查询种类，牛只
  

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
	
	String txt="", txt_q = "";
	//12是牧场厂长
	
	/**
	if(!BllManager.IsCheckPermisssion(openID,"12"))
	{
		txt="没有权限查询";
		 txt_q="";
	}else{
		
		*/
    txt = " <div id=\"content\"> ";
	txt += "<br/><form id=form1 method=\"post\" target=\"_self\" action=\"\">"
			+ "<label for=\"CowID\" ></label><input type=text id=\"CowID\" name=\"CowID\" placeholder=\"请输入牛号查询\" />"
			+ "<button class=\"search\"; onclick=\"form1.submit();\" ><div style=\"color:white;\">查询</div></button>" + "</form>";

			//在这更新状态
			//BllManager.updateSearchType("cow",openID);

	String cowID = request.getParameter("CowID");
	if (cowID != null) {
		CowInfo cowInfo;
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnCowInfoReponse response1 = client
					.getCowInfoByCowID(cowID);
			logger.debug(response1.getRtnCode());
			if (response1.getRtnCode() != -1) {
				cowInfo = response1.getRtnCowInfo();


				txt_q += "<table id=\"table-custom-2\" width=100% class=\"ui-body-d ui-shadow table-stripe ui-responsive\">";
				txt_q +="<tr><th bg  colspan=\"2\"> <span class=\"STYLE7\"> 编号为"
						+ (cowID == null ? "":cowID) 
						+ "的牛只基本信息</th></tr>";
				txt_q += "<tr><th  width=\"30%\">"
						+" <span style=\"color:black\">栏目</span></th><th  width=\"70%\"><span style=\"color:black\">数据</span></th><tr>";
					txt_q += "<tr><td>牛号</td><td>"+ cowID +"</td></tr>";
				if (cowInfo.isSex()) {
					txt_q += "<tr><td>性别</td><td>公</td></tr>";
				} else {
					txt_q += "<tr><td>性别</td><td>母</td></tr>";
				}
				if (!cowInfo.getCurrFarm().equals(""))
					txt_q += "<tr><td>当前牧场</td><td>"
							+ cowInfo.getCurrFarm() + "</td></tr>";
				if (!cowInfo.getCurrGroup().equals(""))
					txt_q += "<tr><td>当前牛舍</td><td>"
							+ cowInfo.getCurrGroup() + "</td></tr>";
				if (!cowInfo.getLastFindGroupNO().equals(""))
					txt_q += "<tr><td>最后发现牛舍</td><td>"
							+ cowInfo.getLastFindGroupNO()
							+ "</td></tr>";
				String dt01 = Services.GetDate(cowInfo
						.getLastFindTime());
				if (!dt01.equals("1-1-1"))
					txt_q += "<tr><td>最后发现时间</td><td>" + dt01
							+ "</td></tr>";
				dt01 = Services.GetDate(cowInfo.getEnterDate());
				if (!dt01.equals("1-1-1"))
					txt_q += "<tr><td>进场日期</td><td>" + dt01
							+ "</td></tr>";

				txt_q += "<tr><td>出生胎次</td><td>"
						+ cowInfo.getBornLact() + "</td></tr>";

				txt_q += "<tr><td>当前胎次</td><td>"
						+ cowInfo.getCurrLact() + "</td></tr>";

				String dt1 = Services.GetDate(cowInfo.getBirthday());
				if (!dt1.equals("1-1-1"))
					txt_q += "<tr><td>出生日期</td><td>" + dt1
							+ "</td></tr>";
				dt1 = Services.GetDate(cowInfo.getLastCalvDate());
				if (!dt1.equals("1-1-1"))
					txt_q += "<tr><td>最近分娩日期</td><td>" + dt1
							+ "</td></tr>";

				txt_q += "<tr><td>初生重</td><td>"
						+ cowInfo.getBornWeight() + "</td></tr>";
						
				txt_q += "<tr><td>落地价</td><td>"
						+ cowInfo.getBornValue() + "</td></tr>";
				if(cowInfo.isIsET()){
					txt_q += "<tr><td>是否ET牛</td><td>是</td></tr>";
				}
				else{
					txt_q += "<tr><td>是否ET牛</td><td>否</td></tr>";	
				}
				if(cowInfo.isIsTwin()){
					txt_q += "<tr><td>是否双胞胎</td><td>是</td></tr>";
				}else{
					txt_q += "<tr><td>是否双胞胎</td><td>否</td></tr>";	
				}
				if(cowInfo.isIsInsurance()){
					txt_q += "<tr><td>是否保险</td><td>是</td></tr>";
				}else{
					txt_q += "<tr><td>是否保险</td><td>否</td></tr>";	
				}

								
				if (!cowInfo.getCurrCategory().equals(""))
					txt_q += "<tr><td>当前状态</td><td>"
							+ cowInfo.getCurrCategory() + "</td></tr>";

				String dt3 = Services.GetDate(cowInfo.getAblactDate());
				if (!dt3.equals("1-1-1"))
					txt_q += "<tr><td>断奶日期</td><td>" + dt3
							+ "</td></tr>";
				if (!cowInfo.getAblactOperator().equals(""))
					txt_q += "<tr><td>断奶操作员</td><td>"
							+ cowInfo.getAblactOperator() + "</td></tr>";
				if (!cowInfo.getFatherNO().equals(""))
					txt_q += "<tr><td>父号</td><td>"
							+ cowInfo.getFatherNO() + "</td></tr>";
				if (!cowInfo.getMotherNO().equals(""))
					txt_q += "<tr><td>母号</td><td>"
							+ cowInfo.getMotherNO() + "</td></tr>";

				if (!cowInfo.getMaFatherNO().equals(""))
					txt_q += "<tr><td>外祖父</td><td>"
							+ cowInfo.getMaFatherNO() + "</td></tr>";
				if (!cowInfo.getMaMotherNO().equals(""))
					txt_q += "<tr><td>外祖母</td><td>"
							+ cowInfo.getMaMotherNO() + "</td></tr>";


				if (!cowInfo.getVariety().equals(""))
					txt_q += "<tr><td>品种</td><td>"
							+ cowInfo.getVariety() + "</td></tr>";
				if (!cowInfo.getVarietyPurity().equals(""))
					txt_q += "<tr><td>品种纯度</td><td>"
							+ cowInfo.getVarietyPurity() + "</td></tr>";
							
				if (!cowInfo.getColor().equals(""))
					txt_q += "<tr><td>花色</td><td>" + cowInfo.getColor()
							+ "</td></tr>";
				if (!cowInfo.getGroCode().equals(""))
					txt_q += "<tr><td>泌乳状态</td><td>"
							+ cowInfo.getGroCode() + "</td></tr>";
				if (!cowInfo.getRepCode().equals(""))
					txt_q += "<tr><td>繁殖状态</td><td>"
							+ cowInfo.getRepCode() + "</td></tr>";
				dt01 = Services.GetDate(cowInfo.getFbDate());
				if (!dt01.equals("1-1-1"))
					txt_q += "<tr><td>初配日期</td><td>" + dt01
							+ "</td></tr>";
				if(cowInfo.isNomateSign()){
					txt_q += "<tr><td>禁配标识</td><td>是</td></tr>";
				}else{
					txt_q += "<tr><td>禁配标识</td><td>否</td></tr>";	
				}
				if (!cowInfo.getNomateReason().equals(""))
					txt_q += "<tr><td>禁配原因</td><td>"
							+ cowInfo.getNomateReason() + "</td></tr>";
				dt01 = Services.GetDate(cowInfo.getNomateDate());
				if (!dt01.equals("1-1-1"))
					txt_q += "<tr><td>禁配时间</td><td>" + dt01
							+ "</td></tr>";

				if (!cowInfo.getNomatePerson().equals(""))
					txt_q += "<tr><td>禁配操作人</td><td>"
							+ cowInfo.getNomatePerson() + "</td></tr>";
							
				String dt2 = Services.GetDate(cowInfo.getLeftDate());
				if (!dt2.equals("1-1-1"))
					txt_q += "<tr><td>离场 日期</td><td>" + dt2
							+ "</td></tr>";
				if (!cowInfo.getLeftWhere().equals(""))
					txt_q += "<tr><td>离场去向</td><td>"
							+ cowInfo.getLeftWhere() + "</td></tr>";
				if (!cowInfo.getLeftReason().equals(""))
					txt_q += "<tr><td>离场 原因</td><td>"
							+ cowInfo.getLeftReason() + "</td></tr>";
				if (!cowInfo.getLeftPerson().equals(""))
					txt_q += "<tr><td>离场 操作人</td><td>"
							+ cowInfo.getLeftPerson() + "</td></tr>";
				txt_q += "</table>";
				logger.debug(txt_q);
				
				
	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}

	}
//	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width" />
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
<script src="PlugIn/jQuery/jquery-1.11.1.js" type="text/javascript"></script>
<script
	src="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile-1.4.3.min.js"
	type="text/javascript"></script>
<title>牛只查询</title>
<style>
td{
border:1px solid gray;
}
th{
border:1px solid gray;
}

.search{
background:url(images/bbg.jpg) repeat top center;
}
*{
 text-shadow: none !important;
}

#content{
   padding:2%;
   
}

thead th{height:30px;}

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

	<%=txt%>
	<%=txt_q%>
	
	</div>
</body>
</html>