package OrderProcessing.copy;

public class Stock {
	private String symbol = "ABC";
	private int quantity = 10;
	private int price = 200;

	public void buy(){
	      System.out.println("Stock [ Symbol: "+symbol+", Quantity: " + quantity +", Price: "+price+ " + ] bought");
	   }

	public void sell(){
	      System.out.println("Stock [ Symbol: "+symbol+", Quantity: " + quantity +", Price: "+price+ " +  ] sold");
	   }
	
	public void cancel(){
		System.out.println("Stock [ Symbol: "+symbol+", Quantity: " + quantity +" , Price: "+price+ " + ] canceled");
	}
}
