package OrderProcessing.copy;

public class SellStock implements Order{
	private Stock abcStock;

	   public SellStock(Stock abcStock){
	      this.abcStock = abcStock;
	   }

	   public void execute() {
	      abcStock.sell();
	   }

	@Override
	public void undo() {
		abcStock.cancel();
		
	}
}
