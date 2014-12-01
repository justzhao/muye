package com.menu.manager;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.core.Logger;

import bean.user.User;

import net.sf.json.JSONObject;

public class UpPermission implements Runnable {
	
	public String[] tags;
	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}



	public UpPermission() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		String userString="";
	  List<User> users=new  ArrayList<User>();
		for(int i=0;i<tags.length;i++)
		{
			try {
			 users=BllManager.getUserByTag(tags[i]);
			 for(User user :users)
			 {
		
				  if(userString.indexOf(user.getUserid())<0)
				  {
			      	 userString+=user.getUserid();
				  }
			 }
			 
			String []u=new String[]{userString}; 
		 DaoManager.updateSendTag(u, "4");
			 
			} catch (KeyManagementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.print("the str is "+userString);

	}

}
