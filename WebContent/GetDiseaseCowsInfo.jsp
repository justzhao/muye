
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
	int pageSize=20;
	if(openID!=null){
		if(Services.CheckBind(openID).equals("")){
			
				response.sendRedirect("MIS_Bind.jsp?OpenID="+openID);
				return;
		}
	}else{
	response.sendRedirect("NotWeixin.jsp");
	return;
	}

	
	List<String> farmlist=Services.getAllFarmInfo();
	String txt = "", dt = "",txt_form="";
	
	
	if(BllManager.getSendTag("4").indexOf(openID)<0)
	{
		response.sendRedirect("NotPermission.jsp");
		return;
	}
	 txt_form = "<form id=form1 action=\"\" method=\"post\" target=\"_self\">";
	txt_form += "<label for=\"cowID\">牧场名字</label>";
	// txt_form+="<input id=\"farmName\" name=\"farmName\" type=\"text\" />";
	
	txt_form+="<select id=\"farmName\" name=\"farmName\" > ";
	int flag=0;
	   for(String s:farmlist){
		   if(flag==0)
		   {
			   txt_form+="<option selected>"+s+"</option>";
		   }else
		   {
			   txt_form+="<option >"+s+"</option>"; 
		   }
		   
		   flag++;
		   
		   
	   }
		

     txt_form+=	 " </select>";		
			
    txt_form += "<button  class=\"search\" style=\"background-color:;\" onclick=\"form1.submit();\" ><div style=\"color:white;\">查询</div></button>";
			
	txt_form += "</form>";

	String ChartX = "", ChartData = "", ChartData1 = "", ChartData2 = "";


	String farmName = request.getParameter("farmName");
	List<Cow> cowList=new ArrayList();
	JSONArray jsonArray = new JSONArray();
	
	if(farmName!=null)
	{
		currtPage="1";
	
		cowList=Services.getDiseaseInfos(farmName);
		rows=String.valueOf(cowList.size());
		if(cowList.size()%pageSize==0){
			pageCount=String.valueOf(cowList.size()/pageSize);
		}else{
		pageCount=String.valueOf(cowList.size()/pageSize+1);
		}
		// 转json
		
		
		for(Cow c:cowList)
		{
			JSONObject jo=new JSONObject();
			jo.put("CowID", c.getCowID());
			jo.put("OnsetDate", c.getOnsetDate());
			jo.put("OnsetDays", c.getOnsetDays());
			jo.put("DiseaseTypes", c.getDiseaseTypes());
			jo.put("DiseaseName", c.getDiseaseName());
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
<title>牧场疾病牛查询</title>
<style>

*{
 text-shadow: none !important;
}
td{
border:1px solid gray;

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
			<%=  (farmName == null ? "":farmName)%>
			牧场的疾病存栏信息：<%= rows%>头牛</span></th></tr>
			<tr class="ui-bar-d">
			<th>牛号</th><th>发病日期</th><th>发病天数</th><th>疾病类型</th><th>疾病名称</th>
			 </tr>
			<% 
			  int i=1;
			for(Cow c:cowList) {
			  if(i<=20){	
				
				%>
			

	       <tr>
	       <td><%= c.getCowID()%></td>
	        <td><%=c.getOnsetDate()%></td>
	         <td><%=c.getOnsetDays()%> </td>
	          <td><%=c.getDiseaseTypes()%> </td>
	           <td><%=c.getDiseaseName()%> </td>
	    
	      
	       </tr>
	
	<%
	      i++;
			  }else{
		break;
	}
			  
			  } %>
	
	</table>
	</div>	
</div>	
		
		
			
<% if(farmName!=null){ %>	
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
var pageSize=20;

var infolist=new Array();
infolist=<%=jsonArray%>;

var pageCount=parseInt(infolist.length/pageSize)+1;


	
	
	
	
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
   
	
   var curows=(curPage-1)*pageSize;
   var i=2;

			for(;curows<curPage*pageSize&&curows<infolist.length;curows++)
			{
				 var tr=trlist[i];
				 
				 if(tr==null)
					 {
					tr= addNode(trlist[i-1].parentNode);
					 }
				 
				 
				  var tdlist=tr.getElementsByTagName('TD');
				  
			
				 tdlist[0].innerHTML=infolist[curows].CowID;	
				 tdlist[1].innerHTML=infolist[curows].OnsetDate;	
				 tdlist[2].innerHTML=infolist[curows].OnsetDays;	
				 tdlist[3].innerHTML=infolist[curows].DiseaseTypes;	
				 tdlist[4].innerHTML=infolist[curows].DiseaseName;	
				 i++;
			}
			
			 var trlength=trlist.length;
			if(curows>=infolist.length)
				{
				   var temp=i;
				
				  for(;temp<trlength;temp++)
					  {
					  
			           //  alert("the i is "+i+"the length is "+trlength+"the node is "+trlist[i].innerHTML );
                        delNode(trlist[i]);   					  
					  }
				}
			
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
