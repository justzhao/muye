package bean.ticketBean;


public class TempTicket {
	private String expire_seconds;
	private String action_name;
	private Scene action_info;
	
	public String getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(String expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	public Scene getAction_info() {
		return action_info;
	}
	public void setAction_info(Scene action_info) {
		this.action_info = action_info;
	}
}
