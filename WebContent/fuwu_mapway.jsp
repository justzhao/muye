<%@ page language="java"  import="java.util.*,java.sql.*,db.Connect,org.apache.logging.log4j.*" 
    pageEncoding="UTF-8"%>
<%
Logger logger = LogManager.getLogger(request.getRequestURI());  


String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String x1=request.getParameter("x1");
String y1=request.getParameter("y1");
String x2=request.getParameter("x2");
String y2=request.getParameter("y2");
logger.debug("x1: "+x1+";y1: "+y1+";x2: "+x2+";y2: "+y2);

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>路径</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="路线">
	 <script type="text/javascript" src="http://api.map.baidu.com/api?type=quick&ak=WY0LNZXMqTGG5dCw8TE1cp3o&v=1.0"></script>
<style type="text/css">
body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;} @media (max-device-width: 780px){#golist{display: block!important;}}#golist {display: none;}
</style>

  </head>
  
  <body>
<div id="allmap"></div>
  </body>
</html>
<script type="text/javascript">
	var   flag=""; 
    function   sleepI(n)   
    {   
          flag   =   window.setInterval("c()",1000*n);     
    }   

var map = new BMap.Map("allmap");
map.centerAndZoom("成都", 15);
map.addControl(new BMap.ZoomControl());          //添加地图缩放控件
sleepI(2);
var routeSearch=new BMap.RouteSearch();  
var start = {  
      latlng:new BMap.Point(<%=x1  %>, <%=y1 %>),  
      name:"当前位置"  
  }  
var end = {  
     latlng:new BMap.Point(<%=x2  %>, <%=y2 %>),  
     name:"地税"  
  }  
var opts = {  
     mode:BMAP_MODE_DRIVING,//公交、驾车、导航均修改该参数  
     region:"成都"  
  }  
var ss = new BMap.RouteSearch();  
routeSearch.routeCall(start,end,opts);

</script>
