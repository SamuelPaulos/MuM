package Visitor.copy;

public class Client {
	public static void main(String[] args) {
		LibraryItem[] items = new LibraryItem[] { new Book(50), new Magazin(4), new ResearchPaper(4) };
		calculateFine(items);
	}

	private static void calculateFine(LibraryItem[] elements) {
		StudentFineCalculator calculator = new StudentFineCalculator();
		FacultyFineCalculator faculty = new FacultyFineCalculator();

		for (LibraryItem item : elements) {
			item.accept(faculty);
			item.accept(calculator);
		}
		System.out.println("Student " + calculator.getTotalFine() + "Faculty " + faculty.getTotalFine());

	}

}
