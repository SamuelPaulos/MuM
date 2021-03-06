package chain;

public class CatagoryTemplate extends TemplateHandler {

	@Override
	public void handleContent(Content content) {
		if (canHandleContent(content)) {
			System.out.println(content.getContentType());
			return;
		} else {
			if (successor != null) {
				successor.handleContent(content);
			}
		}

	}

	@Override
	public boolean canHandleContent(Content content) {

		return content.getContentType().equals("catagory");
	}

}
