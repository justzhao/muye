
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="bean.Cow.Cow"%>
<%@page import="com.menu.manager.BllManager"%>
<%@ page language="java"
	import="java.util.*,java.net.URLEncoder,net.sf.json.*,java.sql.*,db.Connect,org.apache.logging.log4j.*,cn.modernfarming.weixin.*,cn.modernfarming.mis.*,java.util.Date"
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
	String rows="0";
	int pageSize=1;
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




	String cowID = request.getParameter("cowID");
	List<Cow> cowList=new ArrayList();
	JSONArray jsonArray = new JSONArray();
	
	if(cowID!=null)
	{
		currtPage="1";
	
		cowList=Services.getMilksInfos(cowID);// (cowID);
		rows=String.valueOf(cowList.size());
	//	logger.debug("the size is "+rows);
	
		if(cowList.size()%pageSize==0){
			pageCount=String.valueOf(cowList.size()/pageSize);
		}else{
		pageCount=String.valueOf(cowList.size()/pageSize+1);
		}
		
		// 转json
		
		
		for(Cow c:cowList)
		{
			JSONObject jo=new JSONObject();
			jo.put("FarmName", c.getFarmName());
			jo.put("TestDate", c.getTestDate());
			jo.put("CowBarn", c.getCowBarn());
			jo.put("ChildBirthDate", c.getChildBirthDate());
			jo.put("ChildTime", c.getChildTime());
			jo.put("BreedStatus", c.getBreedStatus());
			jo.put("MilkStatus", c.getMilkStatus());
			jo.put("LastDryMikeDate", c.getLastDryMikeDate()!=null?c.getLastDryMikeDate():"");
			jo.put("MilkDays", c.getMilkDays());
			jo.put("TotalMilks", c.getTotalMilks());
			jo.put("FirstMilks", c.getFirstMilks());
			jo.put("SecondMilks", c.getSecondMilks());
			jo.put("ThirdMilks", c.getThirdMilks());
			jo.put("Operator", c.getOperator());
			
			jsonArray.add(jo);
		}

	
	}
	



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

<div>
<table width="100%" id="table-custom-2" data-mode="columntoggle" class="ui-body-d ui-shadow table-stripe ui-responsive\" data-column-btn-theme=\"b\" data-column-btn-text=\"选择要查看的列\" data-column-popup-theme=\"a\"><tr><th colspan="25" > <span class="STYLE7">
			<%=  (cowID == null ? "":cowID)%>
			产奶信息</span></th></tr>
			<tr class="ui-bar-d">
			<th width="30%">栏目</th><th width="70%">数据</th>
			 </tr>
			<% 
			  int i=1;
			for(Cow c:cowList) {
			  if(i<=pageSize){	
				
				%>

	         <tr> <td> 牧场</td> <td>  <%=c.getFarmName() %></td>      </tr>
	          <tr>  <td>测试日期</td>  <td><%=c.getTestDate() %></td></tr>
	          <tr> <td> 牛舍</td> <td><%=c.getCowBarn()%> </td></tr>
	          <tr> <td>分娩日期 </td><td><%=c.getChildBirthDate()%> </td></tr>
	          <tr><td>胎次</td><td><%=c.getChildTime()%> </td> </tr>
	           <tr> <td>繁殖状态</td> <td><%=c.getBreedStatus()%> </td></tr>
	            <tr> <td>泌乳状态</td> <td><%=c.getMilkStatus()%> </td></tr>
	            <tr> <td>最后干奶日期</td> <td><%=c.getLastDryMikeDate()!=null?c.getLastDryMikeDate():""%> </td></tr>
	             <tr> <td>泌乳天数</td> <td><%=c.getMilkDays()%> </td></tr>
	              <tr> <td>总奶量</td> <td><%=c.getTotalMilks()%> </td></tr>
	               <tr> <td>一测奶量</td> <td><%=c.getFirstMilks()%> </td></tr>
	                <tr> <td>二测奶量</td> <td><%=c.getSecondMilks()%> </td></tr>
	            <tr> <td> 三测奶量</td><td><%=c.getThirdMilks()%> </td></tr>
	            <tr> <td>操作员 </td><td><%=c.getOperator()%> </td></tr>
	    	    
	
	<%
	      i++;
			  }else{
		break;
	}
			  
			  } %>
	
	</table>
	</div>	
		
	</div>	
		
		
			
<% if(cowID!=null){ %>	
		<div>
		 <div style=" margin-top:12px; width:100%;text-align:center">
		
		
		 <a class="fpage" onclick="firstPage();" style="text-decoration:none;" href = "javascript:void(0); "><span style="font-size:16px;color:white" > 首页</span></a>


		<a id="pre" class="page" onclick="prePage();"style="text-decoration:none;display:none" href ="javascript:void(0); " ><span style="font-size:16px;color:white" >上一页</span></a>

<% 
	if(Integer.parseInt(currtPage)<Integer.parseInt(pageCount)){
 %>
	<a  id="next" class="page" onclick="nextPage();" style="text-decoration:none;" href ="javascript:void(0);" ><span style="font-size:16px;color:white" >下一页</span></a>
<%} else{%>	
	
	<a id="next" class="page" onclick="nextPage();" style="text-decoration:none;display:none" href ="javascript:void(0);" ><span style="font-size:16px;color:white" >下一页</span></a>
	<%} %>
	<a  class="page" onclick="lastPage();" style="text-decoration:none;" href ="javascript:void(0); " ><span style="font-size:16px;color:white" > 尾页</span></a></div>
		
		
		
		
	
		  
		  <div style=" margin-top:12px; text-align:center">
		  
		  <span style="font-size:14px;color:black" >  第 <span id="nowpage"><%=currtPage%></span>页/共<%=pageCount%>页</span>
		  
		  </div>
		  
		  
		  
		  
		  </div>
		
	<%} %>	
		
		
	
	</body>
<script type="text/javascript">

var curt=1;
var pageSize=1;

var infolist=new Array();
infolist=<%=jsonArray%>;

if(infolist.length%pageSize!=0){
var pageCount=parseInt(infolist.length/pageSize)+1;
}else
	{
	var pageCount=parseInt(infolist.length/pageSize);
	}

	
	
	
	
function firstPage()
{
	
    curt=1;
	showData(curt);
	
}

function prePage()
{
	if(curt>1)
		{

		
		curt--;
		 showData(curt);
		}

}
function nextPage()
{
	
	
	
	if(curt<pageCount){
		curt++;
		showData(curt);
	}
}
function lastPage()
{
	curt=pageCount;

  showData(curt);	
}
function showData(curPage)
{
	 
	   var curows=(curPage-1)*pageSize;
	if(curPage>1)
		{
		document.getElementById('pre').style.display="";
		}else{
			document.getElementById('pre').style.display="none";	
		}
	if(curPage<pageCount)
		{
		document.getElementById('next').style.display="";
		}else
			{
			document.getElementById('next').style.display="none";
			}
	
	
	
	var table=document.getElementById('table-custom-2');
    

	
	var trlist=table.getElementsByTagName('TR');//22
	
	
	var tdlist=trlist[2].getElementsByTagName('TD');
	tdlist[1].innerHTML=infolist[curows].FarmName;

	

	
	var tdlist=trlist[3].getElementsByTagName('TD');
	tdlist[1].innerHTML=infolist[curows].TestDate;
	
	var tdlist=trlist[4].getElementsByTagName('TD');
	tdlist[1].innerHTML=infolist[curows].CowBarn;
	
	var tdlist=trlist[5].getElementsByTagName('TD');
	tdlist[1].innerHTML=infolist[curows].ChildBirthDate;
	
	var tdlist=trlist[6].getElementsByTagName('TD');
	tdlist[1].innerHTML=infolist[curows].ChildTime;
	
    tdlist=trlist[7].getElementsByTagName('TD');
	tdlist[1].innerHTML=infolist[curows].BreedStatus;
	
	tdlist=trlist[8].getElementsByTagName('TD');
	tdlist[1].innerHTML=infolist[curows].MilkStatus;
		
	tdlist=trlist[9].getElementsByTagName('TD');
	tdlist[1].innerHTML=infolist[curows].LastDryMikeDate;
			
	tdlist=trlist[10].getElementsByTagName('TD');
	tdlist[1].innerHTML=infolist[curows].MilkDays;
				
	tdlist=trlist[11].getElementsByTagName('TD');
	tdlist[1].innerHTML=infolist[curows].TotalMilks;
					
	tdlist=trlist[12].getElementsByTagName('TD');
	tdlist[1].innerHTML=infolist[curows].FirstMilks;
						
	tdlist=trlist[13].getElementsByTagName('TD');
	tdlist[1].innerHTML=infolist[curows].SecondMilks;
							
	tdlist=trlist[14].getElementsByTagName('TD');
	tdlist[1].innerHTML=infolist[curows].ThirdMilks;
								
	tdlist=trlist[15].getElementsByTagName('TD');
	tdlist[1].innerHTML=infolist[curows].Operator;
	
   document.getElementById('nowpage').innerHTML =curt;
}
function delNode(node)

{
	if(node!=null)
{
	node.parentNode.removeChild(node); 
}
}
function addNode(node)
{

    var tr = document.createElement("tr");
    node.appendChild(tr);
    
    
    for(var i=0;i<5;i++){
    var td = document.createElement("td");
    tr.appendChild(td);

    }
    
    
    return tr;
}

</script>
</html>
