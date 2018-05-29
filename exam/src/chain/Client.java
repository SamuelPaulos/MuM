package chain;

public class Client {
	static ChainBuilder chain = new ChainBuilder();
	public static void main(String args[]) {
		// Create Content or request
		Content sing = new Content("single");
		Content arc = new Content("archive");
		Content cat = new Content("catagory");
		Content img = new Content("image");

		ChainBuilder chain = new ChainBuilder();
		chain.getHandler().handleContent(img);
		chain.getHandler().handleContent(cat);
		sendRequest(arc);

	}
	
	public static void sendRequest(Content content){
		chain.getHandler().handleContent(content);
	}
}
