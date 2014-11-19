<%@ page language="java"  import="java.util.*,java.sql.*,db.Connect,org.apache.logging.log4j.*" 
    pageEncoding="UTF-8"%>
<%
Logger logger = LogManager.getLogger(request.getRequestURI());  

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String nID= request.getParameter("id");


Connection conn;
ResultSet rsL1;
Statement statementL1;
String SSQL;
conn = Connect.connect();
statementL1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
SSQL="select Q,A,CONVERT(VARCHAR,DT,102) DT from [T_DATA_12366_HOT] where id=" + nID;
logger.debug(SSQL);
rsL1 = statementL1.executeQuery(SSQL);
String txt="";
if(rsL1.next()){
	txt+="<table data-role=\"table\" id=\"table-custom-2\" class=\"ui-body-d ui-shadow table-stripe ui-responsive\"> "
		+"<thead><tr><td ><a onclick=\"history.back();\">返回列表</a></td></tr></thead>"
		+"<tr><td>"+ rsL1.getString("Q") +"</td></tr>"
		+"<tr><td>"+ rsL1.getString("DT") +"</td></tr>"
		+"<tr><td>"+ rsL1.getString("A") +"</td></tr>"
		+"</table>";
}
logger.debug(txt);
rsL1.close();
statementL1.close();
conn.close();
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile.theme-1.4.3.css" rel="stylesheet" type="text/css"/>
<link href="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile.structure-1.4.3.min.css" rel="stylesheet" type="text/css"/>
<link href="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile-1.4.3.min.css" rel="stylesheet" type="text/css"/>
<script src="PlugIn/jQuery/jquery-1.11.1.js" type="text/javascript"></script>
<script src="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile-1.4.3.min.js" type="text/javascript"></script>
<title>12366咨询</title>
<style>
	td
	{font-size:36px;border:2px solid black;}
	</style>
</head>
<body>

<%=txt %>
</body>
</html>