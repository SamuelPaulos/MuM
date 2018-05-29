package Visitor.copy;

public class ResearchPaper implements LibraryItem {

	private int period;;

	public ResearchPaper(int period) {
		this.period = period;
	}

	public int getPeriod() {
		return period;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
