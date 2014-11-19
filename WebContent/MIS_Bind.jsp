<%@page import="com.menu.manager.BllManager"%>
<%@ page language="java"
	import="java.util.*,java.sql.*,db.Connect,org.apache.logging.log4j.*,cn.modernfarming.weixin.*"
	pageEncoding="UTF-8"%>
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
	//txt="<div id=\"content\">";
	
	if (openID == null) {
		txt = "<div data-role=\"head\">没有获取到您的微信信息，请通过微信访问。</div>";
	} else {
		String sLoginName = Services.CheckBind(openID);
		String txt1 = "<br/><form id=form1 method=\"post\" target=\"_self\" action=\"\">";
				
				if(sLoginName.equals("")){
					//绑定
				txt1=txt1+"<label for=\"LoginName\" >用户名</label><input type=text id=\"LoginName\" name=\"LoginName\" />";
				txt1=txt1+ "<input type=hidden  id=\"Opt\" name=\"Opt\" value=0 /> <label for=\"LoginName\" >密码</label><input type=password id=\"Password\" name=\"Password\" />";
				}else{
					//解绑
				txt1=txt1+"<input type=hidden  id=\"Opt\" name=\"Opt\" value=1 /> <input type=hidden id=\"LoginName\" name=\"LoginName\" value="+sLoginName+" />";
				}
				
				//txt1=txt1+ "<fieldset data-role=\"controlgroup\" data-type=\"horizontal\" data-mini=\"true\"><legend>操作类型</legend><input type=radio  id=\"Opt1\" name=\"Opt\" value=0 checked /><label for=\"Opt1\" >绑定</label><input type=radio  id=\"Opt2\" name=\"Opt\" value=1 /><label for=\"Opt2\" >解绑</label></fieldset>"
				txt1=txt1+ "<button class=\"search\" style=\"background-color:;\"  ";
				if(sLoginName.equals("")){
				txt1=txt1+"onclick=\"form1.submit();\" ><div style=\"color:white;\">绑定</div></button>" + "</form>";
				}else{
			    txt1=txt1+"onclick=\"return unBind()\" ><div style=\"color:white;\">解绑</div></button>" + "</form>";
				}
				
				
		if (!sLoginName.equals("")) {
			txt = "<div id=\"content\">  <div data-role=\"head\">您已绑定工号:" + sLoginName
					+ "。</div>";
		}else{
			txt = "<div id=\"content\"><div data-role=\"head\">您还没绑定工号。请输入用户名和密码进行绑定！</div>";			
		}
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
						BllManager.addSearchType(openID);
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
						
						response.sendRedirect("MIS_Bind.jsp?OpenID="+openID);
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
<title>工号绑定</title>
<style>
td {
	font-size: 36px;
	border: 2px solid black;
}

*{
 text-shadow: none !important;
}
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
	
	</div>
</body>
</html>