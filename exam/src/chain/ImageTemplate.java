package chain;

public class ImageTemplate extends TemplateHandler {

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
		// TODO Auto-generated method stub
		return content.getContentType().equals("image");
	}

}
