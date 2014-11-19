<%@page import="com.menu.manager.BllManager"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>

<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.menu.manager.RandomFileRename" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
    String key=request.getParameter("key");

   
	//String  picurl=request.getParameter("picurl");
     
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加文章</title>

<style type="text/css">
input[type='submit'],input[type='button']{background: green;border-radius: 5px;letter-spacing: 3px;width:80px;height: 28px;color:#fff;border: none;}
</style>
<script src="PlugIn/jQuery/jquery-1.11.1.js" type="text/javascript"></script>
</head>
<body>
<form method="post" enctype="multipart/form-data" action = "UploadFile" >
		<table class="grid">			
			<tr>
		<td><label for="title">文章标题：</label></td>
				<td style="width:700px">
				     <input type="hidden" name="key" value="<%=key%>">
					<input type="text" name="title" style="width:400px" id="title" />
					<span class="validation">*</span>
				</td>
							</tr>
					<tr>
				<td><label for="url">链接地址：</label></td>
				<td style="width:700px">
					<input type="text" name="url" style="width:400px" id="url" />
					<span class="validation">*请输入http://开头的链接地址</span>
				</td>	
				</tr>
		       <tr>		
				<td>
				<label for="picurl">背景图片链接：</label></td>
				<td style="width:700px">
				<input type="file" name="file" /> 
				<span >选择该文章的背景图片</span>
				
				<!--  
					<input type="text" style="width:400px" name="picurl" id="picurl" />
					<span class="validation">*请输入http://开头的图片链接</span>
					
				-->	
				</td>
			</tr>



			<tr>
				<td colspan="6">
					<input type="submit" name="add" value="添加">
					<input type="button" value="关闭" name="close"/>
				</td>
			</tr>
		</table>
</form>

</body>

<script type="text/javascript">

$("input[type='button'][name='close']").click(function(){window.close();});


</script>
</html>