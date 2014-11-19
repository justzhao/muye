<%@ page language="java"  import="java.util.*,java.sql.*,db.Connect,org.apache.logging.log4j.*" 
    pageEncoding="UTF-8"%>
<%
Logger logger = LogManager.getLogger(request.getRequestURI());  

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String nPage= request.getParameter("curPage");
int curPg=(nPage==null ? 1:Integer.parseInt(request.getParameter("curPage")));

int cntPerPage=10;
int idBegin,idEnd;
int cntPage=0;
Connection conn;
ResultSet rsL1,rsL2;
Statement statementL1,statementL2;
String SSQL;
conn = Connect.connect();
statementL1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
statementL2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

SSQL="select count(*) cnt from [T_DATA_12366_HOT]";
logger.debug(SSQL);
rsL1 = statementL1.executeQuery(SSQL);
int MenuL1Count=0;
if(rsL1.next()){
	MenuL1Count=rsL1.getInt("cnt");
}
cntPage  =MenuL1Count / cntPerPage ;
if(MenuL1Count % cntPerPage !=0){
	cntPage++;	
}
idBegin=(curPg-1)*cntPerPage+1;
idEnd=curPg*cntPerPage;



rsL1.close();
SSQL="select * from (select row_number()over(order by [dt] desc )as RowNum,ID,Q,A,CONVERT(VARCHAR,DT,102) DT from [T_DATA_12366_HOT]) a where RowNum between "+ idBegin+" and "+ idEnd;
logger.debug(SSQL);
rsL1 = statementL1.executeQuery(SSQL);
String txt="<table data-role=\"table\" id=\"table-custom-2\" class=\"ui-body-d ui-shadow table-stripe ui-responsive\" >"
	+"<thead><tr class=\"ui-bar-d\">"
	+"<td data-priority=\"1\">问题</td><td data-priority=\"2\" style=\"width:200px;\">日期</td></tr></thead>";
while(rsL1.next()){
	txt+="<tr>"
			+"<td><a target=\"_self\" href=\"12366Detail.jsp?id="+ rsL1.getString("id") +"\">"
			+ rsL1.getString("Q")			
			+"</a></td>"
			+"<td>"
			+ rsL1.getString("dt")			
			+"</td>"
			+"</tr>";
}
txt+="<tr>"
		+"<td colspan=2><a target=\"_self\" href=\"12366HotList.jsp?curPage="+ (curPg-1) +"\">上一頁</a>"
		+"<a target=\"_self\" href=\"12366HotList.jsp?curPage="+ (curPg+1) +"\">下一頁</a></td>"
		+"</tr>";
txt+="</table>";
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
<title>12366热点问题</title>
<style>
	td
	{font-size:36px;}
	
	</style>
</head>
<body>
<%=txt %>
</body>
</html>