package message;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import service.CoreService_qy;
import util.AccessTokenUtil_qy;

import com.qq.weixin.mp.aes.WXBizMsgCrypt;

public class checkHigh_qy extends HttpServlet {
	private static Logger logger = LogManager.getLogger(check.class.getName());  

	public checkHigh_qy() {
		// TODO Auto-generated constructor stub
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		//从get中 获取签名  这个是验证url做的

		String msg_signature = request.getParameter("msg_signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		logger.debug("msg_signature:"+msg_signature);
		logger.debug("timestamp:"+timestamp);
		logger.debug("nonce:"+nonce);
		logger.debug("echostr:"+echostr);
     //https://git.duapp.com/appide3cee19dpa
		try{
		WXBizMsgCrypt c=new WXBizMsgCrypt(AccessTokenUtil_qy.sToken,
				AccessTokenUtil_qy.sEncodingAESKey,AccessTokenUtil_qy.sCorpID);
		String s=c.VerifyURL(msg_signature, timestamp, nonce,echostr);
		logger.debug("-------------"+s);
		out.println(s);
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage());			
		}
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.debug("++++++++++++++++++++++++++++++++++++++++++++++++");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//coreService 是核心业务逻辑类s
		CoreService_qy CS=new CoreService_qy();
		String msg_signature,timestamp,nonce;
		//消息签名
		msg_signature=request.getParameter("msg_signature");
		timestamp=request.getParameter("timestamp");
		nonce=request.getParameter("nonce");

		
		logger.debug("msg_signature:"+request.getParameter("msg_signature"));
		logger.debug("timestamp:"+request.getParameter("timestamp"));
		logger.debug("nonce:"+request.getParameter("nonce"));
          //这是消息回复
		String respMessage = null;
		try {
			respMessage = CS.processHightRequest(request,msg_signature,timestamp,nonce);
		} catch (KeyManagementException | NoSuchAlgorithmException
				| NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//respMessage 因该是要加过密的Xml
		respMessage=(respMessage!=null ? respMessage:"");
		logger.debug(respMessage);
		// 响应消息
		PrintWriter out = response.getWriter();
		out.print(respMessage);
		out.flush();
		out.close();
		logger.debug("++++++++++++++++++++++++++++++++++++++++++++++++");

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */

	public void init() throws ServletException {
		// Put your code here

		// PropertyConfigurator.configure("../webapps/weixin/WEB-INF/classes/log4j.properties");
	}
}
