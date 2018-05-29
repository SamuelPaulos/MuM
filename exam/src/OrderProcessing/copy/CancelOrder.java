package OrderProcessing.copy;

//import orderprocessing.Order;

public class CancelOrder implements Order {
	private Stock abcStock;

	public Stock getAbcStock() {
		return abcStock;
	}

	public void setAbcStock(Stock abcStock) {
		this.abcStock = abcStock;
	}

	public CancelOrder(Stock abcStock) {
		this.abcStock = abcStock;
	}

	@Override
	public void execute() {
		abcStock.cancel();

	}

	@Override
	public void undo() {
		abcStock.buy();

	}

}
