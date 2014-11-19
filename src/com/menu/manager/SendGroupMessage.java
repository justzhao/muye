package com.menu.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MessageUtil_qy;

public class SendGroupMessage extends HttpServlet {

	public SendGroupMessage() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String message=request.getParameter("message");
		 PrintWriter out = response.getWriter();
		//String[] selectDps=(String[]) (request.getParameter("selectDps"));
		//选择给部门发
		String[] selectDps=request.getParameterValues("selectDps");
		String[] selectTags=request.getParameterValues("selectTags");

     try {
    	 
    	 BllManager.sendMessage(selectDps, selectTags, message,MessageUtil_qy.REQ_MESSAGE_TYPE_TEXT);
    	 
    	 out.print("<script language='javascript'>alert('发送成功!');window.location.href='sendGroupNews.jsp';</script>");
    	 
    	 //response.sendRedirect("sendGroupNews.jsp");
    	 
	//	BllManager.sendMessage(selectDps,message,"text");
	} catch (KeyManagementException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchProviderException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
