package service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import message.check;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.menu.manager.BllManager;
import com.oreilly.servlet.MultipartRequest;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

import cn.modernfarming.weixin.Services;
import util.AccessTokenUtil_qy;
import util.MessageUtil_qy;
import bean.menuBean.MenuButton;
import bean.requestMessageBean.TextMessage;
import bean.responseMessageBean.Article;
import bean.responseMessageBean.Image;
import bean.responseMessageBean.ImageTextMessage;
import bean.responseMessageBean.Music;
import bean.responseMessageBean.S;
import db.Connect;
import Map.*;

public class CoreService_qy {
	private static Logger logger = LogManager.getLogger(CoreService_qy.class
			.getName());

	public static void main(String[] args) throws Exception {
		

	    

		
		try {
			String msg_signature = "d61d483e90ff2d32e88410aa5da64354604434f8";
			String timestamp = "1412909442";
			String nonce = "1784286985";
			String S = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+ "<xml><ToUserName><![CDATA[wx0cac3e0a5a660ead]]></ToUserName>"
					+ "<Encrypt><![CDATA[Zk0pNBkPpoCcqiotL3mN7ClOLWqGrsUwcB+BfcvtBJ8zIsiLxHpjJq9bxTi+baQ/Q0MLscevQadb0DVUbToJRXho+gxW79Uc3lrjyD2f+BVI5zJ36SROhZeCVs0qS4g6HGXAkeYAoxZt+Qi1Npb8PKHBn6siEIFBemqrLfveU9bsuyFGe9RuK4VmtI1bzT1Rff4qxIfxcPgJbYgj2LZyu/aGeYFxlphLjuaAqOKXnyRLED6f4XhGKnwpXV0/yR+ez6uaEcro3nH0kFKNfaj6ZjZSwDjguJEqjQY8adUVDsgQ9p43aKxZs1EZxVpj/q6cKDVanjQwiIVYvTX9I9b3MUjVHRtv1Z8BrMxBMbZg45tUrhUOArBknU00F/wQZEsV/nh3PDyqKNdXIUwOT11AGWq+2HKnCEXRw+OOEYThf5M=]]></Encrypt>"
					+ "<AgentID><![CDATA[0]]></AgentID>" + "</xml>";
			WXBizMsgCrypt c = new WXBizMsgCrypt(AccessTokenUtil_qy.sToken,
					AccessTokenUtil_qy.sEncodingAESKey,
					AccessTokenUtil_qy.sCorpID);
			logger.debug("---------------");
			String s = c.DecryptMsg(msg_signature, timestamp, nonce, S);
			logger.debug(s);
			logger.debug("---------------");
		} catch (Exception ex) {
			logger.error(ex.getMessage());

		}
	}

	String getAddress(String toUser, String fromUser) {
		String result = "";
		try {
			List<Article> list = new ArrayList<Article>();
			Connection conn;
			ResultSet rsL1;
			Statement statementL1;
			String SSQL;
			conn = Connect.connect();
			statementL1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			SSQL = "select count(*) cnt from T_DATA_LOCATION where FromUser='"
					+ fromUser + "' and ToUser='" + toUser
					+ "' and Dt>dateadd(hour,-2, getdate()) and Status=0 ";
			logger.debug(SSQL);
			rsL1 = statementL1.executeQuery(SSQL);
			int cnt = 0;
			if (rsL1.next()) {
				cnt = rsL1.getInt("cnt");
			}
			rsL1.close();
			statementL1.close();
			if (cnt == 0) {
				Article a1 = new Article();
				a1.setTitle("没有获取到您的位置信息。点击获取帮助！");
				a1.setDescription("");
				a1.setPicUrl("http://aocheng-sc.xicp.net/weixin/image/dishui/ditu_head.png");
				a1.setUrl("http://aocheng-sc.xicp.net/weixin/fuwu_address_help.jsp");
				list.add(a1);
			} else {
				ResultSet rsL2;
				Statement statementL2;
				SSQL = "select top 3 * from (";
				SSQL += " select power(power(lng-Longitude,2)+power(lat-Latitude,2),0.50000000000) L,* from T_SYS_LocalTax_Address A1,";
				SSQL += " (SELECT * FROM T_DATA_LOCATION WHERE FromUser+'_'+ToUser+'_'+convert(varchar,Dt,112)+convert(varchar,Dt,108) in";
				SSQL += " (select FromUser+'_'+ToUser+'_'+convert(varchar,max(Dt),112)+convert(varchar,max(Dt),108) from T_DATA_LOCATION";
				SSQL += " where Status=0  and FromUser='" + fromUser
						+ "' and ToUser='" + toUser
						+ "' group by FromUser,ToUser )) B1) T order by L";
				logger.debug(SSQL);
				statementL2 = conn.createStatement(
						ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				rsL2 = statementL2.executeQuery(SSQL);
				int i = 0;
				String x1 = "", y1 = "";
				while (rsL2.next()) {
					// 添加图文信息中item部分
					i++;
					x1 = rsL2.getString("Longitude");
					y1 = rsL2.getString("Latitude");
					String x2 = rsL2.getString("lng");
					String y2 = rsL2.getString("lat");
					Article a1 = new Article();
					a1.setTitle(rsL2.getString("Depart"));
					a1.setDescription(rsL2.getString("Address"));
					if (i == 1) {
						a1.setPicUrl("http://aocheng-sc.xicp.net/weixin/image/dishui/ditu_head.png");
					} else {
						a1.setPicUrl("http://aocheng-sc.xicp.net/weixin/image/dishui/bsfw03.png");
					}
					a1.setUrl("http://aocheng-sc.xicp.net/weixin/fuwu_mapway.jsp?x1="
							+ x1 + "&y1=" + y1 + "&x2=" + x2 + "&y2=" + y2);
					list.add(a1);
				}
				rsL2.close();
				statementL2.close();
				Article a2 = new Article();
				a2.setTitle("更多");
				a2.setDescription("");
				a2.setPicUrl("http://aocheng-sc.xicp.net/weixin/image/dishui/bsfw03.png");
				a2.setUrl("http://aocheng-sc.xicp.net/weixin/fuwu_address.jsp?x1="
						+ x1 + "&y1=" + y1);
				list.add(a2);
			}
			conn.close();
			ImageTextMessage itm = new ImageTextMessage();
			itm.setFromUserName(toUser);
			itm.setToUserName(fromUser);
			itm.setCreateTime(new Date().getTime());
			itm.setMsgType(MessageUtil_qy.RESP_MESSAGE_TYPE_NEWS);
			itm.setArticleCount(list.size());
			itm.setArticles(list);
			result = MessageUtil_qy.newsMessageToXml(itm);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
		}
		return result;
	}

	private String getAddress(String toUser, String fromUser, String lng,
			String lat) {
		String result = "";
		try {
			Connection conn;
			ResultSet rsL1;
			Statement statementL1;
			String SSQL;
			conn = Connect.connect();
			statementL1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			SSQL = "select TOP 3 * from (select power(power(lng-"
					+ lng
					+ ",2)+power(lat-"
					+ lat
					+ ",2),0.50000000000) L,*  from T_SYS_LocalTax_Address) a ORDER BY L";
			logger.debug(SSQL);
			rsL1 = statementL1.executeQuery(SSQL);
			int i = 0;
			List<Article> list = new ArrayList<Article>();
			while (rsL1.next()) {
				// 添加图文信息中item部分
				i++;
				String x2 = rsL1.getString("lng");
				String y2 = rsL1.getString("lat");
				Article a1 = new Article();
				a1.setTitle(rsL1.getString("Depart"));
				a1.setDescription(rsL1.getString("Address"));
				if (i == 1) {
					a1.setPicUrl("http://aocheng-sc.xicp.net/weixin/image/dishui/ditu_head.png");
				} else {
					a1.setPicUrl("http://aocheng-sc.xicp.net/weixin/image/dishui/bsfw03.png");
				}
				a1.setUrl("http://aocheng-sc.xicp.net/weixin/fuwu_mapway.jsp?x1="
						+ lng + "&y1=" + lat + "&x2=" + x2 + "&y2=" + y2);
				list.add(a1);
			}
			rsL1.close();
			statementL1.close();
			conn.close();
			Article a2 = new Article();
			a2.setTitle("更多");
			a2.setDescription("");
			a2.setPicUrl("http://aocheng-sc.xicp.net/weixin/image/dishui/bsfw03.png");
			a2.setUrl("http://aocheng-sc.xicp.net/weixin/fuwu_address.jsp?x1="
					+ lng + "&y1=" + lat);
			list.add(a2);

			ImageTextMessage itm = new ImageTextMessage();
			itm.setFromUserName(toUser);
			itm.setToUserName(fromUser);
			itm.setCreateTime(new Date().getTime());
			itm.setMsgType(MessageUtil_qy.RESP_MESSAGE_TYPE_NEWS);
			itm.setArticleCount(list.size());
			itm.setArticles(list);
			result = MessageUtil_qy.newsMessageToXml(itm);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());

		}
		return result;
	}

	public String processRequest(HttpServletRequest request,
			String msg_signature, String timestamp, String nonce) {

		String respMessage = null;
		logger.debug("processRequest In");
		try {

			// 默认返回的文本消息内容
			String respContent = "";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil_qy.parseXml(request,
					msg_signature, timestamp, nonce);

			// 发送方帐号（open_id） 就是对应的微信的id
			String fromUserName = requestMap.get("FromUserName");
			
			//agentID是发送者
			String agentID = requestMap.get("AgentID");

			logger.debug("FromUserName(发送者aopenID) 【" + fromUserName + "】");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			logger.debug("ToUserName(公众帐号openID) 【" + toUserName + "】");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			logger.debug("MsgType 【" + msgType + "】");
			// 消息内容
			String content = requestMap.get("Content");
			logger.debug("Content 【" + content + "】");

			// 根据接收到的MsgType判断条件
			// 文本消息

			if (msgType.equals(MessageUtil_qy.REQ_MESSAGE_TYPE_TEXT)) {
				
				
				TextMessage textMessage = new TextMessage();
				
				//textMessage.setToUserName(agentID);
				textMessage.setToUserName(fromUserName);
				textMessage.setFromUserName(toUserName);
				textMessage.setCreateTime(new Date().getTime());
				textMessage.setMsgType(MessageUtil_qy.RESP_MESSAGE_TYPE_TEXT);
         
				
		
				if (!Services.CheckBind(fromUserName).equals("")) {
					
		
					if (content.length() != 8 && !content.equals("1")) {
						textMessage.setContent("您输入的牛号不正确。请发送8位牛号！");
					} else {
						// 这里需要先传进去当前的状态 cow disease breed
						logger.debug("find type in");
					      String type=BllManager.getSearchType(fromUserName);
					      logger.debug("type is "+type);
					      String txt_temp="";
						    if(type.equals("cow")){
						    	
						      txt_temp = Services.getCowInfo(content);
						     //txt_temp="NNONO";
						    
						    }
						    else if(type.equals("breed"))
						    {
						        txt_temp=Services.getBreedingInfo(content);
						    }
						     else if(type.equals("disease")) {
								 
						    	 txt_temp=Services.getDiseaseInfo(content);
						    	 
							}else{
								//
								txt_temp="没有信息";
							}
					      
					      textMessage.setContent(txt_temp);
					  }
				  logger.debug("okokokokokoko");
				} else {
					textMessage
							.setContent("您好，您还没有绑定工号！不能进行查询！请通过菜单【在线办公】->【用户绑定】进入绑定界面进行操作！");
				}
                    
                //字符串转成XML
				respMessage = MessageUtil_qy.textMessageToXml(textMessage);

			}
			// 图片消息
			else if (msgType.equals(MessageUtil_qy.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil_qy.REQ_MESSAGE_TYPE_LOCATION)) {
				String location_x = requestMap.get("Location_X");
				String location_y = requestMap.get("Location_Y");
				BaiDu baiDu = new BaiDu();
				Point pt = baiDu.TransPoint(location_y, location_x);
				respMessage = getAddress(toUserName, fromUserName,
						pt.longitude, pt.latitude);
			}
			// 链接消息
			else if (msgType.equals(MessageUtil_qy.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！";
			}
			// 音频消息
			else if (msgType.equals(MessageUtil_qy.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是音频消息！";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil_qy.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				logger.debug(eventType);				
				// 订阅
				if (eventType.equals(MessageUtil_qy.EVENT_TYPE_SUBSCRIBE)) {
					// 订阅后自动回复菜单
					
					
					if (Services.CheckBind(fromUserName).equals("")) 
					{
					
						TextMessage textMessage = new TextMessage();
							textMessage.setToUserName(fromUserName);
							textMessage.setFromUserName(toUserName);
							textMessage.setCreateTime(new Date().getTime());
							textMessage
									.setMsgType(MessageUtil_qy.RESP_MESSAGE_TYPE_TEXT);
							
							
							textMessage                                                            //http://weixin.xdmy.co/muye/image/0102.png    
									.setContent("感谢关注现代牧业！\n为了不影响您使用，请先进行账号<a href=\"http://weixin.xdmy.co/muye/MIS_Bind.jsp?OpenID="
											+ fromUserName + "\">绑定</a>！");
							//http://aocheng-sc.xicp.net/weixin/MIS_Bind.jsp?OpenID=
							respMessage = MessageUtil_qy.textMessageToXml(textMessage);
					}
				}
				// 取消订阅
				else if (eventType
						.equals(MessageUtil_qy.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
					//Services.UnBindUser(fromUserName);
				}
				// 位置信息
				else if (eventType.equals(MessageUtil_qy.EVENT_TYPE_LOCATION)) {


					String longitude, latitude, precision;
					longitude = requestMap.get("Longitude");
					latitude = requestMap.get("Latitude");
					precision = requestMap.get("Precision");

					BaiDu baiDu = new BaiDu();
					Point pt = baiDu.TransPoint(longitude, latitude);

					Connection conn;
					Statement statementL1;
					String SSQL;
					conn = Connect.connect();
					statementL1 = conn.createStatement();
					SSQL = "update [T_DATA_LOCATION] set [Status]=1 where [FromUser]='"
							+ fromUserName
							+ "' and [ToUser]='"
							+ toUserName
							+ "' ";
					SSQL += "insert into [T_DATA_LOCATION]([FromUser],[ToUser],[Latitude],[Longitude],[Precision])values("
							+ " '"
							+ fromUserName
							+ "','"
							+ toUserName
							+ "',"
							+ pt.latitude
							+ ","
							+ pt.longitude
							+ ","
							+ precision + ")";
					logger.debug(SSQL);
					statementL1.execute(SSQL);
					statementL1.close();
					conn.close();

				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil_qy.EVENT_TYPE_CLICK)) {
					String eventKey = requestMap.get("EventKey");
					logger.debug("EventKey:" + eventKey);
					
					//响应key为数字的
					List<Article> articleslList=new ArrayList<Article>();
					
					// 
					articleslList=BllManager.getArticlesListByKey(eventKey,fromUserName);
					if(articleslList.size()>0){
					ImageTextMessage itm = new ImageTextMessage();
					itm.setFromUserName(toUserName);
					itm.setToUserName(fromUserName);
					itm.setCreateTime(new Date().getTime());
					itm.setMsgType(MessageUtil_qy.RESP_MESSAGE_TYPE_NEWS);
					itm.setArticleCount(articleslList.size());
					itm.setArticles(articleslList);
				
					respMessage = MessageUtil_qy.newsMessageToXml(itm);
					}else {
						respMessage = getAddress(toUserName, fromUserName);
					}

				}
			}
			WXBizMsgCrypt c = new WXBizMsgCrypt(AccessTokenUtil_qy.sToken,
					AccessTokenUtil_qy.sEncodingAESKey,
					AccessTokenUtil_qy.sCorpID);
			logger.debug("---------------");
			
			//这里是对消息加密
		    if(respMessage!=null){
			respMessage = c.EncryptMsg(respMessage, timestamp, nonce);
		    }
			
			} 
		
		catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		logger.debug("processRequest Out");

		return respMessage;
	}

	public String processHightRequest(HttpServletRequest request,String msg_signature, String timestamp, String nonce) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException
	{
		String respMessage = null;
		logger.debug("processHightRequest In");
		
		String respContent = "";

		// xml请求解析 ,也解码了
		Map<String, String> requestMap = MessageUtil_qy.parseXml(request,
				msg_signature, timestamp, nonce);

		// 发送方帐号（open_id） 就是对应的微信的id
		String fromUserName = requestMap.get("FromUserName");
		
		//agentID是发送者
		String agentID = requestMap.get("AgentID");

		logger.debug("FromUserName(发送者aopenID) 【" + fromUserName + "】");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		logger.debug("ToUserName(公众帐号openID) 【" + toUserName + "】");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		logger.debug("MsgType 【" + msgType + "】");
		// 消息内容   要的就是消息内容
		String content = requestMap.get("Content");
		logger.debug("Content 【" + content + "】");
		
		TextMessage textMessage = new TextMessage();
		
		textMessage.setToUserName(agentID);
		
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil_qy.RESP_MESSAGE_TYPE_TEXT);
		String[] selectDps=request.getParameterValues("selectDps");
		String[] selectTags=request.getParameterValues("selectTags");
    //收到消息后转发给大家
		if (msgType.equals(MessageUtil_qy.REQ_MESSAGE_TYPE_TEXT)) {
			
			
			//String[] selectDps=(String[]) (request.getParameter("selectDps"));
			//选择给部门发
		
			


			try {
				BllManager.sendMessage(selectDps,selectTags,content,MessageUtil_qy.REQ_MESSAGE_TYPE_TEXT);
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
			textMessage.setContent("消息已经成功能发出!");
			
		}
		// 图片消息
		else if (msgType.equals(MessageUtil_qy.REQ_MESSAGE_TYPE_IMAGE)) {
			
			
			String MediaId=requestMap.get("MediaId");
			
			BllManager.sendImageMessage(selectDps,MediaId,MessageUtil_qy.REQ_MESSAGE_TYPE_IMAGE);
			textMessage.setContent("消息已经成功能发出!");
	
		}else if(msgType.equals(MessageUtil_qy.RESP_MESSAGE_TYPE_MUSIC)) {
			
			textMessage.setContent("消息类型不支持发出!");
			
			
		}else if(msgType.equals(MessageUtil_qy.REQ_MESSAGE_TYPE_VOICE)){
			textMessage.setContent("消息类型不支持发出!");
			
		}else if (msgType.equals(MessageUtil_qy.REQ_MESSAGE_TYPE_EVENT)) {
			// 事件类型
			String eventType = requestMap.get("Event");
			logger.debug(eventType);				
			// 订阅
					if (eventType.equals(MessageUtil_qy.EVENT_TYPE_SUBSCRIBE))
					{
					
					    textMessage.setContent("请通过此应用发送群消息，或者通知公告，只支持文本消息和图片消息！");
				
					
					}

		
		
			}
		else{
			
		}
		respMessage = MessageUtil_qy.textMessageToXml(textMessage);
		WXBizMsgCrypt c;
		try {
			c = new WXBizMsgCrypt(AccessTokenUtil_qy.sToken,
					AccessTokenUtil_qy.sEncodingAESKey,
					AccessTokenUtil_qy.sCorpID);
			respMessage = c.EncryptMsg(respMessage, timestamp, nonce);
		} catch (AesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("---------------");
		

		return respMessage;
	}
}
