package Visitor.copy;

public class Book implements LibraryItem {
	private int period;
	
	
	public Book(int period){
		
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
