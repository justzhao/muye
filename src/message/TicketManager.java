package message;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import service.CoreService;
import util.AccessTokenUtil;
import util.AccessTokenUtil_qy;
import bean.httpsBean.AccessToken;
import bean.ticketBean.Scene;
import bean.ticketBean.SceneId;
import bean.ticketBean.TempTicket;
import bean.ticketBean.Ticket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TicketManager {
	private static Logger logger = LogManager.getLogger(TicketManager.class.getName());  

	// 二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久
	public static final String QR_SCENE = "QR_SCENE";
	public static final String QR_LIMIT_SCENE = "QR_LIMIT_SCENE";



	public static void main(String[] args) {

		try {
			AccessToken aToken = AccessTokenUtil.getAccessToken(AccessTokenUtil_qy.AppId,
					AccessTokenUtil_qy.AppSecret);
			if (null != aToken) {
				String result = AccessTokenUtil.createTempTicket(
						getTempTicket(), aToken.getAccessToken());
				logger.debug(result);
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

	}

	public static String getTicketCode() {
		String result = null;

		try {
			AccessToken aToken = AccessTokenUtil.getAccessToken(AccessTokenUtil_qy.AppId,
					AccessTokenUtil_qy.AppSecret);
			if (null != aToken) {
				result = AccessTokenUtil.createTempTicket(getTempTicket(),
						aToken.getAccessToken());
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
		return result;
	}

	private static TempTicket getTempTicket() {
		SceneId sceneId = new SceneId();
		sceneId.setScene_id("998");

		Scene scene = new Scene();
		scene.setScene(sceneId);

		TempTicket tt = new TempTicket();
		tt.setExpire_seconds("1800");
		tt.setAction_name(QR_SCENE);
		tt.setAction_info(scene);

		return tt;
	}

	private static Ticket getTicket() {
		SceneId sceneId = new SceneId();
		sceneId.setScene_id("999");

		Scene scene = new Scene();
		scene.setScene(sceneId);

		Ticket t = new Ticket();
		t.setAction_name(QR_LIMIT_SCENE);
		t.setAction_info(scene);

		return t;
	}
}
