package Visitor.copy;

public class StudentFineCalculator implements Visitor {

	private double totalFine;

	@Override
	public void visit(Book book) {
		if (book.getPeriod() > 3) {

			totalFine += (0.1 * (book.getPeriod() - 3) * 7);

		}

	}

	@Override
	public void visit(Magazin magazin) {
		if (magazin.getPeriod() > 3) {
			// if student

			totalFine += (0.1 * (magazin.getPeriod() - 3) * 7);

		}

	}

	@Override
	public void visit(ResearchPaper paper) {
		if (paper.getPeriod() > 3) {
			// if student

			totalFine += (0.20 * (paper.getPeriod() - 3) * 7);

		}

	}

	public double getTotalFine() {
		if (totalFine > 10) {
			totalFine = 10;
		}
		return totalFine;
	}

}
