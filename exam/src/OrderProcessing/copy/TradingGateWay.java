package OrderProcessing.copy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TradingGateWay {
	private Stack<Order> executedOrder = new Stack<Order>();
	private List<Order> orderList = new ArrayList<Order>();

	public void takeOrder(Order order) {
		orderList.add(order);
	}

	public void placeOrders() {

		for (Order order : orderList) {
			order.execute();
			executedOrder.push(order);
		}
		orderList.clear();
	}

	public void cancelOrder() {
		while (!executedOrder.isEmpty()) {
			executedOrder.pop().undo();
		}
	}
}
