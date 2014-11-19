package com.menu.manager;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.jws.soap.SOAPBinding.Use;

import message.MenuManager_qy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bean.menuBean.NormalButton;
import bean.responseMessageBean.Article;
import bean.user.User;

import db.Connect;

public class DaoManager {
	private static Logger logger = LogManager.getLogger(DaoManager.class.getName());  
	public DaoManager() {
		// TODO Auto-generated constructor stub
	}
	
public static  Boolean checkUserPasswd  (String name,String passwd) {
   
	   Boolean result=false;
	   Connection conn=Connect.connect();
	
		ResultSet rsL1;

//	String SSQL="select * from T_SYS_MANAGER_USERS where UserName=? and PassWord=?";
		String SSQL="select * from T_SYS_MANAGER_USERS where UserName='"+name+"' and PassWord='"+passwd+"'";
		try {

      PreparedStatement preState=conn.prepareStatement(SSQL);
   //   preState.setString(1, name );
      //preState.setString(2, passwd);
       rsL1 = preState.executeQuery();
		
       if(rsL1.next()){
				
				result=true;
     	}
			

		 	conn.close();
		} catch (Exception e) {
	     	return false;
		}
		return result;
	}


public static  List<NormalButton> getNormalButtonLists() {
	
	List<NormalButton> normalButtons = new ArrayList<NormalButton>();
	

	   Connection conn=Connect.connect();
	
		ResultSet rsL1;
		Statement statementL1;
		String SSQL="select * from T_DATA_MENU where URL is NULL and ID_PARENT !=0";
		try {

			statementL1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

                   rsL1 = statementL1.executeQuery(SSQL);
		             	while(rsL1.next()){
		
							  NormalButton btn=new NormalButton();
							  btn.setKey(rsL1.getString("Key"));
							  btn.setName(rsL1.getString("Caption"));
					    	 btn.setUrl(rsL1.getString("URL"));
							
                        normalButtons.add(btn);
             }
		   		     statementL1.close();
					 	conn.close();
			
		} catch (Exception e) {
	
		}


	
	
	return normalButtons;
}

  public static  List<Article> getArticlesListByKey(String key,String fromUserName)
  {
	  List<Article> articlelLists=new ArrayList<Article>();
	  

	   Connection conn=Connect.connect();
	
		ResultSet rsL1;

		String SSQL="select * from [T_SYS_ARTICLE] where [Key]=? ";
		try {
		
		      PreparedStatement preState=conn.prepareStatement(SSQL);
		      preState.setString(1,key);
		      rsL1 = preState.executeQuery();
		      
            	while(rsL1.next()){
		
							  Article article=new Article();
							  
							  article.setDescription(rsL1.getString("Description"));
							  article.setPicUrl(rsL1.getString("PicUrl"));
							  article.setTitle(rsL1.getString("Title"));
							  article.setUrl(rsL1.getString("Url")+fromUserName);
							  article.setKey(rsL1.getString("Key"));
							  article.setId(rsL1.getString("Id"));
					   
			
							
					    	 articlelLists.add(article);
            }
   		
   			 	conn.close();
		} catch (Exception e) {
	
		}

	  
	  return articlelLists;
	  
  
  }

  public static Boolean addArticle(String title,String url,String picurl,String key)
  {
	  int result=0;
	  
	  Connection conn=Connect.connect();
		
	  Statement statementL1;
	  String SSQL="";
	    if(picurl!=null){
	    //	picurl="http://211.149.219.21:8081/muye/image/"+picurl;
	    	picurl="http://weixin.xdmy.co/muye/image/"+picurl;
		SSQL="insert into [Weixin_muye].[dbo].[T_SYS_ARTICLE](Title,Url,PicUrl,[Key]) values('"+title+"','"+url+ "','"+picurl+"','"+key+"')";
	    }else {
	    	SSQL="insert into [Weixin_muye].[dbo].[T_SYS_ARTICLE](Title,Url,[Key]) values('"+title+"','"+url+ "','"+key+"')";
		}
		try {
		 statementL1=conn.createStatement();
		

		  result=statementL1.executeUpdate(SSQL);
		      
		     statementL1.close();
			 	conn.close();
			
		} catch (Exception e) {
	
		}

	  
	  return result!=0;
  
  }

  public static Article getArticlesListById(String id) {
	  Article article=new Article();
	  

	   Connection conn=Connect.connect();
	
		ResultSet rsL1;

		String SSQL="select * from [T_SYS_ARTICLE] where [Id]=? ";
		try {
		
		      PreparedStatement preState=conn.prepareStatement(SSQL);
		      preState.setString(1,id);
		      rsL1 = preState.executeQuery();
		      
           	while(rsL1.next()){
		
                   article.setDescription(rsL1.getString("Description"));
				    article.setPicUrl(rsL1.getString("PicUrl"));
				    article.setTitle(rsL1.getString("Title"));
				    
				    String urlString=rsL1.getString("Url");
				    urlString=urlString.substring(0, urlString.length()-8);
				    article.setUrl(urlString);
				    article.setKey(rsL1.getString("Key"));
				  article.setId(rsL1.getString("Id"));
				   
           }

			 	conn.close();
			
		} catch (Exception e) {
	
		}
	  
	  
	  return article;
	  
	
}

public static boolean updateArticle  (String id,String title,String url, String picurl ) {
	
	int result=0;

	   Connection conn=Connect.connect();
	   Statement statementL1;
	String SSQL="";
	 if(picurl!=null){
	//	 picurl="http://211.149.219.21:8081/muye/image/"+picurl;
		 picurl="http://weixin.xdmy.co/muye/image/"+picurl;
		 SSQL="update T_SYS_ARTICLE set Title='"+title+"',PicUrl='"+picurl+"',Url='"+url+"'  where Id="+id;
	 }else {
       SSQL="update T_SYS_ARTICLE set Title='"+title+"',Url='"+url+"'  where Id="+id;
	}
	
			//"update T_SYS_ARTICLE set Title='"+title+"',PicUrl='"+picurl+"',Url='"+url+"'  where Id="+id;
	try {
 
	 statementL1=conn.createStatement();
	 result=statementL1.executeUpdate(SSQL);
     statementL1.close();
	 	conn.close();
		
	} catch (Exception e) {

	}
	return result!=0;
}


public static boolean delArticleById(String id){

	int result=0;
	   Connection conn=Connect.connect();
	   Statement statementL1;
	String SSQL="delete from T_SYS_ARTICLE   where Id="+id;
	try {

	 statementL1=conn.createStatement();
	 result=statementL1.executeUpdate(SSQL);
     statementL1.close();
	 	conn.close();
		
	} catch (Exception e) {

	}
	
	
	return result!=0;
	
}

public static Boolean updateSearchType(String type,String OpenID){
	
	int result=0;

	   Connection conn=Connect.connect();
	   Statement statementL1;
    //	String SSQL=" update T_SYS_SearchType set Type='"+type +"' where Id='"+OpenID+"'";
    	
    	
 String		SSQL = "if not exists(select * from T_SYS_SearchType WHERE Id='"
				+ OpenID
				+ "') \n"
				+ "begin \n"
				+ "insert into T_SYS_SearchType(Id,Type)values( \n"
				+ "'" + OpenID + "','cow')"
				+ " \n"
				+ "end \n"
				+ " update T_SYS_SearchType set Type='"+type +"' where Id='"+OpenID+"'";

  logger.debug(SSQL);
    	   	
	try {
			    statementL1=conn.createStatement();
			     result=statementL1.executeUpdate(SSQL);
			     statementL1.close();
				 	conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage());
       
	}
	return result!=0;
	
	
	//return true;
}
public static boolean addSearchType(String OpenID)
{
	logger.debug("addSearchType________");
	boolean result=false;
	

	try {

		Connection conn;
		Statement statementL1;
		String SSQL;
		conn = Connect.connect();
		statementL1 = conn.createStatement();
     //  SSQL="insert into T_SYS_SearchType(Id,Type)values('"+OpenID+"','cow')";
		
		SSQL = "if exists(select * from T_SYS_SearchType WHERE Id='"
				+ OpenID
				+ "') \n"
				+ "begin \n"
				+ "delete from T_SYS_SearchType WHERE Id='"
				+ OpenID
				+ "' \n"
				+ "end \n"
				+ "insert into T_SYS_SearchType(Id,Type)values( \n"
				+ "'" + OpenID + "','cow')"; 

		/**
		SSQL = "if exists(select * from T_SYS_BIND_USERS WHERE OPENID='"
				+ OpenID
				+ "') \n"
				+ "begin \n"
				+ "delete from T_SYS_BIND_USERS WHERE OPENID='"
				+ OpenID
				+ "' \n"
				+ "end \n"
				+ "insert into T_SYS_SearchType(Id,Type,)values( \n"
				+ "'" + OpenID + "','" + LoginName + "','" + Password
				+ "','' \n" + ")";
				*/
		logger.debug(SSQL);
	 result=	statementL1.execute(SSQL);
	
		statementL1.close();
		conn.close();

	} catch (Exception e) {
		e.printStackTrace();
		logger.error(e.getMessage());
	}
logger.debug("addSearchType out");

	
	return result;
}

public static String getSearchType(String OpenID) throws SQLException
{
	logger.debug("getSearchType in ");
	  String type="";
	   Connection conn=Connect.connect();
	   Statement statementL1;
	   ResultSet rsL1;
 	String SSQL=" select * from T_SYS_SearchType  where Id='"+OpenID+"'";
 	   	
	try {
			    statementL1=conn.createStatement();
			     rsL1=statementL1.executeQuery(SSQL);
			     
			     while (rsL1.next()) {
				
					type=rsL1.getString("Type");
				}
			     statementL1.close();
			 	conn.close();
			} catch (Exception e) {
    
	}
	if(type.equals(""))
	{
		type="cow";
		addSearchType(OpenID);
	}

	return type;
	
}

public static List<User>getAllBindUsers() 
{
	List<User> userList=new ArrayList<User>();
	
	 Connection conn=Connect.connect();
	   Statement statementL1;
	   ResultSet rsL1;
	String SSQL=" select * from T_SYS_BIND_USERS  ";
	   	
	try {
			    statementL1=conn.createStatement();
			     rsL1=statementL1.executeQuery(SSQL);
			     
			     while (rsL1.next()) {
				User user=new User();
			    	 
				user.setName(rsL1.getString("LoginName"));
				user.setPassword(rsL1.getString("Password"));
				user.setOpenId(rsL1.getString("OpenID"));
				userList.add(user);
				}
			     statementL1.close();
				 	conn.close();
			} catch (Exception e) {
  
	}
	for (User user : userList) {
		
		logger.debug(user.getName());
	}

	return userList;
	
}


public static Boolean updateSendTime(String sendTime) 
{
	
	int result=0;

	   Connection conn=Connect.connect();
	   Statement statementL1;
 	String SSQL=" update T_SYS_SendTime set SendTime='"+sendTime +"' where Id=1";
 	   	
	try {
			    statementL1=conn.createStatement();
			     result=statementL1.executeUpdate(SSQL);
			     
			     
			     statementL1.close();
				 	conn.close();
			} catch (Exception e) {
    
	}

	return result!=0;
}

public static int getSendTime()
{
	
	
	  String sendTime="11.5";
	   Connection conn=Connect.connect();
	   Statement statementL1;
	   ResultSet rsL1;
	String SSQL=" select * from  T_SYS_SendTime  where Id=1";
	   	
	try {
			    statementL1=conn.createStatement();
			     rsL1=statementL1.executeQuery(SSQL);
			     
			     while (rsL1.next()) {
				
			    	 sendTime=rsL1.getString("SendTime");
				}
			     statementL1.close();
				 	conn.close();
			} catch (Exception e) {
   
	}
	

	
	return (int) (60* Float.parseFloat(sendTime));
}

public static Boolean updateSendTag(String []role,String type){
	
	int result=0;
	String tagString="";
	
	for (int i = 0; i < role.length; i++) {
		if(i<role.length-1){
			tagString+=role[i]+"|";
		}else {
			tagString+=role[i];
		}
	}

	   Connection conn=Connect.connect();
	   Statement statementL1;
	String SSQL=" update T_SYS_SendRoles set Roles='"+tagString +"' where Id="+type;
	   	
	try {
			    statementL1=conn.createStatement();
			     result=statementL1.executeUpdate(SSQL);
			     statementL1.close();
				 	conn.close();
			} catch (Exception e) {
 
	}
	return result!=0;
	

}

public static String getSendTag(String type )
{
	String sendTag="";
	
	   Connection conn=Connect.connect();
	   Statement statementL1;
	   ResultSet rsL1;
	String SSQL=" select * from  T_SYS_SendRoles  where Id="+type;
	   	
	try {
			    statementL1=conn.createStatement();
			     rsL1=statementL1.executeQuery(SSQL);
			     
			     while (rsL1.next()) {
				
			    	 sendTag=rsL1.getString("Roles");
			    	 
				}
			     statementL1.close();
				 	conn.close();
			} catch (Exception e) {

	
			}
	return sendTag;
	

	
}
}

