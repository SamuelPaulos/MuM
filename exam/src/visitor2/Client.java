package visitor2;

import java.util.Arrays;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		checkOutElement book = new Book(5);
		checkOutElement magazine = new Magazine(17);
		checkOutElement researchPaper = new ResearchPaper(23);
		
		List<checkOutElement> returningItems = Arrays.asList(book, magazine, researchPaper);
		
		MemberVisiter student = new StudentFineCalculatorVisitor();
		MemberVisiter faculty = new FacultyFineCalculatorVisitor();
		
		List<MemberVisiter> members = Arrays.asList(student, faculty);
		
		
		for(MemberVisiter visitor: members) {
			returningItems.forEach(element->element.visit(visitor));
			System.out.printf("%s will pay: $%.2f \n",visitor.getClass().getSimpleName(), visitor.getTotalFine());
		}
	}

}
