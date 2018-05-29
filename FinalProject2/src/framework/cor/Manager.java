package framework.cor;

public class Manager extends Complain {

	public Manager(int level){
		
		this.level=level;
	}
	
	
	@Override
	protected void reported(String message) {
		// TODO Auto-generated method stub
		System.out.println("The complaint is handled by the Manager");
	}

}
