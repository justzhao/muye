<%@page import="org.apache.catalina.connector.Request"%>
<%@page import="bean.responseMessageBean.Article"%>
<%@page import="bean.menuBean.NormalButton"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.menu.manager.BllManager"%>
<%@page import="com.departmentBean.Department"%>
<%@page import="java.util.List"%>
<%@page import="bean.tagBean.Tag" %>
<%@page import="java.io.PrintWriter"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"

import="java.util.*,net.sf.json.*,java.sql.*,db.Connect,org.apache.logging.log4j.*,cn.modernfarming.weixin.*"
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
     request.setCharacterEncoding("UTF-8");
     response.setCharacterEncoding("UTF-8");
     String sendTime=request.getParameter("selectTime");
     response.setContentType("text/html;charset=utf-8");
		
     PrintWriter ot = response.getWriter();
     String formName=request.getParameter("fName"); 
 	 String[] selectTags=request.getParameterValues("selectTags");
 	 String[] selectDepts=request.getParameterValues("selectDepts");
 	 
   
 	/* String selectValue =""; //选择的提示信息
 	String selectDptValue =""; */
       if(sendTime!=null){
	   		BllManager.updateSendTime(sendTime);
         	if(selectTags!=null)
         	{
	
 			 BllManager.updateSendTag(selectTags,"1");
	 			//List<Tag> tags = BllManager.getTagList();
	 			//logger.debug("the length is "+selectTags.length);
	 			/* for(int i=0;i<selectTags.length;i++) {
	 				for(Tag tag : tags) {
	 					
	 					//logger.debug("the my id is "+selectTags[i]+"the tag id is "+tag.getTagid() );
	 					if(selectTags[i].equals( tag.getTagid())) {
	 						
	 						selectValue += tag.getTagname()+"|";
	 						//logger.debug("select value~~~"+tag.getTagname());
	 					}
	 				}
	 				
	 			}
	 			selectValue= selectValue.substring(0, selectValue.length()  -1); */
     		} 
          	if(selectDepts!=null){
          	   BllManager.updateSendTag(selectDepts,"2");
          	}
          	             	
          	out.print("<script>alert('修改成功!')</script>");
	} //else {
			String tags = BllManager.getSendTag("1");
			String[] tagArr = tags.split("\\|");
			
			JSONArray jsonArr = JSONArray.fromObject(tagArr);
			//logger.debug("teh json is "+jsonArr);
			List<Tag> tagslist = BllManager.getTagList();
			
			/* for(int i=0;i<tagArr.length;i++) {
				for(Tag tag : tagslist) {
					
				//	logger.debug("the my id is "+tagArr[i]+"the tag id is "+tag.getTagid() );
					if(tagArr[i].equals( tag.getTagid())) {
						selectValue += tag.getTagname()+" |";
						//logger.debug("select value~~~"+tag.getTagname());
					}
				}
				
			}
			selectValue= selectValue.substring(0, selectValue.length() -1); */
		//}
			String dpts = BllManager.getSendTag("2");
			String[] dptArr = dpts.split("\\|");
			JSONArray jsondptArr = JSONArray.fromObject(dptArr);
			/* List<Department> dptslist = BllManager.getDepartmentList();
			
			for(int i=0;i<dptArr.length;i++) {
				for(Department dept : dptslist) {
					
					//logger.debug("the my id is "+dptArr[i]+"the tag id is "+dept.getId() );
					if(dptArr[i].equals( dept.getId())) {
						selectDptValue += dept.getName()+" |";
						//logger.debug("select value~~~"+tag.getTagname());
					}
				}
				
			}
			selectDptValue= selectDptValue.substring(0, selectDptValue.length() -1); */
   
   
	List<Tag> listTags=BllManager.getTagList();
	   

	String selectString1="<select style=\"width:100px \" name=\"selectTags\" id=\"selectTags\" multiple=\"multiple\">";
	
	for (Tag tag : listTags) {
		
				
		selectString1+="<option value=\""+tag.getTagid()+"\">"+tag.getTagname()+"</option>";
		
	}
	selectString1+="</select>";
		  	 
	  List<Department> listDepts=BllManager.getDepartmentList(); 
		   String  selectDeps="<select style=\"width:100px \" name=\"selectDepts\" id=\"selectDepts\" multiple=\"multiple\">";
    
        for(Department deps :listDepts)
        {
        	selectDeps+="<option value=\""+deps.getId()   +"\">"+deps.getName()+"</option>";
        }
        selectDeps+="</select>";	
        
        
  %>
     

<script type="text/javascript">

$(function(){
	 var valArr = new  Array();
	 valArr = <%=jsonArr%>;
	 var dptArr = new Array();
	 dptArr =<%=jsondptArr%>;
	 //alert(valArr);
	
		 
	 $("#selectTime").multiselect({
		 
	
      
      
        multiple:false,
        selectedList: 1 ,
        minWidth:"160"
		 
		 
	 });
	 
	 
	 $("#selectTags").multiselect({
		 
			
			checkAllText: "全选",
	        uncheckAllText: "全不选",
	        noneSelectedText: "没有选择",
	        selectedText:"#选择",
	        minWidth:"160"
		 
		 });
	 /* $("#selectTags").val(valArr);
	 $("#selectTags").multiselect("refresh"); */
	 
	 $('#selectTags option').each(function(i){
		// alert(this.value);
		   if(valArr.indexOf(this.value)!=-1){
			   this.selected=true;
		   }
		 }); 
	 $("#selectTags").multiselect("refresh");
	 
	 $("#selectDepts").multiselect({
		 
			
			checkAllText: "全选",
		    uncheckAllText: "全不选",
		    noneSelectedText: "没有选择",
		    selectedText:"#选择",
		    minWidth:"160"
		 });
	 
	 $("#selectDepts").val(dptArr);
	 $("#selectDepts").multiselect("refresh");
	 
	});


</script>
    
    <body>
    
     <div class="alert alert-info">当前位置<b class="tip"></b>日报管理<b class="tip"></b>发送设置</div>
<div class="right1">

<div style="width:700px;height:500px">
<span>备注：以下是设置每日日报推送的时间和接受岗位名称</span>


<form method="post">

<div>




<span>
请选择发送日报的开始时间(小时):
</span>
      <select name="selectTime" id="selectTime">   
        <option value="11">11</option>   
        <option value="11.5">11.30</option>   
        <option value="12">12</option>   
        <option value="12.5">12.30</option>   
        <option value="13">13</option>   
        <option value="13.5">13.30</option>  
           
      </select>   



</div>

<div style="margin-top:10px">




	<span >请选择需要推送日报的角色(多选):           </span>
	<%=selectString1 %> <span >没有选择不修改   </span>
	<%-- <br/><span>您当前选择的角色有：(<%=selectValue %>)</span> --%>



</div>


<div style="margin-top:10px">

	<span >请选择需要推送日报的部门(多选):           </span>
	<%=selectDeps %> <span >没有选择不修改   </span>
	<%-- <br/><span>您当前选择的部门有：(<%=selectDptValue %>)</span> --%>


</div>


<input type="submit" name="submit" value="提交">
</form>


</div>


      <div class="clear"></div>
     

      <div class="more2">

      </div>
    </div>

    <div class="clear"></div>
</body>
</html>


