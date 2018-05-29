package framework.cor;

public class Superviser extends Complain{

	
	public Superviser(int level){
		this.level=level;
	}
	
	@Override
	protected void reported(String message) {
		// TODO Auto-generated method stub
		System.out.println("The complaint is handled by the Supervior");
	}

}
