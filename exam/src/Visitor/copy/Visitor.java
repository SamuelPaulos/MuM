package Visitor.copy;

public interface Visitor {
	public void visit(Book book);
	public void visit(Magazin magazin);
	public void visit(ResearchPaper paper);

}
