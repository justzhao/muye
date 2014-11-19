package bean.tagBean;

import bean.ticketBean.Scene;

public class Tag {

	public Tag() {
		// TODO Auto-generated constructor stub
	}
	
	private String tagid;
	private String tagname;
	
	private String []userlist;
	public String getTagid() {
		return tagid;
	}
	public void setTagid(String tagid) {
		this.tagid = tagid;
	}
	
	public String getTagname() {
		return tagname;
	}
	public void setTagname(String tagname) {
		this.tagname = tagname;
	}
	public String[] getUserlist() {
		return userlist;
	}
	public void setUserlist(String[] userlist) {
		this.userlist = userlist;
	}

}
