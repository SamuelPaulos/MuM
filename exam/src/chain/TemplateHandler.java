package chain;

public abstract class TemplateHandler {
	protected TemplateHandler successor;
	public abstract void handleContent(Content content);
	public abstract boolean canHandleContent(Content content);

}
