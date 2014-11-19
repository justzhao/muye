package listener;

import java.util.Timer;//定时器类


import bean.taskBean.ExportHistoryBean_qy;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import message.check;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SysContextListener_qy implements ServletContextListener {
	private static Logger logger = LogManager.getLogger(SysContextListener_qy.class.getName());
	private Timer timer = null;

	public void contextInitialized(ServletContextEvent event) {
		// 在这里初始化监听器，在tomcat启动的时候监听器启动，可以在这里实现定时器功能



		timer = new Timer(true);
		logger.debug("定时器已启动");// 添加日志，可在tomcat日志中查看到
		timer.schedule(new ExportHistoryBean_qy(event.getServletContext()), 0,10 * 1000);// 调用exportHistoryBean，0表示任务无延迟，5*1000表示每隔5秒执行任务，60*60*1000表示一个小时。
		logger.debug("已经添加任务");



	}

	public void contextDestroyed(ServletContextEvent event) {// 在这里关闭监听器，所以在这里销毁定时器。
	  timer.cancel();

	//	logger.debug("定时器销毁");
	}
}
