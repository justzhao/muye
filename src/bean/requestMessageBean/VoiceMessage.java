package bean.requestMessageBean;

public class VoiceMessage extends Base {
	private String MediaId;
	private String Format;
	
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	
}
