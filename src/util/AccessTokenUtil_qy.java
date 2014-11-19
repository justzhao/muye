package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import bean.httpsBean.AccessToken;
import bean.httpsBean.AccessToken_qy;
import bean.manageBean.UpdateMembers;
import bean.menuBean.Menu;
import bean.menuBean.MenuButton;
import bean.sendMessageBean.Filter;
import bean.sendMessageBean.Image;
import bean.sendMessageBean.ImageMessage;
import bean.sendMessageBean.TextMessage;
import bean.tagBean.Tag;
import bean.ticketBean.TempTicket;
import bean.ticketBean.Ticket;
import bean.user.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.impl.cookie.PublicSuffixFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.departmentBean.Department;
import com.menu.manager.BllManager;

public class AccessTokenUtil_qy {
	/**
	 * https请求
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式
	 * @param outputStr
	 *            提交数据
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws KeyManagementException
	 * @throws IOException
	 */

	private static Logger logger = LogManager
			.getLogger(AccessTokenUtil_qy.class.getName());
	public static String AppId = "wx56468c72f3e62a3a";
	public static String AppSecret = "47bd54c067fc522627345ed6dfd4a032";

	

	public static String sToken = "lkYW4ME2KiqfCIgnITbLW2Jc";
	public static String sCorpID = "wx6ac2161ab6372f31";
	public static String sEncodingAESKey = "Rcn9G8I8MdbaMjld3rVxC2Kavaf9qmYKBcsw3yRaxON";
	public static String sCorpSecret = "eIbIPEFUur1u3TQk3x_l3J80KmQvHSmVXfzpGjUORmTmqvP4ALWoUgozWNmtyLFe";
	
	
	/**
	
	public static String sToken = "OiingS5ivw8GfnQAFAcaG43yr";
	public static String sCorpID = "wx93ee6ef7d7810920";
	public static String sEncodingAESKey = "HK9XxDXaVgda6lzec5wbAU7dQ1NmPM5jvW76jdvRQkS";
	public static String sCorpSecret = "T0oh9HkWrLNbN1nD376N1pqIp3qK6naEkJkVP14NMIIBAAPAQuOuuoWNUouK8U5b";
	
	*/
	// public static String AppId = "wx1315792412703dfd";
	// public static String AppSecret = "86fcdf43e0913514853c0c635a2cd56e";

	public static JSONObject httpRequest(String requestUrl,
			String requestMethod, String outputStr)
			throws NoSuchAlgorithmException, NoSuchProviderException,
			KeyManagementException, IOException {
		JSONObject jsonObject = null;
		StringBuffer stringBuffer = new StringBuffer();

		// 创建SSLContext对象并用信任管理器初始化
		TrustManager[] trustManagers = { new MyTrustManager() };
		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		sslContext.init(null, trustManagers, new java.security.SecureRandom());

		// 从SSLContext对象中得到SSLSocketFactory对象
		SSLSocketFactory socketFactory = sslContext.getSocketFactory();

		// HTTPS连接中加载SSLSocketFactory对象
		URL url = new URL(requestUrl);
		HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url
				.openConnection();
		httpsURLConnection.setSSLSocketFactory(socketFactory);

		httpsURLConnection.setDoInput(true);
		httpsURLConnection.setDoOutput(true);
		httpsURLConnection.setUseCaches(true);
		httpsURLConnection.setRequestMethod(requestMethod);

		if ("GET".equalsIgnoreCase(requestMethod)) {
			httpsURLConnection.connect();
		}

		// 设置编码
		if (null != outputStr) {
			OutputStream outputStream = httpsURLConnection.getOutputStream();
			outputStream.write(outputStr.getBytes("utf-8"));
			outputStream.close();
		}

		InputStream inputStream = httpsURLConnection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(
				inputStream, "utf-8");
		BufferedReader br = new BufferedReader(inputStreamReader);

		String cacheString = null;
		while ((cacheString = br.readLine()) != null) {
			stringBuffer.append(cacheString);
		}

		// 释放资源
		br.close();
		inputStreamReader.close();
		inputStream.close();
		httpsURLConnection.disconnect();
		jsonObject = JSONObject.fromObject(stringBuffer.toString());

		return jsonObject;
	}

	public final static String AccessTokenUrl_qy = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=CORPID&corpsecret=CORPSECRET";
	public final static String CreateMenuUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	//https://qyapi.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN&agentid=1
///	public final static String CreateMenuUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	public final static String getDepartmentList_qy="https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN";
	public final static String getButtonList_qy="https://qyapi.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN&agentid=2";

	
	
	public final static String CreateMenuUrl_qy = "https://qyapi.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN&agentid=AGENT_ID";
	public static final String CreateTicketUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
	public final static String sendMessageUrl = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	public final static String sendMessageUrl_qy = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";
	public final static String getGroupsUrl = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
	public final static String getUserInfoUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=[OPENID]&lang=zh_CN";
	public final static String updateMembersUrl = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";
	public final static String sendAllUrl = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";

	//标签数组
	public   static String[] taglist=new String[]{"系统管理员","总经理","财务部主任","工程部主任","人事部主任","管理部主任","财务总监","质控部主任","信息部员工","信息部主任","信息部信息管理","牧场场长","信息部中心人员"};
    public final static String addtagUserUrl_qy="https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers?access_token=ACCESS_TOKEN";
	public final static String gettagUserUrl_qy="https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token=ACCESS_TOKEN&tagid=TAG_ID";
                                                                   //    https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token=ACCESS_TOKEN&tagid=1	
	
    public final static String getTagListUrl_qy="https://qyapi.weixin.qq.com/cgi-bin/tag/list?access_token=ACCESS_TOKEN";
    public final static String createTagUrl_qy="https://qyapi.weixin.qq.com/cgi-bin/tag/create?access_token=ACCESS_TOKEN";
    public final static String delTagUrl_qy="https://qyapi.weixin.qq.com/cgi-bin/tag/delete?access_token=ACCESS_TOKEN&tagid=TAG_ID";
    public final static String getUserByTagUrl_qy="https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token=ACCESS_TOKEN&tagid=TAG_ID";
    public final static String delTagUserUrl_qy="https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers?access_token=ACCESS_TOKEN";
    
    
    /**
	 * 获取accesstoken
	 * 
	 * @param appid
	 * @param secret
	 * @return
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws IOException
	 */
	public static AccessToken_qy getAccessToken(String sCorpID,
			String sCorpSecret) throws KeyManagementException,
			NoSuchAlgorithmException, NoSuchProviderException, IOException {
		AccessToken_qy accessToken = null;

		String requestUrl = AccessTokenUrl_qy.replace("CORPID", sCorpID)
				.replace("CORPSECRET", sCorpSecret);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			accessToken = new AccessToken_qy();
			accessToken.setAccessToken(jsonObject.getString("access_token"));
			accessToken.setTime(jsonObject.getInt("expires_in"));
		}
		logger.debug(accessToken);
		return accessToken;
	}

	

	public static int sendAllText(String Content, String GroupID,
			String accessToken) throws KeyManagementException,
			NoSuchAlgorithmException, NoSuchProviderException, IOException {
		int result = -1;
		TextMessage textMessageGroup = new TextMessage();
		Filter f = new Filter();
		f.setgroup_id(GroupID);
		textMessageGroup.settext(Content);
		textMessageGroup.setmsgtype("text");
		String jsonSendAllText = JSONObject.fromObject(textMessageGroup)
				.toString();
		logger.debug(jsonSendAllText);
		String url = sendAllUrl.replace("ACCESS_TOKEN", accessToken);

		JSONObject jo = httpRequest(url, "POST", jsonSendAllText);
		if (null != jo) {
			if (0 != jo.getInt("errcode")) {
				logger.debug(jo.getString("errmsg"));
			}
		}
		result = jo.getInt("errcode");
		logger.debug(jo.toString());
		logger.debug(url);

		return result;
	}

	
	public static int createTag(Tag tag,String accessToken) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
	{

		int result=0;
		String url = createTagUrl_qy.replace("ACCESS_TOKEN", accessToken);
		
		String jsonText = JSONObject.fromObject(tag).toString();
		JSONObject jo = httpRequest(url, "POST", jsonText);
		if (null != jo) {
			if (0 != jo.getInt("errcode")) {
				logger.debug(jo.getString("errmsg"));
			}
		}
		result = jo.getInt("errcode");
		logger.debug(jo.toString());
		logger.debug(url);
		return 0;
	}
	
	public static int updateMembers(String OpenID, int GroupID,
			String accessToken) throws KeyManagementException,
			NoSuchAlgorithmException, NoSuchProviderException, IOException {
		int result = -1;
		UpdateMembers updateMembers = new UpdateMembers();
		updateMembers.setopenid(OpenID);
		updateMembers.setto_groupid(GroupID);
		String jsonUpdateMembers = JSONObject.fromObject(updateMembers)
				.toString();
		String url = updateMembersUrl.replace("ACCESS_TOKEN", accessToken);
		JSONObject jo = httpRequest(url, "POST", jsonUpdateMembers);
		logger.debug(jo.toString());
		logger.debug(url);
		return result;
	}

	public static int getGroups(String accessToken)
			throws KeyManagementException, NoSuchAlgorithmException,
			NoSuchProviderException, IOException {
		int result = -1;
		String url = getGroupsUrl.replace("ACCESS_TOKEN", accessToken);
		JSONObject jo = httpRequest(url, "POST", "");
		logger.debug(jo.toString());
		logger.debug(url);
		return result;
	}

	public static int getUserInfo(String accessToken, String OpenID)
			throws KeyManagementException, NoSuchAlgorithmException,
			NoSuchProviderException, IOException {
		int result = -1;
		String url = getUserInfoUrl.replace("ACCESS_TOKEN", accessToken)
				.replace("[OPENID]", OpenID);

		JSONObject jo = httpRequest(url, "POST", "");
		logger.debug(jo.toString());
		logger.debug(url);
		return result;
	}

	public static int sendTextMessage(TextMessage textMessage,
			String accessToken) throws KeyManagementException,
			NoSuchAlgorithmException, NoSuchProviderException, IOException {
		int result = -1;
		String url = sendMessageUrl_qy.replace("ACCESS_TOKEN", accessToken);
		String jsonTxtMessage = JSONObject.fromObject(textMessage).toString();
		logger.debug(url);
		logger.debug(jsonTxtMessage);
		JSONObject jo = httpRequest(url, "POST", jsonTxtMessage);

		if (null != jo) {
			if (0 != jo.getInt("errcode")) {
				logger.debug(jo.getString("errmsg"));
			}
		}
		result = jo.getInt("errcode");

		return result;
	}

	public static int sendImageMessage(ImageMessage imageMessage,String accessToken) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
	{
		int result = -1;
		String url = sendMessageUrl_qy.replace("ACCESS_TOKEN", accessToken);
		String jsonTxtMessage = JSONObject.fromObject(imageMessage).toString();
		logger.debug(url);
		logger.debug(jsonTxtMessage);
		JSONObject jo = httpRequest(url, "POST", jsonTxtMessage);

		if (null != jo) {
			if (0 != jo.getInt("errcode")) {
				logger.debug(jo.getString("errmsg"));
			}
		}
		result = jo.getInt("errcode");

		return result;
	}
	
	
	public static void main(String[] args) throws SQLException {
		try {

			AccessToken aToken = AccessTokenUtil.getAccessToken(AppId,
					AppSecret);
			getUserInfo(aToken.getAccessToken(), "o5511ji1Q3uZg2-QSiH_CcQOZ6kI");
			aToken = AccessTokenUtil.getAccessToken(AppId, AppSecret);
			getUserInfo(aToken.getAccessToken(), "o5511jg8Z5lcBIWvO37MxnNEygmU");

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug(ex.getMessage());
		}
	}

	/**
	 * 
	 * @param menu
	 * @param accessToken
	 * @return
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws IOException
	 */
	public static int createMenu(Menu menu, String accessToken, String agentid)
			throws KeyManagementException, NoSuchAlgorithmException,
			NoSuchProviderException, IOException {
		String url = CreateMenuUrl_qy.replace("ACCESS_TOKEN", accessToken);
		url = url.replace("AGENT_ID", agentid);
		String jsonMenu = JSONObject.fromObject(menu).toString();
		JSONObject jo = httpRequest(url, "POST", jsonMenu);
		if (null != jo) {
			if (0 != jo.getInt("errcode")) {
				logger.debug(jo.getString("errmsg"));
			}
		}
		logger.debug(jsonMenu);
		return jo.getInt("errcode");
	}
    public static int createtagUser(Tag tag,String accessToken) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException{
	 
    	/**
    	
		String url =addtagUserUrl_qy.replace("ACCESS_TOKEN", accessToken);
		
		String jsonTag = JSONObject.fromObject(tag).toString();
		JSONObject jo = httpRequest(url, "POST", jsonTag);
		logger.debug(jo.toString());
		if (null != jo) {
			if (0 != jo.getInt("errcode")) {
				logger.debug(jo.getString("errmsg"));
			}
		}
	 */
    	
      String url = addtagUserUrl_qy.replace("ACCESS_TOKEN", accessToken);
		
		String jsonTag = JSONObject.fromObject(tag).toString();
	//	logger.debug(jsonTag);
		//JSONObject jo=null;
		
		JSONObject jo = httpRequest(url, "POST", jsonTag); 
		if (null != jo) {
			if (0 != jo.getInt("errcode")) {
				logger.debug(jo.getString("errmsg"));
			}
		}
		logger.debug(jo.toString());
		return jo.getInt("errcode");
	 
		//return 0;

 }
	
    public static List<Tag> getTagList( String accessToken) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
    {
    	
    	/**
	String url =getTagListUrl_qy.replace("ACCESS_TOKEN", accessToken);
		

		JSONObject jo = httpRequest(url, "POST", "");
		
		List<Tag> tagList=    (List<Tag>) JSONArray.toCollection(jo.getJSONArray("taglist"), Tag.class);

		logger.debug(jo.toString());
		if (null != jo) {
			if (0 != jo.getInt("errcode")) {
				logger.debug(jo.getString("errmsg"));
			}
		}
    	
		
		return tagList;
		*/
    	
    	String url = getTagListUrl_qy.replace("ACCESS_TOKEN", accessToken);
    	JSONObject jo = httpRequest(url,"GET","");

    	JSONArray jojo= (JSONArray) jo.get("taglist"); //获取标签列表 tagid,tagname
    	List<Tag> tagList=  (List<Tag>) jojo.toCollection(jojo, Tag.class);
    	logger.debug(jo);
    	if (null != jo) {
    		if (0 != jo.getInt("errcode")) {
    			logger.debug(jo.getString("errmsg"));
    		}
    	}

    	return tagList;
    	

    }

    /**
	public static List<Tag> getTag(String accessToken) throws KeyManagementException, NoSuchAlgorithmException,
	NoSuchProviderException, IOException{


}*/

    
    
  /**
 * @param tagId
 * @param accessToken
 * @return 获取某个标签的成员
 * @throws KeyManagementException
 * @throws NoSuchAlgorithmException
 * @throws NoSuchProviderException
 * @throws IOException
 */
    //获取某标签下的成员
public  static List<User> gettagUser (String tagId,  String accessToken) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException {
		
		String url =gettagUserUrl_qy .replace("ACCESS_TOKEN", accessToken);
		url=url.replace("TAG_ID", tagId);

		JSONObject jo = httpRequest(url, "GET", "");
		logger.debug(jo.get("userlist") .toString());
		
		@SuppressWarnings("unchecked")
		
		List<User> userLists=(List<User>) JSONArray.toCollection(jo.getJSONArray("userlist"), User.class);
		//返回hashmap
/*

		for (User user : userLists) {
			logger.debug(user.getUserid()+":"+user.getName());
			
		}*/
		if (null != jo) {
			if (0 != jo.getInt("errcode")) {
				logger.debug(jo.getString("errmsg"));
			}
		}
		return userLists;
	}
    
//删除标签下的成员
  public  static Boolean  deltagUser(Tag tag,String accessToken) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
  {
	  String url =delTagUserUrl_qy .replace("ACCESS_TOKEN", accessToken);
	
	  String jsonTag = JSONObject.fromObject(tag).toString();
	
	  logger.debug("the send del is "+jsonTag);
	  JSONObject jo = httpRequest(url, "POST", jsonTag);
		//logger.debug(jo.get("userlist") .toString());
		logger.debug(jo.toString());
	  
	  return true;
	  
  }
  
public static String createTicket(Ticket ticket, String accessToken)
			throws KeyManagementException, NoSuchAlgorithmException,
			NoSuchProviderException, IOException {
		String message = null;
		String url = CreateTicketUrl.replace("TOKEN", accessToken);
		String json = JSONObject.fromObject(ticket).toString();
		JSONObject jo = httpRequest(url, "POST", json);
		if (null != jo) {
			message = jo.getString("errcode");
			if (null != message) {
				logger.debug(jo.getString("errmsg"));
			} else {
				message = jo.getString("ticket");
			}
			logger.debug(jo);
		}
		logger.debug(json);
		return message;
	}

	public static String createTempTicket(TempTicket tempticket,	String accessToken) throws KeyManagementException,
			NoSuchAlgorithmException, NoSuchProviderException, IOException {
		logger.debug(accessToken);
		String message = null;
		String url = CreateTicketUrl.replace("TOKEN", accessToken);
		String json = JSONObject.fromObject(tempticket).toString();
		JSONObject jo = httpRequest(url, "POST", json);
		String json1 = JSONObject.fromObject(jo).toString();
		if (jo.has("errcode")) {
			logger.debug("有");
		} else {
			logger.debug("无");
		}
		if (null != jo) {
			// message=;

			if (json1.indexOf("errcode") > -1) {
				logger.debug(jo.getString("errmsg"));
			} else {
				message = jo.getString("ticket");
			}
			logger.debug(jo);
		}
		logger.debug(json);
		return message;
	}
	
	
 public static List<Department> getDepartmentList(String accessToken) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException{

	 int result=-1;
     String url = getDepartmentList_qy.replace("ACCESS_TOKEN", accessToken);
    JSONObject jo = httpRequest(url, "POST", "");


    @SuppressWarnings("unchecked")
	List<Department> dps = (List<Department>)JSONArray.toCollection((JSONArray) jo.get("department"), Department.class);
    // jo.get("department");

  return dps;





}

public static void getMenubuttonList(String accessToken) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
{
	String url = getButtonList_qy.replace("ACCESS_TOKEN", accessToken);
    JSONObject jo = httpRequest(url, "POST", "");
 // JSONObject joo=(JSONObject) jo.get("menu");
    @SuppressWarnings("unchecked")
List<MenuButton> menuButtonlLists =(List<MenuButton>)JSONArray.toCollection( (JSONArray)((JSONObject) jo.get("menu")).get("button"),MenuButton.class);
    
    for(MenuButton btn:menuButtonlLists){
    	
    logger.debug("the button name is "+btn.getName()); 	
    }
    
   //s logger.debug(((JSONObject) jo.get("menu")).get("button").toString());
}

public static void getUserByTag(String accessToken,String tagId) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
{
	
	String url = getUserByTagUrl_qy.replace("ACCESS_TOKEN", accessToken);
	url = url.replace("TAG_ID", tagId);
    JSONObject jo = httpRequest(url, "GET", "");
    logger.debug(jo.toString());
}

public static void delTagByTag(String accessToken,String tagId) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
{
	String url = delTagUrl_qy.replace("ACCESS_TOKEN", accessToken);
	url = url.replace("TAG_ID", tagId);
    JSONObject jo = httpRequest(url, "GET", "");
    logger.debug(jo.toString());
}

}


