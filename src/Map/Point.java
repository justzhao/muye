package Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Point {
	private static Logger logger = LogManager.getLogger(Point.class.getName());
		public String longitude="";
		public String latitude="";
		
		public Point(String Longitude,String Latitude){
			longitude=Longitude;
			latitude=Latitude;
		
		}

}
