package bean.manageBean;

public class UpdateMembers {
	private String openid;
	private int to_groupid;
	public String getopenid(){
		return openid;
	}
	public void setopenid(String OpenID){
		openid=OpenID;
	}
	public int getto_groupid(){
		return to_groupid;
	}
	public void setto_groupid(int To_Groupid){
		to_groupid=To_Groupid;
	}
}
