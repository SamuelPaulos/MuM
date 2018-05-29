package framework.cor;

public class CompliantRecevier {
	
	
	
	
	public static Complain getBosses(){
		
		
		Complain superviser=new Superviser(Complain.servicereport);
		Complain manager=new Manager(Complain.moneyfrud);
		Complain ceo=new CEO(Complain.others);
		
		
		superviser.setNextLogger(manager);
		manager.setNextLogger(ceo);
		
		return superviser;
	}
	

}
