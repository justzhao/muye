<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.menu.manager.BllManager"%>
<%@page import="com.departmentBean.Department"%>
<%@page import="java.util.List"%>
<%@page import="bean.tagBean.Tag" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"

import="java.util.*,java.sql.*,db.Connect,org.apache.logging.log4j.*,cn.modernfarming.weixin.*"
    pageEncoding="UTF-8"%>


<html>

<head>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
     <link rel="stylesheet" type="text/css" href="css/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="css/base.css" />

     
    <link rel="stylesheet" type="text/css" href="PlugIn/jQuery/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.22.custom.css"/> 

 <link rel="stylesheet" type="text/css" href="PlugIn/jQuery/mutiselect/multiselectSrc/jquery.multiselect.css"/>
    <script src="PlugIn/jQuery/jquery-1.11.1.js" type="text/javascript"></script>
    <script src="PlugIn/jQuery/jquery-ui-1.10.2/ui/jquery-ui.js" type="text/javascript"></script>
    <script src="PlugIn/jQuery/jquery-ui-1.10.2/ui/jquery.multiselect.min.js" type="text/javascript"></script>

<script src="PlugIn/jQuery/pageScript.js" type="text/javascript"></script>
<title>
</title>
</head>

<%

   Logger logger = LogManager.getLogger(request.getRequestURI());

  List<Department> listDepartments=BllManager.getDepartmentList();
  

 String selectDepts="<select style=\"width:100px \" name=\"selectDps\" id=\"selectDps\" multiple=\"multiple\">";

		   for (Department department : listDepartments) {
		
				
			   selectDepts+="<option value=\""+department.getId()+"\">"+department.getName()+"</option>";
		}
		   
		   selectDepts+="</select>";
		 
		   List<Tag> listTags=BllManager.getTagList();
		   

			String selectString1="<select style=\"width:100px \" name=\"selectTags\" id=\"selectTags\" multiple=\"multiple\">";

			for (Tag tag : listTags) {
				
						
				selectString1+="<option value=\""+tag.getTagid()+"\">"+tag.getTagname()+"</option>";
			}
				   
		   selectString1+="</select>";	   
		   



%> 

<script type="text/javascript">

$(function(){

	 $("#selectTags").multiselect({
		 
			checkAllText: "全选",
	        uncheckAllText: "全不选",
	        noneSelectedText: "没有选择",
	        selectedText:"#选择",
	        minWidth:"160"
		 });
	 

	 $("#selectDps").multiselect({
		 
			checkAllText: "全选",
	        uncheckAllText: "全不选",
	        noneSelectedText: "没有选择",
	        selectedText:"#选择",
	        minWidth:"160"
		 });
});
	
	function look(){
		
		var s=$("#selectDps").val();
		alert(s);
	}

</script>
    <div class="alert alert-info">当前位置<b class="tip"></b>消息群发<b class="tip"></b>发送消息</div> 
<div class="right1">

<form method="post"  action="sendGroupMessage">

<div style="height:40px">


	<span >请选择部门发送，(不选择默认发送所有用户)</span>
	<%=selectDepts %>

</div>

<div style="height:40px">


	<span >请选择岗位发送，(不选择默认发送所有用户)</span>
	<%=selectString1 %>

</div>
<div style="height:500px">
<textarea  name="message" cols=70 rows=10 >

</textarea>
<input type="submit" value ="发送" />
</div>

</form>

<div class="clear"></div>
     

<div class="more2">

</div>
</div>

<div class="clear"></div>



