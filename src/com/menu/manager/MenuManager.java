package com.menu.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MenuManager extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger =LogManager.getLogger(MenuManager.class.getName());  

	public MenuManager() {
		// TODO Auto-generated constructor stub
		
		super();
	}

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
		String username=request.getParameter("username");
		String passwd=request.getParameter("password");
		PrintWriter out = response.getWriter();
		
		//response.setCharacterEncoding("UTF-8");
		
		
 if(BllManager.checkUserPasswd(username, passwd)){
	 
	out.print("<script>alert('登录成功!');window.location.href='sendGroupNews.jsp'</script>");
 }else{
	 
	 out.print("<script>alert('登录失败!');window.location.href='loginMenu.jsp'</script>");
 }
	
		
		//logger.debug("the username is "+username +"and the password is "+ passwd);
		
	}

	
	public void init() throws ServletException {
		// Put your code here

		// PropertyConfigurator.configure("../webapps/weixin/WEB-INF/classes/log4j.properties");
	}
	

}
