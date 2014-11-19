package util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;







import bean.requestMessageBean.TextMessage;
import bean.responseMessageBean.Article;
import bean.responseMessageBean.ImageTextMessage;
import bean.responseMessageBean.MusicMessage;
import bean.responseMessageBean.S;

import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import service.CoreService;
public class MessageUtil_qy {
	private static Logger logger = LogManager.getLogger(MessageUtil_qy.class.getName());  
	/**
	 * 返回消息类型：文本
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 返回消息类型：音乐
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

	/**
	 * 返回消息类型：图文
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";

	/**
	 * 请求消息类型：文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 请求消息类型：图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 请求消息类型：链接
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/**
	 * 请求消息类型：地理位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

	/**
	 * 请求消息类型：音频
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * 请求消息类型：推送
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * 事件类型：subscribe(关注;以及扫描二维码后的关注)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * 事件类型：unsubscribe(取消关注)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
	/**
	 * 事件类型：unsubscribe(取消关注)
	 */
	public static final String EVENT_TYPE_LOCATION = "LOCATION";

	/**
	 * 事件类型：CLICK(自定义菜单点击事件)
	 */
	public static final String EVENT_TYPE_CLICK = "click";

	/**
	 * 事件类型：SCAN(扫描二维码后如果已关注，带场景值扫描事件)
	 */
	public static final String EVENT_TYPE_SCAN = "scan";

	/**
	 * 解析微信发来的请求（XML）
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> parseXml(HttpServletRequest request,String msg_signature,String  timestamp,String  nonce)
		{

		// 将解析结果存储在HashMap中
		Map<String, String> map = new HashMap<String, String>();
		try{
		// 从request中取得输入流
		InputStream inputStream = request.getInputStream();
		
		
		// 读取输入流
		SAXReader reader = new SAXReader();
		
		Document document = reader.read(inputStream);
	
		
		WXBizMsgCrypt c=new WXBizMsgCrypt(AccessTokenUtil_qy.sToken,
				AccessTokenUtil_qy.sEncodingAESKey,AccessTokenUtil_qy.sCorpID);
		logger.debug("---------------");
		/**
		org.dom4j.Element root = document.getRootElement();
		// 得到根元素的所有子节点
		List<Element> elementList = root.elements();

		// 遍历所有子节点
		for (Element e : elementList)
			map.put(e.getName(), e.getText());

		// 释放资源
		inputStream.close();
		inputStream = null;
		
		*/
		
		
		//这里是解密 ,本地测试暂时不用解密 ，先注释掉
		
	
		//q签名认证错误
		String s=c.DecryptMsg(msg_signature, timestamp, nonce,document.asXML());
		logger.debug(s);
		logger.debug("---------------");
		// 得到xml根元素  这是解析XML吧

		SAXReader saxReader = new SAXReader();
		
		byte[] bytes = s.getBytes();
		
		InputStream in = new ByteArrayInputStream(bytes);
		//BufferedReader br= new BufferedReader(new InputStreamReader(in,"utf-8"));
		InputStreamReader strInStream = new InputStreamReader(in, "gb2312");
		
		//document.setXMLEncoding("UTF-8");
		document = saxReader.read(strInStream); 
		
      // document.setXMLEncoding("UTF-8");
		
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		List<Element> elementList = root.elements();

		// 遍历所有子节点
		for (Element e : elementList) {
			map.put(e.getName(), e.getText());
			logger.debug(e.getName()+","+e.getText());			
		}

		// 释放资源
		inputStream.close();
		inputStream = null;
		
		
		}catch(Exception ex){
			logger.error(ex.getMessage());
			ex.printStackTrace();
			
		}
		
		
		return map;
	}

	/**
	 * 文本消息对象转换成xml
	 * 
	 * @param textMessage
	 *            文本消息对象
	 * @return xml
	 */
	public static String textMessageToXml(TextMessage textMessage) {
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}

	/**
	 * 音乐消息对象、图片消息对象、语音消息对象、视频消息对象 转换成xml
	 * 
	 * @param <T>
	 *            对象类型
	 * @return xml
	 */
	public static <T> String toXMl(S<T> s) {
		xstream.alias("xml", s.getClass());
		String name = s.getT().getClass().getSimpleName();
		xstream.aliasField(name, s.getClass(), "t");
		return xstream.toXML(s);
	}

	/**
	 * 音乐消息对象转换成xml
	 * 
	 * @param <T>
	 * 
	 * @param musicMessage
	 *            音乐消息对象
	 * @return xml
	 */

	public static String musicMessageToXml(MusicMessage musicMessage) {
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}

	/**
	 * 图文消息对象转换成xml
	 * 
	 * @param newsMessage
	 *            图文消息对象
	 * @return xml
	 */
	public static String newsMessageToXml(ImageTextMessage newsMessage) {
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessage);
	}

	/**
	 * 扩展xstream，使其支持CDATA块
	 * 
	 * @date 2013-05-19
	 */
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@SuppressWarnings("rawtypes")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
}
