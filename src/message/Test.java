package message;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import service.CoreService;
import util.SignUtil;

public class Test  extends HttpServlet {

			/**
			 * 
			 */
			private static Logger logger = LogManager.getLogger(Test.class.getName());  
			private static final long serialVersionUID = -9100295051301568748L;

			/**
			 * Constructor of the object.
			 */
			// Logger logger=LogManager.getLogger(check.class.getClass());
			public Test() {
				super();
			}

			/**
			 * Destruction of the servlet. <br>
			 */
			public void destroy() {
				super.destroy(); // Just puts "destroy" string in log
				// Put your code here
			}


			public void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.print("asdfasdfsadf");

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

				PrintWriter out = response.getWriter();
				out.print("1111111111111111111111111111111111111111");
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
