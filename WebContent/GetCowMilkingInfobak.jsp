
<%@page import="com.menu.manager.BllManager"%>
<%@ page language="java"
	import="java.util.*,java.net.URLEncoder,java.sql.*,db.Connect,org.apache.logging.log4j.*,cn.modernfarming.weixin.*,cn.modernfarming.mis.*,java.util.Date"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");  
response.setCharacterEncoding("utf-8"); 
	Logger logger = LogManager.getLogger(request.getRequestURI());

    //更新查询种类，牛只，疾病，繁殖
	
	
    
    HttpSession mySession=request.getSession();
    
    
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String openID=request.getParameter("OpenID");
	String pageCount=request.getParameter("pageCount");
	String currtPage=request.getParameter("currtPage");
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
	// txt_form+="<input id=\"farmName\" name=\"farmName\" type=\"text\" />";
	txt_form += "<button class=\"search\"; onclick=\"form1.submit();\" ><div style=\"color:white;\">查询</div></button>";
	
		
	txt_form += "</form>";

	String ChartX = "", ChartData = "", ChartData1 = "", ChartData2 = "";


	String cowID = request.getParameter("cowID");
	
//	logger.debug(" the first farmName is "+farmName);
	if(cowID !=null)
	{
		//post过来的重新设置session
		
		mySession.setAttribute("MilkcowID", cowID);
	}else{
		//post过来的 session里面应该有值
		if(mySession.getAttribute("MilkcowID")!=null)
		{
			cowID=mySession.getAttribute("MilkcowID").toString();
		}
			
	}
	
	/**
	if(currtPage!=null)
	{
		
		farmName=new  String(farmName.getBytes("ISO-8859-1"),"utf-8");
		logger.debug("the name is "+farmName);
	}
*/
	txt += "<div><table width=\"100%\" id=\"table-custom-2\" data-mode=\"columntoggle\" class=\"ui-body-d ui-shadow table-stripe ui-responsive\" data-column-btn-theme=\"b\" data-column-btn-text=\"选择要查看的列\" data-column-popup-theme=\"a\"><tr><th colspan=\"25\" > <span class=\"STYLE7\">"
			+ (cowID == null ? "":cowID)
			+ "的产奶信息</span></th></tr><tr class=\"ui-bar-d\">"
			+"<th width=\"30%\">栏目</th><th width=\"70%\">数据</th></tr>";
		    
	
	if (cowID != null) {
        if(pageCount==null){
        	pageCount=Services.getMilkInfoCount(cowID);// (cowID);
        	//pageCount=String.valueOf(Integer.parseInt(pageCount)/20+1);
        	
        }
        //logger.debug("the pagecount is "+pageCount);
        if(currtPage==null){
        	currtPage="1";
        }
        
 
		
		txt += Services.getMilkInfoHtml(cowID, currtPage);// (cowID,currtPage);
         
		}
	txt += "</table></div>";
	
	
	if(cowID!=null)
	{

    		
	txt +="<div> <div style=\"margin-top:12px;width:100%;text-align:center\">";
   // txt+=" <a class=\"page\" style=\"text-decoration:none;\" href = \"GetCowMilkingInfo.jsp?currtPage=1&OpenID="+openID+" \"> <span style=\"font-size:16px;color:white\" >首页</span></a>";
    txt+=" <a class=\"fpage\" style=\"text-decoration:none;margin-left:0px;\" href = \"GetCowMilkingInfo.jsp?currtPage=1&OpenID="+openID+" \"> <span style=\"font-size:16px;color:white\" >首页 </span></a>";
	if(Integer.parseInt(currtPage)>1){
	txt+=" <a class=\"page\" style=\"text-decoration:none;\" href = \"GetCowMilkingInfo.jsp?currtPage="+String.valueOf(Integer.parseInt(currtPage)-1)+"&OpenID="+openID+" \" > <span style=\"font-size:16px;color:white\" >上一页 </span></a> ";
	}
	if(Integer.parseInt(currtPage)<Integer.parseInt(pageCount)){
		
		
	txt+=" <a class=\"page\"  text-decoration:none;\" href = \"GetCowMilkingInfo.jsp?currtPage="+  String.valueOf(Integer.parseInt(currtPage)+1)+"&OpenID="+openID+" \" > <span style=\"font-size:16px;color:white\" >下一页</span></a>";

	}
	txt+="<a class=\"page\" style=\"text-decoration:none;\" href =\"GetCowMilkingInfo.jsp?currtPage="+pageCount+"&OpenID="+openID+" \" >  <span style=\"font-size:16px;color:white\" >尾页</span></a></div>";

	txt+="<div style=\"margin-top:12px;text-align:center\"> <span style=\"font-size:14px;color:black\" >  第"+ currtPage+"页/共"+pageCount+"页   </span> </div></div>";
	


	}

	
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
<title>产奶量查询</title>
<style>

*{
 text-shadow: none !important;
}
td{
border:1px solid gray;
font-size:11px;
}
th{
border:1px solid gray;
font-size:11px;
  background-color: -moz-win-communicationstext;
}
.search{
background:url(images/bbg.jpg) repeat top center;
}

.page{
 background:url(images/bbg.jpg) repeat top center;

 
 height: 20px; 
 padding:13px; 
 text-decoration: none;
 
 margin-left: 10px;
 font-size:16px;
}

.fpage{
 background:url(images/bbg.jpg) repeat top center;

 
 height: 20px; 
 padding:13px; 
 text-decoration: none;
 

 font-size:16px;
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
