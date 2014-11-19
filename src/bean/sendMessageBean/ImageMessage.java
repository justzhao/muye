package bean.sendMessageBean;

public class ImageMessage extends SendMessageBase {

	/**
	 * @param args
	 */
	
	private Image image;
	public Image getImage() {
		return image;
	}
	public void setImage(String _image) {
		image=new Image();
	   image.setMedia_id(_image);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
