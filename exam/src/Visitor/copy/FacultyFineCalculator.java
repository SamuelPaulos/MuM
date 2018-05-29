package Visitor.copy;

public class FacultyFineCalculator implements Visitor {

	private double totalFine;
	

	@Override
	public void visit(Book book) {
		if (book.getPeriod() > 3) {

			// if teacher
			
				totalFine += (0.1 * (book.getPeriod() - 3) * 7);
			
		}

	}

	@Override
	public void visit(Magazin magazin) {
		if (magazin.getPeriod() > 3) {

			// if teacher
			
				totalFine += (0.05 * (magazin.getPeriod() - 3) * 7);
			
		}

	}

	@Override
	public void visit(ResearchPaper paper) {
		if (paper.getPeriod() > 3) {
			// if teacher
			
				totalFine += (0.0 * (paper.getPeriod() - 3) * 7);
			
		}

	}

	public double getTotalFine() {
		if (totalFine > 5) {
			totalFine = 5;
		}
		return totalFine;
	}

}
