package chain;

public class Content {
	private String contentType;//image, post , category , archive , frame

	public Content(String contentType) {
		this.contentType = contentType;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	

}
