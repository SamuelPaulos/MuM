package OrderProcessing.copy;

//Create concrete classes implementing the Order interface.
//BuyStock.java

public class BuyStock implements Order {

	private Stock abcStock;

	public BuyStock(Stock abcStock) {
		this.abcStock = abcStock;
	}

	public void execute() {
		abcStock.buy();
	}

	@Override
	public void undo() {
		abcStock.cancel();
	}

}
