package OrderProcessing.copy;

public class Cleint {

	public static void main(String[] args) {
		Stock abcStock = new Stock();
		

	      BuyStock buyStockOrder = new BuyStock(abcStock);
	      SellStock sellStockOrder = new SellStock(abcStock);

	      TradingGateWay broker = new TradingGateWay();
	      
	      broker.takeOrder(buyStockOrder);

	      broker.takeOrder(buyStockOrder);
	      broker.takeOrder(sellStockOrder);

	      broker.placeOrders();
	      broker.cancelOrder();

	}

}
