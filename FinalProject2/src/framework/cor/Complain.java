package framework.cor;

public abstract class Complain {
	
	public static int  servicereport=1;
	public static int   moneyfrud=2;
        public static int others=3;
	
	
	protected int level;
	
	
	//next element in chain or responsibility
	   protected Complain nextBoss;
	   
	   public void setNextLogger(Complain boss){
		      this.nextBoss = boss;
		   }
	   
	   public void companyChain(int level, String message){
		      if(this.level == level){
		         reported(message);
		      }
		      if(nextBoss !=null){
		    	  nextBoss.companyChain(level, message);
		      }
		   }
	   
	   abstract protected void reported(String message)	;
}
