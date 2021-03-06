package visitor2;

public class StudentFineCalculatorVisitor implements MemberVisiter {
	private double totalFine = 0.0;

	@Override
	public void visit(Book book) {
		totalFine += (book.getNumberOfPastDueDays() * 0.10);
	}

	@Override
	public void visit(Magazine magazine) {
		totalFine += (magazine.getNumberOfPastDueDays() * 0.10);

	}

	@Override
	public void visit(ResearchPaper researchPaper) {
		totalFine += (researchPaper.getNumberOfPastDueDays() * 0.20);

	}

	public double getTotalFine() {
		if (totalFine > 10.00) {
			totalFine = 10.00;
		}
		return totalFine;
	}

}
