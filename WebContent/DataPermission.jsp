<%@ page language="java" contentType="text/html; charset=UTF-8"

import="java.util.*,net.sf.json.*,java.sql.*,db.Connect,org.apache.logging.log4j.*,cn.modernfarming.weixin.*"
    pageEncoding="UTF-8"%>
<%@page import="com.menu.manager.BllManager"%>
<%@page import="bean.tagBean.Tag" %>
    
    
 <%
 
    Logger logger = LogManager.getLogger(request.getRequestURI());
	List<Tag> listTags=BllManager.getTagList();
 
    String[] selectTags=request.getParameterValues("selectTags");
    
	if(selectTags!=null)
	{
		 BllManager.updateSendTag(selectTags,"3");
		 
		 BllManager.updateSendPermission(selectTags);
		 
		 out.print("<script>alert('修改成功!')</script>");
	}
 
    
	String selectString1="<select colNum=\"3\" style=\"width:100px \" name=\"selectTags\" id=\"selectTags\" multiple=\"multiple\">";
	
	for (Tag tag : listTags) {
		
				
		selectString1+="<option value=\""+tag.getTagid()+"\">"+tag.getTagname()+"</option>";
		
	}
	selectString1+="</select>";
	
	

	String tags = BllManager.getSendTag("3");
	String[] tagArr = tags.split("\\|");
	
	JSONArray jsonArr = JSONArray.fromObject(tagArr);
	

 %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link rel="stylesheet" type="text/css" href="css/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="css/base.css" />
  
    <link rel="stylesheet" type="text/css" href="PlugIn/jQuery/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.22.custom.css"/> 

 <link rel="stylesheet" type="text/css" href="PlugIn/jQuery/mutiselect/multiselectSrc/jquery.multiselect.css"/>
    <script src="PlugIn/jQuery/jquery-1.11.1.js" type="text/javascript"></script>
    <script src="PlugIn/jQuery/jquery-ui-1.10.2/ui/jquery-ui.js" type="text/javascript"></script>
    <script src="PlugIn/jQuery/jquery-ui-1.10.2/ui/jquery.multiselect.min.js" type="text/javascript"></script>

<script src="PlugIn/jQuery/pageScript.js" type="text/javascript"></script>

<title></title>
</head>
<body>
 <div class="alert alert-info">当前位置<b class="tip"></b>查询资料管理<b class="tip"></b>权限设置</div>
 
 <div class="right1">

<div style="width:700px;height:500px">
<span>备注：以下是设置能查询资料的权限</span>


<form method="post">



<div style="margin-top:10px">




	<span >请选择能查询资料的岗位(多选):           </span>
	<%=selectString1 %> <span >没有选择不修改   </span>




</div>




<input type="submit" name="submit" value="提交">
</form>


</div>


      <div class="clear"></div>
     

      <div class="more2">

      </div>
    </div>
 
</body>


<script type="text/javascript">

var valArr = new  Array();
valArr = <%=jsonArr%>;

$(function(){


	 


	 

	 
	 
	 $("#selectTags").multiselect({
		 
			
			checkAllText: "全选",
	        uncheckAllText: "全不选",
	        noneSelectedText: "没有选择",
	        selectedText:"#选择",
	        minWidth:"160"
		 
		 });

	
	 $('#selectTags option').each(function(i){

		   if(valArr.indexOf(this.value)!=-1){
			   this.selected=true;
		   }
		 }); 
	
	
	 $("#selectTags").multiselect("refresh");
	 

	});


</script>
</html>