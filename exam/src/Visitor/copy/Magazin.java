package Visitor.copy;

public class Magazin implements LibraryItem {
	private int period;
	

	public Magazin(int period) {
		
		this.period =period;
	}

	public int getPeriod() {
		return period;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	
}
