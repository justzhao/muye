<%@page import="bean.menuBean.NormalButton"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.menu.manager.BllManager"%>
<%@page import="com.departmentBean.Department"%>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"

import="java.util.*,java.sql.*,db.Connect,org.apache.logging.log4j.*,cn.modernfarming.weixin.*"
    pageEncoding="UTF-8"%>
    
   <html>
   <head>
   
     <link rel="stylesheet" type="text/css" href="css/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="css/base.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="PlugIn/jQuery/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.22.custom.css"/> 

 
    <script src="PlugIn/jQuery/jquery-1.11.1.js" type="text/javascript"></script>
    <script src="PlugIn/jQuery/jquery-ui-1.10.2/ui/jquery-ui.js" type="text/javascript"></script>
   <title>
   
   </title>
   </head> 
    
    
<%

   Logger logger = LogManager.getLogger(request.getRequestURI());
   List<NormalButton> btButtons= BllManager.getButtonList();
 
  


%> 

<body>
     <div class="alert alert-info">当前位置<b class="tip"></b>菜单管理<b class="tip"></b>自定义第三级菜单</div>
    <div class="right1">

<form method="post"  action="">


<div style="width:700px;height:500px">

<span>备注： 以下是可以修改的二级菜单列表，点击查看对应三级菜单 </span>
<table  class="table table-bordered table-condensed" >

<tbody>
<tr>
<th>
编号
</th>
<th>
二级栏目名称
</th>
<th>
操作
</th>
</tr>
   <%  for(NormalButton btn: btButtons ){  %>
     
   <tr>
            
          <td><%=btn.getKey() %> </td>
          <td> <%=btn.getName() %></td>

      
      <td> 
         <a href="viewArticle.jsp?key=<%=btn.getKey()%>"> 查看三级菜单列表</a> 
     </td>

     </tr>
      <%} %> 

</tbody>
</table>


</div>


</form>

      <div class="clear"></div>
     

      <div class="more2">

      </div>
    </div>

    <div class="clear"></div>

</body>
</html>

