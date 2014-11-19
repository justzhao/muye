<%@ page language="java"  import="java.util.*,java.sql.*,db.Connect,org.apache.logging.log4j.*" 
    pageEncoding="UTF-8"%>
<%
Logger logger = LogManager.getLogger(request.getRequestURI());  

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String x1=request.getParameter("x1");
String y1=request.getParameter("y1");
Connection conn;
ResultSet rsL1,rsL2;
Statement statementL1,statementL2;
String SSQL;
conn = Connect.connect();
statementL1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
statementL2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
SSQL="select count(*) cnt from [T_DATA_MENU] where [ID_PARENT]=0";
logger.debug(SSQL);
rsL1 = statementL1.executeQuery(SSQL);
int MenuL1Count=0;
if(rsL1.next()){
	MenuL1Count=rsL1.getInt("cnt");
}
rsL1.close();
SSQL="select * from [T_SYS_LocalTax_Address] order by power(power(lng-"+x1+",2)+power(lat-"+y1+",2),0.50000000000)";
logger.debug(SSQL);
rsL1 = statementL1.executeQuery(SSQL);

String txt="<h1>按距离排序</h1><table data-role=\"table\" id=\"table-custom-2\" class=\"ui-body-d ui-shadow table-stripe ui-responsive\">"
	+"<thead><tr class=\"ui-bar-d\">"
	+"<td data-priority=\"1\">部门</td><td data-priority=\"2\">地址</td><td data-priority=\"3\">操作</td></tr></thead>";
while(rsL1.next()){
	String x2=rsL1.getString("Lng");
	String y2=rsL1.getString("Lat");
	txt+="<tr>"
			+"<td>"
			+ rsL1.getString("Depart")			
			+"</td>"
			+"<td>"
			+ rsL1.getString("Address")			
			+"</td>"
			+"<td><a target=\"_self\" href=\"http://aocheng-sc.xicp.net/weixin/fuwu_mapway.jsp?x1="
					+ x1 + "&y1="+ y1 + "&x2=" + x2 + "&y2=" + y2 +"\">去这里</a>"
			+"</td>"
			+"</tr>";
}
txt+="</table>";
logger.debug(txt);
rsL1.close();
statementL1.close();
conn.close();
%>	

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

<link href="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile.theme-1.4.3.css" rel="stylesheet" type="text/css"/>
<link href="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile.structure-1.4.3.min.css" rel="stylesheet" type="text/css"/>
<link href="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile-1.4.3.min.css" rel="stylesheet" type="text/css"/>
<script src="PlugIn/jQuery/jquery-1.11.1.js" type="text/javascript"></script>
<script src="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile-1.4.3.min.js" type="text/javascript"></script>
    
    <title>地址列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%=txt %><br>
  </body>
</html>
