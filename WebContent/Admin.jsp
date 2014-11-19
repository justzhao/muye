<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css" href="css/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="css/base.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="PlugIn/jQuery/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.22.custom.css"/> 

 
    <script src="PlugIn/jQuery/jquery-1.11.1.js" type="text/javascript"></script>
    <script src="PlugIn/jQuery/jquery-ui-1.10.2/ui/jquery-ui.js" type="text/javascript"></script>
    
    <script src="PlugIn/jQuery/jquery.ui.datepicker-zh-CN.js" type="text/javascript"></script>
    <script src="PlugIn/jQuery/index.js" type="text/javascript"></script>
    
 

<title>后台管理首页</title>
<%
HttpSession Session = request.getSession();

String user="";
if(Session.getAttribute("CurrentUsr")!=null)
{
user=Session.getAttribute("CurrentUsr").toString();
}else{
	response.sendRedirect("loginMenu.jsp?error=请登陆");
}

%>
</head>
<body>



    <div class="warp">
        <!--头部开始-->
        <div class="top_c">
         
            <div class="top-nav">您好，欢迎您，<%=user %>!&nbsp;&nbsp;<a href="loginMenu.jsp">退出系统</a> </div>
        </div>
        <!--头部结束-->
        <!--左边菜单开始-->
        <div class="left_c left">
            <h1>系统操作菜单</h1>
            <div class="acc">
              
                <div>
                    <a class="one">菜单管理</a>
                    <ul class="kid">
                  
                        <li><b class="tip"></b><a target="Conframe" href="3levelMenu.jsp">自定义第三级菜单</a></li>
                
                    </ul>
                </div>
                
                
                <div>
                    <a class="one">消息群发</a>
                    <ul class="kid">
                  
                        <li><b class="tip"></b><a target="Conframe" href="sendGroupNews.jsp">发送消息</a></li>
                
                    </ul>
                </div>
                 <div>
                    <a class="one">日报管理</a>
                    <ul class="kid">
                  
                        <li><b class="tip"></b><a target="Conframe" href="sendDairyTime.jsp">发送设置</a></li>
                
                    </ul>
                </div>
                
                
                
             
           
         
                 <div id="datepicker"></div>
       
            </div>

        </div>
        <!--左边菜单结束-->
        <!--右边框架开始-->
        <div class="right_c">
            <div class="nav-tip" onclick="javascript:void(0)">&nbsp;</div>

        </div>
        <div class="Conframe" style="height:500px">
            <iframe name="Conframe" id="Conframe"></iframe>
        </div>
        <!--右边框架结束-->

        <!--底部开始-->
        <div class="bottom_c">Copyright &copy;B1-208版权所有</div>
        <!--底部结束-->
    </div>

    <script type="text/javascript">

       
        //$("#datepicker").datepicker($.datepicker.regional["zh-CN"]);
    
    </script>
</body>
</html>