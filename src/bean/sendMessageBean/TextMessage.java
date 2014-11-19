package bean.sendMessageBean;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;

import net.sf.json.JSONObject;
import cn.modernfarming.weixin.Services;

public class TextMessage extends SendMessageBase {
	private Text text;
	
	public Text gettext() {
		return text;
	}

	public void settext(Text _content) {
		text = _content;
	}
	public void settext(String _content) {
		text = new Text();
		text.setcontent(_content);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextMessage a=new TextMessage();
		a.settext("asdfasdf");
		String s= JSONObject.fromObject(a).toString();
		System.out.println(s);
		

	}

}
