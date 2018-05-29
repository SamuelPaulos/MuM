package OrderProcessing.copy;


//create a command interface
public interface Order {
	public void execute();
	public  void undo();

}
