package com.menu.manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.fluent.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import service.CoreService_qy;
import db.Connect;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static Logger logger = LogManager.getLogger(Login.class
			.getName());

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 req.setCharacterEncoding("UTF-8");
	     resp.setCharacterEncoding("UTF-8");
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");
		
		Connection conn;
		Statement statement;
		String SSQL;
		ResultSet result;
		conn = Connect.connect();
		try {
			statement = conn.createStatement();
			SSQL = "select * from [T_SYS_MANAGER_USERS] where [UserName]='"+userName+"' and [PassWord]='"
					+passWord +"'";
			logger.debug(SSQL);
			result = statement.executeQuery(SSQL);
			resp.setContentType("text/html;charset=utf-8");
			if(result.next()){
				HttpSession session = req.getSession();
				session.setAttribute("CurrentUsr", userName);
				resp.sendRedirect("Admin.jsp");
			}
			else{
				resp.sendRedirect("loginMenu.jsp?error=密码错误");
			}
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
		
}
