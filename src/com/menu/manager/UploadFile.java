package com.menu.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class UploadFile extends HttpServlet {

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		
		
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=utf-8");
		 PrintWriter out = response.getWriter();
		
		 String filepath = getServletContext().getRealPath("/")+"\\image";
		   
	     // String filePath = "D:\\Workspace\\JAVA\\muye\\WebContent\\image";
		   int fileMaxSize = 5*1024*1024;
		    RandomFileRename rfrp=new RandomFileRename();
		    MultipartRequest mulit = new MultipartRequest(request,filepath,fileMaxSize,"UTF-8",rfrp);
		      String  title=mulit.getParameter("title");
		      String  key=mulit.getParameter("key");
		      String  url=mulit.getParameter("url");
		      String id=mulit.getParameter("Id");
		      String action=mulit.getParameter("add");
		      PrintWriter ot = response.getWriter();

	    
	        String fileName="";
	        int fileCount = 0;
		        
		        Enumeration filesname = mulit.getFileNames();
		          while(filesname.hasMoreElements()){
		               String name = (String)filesname.nextElement();
		               fileName = mulit.getFilesystemName(name);
		               String contentType = mulit.getContentType(name);
		               
		               if(fileName!=null){
		                   fileCount++;
		               }
		               System.out.println("文件名：" + fileName);
		               System.out.println("文件类型： " + contentType);
		               
		          }
		          System.out.println("共上传" + fileCount + "个文件！");
	

		     if(action!=null){
		    	 BllManager.addArticle(title,url+"?OpenID=",fileName,key);
		    	 
		    	 out.print("添加成功");
		    	// out.print("<script language='javascript'>alert('添加成功!');window.location.href='addArticle.jsp?key='"+key+";</script>");
		    	 // response.sendRedirect("addArticle.jsp?key="+key);
		     }else{
		   
		    	 BllManager.updateArticle(id, title, url+"?OpenID=", fileName);
		    	 out.print("更新成功");
		    	 
		    //	 out.print("<script language='javascript'>alert('修改成功!');window.location.href='editArticle.jsp?Id='"+id+";</script>");
		    	 // response.sendRedirect("editArticle.jsp?Id="+id);
		     }
		    	
		        
		  

		

		
	}

	
	public void init() throws ServletException {
		// Put your code here

		// PropertyConfigurator.configure("../webapps/weixin/WEB-INF/classes/log4j.properties");
	}
	
	
}
