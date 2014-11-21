package message;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.*;
import java.util.List;

import db.Connect;
import util.AccessTokenUtil_qy;
import bean.Cow.Cow;
import bean.httpsBean.AccessToken_qy;
import bean.menuBean.Button;
import bean.menuBean.Menu;
import bean.menuBean.MenuButton;
import bean.menuBean.NormalButton;
import bean.sendMessageBean.TextMessage;
import bean.tagBean.Tag;
import bean.user.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.menu.manager.BllManager;
import com.menu.manager.DaoManager;

import cn.modernfarming.weixin.Services;

public class MenuManager_qy {
	private static Logger logger = LogManager.getLogger(MenuManager_qy.class.getName());  
	public static final String MENU_TYPE_CLICK = "click";
	public static final String MENU_TYPE_VIEW = "view";

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws IOException
	 * @throws NoSuchProviderException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	public static void main(String[] args) throws SQLException, KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException {
		// TODO Auto-generated method stub
		
		//BllManager.updateSendTime("12");
		//logger.debug( BllManager.getSendTime());
		/**
        for(Cow cow  :   Services.getDiseaseInfos("马鞍山"))
        {
        	logger.debug("the cow name is "+cow.getCowBarn());
        	
        }
        */
		/**
		for( User u:  BllManager.getAllBindUsers())
		{
			logger.debug("the bind user is "+u.getName());
			BllManager.addTagUser(u.getName(), u.getPassword(), u.getOpenId());
		}*/
		BllManager.getUserByTag("14");
		
	//	BllManager.refreshTagList();
		//BllManager.getTagList();
		//BllManager.getAllBindUsers();
	//	BllManager.getUserByTag("4");
 //   logger.debug (BllManager.getSendTag());
 //  BllManager.delTagList();
	//	BllManager.createTagList();
		//Services.getAllJobList();
		//Services.CheckUser("aocheng", "ac");
	 // BllManager.addTagUser("aocheng", "ac", "ljh");
	//	BllManager.IsCheckPermisssion("1","12");//1是用户id，12是tagID
 //  BllManager.getTagList();
		
 //Services.CheckBind("1");
	//System.out.printf(Services.getCowInfo("01115728"));
 //Services.getWorkIdName("whb","1985");	
//Services.getMilkInfoHtml("01115728");
 //Services.getCowLeftInfoHtml("01115728");
		
		//Services.getDiseaseInfoCount("马鞍山");

		
	//	Services.getDiseaseCowsInfoHtml("马鞍山", "1");
//BllManager.addTagforUser()
/**
		Tag tag=new Tag();
		tag.setTagid("1");
		tag.setUserlist(new String[]{"1"});
     BllManager.addTagforUser(tag);
		BllManager.getUserByTag("1");
		*/
//	BllManager.refreshTagList();	 //属性企业号的标签
		//test();
		//BllManager.addSearchType("ljh");
	//	DaoManager.updateSearchType("breed", "hxh");
		/**
		try {
			AccessToken_qy aToken = AccessTokenUtil_qy.getAccessToken(AccessTokenUtil_qy.sCorpID,
					AccessTokenUtil_qy.sCorpSecret);
			if (null != aToken) {
				int result = AccessTokenUtil_qy.createMenu(getMenu(),
						aToken.getAccessToken(),"2");
				if (0 != result) {
					logger.debug("errcode" + result);
				} else {
					logger.debug("<---以前的乱码部分-->");
				}
			}			

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
		*/
	}

	/**
	 * 构建菜单
	 * @throws IOException 
	 * @throws NoSuchProviderException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 * @throws SQLException 
	 */
	public static void test() throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
	{				 
		
		
		 AccessToken_qy aToken = AccessTokenUtil_qy.getAccessToken(AccessTokenUtil_qy.sCorpID,
					AccessTokenUtil_qy.sCorpSecret);
		List<User> userList=AccessTokenUtil_qy.gettagUser("381",aToken.getAccessToken());
	if(userList.size()!=0)
 	{
		String []usename=new String[userList.size()];
		int i=0;
				for (User user : userList) {
					usename[i]=user.getUserid();
				 i++;
				}
	//	tag.setUserlist(usename);
		//AccessTokenUtil_qy.deltagUser(tag, aToken.getAccessToken());
	}
		
	}
	
	public static void sendMessage() throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
	{
		TextMessage textMessage = new TextMessage();
		textMessage.setmsgtype("text");
		String content ="通过部门发送";
		textMessage.settext(content);
		//textMessage.settouser("1");
		//选择角色 1代表标签(岗位名称)
		String sendTag=BllManager.getSendTag("1");
		
		//textMessage.settotag(sendTag);
		//选择部门 2代表部门
		String sendDept=BllManager.getSendTag("2");
		textMessage.settoparty(sendDept);
		textMessage.setagentid("2");
		AccessToken_qy aToken = AccessTokenUtil_qy
				.getAccessToken(AccessTokenUtil_qy.sCorpID,
						AccessTokenUtil_qy.sCorpSecret);
		int rslt = AccessTokenUtil_qy.sendTextMessage(
				textMessage,aToken.getAccessToken());
	}
	
	private static Menu getMenu() throws SQLException {
		
	
		Connection conn;
		ResultSet rsL1,rsL2;
		Statement statementL1,statementL2;
		String SSQL;
		conn = Connect.connect();
		statementL1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		statementL2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rsL1 = statementL1.executeQuery("select count(*) cnt from [T_DATA_MENU] where [ID_PARENT]=0");
		int MenuL1Count=0;
		if(rsL1.next()){
			MenuL1Count=rsL1.getInt("cnt");
		}
		rsL1.close();

		SSQL="select * from [T_DATA_MENU] where [ID_PARENT]=0 order by [ID]";
		rsL1 = statementL1.executeQuery(SSQL);

		MenuButton[] menuButton=new MenuButton[MenuL1Count];
		int i=0;
		while(rsL1.next()){
			rsL2 = statementL2.executeQuery("select count(*) cnt from [T_DATA_MENU] where [ID_PARENT]="+ rsL1.getInt("ID"));
			int MenuL2Count=0;
			if(rsL2.next()){
				MenuL2Count=rsL2.getInt("cnt");
			}	
			NormalButton[] normalButton=new NormalButton[MenuL2Count];

			rsL2.close();
			SSQL="select * from [T_DATA_MENU] where [ID_PARENT]="+ rsL1.getInt("ID") +" order by [ID]";
			rsL2 = statementL2.executeQuery(SSQL);
			int j=0;
			while(rsL2.next()){
				normalButton[j]=new NormalButton();
				normalButton[j].setName(rsL2.getString("Caption"));
				
				if(rsL2.getString("URL")!=null){
					normalButton[j].setType(MENU_TYPE_VIEW);					
					normalButton[j].setUrl(rsL2.getString("URL"));					
				}else{
					normalButton[j].setType(MENU_TYPE_CLICK);
					normalButton[j].setKey(rsL2.getString("Key"));
				}
				j++;
			}
			rsL2.close();
//			statementL2.close();
			menuButton[i]=new MenuButton();
			menuButton[i].setName(rsL1.getString("Caption"));
			menuButton[i].setSub_button(normalButton);
			i++;
		}
		rsL1.close();
		statementL1.close();
		conn.close();
	
	/**	
		
		    MenuButton[] menuButton=new MenuButton[3];
	
		    NormalButton btn11 = new NormalButton();  
	        btn11.setName("天气预报");  
	        btn11.setType("click");  
	        btn11.setKey("11");  
	  
	        NormalButton btn12 = new NormalButton();  
	        btn12.setName("公交查询");  
	        btn12.setType("click");  
	        btn12.setKey("12");
	        
	        menuButton[0]=new MenuButton();
	        menuButton[0].setName("生活助手");  
	        menuButton[0].setSub_button(new NormalButton[] { btn11, btn12 });
	        
	        NormalButton btn21 = new NormalButton();  
	        btn21.setName("歌曲点播放");  
	        btn21.setType("click");  
	        btn21.setKey("21");  
	  
	        NormalButton btn22 = new NormalButton();  
	        btn22.setName("经典游戏");  
	        btn22.setType("click");  
	        btn22.setKey("22");
	        
	        menuButton[1]=new MenuButton();
	        menuButton[1].setName("休闲娱乐");  
	        menuButton[1].setSub_button(new NormalButton[] { btn21, btn22 });  
	        
	        
	        NormalButton btn31 = new NormalButton();  
	        btn31.setName("电影");  
	        btn31.setType("click");  
	        btn31.setKey("31");  
	  
	        NormalButton btn32 = new NormalButton();  
	        btn32.setName("吃喝");  
	        btn32.setType("click");  
	        btn32.setKey("32");
	        
	        menuButton[2]=new MenuButton();
	        menuButton[2].setName("更多体验");  
	        menuButton[2].setSub_button(new NormalButton[] { btn31, btn32 }); 
	  */


		Menu menu = new Menu();
		menu.setButton(menuButton);

		return menu;
	}

   public void adtag(){
	   Tag tag=new Tag();
	   tag.setTagid("3");
	   //就是OPENID
	   String []userlist=new String[]{""};
	   
	   
   }

}
