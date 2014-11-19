<%@page import="bean.responseMessageBean.Article"%>
<%@page import="com.menu.manager.BllManager"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%
     String id=request.getParameter("Id");
     /**
     PrintWriter ot = response.getWriter();
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String action=request.getParameter("update");
	if(action!=null){
		   String  title=request.getParameter("title");
    	   String  url=request.getParameter("url");
    	   String  picurl=request.getParameter("picurl");
    	   //BllManager.updateArticle(id,title,url,picurl);
		  if(BllManager.updateArticle(id, title, url, picurl))
		 {
			  ot.print("<script>alert('更新成功!');</script>");
		}
		  else{
			  ot.print("<script>alert('更新失败!');</script>");
		  }
				  
	}else{
		
	}
	*/
    Article article=BllManager.getArticlesListById(id);
    
 
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑文章</title>
<style type="text/css">
input[type='submit'],input[type='button']{background: green;border-radius: 5px;letter-spacing: 3px;width:80px;height: 28px;color:#fff;border: none;}
</style>


<script src="PlugIn/jQuery/jquery-1.11.1.js" type="text/javascript"></script>
</head>
<body>
<form method="post" enctype="multipart/form-data" action = "UploadFile">
		<table class="grid">			
			<tr>
		<td>
		<label for="title">文章标题：</label>
		
		</td>
		<td style="width:500px">
			<input type="hidden" value="<%=article.getId() %>" name="Id">
			<input type="text" value="<%=article.getTitle() %>" style="width:400px" name="title" id="title" />
		    <span class="validation">*</span>
		</td>
							</tr>
					<tr>
				<td><label for="url">链接地址：</label></td>
				<td style="width:500px">
					<input type="text" name="url" value="<%=article.getUrl() %>"  style="width:400px" id="url" />
					<span class="validation">*请输入http://开头的链接地址</span>
				</td>	
				</tr>
		       <tr>		
				<td>
				<label for="picurl">背景图片链接：</label></td>
				<td style="width:800px">
						<input type="file" name="file" /> 
				<span >选择该文章的背景图片</span>
		
				
				</td>
			</tr>



			<tr>
				<td colspan="6">
					<input type="submit" name="update" value="更新">
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