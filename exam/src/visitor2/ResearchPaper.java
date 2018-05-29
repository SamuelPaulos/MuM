package visitor2;

public class ResearchPaper implements checkOutElement {

	private int numberOfPastDueDays;

	public ResearchPaper(int numberOfPastDueDays) {
		this.setNumberOfPastDueDays(numberOfPastDueDays);
	}

	@Override
	public void visit(MemberVisiter visiter) {
		visiter.visit(this);
	}

	public int getNumberOfPastDueDays() {
		return numberOfPastDueDays;
	}

	public void setNumberOfPastDueDays(int numberOfPastDueDays) {
		this.numberOfPastDueDays = numberOfPastDueDays;
	}

}
