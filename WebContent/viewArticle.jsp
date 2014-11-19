<%@page import="org.apache.catalina.connector.Request"%>
<%@page import="bean.responseMessageBean.Article"%>
<%@page import="bean.menuBean.NormalButton"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.menu.manager.BllManager"%>
<%@page import="com.departmentBean.Department"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"

import="java.util.*,java.sql.*,db.Connect,org.apache.logging.log4j.*,cn.modernfarming.weixin.*"
    pageEncoding="UTF-8"%>
    
<%

   Logger logger = LogManager.getLogger(request.getRequestURI());

  String Id=request.getParameter("Id");
  String Key=request.getParameter("key");

  if(Id!=null){
 
     BllManager.delArticleById(Id);

  }else{
   
  
  }
  
  List<Article> articlelLists=BllManager.getArticlesListByKey(Key,"");

%> 


<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
     <link rel="stylesheet" type="text/css" href="css/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="css/base.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="PlugIn/jQuery/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.22.custom.css"/> 

 
    <script src="PlugIn/jQuery/jquery-1.11.1.js" type="text/javascript"></script>
    <script src="PlugIn/jQuery/jquery-ui-1.10.2/ui/jquery-ui.js" type="text/javascript"></script>
    <script src="PlugIn/jQuery/pageScript.js" type="text/javascript"></script>
</head>
<body>
      <div class="alert alert-info">当前位置<b class="tip"></b>菜单管理<b class="tip"></b>三级菜单列表</div>
<div class="right1">


<input type="button" value="添加" name="add" url="addArticle.jsp?key=<%=Key%>" />
<form method="post"  action="">


<div style="width:80%;height:500px;margin-top:20px">
<table class="table table-bordered table-condensed">
<tbody>
<tr>
<th>编号</th>
<th>标题</th>
<th>背景图片链接</th>
<th>链接地址</th>
<th>操作</th>
</tr>
   <%  for(Article article: articlelLists ){ 
	  
	   %>
     
            <tr>
            
          <td><%= BllManager.subString(article.getId())  %> </td>
          <td> <%=BllManager.subString(article.getTitle()) %></td>

          <td> <%=BllManager.subString(article.getPicUrl()) %></td>
      
            <td> 
            <%=BllManager.subString(article.getUrl())%>
            </td>
            
            <td>
            
      <input type="button" value="编辑" name="add" url="editArticle.jsp?Id=<%=article.getId()%>" /> 
   
      <input type="button" value="删除" name="del" Id="<%=article.getId()%>" Key="<%=Key%>" />      

               </td>

        </tr>
      <%} %> 

</tbody>
</table>


<!--  
      <ul class="list2">
        <li class="t_bg">
          <span class="N1">编号</span>
          <span class="N2">标题</span>
    
          <span class="N3">背景图片链接</span>
     
          <span class="N4">链接地址</span>
          <span class="N5">操作</span>
   </li>
   <%  for(Article article: articlelLists ){ 
	  
	   %>
     
            <li class="bg1">
            
          <span class="N1"><%= BllManager.subString(article.getId())  %> </span>
          <span class="N2"> <%=BllManager.subString(article.getTitle()) %></span>

          <span class="N3"> <%=BllManager.subString(article.getPicUrl()) %></span>
      
            <span class="N4"> 
            <%=BllManager.subString(article.getUrl())%>
            </span>
            
            <span class="N5">
            
      <input type="button" value="编辑" name="add" url="editArticle.jsp?Id=<%=article.getId()%>" /> 
   
      <input type="button" value="删除" name="del" Id="<%=article.getId()%>" Key="<%=Key%>" />      

               </span>

        </li>
      <%} %> 



        </ul>

-->
</div>


</form>

      <div class="clear"></div>
     

      <div class="more2">

      </div>
    </div>

    <div class="clear"></div>
</body>
<script>
bind();
</script>
</html>


