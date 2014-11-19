package cn.modernfarming.weixin;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.axis.message.MessageElement;
import org.apache.commons.configuration.interpol.ExprLookup.Variable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.menu.manager.BllManager;

import util.AccessTokenUtil_qy;
import bean.Cow.Cow;
import bean.httpsBean.AccessToken;
import bean.httpsBean.AccessToken_qy;
import bean.sendMessageBean.TextMessage;
import bean.tagBean.Tag;
import cn.modernfarming.mis.CowInfo;
import cn.modernfarming.mis.RtnCowInfoReponse;
import cn.modernfarming.mis.RtnDataTableResponse;
import cn.modernfarming.mis.RtnDataTableResponseRtnDataTable;
import cn.modernfarming.mis.WxService;
import cn.modernfarming.mis.WxServiceLocator;
import cn.modernfarming.mis.WxServiceSoap;
import db.Connect;

public class Services {

	static Logger logger = LogManager.getLogger(Services.class.getName());

	//绑定用户
	public static Boolean BindUser(String OpenID, String LoginName,
			String Password) {
		Boolean result = false;
		try {

			Connection conn;
			Statement statementL1;
			String SSQL;
			conn = Connect.connect();
			statementL1 = conn.createStatement();

			SSQL = "if exists(select * from T_SYS_BIND_USERS WHERE OPENID='"
					+ OpenID
					+ "') \n"
					+ "begin \n"
					+ "delete from T_SYS_BIND_USERS WHERE OPENID='"
					+ OpenID
					+ "' \n"
					+ "end \n"
					+ "insert into T_SYS_BIND_USERS(OpenID,LoginName,Password,UserInfo)values( \n"
					+ "'" + OpenID + "','" + LoginName + "','" + Password
					+ "','' \n" + ")";
			logger.debug(SSQL);
			statementL1.execute(SSQL);
			result = true;
			statementL1.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return result;
	}

	public static List<Tag> getJobList(String UserName, String Password){
		List<Tag> tagList = new ArrayList<Tag>();
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnDataTableResponse response = client.userLogin(UserName, Password);
			if (response.getRtnCode() != -1) {
				RtnDataTableResponseRtnDataTable tb1 = response
						.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				for (int i = 0; i < messageElement.length; i++) {
					Iterator iterator = messageElement[i].getChildElements();
					while (iterator.hasNext()) {
						MessageElement m1 = (MessageElement) iterator.next();
						m1 = m1.getRealElement();
						Iterator it = m1.getChildElements();
						int jj = 0;
						while (it.hasNext()) {
							MessageElement m2 = (MessageElement) it.next();
							if (m2.getName().equals("Table")) {
								Iterator it1 = m2.getChildElements();
								int jjj = 0;
								String DptID = "", DptName = "";
								while (it1.hasNext()) {

									MessageElement m3 = (MessageElement) it1
											.next();

									switch (m3.getName()) {

									case "岗位ID":
										DptID = m3.getValue();
										break;
									case "岗位名称":
										DptName = m3.getValue();
										break;
									
									}
									jjj++;
								}
								Tag t = new Tag();
								t.setTagname(DptName);
								tagList.add(t);
							}

						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug(tagList);
		return tagList;
			
	}
	
	public static List<Tag> getAllJobList()
	{
		List<Tag> tagList=new ArrayList<Tag>();
		
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnDataTableResponse response = client.getAllDept();
			if (response.getRtnCode() != -1) {
				RtnDataTableResponseRtnDataTable tb1 = response
						.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				for (int i = 0; i < messageElement.length; i++) {
					Iterator iterator = messageElement[i].getChildElements();
					while (iterator.hasNext()) {
						MessageElement m1 = (MessageElement) iterator.next();
						m1 = m1.getRealElement();
						Iterator it = m1.getChildElements();
						int jj = 0;
						while (it.hasNext()) {
							MessageElement m2 = (MessageElement) it.next();
							if (m2.getName().equals("Table")) {
								Iterator it1 = m2.getChildElements();
								int jjj = 0;
								String DptID = "", DptName = "";
								while (it1.hasNext()) {

									MessageElement m3 = (MessageElement) it1
											.next();

									switch (m3.getName()) {

									case "岗位ID":
										DptID = m3.getValue();
										break;
									case "岗位名称":
										DptName = m3.getValue();
										break;
									
									}
									jjj++;
								}
								Tag t = new Tag();
								t.setTagid(DptID);
								t.setTagname(DptName);
								tagList.add(t);
							}

						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug(tagList);
		
		
		return tagList;
		
	}
	
	public static Boolean SendDairyProductSummary_qy() {
		Boolean result = false;
		try {
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
		}
		return result;

	}
     //主动发送每天日报
	public static Boolean SendDairyProductSummary(String toUsers) {
		Boolean result = false;
		try {
			Connection conn;
			ResultSet rsL1, rsL2, rsL3;
			Statement statementL1, statementL2, statementL3;
			String SSQL;
			conn = Connect.connect();
			statementL1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			//先看今天的已经发了没有
			SSQL = "select count(*) cnt from REPORT_Dairy_Product_Summary where dt=convert(varchar,dateadd(day,-1,getdate()),112)";
			logger.debug(SSQL);
			rsL1 = statementL1.executeQuery(SSQL);
			if (rsL1.next()) {
				int cnt = rsL1.getInt("cnt");
				//int cnt=16;
				if (cnt == 16) {
					
					
					
					SSQL = "select count(*) cnt from REPORT_Send_Record where [Report_Type]='Dairy_Product_Summary'"
							+ " and dt=convert(varchar,dateadd(day,-1,getdate()),112)";
							//+ " and OpenID='@all'";
					logger.debug(SSQL);
					statementL2 = conn.createStatement(
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					rsL2 = statementL2.executeQuery(SSQL);
					int cnt2 = 0;
					if (rsL2.next()) {
						cnt2 = rsL2.getInt("cnt");
					}
					//没有发送
					if (cnt2 == 0) {
						
						TextMessage textMessage = new TextMessage();
						textMessage.setmsgtype("text");
						String content = getDairyProductSummary();
						textMessage.settext(content);
						textMessage.settouser(toUsers);
						//选择角色 1代表标签(岗位名称)
						String sendTag=BllManager.getSendTag("1");
						
						textMessage.settotag(sendTag);
						//选择部门 2代表部门
						String sendDept=BllManager.getSendTag("2");
						textMessage.settoparty(sendDept);
						textMessage.setagentid("1");
						AccessToken_qy aToken = AccessTokenUtil_qy
								.getAccessToken(AccessTokenUtil_qy.sCorpID,
										AccessTokenUtil_qy.sCorpSecret);
						int rslt = AccessTokenUtil_qy.sendTextMessage(
								textMessage,aToken.getAccessToken());
						if (rslt == 0) {
							SSQL = "insert into REPORT_Send_Record([Report_Type],[dt],[OpenID]) values("
									+ " 'Dairy_Product_Summary',"
									+ " convert(varchar,dateadd(day,-1,getdate()),112),'"+toUsers+"'"
									+ " )";
							logger.debug(SSQL);
							statementL3 = conn.createStatement(
									ResultSet.TYPE_SCROLL_SENSITIVE,
									ResultSet.CONCUR_READ_ONLY);
						statementL3.execute(SSQL);
							statementL3.close();
						}
					}
					rsL2.close();
					statementL2.close();

				}

			}

			result = true;
			rsL1.close();
			statementL1.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
		}
		return result;
	}
    //验证是否绑定
	public static String CheckBind(String OpenID) {
		String result = "";
		try {
			Connection conn;
			ResultSet rsL1;
			Statement statementL1;
			String SSQL;
			conn = Connect.connect();
			statementL1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			SSQL = "select * from T_SYS_BIND_USERS where OPENID='" + OpenID
					+ "'";
			logger.debug(SSQL);
			rsL1 = statementL1.executeQuery(SSQL);
			if (rsL1.next()) {
				result = rsL1.getString("LoginName");

			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
		}
	
		logger.debug(result+"checkbind out___");
		return result;
	}

	//验证用户密码
	public static Boolean CheckUser(String UserName, String Password) {
		Boolean result = false;
		WxService service = new WxServiceLocator();
		try {
			WxServiceSoap client = service.getWxServiceSoap();
			
			//这里应该可以弄到登录信息
			RtnDataTableResponse response = client
					.userLogin(UserName, Password);
			int rtnCode = response.getRtnCode();
			String message = response.getRtnMessage();

			logger.debug(response.getRtnCode());
			logger.debug(response.getRtnMessage());
			if (response.getRtnCode() != -1) {
				RtnDataTableResponseRtnDataTable tb1 = response
						.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				/**
				for (int i = 0; i < messageElement.length; i++) {
				logger.debug("the element is "+messageElement[i]);
				}*/
				
				HashMap<String , String> map = new HashMap<String , String>();  
				
			MessageElement element=(MessageElement) messageElement[1].getRealElement();
			Iterator iterator=element.getChildElements();
			while (iterator.hasNext()) {
				MessageElement element2=(MessageElement) iterator.next();
				Iterator iterator2=element2.getChildElements();
				while (iterator2.hasNext()) {
		           MessageElement element3=(MessageElement) iterator2.next();
		          Iterator iterator3=element3.getChildElements();
		          
		     MessageElement element4=(MessageElement)iterator3.next();
		          
		          String keyString=element4.getValue();
		          element4=(MessageElement)iterator3.next();
		          String valString=element4.getValue();
		          /**
		           while (iterator3.hasNext()) {
				   MessageElement element4=(MessageElement) iterator3.next();
         		   keyString=element4.getValue();
				   valString=element4.getValue();
          		   logger.debug("the element is "+element4.getName()+"and the value is "+element4.getValue());
				}*/
		           map.put(keyString, valString);
		}
		}

	        Iterator it = map.keySet().iterator();  
	        while(it.hasNext()) {  
	            String key = (String)it.next();  
	            System.out.println("key:" + key);  
	            System.out.println("value:" + map.get(key));  
	        }
			
			
	}

			
			
			result = rtnCode > -1 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return result;
	}
    
	//获得用户的岗位ID和岗位名字
	public static  HashMap<String, String> getWorkIdName(String UserName, String Password)
	{
		HashMap<String, String> map=new HashMap<>();
		
		WxService service = new WxServiceLocator();
		try {
			WxServiceSoap client = service.getWxServiceSoap();
			
			//这里应该可以弄到登录信息
	RtnDataTableResponse response = client.userLogin(UserName, Password);
		
			int rtnCode = response.getRtnCode();
			String message = response.getRtnMessage();

			logger.debug(response.getRtnCode());
			logger.debug(response.getRtnMessage());
			if (response.getRtnCode() != -1) {
				RtnDataTableResponseRtnDataTable tb1 = response
						.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
			MessageElement element=(MessageElement) messageElement[1].getRealElement();
			Iterator iterator=element.getChildElements();
			while (iterator.hasNext()) {
				MessageElement element2=(MessageElement) iterator.next();
				Iterator iterator2=element2.getChildElements();
				while (iterator2.hasNext()) {
		           MessageElement element3=(MessageElement) iterator2.next();
		          Iterator iterator3=element3.getChildElements();
		          
		     MessageElement element4=(MessageElement)iterator3.next();
		          
		          String keyString=element4.getValue();
		          element4=(MessageElement)iterator3.next();
		          String valString=element4.getValue();
	          logger.debug(keyString+":"+valString);
		           map.put(keyString, valString);
		}
		}


			
	}

			
			
		

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return map;
		
	}
	
	//获取所有的牧场
	
	public static List<String > getAllFarmInfo()
	{
		
		List<String> farmlist=new ArrayList();
		
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnDataTableResponse response = client.getAllFarmInfo();

		
			logger.debug("the code is "+response.getRtnCode());
			if (response.getRtnCode() != -1) {
				
				
		RtnDataTableResponseRtnDataTable tb1 = response.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				
	
				Iterator iterator = messageElement[1].getChildElements();
	   
				
					while (iterator.hasNext()) {
						
		  		MessageElement m1 = (MessageElement) iterator.next();
						m1 = m1.getRealElement();
						
						int   count=m1.getLength();
						Iterator it = m1.getChildElements();
						int jj = 0;
				
						while (it.hasNext()) {
							//记录条数
							jj++;
				        Cow cow=new Cow();
						
								
					 	MessageElement m2 = (MessageElement) it.next();
								
			
								
						
							if (m2.getName().equals("Table")) {
								Iterator it1 = m2.getChildElements();
								int jjj = 0;
								String FarmName = "";
								while (it1.hasNext()) {

									MessageElement m3 = (MessageElement) it1
											.next();

									switch (m3.getName()) {

									case "牧场名称":
										FarmName = m3.getValue();
								   
										break;
		

									}
									jjj++;
								}
								farmlist.add(FarmName);


					
				
						
							}
			
						
					
					}
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
	return farmlist;
		
	}
	
	//获取产奶长度
public static String getMilkInfoCount(String cowID)
	{
		  int count=0;
		  
		  
			
			try {
				WxService service = new WxServiceLocator();
				WxServiceSoap client = service.getWxServiceSoap();
				RtnDataTableResponse response = client.getCowMilkingInfo(cowID);  
			
				logger.debug("the code is "+response.getRtnCode());
				if (response.getRtnCode() != -1) {
					
					
			RtnDataTableResponseRtnDataTable tb1 = response.getRtnDataTable();
					MessageElement[] messageElement = tb1.get_any();
					
					
					for (int i = 0; i < messageElement.length; i++) {
					Iterator iterator = messageElement[i].getChildElements();
		  
			
						while (iterator.hasNext()) {
							
							MessageElement m1 = (MessageElement) iterator.next();
				             count=m1.getLength();
	       			}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error(e.getMessage());
			}
		
			logger.debug("the count is "+count);
		  
		  return   String.valueOf(count);
	}
	
	//获取牛的奶
	
	public static  List<Cow> getMilksInfos(String cowID)
	{
		List<Cow> cowinfos=new ArrayList();
		
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnDataTableResponse response = client.getCowMilkingInfo(cowID);

		
			logger.debug("the code is "+response.getRtnCode());
			if (response.getRtnCode() != -1) {
				
				
		RtnDataTableResponseRtnDataTable tb1 = response.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				
	
				Iterator iterator = messageElement[1].getChildElements();
	   
				
					while (iterator.hasNext()) {
						
		  		MessageElement m1 = (MessageElement) iterator.next();
						m1 = m1.getRealElement();
						
						int   count=m1.getLength();
						Iterator it = m1.getChildElements();
						int jj = 0;
				
						while (it.hasNext()) {
							//记录条数
							jj++;
				        Cow cow=new Cow();
						
								
					 	MessageElement m2 = (MessageElement) it.next();
								
			
								
							logger.debug("the m2 is "+m2.getName());
							if (m2.getName().equals("Table")) {
								Iterator it1 = m2.getChildElements();
								int jjj = 0;
								String FarmName = "", CowID = "", TestDate = "", CowBarn= "", ChildBirthDate = "", ChildTime = "", BreedStatus = "", MilkStatus = "", LastDryMikeDate = "", MilkDays = "", TotalMilks = "", FirstMilks = "", SecondMilks = "",ThirdMilks  = "", Operator = "";
								while (it1.hasNext()) {

									MessageElement m3 = (MessageElement) it1
											.next();

									switch (m3.getName()) {

									case "牧场":
										FarmName = m3.getValue();
								      cow.setFarmName( FarmName);
										break;
									case "牛号":
										CowID = m3.getValue();
										cow.setCowID(CowID);
										break;
									case "测定日期":
										TestDate = FormateDate(m3.getValue());
										cow.setTestDate(TestDate);
										
										break;
									case "牛舍":
										CowBarn = m3.getValue();
										cow.setCowBarn(CowBarn);
										break;
									case "分娩日期":
										ChildBirthDate =FormateDate(m3.getValue());
										cow.setChildBirthDate(ChildBirthDate);
										break;
									case "胎次":
										ChildTime= m3.getValue();
										cow.setChildTime(ChildTime);
										break;
									case "繁殖状态":
										BreedStatus = m3.getValue();
										cow.setBreedStatus(BreedStatus);
										break;
									case "泌乳状态":
										MilkStatus = m3.getValue();
										cow.setMilkStatus(MilkStatus);
										break;
									case "最近干奶日期":
										LastDryMikeDate =FormateDate( m3.getValue());
										cow.setLastDryMikeDate(LastDryMikeDate);
										
										break; 
									case "泌乳天数":
										MilkDays = m3.getValue();
										cow.setMilkDays(MilkDays);
										break;
									case "总奶量":
										TotalMilks = m3.getValue();
										cow.setTotalMilks(TotalMilks);
										break;
									case "一测奶量":
										FirstMilks = m3.getValue();
										cow.setFirstMilks(FirstMilks);
										break;
									case "二测奶量":
										SecondMilks = m3.getValue();
										cow.setSecondMilks(SecondMilks);
										break;
									case "三测奶量":
										ThirdMilks = m3.getValue();
										cow.setThirdMilks(ThirdMilks);
										break;
									case "操作员":
										Operator = m3.getValue();
										cow.setOperator(Operator);
										break;
									}
									jjj++;
								}
                     cowinfos.add(cow);
						/**
								result += "<tr>" + "<td>" + FarmName + "</td>"
									//	+ "<td>" + CowID + "</td>" 
										+ "<td>"+ TestDate+"</td>" + "<td>"
										+ CowBarn + "</td>" + "<td>" + ChildBirthDate+"</td>" + "<td>"+ChildTime
										+ "</td>" + "<td>" + BreedStatus + "</td>"
										+ "<td>" + MilkStatus + "</td>" + "<td>"
										+ LastDryMikeDate + "</td>" + "<td>"
										+ MilkDays + "</td>" + "<td>"
										+ TotalMilks + "</td>" + "<td>"
										+ FirstMilks + "</td>" + "<td>"
										+ SecondMilks + "</td>" + "<td>"
										+ ThirdMilks + "</td>" + "<td>"
							         	+ Operator + "</td>" + "</tr>";
					
								result+="<tr><td>牧场</td><td>"+FarmName+"</td></tr>"
										+"<tr><td>牛号</td><td>"+TestDate+"</td></tr>"
										+"<tr><td>测定日期</td><td>"+TestDate+"</td></tr>"
										+"<tr><td>牛舍</td><td>"+TestDate+"</td></tr>"
										+"<tr><td>分娩日期</td><td>"+TestDate+"</td></tr>"
										+"<tr><td>胎次</td><td>"+TestDate+"</td></tr>"
										+"<tr><td>繁殖状态</td><td>"+ChildTime+"</td></tr>"
										+"<tr><td>泌乳状态</td><td>"+ChildTime+"</td></tr>"
										+"<tr><td>最近干奶日期</td><td>"+ChildTime+"</td></tr>"
										
										+"<tr><td>泌乳天数</td><td>"+MilkDays+"</td></tr>"
										+"<tr><td>总奶量</td><td>"+TotalMilks+"</td></tr>"
							         	+"<tr><td>一测奶量</td><td>"+ChildTime+"</td></tr>"
							         	+"<tr><td>二测奶量</td><td>"+ChildTime+"</td></tr>"
							         	+"<tr><td>三测奶量</td><td>"+ChildTime+"</td></tr>"
							         	+"<tr><td>操作员</td><td>"+ChildTime+"</td></tr>";
										*/
						
							}
			
						
					
					}
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		
		return cowinfos;
		
	}
	
 	public static String getMilkInfoHtml(String cowID,String currtPage)
	{
		String result="";
		
		int pageSize=1;
		int nowPage=Integer.parseInt(currtPage);
		int curRow=(nowPage-1)*pageSize+1;
		
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnDataTableResponse response = client.getCowMilkingInfo(cowID);

		
			logger.debug("the code is "+response.getRtnCode());
			if (response.getRtnCode() != -1) {
				
				
		RtnDataTableResponseRtnDataTable tb1 = response.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				
				//	for (int i = 0; i < messageElement.length; i++) {
				Iterator iterator = messageElement[1].getChildElements();
	   
				
					while (iterator.hasNext()) {
						
		  		MessageElement m1 = (MessageElement) iterator.next();
						m1 = m1.getRealElement();
						
						int   count=m1.getLength();
						Iterator it = m1.getChildElements();
						int jj = 0;
				
						while (it.hasNext()) {
							jj++;
				
						
								
								MessageElement m2 = (MessageElement) it.next();
								
								if((jj==nowPage*pageSize)&&(jj<=count))
								{	
								
							logger.debug("the m2 is "+m2.getName());
							if (m2.getName().equals("Table")) {
								Iterator it1 = m2.getChildElements();
								int jjj = 0;
								String FarmName = "", CowID = "", TestDate = "", CowBarn= "", ChildBirthDate = "", ChildTime = "", BreedStatus = "", MilkStatus = "", LastDryMikeDate = "", MilkDays = "", TotalMilks = "", FirstMilks = "", SecondMilks = "",ThirdMilks  = "", Operator = "";
								while (it1.hasNext()) {

									MessageElement m3 = (MessageElement) it1
											.next();

									switch (m3.getName()) {

									case "牧场":
										FarmName = m3.getValue();
										break;
									case "牛号":
										CowID = m3.getValue();
										break;
									case "测定日期":
										TestDate = FormateDate(m3.getValue());
										break;
									case "牛舍":
										CowBarn = m3.getValue();
										break;
									case "分娩日期":
										ChildBirthDate =FormateDate(m3.getValue());
										break;
									case "胎次":
										ChildTime= m3.getValue();
										break;
									case "繁殖状态":
										BreedStatus = m3.getValue();
										break;
									case "泌乳状态":
										MilkStatus = m3.getValue();
										break;
									case "最近干奶日期":
										LastDryMikeDate =FormateDate( m3.getValue());;
										break; 
									case "泌乳天数":
										MilkDays = m3.getValue();
										break;
									case "总奶量":
										TotalMilks = m3.getValue();
										break;
									case "一测奶量":
										FirstMilks = m3.getValue();
										break;
									case "二测奶量":
										SecondMilks = m3.getValue();
										break;
									case "三测奶量":
										ThirdMilks = m3.getValue();
										break;
									case "操作员":
										Operator = m3.getValue();
										break;
									}
									jjj++;
								}

						/**
								result += "<tr>" + "<td>" + FarmName + "</td>"
									//	+ "<td>" + CowID + "</td>" 
										+ "<td>"+ TestDate+"</td>" + "<td>"
										+ CowBarn + "</td>" + "<td>" + ChildBirthDate+"</td>" + "<td>"+ChildTime
										+ "</td>" + "<td>" + BreedStatus + "</td>"
										+ "<td>" + MilkStatus + "</td>" + "<td>"
										+ LastDryMikeDate + "</td>" + "<td>"
										+ MilkDays + "</td>" + "<td>"
										+ TotalMilks + "</td>" + "<td>"
										+ FirstMilks + "</td>" + "<td>"
										+ SecondMilks + "</td>" + "<td>"
										+ ThirdMilks + "</td>" + "<td>"
							         	+ Operator + "</td>" + "</tr>";
						*/
								result+="<tr><td>牧场</td><td>"+FarmName+"</td></tr>"
										+"<tr><td>牛号</td><td>"+TestDate+"</td></tr>"
										+"<tr><td>测定日期</td><td>"+TestDate+"</td></tr>"
										+"<tr><td>牛舍</td><td>"+TestDate+"</td></tr>"
										+"<tr><td>分娩日期</td><td>"+TestDate+"</td></tr>"
										+"<tr><td>胎次</td><td>"+TestDate+"</td></tr>"
										+"<tr><td>繁殖状态</td><td>"+ChildTime+"</td></tr>"
										+"<tr><td>泌乳状态</td><td>"+ChildTime+"</td></tr>"
										+"<tr><td>最近干奶日期</td><td>"+ChildTime+"</td></tr>"
										
										+"<tr><td>泌乳天数</td><td>"+MilkDays+"</td></tr>"
										+"<tr><td>总奶量</td><td>"+TotalMilks+"</td></tr>"
							         	+"<tr><td>一测奶量</td><td>"+ChildTime+"</td></tr>"
							         	+"<tr><td>二测奶量</td><td>"+ChildTime+"</td></tr>"
							         	+"<tr><td>三测奶量</td><td>"+ChildTime+"</td></tr>"
							         	+"<tr><td>操作员</td><td>"+ChildTime+"</td></tr>";
									
							break;
							}
						//	curRow++;
						}else {
						 continue;
						}
						
					
					}
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug(result);
		
		
		return result;
		
	}
	
 	//或的牛的产牛犊长度
 	public static String  getCowCalvingInfoCount(String cowID)
 	{
 		int count=0;
 		
 		
 		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnDataTableResponse response = client.getCowCalvingInfo(cowID);  
		
			logger.debug("the code is "+response.getRtnCode());
			if (response.getRtnCode() != -1) {
				
				
		RtnDataTableResponseRtnDataTable tb1 = response.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				
				
				for (int i = 0; i < messageElement.length; i++) {
				Iterator iterator = messageElement[i].getChildElements();
	  
		
					while (iterator.hasNext()) {
						
						MessageElement m1 = (MessageElement) iterator.next();
			             count=m1.getLength();
       			}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	
		logger.debug("the count is "+count);
	  
 		return String.valueOf(count);
 		
 		
 	}
 	
 	
 	
	//获取牛的产犊
	public static List<Cow> getCowCalvinginfos(String cowID)
	{
		List<Cow> cowinfos=new ArrayList();
		

		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnDataTableResponse response = client.getCowCalvingInfo(cowID);
		
			logger.debug("the code is "+response.getRtnCode());
			if (response.getRtnCode() != -1) {
				
				
		RtnDataTableResponseRtnDataTable tb1 = response.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				
				
				for (int i = 0; i < messageElement.length; i++) {
				Iterator iterator = messageElement[i].getChildElements();
	
					while (iterator.hasNext()) {
						MessageElement m1 = (MessageElement) iterator.next();
						m1 = m1.getRealElement();
						
						int count=m1.getLength();
					//	logger.debug("the m1 is "+m1.getName());
						Iterator it = m1.getChildElements();
						int jj = 0;
						while (it.hasNext()) {
							
				         Cow cow=new Cow();
						       jj++;
							MessageElement m2 = (MessageElement) it.next();
							
							
			
							logger.debug("the m2 is "+m2.getName());
							if (m2.getName().equals("Table")) {
								Iterator it1 = m2.getChildElements();
								int jjj = 0;
								String CalvingDate = "", CowID = "", CowBarn= "", BreedingDate = "", CattleType = "",  MilkStatus = "",BreedStatus = "", ChildTime  = "", FrozenSperm = "", Calvingtype  = "", CalvingNum  = "", CalvingDesc  = "",MidWife   = "", Operator = "";
								while (it1.hasNext()) {

									MessageElement m3 = (MessageElement) it1
											.next();

									switch (m3.getName()) {

									case "产犊日期":
										CalvingDate = FormateDate(m3.getValue());
										cow.setCalvingDate(CalvingDate);
										break;
									case "母牛号":
										CowID = m3.getValue();
										cow.setCowID(CowID);
										break;
									case "当前牛舍":
										CowBarn = m3.getValue();
										cow.setCowBarn(CowBarn);
										break;
									case "配种日期":
										BreedingDate = FormateDate(m3.getValue());
										cow.setBreedingDate(BreedingDate);
										break;
									case "牛只类别":
										CattleType = m3.getValue();
										cow.setCalvingtype(Calvingtype);
										break;
									case "泌乳状态":
										MilkStatus= m3.getValue();
								      cow.setMilkStatus(MilkStatus);
										break;
									case "繁殖状态":
										BreedStatus = m3.getValue();
										cow.setBreedStatus(BreedStatus);
										break;
									case "当前胎次":
										ChildTime = m3.getValue();
									cow.setChildTime(ChildTime);
										break;
								/**	case "最近干奶日期":
										LastDryMikeDate = m3.getValue().substring(0, );
										break; */
									case "冻精号":
										FrozenSperm = m3.getValue();
										 cow.setFrozenSperm(FrozenSperm);
										break;
									case "产犊类型":
										Calvingtype = m3.getValue();
									   cow.setCalvingtype(Calvingtype);
										break;
									case "产犊数":
										CalvingNum = m3.getValue();
										cow.setCalvingNum(CalvingNum);
										break;
									case "产犊描述":
										CalvingDesc = m3.getValue();
										cow.setCalvingDesc(CalvingDesc);
										break;
									case "助产员":
										MidWife = m3.getValue();
										cow.setMidWife(MidWife);
										break;
									case "操作员":
										Operator = m3.getValue();
										cow.setOperator(Operator);
										break;
									}
									jjj++;
								}
//		String CalvingDate = "", CowID = "", CowBarn= "", BreedingDate = "", CattleType = "",  MilkStatus = "",BreedStatus = "", ChildTime  = "", FrozenSperm = "", Calvingtype  = "", CalvingNum  = "", CalvingDesc  = "",MidWife   = "", Operator = "";
							/**
								result += "<tr>" + "<td>" + CalvingDate + "</td>"
										+ "<td>" + CowID + "</td>" + "<td>"+ CowBarn+"</td>" + "<td>"
										+ BreedingDate + "</td>" + "<td>" + CattleType+"</td>" 
									    + "<td>" + MilkStatus + "</td>"
										+ "<td>" + BreedStatus + "</td>" + "<td>"
								
										+ ChildTime + "</td>" + "<td>"
										+ FrozenSperm + "</td>" + "<td>"
										+ Calvingtype + "</td>" + "<td>"
										+ CalvingNum + "</td>" + "<td>"
										+ CalvingDesc + "</td>" + "<td>"
										+ MidWife + "</td>" + "<td>"
							         	+ Operator + "</td>" + "</tr>";
							         	*/
								cowinfos.add(cow);
				
						
							}
					
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		
		
		return cowinfos;
	}
 	
	public static CowInfo getCowCalvingInfoHtml(String farmName,String currtPage )
	{
		String result="";
		
		int pageSize=1;
		int nowPage=Integer.parseInt(currtPage);
		int curRow=(nowPage-1)*pageSize+1;
		CowInfo info=new CowInfo();
		
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnDataTableResponse response = client.getCowCalvingInfo(farmName);
		
			logger.debug("the code is "+response.getRtnCode());
			if (response.getRtnCode() != -1) {
				
				
		RtnDataTableResponseRtnDataTable tb1 = response.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				
				
				for (int i = 0; i < messageElement.length; i++) {
				Iterator iterator = messageElement[i].getChildElements();
	
					while (iterator.hasNext()) {
						MessageElement m1 = (MessageElement) iterator.next();
						m1 = m1.getRealElement();
						
						int count=m1.getLength();
					//	logger.debug("the m1 is "+m1.getName());
						Iterator it = m1.getChildElements();
						int jj = 0;
						while (it.hasNext()) {
							
				
						jj++;
							MessageElement m2 = (MessageElement) it.next();
							
							
							if((jj==nowPage*pageSize)&&(jj<=count))
							{	
							logger.debug("the m2 is "+m2.getName());
							if (m2.getName().equals("Table")) {
								Iterator it1 = m2.getChildElements();
								int jjj = 0;
								String CalvingDate = "", CowID = "", CowBarn= "", BreedingDate = "", CattleType = "",  MilkStatus = "",BreedStatus = "", ChildTime  = "", FrozenSperm = "", Calvingtype  = "", CalvingNum  = "", CalvingDesc  = "",MidWife   = "", Operator = "";
								while (it1.hasNext()) {

									MessageElement m3 = (MessageElement) it1
											.next();

									switch (m3.getName()) {

									case "产犊日期":
										CalvingDate = FormateDate(m3.getValue());
										 info.setTID1(CalvingDate);
										break;
									case "母牛号":
										CowID = m3.getValue();
										info.setCowID(CowID);
										break;
									case "当前牛舍":
										CowBarn = m3.getValue();
										info.setCurrGroup(CowBarn);
										break;
									case "配种日期":
										BreedingDate = FormateDate(m3.getValue());
										info.setTID2(BreedingDate);
										break;
									case "牛只类别":
										CattleType = m3.getValue();
										info.setCurrCategory(CattleType);
										break;
									case "泌乳状态":
										MilkStatus= m3.getValue();
										info.setGroCode(MilkStatus);
										break;
									case "繁殖状态":
										BreedStatus = m3.getValue();
										info.setRepCode(BreedingDate);
										break;
									case "当前胎次":
										ChildTime = m3.getValue();
										info.setCurrLact(Integer.parseInt(ChildTime));
										break;
								/**	case "最近干奶日期":
										LastDryMikeDate = m3.getValue().substring(0, );
										break; */
									case "冻精号":
										FrozenSperm = m3.getValue();
										info.setEarNO(FrozenSperm);
										break;
									case "产犊类型":
										Calvingtype = m3.getValue();
										info.setVariety(CalvingDate);
										break;
									case "产犊数":
										CalvingNum = m3.getValue();
										info.setBornLact(Integer.parseInt(CalvingNum));
										break;
									case "产犊描述":
										CalvingDesc = m3.getValue();
										info.setVarietyPurity(CalvingDesc);
										break;
									case "助产员":
										MidWife = m3.getValue();
										info.setColor(MidWife);
										break;
									case "操作员":
										Operator = m3.getValue();
										info.setLeftPerson(Operator);
										break;
									}
									jjj++;
								}
//		String CalvingDate = "", CowID = "", CowBarn= "", BreedingDate = "", CattleType = "",  MilkStatus = "",BreedStatus = "", ChildTime  = "", FrozenSperm = "", Calvingtype  = "", CalvingNum  = "", CalvingDesc  = "",MidWife   = "", Operator = "";
								result += "<tr>" + "<td>" + CalvingDate + "</td>"
										+ "<td>" + CowID + "</td>" + "<td>"+ CowBarn+"</td>" + "<td>"
										+ BreedingDate + "</td>" + "<td>" + CattleType+"</td>" 
									    + "<td>" + MilkStatus + "</td>"
										+ "<td>" + BreedStatus + "</td>" + "<td>"
									//	+ LastDryMikeDate + "</td>" + "<td>"
										+ ChildTime + "</td>" + "<td>"
										+ FrozenSperm + "</td>" + "<td>"
										+ Calvingtype + "</td>" + "<td>"
										+ CalvingNum + "</td>" + "<td>"
										+ CalvingDesc + "</td>" + "<td>"
										+ MidWife + "</td>" + "<td>"
							         	+ Operator + "</td>" + "</tr>";
								break;
						
							}
							}else {
								continue;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug(result);
		
		return info;
	//	return result;
		
		
	}

	//获取牧场病牛的数目
	public static String getDiseaseInfoCount(String farmName)
	{
	  int count=0;
		
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnDataTableResponse response = client.getDiseaseCowsInfo(farmName);
		
			logger.debug("the code is "+response.getRtnCode());
			if (response.getRtnCode() != -1) {
				
				
		RtnDataTableResponseRtnDataTable tb1 = response.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				
				
				for (int i = 0; i < messageElement.length; i++) {
				Iterator iterator = messageElement[i].getChildElements();
	  
		
					while (iterator.hasNext()) {
						
						MessageElement m1 = (MessageElement) iterator.next();
			             count=m1.getLength();
       			}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	
		logger.debug("the count is "+count);
	  
	  return   String.valueOf(count);
		
	}
	//获取牧场病牛
	public static String getDiseaseCowsInfoHtml(String farmName,String  currtPage)
	{
		
		int pageSize=20;
		int nowPage=Integer.parseInt(currtPage);
		int curRow=(nowPage-1)*pageSize+1;
		int mycount=0;
		logger.debug("the count is "+curRow+":"+nowPage*pageSize);
		String result="";
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			//RtnCowInfoReponse response = client.get (cowID);
			
			RtnDataTableResponse response = client.getDiseaseCowsInfo(farmName) ;

			if (response.getRtnCode() != -1) {
				
				
		RtnDataTableResponseRtnDataTable tb1 = response.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				
				
	//			for (int i = 0; i < messageElement.length; i++) {
				Iterator iterator = messageElement[1].getChildElements();
	
					while (iterator.hasNext()) {
						MessageElement m1 = (MessageElement) iterator.next();
						int   count=m1.getLength();
						logger.debug("the count is "+count);

											logger.debug("login ?"+curRow+":"+nowPage*pageSize+":"+count);
																		
																	m1 = m1.getRealElement();
													
																	
																	Iterator it = m1.getChildElements();
																	
																	int jj = 0;
																	while (it.hasNext()) {
																		jj++;
																		MessageElement m2 = (MessageElement) it.next();		
											           if((((nowPage-1)*pageSize<jj )&&(jj<=nowPage*pageSize))&&(jj<=count))
																			
															{
																		
															
																		
																		if (m2.getName().equals("Table")) {
																			Iterator it1 = m2.getChildElements();
																			int jjj = 0;
																			String CowID = "",OnsetDate="",OnsetDays  ="", CowBarn= "", CurrStatus = "",BreedStatus = "",MilkStatus = "",ChildTime  = "",OnsetPerson ="", DiseaseTypes  ="",DiseaseName ="", PrescriptionNum  = "",    PeriodTreatment  = "", RecentTreatmentDate   = "", LeftFrontArea   = "",RightFrontArea ="",AfterLeftArea ="",AfterRightArea="",Vet="",Outcome ="",WithdrawalDate="",afterAntiDateString="",FlagColumn="",ResistanceTestDate="", ResistanceTest = "" ;
																		
																			while (it1.hasNext()) {
											
																				 
																				MessageElement m3 = (MessageElement) it1
																						.next();
											
																				switch (m3.getName()) {
											
																				case "牛号":
																					CowID = m3.getValue();
																				
																					break;
																				case "发病日期":
																					OnsetDate =FormateDate (m3.getValue());
																					break;
																					
																				case "发病天数":
																					OnsetDays = m3.getValue();
																	
																					break;
																				case "当前牛舍":
																					CowBarn = m3.getValue();
																		
																					break;
																				case "当前状态":
																					CurrStatus = m3.getValue();
																			
																					break;
																		
																				case "泌乳状态":
																					MilkStatus= m3.getValue();
																			
																					break;
																				case "繁殖状态":
																					BreedStatus = m3.getValue();
																					
																					break;
																				case "当前胎次":
																					ChildTime = m3.getValue();
																		
																					break;
																	      	case "发病揭发人":
																	      		
																	      		OnsetPerson = m3.getValue();
																					break; 
																				case "疾病类型":
																					DiseaseTypes = m3.getValue();
																				
																					break;
																				case "疾病名称":
																					DiseaseName = m3.getValue();
																			
																					break;
																				case "处方编号":
																					PrescriptionNum = m3.getValue();
																			
																					break;
																				case "疗程":
																					PeriodTreatment = m3.getValue();
																		
																					break;
																				case "最近治疗日期":
																					RecentTreatmentDate = FormateDate(m3.getValue());//A?B:C
																			
																					break;
																				case "发病时左前区":
																					LeftFrontArea = m3.getValue();
																				
																					break;
																		
																				case "发病时右前区":
																					RightFrontArea = m3.getValue();
																				
																					break;
																				case "发病时左后区":
																					AfterLeftArea = m3.getValue();
																				
																					break;
																				case "发病时右后区":
																					AfterRightArea = m3.getValue();
																				
																					break;
																				case "兽医":
																					Vet = m3.getValue();
																				
																					break;
																				case "转归情况":
																					Outcome = m3.getValue();
																				
																					break;
																				case "停药日期":
																					WithdrawalDate =FormateDate(m3.getValue());
																				
																					break;
																				case "过抗日期":
																					afterAntiDateString = FormateDate(m3.getValue());
																				
																					break;
																				case "FlagColumn":
																					FlagColumn = m3.getValue();
																				
																					break;
																		
																				case "过抗检测日期":
																					ResistanceTestDate = FormateDate(m3.getValue());
																				
																					break;
																				case "过抗检测":
																					ResistanceTest = m3.getValue();
																				
																					break;
																				}
																				jjj++;
																			}
											
																			result += "<tr>" 
																					+ "<td>" + CowID + "</td>" + "<td>"+ OnsetDate+"</td>" + "<td>"
																					+ OnsetDays + "</td>" 
																					//+ "<td>" + CowBarn+"</td>" 
																				//	+"<td>"+CurrStatus+"</td>"
																				  //  + "<td>" + BreedStatus + "</td>"
																				//	+ "<td>" + MilkStatus + "</td>" + "<td>"
																		
																				//	+ ChildTime + "</td>" + "<td>"
																				//	+ OnsetPerson + "</td>" 
																					+ "<td>"
																					+ DiseaseTypes + "</td>" + "<td>"
																					+ DiseaseName + "</td>" //+ "<td>"
																				/**	+ PrescriptionNum + "</td>" + "<td>"
																					+ PeriodTreatment + "</td>" + "<td>"
																					+ RecentTreatmentDate + "</td>" + "<td>"
																					+ LeftFrontArea + "</td>" + "<td>"
																					+ RightFrontArea + "</td>" + "<td>"
																		         	+ AfterLeftArea + "</td>" +"<td>"
																		         	+ AfterRightArea + "</td>" +"<td>"
																		         	+ Vet + "</td>" +"<td>"
																		         	+ Outcome + "</td>" +"<td>"
																		         	+ WithdrawalDate + "</td>" +"<td>"
																		         	+ afterAntiDateString + "</td>" +"<td>"
																		         	+ FlagColumn + "</td>" +"<td>"
																		         	+ ResistanceTestDate + "</td>" +"<td>"
																		         	+ ResistanceTest + "</td>" */
																					
																					
																					+ "</tr>";
																	
																		}
									
														
																	}
																	else{
																		continue;
																	}
																	}
																} 
						
					
					

			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug(result);
		logger.debug("mycout is "+curRow);
		
		
		return result;
	}
	
	public static List<Cow> getDiseaseInfos(String farmName)
	{
		List<Cow> infoList=new ArrayList();

		String result="";
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			//RtnCowInfoReponse response = client.get (cowID);
			
			RtnDataTableResponse response = client.getDiseaseCowsInfo(farmName) ;

			if (response.getRtnCode() != -1) {
				
				
		RtnDataTableResponseRtnDataTable tb1 = response.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				
				
	//			for (int i = 0; i < messageElement.length; i++) {
				Iterator iterator = messageElement[1].getChildElements();
	
					while (iterator.hasNext()) {
						MessageElement m1 = (MessageElement) iterator.next();
						int   count=m1.getLength();
						logger.debug("the count is "+count);

							
																		
																	m1 = m1.getRealElement();
													
																	
																	Iterator it = m1.getChildElements();
																	
																	int jj = 0;
								              while (it.hasNext()) {
								            	  //迭代多少次就有多少条
								            	  Cow info=new Cow();
								            	  
																		jj++;
																		MessageElement m2 = (MessageElement) it.next();		
											
																		
													 	if (m2.getName().equals("Table")) {
																			Iterator it1 = m2.getChildElements();
																			int jjj = 0;
																			String CowID = "",OnsetDate="",OnsetDays  ="", CowBarn= "", CurrStatus = "",BreedStatus = "",MilkStatus = "",ChildTime  = "",OnsetPerson ="", DiseaseTypes  ="",DiseaseName ="", PrescriptionNum  = "",    PeriodTreatment  = "", RecentTreatmentDate   = "", LeftFrontArea   = "",RightFrontArea ="",AfterLeftArea ="",AfterRightArea="",Vet="",Outcome ="",WithdrawalDate="",afterAntiDateString="",FlagColumn="",ResistanceTestDate="", ResistanceTest = "" ;
																		
																			while (it1.hasNext()) {
											
																				 
																				MessageElement m3 = (MessageElement) it1
																						.next();
											
																				switch (m3.getName()) {
											
																				case "牛号":
																					CowID = m3.getValue();
																					info.setCowID(CowID);
																				
																					break;
																				case "发病日期":
																					OnsetDate =FormateDate (m3.getValue());
																					info.setOnsetDate(OnsetDate);
																				
																					break;
																					
																				case "发病天数":
																					OnsetDays = m3.getValue();
																	             info.setOnsetDays(OnsetDays);
																					break;
																				case "当前牛舍":
																					CowBarn = m3.getValue();
																					info.setCowBarn(CowBarn);
																		
																					break;
																				case "当前状态":
																					CurrStatus = m3.getValue();
																			       info.setCurrStatus(CurrStatus);
																					break;
																		
																				case "泌乳状态":
																					MilkStatus= m3.getValue();
																					info.setMilkStatus(MilkStatus);
																					//info.set
																			
																					break;
																				case "繁殖状态":
																					BreedStatus = m3.getValue();
																					info.setBreedStatus(BreedStatus);
																					break;
																				case "当前胎次":
																					ChildTime = m3.getValue();
																					info.setChildTime(ChildTime);
																		
																					break;
																	      	case "发病揭发人":
																	      		
																	      		OnsetPerson = m3.getValue();
																				info.setOnsetPerson(OnsetPerson);	
																	      		break; 
																				case "疾病类型":
																					DiseaseTypes = m3.getValue();
																				  info.setDiseaseTypes(DiseaseTypes);
																					break;
																				case "疾病名称":
																					DiseaseName = m3.getValue();
																			       info.setDiseaseName(DiseaseName);
																					break;
																				case "处方编号":
																					PrescriptionNum = m3.getValue();
																					info.setPrescriptionNum(PrescriptionNum);
																			
																					break;
																				case "疗程":
																					PeriodTreatment = m3.getValue();
																		           info.setPeriodTreatment(PeriodTreatment);
																					break;
																				case "最近治疗日期":
																					RecentTreatmentDate = FormateDate(m3.getValue());//A?B:C
																			         info.setRecentTreatmentDate(RecentTreatmentDate);
																					break;
																				case "发病时左前区":
																					LeftFrontArea = m3.getValue();
																					info.setLeftFrontArea(LeftFrontArea);
																				
																					break;
																		
																				case "发病时右前区":
																					RightFrontArea = m3.getValue();
																				   info.setRightFrontArea(RightFrontArea);
																					break;
																				case "发病时左后区":
																					AfterLeftArea = m3.getValue();
																				  info.setAfterLeftArea(AfterLeftArea);
																					break;
																				case "发病时右后区":
																					AfterRightArea = m3.getValue();
																					info.setAfterRightArea(AfterRightArea);
																				
																					break;
																				case "兽医":
																					Vet = m3.getValue();
																					info.setVet(Vet);
																				
																					break;
																				case "转归情况":
																					Outcome = m3.getValue();
																				    info.setOutcome(Outcome);
																					break;
																				case "停药日期":
																					WithdrawalDate =FormateDate(m3.getValue());
																				   info.setWithdrawalDate(WithdrawalDate);
																					break;
																				case "过抗日期":
																					afterAntiDateString = FormateDate(m3.getValue());
																				  info.setAfterAntiDateString(afterAntiDateString);
																					break;
																				case "FlagColumn":
																					FlagColumn = m3.getValue();
																					info.setFlagColumn(FlagColumn);
																				
																					break;
																		
																				case "过抗检测日期":
																					ResistanceTestDate = FormateDate(m3.getValue());
																				   info.setResistanceTestDate(ResistanceTestDate);
																					break;
																				case "过抗检测":
																					ResistanceTest = m3.getValue();
																				  info.setResistanceTest(ResistanceTest);
																					break;
																				}
																				jjj++;
																			}
											
										                            infoList.add(info);
																	
																		}
									
														
															
																	}
																} 
						
					
					

			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}


		
		
		
		
		
		return infoList;
		
	}
	
	//获取牛离场
	public static CowInfo getCowLeftInfoHtml(String cowID)
	{
		String result="";
	       CowInfo		cowInfo = new CowInfo();
		
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			//RtnCowInfoReponse response = client.get (cowID);
			
			RtnDataTableResponse response = client.getCowLeftInfo(cowID);


		  
			
			

			logger.debug("the code is "+response.getRtnCode());
			if (response.getRtnCode() != -1) {
				
				
		RtnDataTableResponseRtnDataTable tb1 = response.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				
				
				for (int i = 0; i < messageElement.length; i++) {
				Iterator iterator = messageElement[i].getChildElements();
	
					while (iterator.hasNext()) {
						MessageElement m1 = (MessageElement) iterator.next();
						m1 = m1.getRealElement();
					//	logger.debug("the m1 is "+m1.getName());
						Iterator it = m1.getChildElements();
						int jj = 0;
						while (it.hasNext()) {
							MessageElement m2 = (MessageElement) it.next();
							logger.debug("the m2 is "+m2.getName());
							if (m2.getName().equals("Table")) {
								Iterator it1 = m2.getChildElements();
								int jjj = 0;
								String CowID = "",LeftDate="",CurrentFarm ="", CowBarn= "", CattleType = "",MilkStatus = "",BreedStatus = "",ChildTime  = "",ProhibitedDate="", ProhibitedReason ="",ExitWay ="", LeaveTo  = "",    LeaveReason = "", ProcessingOpinion  = "", IsOut  = "",  Operator = "",LeaveMonths="" ;
								Calendar dayc1 = new GregorianCalendar();
								 
								DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
								Date date=new Date();
			
								
								
								while (it1.hasNext()) {

									MessageElement m3 = (MessageElement) it1
											.next();

									switch (m3.getName()) {

									case "牛号":
										CowID = m3.getValue();
										cowInfo.setCowID(CowID);
										break;
									case "离场日期":
										LeftDate = FormateDate(m3.getValue());
										//Calendar dayc1 = new GregorianCalendar();
										 
										// df = new SimpleDateFormat("yyyy-MM-dd");
										// date=df.parse(LeftDate);
									//	dayc1.setTime(date);
										//cowInfo.setLeftDate(dayc1);
										cowInfo.setVariety(LeftDate);
										break;
										
									case "当前牧场":
										CurrentFarm = m3.getValue();
										cowInfo.setCurrFarm(CurrentFarm);
										break;
									case "当前牛舍":
										CowBarn = m3.getValue();
										cowInfo.setCurrGroup(CowBarn);
										break;
									case "牛只类别":
										CattleType = m3.getValue();
										cowInfo.setCurrCategory(CattleType);
										break;
							
									case "泌乳状态":
										MilkStatus= m3.getValue();
										cowInfo.setGroCode(MilkStatus);
										break;
									case "繁殖状态":
										BreedStatus = m3.getValue();
										cowInfo.setRepCode(BreedStatus);
										break;
									case "当前胎次":
										ChildTime = m3.getValue();
										cowInfo.setCurrLact( Integer.parseInt(ChildTime));
										break;
						      	case "禁配日期":
						      		ProhibitedDate = FormateDate(m3.getValue());
									//Calendar dayc1 = new GregorianCalendar();
									 
									//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
							    	 //date=df.parse(ProhibitedDate);
									//dayc1.setTime(date);
							       cowInfo.setVarietyPurity(ProhibitedDate);
									
									
										break; 
									case "禁配原因":
										ProhibitedReason = m3.getValue();
										cowInfo.setNomateReason(ProhibitedReason);
										break;
									case "离场方式":
										ExitWay = m3.getValue();
										cowInfo.setTID1(ExitWay);
										break;
									case "离场去向":
										LeaveTo = m3.getValue();
									  cowInfo.setLeftWhere(LeaveTo);
										break;
									case "离场原因":
										LeaveReason = m3.getValue();
										cowInfo.setLeftReason(LeaveReason);
										break;
									case "处理意见":
										ProcessingOpinion = m3.getValue()!=null?m3.getValue():"";//A?B:C
										cowInfo.setEPC(ProcessingOpinion);
										break;
									case "是否主动淘汰":
										IsOut = m3.getValue();
										cowInfo.setEarNO(IsOut);
										break;
							
									case "操作员":
										Operator = m3.getValue();
										cowInfo.setLeftPerson(Operator);
										break;
									case "离场月龄":
										LeaveMonths = m3.getValue();
										cowInfo.setColor(LeaveMonths);
										break;
									}
									jjj++;
								}
//		String CowID = "",LeftDate="",CurrentFarm ="", CowBarn= "", CattleType = "",MilkStatus = "",BreedStatus = "",ChildTime  = "",ProhibitedDate="", ProhibitedReason ="",ExitWay ="", LeaveTo  = "",    LeaveReason = "", ProcessingOpinion  = "", IsOut  = "",  Operator = "",LeaveMonths ;
								result += "<tr>" //+ "<td>" + CowID + "</td>"
										+ "<td>" + LeftDate + "</td>" + "<td>"+ CurrentFarm+"</td>" + "<td>"
										+ CowBarn + "</td>" + "<td>" + CattleType+"</td>" 
									    + "<td>" + MilkStatus + "</td>"
										+ "<td>" + BreedStatus + "</td>" + "<td>"
									//	+ LastDryMikeDate + "</td>" + "<td>"
										+ ChildTime + "</td>" + "<td>"
										+ ProhibitedDate + "</td>" + "<td>"
										+ ProhibitedReason + "</td>" + "<td>"
										+ ExitWay + "</td>" + "<td>"
										+ LeaveTo + "</td>" + "<td>"
										+ LeaveReason + "</td>" + "<td>"
										+ ProcessingOpinion + "</td>" + "<td>"
										+ IsOut + "</td>" + "<td>"
										+ Operator + "</td>" + "<td>"
							         	+ LeaveMonths + "</td>" + "</tr>";
						
							}

						}
					}
				}
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug(result);
		
		
		 return cowInfo;
		//return result;
	}
	
	//获取疾病牛
	public static String getDiseaseInfoHtml(String cowID) {
		String result = "";
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnDataTableResponse response = client.getCowDiseaseInfo(cowID);
			if (response.getRtnCode() != -1) {
				RtnDataTableResponseRtnDataTable tb1 = response
						.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				for (int i = 0; i < messageElement.length; i++) {
					Iterator iterator = messageElement[i].getChildElements();
					while (iterator.hasNext()) {
						MessageElement m1 = (MessageElement) iterator.next();
						m1 = m1.getRealElement();
						Iterator it = m1.getChildElements();
						int jj = 0;
						while (it.hasNext()) {
							MessageElement m2 = (MessageElement) it.next();
							if (m2.getName().equals("Table")) {
								Iterator it1 = m2.getChildElements();
								int jjj = 0;
								String DT = "", MonthOld = "", CowKind = "", GroCode = "", RepCode = "", CurrLact = "", DiseaseType = "", DiseaseName = "", ReturnInfo = "", Veterinary = "";
								while (it1.hasNext()) {

									MessageElement m3 = (MessageElement) it1
											.next();

									switch (m3.getName()) {

									case "发病日期":
										DT =FormateDate (m3.getValue());
										break;
									case "发病时月龄":
										MonthOld = m3.getValue();
										break;
									case "牛只类别":
										CowKind = m3.getValue();
										break;
									case "泌乳状态":
										GroCode = m3.getValue();
										break;
									case "繁殖状态":
										RepCode = m3.getValue();
										break;
									case "当前胎次":
										CurrLact = m3.getValue();
										break;
									case "疾病类型":
										DiseaseType = m3.getValue();
										break;
									case "疾病名称":
										DiseaseName = m3.getValue();
										break;
									case "转归情况":
										ReturnInfo = m3.getValue();
										break;
									case "兽医":
										Veterinary = m3.getValue();
										break;
									}
									jjj++;
								}

			 
								result += "<tr>" + "<td>" + DT + "</td>"
										+ "<td>" + MonthOld + "</td>" + "<td>"
										+ CowKind + "</td>" + "<td>" + GroCode
										+ "</td>" + "<td>" + RepCode + "</td>"
										+ "<td>" + CurrLact + "</td>" + "<td>"
										+ DiseaseType + "</td>" + "<td>"
										+ DiseaseName + "</td>" + "<td>"
										+ ReturnInfo + "</td>" + "<td>"
										+ Veterinary + "</td>" + "</tr>";
										
						
								
								/**
								jj++;
								if(jj%2!=0){
									
									result += "<tr>" + "<td bgcolor=\"cac4b2\">" + DT + "</td>"
											+ "<td bgcolor=\"cac4b2\">" + MonthOld + "</td>" + "<td bgcolor=\"cac4b2\">"
											+ CowKind + "</td>" + "<td bgcolor=\"cac4b2\">" + GroCode
											+ "</td>" + "<td bgcolor=\"cac4b2\">" + RepCode + "</td>"
											+ "<td bgcolor=\"cac4b2\">" + CurrLact + "</td>" + "<td bgcolor=\"cac4b2\">"
											+ DiseaseType + "</td>" + "<td bgcolor=\"cac4b2\">"
											+ DiseaseName + "</td>" + "<td bgcolor=\"cac4b2\">"
											+ ReturnInfo + "</td>" + "<td bgcolor=\"cac4b2\">"
											+ Veterinary + "</td>" + "</tr>";
								}else {
									result += "<tr>" + "<td bgcolor=\"a69c7f\">" + DT + "</td>"
											+ "<td bgcolor=\"a69c7f\">" + MonthOld + "</td>" + "<td bgcolor=\"a69c7f\">"
											+ CowKind + "</td>" + "<td bgcolor=\"a69c7f\">" + GroCode
											+ "</td>" + "<td bgcolor=\"a69c7f\">" + RepCode + "</td>"
											+ "<td bgcolor=\"a69c7f\">" + CurrLact + "</td>" + "<td bgcolor=\"a69c7f\">"
											+ DiseaseType + "</td>" + "<td bgcolor=\"a69c7f\">"
											+ DiseaseName + "</td>" + "<td bgcolor=\"a69c7f\">"
											+ ReturnInfo + "</td>" + "<td bgcolor=\"a69c7f\">"
											+ Veterinary + "</td>" + "</tr>";
									
								}*/
								
							}

						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug(result);
		return result;
	}

	//疾病牛文本
	public static String getDiseaseInfo(String cowID){
		String result="";
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnDataTableResponse response = client.getCowDiseaseInfo(cowID);
			if (response.getRtnCode() != -1) {
				RtnDataTableResponseRtnDataTable tb1 = response
						.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				for (int i = 0; i < messageElement.length; i++) {
					Iterator iterator = messageElement[i].getChildElements();
					while (iterator.hasNext()) {
						MessageElement m1 = (MessageElement) iterator.next();
						m1 = m1.getRealElement();
						Iterator it = m1.getChildElements();
						int jj = 0;
						while (it.hasNext()) {
							MessageElement m2 = (MessageElement) it.next();
							if (m2.getName().equals("Table")) {
								Iterator it1 = m2.getChildElements();
								int jjj = 0;
								String DT = "", MonthOld = "", CowKind = "", GroCode = "", RepCode = "", CurrLact = "", DiseaseType = "", DiseaseName = "", ReturnInfo = "", Veterinary = "";
								while (it1.hasNext()) {

									MessageElement m3 = (MessageElement) it1
											.next();

									switch (m3.getName()) {

									case "发病日期":
										DT ="发病日期 :"+ FormateDate(m3.getValue())+"\n";
										break;
									case "发病时月龄":
										MonthOld = "发病时月龄 :"+ m3.getValue()+"\n";
										break;
									case "牛只类别":
										CowKind = "牛只类别 :"+m3.getValue()+"\n";
										break;
									case "泌乳状态":
										GroCode ="泌乳状态 :"+ m3.getValue()+"\n";
										break;
									case "繁殖状态":
										RepCode ="繁殖状态 :"+ m3.getValue()+"\n";
										break;
									case "当前胎次":
										CurrLact = "当前胎次 :"+m3.getValue()+"\n";
										break;
									case "疾病类型":
										DiseaseType ="疾病类型 :"+ m3.getValue()+"\n";
										break;
									case "疾病名称":
										DiseaseName = "疾病名称 :"+m3.getValue()+"\n";
										break;
									case "转归情况":
										ReturnInfo ="转归情况 :"+ m3.getValue()+"\n";
										break;
									case "兽医":
										Veterinary ="兽医 :"+ m3.getValue()+"\n";
										break;
									}
									jjj++;
								}

								result =  DT + MonthOld 
										+ CowKind + GroCode
										 + RepCode + CurrLact 
										+ DiseaseType 
										+ DiseaseName 
										+ ReturnInfo 
										+ Veterinary;
							}

						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug(result);
		if(result!=""){
		return  "最近一次疾病事件如下：\n" +result+"\n 更多信息请点击图片查询 ";
		}else{
			
			return "未找到牛只信息";
		}
	}
	
	//牛的繁殖信息
	public static String getBreedingInfoHtml(String cowID) {
		String result = "";
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnDataTableResponse response = client.getCowBreedingInfo(cowID);
			if (response.getRtnCode() != -1) {
				RtnDataTableResponseRtnDataTable tb1 = response
						.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				for (int i = 0; i < messageElement.length; i++) {
					Iterator iterator = messageElement[i].getChildElements();
					while (iterator.hasNext()) {
						MessageElement m1 = (MessageElement) iterator.next();
						m1 = m1.getRealElement();
						Iterator it = m1.getChildElements();
						int jj = 0;
						while (it.hasNext()) {
							MessageElement m2 = (MessageElement) it.next();
							if (m2.getName().equals("Table")) {
								Iterator it1 = m2.getChildElements();
								int jjj = 0;
								String Proceeding = "", DT = "", CowKind = "", GroCode = "", RepCode = "", CurrLact = "", DetailInfo = "";
								while (it1.hasNext()) {

									MessageElement m3 = (MessageElement) it1
											.next();

									switch (m3.getName()) {
									case "进程":
										Proceeding = m3.getValue();
										break;
									case "事件日期":
										DT = FormateDate(m3.getValue());
										break;
									case "当时牛只类别":
										CowKind = m3.getValue();
										break;
									case "当时泌乳状态":
										GroCode = m3.getValue();
										break;
									case "当时繁殖状态":
										RepCode = m3.getValue();
										break;
									case "当时胎次":
										CurrLact = m3.getValue();
										break;
									case "详细信息":
										DetailInfo = m3.getValue();
										break;
									}
									jjj++;
								}
								
							
								result += "<tr>" + "<td>" + Proceeding
										+ "</td>" + "<td>" + DT + "</td>"
										+ "<td>" + CowKind + "</td>" + "<td>"
										+ GroCode + "</td>" + "<td>" + RepCode
										+ "</td>" + "<td>" + CurrLact + "</td>"
										+ "<td>" + DetailInfo + "</td>"
										+ "</tr>";
										
									
								/**
								jj++;
								if(jj%2!=0){
								result += "<tr>" + "<td  bgcolor=\"cac4b2\">" + Proceeding
										+ "</td>" + "<td bgcolor=\"cac4b2\">" + DT + "</td>"
										+ "<td bgcolor=\"cac4b2\">" + CowKind + "</td>" + "<td bgcolor=\"cac4b2\">"
										+ GroCode + "</td>" + "<td bgcolor=\"cac4b2\">" + RepCode
										+ "</td>" + "<td bgcolor=\"cac4b2\">" + CurrLact + "</td>"
										+ "<td bgcolor=\"cac4b2\">" + DetailInfo + "</td>"
										+ "</tr>";
								}else{
									 
									result += "<tr>" + "<td  bgcolor=\"a69c7f\">" + Proceeding
											+ "</td>" + "<td bgcolor=\"a69c7f\">" + DT + "</td>"
											+ "<td bgcolor=\"a69c7f\">" + CowKind + "</td>" + "<td bgcolor=\"a69c7f\">"
											+ GroCode + "</td>" + "<td bgcolor=\"a69c7f\">" + RepCode
											+ "</td>" + "<td bgcolor=\"a69c7f\">" + CurrLact + "</td>"
											+ "<td bgcolor=\"a69c7f\">" + DetailInfo + "</td>"
											+ "</tr>";
								}
								*/
							}

						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug(result);
		return result;
	}

	//繁殖牛文本
	public static String getBreedingInfo(String cowID){
		String result="";
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnDataTableResponse response = client.getCowBreedingInfo(cowID);
			if (response.getRtnCode() != -1) {
				RtnDataTableResponseRtnDataTable tb1 = response
						.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				
				for (int i = 0; i < messageElement.length; i++) {
					Iterator iterator = messageElement[i].getChildElements();
					while (iterator.hasNext()) {
						MessageElement m1 = (MessageElement) iterator.next();
						m1 = m1.getRealElement();
						Iterator it = m1.getChildElements();
						int jj = 0;
						while (it.hasNext()) {
							MessageElement m2 = (MessageElement) it.next();
							if (m2.getName().equals("Table")) {
								Iterator it1 = m2.getChildElements();
								int jjj = 0;
								String Proceeding = "", DT = "", CowKind = "", GroCode = "", RepCode = "", CurrLact = "", DetailInfo = "";
								while (it1.hasNext()) {

									MessageElement m3 = (MessageElement) it1
											.next();

									switch (m3.getName()) {
									case "进程":
										Proceeding ="进程: "+ m3.getValue()+"\n";
										break;
									case "事件日期":
										DT = "事件日期: "+FormateDate(m3.getValue())+"\n";
										break;
									case "当时牛只类别":
										CowKind ="当时牛只状态: "+ m3.getValue()+"\n";
										break;
									case "当时泌乳状态":
										GroCode = "当时泌乳状态: "+m3.getValue()+"\n";
										break;
									case "当时繁殖状态":
										RepCode = "当时繁殖状态: "+m3.getValue()+"\n";
										break;
									case "当时胎次":
										CurrLact = "当时胎次："+m3.getValue()+"\n";
										break;
									case "详细信息":
										DetailInfo = "详细信息: "+m3.getValue()+"\n";
										break;
									}
									jjj++;
								}
								result = Proceeding
										+ DT +  CowKind + 
										GroCode + RepCode
										 + CurrLact  + DetailInfo ;
							}

						}
					}
				}
			}else{
				
				result = response.getRtnMessage();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug(result);
		if(result!=""){
		return "最近一次繁殖事件如下：\n" +result+"\n 更多信息请点击图片查询 ";
		}else{
			
			return "未找到相应牛只信息";
		}
	}
	
	
	public static String getCowBlindInfoHTML(String cowID) {
		String result = "";
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnDataTableResponse response = client.getCowBlindInfo(cowID);
			if (response.getRtnCode() != -1) {
				RtnDataTableResponseRtnDataTable tb1 = response
						.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				for (int i = 0; i < messageElement.length; i++) {
					Iterator iterator = messageElement[i].getChildElements();
					
					//logger.debug("xxxxxx is "+messageElement[i]);
					
					while (iterator.hasNext()) {
						MessageElement m1 = (MessageElement) iterator.next();
						m1 = m1.getRealElement();
						Iterator it = m1.getChildElements();
						int jj = 0;
						while (it.hasNext()) {
							MessageElement m2 = (MessageElement) it.next();
							if (m2.getName().equals("Table")) {
								Iterator it1 = m2.getChildElements();
								int jjj = 0;
								String CkDT = "", Farm = "", CowDorm = "",CowKind = "", GroCode = "", RepCode = "", CurLact = "", LftBfArea = "", LftBfDt = "",LftBfMk = "";
								String RtBfArea = "", RtBfDt = "",RtBfMk = "",LftAftArea = "", LftAftDt = "",LftAftMk = "",RtAftArea = "", RtAftDt = "",RtAftMk = "";
								String IsLeft = "", LftDt="";
								while (it1.hasNext()) {

									MessageElement m3 = (MessageElement) it1
											.next();

									switch (m3.getName()) {
									case "检测日期":
										CkDT = FormateDate(m3.getValue());
										break;
									case "所在牧场":
										Farm = m3.getValue();
										break;
									case "当前牛舍":
										CowDorm = m3.getValue();
										break;
									case "牛只类别":
										CowKind = m3.getValue();
										break;
									case "泌乳状态":
										GroCode = m3.getValue();
										break;
									case "繁殖状态":
										RepCode = m3.getValue();
										break;
									case "当前胎次":
										CurLact = m3.getValue();
										break;
									case "左前乳区":
										LftBfArea = m3.getValue();
										break;
									case "左前标记日期":
										LftBfDt = FormateDate(m3.getValue());
										break;
									case "左前标记人":
										LftBfMk = m3.getValue();
										break;
									case "右前乳区":
										RtBfArea = m3.getValue();
										break;
									case "右前标记日期":
										RtBfDt =FormateDate( m3.getValue());
										break;
									case "右前标记人":
										RtBfMk = m3.getValue();
										break;
									case "左后乳区":
										LftAftArea = m3.getValue();
										break;
									case "左后标记日期":
										LftAftDt = FormateDate(m3.getValue());
										break;
									case "左后标记人":
										LftAftMk = m3.getValue();
										
										break;
									case "右后乳区":
										RtAftArea = m3.getValue();
										break;
									case "右后标记日期":
										RtAftDt = FormateDate(m3.getValue());
										break;
									case "右后标记人":
										RtAftMk = m3.getValue();
										
										break;
									case "是否离场":
										IsLeft = m3.getValue();
										break;
									case "离场日期":
										LftDt = FormateDate(m3.getValue());
										break;
									}
									
									jjj++;
								}
								/*result += "<tr>" 
										+ "<td>" + CkDT + "</td>"
										+ "<td>" + Farm + "</td>" + "<td>"
										+ CowDorm + "</td>" +"<td>"
										+ CowKind + "</td>" + "<td>"
										+ GroCode+ "</td>" + "<td>"
										+ RepCode + "</td>"
										+ "<td>" + CurLact + "</td>" + "<td>"
										+ LftBfArea + "</td>"  + "<td>"
										+ LftBfDt + "</td>"+ "<td>"
										+ LftBfMk + "</td>"+ "<td>"
										+ RtBfArea + "</td>" + "<td>"
										+ RtBfDt + "</td>"+ "<td>"
										+ RtBfMk + "</td>" + "<td>"
										+ LftAftArea + "</td>"  + "<td>"
										+ LftAftDt + "</td>"+ "<td>"
										+ LftAftMk + "</td>"+ "<td>"
										+ RtAftArea + "</td>"  + "<td>"
										+ RtAftDt + "</td>"+ "<td>"
										+ RtAftMk + "</td>"+ "<td>"
										+ IsLeft + "</td>"+ "<td>"
										+ LftDt + "</td>"+ "</tr>";*/
								result += "<tr><td>检测日期</td><td>"+ CkDT +"</td></tr>"
										+ "<tr><td>所在牧场</td><td>"+ Farm +"</td></tr>"
										+ "<tr><td>当前牛舍</td><td>"+ CowDorm +"</td></tr>"
										+ "<tr><td>牛只类别</td><td>"+ CowKind +"</td></tr>"
										+ "<tr><td>泌乳状态</td><td>"+ GroCode +"</td></tr>"
										+ "<tr><td>繁殖状态</td><td>"+ RepCode +"</td></tr>"
										+ "<tr><td>当前胎次</td><td>"+ CurLact +"</td></tr>"
										+ "<tr><td>左前乳区</td><td>"+ LftBfArea +"</td></tr>"
										+ "<tr><td>左前标记日期</td><td>"+ LftBfDt +"</td></tr>"
										+ "<tr><td>左前标记人</td><td>"+ LftBfMk +"</td></tr>"
										+ "<tr><td>右前乳区</td><td>"+ RtBfArea +"</td></tr>"
										+ "<tr><td>右前标记日期</td><td>"+ RtBfDt +"</td></tr>"
										+ "<tr><td>右前标记人</td><td>"+ RtBfMk +"</td></tr>"
										+ "<tr><td>左后乳区</td><td>"+ LftAftArea +"</td></tr>"
										+ "<tr><td>左后标记日期</td><td>"+ LftAftDt +"</td></tr>"
										+ "<tr><td>左后标记人</td><td>"+ LftAftMk +"</td></tr>"
										+ "<tr><td>右后乳区</td><td>"+ RtAftArea +"</td></tr>"
										+ "<tr><td>右后标记日期</td><td>"+ RtAftDt +"</td></tr>"
										+ "<tr><td>右后标记人</td><td>"+ RtAftMk +"</td></tr>"
										+ "<tr><td>是否离场</td><td>"+ IsLeft +"</td></tr>"
										+ "<tr><td>离场日期</td><td>"+ LftDt +"</td></tr>";
							}

						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug(result);
		return result;
	}
	//查询指定牛号的犊牛断奶信息
	public static String getCowWeaningInfoHTML(String cowID) {
		String result = "";
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnDataTableResponse response = client.getCowWeaningInfo(cowID);
			if (response.getRtnCode() != -1) {
				RtnDataTableResponseRtnDataTable tb1 = response
						.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				for (int i = 0; i < messageElement.length; i++) {
					Iterator iterator = messageElement[i].getChildElements();
					while (iterator.hasNext()) {
						MessageElement m1 = (MessageElement) iterator.next();
						m1 = m1.getRealElement();
						Iterator it = m1.getChildElements();
						int jj = 0;
						while (it.hasNext()) {
							MessageElement m2 = (MessageElement) it.next();
							if (m2.getName().equals("Table")) {
								Iterator it1 = m2.getChildElements();
								int jjj = 0;
								String WeaningDT = "", CowID = "", Farm ="",CowDorm = "", FeedDays = "", WeaningWeit = "", MilkWeit = "", Feeder = "";
								while (it1.hasNext()) {

									MessageElement m3 = (MessageElement) it1
											.next();

									switch (m3.getName()) {

									case "断奶日期":
										WeaningDT = FormateDate(m3.getValue());
										break;
									case "牛号":
										CowID = m3.getValue();
										break;
									case "所在牧场":
										Farm = m3.getValue();
										break;
									case "当前牛舍":
										CowDorm = m3.getValue();
										break;
									case "哺乳天数":
										FeedDays = m3.getValue();
										break;
									case "断奶时体重":
										WeaningWeit = m3.getValue();
										break;
									case "犊牛期喂奶量":
										MilkWeit = m3.getValue();
										break;
									case "饲养员":
										Feeder = m3.getValue();
										break;
									}
									jjj++;
								}
                                /**
								result += "<tr>" + "<td>" + WeaningDT + "</td>"
										+ "<td>" + CowID + "</td>" + "<td>"
										+ Farm + "</td>" + "<td>" + CowDorm
										+ "</td>" + "<td>" + FeedDays + "</td>"
										+ "<td>" + WeaningWeit + "</td>" + "<td>"
										+ MilkWeit + "</td>" + "<td>"
										+ Feeder + "</td></tr>";
										
										*/
								result+="<tr><td> 断奶日期</td><td>"+WeaningDT+"</td></tr>"
										+"<tr><td> 牛号</td><td>"+CowID+"</td></tr>"
										+"<tr><td>所在农场</td><td>"+Farm+"</td></tr>"
										+"<tr><td> 当前牛舍</td><td>"+CowDorm+"</td></tr>"
										+"<tr><td>哺乳天数 </td><td>"+FeedDays+"</td></tr>"
										+"<tr><td> 断奶时体重</td><td>"+WeaningWeit+"</td></tr>"
								          +"<tr><td> 犊牛期喂奶量</td><td>"+MilkWeit+"</td></tr>"
								        +"<tr><td> 饲养员</td><td>"+Feeder+"</td></tr>";
							}

						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug(result);
		return result;
	}
	
	
	
	//获取牛的信息
	public static String getCowInfo(String cowID) {
		logger.debug("getCowInfo in________");
		
		String result = "";
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnCowInfoReponse response1 = client.getCowInfoByCowID(cowID);
			logger.debug(response1.getRtnCode());
			//只要code部位-1就是成功
			if (response1.getRtnCode() != -1) {
				CowInfo cowInfo = response1.getRtnCowInfo();
				result += "牛号:" + cowID + "\n";
				if (cowInfo.isSex()) {
					result += "性别:公\n";
				} else {
					result += "性别:母\n";
				}
				if (!cowInfo.getCurrFarm().equals(""))
					result += "当前牧场:" + cowInfo.getCurrFarm() + "\n";
				if (!cowInfo.getCurrGroup().equals(""))
					result += "当前牛舍:" + cowInfo.getCurrGroup() + "\n";
				if (!cowInfo.getLastFindGroupNO().equals(""))
					result += "最后发现牛舍:" + cowInfo.getLastFindGroupNO() + "\n";
				String dt01 = Services.GetDate(cowInfo.getLastFindTime());
				if (!dt01.equals("1-1-1"))
					result += "最后发现时间:" + dt01 + "\n";
				dt01 = Services.GetDate(cowInfo.getEnterDate());
				if (!dt01.equals("1-1-1"))
					result += "进场日期:" + dt01 + "\n";

				result += "出生胎次:" + cowInfo.getBornLact() + "\n";

				result += "当前胎次:" + cowInfo.getCurrLact() + "\n";

				String dt1 = Services.GetDate(cowInfo.getBirthday());
				if (!dt1.equals("1-1-1"))
					result += "出生日期:" + dt1 + "\n";
				dt1 = Services.GetDate(cowInfo.getLastCalvDate());
				if (!dt1.equals("1-1-1"))
					result += "最近分娩日期:" + dt1 + "\n";

				result += "初生重:" + cowInfo.getBornWeight() + "\n";

				result += "落地价:" + cowInfo.getBornValue() + "\n";
				if (cowInfo.isIsET()) {
					result += "是否ET牛:是\n";
				} else {
					result += "是否ET牛:否\n";
				}
				if (cowInfo.isIsTwin()) {
					result += "是否双胞胎:是\n";
				} else {
					result += "是否双胞胎:否\n";
				}
				if (cowInfo.isIsInsurance()) {
					result += "是否保险:是\n";
				} else {
					result += "是否保险:否\n";
				}

				if (!cowInfo.getCurrCategory().equals(""))
					result += "当前状态:" + cowInfo.getCurrCategory() + "\n";

				String dt3 = Services.GetDate(cowInfo.getAblactDate());
				if (!dt3.equals("1-1-1"))
					result += "断奶日期:" + dt3 + "\n";
				if (!cowInfo.getAblactOperator().equals(""))
					result += "断奶操作员:" + cowInfo.getAblactOperator() + "\n";
				if (!cowInfo.getFatherNO().equals(""))
					result += "父号:" + cowInfo.getFatherNO() + "\n";
				if (!cowInfo.getMotherNO().equals(""))
					result += "母号:" + cowInfo.getMotherNO() + "\n";

				if (!cowInfo.getMaFatherNO().equals(""))
					result += "外祖父:" + cowInfo.getMaFatherNO() + "\n";
				if (!cowInfo.getMaMotherNO().equals(""))
					result += "外祖母:" + cowInfo.getMaMotherNO() + "\n";

				if (!cowInfo.getVariety().equals(""))
					result += "品种:" + cowInfo.getVariety() + "\n";
				if (!cowInfo.getVarietyPurity().equals(""))
					result += "品种纯度:" + cowInfo.getVarietyPurity() + "\n";

				if (!cowInfo.getColor().equals(""))
					result += "花色:" + cowInfo.getColor() + "\n";
				if (!cowInfo.getGroCode().equals(""))
					result += "泌乳状态:" + cowInfo.getGroCode() + "\n";
				if (!cowInfo.getRepCode().equals(""))
					result += "繁殖状态:" + cowInfo.getRepCode() + "\n";
				dt01 = Services.GetDate(cowInfo.getFbDate());
				if (!dt01.equals("1-1-1"))
					result += "初配日期:" + dt01 + "\n";
				if (cowInfo.isNomateSign()) {
					result += "禁配标识:是\n";
				} else {
					result += "禁配标识:否\n";
				}
				if (!cowInfo.getNomateReason().equals(""))
					result += "禁配原因:" + cowInfo.getNomateReason() + "\n";
				dt01 = Services.GetDate(cowInfo.getNomateDate());
				if (!dt01.equals("1-1-1"))
					result += "禁配时间:" + dt01 + "\n";

				if (!cowInfo.getNomatePerson().equals(""))
					result += "禁配操作人:" + cowInfo.getNomatePerson() + "\n";

				String dt2 = Services.GetDate(cowInfo.getLeftDate());
				if (!dt2.equals("1-1-1"))
					result += "离场日期:" + dt2 + "\n";
				if (!cowInfo.getLeftWhere().equals(""))
					result += "离场去向:" + cowInfo.getLeftWhere() + "\n";
				if (!cowInfo.getLeftReason().equals(""))
					result += "离场原因:" + cowInfo.getLeftReason() + "\n";
				if (!cowInfo.getLeftPerson().equals(""))
					result += "离场操作人:" + cowInfo.getLeftPerson() + "\n";
			} else {
				result = response1.getRtnMessage();

			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug(result);
		return result;

	}

	public static String GetDate(Calendar SourceDate) {
		String result = "";
		int YY = SourceDate.get(Calendar.YEAR);
		int MM = SourceDate.get(Calendar.MONTH) + 1;
		int DD = SourceDate.get(Calendar.DATE);

		result = Integer.toString(YY) + "-" + Integer.toString(MM) + "-"
				+ Integer.toString(DD);
		logger.debug(result);
		return result;

	}

	//这个是获取生产日报日常汇总指
	public static String getDairyProductSummary() {
		String result = "";
		try {

			Connection conn;
			Statement statementL1;
			String SSQL;
			conn = Connect.connect();
			statementL1 = conn.createStatement();
			SSQL = "select [id],convert(varchar,[dt],112) dt,[FARM],[TOTAL],[adult_cow],[Lactating_cow],[protein],[fat],[dry_matter],[germ],[soma],[proportion]"
					+ " from REPORT_Dairy_Product_Summary where dt=convert(varchar,dateadd(day,-1,getdate()),112) order by id";
			logger.debug(SSQL);
			ResultSet rsL1 = statementL1.executeQuery(SSQL);
			String Dt = "";
			while (rsL1.next()) {
				Dt = rsL1.getString("dt") + "日报\n";
				result += "【" + CleanNull(rsL1.getString("FARM")) + "】";
				result += "总:" + CleanNull(rsL1.getString("TOTAL"));
				result += " 成:" + CleanNull(rsL1.getString("adult_cow"));
				result += " 泌:" + CleanNull(rsL1.getString("Lactating_cow"));
				result += " 蛋:" + CleanNull(rsL1.getString("protein"));
				result += " 脂:" + CleanNull(rsL1.getString("fat"));
				result += " 干:" + CleanNull(rsL1.getString("dry_matter"));
				result += " 微:" + CleanNull(rsL1.getString("germ"));
				result += " 体:" + CleanNull(rsL1.getString("soma"));
				result += " 干比:" + CleanNull(rsL1.getString("proportion")) + "%;\n\n";
			}
			result = Dt + result;
			rsL1.close();
			statementL1.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug(result);
		return result;
	}

	public static Boolean getReport(){
		Boolean result = false;
		try {
			WxService service = new WxServiceLocator();
			WxServiceSoap client = service.getWxServiceSoap();
			RtnDataTableResponse response = client.getDairyProductSummary();
			if (response.getRtnCode() != -1) {
				RtnDataTableResponseRtnDataTable tb1 = response
						.getRtnDataTable();
				MessageElement[] messageElement = tb1.get_any();
				for (int i = 0; i < messageElement.length; i++) {
					Iterator iterator = messageElement[i].getChildElements();
					while (iterator.hasNext()) {
						MessageElement m1 = (MessageElement) iterator.next();
						m1 = m1.getRealElement();
						Iterator it = m1.getChildElements();
						int jj = 0;
						while (it.hasNext()) {
							MessageElement m2 = (MessageElement) it.next();
							if (m2.getName().equals("Table")) {
								Iterator it1 = m2.getChildElements();
								int jjj = 0;
								String SSQL = "", SSQL1 = "[id]", SSQL2 = Integer
										.toString(jj + 1);
								String Dt = "", farm = "";
								while (it1.hasNext()) {
									MessageElement m3 = (MessageElement) it1
											.next();

									SSQL1 = SSQL1 + ",";

									SSQL2 = SSQL2 + ",";
									switch (m3.getName()) {
									case "日期":
										SSQL1 += "[dt]";
										Dt =CleanNull( m3.getValue());
										SSQL2 += "'" + Dt + "'";
										break;
									case "牧场":
										SSQL1 += "[FARM]";
										farm = CleanNull(m3.getValue());
										SSQL2 += "'" + farm + "'";
										break;
									case "总产量":
										SSQL1 += "[TOTAL]";
										SSQL2 += CleanNull(m3.getValue());
										break;
									case "成母牛单产":
										SSQL1 += "[adult_cow]";
										SSQL2 +=CleanNull( m3.getValue());
										break;
									case "泌乳牛单产":
										SSQL1 += "[Lactating_cow]";
										SSQL2 += CleanNull(m3.getValue());
										break;
									case "蛋白质":
										SSQL1 += "[protein]";
										//logger.debug("the pro is "+m3.getValue());
										SSQL2 += CleanNull(m3.getValue());
										break;
									case "脂肪":
										SSQL1 += "[fat]";
										SSQL2 +=CleanNull(m3.getValue());
										break;
									case "干物质":
										SSQL1 += "[dry_matter]";
										SSQL2 +=CleanNull( m3.getValue());
										break;
									case "微生物":
										SSQL1 += "[germ]";
										SSQL2 += CleanNull(m3.getValue());
										break;
									case "体细胞":
										SSQL1 += "[soma]";
										SSQL2 += CleanNull(m3.getValue());
										break;
									case "干奶牛比例":
										SSQL1 += "[proportion]";
										SSQL2 += CleanNull(m3.getValue().replace("%", ""));
										break;
									default:
										SSQL1 += "";
										break;

									}
									jjj++;
								}
								//logger.debug("the sql2 is "+SSQL2);
								SSQL = "delete from REPORT_Dairy_Product_Summary where [dt]='"
										+ Dt
										+ "' and [Farm]='"
										+ farm
										+ "' "
										+ "insert into REPORT_Dairy_Product_Summary("
										+ SSQL1 + ")values(" + SSQL2 + ")";
							//	logger.debug(SSQL);
								Connection conn;
								Statement statementL1;
								conn = Connect.connect();
								statementL1 = conn.createStatement();
							   statementL1.execute(SSQL);
								statementL1.close();
								conn.close();
								jj++;
							}

						}
					}
				}
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.debug(result);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Services.SendDairyProductSummary("2");
	//	Services.getReport();
		//推送每日日报  ,默认为@all
		//getDairyProductSummary();
		Services.SendDairyProductSummary("");
	}
 
	public static String CleanNull(String str)
	{
		return str!=null?str:" ";

		
	}
	//解除绑定
 	public static Boolean UnBindUser(String OpenID) {
		Boolean result = false;
		try {
			Connection conn;
			Statement statementL1;
			String SSQL;
			conn = Connect.connect();
			statementL1 = conn.createStatement();
			SSQL = "delete from T_SYS_BIND_USERS WHERE OPENID='" + OpenID + "'";
			logger.debug(SSQL);
			statementL1.execute(SSQL);
			result = true;

			statementL1.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return result;
	}

	public static Boolean UnBindUser(String OpenID, String LoginName,
			String Password) {
		Boolean result = false;
		
		
		try {

			Connection conn;
			Statement statementL1;
			String SSQL;
			conn = Connect.connect();
			statementL1 = conn.createStatement();
			SSQL = "select count(*) cnt from T_SYS_BIND_USERS WHERE OPENID='"
					+ OpenID + "' and LoginName='" + LoginName+"'";
				//	+ "' and Password='" + Password + "'";
			logger.debug(SSQL);
			ResultSet rsL1 = statementL1.executeQuery(SSQL);
			if (rsL1.next()) {
				int cnt = rsL1.getInt("cnt");
				rsL1.close();
				if (cnt > 0) {

					SSQL = "delete from T_SYS_BIND_USERS WHERE OPENID='"
							+ OpenID + "' and LoginName='" + LoginName+"'";
							//+ "' and Password='" + Password + "'";
					logger.debug(SSQL);
					statementL1.execute(SSQL);
					result = true;

				}

			}
			statementL1.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return result;
	}
	
	
	public static String FormateDate(String str)
	{
		if(str=="")
		{
			return str;
		}else{
			return str.substring(0, 10);
		}
	}
 
}
