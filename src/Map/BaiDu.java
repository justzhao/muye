package Map;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject; 

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaiDu {
	private static Logger logger = LogManager.getLogger(BaiDu.class.getName());  
	


	public Point TransPoint(String longitude,String latitude)
	{

		Point result=new Point(longitude,latitude);
		try{
			String url="http://api.map.baidu.com/geoconv/v1/?coords="+longitude+","+latitude+"&from=1&to=5&ak=WY0LNZXMqTGG5dCw8TE1cp3o";
	    	logger.debug(url);
	    	CloseableHttpClient httpclient = HttpClients.createDefault();
			try {

		    	   HttpGet httpGet = new HttpGet(url);

		    	   ResponseHandler<String> responseHandler = new ResponseHandler<String>(){
		    		   public String handleResponse(final HttpResponse response) throws ClientProtocolException,IOException{
		    			   int status = response.getStatusLine().getStatusCode();
		    			   if (status >= 200 && status < 300){
		    				   HttpEntity entity = response.getEntity();
		    				   return entity !=null ? EntityUtils.toString(entity) : null;
		    			   }else{
		    				   throw new ClientProtocolException("Unexpected response status: " + status);
		    			   }
		    		   }
		    	   };	       
	       
		    	   String strResult = httpclient.execute(httpGet,responseHandler);
		    	   logger.debug(strResult);
		    	   JSONObject json=JSONObject.fromObject(strResult) ;
		    	   String status=json.getString("status");
		    	   if(status.equals("0")){
		    		   JSONObject rslt=JSONObject.fromObject(json.getJSONArray("result").get(0));
		    		   result.longitude=rslt.getString("x");
		    		   result.latitude=rslt.getString("y");
		    	   }

	             
	       } finally {
	    	   httpclient.close();
	       }
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error(ex.getMessage());
		}
		return result;
		
	}
	public static void main(String[] args) throws ParseException, IOException {
		// TODO Auto-generated method stub
		BaiDu baiDu=new BaiDu();
		Point pt=baiDu.TransPoint("104.0546420000","30.5908240000");

	}

}
