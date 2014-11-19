<%@page import="com.menu.manager.BllManager"%>
<%@ page language="java"
	import="java.util.*,java.sql.*,db.Connect,org.apache.logging.log4j.*,cn.modernfarming.weixin.*"
	pageEncoding="UTF-8"%>
<style type="text/css">
<!--
body { margin:0; }
.STYLE5 {
	font-family: "微软雅黑";
	font-size: 14px;
}
.STYLE6 {font-size: 14px}
-->
</style>
<%
	Logger logger = LogManager.getLogger(request.getRequestURI());

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//OpenID  是用户的id
	String openID = request.getParameter("OpenID");
	logger.debug("openID:" + openID);
	String txt = "";
	if (openID == null) {
		txt = "<div data-role=\"head\">没有获取到您的微信信息，请通过微信访问。</div>";
	} else {
		String sLoginName = Services.CheckBind(openID);
		String txt1 = "<form id=form1 method=\"post\" target=\"_self\" action=\"\">";
		txt1+= "<table width=\"320\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">"
		            +"<tr><td>"
				    //+"<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"
		            //+"<tr><td><img src=\"images/top.jpg\" width=\"320\" height=\"45\"></td></tr></table>"
					+"<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">"
					+"<tr><td><img src=\"images/t.jpg\" width=\"320\" height=\"23\"></td></tr>"
					+"<tr><td align=\"center\" style=\"background:url(images/m.jpg) repeat-y top center\">"
					+"<table width=\"86%\" height=\"400\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">";
				
				if(sLoginName.equals("")){
					//绑定
				txt1+="<tr><td height=\"73\" valign=\"top\"><span class=\"STYLE5\">您还没绑定工号，请输入用户名和密码进行绑定！</span></td></tr>";
				txt1+="<tr><td><table width=\"264\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"margin-bottom:10px\"><tr><td height=\"25\"><span class=\"STYLE6\">用户名</span></td></tr>";
				txt1+="<tr><td align=\"center\" style=\"background:url(images/iin.jpg) repeat top center; line-height:37px; height:37px\"><input style=\"width:250px; line-height:28px; height:28px; margin-top:3px; background:none; border:0\" type=text id=\"LoginName\" name=\"LoginName\" /></td></tr><tr><td><input type=hidden  id=\"Opt\" name=\"Opt\" value=0 /></td></tr></table></td></tr>";
      			txt1+="<tr><td><table width=\"264\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"margin-bottom:20px\"><tr><td height=\"25\"><span class=\"STYLE6\">密&nbsp;&nbsp;&nbsp;&nbsp;码</span></td></tr><tr><td align=\"center\" style=\"background:url(images/iin.jpg) repeat top center; line-height:37px; height:37px\"><input style=\"width:250px; line-height:28px; height:28px; margin-top:3px; background:none; border:0\" type=password id=\"Password\" name=\"Password\" /></td></tr></table></td></tr>";
				     
				}else{
				
				txt1+="<tr><td height=\"48\" valign=\"top\"><span class=\"STYLE5\">您已绑定工号:"+sLoginName+"<input type=hidden  id=\"Opt\" name=\"Opt\" value=1 /> <input type=hidden id=\"LoginName\" name=\"LoginName\" value="+sLoginName+" />。</span></td></tr>";
      				
				
				}
				
				//txt1=txt1+ "<fieldset data-role=\"controlgroup\" data-type=\"horizontal\" data-mini=\"true\"><legend>操作类型</legend><input type=radio  id=\"Opt1\" name=\"Opt\" value=0 checked /><label for=\"Opt1\" >绑定</label><input type=radio  id=\"Opt2\" name=\"Opt\" value=1 /><label for=\"Opt2\" >解绑</label></fieldset>"
				txt1=txt1+ "<tr><td><input name=\"button\" type=submit  class=\"an\" ";
				if(sLoginName.equals("")){
					txt1=txt1+"onclick=\"form1.submit();\"value=\"绑 定\"/></td></tr><tr><td height=\"50\">&nbsp;</td></tr></table></td></tr>";	
				}else{
			    	txt1=txt1+"onclick=\"return unBind()\" value=\"解 绑\"/></td></tr><tr><td height=\"230\">&nbsp;</td></tr>"
			    	//+"<tr><td><img src=\"images/b.jpg\" width=\"320\" height=\"26\"></td></tr>"
			    	+"</table></td></tr>";
				}
				txt1+="<tr><td><img src=\"images/b.jpg\" width=\"320\" height=\"26\"></td></tr></table>";
		
				/**
				
		if (!sLoginName.equals("")) {
			txt = "<div data-role=\"head\"><span class=\"STYLE5\">您已绑定工号:" + sLoginName
					+ "。</span></div>";
		}else{
			txt = "<div data-role=\"head\"><span class=\"STYLE5\">您还没绑定工号。请输入用户名和密码进行绑定！</span></div>";			
		}*/
		String loginName = request.getParameter("LoginName");
		String password = request.getParameter("Password");
		String Opt = request.getParameter("Opt");
        String Action=request.getParameter("submit");
       // logger.debug("the action is "+Action);
		//opt 代表是解绑还是绑定
		if(Opt!=null)
		{
		
		if (Opt.equals("0")) {
			
			
			Boolean b = Services.CheckUser(loginName, password);
			
			if (b) {
				
				Boolean bb = Services.BindUser(openID, loginName,
							password);
					if (bb) {
						txt = "<div data-role=\"head\">绑定成功！</div>";
						//在这里打上标签 ，先根据用户名和密码获得角色，有多个角色，所以要对同一个人打多个标签
						BllManager.addTagUser(loginName, password, openID);
						response.sendRedirect("MIS_Bind.jsp?OpenID="+openID);
						
					} else {
						txt = "<div data-role=\"head\">绑定失败 ！</div>";
					}
			}else{	
				txt = "<div data-role=\"head\">登录名/口令校验失败 ！</div>";
			}
					
					
					
         } else if (Opt.equals("1")) 
         {
					Boolean bb = Services.UnBindUser(openID, loginName,
							password);
					if (bb) {
						txt = "<div data-role=\"head\">解除绑定成功！</div>";
						
						response.sendRedirect("MIS_Bind_bk.jsp?OpenID="+openID);
					} else {
						txt = "<div data-role=\"head\">解除绑定失败 ！</div>";
					}
				
		 }
		
		
		
		
		}
		
		

		
		/**
		if (loginName != null) {
			Boolean b = Services.CheckUser(loginName, password);
			if (b) {
				if (Opt.equals("0")) {
					Boolean bb = Services.BindUser(openID, loginName,
							password);
					if (bb) {
						txt = "<div data-role=\"head\">绑定成功！</div>";
						//在这里打上标签 ，先根据用户名和密码获得角色，有多个角色，所以要对同一个人打多个标签
						
					

						BllManager.addTagUser(loginName, password, openID);
						response.sendRedirect("MIS_Bind.jsp?OpenID="+openID);
						
					} else {
						txt = "<div data-role=\"head\">绑定失败 ！</div>";
					}
				} else if (Opt.equals("1")) {
					Boolean bb = Services.UnBindUser(openID, loginName,
							password);
					if (bb) {
						txt = "<div data-role=\"head\">解除绑定成功！</div>";
					} else {
						txt = "<div data-role=\"head\">解除绑定失败 ！</div>";
					}
					response.sendRedirect("MIS_Bind.jsp?OpenID="+openID);
				}
			} else {
				txt = "<div data-role=\"head\">登录名/口令校验失败 ！</div>";

			}
		}
		*/
		logger.debug("loginName:" + loginName);
		logger.debug("password:" + password);
		logger.debug("txt1:" + txt1);

		txt += txt1;
		
		
		
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/mystyle.css" rel="stylesheet" type="text/css" />

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
<!--  
<script
	src="PlugIn/jQuery/jquery.mobile-1.4.3/jquery.mobile-1.4.3.min.js"
	type="text/javascript"></script>-->
<title>工号绑定</title>
<style>
td {/**
	font-size: 36px;
	border: 2px solid black;*/
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

function unBind()
{
	if(window.confirm("确定解绑?"))
		{
		 // $("form1").submit();
		// alert("YES");
		 
		 return true;
		
		}else
		{
			//alert("NO");
			return false;
		}
	
}
</script>
</head>
<body>

	<%=txt%>
</body>
<script type=text/javascript>
var lastThirdElemnet;
function changeSubStyle(obj)
{
    var objSubChild = obj.parentNode.getElementsByTagName("ul")[0];
    
    var isDisplay = objSubChild.style.display=="none";
    
    objSubChild.style.display = isDisplay?"block":"none";
    if(lastThirdElemnet!=null)
    {
        lastThirdElemnet.style.display = "none";
        lastThirdElemnet = null;
    }
    if(isDisplay)
    {
         lastThirdElemnet = objSubChild; 
    }
   
   
}
var LastLeftID = "";
function menuFix() {
var obj = document.getElementById("nav").getElementsByTagName("li");

for (var i=0; i<obj.length; i++) {
  obj[i].onmouseover=function() {
   this.className+=(this.className.length>0? " ": "") + "sfhover";
  }
  obj[i].onMouseDown=function() {
   this.className+=(this.className.length>0? " ": "") + "sfhover";
  }
  obj[i].onMouseUp=function() {
   this.className+=(this.className.length>0? " ": "") + "sfhover";
  }
  obj[i].onmouseout=function() {
   this.className=this.className.replace(new RegExp("( ?|^)sfhover\\b"), "");
  }
}
}
function DoMenu(emid)
{

var obj = document.getElementById(emid); 
obj.className = (obj.className.toLowerCase() == "expanded"?"collapsed":"expanded");
if((LastLeftID!="")&&(emid!=LastLeftID)) //关闭上一个Menu
{
  document.getElementById(LastLeftID).className = "collapsed";
}
LastLeftID = emid;
}
function GetMenuID()
{
var MenuID="";
var _paramStr = new String(window.location.href);
var _sharpPos = _paramStr.indexOf("#");

if (_sharpPos >= 0 && _sharpPos < _paramStr.length - 1)
{
  _paramStr = _paramStr.substring(_sharpPos + 1, _paramStr.length);
}
else
{
  _paramStr = "";
}

if (_paramStr.length > 0)
{
  var _paramArr = _paramStr.split("&");
  if (_paramArr.length>0)
  {
   var _paramKeyVal = _paramArr[0].split("=");
   if (_paramKeyVal.length>0)
   {
    MenuID = _paramKeyVal[1];
   }
  }
  /*
  if (_paramArr.length>0)
  {
   var _arr = new Array(_paramArr.length);
  }
  
  //取所有#后面的，菜单只需用到Menu
  //for (var i = 0; i < _paramArr.length; i++)
  {
   var _paramKeyVal = _paramArr[i].split('=');
   
   if (_paramKeyVal.length>0)
   {
    _arr[_paramKeyVal[0]] = _paramKeyVal[1];
   }  
  }
  */
}

if(MenuID!="")
{
  DoMenu(MenuID)
}
}
GetMenuID(); //*这两个function的顺序要注意一下，不然在Firefox里GetMenuID()不起效果
menuFix();
</script>
</html>