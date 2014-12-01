package com.menu.manager;

import java.io.File;
import java.io.IOException;
import java.rmi.server.LogStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.catalina.util.StringParser;
import org.apache.http.auth.UsernamePasswordCredentials;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import cn.modernfarming.weixin.Services;

import com.departmentBean.Department;
import com.sun.mail.handlers.image_gif;

import db.Connect;

import util.AccessTokenUtil_qy;
import util.MessageUtil_qy;
import bean.fileBean.UpFile;
import bean.httpsBean.AccessToken_qy;
import bean.menuBean.NormalButton;
import bean.responseMessageBean.Article;
import bean.sendMessageBean.ImageMessage;
import bean.sendMessageBean.TextMessage;
import bean.tagBean.Tag;
import bean.user.User;

public class BllManager {
	

	private static Logger logger = LogManager.getLogger(BllManager.class.getName());
	public BllManager() {
		// TODO Auto-generated constructor stub
	}
	
	public static String subString(String str){
		
		if(str==null)
		{
			
			return str;
		}
		if (str.length()<10) {
			return str;
		}else {
			str=str.substring(0, 10)+"...";
			return str;
		}
	}
	
	public static  Boolean checkUserPasswd  (String name,String passwd) {
		
		
		
		return DaoManager.checkUserPasswd(name, passwd);
	}
	
	
	public static void sendPersonMessage(String toUser,String text ,String msgType) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
	{
		
		AccessToken_qy aToken = AccessTokenUtil_qy
				.getAccessToken(AccessTokenUtil_qy.sCorpID,
						AccessTokenUtil_qy.sCorpSecret);
		
	
		
		TextMessage message = new TextMessage();
		//textMessage.setmsgtype("text");
		message.setmsgtype(msgType);
		String content = text;
		message.settext(content);
		if(toUser==null){
			message.settouser("@all");
		}else {
             
			message.settouser(toUser);
				
			
			
		}
		message.setagentid("1");
		
		int rslt = AccessTokenUtil_qy.sendTextMessage(
				message,aToken.getAccessToken());
		if(rslt>0){
		   System.out.println("send Fail");	
		}else{
			System.out.println("send Yes");
		
		}
		
	}
	
	//给部门发消息，toUser为空的时候默认发给全部的人
	/**
	public static void  sendMessage(String[] toUser,String text,String msgType) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException {
		
		AccessToken_qy aToken = AccessTokenUtil_qy
				.getAccessToken(AccessTokenUtil_qy.sCorpID,
						AccessTokenUtil_qy.sCorpSecret);
		
	
		
		TextMessage message = new TextMessage();
		//textMessage.setmsgtype("text");
		message.setmsgtype(msgType);
		String content = text;
		message.settext(content);
		if(toUser==null){
			message.settouser("@all");
		}else {
			String partyString="";
			for (int i = 0; i < toUser.length; i++) {
				if(i<toUser.length-1){
				partyString+=toUser[i]+"|";
				}else {

					partyString+=toUser[i];
				}
				
			}
			message.settoparty(partyString);
		}
		message.setagentid("2");
		
		int rslt = AccessTokenUtil_qy.sendTextMessage(
				message,aToken.getAccessToken());
		if(rslt>0){
		   System.out.println("send Fail");	
		}else{
			System.out.println("send Yes");
		
		}

	
		
	}
*/
	
	public static void  sendMessage(String[] toUser,String[] toTag,String text,String msgType) throws KeyManagementException, 
	NoSuchAlgorithmException, NoSuchProviderException, IOException {
	
	AccessToken_qy aToken = AccessTokenUtil_qy
			.getAccessToken(AccessTokenUtil_qy.sCorpID,
					AccessTokenUtil_qy.sCorpSecret);
	
	TextMessage message = new TextMessage();
	//textMessage.setmsgtype("text");
	message.setmsgtype(msgType);
	String content = text;
	message.settext(content);
	if(toUser==null&&toTag==null){
		message.settouser("@all");
	}else {
		
		if(toUser!=null){
			String partyString="";
			for (int i = 0; i < toUser.length; i++) {
				if(i<toUser.length-1){
					partyString+=toUser[i]+"|";
				}else {
					partyString+=toUser[i];
				}
			}
			message.settoparty(partyString);
		}
		if(toTag!=null){
			String tagString="";
			for (int i = 0; i < toTag.length; i++) {
				if(i<toTag.length-1){
					tagString+=toTag[i]+"|";
				}else {
					tagString+=toTag[i];
				}
			}
			message.settotag(tagString);
		}
	}
	message.setagentid("1");//
	
	int rslt = AccessTokenUtil_qy.sendTextMessage(
			message,aToken.getAccessToken());
	if(rslt>0){
	   System.out.println("send Fail");	
	}else{
		System.out.println("send Yes");
	}
}
	
	public static void  sendImageMessage(String[] toUser,String text,String msgType) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException{
		AccessToken_qy aToken = AccessTokenUtil_qy
				.getAccessToken(AccessTokenUtil_qy.sCorpID,
						AccessTokenUtil_qy.sCorpSecret);
		
		ImageMessage message = new ImageMessage();
		//textMessage.setmsgtype("text");
		message.setmsgtype(msgType);
	    message.setImage(text);
		message.setagentid("1");
		if(toUser==null){
			message.settouser("@all");
		}else {
			String partyString="";
			for (int i = 0; i < toUser.length; i++) {
				if(i<toUser.length-1){
				partyString+=toUser[i]+"|";
				}else {

					partyString+=toUser[i];
				}
				
			}
			message.settouser(partyString);
		}
		message.setagentid("1");
		int rslt = AccessTokenUtil_qy.sendImageMessage(
				message,aToken.getAccessToken());
		if(rslt>0){
		   System.out.println("send Fail");	
		}else{
			System.out.println("send Yes");
		
		}
	}

	public static List<User> getAllBindUsers(){
		
		
	return  DaoManager.getAllBindUsers();
		
	}
	
	public static List<Department> getDepartmentList(){

		
		try {
			AccessToken_qy aToken = AccessTokenUtil_qy
					.getAccessToken(AccessTokenUtil_qy.sCorpID,
							AccessTokenUtil_qy.sCorpSecret);
		
			return AccessTokenUtil_qy.getDepartmentList(aToken.getAccessToken());
				

		} catch (KeyManagementException | NoSuchAlgorithmException
				| NoSuchProviderException | IOException e) {
			
			e.printStackTrace();
			return null;
		}

		
	}
	
	
	public static  List<NormalButton> getButtonList() throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException {
		
  return DaoManager.getNormalButtonLists();
		
		
	}
	
	
	public  static List<Article> getArticlesListByKey(String key,String fromUserName) {
		
		
		return DaoManager.getArticlesListByKey(key,fromUserName);
		
		
	}
	
	public static boolean addArticle(String title,String pic, String picurl,String key)
	{
		boolean result=false;
		
		result= DaoManager.addArticle(title,pic,picurl,key);
		
		
		return result;
		
	}

	 public static Article getArticlesListById (String id)
	 {

		 
		 
	 return	 DaoManager.getArticlesListById(id);

	 
		
	}
   
	 public static   boolean updateArticle (String id,String title,String url, String picurl ) {

		 
	  return	 DaoManager.updateArticle(id,title,url,picurl);

		
	}

	 
	 public static boolean delArticleById(String id){
		 
		 DaoManager.delArticleById(id);
		 
		 return true;
	 }
	 
	 
	 public static boolean updateSearchType(String type,String openID) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException, SQLException{
		 
	// 通知给用户说给可以通过发送牛号来查询了	
		 String text="";
		 
		 if(type.equals("cow")){
			 text="现在可以直接发送牛只编号查询牛只信息";
		 }else if(type.equals("breed")){
			 text="现在可以直接发送牛只编号查询繁殖信息";
		 }else{
			 text="现在可以直接发送牛只编号查询疾病信息";
		 }
		 if(!type.equals(BllManager.getSearchType(openID)))
		 { 
		 DaoManager.updateSearchType(type,openID);
		 
		 
	  BllManager.sendPersonMessage(openID,text,MessageUtil_qy.REQ_MESSAGE_TYPE_TEXT);	
		 }
	 return	 true;
	
	 }
	 
	 
	 public static String  getSearchType(String OpenID) throws SQLException
	 {
		 return DaoManager.getSearchType(OpenID);
		 
	 }
	public static boolean addSearchType(String OpenID)
	{
		return DaoManager.addSearchType(OpenID);
	}
	 
	 public static boolean createTagList() throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
	 {
		 List<Tag> allTagsList=  Services.getAllJobList();
		 logger.debug(allTagsList.size());
		 for (Tag tag : allTagsList) {
			
			//ogger.debug(tag.getTagname());
			 createTag(tag);
		}
		 
		 return true;
	 }
	 
	 public static boolean createTag(Tag tag) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
	 {
		 
		 AccessToken_qy aToken = AccessTokenUtil_qy.getAccessToken(AccessTokenUtil_qy.sCorpID,
					AccessTokenUtil_qy.sCorpSecret);
		 
		 AccessTokenUtil_qy.createTag(tag,aToken.getAccessToken());
		 
		 return true;
	 }
	 
	 public static boolean delTagList() throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException{
		
		 AccessToken_qy aToken = AccessTokenUtil_qy.getAccessToken(AccessTokenUtil_qy.sCorpID,
					AccessTokenUtil_qy.sCorpSecret);
		 //获取所有的标签
		 List<Tag> tagList=BllManager.getTagList();


		 if(tagList.size()!=0)
		 {
			 
			 
			 
			 
			 for (Tag tag : tagList) {
				 
				 //根据标签id获得每个标签下的所有成员
				 		List<User> userList=AccessTokenUtil_qy.gettagUser(tag.getTagid(),aToken.getAccessToken());
							if(userList.size()!=0)
						 	{
								String []usename=new String[userList.size()];
								int i=0;
										for (User user : userList) {
											usename[i]=user.getUserid();
										 i++;
										}
								tag.setUserlist(usename);
								AccessTokenUtil_qy.deltagUser(tag, aToken.getAccessToken());
							}
			
		
				
				
			   	 delTag(tag.getTagid());
				
			}
		
		 }
		 
		 logger.debug(tagList.size());
		 return true;
	 }
	 public  static boolean delTag(String  tagId) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
	 {
		 AccessToken_qy aToken = AccessTokenUtil_qy.getAccessToken(AccessTokenUtil_qy.sCorpID,
					AccessTokenUtil_qy.sCorpSecret);
		 AccessTokenUtil_qy.delTagByTag(aToken.getAccessToken(), tagId);
		 return true;
	 }
	 
	 
   public static boolean  addTagUser(String username,String passWord,String openID) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
	 {
		 
		 /**
		 
			HashMap<String, String> map=new HashMap<>();
		   
			map=Services.getWorkIdName(username, passWord);
			// 打标签需要，用户的id(openID)，标签的id (定义在数组中)；
	        Iterator it = map.keySet().iterator();  
	        List<String> tagidlist=new ArrayList<String>();//用户tgalist；
	        //获取标签列表
	       List<Tag> taglist=BllManager.getTagList();
	       // String[] taglist=AccessTokenUtil_qy.taglist;
	        AccessToken_qy aToken = AccessTokenUtil_qy.getAccessToken(AccessTokenUtil_qy.sCorpID,
					AccessTokenUtil_qy.sCorpSecret);
	        
	        while(it.hasNext()) {  
	            String key = (String)it.next();  
	
	          
	            String role=map.get(key);
	            
	            for(Tag tag:taglist)
	            {
	            	if(role.equals(tag.getTagname()))
	            	{
	            	tagidlist.add(tag.getTagid());
	                break;
	            	}
	            }
	            
			
	        }
	        


	        if(tagidlist.size()!=0){
	        	
	        	for (int i = 0; i < tagidlist.toArray().length; i++) {
	        	//	logger.debug("the addtag is " +tagidlist.toArray()[i].toString()+":");
	        		Tag tag=new Tag();
	        		tag.setTagid(tagidlist.toArray()[i].toString());
	        		tag.setUserlist(new String[]{openID});
	        		AccessTokenUtil_qy.createtagUser(tag, aToken.getAccessToken());
	        		
				}
	    	        }*/
		 
			int result=-1;
			AccessToken_qy aToken = AccessTokenUtil_qy.getAccessToken(AccessTokenUtil_qy.sCorpID,
							AccessTokenUtil_qy.sCorpSecret);
			 
			if(null!=aToken){

				//获取用户的岗位 这是从webService获得
				List<Tag> tag = Services.getJobList(username,passWord);

				 //获取微信的taglist 从微信后台获得
				List<Tag> tagList =BllManager.getTagList();
						//AccessTokenUtil_qy.getTag(aToken.getAccessToken());
				
			    for(Tag t:tagList){
			    	
			    	for(Tag tt: tag){
						
						if(t.getTagname().equals(tt.getTagname()))
						{
							
							//logger.debug("id: "+t.getTagid());
							//t.setTagid(tt.getTagid());
							String[] userlist = new String[]{openID};
							t.setUserlist(userlist);
							
							result = AccessTokenUtil_qy.createtagUser(t,aToken.getAccessToken());
							
							if (0 != result) {
								logger.debug("errcode" + result);
							} 
						}
					}
			    }
			}
			return result==0;
		 
		 
       	 }
 
  public  static  List<Tag>  getTagList() throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException {
		
		  AccessToken_qy aToken = AccessTokenUtil_qy.getAccessToken(AccessTokenUtil_qy.sCorpID,
					AccessTokenUtil_qy.sCorpSecret);
		  
	  return	 AccessTokenUtil_qy.getTagList(aToken.getAccessToken());		 
	}
	 
  public static Boolean IsCheckPermisssion(String openID,String tagID) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
   {
	   //接口中只提供根据tagId来查询这个tag内的标签成员。这样
       AccessToken_qy aToken = AccessTokenUtil_qy.getAccessToken(AccessTokenUtil_qy.sCorpID,
				AccessTokenUtil_qy.sCorpSecret);
    List<User> userList =	  AccessTokenUtil_qy.gettagUser(tagID,aToken.getAccessToken());
 
    
    return BllManager.hasUserList(userList,openID);
 

   }
   public static Boolean hasUserList(List<User> userlist,String openID)
   {
	   for (User user : userlist) {
		
		   if(user.getUserid().equals(openID))
		   {
			   return true;
		   }
	}
	   
	   
	   return false;
   }
	 
   public static Boolean updateSendTime(String sendTime){
	   
	 return   DaoManager.updateSendTime(sendTime);
	  // return true;
   }
   

   public static int getSendTime()
   {
	   
	  return  DaoManager.getSendTime();
	   //return 0;
	   
   }
   
   public static Boolean updateSendTag(String []roles,String type)
   {
	   
	   return DaoManager.updateSendTag(roles,type);
	   
	//   return true;
   }   
   
   public static void updateSendPermission(String []tags)
   {
	   UpPermission threadUp=new UpPermission();
		threadUp.setTags(tags);
		Thread thread=new Thread(threadUp);
		thread.start();
   }
   
   public static String getSendTag(String type){

	   
	  return DaoManager.getSendTag(type);
   }
   
   public  static List<User> getUserByTag (String tagId) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException {
	   
		 AccessToken_qy aToken = AccessTokenUtil_qy.getAccessToken(AccessTokenUtil_qy.sCorpID,
					AccessTokenUtil_qy.sCorpSecret);
		 
	 return	 AccessTokenUtil_qy.getUserByTag(aToken.getAccessToken(),tagId);
		 
	//	 return true;
	   
	
}
   public static  boolean refreshTagList() throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
   {
	   /* 刷新对应的所有标签库
	    *  1 删除所有的标签,在这之前需要删除标签里面的成员
	    *  2 重新新建
	    *  3 给意见绑定的用户重新 做上标签
	    */

	   
				   if(BllManager.delTagList())
				   {

					  BllManager.createTagList();
								for( User u:  BllManager.getAllBindUsers())
								{
									BllManager.addTagUser(u.getName(), u.getPassword(), u.getOpenId());
								}
			
				   }
	   
	 	   return true;
   
   }
   
   
   /**
 * @param tag  做测试用的为某个角色生成标签
 * @return   
 * @throws KeyManagementException
 * @throws NoSuchAlgorithmException
 * @throws NoSuchProviderException
 * @throws IOException
 */
public static boolean addTagforUser(Tag tag) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
    {
		 AccessToken_qy aToken = AccessTokenUtil_qy.getAccessToken(AccessTokenUtil_qy.sCorpID,
					AccessTokenUtil_qy.sCorpSecret);
	   AccessTokenUtil_qy.createtagUser(tag, aToken.getAccessToken());
	   return true;
   }


/**
 * @param 
 * @throws IOException 
 * @throws NoSuchProviderException 
 * @throws NoSuchAlgorithmException 
 * @throws KeyManagementException 
 * 
 */
public static String upLoadFile(String path) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
{
	 AccessToken_qy aToken = AccessTokenUtil_qy.getAccessToken(AccessTokenUtil_qy.sCorpID,
				AccessTokenUtil_qy.sCorpSecret);

	 
	 String temppath="\\muye\\img\\";
	 int x=1+(int)(Math.random()*10);
	 String filepath=	 System.getProperty("user.dir").replace("bin", "webapps")+temppath+x+".jpg";
	 logger.debug(filepath);
	 File file=new File(filepath);


  JSONObject jObject=	AccessTokenUtil_qy.upload(aToken.getAccessToken(), "image", file); 
//AccessTokenUtil_qy.upLoadFile(path, aToken.getAccessToken(),uf);

	return jObject.getString("media_id");
	//return "xx";
}


}
