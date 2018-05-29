package visitor2;

public interface MemberVisiter {

	void visit(Book book);

	void visit(Magazine magazine);

	void visit(ResearchPaper researchPaper);
	
	double getTotalFine();

}
