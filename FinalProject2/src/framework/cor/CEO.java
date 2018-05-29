package framework.cor;

public class CEO extends Complain {

    
    public CEO(int level){
        this.level=level;
    }

	@Override
	protected void reported(String message) {
		// TODO Auto-generated method stub
		System.out.println("The complaint is handled by the CEO");
	}
        

}
