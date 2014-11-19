package bean.taskBean;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import message.check;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import util.AccessTokenUtil;
import bean.httpsBean.AccessToken;
import cn.modernfarming.weixin.Services;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import com.menu.manager.BllManager;

public class ExportHistoryBean_qy extends TimerTask {
	private static Logger logger = LogManager.getLogger(ExportHistoryBean_qy.class.getName());
	private static final int C_SCHEDULE_HOUR_BEGIN = BllManager.getSendTime();
  //private static final int C_SCHEDULE_HOUR_BEGIN = 600;// 
	private static final int C_SCHEDULE_HOUR_END = 1200;// 
	private static boolean isRunning = false;
	private ServletContext context = null;

	public ExportHistoryBean_qy(ServletContext context) {
		this.context = context;
	}

	public void run() {
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		
		
		if (!isRunning) {
			try {
				
			//	int curHour=c.get(Calendar.HOUR_OF_DAY)*100 + c.get(Calendar.MINUTE); //乘以100??
				
				int curHour=c.get(Calendar.HOUR_OF_DAY)*60 + c.get(Calendar.MINUTE);
				logger.debug("curHour:"+curHour);				
				logger.debug("C_SCHEDULE_HOUR_BEGIN:"+C_SCHEDULE_HOUR_BEGIN);				
				logger.debug("C_SCHEDULE_HOUR_END:"+C_SCHEDULE_HOUR_END);				
				//int curHour = c.get(Calendar.HOUR_OF_DAY);
				if ((C_SCHEDULE_HOUR_BEGIN <= curHour)
						&& (curHour <= C_SCHEDULE_HOUR_END)) {
					isRunning = true;
					logger.debug("开始执行指定任务");

					Services.getReport();
					//推送每日日报  ,默认为@all
					Services.SendDairyProductSummary("");

					logger.debug("正在执行tomcat定时任务！------------" + "");
					// -------------------结束
					isRunning = false;
					logger.debug("指定任务执行结束");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				logger.error(ex.getMessage());
			}
		} else {
			logger.debug("上一次任务执行还未结束-----" + c.get(Calendar.HOUR_OF_DAY));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
