package bean.sendMessageBean;

import java.util.ArrayList;



public class SendMessageBase {
	private String touser;
	private String toparty;
	private String totag;
	private String msgtype;
	private String agentid;
	private String safe;
	 
	
	
	
	public String gettouser(){
		return touser;
	}
	public String gettoparty(){
		return toparty;
	}
	public String gettotag(){
		return totag;
	}
	public String getagentid(){
		return agentid;
	}
	public void settouser(String ToUser){
		touser=ToUser;
	}
	public void settoparty(String ToParty){
		toparty=ToParty;
	}
	public void settotag(String ToTag){
		totag=ToTag;
	}

	public String getmsgtype(){
		return msgtype;
	}
	public String getsafe(){
		return safe;
	}
	public void setmsgtype(String MsgType){
		msgtype=MsgType;
	}
	public void setsafe(String Safe){
		safe=Safe;
	}
	public void setagentid(String AgentID){
		agentid=AgentID;
	}
}
